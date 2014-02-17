package sample.com.doorder.door.simple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.com.doorder.door.OuterDecorationType;

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
		singleDoorTopTransom.setHeight(2000);
		singleDoorTopTransom.setWidth(1000);
		singleDoorTopTransom.setHeightTransom(1500);
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
		singleDoorTopTransom.setHeight(2000);
		singleDoorTopTransom.setWidth(1000);
		singleDoorTopTransom.setHeightTransom(1500);
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.calcMetalList();
		assertEquals(175, singleDoorTopTransom.getMetalListPrice(), DELTA);
		assertEquals(175, singleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcMetalList1() throws Exception {
		singleDoorTopTransom.setHeight(2000);
		singleDoorTopTransom.setWidth(800);
		singleDoorTopTransom.setHeightTransom(1500);
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.calcMetalList();
		assertEquals(220, singleDoorTopTransom.getMetalListPrice(), DELTA);
		assertEquals(220, singleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcHinge() throws Exception {
		singleDoorTopTransom.setHeight(2000);
		singleDoorTopTransom.setWidth(1000);
		singleDoorTopTransom.setHeightTransom(1500);
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.calcHinge();
		assertEquals(24, singleDoorTopTransom.getHingePrice(), DELTA);
		assertEquals(24, singleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@org.junit.Test
	public void testCalcHeaterIncluded() throws Exception {
		singleDoorTopTransom.setHeight(2000);
		singleDoorTopTransom.setWidth(1000);
		singleDoorTopTransom.setHeightTransom(1500);
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.calcHeater(true);
		assertEquals(24, singleDoorTopTransom.getHeaterPrice(), DELTA);
		assertEquals(24, singleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcSealIncluded() throws Exception {
		singleDoorTopTransom.setHeight(2000);
		singleDoorTopTransom.setWidth(1000);
		singleDoorTopTransom.setHeightTransom(1500);
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.calcSeal(true);
		assertEquals(60, singleDoorTopTransom.getSealPrice(), DELTA);
		assertEquals(60, singleDoorTopTransom.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcOuterDecoration() throws Exception {
		singleDoorTopTransom.setHeight(2000);
		singleDoorTopTransom.setWidth(1000);
		singleDoorTopTransom.setHeightTransom(1500);
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
		singleDoorTopTransom.setHeight(2000);
		singleDoorTopTransom.setWidth(1000);
		singleDoorTopTransom.setHeightTransom(1500);
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
}
