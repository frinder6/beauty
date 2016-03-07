package com.beauty.init;

import com.beauty.entity.BeautyJob;
import com.beauty.entity.BeautyQueue;
import com.beauty.handler.Handler;
import com.beauty.mq.entity.QueueEntity;
import com.beauty.quartz.entity.ScheduleJob;
import com.beauty.service.JobService;
import com.beauty.service.QueueService;
import org.quartz.Scheduler;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by frinder_liu on 2016/3/7.
 */
@Component
public class InitBean {

    @Autowired
    private JobService jobService;

    @Autowired
    private QueueService queueService;

    @Autowired
    private CachingConnectionFactory rabbitConnectionFactory;

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Autowired
    private Handler messageHandler;

    @Autowired
    private Scheduler scheduler;


    /**
     * init flag
     */
    private volatile static boolean isInit = false;


    @PostConstruct
    public void initMethod(){
        if (isInit){
            return;
        }
        try {
            initQueues();
            initJobs();
            isInit = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * init queue
     * @throws Exception
     */
    public void initQueues() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("from", 0);
        params.put("size", 100);
        List<BeautyQueue> queues = (List<BeautyQueue>) this.queueService.selectPage(params);
        for (BeautyQueue queue : queues) {
            QueueEntity queueEntity = new QueueEntity(rabbitConnectionFactory, rabbitAdmin, queue.getQueueName(), queue.getExchangeName(), queue.getRoutingKey(), queue.getType(), messageHandler);
            queueEntity.startReceive();
        }
    }


    /**
     * init jobs
     * @throws Exception
     */
    public void initJobs() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("from", 0);
        params.put("size", 100);
        List<?> list = this.jobService.selectPage(params);
        for (Object obj : list) {
            BeautyJob job = (BeautyJob) obj;
            new ScheduleJob(job.getName(), job.getGroupName(), job.getClassPath(), job.getMethodName(), job.getCronExpression(), scheduler);
        }
    }
}
