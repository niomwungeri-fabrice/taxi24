package unit.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.taxi24.dao.DriverRepo;
import com.taxi24.models.Driver;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DriverControllerTestttttt {
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private DriverRepo driverRepo;
    
    List<Driver> drivers = Arrays.asList(
            new Driver(UUID.randomUUID(), "Fabrice", "Niyomwungeri", true, "14.91817,22.94742"),
            new Driver(UUID.randomUUID(), "Fabrice", "Niyomwungeri", true, "14.91817,22.94742"));

    @Before
    public void init() {
    	final UUID uuid = UUID.randomUUID();
    	Driver driver = new Driver(uuid, "Fabrice", "Niyomwungeri", true, "34.94817,22.94722");
        when(driverRepo.findById(uuid)).thenReturn(Optional.of(driver));
    }
    
    @Test
    public void testAvailableDrivers() throws Exception {

        when(driverRepo.findByIsAvailableTrue()).thenReturn(drivers);

        mockMvc.perform(get("/drivers/available"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].isAvailable", is(true)));
        verify(driverRepo, times(1)).findByIsAvailableTrue();
    }
    
    @Test
    public void testAvailableDriversWithInRange() throws Exception {
    	 when(driverRepo.findByIsAvailableTrue()).thenReturn(drivers);
    	 
    	 mockMvc.perform(get("/drivers/3000/available?latitude=-1.956537&&longitude=30.063616"))
		    	 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
		         .andExpect(status().isOk())
		         .andExpect(jsonPath("$[0].isAvailable", is(true)));
		 verify(driverRepo, times(1)).findByIsAvailableTrue();
    }
}
