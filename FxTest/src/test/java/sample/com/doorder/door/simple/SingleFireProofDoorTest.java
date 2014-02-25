package sample.com.doorder.door.simple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.com.doorder.door.InnerDecorationType;
import sample.com.doorder.door.OuterDecorationType;
import sample.com.doorder.door.PlatbandType;

public class SingleFireProofDoorTest extends Assert {

	private static final double DELTA = 1e-12;
	
	SingleFireProofDoor singleFireProofDoor;

	@Before
	public void setUp() throws Exception {
		this.singleFireProofDoor = new SingleFireProofDoor();
		this.singleFireProofDoor.setX(1050);
		this.singleFireProofDoor.setY(2100);
		this.singleFireProofDoor.setX_1(1000);
	}

	@Test
	public void testCalcMetalFrameParts() throws Exception {
		assertEquals(singleFireProofDoor.getTotalPrice(), 0.0, DELTA);
		singleFireProofDoor.calcMetalFrameParts();
		assertEquals(singleFireProofDoor.getMetal_40x40_Price(), 693, DELTA);
		assertEquals(singleFireProofDoor.getMetal_40x20_Price(), 127.63, DELTA);
		assertEquals(singleFireProofDoor.getMetalFramesPartsTotalPrice(), 820.63, DELTA);
		assertEquals(singleFireProofDoor.getMetalFramesPartsTotalPrice(),
				singleFireProofDoor.getMetal_40x40_Price() + singleFireProofDoor.getMetal_40x20_Price(), DELTA);
		assertEquals(singleFireProofDoor.getTotalPrice(), singleFireProofDoor.getMetalFramesPartsTotalPrice(), DELTA);
	}

