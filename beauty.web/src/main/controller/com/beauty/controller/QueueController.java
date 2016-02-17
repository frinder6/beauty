package com.beauty.controller;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.model.Value;
import com.beauty.util.CodeUtil;

@Controller
@RequestMapping("/queue")
public class QueueController implements InitializingBean, ApplicationContextAware {

	protected ApplicationContext applicationContext;

	@Resource(name = "logMessageListenerContainer")
	private SimpleMessageListenerContainer logMessageListenerContainer;

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job logProcessJob;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}

	@RequestMapping("start")
	@ResponseBody
	public Value start() {
		if (!this.logMessageListenerContainer.isRunning()) {
			this.logMessageListenerContainer.start();
		}
		return new Value(CodeUtil.SUCCESS);
	}

	@RequestMapping("stop")
	@ResponseBody
	public Value stop() {
		if (this.logMessageListenerContainer.isRunning()) {
			this.logMessageListenerContainer.stop();
		}
		return new Value(CodeUtil.SUCCESS);
	}

	@RequestMapping("job")
	@ResponseBody
	public Value job() {
		try {
			JobExecution result = jobLauncher.run(logProcessJob, new JobParameters());
			System.out.println("==========================================");
			System.out.println(result);
			System.out.println("==========================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Value(CodeUtil.SUCCESS);
	}

}
