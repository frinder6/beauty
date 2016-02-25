package com.beauty.handler;

import com.beauty.util.DwrUtil;
import com.beauty.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by frinder_liu on 2016/2/25.
 */
@Component
public class MessageHandler {

    @Autowired
    private HttpSession session;

    public void handleMessage(Object message){
        String userId = StringUtil.valueOf(session.getAttribute("CURRENT_USER_ACCOUNT"));
        DwrUtil.sendMessage(userId, message);
    }

}
