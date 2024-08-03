package com.rest;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class Controller {

	public static final String SERVICE_NAME = "fallback";

	@GetMapping("/redis")
	@CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "databaseLogic")
	public String getRedisData() {
		System.out.println("**Redis() method called**");

		if (new Random().nextInt(10) < 7) {
			throw new RuntimeException("Redis Server Is Down");
		}
		// logic to access data from redis
		return "data accessed from redis (main logic) ....";
	}

	public String databaseLogic(Throwable t) {
		System.out.println("**DB() method called**");
		// logic to access data from db
		return "data accessed from database (fall back logic) ....";
	}
}
