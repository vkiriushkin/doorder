package sample.com.doorder.door.angled;

import org.junit.Before;
import org.junit.Test;
import sample.com.doorder.door.UnsupportedDimensions;

public class MetalListDimensionsTest extends AngledDoorTest{

    @Before
    public void setUp() throws Exception {
        this.angledDoor = new AngledDoor();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalListWidthLessExceptions() throws Exception {
        angledDoor.setY(2000);
        angledDoor.setX(499);
        angledDoor.calcMetalList();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalListWidthMoreExceptions() throws Exception {
        angledDoor.setY(2000);
        angledDoor.setX(1201);
        angledDoor.calcMetalList();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalListHeightLessExceptions() throws Exception {
        angledDoor.setY(999);
        angledDoor.setX(1000);
        angledDoor.calcMetalList();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalListHeightMoreExceptions() throws Exception {
        angledDoor.setY(2451);
        angledDoor.setX(1000);
        angledDoor.calcMetalList();
    }
}
