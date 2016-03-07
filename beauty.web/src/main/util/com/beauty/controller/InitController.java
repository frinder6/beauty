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
//@Controller
//@RequestMapping("/init")
public class InitController implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("****************************************************");
        System.out.println("****************************************************");
        System.out.println("****************************************************");
        System.out.println("****************************************************");
        System.out.println("****************************************************");
        System.out.println("****************************************************");
        System.out.println("****************************************************");
    }
}