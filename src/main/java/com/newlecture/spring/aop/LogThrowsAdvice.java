package com.newlecture.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class LogThrowsAdvice implements ThrowsAdvice {
	public void afterThrowing(Method m, Object agrs[], Object target, Exception e) {
		System.out.println("예외 : " + e.getMessage());
	}
}
