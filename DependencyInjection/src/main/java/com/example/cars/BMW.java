package com.example.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.cars.interfaces.Car;
import com.example.cars.interfaces.Engine;

//@Component ("MyBMW")
public class BMW implements Car{
	@Autowired
	@Qualifier("V8Engine")
	Engine eng;
	
	public String spec() {
		return "this is SUV with engine type as "+eng.type();
	}

}
