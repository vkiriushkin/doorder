package sample.com.doorder.door.simple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class AngledDoorTest extends Assert {

    private static final double DELTA = 1e-12;

    protected AngledDoor angledDoor;

    @Before
    public void setUp() throws Exception {
        this.angledDoor = new AngledDoor();
    }

    @org.junit.Test
    public void testCalcMetalFrameParts() throws Exception {
        assertEquals(angledDoor.getTotalPrice(), 0.0, DELTA);
        angledDoor.setHeight(2000);
        angledDoor.setWidth(1000);
        angledDoor.calcMetalFrameParts();
        assertEquals(angledDoor.getMetal_L50x4_Price(), 66.66, DELTA);
        assertEquals(angledDoor.getMetal_40x40_Price(), 0.0, DELTA);
        assertEquals(angledDoor.getMetal_40x20_Price(), 56.1, DELTA);
        assertEquals(angledDoor.getMetal_20x20_Price(), 42.9, DELTA);
        assertEquals(angledDoor.getMetalFramesPartsTotalPrice(), 165.66, DELTA);
        assertEquals(angledDoor.getMetalFramesPartsTotalPrice(),
                angledDoor.getMetal_L50x4_Price() + angledDoor.getMetal_40x40_Price() +
                        angledDoor.getMetal_40x20_Price() + angledDoor.getMetal_20x20_Price(), DELTA);
        assertEquals(angledDoor.getTotalPrice(), angledDoor.getMetalFramesPartsTotalPrice(), DELTA);
    }

    @org.junit.Test
    public void testCalcBigMetalList() throws Exception {
        angledDoor.setHeight(2000);
        angledDoor.setWidth(1000);
        assertEquals(angledDoor.getTotalPrice(), 0.0, DELTA);
        angledDoor.calcMetalList();
        assertEquals(150, angledDoor.getMetalListPrice(), DELTA);
        assertEquals(150, angledDoor.getTotalPrice(), DELTA);
    }

    @org.junit.Test
    public void testCalcSmallMetalList() throws Exception {
        angledDoor.setHeight(2000);
        angledDoor.setWidth(900);
        assertEquals(angledDoor.getTotalPrice(), 0.0, DELTA);
        angledDoor.calcMetalList();
        assertEquals(200, angledDoor.getMetalListPrice(), DELTA);
        assertEquals(200, angledDoor.getTotalPrice(), DELTA);
    }

    @org.junit.Test
    public void testCalcHinge() throws Exception {

    }

    @org.junit.Test
    public void testCalcHeater() throws Exception {

    }

    @org.junit.Test
    public void testCalcSeal() throws Exception {

    }

    @org.junit.Test
    public void testCalcOuterFacing() throws Exception {

    }

    @org.junit.Test
    public void testCalcInnerFacing() throws Exception {

    }

    @org.junit.Test
    public void testCalcPlatband() throws Exception {

    }

    @org.junit.Test
    public void testCalcAccessories() throws Exception {

    }
}
