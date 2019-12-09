package unit.controllers;

import com.taxi24.Taxi24Application;
import com.taxi24.constant.Paths;
import com.taxi24.controllers.DriverController;
import com.taxi24.models.Driver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Taxi24Application.class)
@WebMvcTest(DriverController.class)
public class DriverControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DriverController driverController;

    @Test
    public void getAvailable() throws Exception{
        Driver driver = createDriver();

        List<Driver> drivers =  Arrays.asList(driver);

        given(driverController.getAvailable()).willReturn(drivers);

        mockMvc.perform(get( Paths.DRIVERS + "/available")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].isAvailable", is(true)))
                .andExpect(jsonPath("$", hasSize(1)));

    }

    private Driver createDriver(){
        final UUID uuid = UUID.randomUUID();
        Driver driver = new Driver(uuid, "Fabrice", "Niyomwungeri", true, "34.94817,22.94722");
        return driver;
    }
}