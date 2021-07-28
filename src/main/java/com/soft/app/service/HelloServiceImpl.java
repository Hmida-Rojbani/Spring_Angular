package com.soft.app.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HelloServiceImpl implements HelloService{
	
	public String GetHello() {
		return "Hello World! Get";
	}
	
	public String PostHello() {
		return "Hello World! post";
	}
	
	public String PutHello() {
		return "Hello World! Put";
	}
	
	public String DelHello() {
		return "Hello World! Delete";
	}

}
