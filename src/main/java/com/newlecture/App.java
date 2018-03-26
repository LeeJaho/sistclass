package com.newlecture;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.newlecture.ui.FlowExamConsole;
import com.newlecture.ui.GridExamConsole;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException
    {
        /*GridExamConsole console = new GridExamConsole();*/
        /*FlowExamConsole console = new FlowExamConsole();*/
    	Properties properties = new Properties();
    	FileInputStream fis = new FileInputStream("app.properties");
    	properties.load(fis);
    	ExamConsole console = (ExamConsole) Class.forName(properties.getProperty("console")).newInstance();
        console.input();
        console.print();
    }
}
