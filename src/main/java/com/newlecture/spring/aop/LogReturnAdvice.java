package com.newlecture.spring.aop;


import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogReturnAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] arg, Object target) throws Throwable {
		
		System.out.println("return : " + returnValue);
	}
	
	//ThrowAdvice
}
