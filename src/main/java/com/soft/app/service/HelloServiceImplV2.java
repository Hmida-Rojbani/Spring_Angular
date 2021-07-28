package com.soft.app.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service

public class HelloServiceImplV2 implements HelloService {

	public String GetHello() {
		return "Hello World! Get V2";
	}
	
	public String PostHello() {
		return "Hello World! post V2";
	}
	
	public String PutHello() {
		return "Hello World! Put V2";
	}
	
	public String DelHello() {
		return "Hello World! Delete V2";
	}

}
