package unit.controllers;

import com.taxi24.dao.DriverRepo;
import com.taxi24.models.Driver;
import com.taxi24.utils.DriverUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.taxi24.Taxi24Application;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

	@MockBean
	private DriverRepo driverRepo;

	final UUID uuid = UUID.randomUUID();

	List<Driver> drivers = Arrays.asList(
			new Driver(UUID.randomUUID(), "Fabrice", "Niyomwungeri", true, "14.91817,22.94742"),
			new Driver(UUID.randomUUID(), "Fabrice", "Niyomwungeri", true, "14.91817,22.94742"));

	Driver driver = new Driver(uuid, "Fabrice", "Niyomwungeri", true, "34.94817,22.94722");

	@After
	public void clearDb(){
		driverRepo.deleteAll();
	}

	@Test
	public void createDriverTests() {
		final UUID uuid = UUID.randomUUID();
		Driver driver = new Driver(uuid, "Fabrice", "Niyomwungeri", true, "34.94817,22.94722");
		Driver newDriver = driverRepo.save(driver);
		System.out.print(newDriver+"==========");
//		Assert.assertEquals(driverRepo.findById(uuid), driver);
	}

	@Test
	public void testAvailableDrivers() throws Exception {
		mockMVC.perform(
				MockMvcRequestBuilders.get("/drivers/available").accept(MediaType.APPLICATION_JSON)
		)
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(content().json("[]"));
	}
}
