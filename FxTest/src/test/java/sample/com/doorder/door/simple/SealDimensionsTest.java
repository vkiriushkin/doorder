package sample.com.doorder.door.simple;

import org.junit.Before;
import org.junit.Test;

public class SealDimensionsTest extends AngledDoorTest {

    @Before
    public void setUp() throws Exception {
        this.angledDoor = new AngledDoor();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcSealWidthLessExceptions() throws Exception {
        angledDoor.setY(2000);
        angledDoor.setX(499);
        angledDoor.calcSeal(true);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcSealWidthMoreExceptions() throws Exception {
        angledDoor.setY(2000);
        angledDoor.setX(1201);
        angledDoor.calcSeal(true);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcSealHeightLessExceptions() throws Exception {
        angledDoor.setY(999);
        angledDoor.setX(1000);
        angledDoor.calcSeal(true);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcSealHeightMoreExceptions() throws Exception {
        angledDoor.setY(2451);
        angledDoor.setX(1000);
        angledDoor.calcSeal(true);
    }
}
