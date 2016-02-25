package com.beauty.filter;

import com.beauty.entity.BeautyUrl;
import com.beauty.service.UrlService;
import com.beauty.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * Created by frinder_liu on 2016/2/24.
 */
public class UrlFilter implements Filter {

    private final Logger logger = Logger.getLogger(getClass());

    /**
     * 保存不需要过滤的路径
      */
    private static final List<String> _OFF_URLS = new ArrayList<String>();

    private UrlService urlService;


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
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
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        String param = config.getInitParameter("offParams");
        String[] params = param.split(",");
        List<String> list = Arrays.asList(params);
        _OFF_URLS.addAll(list);
        if (null == urlService) {
            ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
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
        for (String param : _OFF_URLS) {
            if (url.indexOf(param) > -1) {
                return true;
            }
        }
        return false;
    }

    public void destroy() {
    }

}
