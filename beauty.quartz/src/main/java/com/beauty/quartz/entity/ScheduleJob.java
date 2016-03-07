package com.beauty.quartz.entity;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by frinder_liu on 2016/2/29.
 */
public class ScheduleJob {

    private Logger logger = Logger.getLogger(getClass());

    /**
     * 保存所有的job
     */
    public static final Map<String, ScheduleJob> _JOB_MAP = new ConcurrentHashMap<>();

    private String name;

    private String group;

    private String className;

    private String methodName;

    private String cronExpression;

    private volatile Boolean isStart = false;

    private Scheduler scheduler;

    private JobKey jobKey;

    private TriggerKey triggerKey;

    private CronTrigger cronTrigger;

    private JobDetail jobDetail;

    private volatile boolean isInit = false;

    public ScheduleJob(String name, String group, String className, String methodName, String cronExpression, Scheduler scheduler) throws Exception {
        logger.info("job...............init................begin!");
        this.name = name;
        this.group = group;
        this.className = className;
        this.methodName = methodName;
        this.cronExpression = cronExpression;
        this.scheduler = scheduler;
        setJobKey();
        setTriggerKey();
        setJobDetail();
        setCronTrigger();
        // scheduler.scheduleJob(jobDetail, cronTrigger);
        _JOB_MAP.put(name, this);
        logger.info("job...............init................end!");
    }

    /**
     * pause
     */
    public synchronized void pause() {
        logger.info("job...............pause................begin!");
        try {
            if (isStart) {
                scheduler.pauseJob(this.jobKey);
                isStart = false;
                logger.info("job...............pause................success!");
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
            logger.info("job...............pause................fail! ".concat(e.getMessage()));
        }
        logger.info("job...............pause................end!");
    }


    /**
     * start
     */
    public synchronized void start() {
        logger.info("job...............start................begin!");
        try {
            if (!isStart) {
                if (!isInit) {
                    scheduler.scheduleJob(jobDetail, cronTrigger);
                    isInit = true;
                } else {
                    scheduler.resumeJob(this.jobKey);
                }
                isStart = true;
                logger.info("job...............start................success!");
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
            logger.info("job...............start................fail! ".concat(e.getMessage()));
        }
        logger.info("job...............start................end!");
    }


    /**
     * reset expression
     *
     * @param cronExpression
     */
    public synchronized void resetTrigger(String cronExpression) {
        logger.info("job...............resetTrigger................begin!");
        try {
            cronTrigger = cronTrigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();
            scheduler.rescheduleJob(triggerKey, cronTrigger);
            this.isStart = true;
            this.cronExpression = cronExpression;
            logger.info("job...............resetTrigger................success!");
        } catch (SchedulerException e) {
            e.printStackTrace();
            logger.info("job...............resetTrigger................fail!");
        }
        logger.info("job...............resetTrigger................end!");
    }


    /**
     * delete
     */
    public void delete() {
        logger.info("job...............delete................begin!");
        try {
            scheduler.deleteJob(this.jobKey);
            _JOB_MAP.remove(name);
            logger.info("job...............delete................success!");
        } catch (SchedulerException e) {
            e.printStackTrace();
            logger.info("job...............delete................fail! ".concat(e.getMessage()));
        }
        logger.info("job...............delete................end!");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Boolean getIsStart() {
        return isStart;
    }

    public void setIsStart(Boolean isStart) {
        this.isStart = isStart;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public JobKey getJobKey() {
        return jobKey;
    }

    public void setJobKey() {
        this.jobKey = JobKey.jobKey(name, group);
    }

    public TriggerKey getTriggerKey() {
        return triggerKey;
    }

    public void setTriggerKey() {
        logger.info("job...............setTriggerKey................begin!");
        this.triggerKey = TriggerKey.triggerKey(name, group);
        logger.info("job...............setTriggerKey................end!");
    }

    public CronTrigger getCronTrigger() {
        return cronTrigger;
    }

    public void setCronTrigger() {
        logger.info("job...............setCronTrigger................begin!");
        this.cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();
        logger.info("job...............setCronTrigger................end!");
    }

    public JobDetail getJobDetail() {
        return jobDetail;
    }

    public void setJobDetail() throws Exception {
        logger.info("job...............setJobDetail................begin!");
        Class clazz = Class.forName(className);
        this.jobDetail = JobBuilder.newJob(clazz).withIdentity(jobKey).build();
        logger.info("job...............setJobDetail................end!");
    }
}
