package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(Demo1Application.class, args);
	
		Object byName=context.getBean("greeting");
		//String byType=context.getBean(String.class);
		//String byBoth=context.getBean("greeting",String.class);
		System.out.println(byName);
		//System.out.println(byType);
		//System.out.println(byBoth);
	

	
		Object byName1=context.getBean("book");
		//String byType1=context.getBean(String.class);
		//String byBoth1=context.getBean("Oliver Twist, String.class");
		System.out.println(byName1);
	}
	
	}
	

	