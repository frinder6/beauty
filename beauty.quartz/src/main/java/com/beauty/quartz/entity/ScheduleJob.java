package com.beauty.quartz.entity;

import org.quartz.*;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by frinder_liu on 2016/2/29.
 */
public class ScheduleJob {

    /**
     * 保存所有的job
     */
    public static final Map<String, ScheduleJob> _JOB_MAP = new HashMap<>();

    private String name;

    private String group;

    private String className;

    private String methodName;

    private String cronExpression;

    private Boolean isStart = true;

    private Scheduler scheduler;

    private JobKey jobKey;

    private TriggerKey triggerKey;

    private CronTrigger cronTrigger;

    private JobDetail jobDetail;

    public ScheduleJob(String name, String group, String className, String methodName, String cronExpression, Scheduler scheduler) throws Exception {
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
        scheduler.scheduleJob(jobDetail, cronTrigger);
        _JOB_MAP.put(name, this);
        if (scheduler.isStarted()){
            scheduler.resumeJob(jobKey);
        }
    }

    /**
     * pause
     */
    public synchronized void pause() {
        try {
            if (isStart) {
                scheduler.pauseJob(this.jobKey);
                isStart = false;
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * restart
     */
    public synchronized void restart() {
        try {
            if (!isStart) {
                scheduler.resumeJob(this.jobKey);
                isStart = true;
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    /**
     * reset expression
     *
     * @param cronExpression
     */
    public void resetTrigger(String cronExpression) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(this.name, this.group);
            CronTrigger trigger = (CronTrigger) this.scheduler.getTrigger(triggerKey);
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    /**
     * delete
     */
    public void delete() {
        try {
            scheduler.deleteJob(this.jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
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
        this.triggerKey = TriggerKey.triggerKey(name, group);
    }

    public CronTrigger getCronTrigger() {
        return cronTrigger;
    }

    public void setCronTrigger() {
        this.cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();
    }

    public JobDetail getJobDetail() {
        return jobDetail;
    }

    public void setJobDetail() throws Exception {
        Class clazz = Class.forName(className);
        this.jobDetail = JobBuilder.newJob(clazz).withIdentity(jobKey).build();
    }
}
