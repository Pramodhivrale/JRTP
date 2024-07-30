package com.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GreetApi-JRTP4")
public interface FeignClientDemo {
	
	@GetMapping("/greet")
	public String invokeGreetApi();

}
