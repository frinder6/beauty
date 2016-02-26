package com.beauty.handler;

import com.beauty.util.DwrUtil;
import com.beauty.util.SpringUtil;
import com.beauty.util.StringUtil;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by frinder_liu on 2016/2/25.
 */
public class MessageHandler {

    public void handleMessage(Object message){
        String userId = "admin";
        DwrUtil.sendMessage(userId, message);
    }


}
