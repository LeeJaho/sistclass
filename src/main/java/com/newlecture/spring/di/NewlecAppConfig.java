package com.newlecture.spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //xml파일처럼 지시서 기능을 하겠다고 말하는 것
@ComponentScan("com.newlecture.spring.di") //component-scan -> ("") 경로
public class NewlecAppConfig {
	
	@Bean
	public ExamConsole console() {
		
		return new FlowExamConsole();
	}

}
