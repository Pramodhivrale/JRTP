package com.example.service;

import org.springframework.stereotype.Service;

import com.example.binding.BookBinding;

@Service
public class BookService {
	
	public boolean getBookData(BookBinding bookBinding) {
		System.out.println(bookBinding);
		if(bookBinding != null) {
			return true;
		}
		return false;
	}

}
