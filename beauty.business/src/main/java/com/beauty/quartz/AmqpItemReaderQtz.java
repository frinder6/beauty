package com.beauty.quartz;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("amqpItemReaderQtz")
public class AmqpItemReaderQtz {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job logProcessJob;

	public void execute() {
		try {
			JobExecution result = jobLauncher.run(logProcessJob, new JobParameters());
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
