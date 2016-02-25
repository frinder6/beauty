package com.beauty.mq.entity;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueEntity {

	/**
	 * 队列类型
	 */
	public static final String _TYPE_DIRECT = "direct";
	public static final String _TYPE_TOPIC = "topic";
	public static final String _TYPE_FANOUT = "fanout";

	@Autowired
	private CachingConnectionFactory rabbitConnectionFactory;

	private String queueName;
	private String exchangeName;
	private String routingKey;
	private String type;
	private Queue queue;
	private Exchange exchange;
	private RabbitTemplate rabbitTemplate;
	private SimpleMessageListenerContainer container;
	private Object delegate;

	public QueueEntity() {
	}

	/**
	 *
	 * @param queueName
	 *            队列名
	 * @param exchangeName
	 *            交换区名
	 * @param routingKey
	 *            路由规则
	 * @param type
	 *            队列类型
	 * @param delegate
	 *            消息处理器
	 */
	public QueueEntity(String queueName, String exchangeName, String routingKey, String type, Object delegate) {
		super();
		this.queueName = queueName;
		this.exchangeName = exchangeName;
		this.routingKey = routingKey;
		this.type = type;
		this.queue = new Queue(queueName);
		this.delegate = delegate;
		setExchange();
		setRabbitTemplate();
		setContainer();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Queue getQueue() {
		return queue;
	}

	public Exchange getExchange() {
		return exchange;
	}

	private void setExchange() {
		if (_TYPE_TOPIC.equalsIgnoreCase(type)) {
			this.exchange = new TopicExchange(exchangeName);
		} else if (_TYPE_FANOUT.equalsIgnoreCase(type)) {
			this.exchange = new FanoutExchange(exchangeName);
		} else {
			this.exchange = new DirectExchange(exchangeName);
		}
	}

	public RabbitTemplate getRabbitTemplate() {
		return rabbitTemplate;
	}

	private void setRabbitTemplate() {
		this.rabbitTemplate = new RabbitTemplate(rabbitConnectionFactory);
		rabbitTemplate.setQueue(queueName);
		rabbitTemplate.setExchange(exchangeName);
		rabbitTemplate.setRoutingKey(routingKey);
	}

	public SimpleMessageListenerContainer getContainer() {
		return container;
	}

	private void setContainer() {
		container = new SimpleMessageListenerContainer(rabbitConnectionFactory);
		MessageListenerAdapter adapter = new MessageListenerAdapter();
		adapter.setDelegate(delegate);
		container.addQueues(queue);
		container.setMessageListener(adapter);
	}

	public Object getDelegate() {
		return delegate;
	}

	/**
	 * 
	 * @Title: stop
	 * @Description: TODO(停止队列接收消息方法)
	 * @author frinder_liu
	 * @return
	 * @return int 1 成功 0失败
	 * @date 2016年2月16日 下午8:39:16
	 * @throws
	 */
	public int stopReceive() {
		if (null != container && container.isRunning()) {
			container.stop();
			return 1;
		}
		return 0;
	}

	/**
	 * 
	 * @Title: startReceive
	 * @Description: TODO(启动队列接收消息方法)
	 * @author frinder_liu
	 * @return
	 * @return int 1 成功 0失败
	 * @date 2016年2月16日 下午8:42:23
	 * @throws
	 */
	public int startReceive() {
		if (null != container && !container.isRunning()) {
			container.start();
			return 1;
		}
		return 0;
	}
}
