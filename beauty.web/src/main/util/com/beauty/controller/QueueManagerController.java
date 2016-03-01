package com.beauty.controller;

import com.beauty.entity.BeautyMessage;
import com.beauty.entity.BeautyQueue;
import com.beauty.handler.Handler;
import com.beauty.model.Value;
import com.beauty.mq.entity.QueueEntity;
import com.beauty.service.QueueService;
import com.beauty.util.CodeUtil;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by frinder_liu on 2016/2/29.
 */
@Controller
@RequestMapping("/qe/manager")
public class QueueManagerController implements InitializingBean, ApplicationContextAware {

    protected ApplicationContext applicationContext;

    @Autowired
    private CachingConnectionFactory rabbitConnectionFactory;

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Autowired
    private Handler messageHandler;

    @Autowired
    private QueueService queueService;

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
        Map<String, Object> params = new HashMap<>();
        params.put("from", 0);
        params.put("size", 10);
        List<BeautyQueue> queues = (List<BeautyQueue>)this.queueService.selectPage(params);
        for (BeautyQueue queue : queues){
            QueueEntity queueEntity = new QueueEntity(rabbitConnectionFactory, queue.getQueueName(), queue.getExchangeName(), queue.getRoutingKey(), queue.getType(), messageHandler);
            queueEntity.declare(rabbitAdmin);
            queueEntity.getContainer().start();
        }
    }

    @RequestMapping("send")
    @ResponseBody
    public Value send(@RequestParam("account") String account){
        BeautyMessage message = new BeautyMessage(account, "提示信息", "hello world...");
        QueueEntity._QUEUES_MAP.get("message.topic.queue").getRabbitTemplate().convertAndSend(message);
        return new Value(CodeUtil.SUCCESS);
    }

    @RequestMapping("start")
    @ResponseBody
    public Value start(){
        QueueEntity._QUEUES_MAP.get("message.topic.queue").getContainer().start();
        return new Value(CodeUtil.SUCCESS);
    }

    @RequestMapping("stop")
    @ResponseBody
    public Value stop(){
        QueueEntity._QUEUES_MAP.get("message.topic.queue").getContainer().stop();
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