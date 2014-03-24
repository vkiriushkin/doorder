package sample.com.doorder.door.angled;

import org.junit.Before;
import org.junit.Test;
import sample.com.doorder.door.UnsupportedDimensions;

public class MetalFramePartsDimensionsTest extends AngledDoorTest {

    @Before
    public void setUp() throws Exception {
        this.angledDoor = new AngledDoor();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalFramePartsWidthLessExceptions() throws Exception {
        angledDoor.setY(2000);
        angledDoor.setX(499);
        angledDoor.calcMetalFrameParts();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalFramePartsWidthMoreExceptions() throws Exception {
        angledDoor.setY(2000);
        angledDoor.setX(1201);
        angledDoor.calcMetalFrameParts();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalFramePartsHeightLessExceptions() throws Exception {
        angledDoor.setY(999);
        angledDoor.setX(1000);
        angledDoor.calcMetalFrameParts();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMetalFramePartsHeightMoreExceptions() throws Exception {
        angledDoor.setY(2451);
        angledDoor.setX(1000);
        angledDoor.calcMetalFrameParts();
    }

}
