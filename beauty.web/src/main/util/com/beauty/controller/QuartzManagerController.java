package com.beauty.controller;

import com.beauty.model.Value;
import com.beauty.quartz.entity.ScheduleJob;
import com.beauty.util.CodeUtil;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by frinder_liu on 2016/2/29.
 */
@Controller
@RequestMapping("/quartz")
public class QuartzManagerController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private Scheduler scheduler;

   // @Autowired
    private CronTrigger trigger;


    /**
     * 关闭任务调度器
     *
     * @return
     */
    @RequestMapping("shut")
    @ResponseBody
    public Value shutDown() {
        try {
            if (scheduler.isStarted()) {
                scheduler.shutdown(true);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return new Value(CodeUtil.SUCCESS);
    }


    /**
     * 启动任务调度
     *
     * @return
     */
    @RequestMapping("start")
    @ResponseBody
    public Value start() {
        try {
            if (!scheduler.isStarted() || !scheduler.isShutdown()) {
                scheduler.start();
                scheduler.resumeAll();
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return new Value(CodeUtil.SUCCESS);
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<?, ?> list() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("scheduler", scheduler);
        GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
        map.put("matcher", matcher);
        Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
        map.put("jobKeys", jobKeys);
        List<Object> triggers = new ArrayList<>();
        map.put("triggers", triggers);
        for (JobKey jobKey : jobKeys) {
            triggers.addAll(scheduler.getTriggersOfJob(jobKey));
        }
        return map;
    }

    @RequestMapping("pause")
    @ResponseBody
    public Value pause() {
        try {
            scheduler.pauseJob(trigger.getJobKey());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return new Value(CodeUtil.SUCCESS);
    }

    @RequestMapping("change")
    @ResponseBody
    public Value changeTrigger() {
        String cronExpression = "0/5 * * * * ?";
        try {
            TriggerKey triggerKey = trigger.getKey();
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return new Value(CodeUtil.SUCCESS);
    }


    @RequestMapping("test")
    @ResponseBody
    public Value test(){
        try {
            ScheduleJob scheduleJob = new ScheduleJob("amqpItemReaderQtz", "DEFAULT", "com.beauty.quartz.AmqpItemReaderJobImpl", "execute", "0/5 * * * * ?", scheduler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Value(CodeUtil.SUCCESS);
    }




    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
