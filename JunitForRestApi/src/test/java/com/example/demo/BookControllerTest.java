package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.controler.BookController;
import com.example.service.BookService;

@WebMvcTest(value = BookController.class)
public class BookControllerTest {

	@MockBean
	private BookService bookService;

	@Autowired
	private MockMvc mockMvc;
	
	public void testAddBook() {
		
	}
}
