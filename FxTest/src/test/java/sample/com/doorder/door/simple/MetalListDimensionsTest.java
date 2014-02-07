package sample.com.doorder.door.simple;

import org.junit.Before;
import org.junit.Test;

public class MetalListDimensionsTest extends AngledDoorTest{

    @Before
    public void setUp() throws Exception {
        this.angledDoor = new AngledDoor();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalListWidthLessExceptions() throws Exception {
        angledDoor.setHeight(2000);
        angledDoor.setWidth(499);
        angledDoor.calcMetalList();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalListWidthMoreExceptions() throws Exception {
        angledDoor.setHeight(2000);
        angledDoor.setWidth(1201);
        angledDoor.calcMetalList();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalListHeightLessExceptions() throws Exception {
        angledDoor.setHeight(999);
        angledDoor.setWidth(1000);
        angledDoor.calcMetalList();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalListHeightMoreExceptions() throws Exception {
        angledDoor.setHeight(2451);
        angledDoor.setWidth(1000);
        angledDoor.calcMetalList();
    }
}