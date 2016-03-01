package com.beauty.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by frinder_liu on 2016/3/1.
 */
public class MyTestJob01Impl implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.print("job1.....................");
        System.out.print("job1.....................");
        System.out.print("job1.....................");
        System.out.print("job1.....................");
        System.out.print("job1.....................");
        System.out.print("job1.....................");
        System.out.print("job1.....................");
        System.out.print("job1.....................");
        System.out.print("job1.....................");
        System.out.print("job1.....................");
    }
}
