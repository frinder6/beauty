package com.beauty.mq.entity;

import com.beauty.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QueueEntity {

    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * 保存所有的队列
     */
    public static final Map<String, QueueEntity> _QUEUES_MAP = new ConcurrentHashMap<>();

    /**
     * 队列类型
     */
    public static final String _TYPE_DIRECT = "direct";
    public static final String _TYPE_TOPIC = "topic";
    public static final String _TYPE_FANOUT = "fanout";


    private String queueName;
    private String exchangeName;
    private String routingKey;
    private int type;
    private Queue queue;
    private Exchange exchange;
    private RabbitTemplate rabbitTemplate;
    private SimpleMessageListenerContainer container;
    private Object delegate;
    private Binding binding;


    /**
     * @param queueName    队列名
     * @param exchangeName 交换区名
     * @param routingKey   路由规则
     * @param type         队列类型
     * @param delegate     消息处理器
     */
    public QueueEntity(CachingConnectionFactory rabbitConnectionFactory, String queueName, String exchangeName, String routingKey, int type, Object delegate) {
        super();
        logger.info("queue...................init.................begin!");
        this.queueName = queueName;
        this.exchangeName = exchangeName;
        this.routingKey = routingKey;
        this.type = type;
        this.queue = new Queue(queueName);
        this.delegate = delegate;
        setExchange();
        setBinding();
        setRabbitTemplate(rabbitConnectionFactory);
        setContainer(rabbitConnectionFactory);
        if (!_QUEUES_MAP.containsKey(queueName)) {
            _QUEUES_MAP.put(queueName, this);
        }
        logger.info("queue...................init.................end!");
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Queue getQueue() {
        return queue;
    }

    public Exchange getExchange() {
        return exchange;
    }

    private void setExchange() {
        logger.info("exchange...................init.................begin!");
        if (!StringUtil.isEmpty(exchangeName)) {
            if (1 == type) {
                this.exchange = new DirectExchange(exchangeName);
                logger.info("exchange...................type.................direct!");
            } else if (2 == type) {
                this.exchange = new TopicExchange(exchangeName);
                logger.info("exchange...................type.................topic!");
            } else if (3 == type) {
                this.exchange = new FanoutExchange(exchangeName);
                logger.info("exchange...................type.................fanout!");
            } else {
                logger.info("exchange...................init.................fail!");
            }
        }
        logger.info("exchange...................init.................end!");
    }

    public RabbitTemplate getRabbitTemplate() {
        return rabbitTemplate;
    }

    private void setRabbitTemplate(CachingConnectionFactory rabbitConnectionFactory) {
        logger.info("template...................init.................begin!");
        this.rabbitTemplate = new RabbitTemplate(rabbitConnectionFactory);
        rabbitTemplate.setQueue(queueName);
        if (!StringUtil.isEmpty(exchangeName)) {
            rabbitTemplate.setExchange(exchangeName);
            logger.info("template...................exchange.................[ ".concat(exchangeName).concat(" ]"));
        }
        if (!StringUtil.isEmpty(routingKey)) {
            rabbitTemplate.setRoutingKey(routingKey);
            logger.info("template...................routingKey.................[ ".concat(routingKey).concat(" ]"));
        }
        logger.info("template...................init.................end!");
    }

    public SimpleMessageListenerContainer getContainer() {
        return container;
    }

    private void setContainer(CachingConnectionFactory rabbitConnectionFactory) {
        logger.info("SimpleMessageListenerContainer...................init.................begin!");
        container = new SimpleMessageListenerContainer(rabbitConnectionFactory);
        MessageListenerAdapter adapter = new MessageListenerAdapter();
        adapter.setDelegate(delegate);
        container.addQueues(queue);
        container.setMessageListener(adapter);
        // container.setAutoStartup(false);
        logger.info("SimpleMessageListenerContainer...................init.................end!");
    }

    public Object getDelegate() {
        return delegate;
    }

    public Binding getBinding() {
        return binding;
    }

    public void setBinding() {
        logger.info("binding...................init.................begin!");
        if (!StringUtil.isEmpty(exchangeName) && !StringUtil.isEmpty(routingKey)) {
            if (1 == type) {
                this.binding = BindingBuilder.bind(queue).to((DirectExchange) exchange).with(routingKey);
            } else if (2 == type) {
                this.binding = BindingBuilder.bind(queue).to((TopicExchange) exchange).with(routingKey);
            } else if (3 == type) {
                this.binding = BindingBuilder.bind(queue).to((FanoutExchange) exchange);
            } else {
                logger.info("binding...................init.................fail!");
            }
        }
        logger.info("binding...................init.................end!");
    }

    /**
     * 定义
     *
     * @param admin
     */
    public void declare(RabbitAdmin admin) {
        if (null != queue) {
            admin.declareQueue(queue);
        }
        if (null != exchange) {
            admin.declareExchange(exchange);
        }
        if (null != binding) {
            admin.declareBinding(binding);
        }
    }


    /**
     * @return int 1 成功 0失败
     * @throws
     * @Title: stop
     * @Description: TODO(停止队列接收消息方法)
     * @author frinder_liu
     * @date 2016年2月16日 下午8:39:16
     */
    public int stopReceive() {
        if (null != container && container.isRunning()) {
            container.stop();
            return 1;
        }
        return 0;
    }

    /**
     * @return int 1 成功 0失败
     * @throws
     * @Title: startReceive
     * @Description: TODO(启动队列接收消息方法)
     * @author frinder_liu
     * @date 2016年2月16日 下午8:42:23
     */
    public int startReceive() {
        if (null != container && !container.isRunning()) {
            container.start();
            return 1;
        }
        return 0;
    }
}
