package sample.com.doorder.door.simple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OuterDecorationTest extends Assert {

    private static final double DELTA = 1e-12;

    private OuterDecoration outerDecoration;

    @Before
    public void setUp() throws Exception {
        this.outerDecoration = new OuterDecoration();
    }

    @Test
    public void testCalcSelfAdhesiveFilm() throws Exception {
        outerDecoration.calcSelfAdhesiveFilm(1000, 2000);
        assertEquals(150.0, outerDecoration.getTotalOuterDecorationPrice(), DELTA);
    }

    @Test
    public void testCalcPaintingShagreen() throws Exception {
        outerDecoration.calcPaintingShagreen(1000, 2000);
        assertEquals(207.20, outerDecoration.getTotalOuterDecorationPrice(), DELTA);
    }

    @Test
    public void testCalcPaintingAntic() throws Exception {
        outerDecoration.calcPaintingAntic(1000, 2000);
        assertEquals(236.80, outerDecoration.getTotalOuterDecorationPrice(), DELTA);
    }

    @Test
    public void testCalcPaintinPF() throws Exception {
        outerDecoration.calcPaintingPF(1000, 2000);
        assertEquals(88.80, outerDecoration.getTotalOuterDecorationPrice(), DELTA);
    }

    @Test
    public void testCalcAntiLayer() throws Exception {
        outerDecoration.calcAntiLayer(1000, 2000);
        assertEquals(114.0, outerDecoration.getTotalOuterDecorationPrice(), DELTA);
    }

    @Test
    public void testCalcMdf10() throws Exception {
        outerDecoration.calcMdf10(1000, 2000);
        assertEquals(284.0, outerDecoration.getTotalOuterDecorationPrice(), DELTA);
    }

    @Test
    public void testCalcMdf16() throws Exception {
        outerDecoration.calcMdf16(1000, 2000);
        assertEquals(484.0, outerDecoration.getTotalOuterDecorationPrice(), DELTA);
    }
}
