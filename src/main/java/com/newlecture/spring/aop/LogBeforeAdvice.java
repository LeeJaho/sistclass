package com.newlecture.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] arg, Object target) throws Throwable {
		System.out.println("Log Before");
		
	}
	
}
