package sample.com.doorder.door.simple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InnerDecorationDimansionsTest extends Assert {

	private InnerDecoration innerDecoration;
	@Before
	public void setUp() {
		innerDecoration = new InnerDecoration();
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcMDF10WidthLessExceptions() throws Exception {
		innerDecoration.calcMdf10(500,900);
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcMDF10WidthMoreExceptions() throws Exception {
		innerDecoration.calcMdf10(1200, 2400);
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcMDF16WidthLessExceptions() throws Exception {
		innerDecoration.calcMdf16(500,900);
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcMDF16WidthMoreExceptions() throws Exception {
		innerDecoration.calcMdf16(1200, 2400);
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcPaintingPFWidthLessExceptions() throws Exception {
		innerDecoration.calcPaintingPF(500,900);
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcPaintingPFWidthMoreExceptions() throws Exception {
		innerDecoration.calcPaintingPF(1300, 2400);
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcPaintingPFHeightLessExceptions() throws Exception {
		innerDecoration.calcPaintingPF(500,1000);
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcPaintingPFHeightMoreExceptions() throws Exception {
		innerDecoration.calcPaintingPF(1000, 2500);
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcPaintingShagreenWidthLessExceptions() throws Exception {
		innerDecoration.calcPaintingShagreen(500,900);
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcPaintingShagreenWidthMoreExceptions() throws Exception {
		innerDecoration.calcPaintingShagreen(1300, 2400);
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcPaintingShagreenHeightLessExceptions() throws Exception {
		innerDecoration.calcPaintingShagreen(500,1000);
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcPaintingShagreenHeightMoreExceptions() throws Exception {
		innerDecoration.calcPaintingShagreen(1000, 2500);
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcPaintingAnticWidthLessExceptions() throws Exception {
		innerDecoration.calcPaintingAntic(500,900);
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcPaintingAnticWidthMoreExceptions() throws Exception {
		innerDecoration.calcPaintingAntic(1300, 2400);
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcPaintingAnticHeightLessExceptions() throws Exception {
		innerDecoration.calcPaintingAntic(500,1000);
	}

	@Test(expected = UnsupportedDimensions.class)
	public void testCalcPaintingAnticHeightMoreExceptions() throws Exception {
		innerDecoration.calcPaintingAntic(1000, 2500);
	}
}
