package com.soft.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soft.app.service.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloCtrl {
	
	//private HelloService service = new HelloService();
	
	private HelloService service;
	/*
	 * @RequestMapping(method = RequestMethod.POST,path = {"/hello",""}) public
	 * String helloWorld() { return "Hello World!"; }
	 */
	

	@PostMapping("/post")
	public String helloWorldPOST() {
		return service.PostHello();
	}
	
	
	public HelloCtrl(HelloService service) {
		super();
		this.service = service;
	}


	@GetMapping("/get")
	public String helloWorldGet() {
		return service.GetHello();
	}
	
	@PutMapping("/put")
	public String helloWorldPUT() {
		return service.PutHello();
	}
	
	@DeleteMapping("/delete")
	public String helloWorlDel() {
		return service.DelHello();
	}

}
