package com.beauty.controller;

import com.alibaba.fastjson.JSON;
import com.beauty.entity.BeautyQueue;
import com.beauty.handler.MessageHandler;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/queue")
public class QueueController implements InitializingBean, ApplicationContextAware {

    protected ApplicationContext applicationContext;

    @Autowired
    private CachingConnectionFactory rabbitConnectionFactory;

    @Autowired
    private RabbitAdmin rabbitAdmin;

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
        System.err.println("-------------------------------------------------------------");
        System.err.println("-------------------------------------------------------------");
        Map<String, Object> params = new HashMap<>();
        params.put("from", 0);
        params.put("size", 10);
        List<BeautyQueue> queues = (List<BeautyQueue>)this.queueService.selectPage(params);
        for (BeautyQueue queue : queues){
            QueueEntity queueEntity = new QueueEntity(rabbitConnectionFactory, queue.getQueueName(), queue.getExchangeName(), queue.getRoutingKey(), queue.getType(), new MessageHandler());
            queueEntity.declare(rabbitAdmin);
            System.err.println(JSON.toJSONString(queueEntity));
        }
        System.err.println("-------------------------------------------------------------");
        System.err.println("-------------------------------------------------------------");
    }

    @RequestMapping("send")
    @ResponseBody
    public Value send(){
        System.err.println(JSON.toJSONString(QueueEntity._QUEUES_MAP));
        QueueEntity._QUEUES_MAP.get("message.topic.queue").getRabbitTemplate().convertAndSend("hello world...");
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
