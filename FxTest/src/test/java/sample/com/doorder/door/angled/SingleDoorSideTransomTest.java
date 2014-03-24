package sample.com.doorder.door.angled;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.com.doorder.door.types.InnerDecorationType;
import sample.com.doorder.door.types.OuterDecorationType;
import sample.com.doorder.door.types.PlatbandType;

public class SingleDoorSideTransomTest extends Assert {

    private static final double DELTA = 1e-12;
    
    SingleDoorSideTransom singleDoorSideTransom;

    @Before
    public void setUp() throws Exception {
        singleDoorSideTransom = new SingleDoorSideTransom();
        singleDoorSideTransom.setX(1000);
        singleDoorSideTransom.setY(2000);
        singleDoorSideTransom.setX_1(500);
        singleDoorSideTransom.setZ(70);
    }

    @Test
    public void testCalcMetalFrameParts() throws Exception {
        assertEquals(singleDoorSideTransom.getTotalPrice(), 0.0, DELTA);
        singleDoorSideTransom.calcMetalFrameParts();
        assertEquals(66.66, singleDoorSideTransom.getMetal_L50x4_Price(), DELTA);
        assertEquals(200, singleDoorSideTransom.getMetal_40x40_Price(),DELTA);
        assertEquals(46.75, singleDoorSideTransom.getMetal_40x20_Price(), DELTA);
        assertEquals(42.90, singleDoorSideTransom.getMetal_20x20_Price(), DELTA);
        assertEquals(356.31, singleDoorSideTransom.getMetalFramesPartsTotalPrice(), DELTA);
        assertEquals(singleDoorSideTransom.getMetalFramesPartsTotalPrice(),
                singleDoorSideTransom.getMetal_L50x4_Price() + singleDoorSideTransom.getMetal_40x40_Price() +
                        singleDoorSideTransom.getMetal_40x20_Price() + singleDoorSideTransom.getMetal_20x20_Price(), DELTA);
        assertEquals(singleDoorSideTransom.getTotalPrice(), singleDoorSideTransom.getMetalFramesPartsTotalPrice(), DELTA);
    }

