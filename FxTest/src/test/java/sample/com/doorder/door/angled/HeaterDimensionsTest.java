package sample.com.doorder.door.angled;

import org.junit.Before;
import org.junit.Test;
import sample.com.doorder.door.UnsupportedDimensions;

public class HeaterDimensionsTest  extends AngledDoorTest {

    @Before
    public void setUp() throws Exception {
        this.angledDoor = new AngledDoor();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcHeaterWidthLessExceptions() throws Exception {
        angledDoor.setY(2000);
        angledDoor.setX(499);
        angledDoor.calcHeater(true);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcHeaterWidthMoreExceptions() throws Exception {
        angledDoor.setY(2000);
        angledDoor.setX(1201);
        angledDoor.calcHeater(true);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcHeaterHeightLessExceptions() throws Exception {
        angledDoor.setY(999);
        angledDoor.setX(1000);
        angledDoor.calcHeater(true);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcHeaterHeightMoreExceptions() throws Exception {
        angledDoor.setY(2451);
        angledDoor.setX(1000);
        angledDoor.calcHeater(true);
    }
}
