package sample.com.doorder.door.simple;

import org.junit.Before;
import org.junit.Test;

public class MetalFramePartsDimensionsTest extends AngledDoorTest {

    @Before
    public void setUp() throws Exception {
        this.angledDoor = new AngledDoor();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalFramePartsWidthLessExceptions() throws Exception {
        angledDoor.setHeight(2000);
        angledDoor.setWidth(499);
        angledDoor.calcMetalFrameParts();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalFramePartsWidthMoreExceptions() throws Exception {
        angledDoor.setHeight(2000);
        angledDoor.setWidth(1201);
        angledDoor.calcMetalFrameParts();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalFramePartsHeightLessExceptions() throws Exception {
        angledDoor.setHeight(999);
        angledDoor.setWidth(1000);
        angledDoor.calcMetalFrameParts();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalFramePartsHeightMoreExceptions() throws Exception {
        angledDoor.setHeight(2451);
        angledDoor.setWidth(1000);
        angledDoor.calcMetalFrameParts();
    }

}