	@Test
	public void testCalcInnerMetalList() throws Exception {
		assertEquals(singleFireProofDoor.getTotalPrice(), 0.0, DELTA);
		singleFireProofDoor.calcInnerMetalList();
		assertEquals(150, singleFireProofDoor.getInnerMetalListPrice(), DELTA);
		assertEquals(150, singleFireProofDoor.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcOuterMetalList() throws Exception {
		assertEquals(singleFireProofDoor.getTotalPrice(), 0.0, DELTA);
		singleFireProofDoor.calcOuterMetalList();
		assertEquals(100, singleFireProofDoor.getOuterMetalListPrice(), DELTA);
		assertEquals(100, singleFireProofDoor.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcHinge() throws Exception {
		assertEquals(singleFireProofDoor.getTotalPrice(), 0.0, DELTA);
		singleFireProofDoor.calcHinge();
		assertEquals(36, singleFireProofDoor.getHingePrice(), DELTA);
		assertEquals(36, singleFireProofDoor.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcOgrask() throws Exception {
		assertEquals(singleFireProofDoor.getTotalPrice(), 0.0, DELTA);
		singleFireProofDoor.calcOgrask();
		assertEquals(126, singleFireProofDoor.getOgraskPrice(), DELTA);
		assertEquals(126, singleFireProofDoor.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcDryWall() throws Exception {
		assertEquals(singleFireProofDoor.getTotalPrice(), 0.0, DELTA);
		singleFireProofDoor.calcDryWall();
		assertEquals(61.74, singleFireProofDoor.getDryWallPrice(), DELTA);
		assertEquals(61.74, singleFireProofDoor.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcMineralWool() throws Exception {
		assertEquals(singleFireProofDoor.getTotalPrice(), 0.0, DELTA);
		singleFireProofDoor.calcMineralWool();
		assertEquals(22.05, singleFireProofDoor.getMineralWoolPrice(), DELTA);
		assertEquals(22.05, singleFireProofDoor.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcSeal() throws Exception {
		assertEquals(singleFireProofDoor.getTotalPrice(), 0.0, DELTA);
		singleFireProofDoor.calcSeal();
		assertEquals(75.60, singleFireProofDoor.getSealPrice(), DELTA);
		assertEquals(75.60, singleFireProofDoor.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcOuterDecoration() throws Exception {
		assertEquals(singleFireProofDoor.getTotalPrice(), 0.0, DELTA);
		singleFireProofDoor.calcOuterDecoration(OuterDecorationType.SELF_ADHESIVE_FILM);
		assertEquals(157.50, singleFireProofDoor.getOuterDecorationPrice(), DELTA);
		assertEquals(157.50, singleFireProofDoor.getTotalPrice(), DELTA);
		singleFireProofDoor.calcOuterDecoration(OuterDecorationType.PAINTING_SHAGREEN);
		assertEquals(242.55, singleFireProofDoor.getOuterDecorationPrice(), DELTA);
		assertEquals(242.55, singleFireProofDoor.getTotalPrice(), DELTA);
		singleFireProofDoor.calcOuterDecoration(OuterDecorationType.PAINTING_ANTIC);
		assertEquals(277.20, singleFireProofDoor.getOuterDecorationPrice(), DELTA);
		assertEquals(277.20, singleFireProofDoor.getTotalPrice(), DELTA);
		singleFireProofDoor.calcOuterDecoration(OuterDecorationType.PAINTING_PF);
		assertEquals(103.95, singleFireProofDoor.getOuterDecorationPrice(), DELTA);
		assertEquals(103.95, singleFireProofDoor.getTotalPrice(), DELTA);
		singleFireProofDoor.calcOuterDecoration(OuterDecorationType.ANTI_LAYER);
		assertEquals(119.70, singleFireProofDoor.getOuterDecorationPrice(), DELTA);
		assertEquals(119.70, singleFireProofDoor.getTotalPrice(), DELTA);
		singleFireProofDoor.calcOuterDecoration(OuterDecorationType.MDF10);
		assertEquals(348.70, singleFireProofDoor.getOuterDecorationPrice(), DELTA);
		assertEquals(348.70, singleFireProofDoor.getTotalPrice(), DELTA);
		singleFireProofDoor.calcOuterDecoration(OuterDecorationType.MDF16);
		assertEquals(569.20, singleFireProofDoor.getOuterDecorationPrice(), DELTA);
		assertEquals(569.20, singleFireProofDoor.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcInnerDecoration() throws Exception {
		assertEquals(singleFireProofDoor.getTotalPrice(), 0.0, DELTA);
		singleFireProofDoor.calcInnerDecoration(InnerDecorationType.MDF10);
		assertEquals(248.06, singleFireProofDoor.getInnerDecorationPrice(), DELTA);
		assertEquals(248.06, singleFireProofDoor.getTotalPrice(), DELTA);
		singleFireProofDoor.calcInnerDecoration(InnerDecorationType.MDF16);
		assertEquals(456.12, singleFireProofDoor.getInnerDecorationPrice(), DELTA);
		assertEquals(456.12, singleFireProofDoor.getTotalPrice(), DELTA);
		singleFireProofDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_PF);
		assertEquals(62.42, singleFireProofDoor.getInnerDecorationPrice(), DELTA);
		assertEquals(62.42, singleFireProofDoor.getTotalPrice(), DELTA);
		singleFireProofDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
		assertEquals(145.64, singleFireProofDoor.getInnerDecorationPrice(), DELTA);
		assertEquals(145.64, singleFireProofDoor.getTotalPrice(), DELTA);
		singleFireProofDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
		assertEquals(166.45, singleFireProofDoor.getInnerDecorationPrice(), DELTA);
		assertEquals(166.45, singleFireProofDoor.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcPlatband() throws Exception {
		assertEquals(singleFireProofDoor.getTotalPrice(), 0.0, DELTA);
		singleFireProofDoor.calcPlatband(PlatbandType.METAL_PAINTING_PF);
		assertEquals(126.53, singleFireProofDoor.getPlatbandPrice(), DELTA);
		assertEquals(126.53, singleFireProofDoor.getTotalPrice(), DELTA);
		singleFireProofDoor.calcPlatband(PlatbandType.METAL_PAINTING_SHAGREEN);
		assertEquals(141.23, singleFireProofDoor.getPlatbandPrice(), DELTA);
		assertEquals(141.23, singleFireProofDoor.getTotalPrice(), DELTA);
		singleFireProofDoor.calcPlatband(PlatbandType.METAL_PAINTING_ANTIC);
		assertEquals(144.90, singleFireProofDoor.getPlatbandPrice(), DELTA);
		assertEquals(144.90, singleFireProofDoor.getTotalPrice(), DELTA);
	}

	@Test
	public void testCalcAccessories() throws Exception {

	}
}
