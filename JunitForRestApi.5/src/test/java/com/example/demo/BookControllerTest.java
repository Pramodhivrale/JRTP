package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.binding.BookBinding;
import com.example.controler.BookController;
import com.example.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = BookController.class)
public class BookControllerTest {

	@MockBean
	private BookService bookService;

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testAddBook() throws Exception {
		
		when(bookService.getBookData(ArgumentMatchers.any())).thenReturn(true);
		
		BookBinding b=new BookBinding(1,"Java","e=Jems gaseloni");
		ObjectMapper obj=new ObjectMapper();
		String bookJson = obj.writeValueAsString(obj);
		
		MockHttpServletRequestBuilder content = MockMvcRequestBuilders.post("/addbook").contentType(MediaType.APPLICATION_JSON)
		                                      .content(bookJson);
		
		ResultActions perform = mockMvc.perform(content);
		
		MvcResult andReturn = perform.andReturn();
		
		MockHttpServletResponse response = andReturn.getResponse();
		
		int status = response.getStatus();
		
		assertEquals(201, status);
		
		
		                                      
		
		
	}
}
