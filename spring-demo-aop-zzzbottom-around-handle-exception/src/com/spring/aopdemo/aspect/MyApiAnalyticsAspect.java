package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	
	//c
	@Before("com.spring.aopdemo.aspect.combineAopExpressions.combineNoGetterSetter()")
	public void performApiAnalytics() {
			
		System.out.println("=====>>> From performApiAnalytics()");
	}
}
