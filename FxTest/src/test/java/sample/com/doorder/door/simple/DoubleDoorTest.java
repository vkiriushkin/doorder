package sample.com.doorder.door.simple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.com.doorder.door.InnerDecorationType;
import sample.com.doorder.door.OuterDecorationType;
import sample.com.doorder.door.PlatbandType;

public class DoubleDoorTest extends Assert {

    private static final double DELTA = 1e-12;

    private DoubleDoor doubleDoor;

    @Before
    public void setUp() throws Exception {
        doubleDoor = new DoubleDoor();
        doubleDoor.setX(1000);
        doubleDoor.setY(2000);
        doubleDoor.setX_1(500);
        doubleDoor.setZ(70);
    }

    @Test
    public void testCalcMetalFrameParts() throws Exception {
        assertEquals(0, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcMetalFrameParts();
        assertEquals(66.66, doubleDoor.getMetal_L50x4_Price(), DELTA);
        assertEquals(93.50, doubleDoor.getMetal_40x20_Price(), DELTA);
        assertEquals(42.90, doubleDoor.getMetal_20x20_Price(), DELTA);
        assertEquals(0, doubleDoor.getMetal_40x40_Price(), DELTA);
        assertEquals(203.06, doubleDoor.getMetalFramesPartsTotalPrice(), DELTA);
        assertEquals(203.06, doubleDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcMetalList() throws Exception {
        assertEquals(0, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcMetalList();
        assertEquals(150, doubleDoor.getMetalListPrice(), DELTA);
        assertEquals(150, doubleDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcHinge() throws Exception {
        assertEquals(0, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcHinge();
        assertEquals(48, doubleDoor.getHingePrice(), DELTA);
        assertEquals(48, doubleDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcHeater() throws Exception {
        assertEquals(0, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcHeater(true);
        assertEquals(24, doubleDoor.getHeaterPrice(), DELTA);
        assertEquals(24, doubleDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcSeal() throws Exception {
        assertEquals(0, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcSeal(true);
        assertEquals(96, doubleDoor.getSealPrice(), DELTA);
        assertEquals(96, doubleDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcOuterDecoration() throws Exception {
        assertEquals(doubleDoor.getTotalPrice(), 0.0, DELTA);
        doubleDoor.calcOuterDecoration(OuterDecorationType.SELF_ADHESIVE_FILM);
        assertEquals(164, doubleDoor.getOuterDecorationPrice(), DELTA);
        assertEquals(164, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcOuterDecoration(OuterDecorationType.PAINTING_SHAGREEN);
        assertEquals(224, doubleDoor.getOuterDecorationPrice(), DELTA);
        assertEquals(224, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcOuterDecoration(OuterDecorationType.PAINTING_ANTIC);
        assertEquals(256, doubleDoor.getOuterDecorationPrice(), DELTA);
        assertEquals(256, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcOuterDecoration(OuterDecorationType.PAINTING_PF);
        assertEquals(96, doubleDoor.getOuterDecorationPrice(), DELTA);
        assertEquals(96, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcOuterDecoration(OuterDecorationType.ANTI_LAYER);
        assertEquals(128, doubleDoor.getOuterDecorationPrice(), DELTA);
        assertEquals(128, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcOuterDecoration(OuterDecorationType.MDF10);
        assertEquals(298, doubleDoor.getOuterDecorationPrice(), DELTA);
        assertEquals(298, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcOuterDecoration(OuterDecorationType.MDF16);
        assertEquals(498, doubleDoor.getOuterDecorationPrice(), DELTA);
        assertEquals(498, doubleDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcInnerDecoration() throws Exception {
        assertEquals(doubleDoor.getTotalPrice(), 0.0, DELTA);
        doubleDoor.calcInnerDecoration(InnerDecorationType.PLASTIC);
        assertEquals(378.40, doubleDoor.getInnerDecorationPrice(), DELTA);
        assertEquals(378.40, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcInnerDecoration(InnerDecorationType.LAMINATED_PLASTIC);
        assertEquals(462, doubleDoor.getInnerDecorationPrice(), DELTA);
        assertEquals(462, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcInnerDecoration(InnerDecorationType.MDF10);
        assertEquals(188.16, doubleDoor.getInnerDecorationPrice(), DELTA);
        assertEquals(188.16, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcInnerDecoration(InnerDecorationType.MDF16);
        assertEquals(376.32, doubleDoor.getInnerDecorationPrice(), DELTA);
        assertEquals(376.32, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcInnerDecoration(InnerDecorationType.NO_DECORATION);
        assertEquals(60.00, doubleDoor.getInnerDecorationPrice(), DELTA);
        assertEquals(60.00, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_PF);
        assertEquals(255.58, doubleDoor.getInnerDecorationPrice(), DELTA);
        assertEquals(255.58, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
        assertEquals(329.68, doubleDoor.getInnerDecorationPrice(), DELTA);
        assertEquals(329.68, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
        assertEquals(348.20, doubleDoor.getInnerDecorationPrice(), DELTA);
        assertEquals(348.20, doubleDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcPlatband() throws Exception {
        assertEquals(doubleDoor.getTotalPrice(), 0.0, DELTA);
        doubleDoor.calcPlatband(PlatbandType.WOODEN);
        assertEquals(55, doubleDoor.getPlatbandPrice(), DELTA);
        assertEquals(55, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcPlatband(PlatbandType.METAL_PAINTING_PF);
        assertEquals(120.50, doubleDoor.getPlatbandPrice(), DELTA);
        assertEquals(120.50, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcPlatband(PlatbandType.METAL_PAINTING_SHAGREEN);
        assertEquals(134.50, doubleDoor.getPlatbandPrice(), DELTA);
        assertEquals(134.50, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcPlatband(PlatbandType.METAL_PAINTING_ANTIC);
        assertEquals(138, doubleDoor.getPlatbandPrice(), DELTA);
        assertEquals(138, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcPlatband(PlatbandType.MDF10);
        assertEquals(35, doubleDoor.getPlatbandPrice(), DELTA);
        assertEquals(35, doubleDoor.getTotalPrice(), DELTA);
        doubleDoor.calcPlatband(PlatbandType.MDF16);
        assertEquals(70, doubleDoor.getPlatbandPrice(), DELTA);
        assertEquals(70, doubleDoor.getTotalPrice(), DELTA);
    }
}
