package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.data.DAO;
import com.service.UserService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class TestUser {

	@Test
	public void getUsernameById() {
//		DAO mock2 = PowerMockito.mock(DAO.class);
//
//		// Stubbing findNameById method
//		PowerMockito.when(mock2.findNameById(101)).thenReturn("Nick");
//
//		UserService userService = new UserService(mock2);
//		String nameById = userService.findNameById(101);
//		assertEquals("Nick", nameById);
		
		
	}

	@Test
	public void getEmailById() {
		DAO mock = PowerMockito.mock(DAO.class);

		PowerMockito.when(mock.findEmailbyId(102)).thenReturn("Peamodhivrale@gmail.com");

		UserService userService = new UserService(mock);
		String emailById = userService.findEmailById(102);
		assertEquals("Peamodhivrale@gmail.com", emailById);
	}

	@Test
	public void testDoProcess() {
		UserService mock3 = PowerMockito.mock(UserService.class);
		try {
			PowerMockito.doNothing().when(mock3, "pushtoKafkaTopic", anyString());
			mock3.doProcess();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testDoWorkWithPrivateMethodMock() throws Exception {
		UserService u=new UserService();
		UserService spy = PowerMockito.spy(u);
		PowerMockito.when(spy, "formatMsg", "test msg").thenReturn("TEST MSG");
		String doWork = u.doWork("test msg");
		assertEquals("TEST MSG", doWork);
	}

}
