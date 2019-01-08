package com.kwin.rabbit.producer;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kwin.rabbit.entity.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderSenderTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Autowired
	private OrderSender orderSender;
	
	@Test
	public void sendTest() throws Exception {
		Order order = new Order();
		order.setId("201901080000000001");
		order.setName("测试订单1");
		order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
		
		orderSender.send(order);
		
	}
	

}
