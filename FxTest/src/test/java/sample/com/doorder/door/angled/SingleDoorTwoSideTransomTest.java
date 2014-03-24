package sample.com.doorder.door.angled;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.com.doorder.door.types.InnerDecorationType;
import sample.com.doorder.door.types.OuterDecorationType;
import sample.com.doorder.door.types.PlatbandType;

public class SingleDoorTwoSideTransomTest extends Assert {

	private static final double DELTA = 1e-12;

	SingleDoorTwoSideTransom singleDoorTwoSideTransom;

	@Before
	public void setUp() throws Exception {
		singleDoorTwoSideTransom = new SingleDoorTwoSideTransom();
		singleDoorTwoSideTransom.setX(1000);
		singleDoorTwoSideTransom.setY(2000);
		singleDoorTwoSideTransom.setX_1(500);
		singleDoorTwoSideTransom.setZ(70);
	}

	@Test
	public void testCalcMetalFrameParts() throws Exception {
		assertEquals(singleDoorTwoSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTwoSideTransom.calcMetalFrameParts();
		assertEquals(66.66, singleDoorTwoSideTransom.getMetal_L50x4_Price(), DELTA);
		assertEquals(400, singleDoorTwoSideTransom.getMetal_40x40_Price(),DELTA);
		assertEquals(42.50, singleDoorTwoSideTransom.getMetal_40x20_Price(), DELTA);
		assertEquals(42.90, singleDoorTwoSideTransom.getMetal_20x20_Price(), DELTA);
		assertEquals(552.06, singleDoorTwoSideTransom.getMetalFramesPartsTotalPrice(), DELTA);
		assertEquals(singleDoorTwoSideTransom.getMetalFramesPartsTotalPrice(),
				singleDoorTwoSideTransom.getMetal_L50x4_Price() + singleDoorTwoSideTransom.getMetal_40x40_Price() +
						singleDoorTwoSideTransom.getMetal_40x20_Price() + singleDoorTwoSideTransom.getMetal_20x20_Price(), DELTA);
		assertEquals(singleDoorTwoSideTransom.getTotalPrice(), singleDoorTwoSideTransom.getMetalFramesPartsTotalPrice(), DELTA);
	}

	@Test
	public void testCalcMetalList() throws Exception {
		assertEquals(singleDoorTwoSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTwoSideTransom.calcMetalList();
		assertEquals(250, singleDoorTwoSideTransom.getMetalListPrice(), DELTA);
		assertEquals(250, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcHinge() throws Exception {
		assertEquals(singleDoorTwoSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTwoSideTransom.calcHinge();
		assertEquals(24, singleDoorTwoSideTransom.getHingePrice(), DELTA);
		assertEquals(24, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
	}

	@org.junit.Test
	public void testCalcHeaterIncluded() throws Exception {
		assertEquals(singleDoorTwoSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTwoSideTransom.calcHeater(true);
		assertEquals(24, singleDoorTwoSideTransom.getHeaterPrice(), DELTA);
		assertEquals(24, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcSealIncluded() throws Exception {
		assertEquals(singleDoorTwoSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTwoSideTransom.calcSeal(true);
		assertEquals(60, singleDoorTwoSideTransom.getSealPrice(), DELTA);
		assertEquals(60, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcOuterDecoration() throws Exception {
		assertEquals(singleDoorTwoSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTwoSideTransom.calcOuterDecoration(OuterDecorationType.SELF_ADHESIVE_FILM);
		assertEquals(164, singleDoorTwoSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(164, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcOuterDecoration(OuterDecorationType.PAINTING_SHAGREEN);
		assertEquals(238, singleDoorTwoSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(238, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcOuterDecoration(OuterDecorationType.PAINTING_ANTIC);
		assertEquals(272, singleDoorTwoSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(272, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcOuterDecoration(OuterDecorationType.PAINTING_PF);
		assertEquals(102, singleDoorTwoSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(102, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcOuterDecoration(OuterDecorationType.ANTI_LAYER);
		assertEquals(128, singleDoorTwoSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(128, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcOuterDecoration(OuterDecorationType.MDF10);
		assertEquals(298, singleDoorTwoSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(298, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcOuterDecoration(OuterDecorationType.MDF16);
		assertEquals(498, singleDoorTwoSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(498, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcOuterDecorationWithoutTopTransom() throws Exception {
		assertEquals(singleDoorTwoSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTwoSideTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.SELF_ADHESIVE_FILM);
		assertEquals(172, singleDoorTwoSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(172, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.PAINTING_SHAGREEN);
		assertEquals(156, singleDoorTwoSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(156, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.PAINTING_ANTIC);
		assertEquals(174, singleDoorTwoSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(174, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.PAINTING_PF);
		assertEquals(84, singleDoorTwoSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(84, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.ANTI_LAYER);
		assertEquals(158, singleDoorTwoSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(158, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.MDF10);
		assertEquals(228, singleDoorTwoSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(228, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.MDF16);
		assertEquals(328, singleDoorTwoSideTransom.getOuterDecorationPrice(), DELTA);
		assertEquals(328, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
	}

	@org.junit.Test
	public void testCalcInnerDecoration() throws Exception {
		singleDoorTwoSideTransom.setX(1500);
		singleDoorTwoSideTransom.setX_1(1000);
		assertEquals(singleDoorTwoSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTwoSideTransom.calcInnerDecoration(InnerDecorationType.PLASTIC);
		assertEquals(567.60, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(567.60, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcInnerDecoration(InnerDecorationType.LAMINATED_PLASTIC);
		assertEquals(693, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(693, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcInnerDecoration(InnerDecorationType.MDF10);
		assertEquals(286.16, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(286.16, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcInnerDecoration(InnerDecorationType.MDF16);
		assertEquals(572.32, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(572.32, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcInnerDecoration(InnerDecorationType.NO_DECORATION);
		assertEquals(90, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(90, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_PF);
		assertEquals(335.85, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(335.85, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
		assertEquals(450.31, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(450.31, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
		assertEquals(478.93, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(478.93, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
	}

	@org.junit.Test
	public void testCalcInnerDecorationWithoutTopTransom() throws Exception {
		singleDoorTwoSideTransom.setX(1500);
		singleDoorTwoSideTransom.setX_1(1000);
		assertEquals(singleDoorTwoSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTwoSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.PLASTIC);
		assertEquals(355.6, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(355.6, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.LAMINATED_PLASTIC);
		assertEquals(439.20, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(439.20, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.MDF10);
		assertEquals(218.16, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(218.16, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.MDF16);
		assertEquals(406.32, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(406.32, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.NO_DECORATION);
		assertEquals(90, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(90, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.METAL_LIST_PAINTING_PF);
		assertEquals(285.85, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(285.85, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
		assertEquals(361.71, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(361.71, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
		assertEquals(380.53, singleDoorTwoSideTransom.getInnerDecorationPrice(), DELTA);
		assertEquals(380.53, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
	}

	@org.junit.Test
	public void testCalcPlatband() throws Exception {
		assertEquals(singleDoorTwoSideTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTwoSideTransom.calcPlatband(PlatbandType.WOODEN);
		assertEquals(55, singleDoorTwoSideTransom.getPlatbandPrice(), DELTA);
		assertEquals(55, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcPlatband(PlatbandType.METAL_PAINTING_PF);
		assertEquals(120.50, singleDoorTwoSideTransom.getPlatbandPrice(), DELTA);
		assertEquals(120.50, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcPlatband(PlatbandType.METAL_PAINTING_SHAGREEN);
		assertEquals(134.50, singleDoorTwoSideTransom.getPlatbandPrice(), DELTA);
		assertEquals(134.50, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcPlatband(PlatbandType.METAL_PAINTING_ANTIC);
		assertEquals(138, singleDoorTwoSideTransom.getPlatbandPrice(), DELTA);
		assertEquals(138, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcPlatband(PlatbandType.MDF10);
		assertEquals(35, singleDoorTwoSideTransom.getPlatbandPrice(), DELTA);
		assertEquals(35, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
		singleDoorTwoSideTransom.calcPlatband(PlatbandType.MDF16);
		assertEquals(70, singleDoorTwoSideTransom.getPlatbandPrice(), DELTA);
		assertEquals(70, singleDoorTwoSideTransom.getTotalPrice(), DELTA);
	}
}
