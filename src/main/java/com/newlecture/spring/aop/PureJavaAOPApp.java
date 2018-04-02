package com.newlecture.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

public class PureJavaAOPApp {

	public static void main(String[] args) {
		Exam exam = new Exam();
    	FlowExamConsole console = new FlowExamConsole();
    	console.setExam(exam);
    	
    	
		ExamConsole proxy = (ExamConsole) Proxy.newProxyInstance(FlowExamConsole.class.getClassLoader(),
				new Class[] { ExamConsole.class }, new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("Start : " + new Date());
						Object result = method.invoke(console, args);
						System.out.println("end : " + new Date());

						return result;
					}
				});

    	proxy.input();
    	proxy.print();
    	

	}

}
