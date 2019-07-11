package com.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.rabbit.direct.DirectSender;
import com.bill.rabbit.workqueue.NewTask;

@RestController
@RequestMapping("/rabbit")
public class RabbitConntroller {

	@Autowired
	private DirectSender sender;
	
	@Autowired
	private NewTask newTask;
	
    @GetMapping("/hello")
    public void hello() {
    	sender.send();
    }
    
    @GetMapping("/newtask")
    public void newTask() {
    	newTask.send();
    }
}
