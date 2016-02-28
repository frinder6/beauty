package com.beauty.handler;

import com.beauty.entity.BeautyMessage;
import com.beauty.util.DwrUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Created by frinder_liu on 2016/2/25.
 */
@Component
public class MessageHandler implements Handler {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void handleMessage(Object message) {
        try {
            BeautyMessage beautyMessage = (BeautyMessage) message;
            DwrUtil.sendMessage(beautyMessage.getAccount(), message);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


}
