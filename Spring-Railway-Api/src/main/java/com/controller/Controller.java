package com.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.req.Passenger;
import com.req.Ticket;

@RestController
public class Controller {
	private int ticketId = 100;

	HashMap<Integer, Ticket> tickets = new HashMap<>();

	@PostMapping("/book")
	public Ticket bookTicket(@RequestBody Passenger passenger) {

		Ticket t = new Ticket();
		t.setTicketId(ticketId);
		t.setFrom(passenger.getFrom());
		t.setTo(passenger.getTo());
		t.setTrainNum(passenger.getTrainNum());
		t.setTktCost("500");
		t.setTicketStatus("CONFORMED");

		tickets.put(ticketId, t);
		ticketId++;

		return t;

	}
	
	@GetMapping("/book/{ticketId}")
	public Ticket getTicket(@PathVariable Integer ticketId)
	{
		System.out.println(tickets);
		
		if(tickets.containsKey(ticketId))
		{
			return tickets.get(ticketId);
		}
		return null;
		
	}

}
