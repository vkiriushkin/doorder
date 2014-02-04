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
}
