package sample.com.doorder.door.simple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.com.doorder.door.InnerDecorationType;
import sample.com.doorder.door.OuterDecorationType;
import sample.com.doorder.door.PlatbandType;

public class SingleDoorTopTransomTest extends Assert {

	private static final double DELTA = 1e-12;

	private SingleDoorTopTransom singleDoorTopTransom;

	@Before
	public void setUp() throws Exception {
		this.singleDoorTopTransom = new SingleDoorTopTransom();
	}

	@Test
	public void testCalcMetalFrameParts() throws Exception {
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.setY(2000);
		singleDoorTopTransom.setX(1000);
		singleDoorTopTransom.setY_1(1500);
		singleDoorTopTransom.calcMetalFrameParts();
		assertEquals(66.66, singleDoorTopTransom.getMetal_L50x4_Price(), DELTA);
		assertEquals(100, singleDoorTopTransom.getMetal_40x40_Price(),DELTA);
		assertEquals(46.75, singleDoorTopTransom.getMetal_40x20_Price(), DELTA);
		assertEquals(42.90, singleDoorTopTransom.getMetal_20x20_Price(), DELTA);
		assertEquals(256.31, singleDoorTopTransom.getMetalFramesPartsTotalPrice(), DELTA);
		assertEquals(singleDoorTopTransom.getMetalFramesPartsTotalPrice(),
				singleDoorTopTransom.getMetal_L50x4_Price() + singleDoorTopTransom.getMetal_40x40_Price() +
						singleDoorTopTransom.getMetal_40x20_Price() + singleDoorTopTransom.getMetal_20x20_Price(), DELTA);
		assertEquals(singleDoorTopTransom.getTotalPrice(), singleDoorTopTransom.getMetalFramesPartsTotalPrice(), DELTA);
	}

