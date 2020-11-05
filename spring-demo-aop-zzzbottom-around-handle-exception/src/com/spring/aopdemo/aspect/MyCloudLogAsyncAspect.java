package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
	
	//c
	@Before("com.spring.aopdemo.aspect.combineAopExpressions.combineNoGetterSetter()")
	public void cloudAsync() {
			
		System.out.println("=====>>> From cloudAsync()");
	}
}
