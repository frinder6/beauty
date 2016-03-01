package com.beauty.quartz.job;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by frinder_liu on 2016/3/1.
 */
@Component
public class AmqpItemReaderJobImpl {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private org.springframework.batch.core.Job logProcessJob;

    public void execute() {
        try {
            JobExecution result = jobLauncher.run(logProcessJob, new JobParameters());
            logger.info(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
