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
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @Autowired
    private LogService logService;

    @Resource(name = "logDirectTemplate")
    private RabbitTemplate logDirectTemplate;

    /**
     *
     */
    public LogHandler() {
    }

    // 声明切入点
    @Pointcut("execution(* com.beauty.controller..*.*(..))")
    public void anyMethod() {
    }

    // 前置通知
    // @Before("anyMethod()")
    public void dobefore() {
        System.out.println("我是前置通知。");
    }

    // 后置通知
    // @AfterReturning("anyMethod()")
    public void doafterReturning() {
        System.out.println("我是后置通知。");
    }

    // 最终置通知
    // @After("anyMethod()")
    public void doafter() {
        System.out.println("我是最终通知。");
    }

    // 异常通知
    // @AfterThrowing(value = "anyMethod()", throwing = "e")
    public void doException(JoinPoint point, Throwable e) {
        System.out.println("我是异常通知。");
    }

    /**
     * @param point
     * @return Object
     * @throws Throwable
     * @throws
     * @Title: doInfoLog
     * @Description: TODO(输出日志)
     * @author frinder_liu
     * @date 2015年4月6日 下午2:05:17
     */
    @Around("anyMethod()")
    public Object doInfoLog(ProceedingJoinPoint point) throws Throwable {
        BeautyHandlerLogs log = new BeautyHandlerLogs();
        String account = StringUtil.valueOf(session.getAttribute("CURRENT_USER_ACCOUNT")).concat(":").concat(StringUtil.valueOf(session.getAttribute("IP")));
        log.setAccount(account);
        log.setBeginTime(new Date());
        String className = point.getTarget().getClass().getName();
        log.setClassName(className);
        String methodName = point.getSignature().getName();
        log.setMethodName(methodName);
        try {
            Object[] args = point.getArgs();
            log.setArgs(JSON.toJSONString(args));
        } catch (Exception e) {
            log.setArgs(JSON.toJSONString(e.getMessage()));
        }
        logger.info("begin to execute : " + JSON.toJSONString(log));
        // 返回结果
        Object retValue = point.proceed();
        try {
            log.setReturnValue(JSON.toJSONString(retValue));
        } catch (Exception e) {
            log.setReturnValue(e.getMessage());
        }
        log.setEndTime(new Date());
        log.setCreateTime(new Date());
        // this.logService.insertSelective(log);
        this.logDirectTemplate.convertAndSend(log);
        logger.info("end of execute : " + JSON.toJSONString(log));
        return retValue;
    }

}
