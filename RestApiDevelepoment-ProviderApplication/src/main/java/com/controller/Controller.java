package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.req.Passenger;
import com.res.Ticket;

@RestController
public class Controller
{
	Map<Integer, Ticket> tickets=new HashMap<>();
	int tickedId=100;
	
	@PostMapping(
			value = "/book",
			consumes = {"application/xml", "application/json"},
			produces = {"application/xml", "application/json"}
			)
	public Ticket bookticket(@RequestBody Passenger passenger) 
	{
		
		
		Ticket r=new Ticket();
		r.setTicketId(tickedId);
		r.setFrom(passenger.getForm());
		r.setTo(passenger.getTo());
		r.setTrainNum("205266");
		r.setTktCost("522");
		r.setTicketStatus("confirmed");
		
		tickets.put(tickedId, r);
		tickedId++;
		
		return r;
	}
	
	@GetMapping(
			value="/ticket/{ticketId}",
			produces = {"application/xml", "application/json"}
	)
	public Ticket getTicket(@PathVariable Integer ticketId)
	{
		Ticket ticket = tickets.get(ticketId);
		System.out.println(ticket);
		if(tickets != null) {
			return ticket;
		}
		else {
		return null;
		}
		
		
	}	

}
