package com.bill.rabbit.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "helloQueue")
public class DirectReciever {

//	@RabbitHandler
//	public void process(String msg){
//		System.out.println("Reciever:" + msg);
//	}
}
