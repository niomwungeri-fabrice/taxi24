import com.taxi24.utils.DriverUtils;
import org.junit.Assert;
import org.junit.Test;

public class DriverUtilsTest {
    @Test
    public void calculateDistanceWithSameLocation(){
        final double expected = 0.0;
        final double actual = DriverUtils.distance(
                34.94817, 22.94722, 34.94817,22.94722, "K");
        Assert.assertEquals(actual, expected, 0.0);
    }
    @Test
    public void calculateDistanceWithDifferentLocationInKilometers(){
        final double expected = 0.009113350132446673;
        final double actual = DriverUtils.distance(
                34.94817, 22.94712, 34.94817,22.94722, "K");
        Assert.assertEquals(actual, expected, 0.0);
    }
    @Test
    public void calculateDistanceWithDifferentLocationWithNullUnit(){
        final double expected = 273.3971079754112;
        final double actual = DriverUtils.distance(
                34.94817, 22.94712, 34.94817,19.94722, null);
        Assert.assertEquals(actual, expected, 0.0);
    }

}
