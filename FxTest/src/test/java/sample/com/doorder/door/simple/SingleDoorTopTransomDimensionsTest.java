package sample.com.doorder.door.simple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingleDoorTopTransomDimensionsTest extends Assert {

	private SingleDoorTopTransom singleDoorTopTransom;

	@Before
	public void setUp() throws Exception {
		this.singleDoorTopTransom = new SingleDoorTopTransom();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testcalcL50x4PartLessWidth() throws Exception {
		singleDoorTopTransom.setHeight(2000);
		singleDoorTopTransom.setWidth(499);
		singleDoorTopTransom.setHeightTransom(1500);
		singleDoorTopTransom.calcMetalFrameParts();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testcalcL50x4PartMoreWidth() throws Exception {
		singleDoorTopTransom.setHeight(2000);
		singleDoorTopTransom.setWidth(1201);
		singleDoorTopTransom.setHeightTransom(1500);
		singleDoorTopTransom.calcMetalFrameParts();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testcalcL50x4PartLessHeight() throws Exception {
		singleDoorTopTransom.setHeight(999);
		singleDoorTopTransom.setWidth(500);
		singleDoorTopTransom.setHeightTransom(1500);
		singleDoorTopTransom.calcMetalFrameParts();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testcalcL50x4PartMoreHeight() throws Exception {
		singleDoorTopTransom.setHeight(3001);
		singleDoorTopTransom.setWidth(1200);
		singleDoorTopTransom.setHeightTransom(1500);
		singleDoorTopTransom.calcMetalFrameParts();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testcalcL50x4PartLessHeightTransom() throws Exception {
		singleDoorTopTransom.setHeight(1000);
		singleDoorTopTransom.setWidth(500);
		singleDoorTopTransom.setHeightTransom(999);
		singleDoorTopTransom.calcMetalFrameParts();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testcalcL50x4PartMoreHeightTransom() throws Exception {
		singleDoorTopTransom.setHeight(3000);
		singleDoorTopTransom.setWidth(1200);
		singleDoorTopTransom.setHeightTransom(2451);
		singleDoorTopTransom.calcMetalFrameParts();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testcalcL50x4PartLessHeights() throws Exception {
		singleDoorTopTransom.setHeight(1000);
		singleDoorTopTransom.setWidth(500);
		singleDoorTopTransom.setHeightTransom(1000);
		singleDoorTopTransom.calcMetalFrameParts();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testcalcL50x4PartMoreHeights() throws Exception {
		singleDoorTopTransom.setHeight(3000);
		singleDoorTopTransom.setWidth(1200);
		singleDoorTopTransom.setHeightTransom(1000);
		singleDoorTopTransom.calcMetalFrameParts();
	}
}
