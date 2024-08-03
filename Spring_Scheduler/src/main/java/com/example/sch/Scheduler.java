package com.example.sch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Scheduler 
{
	@Scheduled(fixedRate = 2000)
	public void scheduledExecutation() {
		System.out.println("Schulder executed...");
	}

}
