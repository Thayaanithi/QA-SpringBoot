package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.cars.interfaces.Car;

//@SpringBootApplication
public class DependencyInjection {

	public static void main(String[] args) {
		// ApplicationContext context=SpringApplication.run(DependencyInjection.class,
		// args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Car myCar=context.getBean("MyBMW",Car.class);
		System.out.println(myCar.spec());
	}

}
