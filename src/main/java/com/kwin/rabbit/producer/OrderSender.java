package com.kwin.rabbit.producer;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kwin.rabbit.entity.Order;

@Component
public class OrderSender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void send(Order order) throws Exception {
		CorrelationData correlationData = new CorrelationData();
		correlationData.setId(order.getMessageId());
		rabbitTemplate.convertAndSend("order-exchange",//exchange
									"order.abcd", //routingkey
									order,  //Object
									correlationData);//correlationData 发消息指定的唯一id
	}
}
