package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.TestingDemo.UtilMethods;

@WebMvcTest
public class RestApiTesting {

	@MockBean
	public UtilMethods utilMethods;
	
	@Autowired
	public MockMvc mockMvc;
	
	public void testwelcome() throws Exception {
		when(utilMethods.welcome()).thenReturn("Good Luck");
		
		MockHttpServletRequestBuilder reqbuilder=MockMvcRequestBuilders.get("welcome");
		MvcResult andReturn = mockMvc.perform(reqbuilder).andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();
		assertEquals(200,status);	
	}
}
