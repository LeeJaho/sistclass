package com.newlecture;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class AnoApp {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("호출하고 싶은 함수의 이름은 : ");
		String testName = scan.nextLine();
		
		
		//RRTI -> meta data -> Runtime type information
		AnoTestClass cls = new AnoTestClass();
		Class <?> clsInfo = cls.getClass();
		//System.out.println(clsInfo);
		Haha haha = clsInfo.getAnnotation(Haha.class);
		//Test test = cls.getClass().getAnnotation(Test.class);
		
		if(haha != null) {
			Method[] methods = clsInfo.getDeclaredMethods();
			
			for(Method m : methods) {
				
				Test test = m.getAnnotation(Test.class);
				System.out.println(test);
				if(test != null) {
					//name 속성을 확인해서 testName과 일치한다면
					if(test.name().equals(testName))
						//System.out.println(m.getName()+"()");
						m.invoke(cls, null);
					
				}
			}
		}
		
		
		/*Test test = cls.getClass().getAnnotation(Test.class);
		System.out.println(test);

		Haha haha = cls.getClass().getAnnotation(Haha.class);
		System.out.println(haha);
		
		//RRTI 객체
		Annotation[] anos = cls.getClass().getAnnotations();
		
		//anos.length
		System.out.println(anos.length);
		
		for(int i = 0; i < anos.length; i++) {
			System.out.println(anos[i]);
			System.out.println(anos[i].annotationType().getName());
			System.out.println(anos[i].annotationType().getSimpleName());
		}*/
	}
}
