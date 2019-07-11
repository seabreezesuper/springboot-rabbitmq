package com.bill.rabbit.direct;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectSender {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send(){
		String message = "hello" + new Date();
		System.out.println("Sender:" + message);
		this.amqpTemplate.convertAndSend("helloQueue",message);
	}
}
