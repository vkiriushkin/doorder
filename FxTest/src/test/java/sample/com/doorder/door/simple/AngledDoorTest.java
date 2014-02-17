package sample.com.doorder.door.simple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.com.doorder.door.InnerDecorationType;
import sample.com.doorder.door.OuterDecorationType;
import sample.com.doorder.door.PlatbandType;

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
        angledDoor.setHeight(2000);
        angledDoor.setWidth(900);
        assertEquals(angledDoor.getTotalPrice(), 0.0, DELTA);
        angledDoor.calcHinge();
        assertEquals(24, angledDoor.getHingePrice(), DELTA);
        assertEquals(24, angledDoor.getTotalPrice(), DELTA);
    }

    @org.junit.Test
    public void testCalcHeaterIncluded() throws Exception {
        angledDoor.setHeight(2000);
        angledDoor.setWidth(1000);
        assertEquals(angledDoor.getTotalPrice(), 0.0, DELTA);
        angledDoor.calcHeater(true);
        assertEquals(24, angledDoor.getHeaterPrice(), DELTA);
        assertEquals(24, angledDoor.getTotalPrice(), DELTA);
    }

    @org.junit.Test
    public void testCalcHeaterExcluded() throws Exception {
        angledDoor.setHeight(2000);
        angledDoor.setWidth(1000);
        assertEquals(angledDoor.getTotalPrice(), 0.0, DELTA);
        angledDoor.calcHeater(false);
        assertEquals(0, angledDoor.getHeaterPrice(), DELTA);
        assertEquals(0, angledDoor.getTotalPrice(), DELTA);
    }

    @org.junit.Test
    public void testCalcSealIncluded() throws Exception {
        angledDoor.setHeight(2000);
        angledDoor.setWidth(1000);
        assertEquals(angledDoor.getTotalPrice(), 0.0, DELTA);
        angledDoor.calcSeal(true);
        assertEquals(72, angledDoor.getSealPrice(), DELTA);
        assertEquals(72, angledDoor.getTotalPrice(), DELTA);
    }

    @org.junit.Test
    public void testCalcSealExcluded() throws Exception {
        angledDoor.setHeight(2000);
        angledDoor.setWidth(1000);
        assertEquals(angledDoor.getTotalPrice(), 0.0, DELTA);
        angledDoor.calcSeal(false);
        assertEquals(0, angledDoor.getSealPrice(), DELTA);
        assertEquals(0, angledDoor.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcOuterDecoration() throws Exception {
	    angledDoor.setHeight(2000);
	    angledDoor.setWidth(1000);
	    assertEquals(angledDoor.getTotalPrice(), 0.0, DELTA);
	    angledDoor.calcOuterDecoration(OuterDecorationType.SELF_ADHESIVE_FILM);
	    assertEquals(150, angledDoor.getOuterDecorationPrice(), DELTA);
	    assertEquals(150, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcOuterDecoration(OuterDecorationType.PAINTING_SHAGREEN);
	    assertEquals(207.20, angledDoor.getOuterDecorationPrice(), DELTA);
	    assertEquals(207.20, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcOuterDecoration(OuterDecorationType.PAINTING_ANTIC);
	    assertEquals(236.80, angledDoor.getOuterDecorationPrice(), DELTA);
	    assertEquals(236.80, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcOuterDecoration(OuterDecorationType.PAINTING_PF);
	    assertEquals(88.80, angledDoor.getOuterDecorationPrice(), DELTA);
	    assertEquals(88.80, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcOuterDecoration(OuterDecorationType.ANTI_LAYER);
	    assertEquals(114, angledDoor.getOuterDecorationPrice(), DELTA);
	    assertEquals(114, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcOuterDecoration(OuterDecorationType.MDF10);
	    assertEquals(284, angledDoor.getOuterDecorationPrice(), DELTA);
	    assertEquals(284, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcOuterDecoration(OuterDecorationType.MDF16);
	    assertEquals(484, angledDoor.getOuterDecorationPrice(), DELTA);
	    assertEquals(484, angledDoor.getTotalPrice(), DELTA);
    }

    @org.junit.Test
    public void testCalcInnerDecoration() throws Exception {
	    angledDoor.setHeight(2000);
	    angledDoor.setWidth(1000);
	    assertEquals(angledDoor.getTotalPrice(), 0.0, DELTA);
	    angledDoor.calcInnerDecoration(InnerDecorationType.PLASTIC);
	    assertEquals(325.60, angledDoor.getInnerDecorationPrice(), DELTA);
	    assertEquals(325.60, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcInnerDecoration(InnerDecorationType.LAMINATED_PLASTIC);
	    assertEquals(409.20, angledDoor.getInnerDecorationPrice(), DELTA);
	    assertEquals(409.20, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcInnerDecoration(InnerDecorationType.MDF10);
	    assertEquals(188.16, angledDoor.getInnerDecorationPrice(), DELTA);
	    assertEquals(188.16, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcInnerDecoration(InnerDecorationType.MDF16);
	    assertEquals(376.32, angledDoor.getInnerDecorationPrice(), DELTA);
	    assertEquals(376.32, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcInnerDecoration(InnerDecorationType.NO_DECORATION);
	    assertEquals(60.00, angledDoor.getInnerDecorationPrice(), DELTA);
	    assertEquals(60.00, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_PF);
	    assertEquals(256.45, angledDoor.getInnerDecorationPrice(), DELTA);
	    assertEquals(256.45, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
	    assertEquals(331.71, angledDoor.getInnerDecorationPrice(), DELTA);
	    assertEquals(331.71, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
	    assertEquals(350.53, angledDoor.getInnerDecorationPrice(), DELTA);
	    assertEquals(350.53, angledDoor.getTotalPrice(), DELTA);
    }

    @org.junit.Test
    public void testCalcPlatband() throws Exception {
	    angledDoor.setHeight(2000);
	    angledDoor.setWidth(1000);
	    angledDoor.setpWidth(70);
	    assertEquals(angledDoor.getTotalPrice(), 0.0, DELTA);
	    angledDoor.calcPlatband(PlatbandType.WOODEN);
	    assertEquals(55, angledDoor.getPlatbandPrice(), DELTA);
	    assertEquals(55, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcPlatband(PlatbandType.METAL_PAINTING_PF);
	    assertEquals(120.50, angledDoor.getPlatbandPrice(), DELTA);
	    assertEquals(120.50, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcPlatband(PlatbandType.METAL_PAINTING_SHAGREEN);
	    assertEquals(134.50, angledDoor.getPlatbandPrice(), DELTA);
	    assertEquals(134.50, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcPlatband(PlatbandType.METAL_PAINTING_ANTIC);
	    assertEquals(138, angledDoor.getPlatbandPrice(), DELTA);
	    assertEquals(138, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcPlatband(PlatbandType.MDF10);
	    assertEquals(35, angledDoor.getPlatbandPrice(), DELTA);
	    assertEquals(35, angledDoor.getTotalPrice(), DELTA);
	    angledDoor.calcPlatband(PlatbandType.MDF16);
	    assertEquals(70, angledDoor.getPlatbandPrice(), DELTA);
	    assertEquals(70, angledDoor.getTotalPrice(), DELTA);
    }

    @org.junit.Test
    public void testCalcAccessories() throws Exception {

    }
}
