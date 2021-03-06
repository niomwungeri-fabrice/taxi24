package unitTest.repositorieTest;



import com.taxi24.Taxi24Application;
import com.taxi24.dao.DriverRepo;
import com.taxi24.models.Driver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@ActiveProfiles("test")
@ContextConfiguration(classes= Taxi24Application.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DriverRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DriverRepo driverRepo;

    @Test
    public void whenFindAvailableDriver() {
        //given
        Driver firstDriver = new Driver();
        firstDriver.setIsAvailable(true);
        firstDriver.setFirstName("Fabrice");
        firstDriver.setLastName("Niyomwungeri");
        firstDriver.setLocation("34.94817,22.94722");
        entityManager.persist(firstDriver);
        entityManager.flush();

        Driver secondDriver = new Driver();
        secondDriver.setIsAvailable(true);
        secondDriver.setFirstName("Quincy");
        secondDriver.setLastName("Jones");
        secondDriver.setLocation("34.94817,22.94722");
        entityManager.persist(secondDriver);
        entityManager.flush();

        //when
        List<Driver> drivers = driverRepo.findByIsAvailableTrue();

        //then
        assertThat(drivers.size()).isEqualTo(2);
        assertThat(drivers.get(0)).isEqualTo(firstDriver);
        assertThat(drivers.get(1)).isEqualTo(secondDriver);
    }

}