    @Test
    public void testCalcMetalList() throws Exception {
        assertEquals(singleDoorSideTransom.getTotalPrice(), 0.0, DELTA);
        singleDoorSideTransom.calcMetalList();
        assertEquals(150, singleDoorSideTransom.getMetalListPrice(), DELTA);
        assertEquals(150, singleDoorSideTransom.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcHinge() throws Exception {
        assertEquals(singleDoorSideTransom.getTotalPrice(), 0.0, DELTA);
        singleDoorSideTransom.calcHinge();
        assertEquals(24, singleDoorSideTransom.getHingePrice(), DELTA);
        assertEquals(24, singleDoorSideTransom.getTotalPrice(), DELTA);
    }

    @org.junit.Test
    public void testCalcHeaterIncluded() throws Exception {
        assertEquals(singleDoorSideTransom.getTotalPrice(), 0.0, DELTA);
        singleDoorSideTransom.calcHeater(true);
        assertEquals(24, singleDoorSideTransom.getHeaterPrice(), DELTA);
        assertEquals(24, singleDoorSideTransom.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcSealIncluded() throws Exception {
        assertEquals(singleDoorSideTransom.getTotalPrice(), 0.0, DELTA);
        singleDoorSideTransom.calcSeal(true);
        assertEquals(60, singleDoorSideTransom.getSealPrice(), DELTA);
        assertEquals(60, singleDoorSideTransom.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcOuterDecoration() throws Exception {
        assertEquals(singleDoorSideTransom.getTotalPrice(), 0.0, DELTA);
        singleDoorSideTransom.calcOuterDecoration(OuterDecorationType.SELF_ADHESIVE_FILM);
        assertEquals(164, singleDoorSideTransom.getOuterDecorationPrice(), DELTA);
        assertEquals(164, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcOuterDecoration(OuterDecorationType.PAINTING_SHAGREEN);
        assertEquals(224, singleDoorSideTransom.getOuterDecorationPrice(), DELTA);
        assertEquals(224, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcOuterDecoration(OuterDecorationType.PAINTING_ANTIC);
        assertEquals(256, singleDoorSideTransom.getOuterDecorationPrice(), DELTA);
        assertEquals(256, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcOuterDecoration(OuterDecorationType.PAINTING_PF);
        assertEquals(96, singleDoorSideTransom.getOuterDecorationPrice(), DELTA);
        assertEquals(96, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcOuterDecoration(OuterDecorationType.ANTI_LAYER);
        assertEquals(128, singleDoorSideTransom.getOuterDecorationPrice(), DELTA);
        assertEquals(128, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcOuterDecoration(OuterDecorationType.MDF10);
        assertEquals(298, singleDoorSideTransom.getOuterDecorationPrice(), DELTA);
        assertEquals(298, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcOuterDecoration(OuterDecorationType.MDF16);
        assertEquals(498, singleDoorSideTransom.getOuterDecorationPrice(), DELTA);
        assertEquals(498, singleDoorSideTransom.getTotalPrice(), DELTA);
    }

    @Test
    public void testCalcOuterDecorationWithoutTopTransom() throws Exception {
        assertEquals(singleDoorSideTransom.getTotalPrice(), 0.0, DELTA);
        singleDoorSideTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.SELF_ADHESIVE_FILM);
        assertEquals(172, singleDoorSideTransom.getOuterDecorationPrice(), DELTA);
        assertEquals(172, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.PAINTING_SHAGREEN);
        assertEquals(172.80, singleDoorSideTransom.getOuterDecorationPrice(), DELTA);
        assertEquals(172.80, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.PAINTING_ANTIC);
        assertEquals(193.20, singleDoorSideTransom.getOuterDecorationPrice(), DELTA);
        assertEquals(193.20, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.PAINTING_PF);
        assertEquals(91.20, singleDoorSideTransom.getOuterDecorationPrice(), DELTA);
        assertEquals(91.20, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.ANTI_LAYER);
        assertEquals(158, singleDoorSideTransom.getOuterDecorationPrice(), DELTA);
        assertEquals(158, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.MDF10);
        assertEquals(228, singleDoorSideTransom.getOuterDecorationPrice(), DELTA);
        assertEquals(228, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcOuterDecorationWithoutTopTransom(OuterDecorationType.MDF16);
        assertEquals(328, singleDoorSideTransom.getOuterDecorationPrice(), DELTA);
        assertEquals(328, singleDoorSideTransom.getTotalPrice(), DELTA);
    }

    @org.junit.Test
    public void testCalcInnerDecoration() throws Exception {
        assertEquals(singleDoorSideTransom.getTotalPrice(), 0.0, DELTA);
        singleDoorSideTransom.calcInnerDecoration(InnerDecorationType.PLASTIC);
        assertEquals(378.40, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(378.40, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcInnerDecoration(InnerDecorationType.LAMINATED_PLASTIC);
        assertEquals(462, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(462, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcInnerDecoration(InnerDecorationType.MDF10);
        assertEquals(188.16, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(188.16, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcInnerDecoration(InnerDecorationType.MDF16);
        assertEquals(376.32, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(376.32, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcInnerDecoration(InnerDecorationType.NO_DECORATION);
        assertEquals(60.00, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(60.00, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_PF);
        assertEquals(255.58, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(255.58, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
        assertEquals(329.68, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(329.68, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
        assertEquals(348.20, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(348.20, singleDoorSideTransom.getTotalPrice(), DELTA);
    }

    @org.junit.Test
    public void testCalcInnerDecorationWithoutTopTransom() throws Exception {
        singleDoorSideTransom.setX(1500);
        singleDoorSideTransom.setX_1(1000);
        assertEquals(singleDoorSideTransom.getTotalPrice(), 0.0, DELTA);
        singleDoorSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.PLASTIC);
        assertEquals(352.65, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(352.65, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.LAMINATED_PLASTIC);
        assertEquals(436.25, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(436.25, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.MDF10);
        assertEquals(218.16, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(218.16, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.MDF16);
        assertEquals(406.32, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(406.32, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.NO_DECORATION);
        assertEquals(90, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(90, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.METAL_LIST_PAINTING_PF);
        assertEquals(285.85, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(285.85, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
        assertEquals(361.71, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(361.71, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcInnerDecorationWithoutTopTransom(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
        assertEquals(380.53, singleDoorSideTransom.getInnerDecorationPrice(), DELTA);
        assertEquals(380.53, singleDoorSideTransom.getTotalPrice(), DELTA);
    }

    @org.junit.Test
    public void testCalcPlatband() throws Exception {
        assertEquals(singleDoorSideTransom.getTotalPrice(), 0.0, DELTA);
        singleDoorSideTransom.calcPlatband(PlatbandType.WOODEN);
        assertEquals(55, singleDoorSideTransom.getPlatbandPrice(), DELTA);
        assertEquals(55, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcPlatband(PlatbandType.METAL_PAINTING_PF);
        assertEquals(120.50, singleDoorSideTransom.getPlatbandPrice(), DELTA);
        assertEquals(120.50, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcPlatband(PlatbandType.METAL_PAINTING_SHAGREEN);
        assertEquals(134.50, singleDoorSideTransom.getPlatbandPrice(), DELTA);
        assertEquals(134.50, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcPlatband(PlatbandType.METAL_PAINTING_ANTIC);
        assertEquals(138, singleDoorSideTransom.getPlatbandPrice(), DELTA);
        assertEquals(138, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcPlatband(PlatbandType.MDF10);
        assertEquals(35, singleDoorSideTransom.getPlatbandPrice(), DELTA);
        assertEquals(35, singleDoorSideTransom.getTotalPrice(), DELTA);
        singleDoorSideTransom.calcPlatband(PlatbandType.MDF16);
        assertEquals(70, singleDoorSideTransom.getPlatbandPrice(), DELTA);
        assertEquals(70, singleDoorSideTransom.getTotalPrice(), DELTA);
    }
}
