package com.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bindings.Binding;

@RestController
public class BindingRestController {

	HashOperations<String, Object, Object> opsForHash = null;

	public BindingRestController(RedisTemplate<String, Binding> rt) {
		this.opsForHash = rt.opsForHash();

	}

	@PostMapping("/country")
	public String addCountry(@RequestBody Binding binding) {
		opsForHash.put("countries", binding.getId(), binding);
		return "Record added !";
	}

	@GetMapping("/get")
	public Collection<Object> getCountries() {
		Map<Object, Object> entries = opsForHash.entries("countries");
		Collection<Object> values = entries.values();
		return values;
	}

	@GetMapping("/user{userId}")
	public Binding getCountry(@PathVariable("userId") Integer id) {
		System.out.println(id);
		Binding object = (Binding) opsForHash.get("countries", id);
		return object;
	}

}
