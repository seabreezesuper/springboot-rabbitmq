package com.bill.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bill")
public class SpringbootRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmqApplication.class, args);
	}
}

