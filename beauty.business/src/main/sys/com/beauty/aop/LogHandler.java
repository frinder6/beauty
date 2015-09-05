/**    
 * @Title: LogHandler.java  
 * @Package com.mvc.aop  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年1月29日 上午12:03:38 
 * @version V1.0   
 */
package com.beauty.aop;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @ClassName: LogHandler
 * @Description: TODO(记录url)
 * @author frinder_liu
 * @date 2015年9月5日 下午8:57:34
 *
 */
//@Component
//@Aspect
public class LogHandler {

	private final Logger logger = LogManager.getLogger(getClass());

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

	// 环绕通知
	@Around("anyMethod()")
	public Object doLog(ProceedingJoinPoint point) throws Throwable {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", 1);
		String className = point.getTarget().getClass().getName();
		params.put("className", className);
		String methodName = point.getSignature().getName();
		params.put("methodName", methodName);
		// 返回结果
		Object retValue = point.proceed();
		//
		return retValue;
	}

	/**
	 * 
	 * @Title: anyMethodForInfoLog
	 * @Description: TODO(切面)
	 * @author frinder_liu
	 * @return void
	 * @date 2015年4月6日 下午2:05:34
	 * @throws
	 */
	//@Pointcut("execution(* com.mvc.controller..*.*(..))")
	public void anyMethodForInfoLog() {
	}

	/**
	 * 
	 * @Title: doInfoLog
	 * @Description: TODO(输出日志)
	 * @author frinder_liu
	 * @param point
	 * @return
	 * @throws Throwable
	 * @return Object
	 * @date 2015年4月6日 下午2:05:17
	 * @throws
	 */
	//@Around("anyMethodForInfoLog()")
	public Object doInfoLog(ProceedingJoinPoint point) throws Throwable {
		Map<String, Object> params = new HashMap<String, Object>();
		String className = point.getTarget().getClass().getName();
		params.put("ClassName", className);
		String methodName = point.getSignature().getName();
		params.put("MethodName", methodName);
		Object[] args = point.getArgs();
		try {
			JSON.toJSONString(args);
			params.put("Args", args);
		} catch (Exception e) {
			params.put("Args", e.getMessage());
		}
		logger.info("begin to execute : " + JSON.toJSONString(params));
		// 返回结果
		Object retValue = point.proceed();
		try {
			JSON.toJSONString(retValue);
			params.put("RetValue", retValue);
		} catch (Exception e) {
			params.put("RetValue", e.getMessage());
		}
		logger.info("end of execute : " + JSON.toJSONString(params));
		return retValue;
	}

}
