package com.bill.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.rabbit.workqueue.Worker;

@RestController
public class WorkController {

//	@Autowired
//	Worker worker;
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
//	@GetMapping("/work")
//	public void work(){
//		worker.doWork();
//	}
	
	/*
	 * 主动去消费
	 */
	@GetMapping("/consume")
	public void consume(){
		String message = (String) amqpTemplate.receiveAndConvert("helloQueue");
		System.out.println(message);
	}
}
