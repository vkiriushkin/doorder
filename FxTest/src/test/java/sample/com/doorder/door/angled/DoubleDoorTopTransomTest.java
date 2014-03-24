package sample.com.doorder.door.angled;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.com.doorder.door.types.InnerDecorationType;
import sample.com.doorder.door.types.OuterDecorationType;
import sample.com.doorder.door.types.PlatbandType;

public class DoubleDoorTopTransomTest extends Assert {

	private static final double DELTA = 1e-12;

	DoubleDoorTopTransom doubleDoorTopTransom;

	@Before
	public void setUp() throws Exception {
		doubleDoorTopTransom = new DoubleDoorTopTransom();
		doubleDoorTopTransom.setX(1500);
		doubleDoorTopTransom.setY(2000);
		doubleDoorTopTransom.setY_1(1500);
		doubleDoorTopTransom.setX_1(1000);
		doubleDoorTopTransom.setZ(70);
	}

	@Test
	public void testCalcMetalFrameParts() throws Exception {
		assertEquals(doubleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		doubleDoorTopTransom.calcMetalFrameParts();
		assertEquals(77.77, doubleDoorTopTransom.getMetal_L50x4_Price(), DELTA);
		assertEquals(150, doubleDoorTopTransom.getMetal_40x40_Price(),DELTA);
		assertEquals(102.85, doubleDoorTopTransom.getMetal_40x20_Price(), DELTA);
		assertEquals(64.35, doubleDoorTopTransom.getMetal_20x20_Price(), DELTA);
		assertEquals(394.97, doubleDoorTopTransom.getMetalFramesPartsTotalPrice(), DELTA);
		assertEquals(doubleDoorTopTransom.getMetalFramesPartsTotalPrice(),
				doubleDoorTopTransom.getMetal_L50x4_Price() + doubleDoorTopTransom.getMetal_40x40_Price() +
						doubleDoorTopTransom.getMetal_40x20_Price() + doubleDoorTopTransom.getMetal_20x20_Price(), DELTA);
		assertEquals(doubleDoorTopTransom.getTotalPrice(), doubleDoorTopTransom.getMetalFramesPartsTotalPrice(), DELTA);
	}

	@Test
	public void testCalcMetalList() throws Exception {
		assertEquals(doubleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		doubleDoorTopTransom.calcMetalList();
		assertEquals(262.50, doubleDoorTopTransom.getMetalListPrice(), DELTA);
		assertEquals(262.50, doubleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcHinge() throws Exception {
		assertEquals(doubleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		doubleDoorTopTransom.calcHinge();
		assertEquals(48, doubleDoorTopTransom.getHingePrice(), DELTA);
		assertEquals(48, doubleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@org.junit.Test
	public void testCalcHeaterIncluded() throws Exception {
		assertEquals(doubleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		doubleDoorTopTransom.calcHeater(true);
		assertEquals(36, doubleDoorTopTransom.getHeaterPrice(), DELTA);
		assertEquals(36, doubleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcSealIncluded() throws Exception {
		assertEquals(doubleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		doubleDoorTopTransom.calcSeal(true);
		assertEquals(108, doubleDoorTopTransom.getSealPrice(), DELTA);
		assertEquals(108, doubleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcOuterDecoration() throws Exception {
		assertEquals(doubleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		doubleDoorTopTransom.calcOuterDecoration(OuterDecorationType.SELF_ADHESIVE_FILM);
		assertEquals(225.80, doubleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(225.80, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcOuterDecoration(OuterDecorationType.PAINTING_SHAGREEN);
		assertEquals(309.40, doubleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(309.40, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcOuterDecoration(OuterDecorationType.PAINTING_ANTIC);
		assertEquals(353.60, doubleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(353.60, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcOuterDecoration(OuterDecorationType.PAINTING_PF);
		assertEquals(132.60, doubleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(132.60, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcOuterDecoration(OuterDecorationType.ANTI_LAYER);
		assertEquals(153.80, doubleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(153.80, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcOuterDecoration(OuterDecorationType.MDF10);
		assertEquals(393.80, doubleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(393.80, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcOuterDecoration(OuterDecorationType.MDF16);
		assertEquals(693.80, doubleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(693.80, doubleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcOuterDecorationWithoutTopSideTransom() throws Exception {
		assertEquals(doubleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		doubleDoorTopTransom.calcOuterDecorationWithoutTopSideTransom(OuterDecorationType.SELF_ADHESIVE_FILM);
		assertEquals(215.30, doubleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(215.30, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcOuterDecorationWithoutTopSideTransom(OuterDecorationType.PAINTING_SHAGREEN);
		assertEquals(259.80, doubleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(259.80, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcOuterDecorationWithoutTopSideTransom(OuterDecorationType.PAINTING_ANTIC);
		assertEquals(293.70, doubleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(293.70, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcOuterDecorationWithoutTopSideTransom(OuterDecorationType.PAINTING_PF);
		assertEquals(124.20, doubleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(124.20, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcOuterDecorationWithoutTopSideTransom(OuterDecorationType.ANTI_LAYER);
		assertEquals(161.30, doubleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(161.30, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcOuterDecorationWithoutTopSideTransom(OuterDecorationType.MDF10);
		assertEquals(341.30, doubleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(341.30, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcOuterDecorationWithoutTopSideTransom(OuterDecorationType.MDF16);
		assertEquals(566.30, doubleDoorTopTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(566.30, doubleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@org.junit.Test
	public void testCalcInnerDecoration() throws Exception {
		assertEquals(doubleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		doubleDoorTopTransom.calcInnerDecoration(InnerDecorationType.PLASTIC);
		assertEquals(580.80, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(580.80, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcInnerDecoration(InnerDecorationType.LAMINATED_PLASTIC);
		assertEquals(706.20, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(706.20, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcInnerDecoration(InnerDecorationType.MDF10);
		assertEquals(286.16, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(286.16, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcInnerDecoration(InnerDecorationType.MDF16);
		assertEquals(572.32, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(572.32, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcInnerDecoration(InnerDecorationType.NO_DECORATION);
		assertEquals(90, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(90, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_PF);
		assertEquals(347.33, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(347.33, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
		assertEquals(460.43, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(460.43, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
		assertEquals(488.70, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(488.70, doubleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@org.junit.Test
	public void testCalcInnerDecorationWithoutTopTransom() throws Exception {
		doubleDoorTopTransom.setX(1500);
		doubleDoorTopTransom.setX_1(1000);
		assertEquals(doubleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		doubleDoorTopTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.PLASTIC);
		assertEquals(418.50, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(418.50, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.LAMINATED_PLASTIC);
		assertEquals(512.55, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(512.55, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.MDF10);
		assertEquals(235.66, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(235.66, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.MDF16);
		assertEquals(448.82, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(448.82, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.NO_DECORATION);
		assertEquals(90, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(90, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.METAL_LIST_PAINTING_PF);
		assertEquals(310.58, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(310.58, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
		assertEquals(394.68, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(394.68, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
		assertEquals(415.70, doubleDoorTopTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(415.70, doubleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@org.junit.Test
	public void testCalcPlatband() throws Exception {
		assertEquals(doubleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		doubleDoorTopTransom.calcPlatband(PlatbandType.WOODEN);
		assertEquals(60.50, doubleDoorTopTransom.getPlatbandPrice(), DELTA);
		assertEquals(60.50, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcPlatband(PlatbandType.METAL_PAINTING_PF);
		assertEquals(132.55, doubleDoorTopTransom.getPlatbandPrice(), DELTA);
		assertEquals(132.55, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcPlatband(PlatbandType.METAL_PAINTING_SHAGREEN);
		assertEquals(147.95, doubleDoorTopTransom.getPlatbandPrice(), DELTA);
		assertEquals(147.95, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcPlatband(PlatbandType.METAL_PAINTING_ANTIC);
		assertEquals(151.80, doubleDoorTopTransom.getPlatbandPrice(), DELTA);
		assertEquals(151.80, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcPlatband(PlatbandType.MDF10);
		assertEquals(38.50, doubleDoorTopTransom.getPlatbandPrice(), DELTA);
		assertEquals(38.50, doubleDoorTopTransom.getTotalPrice(), DELTA);
		doubleDoorTopTransom.calcPlatband(PlatbandType.MDF16);
		assertEquals(77, doubleDoorTopTransom.getPlatbandPrice(), DELTA);
		assertEquals(77, doubleDoorTopTransom.getTotalPrice(), DELTA);
	}
}
