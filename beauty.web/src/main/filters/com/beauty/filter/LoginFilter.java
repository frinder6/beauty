package com.beauty.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.beauty.entity.BeautyUrl;
import com.beauty.security.UserInfo;
import com.beauty.service.UrlService;
import com.beauty.util.StringUtil;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	private final Logger logger = Logger.getLogger(getClass());

	//
	private UrlService urlService;

	// 保存不需要过滤的路径
	private List<String> offParams = new ArrayList<String>();

	public static final Map<String, String> errors = new HashMap<String, String>() {
		/**
		 * @Fields serialVersionUID
		 */
		private static final long serialVersionUID = 1L;

		{
			put("Bad credentials", "密码错误！");
		}
	};

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		setLoginUser(req);
		// 项目根路径
		String base = StringUtil.getRequestPrefix(req);
		int len = base.length();
		String url = String.valueOf(req.getRequestURL());
		logger.info("request url : [" + url + "]");
		try {
			if (!isInclude(url)) {
				if (url.length() > len) {
					url = url.substring(len);
				}
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("url", url);
				int result = urlService.selectCount(params);
				if (result <= 0) {
					urlService.insertSelective(new BeautyUrl(url, url));
				}
			}
		} catch (Exception e) {
			logger.error("LoginFilter doFilter : [write url error!] ".concat(e.getMessage()));
		}
		//
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		if (null != obj) {
			AuthenticationException exception = (AuthenticationException) obj;
			String error = exception.getMessage();
			if (errors.containsKey(error)) {
				session.setAttribute("error", errors.get(error));
			} else {
				session.setAttribute("error", error);
			}
		} else {
			session.setAttribute("error", "");
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String param = fConfig.getInitParameter("offParams");
		String[] params = param.split(",");
		List<String> list = Arrays.asList(params);
		offParams.addAll(list);
		if (null == urlService) {
			//
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(fConfig.getServletContext());
			urlService = (UrlService) context.getBean("urlService");
		}

	}

	/**
	 * 
	 * @Title: isInclude
	 * @Description: TODO(是否为不需要过滤的url)
	 * @author frinder_liu
	 * @param url
	 * @return
	 * @return boolean
	 * @date 2015年2月13日 下午5:27:37
	 * @throws
	 */
	protected boolean isInclude(String url) {
		for (String param : offParams) {
			if (url.indexOf(param) > -1) {
				return true;
			}
		}
		return false;
	}

	//
	protected void setLoginUser(HttpServletRequest req) {
		UserInfo user = (UserInfo) req.getSession().getAttribute("CURRENT_USER");
		if (user == null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (null != authentication) {
				user = (UserInfo) authentication.getPrincipal();
				req.getSession().setAttribute("CURRENT_USER", user);
			}
		}
	}

}
