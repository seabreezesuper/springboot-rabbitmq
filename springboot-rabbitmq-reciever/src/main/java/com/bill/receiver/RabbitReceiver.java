package com.bill.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitReceiver {

	/*
	 * 监听消息队列，不用自己主动去触发拿消息这个动作
	 */
	@RabbitListener(queues = "task_queue")
	public void receiver(String message) {
		System.out.println("message:"+message);
	}
}
