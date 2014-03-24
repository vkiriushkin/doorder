package sample.com.doorder.door.angled;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.com.doorder.door.fireproof.DoubleFireProofDoor;
import sample.com.doorder.door.types.InnerDecorationType;
import sample.com.doorder.door.types.OuterDecorationType;
import sample.com.doorder.door.types.PlatbandType;

public class DoubleFireProofDoorTest extends Assert {

    private static final double DELTA = 1e-12;

    DoubleFireProofDoor doubleFireProofDoor;

    @Before
    public void setUp() throws Exception {
        this.doubleFireProofDoor = new DoubleFireProofDoor();
        this.doubleFireProofDoor.setX(1050);
        this.doubleFireProofDoor.setY(2100);
        this.doubleFireProofDoor.setX_1(1000);
    }

    @Test
    public void testCalcMetalFrameParts() throws Exception {
        assertEquals(doubleFireProofDoor.getTotalPrice(), 0.0, DELTA);
        doubleFireProofDoor.calcMetalFrameParts();
        assertEquals(doubleFireProofDoor.getMetal_40x40_Price(), 693, DELTA);
        assertEquals(doubleFireProofDoor.getMetal_40x20_Price(), 166.9, DELTA);
        assertEquals(doubleFireProofDoor.getMetalFramesPartsTotalPrice(), 859.90, DELTA);
        assertEquals(doubleFireProofDoor.getMetalFramesPartsTotalPrice(),
                doubleFireProofDoor.getMetal_40x40_Price() + doubleFireProofDoor.getMetal_40x20_Price(), DELTA);
        assertEquals(doubleFireProofDoor.getTotalPrice(), doubleFireProofDoor.getMetalFramesPartsTotalPrice(), DELTA);
    }

