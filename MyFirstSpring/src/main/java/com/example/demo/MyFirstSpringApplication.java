package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyFirstSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(MyFirstSpringApplication.class, args);
		
		Object byName=context.getBean("place");
		System.out.println(byName);
	
		
		Object byName1=context.getBean("flower");
		System.out.println(byName1);
		
	}
	
}