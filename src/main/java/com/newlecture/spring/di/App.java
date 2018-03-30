package com.newlecture.spring.di;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Hello world!
 *
 */
public class App{
	
	public static void main( String[] args ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException
	{
        /*GridExamConsole console = new GridExamConsole();*/
        /*FlowExamConsole console = new FlowExamConsole();*/
    	/*Properties properties = new Properties();
    	FileInputStream fis = new FileInputStream("app.properties");
    	properties.load(fis);*/
    	//각각 부품 객체 생성 귀찮아
    	/*Exam exam = new Exam();
    	FlowExamConsole console = new FlowExamConsole();
    	console.setExam(exam);*/
    	
    	//주문명세서로 가자
    	
    	
    	//ExamConsole console = (ExamConsole) Class.forName(properties.getProperty("console")).newInstance();
        ApplicationContext beans = 
        		new ClassPathXmlApplicationContext("com/newlecture/spring/di/app-context.xml");
        
        ExamConsole console = (ExamConsole) beans.getBean("console");
    	//console.input();
        console.print();
    }
}	
