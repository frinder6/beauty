package com.beauty.util;

import org.apache.log4j.Logger;

/**
 * Created by frinder_liu on 2016/2/29.
 */
public class LoggerUtil {

    /**
     *
     * @param logger
     * @param type
     * @param flag
     */
    public static void logger(Logger logger, String method, int type, boolean flag){
        String logStr = method.concat(".....................%s!");
        String endStr = flag ? "begin" : "error";
        if (type == 1){
            logger.info(String.format(logStr, endStr));
        }
    }

}
