package sample.com.doorder.door.simple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
	public void testCalcOuterFacing() throws Exception {
		singleDoorTopTransom.setHeight(2000);
		singleDoorTopTransom.setWidth(1000);
		singleDoorTopTransom.setHeightTransom(1500);
		assertEquals(singleDoorTopTransom.getTotalPrice(), 0.0, DELTA);
		singleDoorTopTransom.getOuterDecoration().calcSelfAdhesiveFilm((int)singleDoorTopTransom.getWidth(), (int)singleDoorTopTransom.getHeight());
//		assertEquals(60, singleDoorTopTransom.getOuterDecoration().g, DELTA);
		assertEquals(60, singleDoorTopTransom.getTotalPrice(), DELTA);
	}
}
