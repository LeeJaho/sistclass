package com.newlecture.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LogAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		
		StopWatch sw = new StopWatch();
		sw.start();
		System.out.println("around before");
	
		Object result = methodInvocation.proceed();
		
		sw.stop();
		System.out.println("around after : " + sw.getTotalTimeMillis());
		
		return null;
	}
	
	
	
}
