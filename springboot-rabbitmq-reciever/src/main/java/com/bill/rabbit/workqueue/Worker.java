package com.bill.rabbit.workqueue;

import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

@Component
public class Worker {

	private static final String TASK_QUEUE_NAME = "task_queue";

	public void doWork() {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			final Connection connection = factory.newConnection();
			final Channel channel = connection.createChannel();

			channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
			System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

			channel.basicQos(1);

			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
				String message = new String(delivery.getBody(), "UTF-8");

				System.out.println(" [x] Received '" + message + "'");
				try {
					doWork(message);
				} finally {
					System.out.println(" [x] Done");
					channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
				}
			};

			channel.basicConsume(TASK_QUEUE_NAME, false, deliverCallback, consumerTag -> {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void doWork(String task) {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException _ignored) {
			Thread.currentThread().interrupt();
		}

	}
}
