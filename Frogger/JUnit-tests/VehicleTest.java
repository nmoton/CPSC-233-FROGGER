import static org.junit.Assert.*;
import org.junit.Test;

public class VehicleTest{

    @Test
    public void test_vehicleConstructor() {
        Vehicle v1 = new Vehicle(32, 320, 2.5, 1, false);
        assertEquals("Created left bound vehicle with constructor with length of 1", false, v1.isVehicleRightBound());
        assertEquals("Created left bound vehicle with constructor with length of 1", 32.0, v1.getVehiclePosX(), 0.000001);
        assertEquals("Created left bound vehicle with constructor with length of 1", 320.0, v1.getVehiclePosY(), 0.000001);
        assertEquals("Created left bound vehicle with constructor with length of 1", 1.0, v1.getVehicleLength(), 0.000001);
    }


    @Test
    public void test_rightBoundLengthTwo() {
        Vehicle v1 = new Vehicle(32, 320, 1.5, 2, true);
        assertEquals("Created right bound vehicle with constructor with length of 2", true, v1.isVehicleRightBound());
        if (v1.isVehicleRightBound()){
            v1.moveVehicleRightX();
        }
        else{
            v1.moveVehicleLeftX();
        }
        assertEquals("Created right bound vehicle with constructor with length of 2", 33.5, v1.getVehiclePosX(), 0.000001);
        assertEquals("Created right bound vehicle with constructor with length of 2", 320.0, v1.getVehiclePosY(), 0.000001);
        assertEquals("Created right bound vehicle with constructor with length of 2", 2.0, v1.getVehicleLength(), 0.000001);
    }
}