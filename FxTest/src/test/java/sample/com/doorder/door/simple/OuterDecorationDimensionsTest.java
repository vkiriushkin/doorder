package sample.com.doorder.door.simple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OuterDecorationDimensionsTest extends Assert {

    private OuterDecoration outerDecoration;

    @Before
    public void setUp() {
        outerDecoration = new OuterDecoration();
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcSelfAdhesiveFilmWidthLessExceptions() throws Exception {
        outerDecoration.calcSelfAdhesiveFilm(499,2000);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcSelfAdhesiveFilmWidthMoreExceptions() throws Exception {
        outerDecoration.calcSelfAdhesiveFilm(1201, 2000);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcAntiLayerWidthLessExceptions() throws Exception {
        outerDecoration.calcAntiLayer(499,2000);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcAntiLayerWidthMoreExceptions() throws Exception {
        outerDecoration.calcAntiLayer(1201, 2000);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMDF10WidthLessExceptions() throws Exception {
        outerDecoration.calcMdf10(500,999);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMDF10WidthMoreExceptions() throws Exception {
        outerDecoration.calcMdf10(1200, 2351);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMDF16WidthLessExceptions() throws Exception {
        outerDecoration.calcMdf16(500,999);
    }

    @Test(expected = UnsupportedDimensions.class)
    public void testCalcMDF16WidthMoreExceptions() throws Exception {
        outerDecoration.calcMdf16(1200, 2351);
    }
}