    @Test
    public void testCalcInnerMetalList() throws Exception {
        assertEquals(doubleFireProofDoor.getTotalPrice(), 0.0, DELTA);
        doubleFireProofDoor.calcInnerMetalList();
        assertEquals(100, doubleFireProofDoor.getInnerMetalListPrice(), DELTA);
        assertEquals(100, doubleFireProofDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcOuterMetalList() throws Exception {
        assertEquals(doubleFireProofDoor.getTotalPrice(), 0.0, DELTA);
        doubleFireProofDoor.calcOuterMetalList();
        assertEquals(100, doubleFireProofDoor.getOuterMetalListPrice(), DELTA);
        assertEquals(100, doubleFireProofDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcHinge() throws Exception {
        assertEquals(doubleFireProofDoor.getTotalPrice(), 0.0, DELTA);
        doubleFireProofDoor.calcHinge();
        assertEquals(72, doubleFireProofDoor.getHingePrice(), DELTA);
        assertEquals(72, doubleFireProofDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcOgrask() throws Exception {
        assertEquals(doubleFireProofDoor.getTotalPrice(), 0.0, DELTA);
        doubleFireProofDoor.calcOgrask();
        assertEquals(168, doubleFireProofDoor.getOgraskPrice(), DELTA);
        assertEquals(168, doubleFireProofDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcDryWall() throws Exception {
        assertEquals(doubleFireProofDoor.getTotalPrice(), 0.0, DELTA);
        doubleFireProofDoor.calcDryWall();
        assertEquals(61.74, doubleFireProofDoor.getDryWallPrice(), DELTA);
        assertEquals(61.74, doubleFireProofDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcMineralWool() throws Exception {
        assertEquals(doubleFireProofDoor.getTotalPrice(), 0.0, DELTA);
        doubleFireProofDoor.calcMineralWool();
        assertEquals(22.05, doubleFireProofDoor.getMineralWoolPrice(), DELTA);
        assertEquals(22.05, doubleFireProofDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcSeal() throws Exception {
        assertEquals(doubleFireProofDoor.getTotalPrice(), 0.0, DELTA);
        doubleFireProofDoor.calcSeal();
        assertEquals(100.8, doubleFireProofDoor.getSealPrice(), DELTA);
        assertEquals(100.8, doubleFireProofDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcOuterDecoration() throws Exception {
        assertEquals(doubleFireProofDoor.getTotalPrice(), 0.0, DELTA);
        doubleFireProofDoor.calcOuterDecoration(OuterDecorationType.SELF_ADHESIVE_FILM);
        assertEquals(181.02, doubleFireProofDoor.getOuterDecorationPrice(), DELTA);
        assertEquals(181.02, doubleFireProofDoor.getTotalPrice(), DELTA);
        doubleFireProofDoor.calcOuterDecoration(OuterDecorationType.PAINTING_SHAGREEN);
        assertEquals(266.07, doubleFireProofDoor.getOuterDecorationPrice(), DELTA);
        assertEquals(266.07, doubleFireProofDoor.getTotalPrice(), DELTA);
        doubleFireProofDoor.calcOuterDecoration(OuterDecorationType.PAINTING_ANTIC);
        assertEquals(304.08, doubleFireProofDoor.getOuterDecorationPrice(), DELTA);
        assertEquals(304.08, doubleFireProofDoor.getTotalPrice(), DELTA);
        doubleFireProofDoor.calcOuterDecoration(OuterDecorationType.PAINTING_PF);
        assertEquals(114.03, doubleFireProofDoor.getOuterDecorationPrice(), DELTA);
        assertEquals(114.03, doubleFireProofDoor.getTotalPrice(), DELTA);
        doubleFireProofDoor.calcOuterDecoration(OuterDecorationType.ANTI_LAYER);
        assertEquals(143.22, doubleFireProofDoor.getOuterDecorationPrice(), DELTA);
        assertEquals(143.22, doubleFireProofDoor.getTotalPrice(), DELTA);
        doubleFireProofDoor.calcOuterDecoration(OuterDecorationType.MDF10);
        assertEquals(412.22, doubleFireProofDoor.getOuterDecorationPrice(), DELTA);
        assertEquals(412.22, doubleFireProofDoor.getTotalPrice(), DELTA);
        doubleFireProofDoor.calcOuterDecoration(OuterDecorationType.MDF16);
        assertEquals(632.72, doubleFireProofDoor.getOuterDecorationPrice(), DELTA);
        assertEquals(632.72, doubleFireProofDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcInnerDecoration() throws Exception {
        assertEquals(doubleFireProofDoor.getTotalPrice(), 0.0, DELTA);
        doubleFireProofDoor.calcInnerDecoration(InnerDecorationType.MDF10);
        assertEquals(288.06, doubleFireProofDoor.getInnerDecorationPrice(), DELTA);
        assertEquals(288.06, doubleFireProofDoor.getTotalPrice(), DELTA);
        doubleFireProofDoor.calcInnerDecoration(InnerDecorationType.MDF16);
        assertEquals(496.12, doubleFireProofDoor.getInnerDecorationPrice(), DELTA);
        assertEquals(496.12, doubleFireProofDoor.getTotalPrice(), DELTA);
        doubleFireProofDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_PF);
        assertEquals(62.42, doubleFireProofDoor.getInnerDecorationPrice(), DELTA);
        assertEquals(62.42, doubleFireProofDoor.getTotalPrice(), DELTA);
        doubleFireProofDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
        assertEquals(145.64, doubleFireProofDoor.getInnerDecorationPrice(), DELTA);
        assertEquals(145.64, doubleFireProofDoor.getTotalPrice(), DELTA);
        doubleFireProofDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
        assertEquals(166.45, doubleFireProofDoor.getInnerDecorationPrice(), DELTA);
        assertEquals(166.45, doubleFireProofDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcPlatband() throws Exception {
        assertEquals(doubleFireProofDoor.getTotalPrice(), 0.0, DELTA);
        doubleFireProofDoor.calcPlatband(PlatbandType.METAL_PAINTING_PF);
        assertEquals(126.53, doubleFireProofDoor.getPlatbandPrice(), DELTA);
        assertEquals(126.53, doubleFireProofDoor.getTotalPrice(), DELTA);
        doubleFireProofDoor.calcPlatband(PlatbandType.METAL_PAINTING_SHAGREEN);
        assertEquals(141.23, doubleFireProofDoor.getPlatbandPrice(), DELTA);
        assertEquals(141.23, doubleFireProofDoor.getTotalPrice(), DELTA);
        doubleFireProofDoor.calcPlatband(PlatbandType.METAL_PAINTING_ANTIC);
        assertEquals(144.90, doubleFireProofDoor.getPlatbandPrice(), DELTA);
        assertEquals(144.90, doubleFireProofDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcAccessories() throws Exception {

    }
}
