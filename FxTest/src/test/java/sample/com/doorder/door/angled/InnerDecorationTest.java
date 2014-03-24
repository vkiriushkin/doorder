package sample.com.doorder.door.angled;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InnerDecorationTest extends Assert {

	private static final double DELTA = 1e-12;

	private InnerDecoration innerDecoration;

    @Before
    public void setUp() throws Exception {
		innerDecoration = new InnerDecoration();
    }

    @Test
    public void testCalcPlastic() throws Exception {
		innerDecoration.calcPlastic(1000, 2000);
	    assertEquals(325.60, innerDecoration.getTotalInnerDecorationPrice(), DELTA);
    }

    @Test
    public void testCalcLaminate() throws Exception {
	    innerDecoration.calcLaminate(1000, 2000);
	    assertEquals(409.20, innerDecoration.getTotalInnerDecorationPrice(), DELTA);
    }

    @Test
    public void testCalcMdf10() throws Exception {
	    innerDecoration.calcMdf10(1000, 2000);
	    assertEquals(188.16, innerDecoration.getTotalInnerDecorationPrice(), DELTA);
    }

    @Test
    public void testCalcMdf16() throws Exception {
	    innerDecoration.calcMdf16(1000, 2000);
	    assertEquals(376.32, innerDecoration.getTotalInnerDecorationPrice(), DELTA);
    }

    @Test
    public void testCalcWithoutDecoration() throws Exception {
	    innerDecoration.calcWithoutDecoration(1000, 2000);
	    assertEquals(60, innerDecoration.getTotalInnerDecorationPrice(), DELTA);
    }

    @Test
    public void testCalcPaintingPF() throws Exception {
	    innerDecoration.calcPaintingPF(1000, 2000);
	    assertEquals(256.45, innerDecoration.getTotalInnerDecorationPrice(), DELTA);
    }

    @Test
    public void testCalcPaintingShagreen() throws Exception {
	    innerDecoration.calcPaintingShagreen(1000, 2000);
	    assertEquals(331.71, innerDecoration.getTotalInnerDecorationPrice(), DELTA);
    }

    @Test
    public void testCalcPaintingAntic() throws Exception {
	    innerDecoration.calcPaintingAntic(1000, 2000);
	    assertEquals(350.53, innerDecoration.getTotalInnerDecorationPrice(), DELTA);
    }
}
