/**
 * @Title: LogHandler.java
 * @Package com.mvc.aop
 * @Description: TODO(用一句话描述该文件做什么)
 * @author frinder_liu
 * @date 2015年1月29日 上午12:03:38 
 * @version V1.0
 */
package com.beauty.aop;

import com.alibaba.fastjson.JSON;
import com.beauty.entity.BeautyHandlerLogs;
import com.beauty.service.LogService;
import com.beauty.util.StringUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author frinder_liu
 * @ClassName: LogHandler
 * @Description: TODO(记录url)
 * @date 2015年9月5日 下午8:57:34
 */
@Component
@Aspect
public class LogHandler {

    private final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private HttpSession session;


    @Resource(name = "logDirectTemplate")
    private RabbitTemplate logDirectTemplate;

    @Autowired
    private LogService logService;


    /**
     *
     */
    public LogHandler() {
    }

    @Pointcut("execution(* com.beauty..*.*(..)) && !execution(* com.beauty.mapper..*.*(..))")
    public void allPointCut() {
    }


    @Pointcut("execution(* com.beauty.controller..*.*(..))")
    public void controllerPointCut() {
    }


    /**
     * print all log
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("allPointCut()")
    public Object logger(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        logger.info("before processing at : [" + beginTime + "]");
        try {
            logger.info("ip : " + session.getAttribute("IP"));
            logger.info("account : " + session.getAttribute("CURRENT_USER_ACCOUNT"));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        try {
            logger.info("ProceedingJoinPoint : " + JSON.toJSONString(point));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.info("class : " + point.getTarget().getClass().getName());
        logger.info("method : " + point.getSignature().getName());
        Object retValue = point.proceed();
        try {
            logger.info("retValue : " + JSON.toJSONString(retValue));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        long endTime = System.currentTimeMillis();
        logger.info("after processing at : [" + endTime + "]");
        logger.info("the process cast : [" + (endTime - beginTime) + "] millisecond!");
        return retValue;
    }


    /**
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("controllerPointCut()")
    public Object loggerDB(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object retValue = point.proceed();
        long endTime = System.currentTimeMillis();
        BeautyHandlerLogs log = convert2Log(point, retValue, beginTime, endTime);
        try {
            this.logDirectTemplate.convertAndSend(log);
        } catch (AmqpException e) {
            logger.error(e.getMessage());
        }
        return retValue;
    }


    /**
     * @param point
     * @param retValue
     * @param beginTime
     * @param endTime
     * @return
     */
    private BeautyHandlerLogs convert2Log(ProceedingJoinPoint point, Object retValue, long beginTime, long endTime) {
        BeautyHandlerLogs log = new BeautyHandlerLogs();
        try {
            log.setAccount(StringUtil.valueOf(session.getAttribute("CURRENT_USER_ACCOUNT")).concat(":").concat(StringUtil.valueOf(session.getAttribute("IP"))));
        } catch (Exception e) {
            log.setAccount("account");
        }
        try {
            log.setArgs(StringUtil.valueOf(point.getArgs()));
        } catch (Exception e) {
            log.setArgs("");
        }
        try {
            log.setReturnValue(StringUtil.valueOf(retValue));
        } catch (Exception e) {
            log.setReturnValue("");
        }
        log.setClassName(point.getTarget().getClass().getName());
        log.setMethodName(point.getSignature().getName());
        log.setBeginTime(new Date(beginTime));
        log.setEndTime(new Date(endTime));
        log.setCreateTime(new Date());
        return log;
    }

}
