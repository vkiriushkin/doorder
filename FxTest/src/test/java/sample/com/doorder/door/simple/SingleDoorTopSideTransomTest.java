package sample.com.doorder.door.simple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.com.doorder.door.InnerDecorationType;
import sample.com.doorder.door.OuterDecorationType;
import sample.com.doorder.door.PlatbandType;

public class SingleDoorTopSideTransomTest extends Assert{

	private static final double DELTA = 1e-12;

	SingleDoorTopSideTransom singleDoorTopSideTransom;

	@Before
	public void setUp() throws Exception {
		singleDoorTopSideTransom = new SingleDoorTopSideTransom();
		singleDoorTopSideTransom.setX(1500);
		singleDoorTopSideTransom.setY(2000);
		singleDoorTopSideTransom.setY_1(1500);
		singleDoorTopSideTransom.setX_1(1000);
		singleDoorTopSideTransom.setZ(70);
	}

	@Test
	public void testCalcMetalFrameParts() throws Exception {
		assertEquals(singleDoorTopSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopSideTransom.calcMetalFrameParts();
		assertEquals(77.77, singleDoorTopSideTransom.getMetal_L50x4_Price(), DELTA);
		assertEquals(450, singleDoorTopSideTransom.getMetal_40x40_Price(),DELTA);
		assertEquals(42.50, singleDoorTopSideTransom.getMetal_40x20_Price(), DELTA);
		assertEquals(64.35, singleDoorTopSideTransom.getMetal_20x20_Price(), DELTA);
		assertEquals(634.62, singleDoorTopSideTransom.getMetalFramesPartsTotalPrice(), DELTA);
		assertEquals(singleDoorTopSideTransom.getMetalFramesPartsTotalPrice(),
				singleDoorTopSideTransom.getMetal_L50x4_Price() + singleDoorTopSideTransom.getMetal_40x40_Price() +
						singleDoorTopSideTransom.getMetal_40x20_Price() + singleDoorTopSideTransom.getMetal_20x20_Price(), DELTA);
		assertEquals(singleDoorTopSideTransom.getTotalPrice(), singleDoorTopSideTransom.getMetalFramesPartsTotalPrice(), DELTA);
	}

	@Test
	public void testCalcMetalList() throws Exception {
		assertEquals(singleDoorTopSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopSideTransom.calcMetalList();
		assertEquals(225, singleDoorTopSideTransom.getMetalListPrice(), DELTA);
		assertEquals(225, singleDoorTopSideTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcHinge() throws Exception {
		assertEquals(singleDoorTopSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopSideTransom.calcHinge();
		assertEquals(24, singleDoorTopSideTransom.getHingePrice(), DELTA);
		assertEquals(24, singleDoorTopSideTransom.getTotalPrice(), DELTA);
	}

	@org.junit.Test
	public void testCalcHeaterIncluded() throws Exception {
		assertEquals(singleDoorTopSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopSideTransom.calcHeater(true);
		assertEquals(36, singleDoorTopSideTransom.getHeaterPrice(), DELTA);
		assertEquals(36, singleDoorTopSideTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcSealIncluded() throws Exception {
		assertEquals(singleDoorTopSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopSideTransom.calcSeal(true);
		assertEquals(60, singleDoorTopSideTransom.getSealPrice(), DELTA);
		assertEquals(60, singleDoorTopSideTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcOuterDecoration() throws Exception {
		assertEquals(singleDoorTopSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopSideTransom.calcOuterDecoration(OuterDecorationType.SELF_ADHESIVE_FILM);
		assertEquals(215, singleDoorTopSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(215, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcOuterDecoration(OuterDecorationType.PAINTING_SHAGREEN);
		assertEquals(315, singleDoorTopSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(315, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcOuterDecoration(OuterDecorationType.PAINTING_ANTIC);
		assertEquals(360, singleDoorTopSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(360, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcOuterDecoration(OuterDecorationType.PAINTING_PF);
		assertEquals(135, singleDoorTopSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(135, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcOuterDecoration(OuterDecorationType.ANTI_LAYER);
		assertEquals(165, singleDoorTopSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(165, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcOuterDecoration(OuterDecorationType.MDF10);
		assertEquals(405, singleDoorTopSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(405, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcOuterDecoration(OuterDecorationType.MDF16);
		assertEquals(705, singleDoorTopSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(705, singleDoorTopSideTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcOuterDecorationWithoutTopSideTransom() throws Exception {
		assertEquals(singleDoorTopSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopSideTransom.calcOuterDecorationWithoutTopSideTransom(OuterDecorationType.SELF_ADHESIVE_FILM);
		assertEquals(199.50, singleDoorTopSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(199.50, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcOuterDecorationWithoutTopSideTransom(OuterDecorationType.PAINTING_SHAGREEN);
		assertEquals(206, singleDoorTopSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(206, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcOuterDecorationWithoutTopSideTransom(OuterDecorationType.PAINTING_ANTIC);
		assertEquals(229, singleDoorTopSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(229, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcOuterDecorationWithoutTopSideTransom(OuterDecorationType.PAINTING_PF);
		assertEquals(114, singleDoorTopSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(114, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcOuterDecorationWithoutTopSideTransom(OuterDecorationType.ANTI_LAYER);
		assertEquals(172.50, singleDoorTopSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(172.50, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcOuterDecorationWithoutTopSideTransom(OuterDecorationType.MDF10);
		assertEquals(300, singleDoorTopSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(300, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcOuterDecorationWithoutTopSideTransom(OuterDecorationType.MDF16);
		assertEquals(450, singleDoorTopSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(450, singleDoorTopSideTransom.getTotalPrice(), DELTA);
	}

	@org.junit.Test
	public void testCalcInnerDecoration() throws Exception {
		assertEquals(singleDoorTopSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopSideTransom.calcInnerDecoration(InnerDecorationType.PLASTIC);
		assertEquals(580.80, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(580.80, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcInnerDecoration(InnerDecorationType.LAMINATED_PLASTIC);
		assertEquals(706.20, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(706.20, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcInnerDecoration(InnerDecorationType.MDF10);
		assertEquals(286.16, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(286.16, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcInnerDecoration(InnerDecorationType.MDF16);
		assertEquals(572.32, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(572.32, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcInnerDecoration(InnerDecorationType.NO_DECORATION);
		assertEquals(90, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(90, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_PF);
		assertEquals(360.85, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(360.85, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
		assertEquals(475.31, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(475.31, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
		assertEquals(503.93, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(503.93, singleDoorTopSideTransom.getTotalPrice(), DELTA);
	}

	@org.junit.Test
	public void testCalcInnerDecorationWithoutTopTransom() throws Exception {
		singleDoorTopSideTransom.setX(1500);
		singleDoorTopSideTransom.setX_1(1000);
		assertEquals(singleDoorTopSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopSideTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.PLASTIC);
		assertEquals(295.80, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(295.80, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.LAMINATED_PLASTIC);
		assertEquals(358.50, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(358.50, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.MDF10);
		assertEquals(185.16, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(185.16, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.MDF16);
		assertEquals(325.32, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(325.32, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.NO_DECORATION);
		assertEquals(90, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(90, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.METAL_LIST_PAINTING_PF);
		assertEquals(285.85, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(285.85, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
		assertEquals(343.11, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(343.11, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcInnerDecorationWithoutTopSideTransom(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
		assertEquals(357.13, singleDoorTopSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(357.13, singleDoorTopSideTransom.getTotalPrice(), DELTA);
	}

	@org.junit.Test
	public void testCalcPlatband() throws Exception {
		assertEquals(singleDoorTopSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopSideTransom.calcPlatband(PlatbandType.WOODEN);
		assertEquals(60.50, singleDoorTopSideTransom.getPlatbandPrice(), DELTA);
		assertEquals(60.50, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcPlatband(PlatbandType.METAL_PAINTING_PF);
		assertEquals(132.55, singleDoorTopSideTransom.getPlatbandPrice(), DELTA);
		assertEquals(132.55, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcPlatband(PlatbandType.METAL_PAINTING_SHAGREEN);
		assertEquals(147.95, singleDoorTopSideTransom.getPlatbandPrice(), DELTA);
		assertEquals(147.95, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcPlatband(PlatbandType.METAL_PAINTING_ANTIC);
		assertEquals(151.80, singleDoorTopSideTransom.getPlatbandPrice(), DELTA);
		assertEquals(151.80, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcPlatband(PlatbandType.MDF10);
		assertEquals(38.50, singleDoorTopSideTransom.getPlatbandPrice(), DELTA);
		assertEquals(38.50, singleDoorTopSideTransom.getTotalPrice(), DELTA);
		singleDoorTopSideTransom.calcPlatband(PlatbandType.MDF16);
		assertEquals(77, singleDoorTopSideTransom.getPlatbandPrice(), DELTA);
		assertEquals(77, singleDoorTopSideTransom.getTotalPrice(), DELTA);
	}
}
