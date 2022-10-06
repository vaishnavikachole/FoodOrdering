package com.food.ordering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.ResponseEntity;

import com.food.ordering.aop.AppConfig;
import com.food.ordering.controller.CustomerController;

@SpringBootApplication
@ComponentScan(basePackages="com.food.ordering")
public class OnlineFoodOrderingSystemApplication implements CommandLineRunner{
	@Autowired
	CustomerController customerController;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodOrderingSystemApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		aspect();
	}
	
	
	public void aspect()
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ResponseEntity<?> customer = customerController.getOneCustomer(1);
		System.out.println(customer);
	
		context.close();
	}
	
	

}
