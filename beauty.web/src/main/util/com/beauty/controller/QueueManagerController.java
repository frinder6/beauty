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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by frinder_liu on 2016/2/29.
 */
@Controller
@RequestMapping("/qe/manager")
public class QueueManagerController {


    @Autowired
    private CachingConnectionFactory rabbitConnectionFactory;

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Autowired
    private Handler messageHandler;

    @Autowired
    private QueueService queueService;



    @RequestMapping("/start/receive")
    @ResponseBody
    public Value startReceive(Value value) {
        List<?> list = this.queueService.selectByPrimaryKeys(value.getValues());
        for (Object obj : list) {
            BeautyQueue queue = (BeautyQueue) obj;
            QueueEntity queueEntity = QueueEntity._QUEUES_MAP.get(queue.getQueueName());
            if (null != queueEntity) {
                queueEntity.startReceive();
            }
        }
        return new Value(CodeUtil.SUCCESS);
    }

    @RequestMapping("/stop/receive")
    @ResponseBody
    public Value stopReceive(Value value) {
        List<?> list = this.queueService.selectByPrimaryKeys(value.getValues());
        for (Object obj : list) {
            BeautyQueue queue = (BeautyQueue) obj;
            QueueEntity queueEntity = QueueEntity._QUEUES_MAP.get(queue.getQueueName());
            if (null != queueEntity) {
                queueEntity.stopReceive();
            }
        }
        return new Value(CodeUtil.SUCCESS);
    }

    @RequestMapping("/send")
    @ResponseBody
    public Value send(@RequestParam("account") String account) {
        BeautyMessage message = new BeautyMessage(account, "提示信息", "hello world...");
        QueueEntity._QUEUES_MAP.get("message.topic.queue").getRabbitTemplate().convertAndSend(message);
        return new Value(CodeUtil.SUCCESS);
    }


}