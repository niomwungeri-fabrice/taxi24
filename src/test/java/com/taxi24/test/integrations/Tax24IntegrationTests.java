package com.taxi24.test.integrations;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.taxi24.Taxi24Application;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = Taxi24Application.class
		)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class Tax24IntegrationTests {
	@Autowired
	private MockMvc mockMVC;
	
	@Test
	public void testAvailableDrivers() throws Exception{
		MvcResult mvcResult = mockMVC.perform(
				MockMvcRequestBuilders.get("/drivers/available").accept(MediaType.APPLICATION_JSON)
				).andReturn();
		System.out.println(mvcResult);
	}
}
