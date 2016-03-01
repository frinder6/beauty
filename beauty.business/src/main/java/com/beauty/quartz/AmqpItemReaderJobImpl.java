package com.beauty.quartz;

import com.beauty.util.SpringUtil;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;

/**
 * Created by frinder_liu on 2016/3/1.
 */
public class AmqpItemReaderJobImpl implements Job {

    private Logger logger = Logger.getLogger(this.getClass());


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            JobLauncher jobLauncher = SpringUtil.getBean("jobLauncher");
            org.springframework.batch.core.Job logProcessJob = SpringUtil.getBean("logProcessJob");
            JobExecution result = jobLauncher.run(logProcessJob, new JobParameters());
            logger.info(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
