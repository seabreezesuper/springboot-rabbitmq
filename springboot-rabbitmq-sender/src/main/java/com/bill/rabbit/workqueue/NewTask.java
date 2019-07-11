package com.bill.rabbit.workqueue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

@Component
public class NewTask {

	private static int count = 0;

	private final static String TASK_QUEUE_NAME = "task_queue";

	public void send() {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		try {

			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			String message = "msg" + count++;

			channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

			channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
			System.out.println(" [x] Sent message'" + message + "'");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
