package sample.com.doorder.door.simple;

import org.junit.Before;
import org.junit.Test;

public class HeaterDimensionsTest  extends AngledDoorTest {

    @Before
    public void setUp() throws Exception {
        this.angledDoor = new AngledDoor();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcHeaterWidthLessExceptions() throws Exception {
        angledDoor.setHeight(2000);
        angledDoor.setWidth(499);
        angledDoor.calcHeater(true);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcHeaterWidthMoreExceptions() throws Exception {
        angledDoor.setHeight(2000);
        angledDoor.setWidth(1201);
        angledDoor.calcHeater(true);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcHeaterHeightLessExceptions() throws Exception {
        angledDoor.setHeight(999);
        angledDoor.setWidth(1000);
        angledDoor.calcHeater(true);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcHeaterHeightMoreExceptions() throws Exception {
        angledDoor.setHeight(2451);
        angledDoor.setWidth(1000);
        angledDoor.calcHeater(true);
    }
}