	@Test
	public void testCalcMetalList() throws Exception {
		singleDoorTopTransom.setY(2000);
		singleDoorTopTransom.setX(1000);
		singleDoorTopTransom.setY_1(1500);
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.calcMetalList();
		assertEquals(175, singleDoorTopTransom.getMetalListPrice(), DELTA);
		assertEquals(175, singleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcMetalList1() throws Exception {
		singleDoorTopTransom.setY(2000);
		singleDoorTopTransom.setX(800);
		singleDoorTopTransom.setY_1(1500);
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.calcMetalList();
		assertEquals(220, singleDoorTopTransom.getMetalListPrice(), DELTA);
		assertEquals(220, singleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcHinge() throws Exception {
		singleDoorTopTransom.setY(2000);
		singleDoorTopTransom.setX(1000);
		singleDoorTopTransom.setY_1(1500);
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.calcHinge();
		assertEquals(24, singleDoorTopTransom.getHingePrice(), DELTA);
		assertEquals(24, singleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@org.junit.Test
	public void testCalcHeaterIncluded() throws Exception {
		singleDoorTopTransom.setY(2000);
		singleDoorTopTransom.setX(1000);
		singleDoorTopTransom.setY_1(1500);
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.calcHeater(true);
		assertEquals(24, singleDoorTopTransom.getHeaterPrice(), DELTA);
		assertEquals(24, singleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcSealIncluded() throws Exception {
		singleDoorTopTransom.setY(2000);
		singleDoorTopTransom.setX(1000);
		singleDoorTopTransom.setY_1(1500);
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.calcSeal(true);
		assertEquals(60, singleDoorTopTransom.getSealPrice(), DELTA);
		assertEquals(60, singleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcOuterDecoration() throws Exception {
		singleDoorTopTransom.setY(2000);
		singleDoorTopTransom.setX(1000);
		singleDoorTopTransom.setY_1(1500);
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.calcOuterDecoration(OuterDecorationType.SELF_ADHESIVE_FILM);
		assertEquals(150, singleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(150, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcOuterDecoration(OuterDecorationType.PAINTING_SHAGREEN);
		assertEquals(207.20, singleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(207.20, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcOuterDecoration(OuterDecorationType.PAINTING_ANTIC);
		assertEquals(236.80, singleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(236.80, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcOuterDecoration(OuterDecorationType.PAINTING_PF);
		assertEquals(88.80, singleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(88.80, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcOuterDecoration(OuterDecorationType.ANTI_LAYER);
		assertEquals(114, singleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(114, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcOuterDecoration(OuterDecorationType.MDF10);
		assertEquals(284, singleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(284, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcOuterDecoration(OuterDecorationType.MDF16);
		assertEquals(484, singleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(484, singleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcOuterDecorationWithoutTopTransom() throws Exception {
		singleDoorTopTransom.setY(2000);
		singleDoorTopTransom.setX(1000);
		singleDoorTopTransom.setY_1(1500);
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.SELF_ADHESIVE_FILM);
		assertEquals(148.50, singleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(148.50, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.PAINTING_SHAGREEN);
		assertEquals(176, singleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(176, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.PAINTING_ANTIC);
		assertEquals(199, singleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(199, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.PAINTING_PF);
		assertEquals(84, singleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(84, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.ANTI_LAYER);
		assertEquals(121.50, singleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(121.50, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.MDF10);
		assertEquals(249, singleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(249, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.MDF16);
		assertEquals(399, singleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(399, singleDoorTopTransom.getTotalPrice(), DELTA);
	}

    @org.junit.Test
    public void testCalcInnerDecoration() throws Exception {
        singleDoorTopTransom.setY(2000);
        singleDoorTopTransom.setX(1000);
        singleDoorTopTransom.setY_1(1500);
        assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
        singleDoorTopTransom.calcInnerDecoration(InnerDecorationType.PLASTIC);
        assertEquals(352, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(352, singleDoorTopTransom.getTotalPrice(), DELTA);
        singleDoorTopTransom.calcInnerDecoration(InnerDecorationType.LAMINATED_PLASTIC);
        assertEquals(435.60, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(435.60, singleDoorTopTransom.getTotalPrice(), DELTA);
        singleDoorTopTransom.calcInnerDecoration(InnerDecorationType.MDF10);
        assertEquals(188.16, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(188.16, singleDoorTopTransom.getTotalPrice(), DELTA);
        singleDoorTopTransom.calcInnerDecoration(InnerDecorationType.MDF16);
        assertEquals(376.32, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(376.32, singleDoorTopTransom.getTotalPrice(), DELTA);
        singleDoorTopTransom.calcInnerDecoration(InnerDecorationType.NO_DECORATION);
        assertEquals(60.00, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(60.00, singleDoorTopTransom.getTotalPrice(), DELTA);
        singleDoorTopTransom.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_PF);
        assertEquals(281.45, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(281.45, singleDoorTopTransom.getTotalPrice(), DELTA);
        singleDoorTopTransom.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
        assertEquals(338.11, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(338.11, singleDoorTopTransom.getTotalPrice(), DELTA);
        singleDoorTopTransom.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
        assertEquals(352.13, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(352.13, singleDoorTopTransom.getTotalPrice(), DELTA);
    }

	@org.junit.Test
	public void testCalcInnerDecorationWithoutTopTransom() throws Exception {
		singleDoorTopTransom.setY(2000);
		singleDoorTopTransom.setX(1000);
		singleDoorTopTransom.setY_1(1500);
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.PLASTIC);
		assertEquals(265.80, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(265.80, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.LAMINATED_PLASTIC);
		assertEquals(328.50, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(328.50, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.MDF10);
		assertEquals(155.16, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(155.16, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.MDF16);
		assertEquals(295.32, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(295.32, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.NO_DECORATION);
		assertEquals(60.00, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(60.00, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.METAL_LIST_PAINTING_PF);
		assertEquals(257.05, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(257.05, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
		assertEquals(313.11, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(313.11, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
		assertEquals(327.13, singleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(327.13, singleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@org.junit.Test
	public void testCalcPlatband() throws Exception {
		singleDoorTopTransom.setY(2000);
		singleDoorTopTransom.setX(1000);
		singleDoorTopTransom.setY_1(1500);
		singleDoorTopTransom.setZ(70);
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.calcPlatband(PlatbandType.WOODEN);
		assertEquals(55, singleDoorTopTransom.getPlatbandPrice(), DELTA);
		assertEquals(55, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcPlatband(PlatbandType.METAL_PAINTING_PF);
		assertEquals(120.50, singleDoorTopTransom.getPlatbandPrice(), DELTA);
		assertEquals(120.50, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcPlatband(PlatbandType.METAL_PAINTING_SHAGREEN);
		assertEquals(134.50, singleDoorTopTransom.getPlatbandPrice(), DELTA);
		assertEquals(134.50, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcPlatband(PlatbandType.METAL_PAINTING_ANTIC);
		assertEquals(138, singleDoorTopTransom.getPlatbandPrice(), DELTA);
		assertEquals(138, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcPlatband(PlatbandType.MDF10);
		assertEquals(35, singleDoorTopTransom.getPlatbandPrice(), DELTA);
		assertEquals(35, singleDoorTopTransom.getTotalPrice(), DELTA);
		singleDoorTopTransom.calcPlatband(PlatbandType.MDF16);
		assertEquals(70, singleDoorTopTransom.getPlatbandPrice(), DELTA);
		assertEquals(70, singleDoorTopTransom.getTotalPrice(), DELTA);
	}
}
