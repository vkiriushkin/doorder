package sample;

import javafx.scene.image.Image;
import sample.com.doorder.door.LabelNames;
import sample.com.doorder.door.Price;

import java.util.Arrays;

public enum DoorType {

    ANGLED_SINGLE_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoor,LabelNames.leftOpeningDoor,"singleLeft.png",
            500, 1200, 1000, 2450,
            0, 0, 0, 0,
            0, 0, 0, 0,
            Price.ANGLEDSINGLE.getPriceInUAH(), Price.ANGLEDSINGLEWORK.getPriceInUAH()),
    ANGLED_SINGLE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoor,LabelNames.rightOpeningDoor,"singleRight.png",
            500, 1200, 1000, 2450,
            0, 0, 0, 0,
            0, 0, 0, 0,
            Price.ANGLEDSINGLE.getPriceInUAH(), Price.ANGLEDSINGLEWORK.getPriceInUAH()),
    ANGLED_SINGLE_TOP_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTopTransom,LabelNames.leftOpeningDoor,"singleTopTransomLeft.png",
            500, 1200, 1060, 3000,
            0, 0, 1000, 2450,
            0, 0, 0, 0,
            Price.ANGLEDSINGLETOP.getPriceInUAH(), Price.ANGLEDSINGLETOPWORK.getPriceInUAH()),
    ANGLED_SINGLE_TOP_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTopTransom,LabelNames.rightOpeningDoor,"singleTopTransomRight.png",
            500, 1200, 1060, 3000,
            0, 0, 1000, 2450,
            0, 0, 0, 0,
            Price.ANGLEDSINGLETOP.getPriceInUAH(), Price.ANGLEDSINGLETOPWORK.getPriceInUAH()),
    ANGLED_DOUBLE_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.doubleDoor,LabelNames.leftOpeningDoor,"doubleLeft.png",
            800, 1950, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.ANGLEDDOUBLE.getPriceInUAH(), Price.ANGLEDDOUBLEWORK.getPriceInUAH()),
    ANGLED_DOUBLE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.doubleDoor,LabelNames.rightOpeningDoor,"doubleRight.png",
            800, 1950, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.ANGLEDDOUBLE.getPriceInUAH(), Price.ANGLEDDOUBLEWORK.getPriceInUAH()),
    ANGLED_SINGLE_SIDE_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorSideTransom,LabelNames.leftOpeningDoor,"singleSideTransomLeft.png",
            800, 1950, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.ANGLEDSINGLESIDE.getPriceInUAH(), Price.ANGLEDSINGLESIDEWORK.getPriceInUAH()),
    ANGLED_SINGLE_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorSideTransom,LabelNames.rightOpeningDoor,"singleSideTransomRight.png",
            800, 1950, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.ANGLEDSINGLESIDE.getPriceInUAH(), Price.ANGLEDSINGLESIDEWORK.getPriceInUAH()),
    ANGLED_SINGLE_TOP_SIDE_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTopSideTransoms,LabelNames.leftOpeningDoor,"singleTopSideTransomLeft.png",
            800, 3000, 1060, 3000,
            500, 1200, 1000, 2450,
            150, 0, 150, 0,
            Price.ANGLEDSINGLETOPSIDE.getPriceInUAH(), Price.ANGLEDSINGLETOPSIDEWORK.getPriceInUAH()),
    ANGLED_SINGLE_TOP_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTopSideTransoms,LabelNames.rightOpeningDoor,"singleTopSideTransomRight.png",
            800, 3000, 1060, 3000,
            500, 1200, 1000, 2450,
            150, 0, 150, 0,
            Price.ANGLEDSINGLETOPSIDE.getPriceInUAH(), Price.ANGLEDSINGLETOPSIDEWORK.getPriceInUAH()),
    ANGLED_DOUBLE_TOP_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.doubleDoorTopTransom,LabelNames.leftOpeningDoor,"doubleTopTransomLeft.png",
            800, 1950, 1060, 3000,
            400, 1200, 1000, 2450,
            0, 0, 0, 0,
            Price.ANGLEDDOUBLETOP.getPriceInUAH(), Price.ANGLEDDOUBLETOPWORK.getPriceInUAH()),
    ANGLED_DOUBLE_TOP_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.doubleDoorTopTransom,LabelNames.rightOpeningDoor,"doubleTopTransomRight.png",
            800, 1950, 1060, 3000,
            400, 1200, 1000, 2450,
            0, 0, 0, 0,
            Price.ANGLEDDOUBLETOP.getPriceInUAH(), Price.ANGLEDDOUBLETOPWORK.getPriceInUAH()),
    ANGLED_SINGLE_TWO_SIDE_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTwoSideTransoms,LabelNames.leftOpeningDoor,"singleTwoSideTransomLeft.png",
            800, 3000, 1000, 2450,
            500, 1250, 0, 0,
            150, 0, 150, 0,
            Price.ANGLEDSINGLETWOSIDE.getPriceInUAH(), Price.ANGLEDSINGLETWOSIDEWORK.getPriceInUAH()),
    ANGLED_SINGLE_TWO_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTwoSideTransoms,LabelNames.rightOpeningDoor,"singleTwoSideTransomRight.png",
            800, 3000, 1000, 2450,
            500, 1250, 0, 0,
            150, 0, 150, 0,
            Price.ANGLEDSINGLETWOSIDE.getPriceInUAH(), Price.ANGLEDSINGLETWOSIDEWORK.getPriceInUAH()),

    FIREPROOF_SINGLE_LEFT(LabelNames.fireproofDoor,null,LabelNames.singleDoor,LabelNames.leftOpeningDoor,"singleLeft.png",
            540, 1100, 1040, 2500,
            0, 0, 0, 0,
            0, 0, 0, 0,
            Price.FIREPROOFSINGLE.getPriceInUAH(), Price.FIREPROOFSINGLEWORK.getPriceInUAH()),
    FIREPROOF_SINGLE_RIGHT(LabelNames.fireproofDoor,null,LabelNames.singleDoor,LabelNames.rightOpeningDoor,"singleRight.png",
            540, 1100, 1040, 2500,
            0, 0, 0, 0,
            0, 0, 0, 0,
            Price.FIREPROOFSINGLE.getPriceInUAH(), Price.FIREPROOFSINGLEWORK.getPriceInUAH()),
    FIREPROOF_DOUBLE_LEFT(LabelNames.fireproofDoor,null,LabelNames.doubleDoor,LabelNames.leftOpeningDoor,"doubleLeft.png",
            840, 2000, 1040, 2500,
            420, 1100, 0, 0,
            0, 0, 0, 0,
            Price.FIREPROOFDOUBLE.getPriceInUAH(), Price.FIREPROOFDOUBLEWORK.getPriceInUAH()),
    FIREPROOF_DOUBLE_RIGHT(LabelNames.fireproofDoor,null,LabelNames.doubleDoor,LabelNames.rightOpeningDoor,"doubleRight.png",
            840, 2000, 1040, 2500,
            420, 1100, 0, 0,
            0, 0, 0, 0,
            Price.FIREPROOFDOUBLE.getPriceInUAH(), Price.FIREPROOFDOUBLEWORK.getPriceInUAH()),

    DOUBLEFRAME_SINGLE_LEFT(LabelNames.metalDoor,LabelNames.angledDoubleDoor,LabelNames.singleDoor,LabelNames.leftOpeningDoor,"singleLeft.png",
            500, 1200, 1000, 2450,
            0, 0, 0, 0,
            0, 0, 0, 0,
            Price.DOUBLEFRAMESINGLE.getPriceInUAH(), Price.DOUBLEFRAMESINGLEWORK.getPriceInUAH()),
    DOUBLEFRAME_SINGLE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoubleDoor,LabelNames.singleDoor,LabelNames.rightOpeningDoor,"singleRight.png",
            500, 1200, 1000, 2450,
            0, 0, 0, 0,
            0, 0, 0, 0,
            Price.DOUBLEFRAMESINGLE.getPriceInUAH(), Price.DOUBLEFRAMESINGLEWORK.getPriceInUAH()),
    DOUBLEFRAME_SINGLE_TOP_LEFT(LabelNames.metalDoor,LabelNames.angledDoubleDoor,LabelNames.singleDoorTopTransom,LabelNames.leftOpeningDoor,"singleTopTransomLeft.png",
            500, 1200, 1060, 3000,
            0, 0, 1000, 2450,
            0, 0, 0, 0,
            Price.DOUBLEFRAMESINGLETOP.getPriceInUAH(), Price.DOUBLEFRAMESINGLETOPWORK.getPriceInUAH()),
    DOUBLEFRAME_SINGLE_TOP_RIGHT(LabelNames.metalDoor,LabelNames.angledDoubleDoor,LabelNames.singleDoorTopTransom,LabelNames.rightOpeningDoor,"singleTopTransomRight.png",
            500, 1200, 1060, 3000,
            0, 0, 1000, 2450,
            0, 0, 0, 0,
            Price.DOUBLEFRAMESINGLETOP.getPriceInUAH(), Price.DOUBLEFRAMESINGLETOPWORK.getPriceInUAH()),
    DOUBLEFRAME_DOUBLE_LEFT(LabelNames.metalDoor,LabelNames.angledDoubleDoor,LabelNames.doubleDoor,LabelNames.leftOpeningDoor,"doubleLeft.png",
            800, 1950, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.DOUBLEFRAMEDOUBLE.getPriceInUAH(), Price.DOUBLEFRAMEDOUBLEWORK.getPriceInUAH()),
    DOUBLEFRAME_DOUBLE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoubleDoor,LabelNames.doubleDoor,LabelNames.rightOpeningDoor,"doubleRight.png",
            800, 1950, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.DOUBLEFRAMEDOUBLE.getPriceInUAH(), Price.DOUBLEFRAMEDOUBLEWORK.getPriceInUAH()),
    DOUBLEFRAME_SINGLE_SIDE_LEFT(LabelNames.metalDoor,LabelNames.angledDoubleDoor,LabelNames.singleDoorSideTransom,LabelNames.leftOpeningDoor,"singleSideTransomLeft.png",
            800, 1950, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.DOUBLEFRAMESINGLESIDE.getPriceInUAH(), Price.DOUBLEFRAMESINGLESIDEWORK.getPriceInUAH()),
    DOUBLEFRAME_SINGLE_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoubleDoor,LabelNames.singleDoorSideTransom,LabelNames.rightOpeningDoor,"singleSideTransomRight.png",
            800, 1950, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.DOUBLEFRAMESINGLESIDE.getPriceInUAH(), Price.DOUBLEFRAMESINGLESIDEWORK.getPriceInUAH()),
    DOUBLEFRAME_SINGLE_TOP_SIDE_LEFT(LabelNames.metalDoor,LabelNames.angledDoubleDoor,LabelNames.singleDoorTopSideTransoms,LabelNames.leftOpeningDoor,"singleTopSideTransomLeft.png",
            800, 3000, 1060, 3000,
            500, 1200, 1000, 2450,
            150, 0, 150, 0,
            Price.DOUBLEFRAMESINGLETOPSIDE.getPriceInUAH(), Price.DOUBLEFRAMESINGLETOPSIDEWORK.getPriceInUAH()),
    DOUBLEFRAME_SINGLE_TOP_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoubleDoor,LabelNames.singleDoorTopSideTransoms,LabelNames.rightOpeningDoor,"singleTopSideTransomRight.png",
            800, 3000, 1060, 3000,
            500, 1200, 1000, 2450,
            150, 0, 150, 0,
            Price.DOUBLEFRAMESINGLETOPSIDE.getPriceInUAH(), Price.DOUBLEFRAMESINGLETOPSIDEWORK.getPriceInUAH()),
    DOUBLEFRAME_DOUBLE_TOP_LEFT(LabelNames.metalDoor,LabelNames.angledDoubleDoor,LabelNames.doubleDoorTopTransom,LabelNames.leftOpeningDoor,"doubleTopTransomLeft.png",
            800, 1950, 1060, 3000,
            400, 1200, 1000, 2450,
            0, 0, 0, 0,
            Price.DOUBLEFRAMEDOUBLETOP.getPriceInUAH(), Price.DOUBLEFRAMEDOUBLETOPWORK.getPriceInUAH()),
    DOUBLEFRAME_DOUBLE_TOP_RIGHT(LabelNames.metalDoor,LabelNames.angledDoubleDoor,LabelNames.doubleDoorTopTransom,LabelNames.rightOpeningDoor,"doubleTopTransomRight.png",
            800, 1950, 1060, 3000,
            400, 1200, 1000, 2450,
            0, 0, 0, 0,
            Price.DOUBLEFRAMEDOUBLETOP.getPriceInUAH(), Price.DOUBLEFRAMEDOUBLETOPWORK.getPriceInUAH()),
    DOUBLEFRAME_SINGLE_TWO_SIDE_LEFT(LabelNames.metalDoor,LabelNames.angledDoubleDoor,LabelNames.singleDoorTwoSideTransoms,LabelNames.leftOpeningDoor,"singleTwoSideTransomLeft.png",
            800, 3000, 1000, 2450,
            500, 1250, 0, 0,
            150, 0, 150, 0,
            Price.DOUBLEFRAMESINGLETWOSIDE.getPriceInUAH(), Price.DOUBLEFRAMESINGLETWOSIDEWORK.getPriceInUAH()),
    DOUBLEFRAME_SINGLE_TWO_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoubleDoor,LabelNames.singleDoorTwoSideTransoms,LabelNames.rightOpeningDoor,"singleTwoSideTransomRight.png",
            800, 3000, 1000, 2450,
            500, 1250, 0, 0,
            150, 0, 150, 0,
            Price.DOUBLEFRAMESINGLETWOSIDE.getPriceInUAH(), Price.DOUBLEFRAMESINGLETWOSIDEWORK.getPriceInUAH()),

    ARMOUR40_40_SINGLE_LEFT(LabelNames.metalDoor,LabelNames.door40x40,LabelNames.singleDoor,LabelNames.leftOpeningDoor,"singleLeft.png",
            500, 1300, 1000, 2500,
            0, 0, 0, 0,
            0, 0, 0, 0,
            Price.ANGLED40X40SINGLE.getPriceInUAH(), Price.ANGLED40X40SINGLEWORK.getPriceInUAH()),
    ARMOUR40_40_SINGLE_RIGHT(LabelNames.metalDoor,LabelNames.door40x40,LabelNames.singleDoor,LabelNames.rightOpeningDoor,"singleRight.png",
            500, 1300, 1000, 2500,
            0, 0, 0, 0,
            0, 0, 0, 0,
            Price.ANGLED40X40SINGLE.getPriceInUAH(), Price.ANGLED40X40SINGLEWORK.getPriceInUAH()),
    ARMOUR40_40SINGLE_TOP_LEFT(LabelNames.metalDoor,LabelNames.door40x40,LabelNames.singleDoorTopTransom,LabelNames.leftOpeningDoor,"singleTopTransomLeft.png",
            500, 1300, 1060, 3000,
            0, 0, 1000, 2550,
            0, 0, 0, 0,
            Price.ANGLED40X40SINGLETOP.getPriceInUAH(), Price.ANGLED40X40SINGLETOPWORK.getPriceInUAH()),
    ARMOUR40_40_SINGLE_TOP_RIGHT(LabelNames.metalDoor,LabelNames.door40x40,LabelNames.singleDoorTopTransom,LabelNames.rightOpeningDoor,"singleTopTransomRight.png",
            500, 1300, 1060, 3000,
            0, 0, 1000, 2550,
            0, 0, 0, 0,
            Price.ANGLED40X40SINGLETOP.getPriceInUAH(), Price.ANGLED40X40SINGLETOPWORK.getPriceInUAH()),
    ARMOUR40_40_DOUBLE_LEFT(LabelNames.metalDoor,LabelNames.door40x40,LabelNames.doubleDoor,LabelNames.leftOpeningDoor,"doubleLeft.png",
            800, 1950, 1000, 2500,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.ANGLED40X40DOUBLE.getPriceInUAH(), Price.ANGLED40X40DOUBLEWORK.getPriceInUAH()),
    ARMOUR40_40_DOUBLE_RIGHT(LabelNames.metalDoor,LabelNames.door40x40,LabelNames.doubleDoor,LabelNames.rightOpeningDoor,"doubleRight.png",
            800, 1950, 1000, 2500,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.ANGLED40X40DOUBLE.getPriceInUAH(), Price.ANGLED40X40DOUBLEWORK.getPriceInUAH()),
    ARMOUR40_40_SINGLE_SIDE_LEFT(LabelNames.metalDoor,LabelNames.door40x40,LabelNames.singleDoorSideTransom,LabelNames.leftOpeningDoor,"singleSideTransomLeft.png",
            800, 1950, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.ANGLED40X40SINGLESIDE.getPriceInUAH(), Price.ANGLED40X40SINGLESIDEWORK.getPriceInUAH()),
    ARMOUR40_40_SINGLE_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.door40x40,LabelNames.singleDoorSideTransom,LabelNames.rightOpeningDoor,"singleSideTransomRight.png",
            800, 1950, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.ANGLED40X40SINGLESIDE.getPriceInUAH(), Price.ANGLED40X40SINGLESIDEWORK.getPriceInUAH()),
    ARMOUR40_40_SINGLE_TOP_SIDE_LEFT(LabelNames.metalDoor,LabelNames.door40x40,LabelNames.singleDoorTopSideTransoms,LabelNames.leftOpeningDoor,"singleTopSideTransomLeft.png",
            800, 3000, 1060, 3000,
            500, 1250, 1000, 2450,
            150, 0, 150, 0,
            Price.ANGLED40X40SINGLETOPSIDE.getPriceInUAH(), Price.ANGLED40X40SINGLETOPSIDEWORK.getPriceInUAH()),
    ARMOUR40_40_SINGLE_TOP_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.door40x40,LabelNames.singleDoorTopSideTransoms,LabelNames.rightOpeningDoor,"singleTopSideTransomRight.png",
            800, 3000, 1060, 3000,
            500, 1250, 1000, 2450,
            150, 0, 150, 0,
            Price.ANGLED40X40SINGLETOPSIDE.getPriceInUAH(), Price.ANGLED40X40SINGLETOPSIDEWORK.getPriceInUAH()),
    ARMOUR40_40_DOUBLE_TOP_LEFT(LabelNames.metalDoor,LabelNames.door40x40,LabelNames.doubleDoorTopTransom,LabelNames.leftOpeningDoor,"doubleTopTransomLeft.png",
            800, 2000, 1060, 3000,
            400, 1200, 1000, 2450,
            0, 0, 0, 0,
            Price.ANGLED40X40DOUBLETOP.getPriceInUAH(), Price.ANGLED40X40DOUBLETOPWORK.getPriceInUAH()),
    ARMOUR40_40_DOUBLE_TOP_RIGHT(LabelNames.metalDoor,LabelNames.door40x40,LabelNames.doubleDoorTopTransom,LabelNames.rightOpeningDoor,"doubleTopTransomRight.png",
            800, 2000, 1060, 3000,
            400, 1200, 1000, 2450,
            0, 0, 0, 0,
            Price.ANGLED40X40DOUBLETOP.getPriceInUAH(), Price.ANGLED40X40DOUBLETOPWORK.getPriceInUAH()),
    ARMOUR40_40_SINGLE_TWO_SIDE_LEFT(LabelNames.metalDoor,LabelNames.door40x40,LabelNames.singleDoorTwoSideTransoms,LabelNames.leftOpeningDoor,"singleTwoSideTransomLeft.png",
            800, 3000, 1000, 2450,
            500, 1200, 0, 0,
            150, 0, 150, 0,
            Price.ANGLED40X40SINGLETWOSIDE.getPriceInUAH(), Price.ANGLED40X40SINGLETWOSIDEWORK.getPriceInUAH()),
    ARMOUR40_40_SINGLE_TWO_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.door40x40,LabelNames.singleDoorTwoSideTransoms,LabelNames.rightOpeningDoor,"singleTwoSideTransomRight.png",
            800, 3000, 1000, 2450,
            500, 1200, 0, 0,
            150, 0, 150, 0,
            Price.ANGLED40X40SINGLETWOSIDE.getPriceInUAH(), Price.ANGLED40X40SINGLETWOSIDEWORK.getPriceInUAH()),

    ARMOUR50_30_SINGLE_LEFT(LabelNames.metalDoor,LabelNames.door50x30,LabelNames.singleDoor,LabelNames.leftOpeningDoor,"singleLeft.png",
            500, 1200, 1000, 2450,
            0, 0, 0, 0,
            0, 0, 0, 0,
            Price.ANGLED50X30SINGLE.getPriceInUAH(), Price.ANGLED50X30SINGLEWORK.getPriceInUAH()),
    ARMOUR50_30_SINGLE_RIGHT(LabelNames.metalDoor,LabelNames.door50x30,LabelNames.singleDoor,LabelNames.rightOpeningDoor,"singleRight.png",
            500, 1200, 1000, 2450,
            0, 0, 0, 0,
            0, 0, 0, 0,
            Price.ANGLED50X30SINGLE.getPriceInUAH(), Price.ANGLED50X30SINGLEWORK.getPriceInUAH()),
    ARMOUR50_30SINGLE_TOP_LEFT(LabelNames.metalDoor,LabelNames.door50x30,LabelNames.singleDoorTopTransom,LabelNames.leftOpeningDoor,"singleTopTransomLeft.png",
            500, 1200, 1060, 3000,
            0, 0, 1000, 2450,
            0, 0, 0, 0,
            Price.ANGLED50X30SINGLETOP.getPriceInUAH(), Price.ANGLED50X30SINGLETOPWORK.getPriceInUAH()),
    ARMOUR50_30_SINGLE_TOP_RIGHT(LabelNames.metalDoor,LabelNames.door50x30,LabelNames.singleDoorTopTransom,LabelNames.rightOpeningDoor,"singleTopTransomRight.png",
            500, 1200, 1060, 3000,
            0, 0, 1000, 2450,
            0, 0, 0, 0,
            Price.ANGLED50X30SINGLETOP.getPriceInUAH(), Price.ANGLED50X30SINGLETOPWORK.getPriceInUAH()),
    ARMOUR50_30_DOUBLE_LEFT(LabelNames.metalDoor,LabelNames.door50x30,LabelNames.doubleDoor,LabelNames.leftOpeningDoor,"doubleLeft.png",
            800, 2000, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.ANGLED50X30DOUBLE.getPriceInUAH(), Price.ANGLED50X30DOUBLEWORK.getPriceInUAH()),
    ARMOUR50_30_DOUBLE_RIGHT(LabelNames.metalDoor,LabelNames.door50x30,LabelNames.doubleDoor,LabelNames.rightOpeningDoor,"doubleRight.png",
            800, 2000, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.ANGLED50X30DOUBLE.getPriceInUAH(), Price.ANGLED50X30DOUBLEWORK.getPriceInUAH()),
    ARMOUR50_30_SINGLE_SIDE_LEFT(LabelNames.metalDoor,LabelNames.door50x30,LabelNames.singleDoorSideTransom,LabelNames.leftOpeningDoor,"singleSideTransomLeft.png",
            800, 2000, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.ANGLED50X30SINGLESIDE.getPriceInUAH(), Price.ANGLED50X30SINGLESIDEWORK.getPriceInUAH()),
    ARMOUR50_30_SINGLE_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.door50x30,LabelNames.singleDoorSideTransom,LabelNames.rightOpeningDoor,"singleSideTransomRight.png",
            800, 2000, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0,
            Price.ANGLED50X30SINGLESIDE.getPriceInUAH(), Price.ANGLED50X30SINGLESIDEWORK.getPriceInUAH()),
    ARMOUR50_30_SINGLE_TOP_SIDE_LEFT(LabelNames.metalDoor,LabelNames.door50x30,LabelNames.singleDoorTopSideTransoms,LabelNames.leftOpeningDoor,"singleTopSideTransomLeft.png",
            800, 3000, 1060, 3000,
            500, 1200, 1000, 2450,
            150, 0, 150, 0,
            Price.ANGLED50X30SINGLETOPSIDE.getPriceInUAH(), Price.ANGLED50X30SINGLETOPSIDEWORK.getPriceInUAH()),
    ARMOUR50_30_SINGLE_TOP_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.door50x30,LabelNames.singleDoorTopSideTransoms,LabelNames.rightOpeningDoor,"singleTopSideTransomRight.png",
            800, 3000, 1060, 3000,
            500, 1200, 1000, 2450,
            150, 0, 150, 0,
            Price.ANGLED50X30SINGLETOPSIDE.getPriceInUAH(), Price.ANGLED50X30SINGLETOPSIDEWORK.getPriceInUAH()),
    ARMOUR50_30_DOUBLE_TOP_LEFT(LabelNames.metalDoor,LabelNames.door50x30,LabelNames.doubleDoorTopTransom,LabelNames.leftOpeningDoor,"doubleTopTransomLeft.png",
            800, 2000, 1060, 3000,
            400, 1200, 1000, 2450,
            0, 0, 0, 0,
            Price.ANGLED50X30DOUBLETOP.getPriceInUAH(), Price.ANGLED50X30DOUBLETOPWORK.getPriceInUAH()),
    ARMOUR50_30_DOUBLE_TOP_RIGHT(LabelNames.metalDoor,LabelNames.door50x30,LabelNames.doubleDoorTopTransom,LabelNames.rightOpeningDoor,"doubleTopTransomRight.png",
            800, 2000, 1060, 3000,
            400, 1200, 1000, 2450,
            0, 0, 0, 0,
            Price.ANGLED50X30DOUBLETOP.getPriceInUAH(), Price.ANGLED50X30DOUBLETOPWORK.getPriceInUAH()),
    ARMOUR50_30_SINGLE_TWO_SIDE_LEFT(LabelNames.metalDoor,LabelNames.door50x30,LabelNames.singleDoorTwoSideTransoms,LabelNames.leftOpeningDoor,"singleTwoSideTransomLeft.png",
            800, 3000, 1000, 2450,
            500, 1200, 0, 0,
            150, 0, 150, 0,
            Price.ANGLED50X30SINGLETWOSIDE.getPriceInUAH(), Price.ANGLED50X30SINGLETWOSIDEWORK.getPriceInUAH()),
    ARMOUR50_30_SINGLE_TWO_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.door50x30,LabelNames.singleDoorTwoSideTransoms,LabelNames.rightOpeningDoor,"singleTwoSideTransomRight.png",
            800, 3000, 1000, 2450,
            500, 1200, 0, 0,
            150, 0, 150, 0,
            Price.ANGLED50X30SINGLETWOSIDE.getPriceInUAH(), Price.ANGLED50X30SINGLETWOSIDEWORK.getPriceInUAH()),
    ;

    public static DoorType selectDoorBy(String doorType, String doorStructureType, String doorComplexityCategory, String doorOpeningSide) {
        DoorType selectedDoorType = null;
        for (DoorType door : Arrays.asList(DoorType.values())) {
            if (door.getDoorType().equals(doorType)
                    && (door.getDoorStructureType() == null || door.getDoorStructureType().equals(doorStructureType))
                    && door.getDoorComplexityCategory().equals(doorComplexityCategory)
                    && door.getDoorOpeningSide().equals(doorOpeningSide)) {
                selectedDoorType = door;
                break;
            }
        }
        return selectedDoorType;
    }

    private String doorType;
    private String doorStructureType;
    private String doorComplexityCategory;
    private String doorOpeningSide;
    private Image doorImage;
    private String doorImageName;

    private int minX;
    private int maxX;
    private int minY;
    private int maxY;
    private int minX1;
    private int maxX1;
    private int minY1;
    private int maxY1;
    private int minX2;
    private int maxX2;
    private int minX3;
    private int maxX3;

    private double profit;
    private double workCost;

    private DoorType(String doorType, String doorStructureType, String doorComplexityCategory, String doorOpeningSide, String doorImageName,
                     int minX, int maxX, int minY, int maxY,
                     int minX1, int maxX1, int minY1, int maxY1,
                     int minX2, int maxX2, int minX3, int maxX3,
                     double profit, double workCost) {
        this.doorType = doorType;
        this.doorStructureType = doorStructureType;
        this.doorComplexityCategory = doorComplexityCategory;
        this.doorOpeningSide = doorOpeningSide;
        this.doorImage = new Image(DoorType.class.getResourceAsStream(doorImageName));
        this.doorImageName = doorImageName;
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.minX1 = minX1;
        this.maxX1 = maxX1;
        this.minY1 = minY1;
        this.maxY1 = maxY1;
        this.minX2 = minX2;
        this.maxX2 = maxX2;
        this.minX3 = minX3;
        this.maxX3 = maxX3;
        this.profit = profit;
        this.workCost = workCost;
    }

    public String getDoorType() {
        return doorType;
    }

    public String getDoorStructureType() {
        return doorStructureType;
    }

    public String getDoorComplexityCategory() {
        return doorComplexityCategory;
    }

    public String getDoorOpeningSide() {
        return doorOpeningSide;
    }

    public Image getDoorImage() {
        return doorImage;
    }

    public String getDoorImageName() {
        return doorImageName;
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMinX1() {
        return minX1;
    }

    public int getMaxX1() {
        return maxX1;
    }

    public int getMinY1() {
        return minY1;
    }

    public int getMaxY1() {
        return maxY1;
    }

    public int getMinX2() {
        return minX2;
    }

    public int getMaxX2() {
        return maxX2;
    }

    public int getMinX3() {
        return minX3;
    }

    public int getMaxX3() {
        return maxX3;
    }

    public double getProfit() {
        return profit;
    }

    public double getWorkCost() {
        return workCost;
    }
}
