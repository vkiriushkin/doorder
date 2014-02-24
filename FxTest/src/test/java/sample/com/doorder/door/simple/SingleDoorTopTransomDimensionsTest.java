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
		singleDoorTopTransom.setY(2000);
		singleDoorTopTransom.setX(499);
		singleDoorTopTransom.setY_1(1500);
		singleDoorTopTransom.calcMetalFrameParts();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testcalcL50x4PartMoreWidth() throws Exception {
		singleDoorTopTransom.setY(2000);
		singleDoorTopTransom.setX(1201);
		singleDoorTopTransom.setY_1(1500);
		singleDoorTopTransom.calcMetalFrameParts();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testcalcL50x4PartLessHeight() throws Exception {
		singleDoorTopTransom.setY(999);
		singleDoorTopTransom.setX(500);
		singleDoorTopTransom.setY_1(1500);
		singleDoorTopTransom.calcMetalFrameParts();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testcalcL50x4PartMoreHeight() throws Exception {
		singleDoorTopTransom.setY(3001);
		singleDoorTopTransom.setX(1200);
		singleDoorTopTransom.setY_1(1500);
		singleDoorTopTransom.calcMetalFrameParts();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testcalcL50x4PartLessHeightTransom() throws Exception {
		singleDoorTopTransom.setY(1000);
		singleDoorTopTransom.setX(500);
		singleDoorTopTransom.setY_1(999);
		singleDoorTopTransom.calcMetalFrameParts();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testcalcL50x4PartMoreHeightTransom() throws Exception {
		singleDoorTopTransom.setY(3000);
		singleDoorTopTransom.setX(1200);
		singleDoorTopTransom.setY_1(2451);
		singleDoorTopTransom.calcMetalFrameParts();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testcalcL50x4PartLessHeights() throws Exception {
		singleDoorTopTransom.setY(1000);
		singleDoorTopTransom.setX(500);
		singleDoorTopTransom.setY_1(1000);
		singleDoorTopTransom.calcMetalFrameParts();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testcalcL50x4PartMoreHeights() throws Exception {
		singleDoorTopTransom.setY(3000);
		singleDoorTopTransom.setX(1200);
		singleDoorTopTransom.setY_1(1000);
		singleDoorTopTransom.calcMetalFrameParts();
	}
}
