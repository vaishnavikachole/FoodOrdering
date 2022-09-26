package com.food.ordering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.food.ordering")
public class OnlineFoodOrderingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodOrderingSystemApplication.class, args);

	}


}
