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

import com.alibaba.fastjson.JSON;
import com.beauty.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        req.getSession().setAttribute("IP", HttpUtil.getIpAddress(req));
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {

    }


    /**
     * 设置登陆用户
     *
     * @param req
     */
    protected void setLoginUser(HttpServletRequest req) {
        UserInfo user = (UserInfo) req.getSession().getAttribute("CURRENT_USER");
        if (user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (null != authentication) {
                Object obj = authentication.getPrincipal();
                if (obj instanceof UserDetails) {
                    user = (UserInfo) obj;
                    req.getSession().setAttribute("CURRENT_USER", user);
                    req.getSession().setAttribute("CURRENT_USER_ACCOUNT", user.getUser().getAccount());
                    logger.info("current login user is : [" + user.toString() + "]");
                }
            }
        }
    }


}
