
package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.controler.MsgController;
import com.example.service.ServiceClass;

@WebMvcTest(value = MsgController.class)
public class MsgControllerTest {
	
	@MockBean
	private ServiceClass serviceClass;
	
	@Autowired
	private MockMvc mockMvc;
	//Used to send request to our rest-api
	
	@Test
	public void testWelcomeMsg() throws Exception {
		when(serviceClass.getMessage()).thenReturn("GOOD MORNING");
		 
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/Welcome");
		
		ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder);
		MvcResult andReturn = perform.andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		Integer status = response.getStatus();
		assertEquals(200, status);
		
	}

}
