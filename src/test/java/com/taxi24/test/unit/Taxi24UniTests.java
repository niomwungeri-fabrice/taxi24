package com.taxi24.test.unit;

import static org.mockito.Mockito.verify;

import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.taxi24.dao.DriverRepo;

@RunWith(SpringRunner.class)
@WebMvcTest
class Taxi24UniTests {
	
	@Autowired
	private MockMvc mockMVC;
	
	@MockBean
	private DriverRepo driverRepo;
	
	@Test
	public void testAvailabeDrivers() throws Exception{
		System.out.println(Collections.emptyList());
		Mockito.when(driverRepo.findByIsAvailableTrue()).thenReturn(Collections.emptyList());
		
		mockMVC.perform(
				MockMvcRequestBuilders.get("/drivers/available").accept(MediaType.APPLICATION_JSON)
				).andReturn();
		verify(driverRepo).findByIsAvailableTrue();
	}
}
