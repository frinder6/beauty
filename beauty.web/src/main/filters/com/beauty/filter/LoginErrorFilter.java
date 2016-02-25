package com.beauty.filter;

import com.beauty.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by frinder_liu on 2016/2/24.
 */
public class LoginErrorFilter implements Filter {

    private final Logger logger = Logger.getLogger(getClass());

    public static final Map<String, Object> _ERRORS = new HashMap<String, Object>() {
        /**
         * @Fields serialVersionUID
         */
        private static final long serialVersionUID = 1L;

        {
            put("BadCredentialsException", "密码错误！");
            put("UsernameNotFoundException", "用户名不存在！");
            put("LockedException", "帐户被锁！");
            put("DisabledException", "帐户未启动！");
            put("CredentialExpiredException", "密码过期！");
        }
    };


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        if (null != obj) {
            AuthenticationException exception = (AuthenticationException) obj;
            logger.error(exception);
            String error = exception.getMessage();
            logger.error(error);
            if (_ERRORS.containsKey(error)) {
                session.setAttribute("error", _ERRORS.get(error));
            } else {
                session.setAttribute("error", error);
            }
        } else {
            session.setAttribute("error", "");
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    /**
     * 登陆失败提示信息
     */
    protected void error(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        if (null != obj) {
            String excp = StringUtil.getValue4Map(_ERRORS, obj.toString());
            if (null != excp) {
                session.setAttribute("error", excp);
            } else {
                AuthenticationException exception = (AuthenticationException) obj;
                String error = exception.getMessage();
                session.setAttribute("error", error);
            }
        } else {
            session.setAttribute("error", "");
        }
    }



    public void destroy() {
    }


}
