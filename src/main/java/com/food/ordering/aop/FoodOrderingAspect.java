package com.food.ordering.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class FoodOrderingAspect {
	
	@Before("execution(public Customer getOneCustomer(..))")
	public void getOneCustomerAdvice()
	{
		System.out.println("GetOneCustomerAdvice executed");
	}

}
