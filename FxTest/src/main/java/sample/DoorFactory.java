package sample;

import javafx.scene.control.TextField;
import sample.com.doorder.door.*;
import sample.com.doorder.door.simple.*;

public class DoorFactory {


    public static String createDoor(String doorType, String doorStructure, String doorComplexity,
                                  TextField x, TextField y,
                                  TextField x_1, TextField y_1,
                                  TextField x_2, TextField x_3,
                                  TextField platbandWidth,
                                  String innerDecoration, String outerDecoration,
                                  String platbandType) {
        String result = null;

        if (doorType.equalsIgnoreCase(LabelNames.metalDoor)) {
            //angled door
            if (doorStructure.equalsIgnoreCase(LabelNames.angledDoor)) {
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoor)) {
                    AngledDoor angledDoor = new AngledDoor();
                    angledDoor.setX(Integer.parseInt(x.getText()));
                    angledDoor.setY(Integer.parseInt(y.getText()));
                    angledDoor.setZ(Integer.parseInt(platbandWidth.getText()));
                    angledDoor.calcMetalFrameParts();
                    angledDoor.calcMetalList();
                    angledDoor.calcSeal(true);
                    angledDoor.calcHeater(true);
                    angledDoor.calcHinge();
                    calcInnerDecoration(angledDoor, innerDecoration);
                    calcOuterDecoration(angledDoor, outerDecoration);
                    calcPlatband(angledDoor, platbandType);
                    result = angledDoor.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.doubleDoor)) {
                    DoubleDoor doubleDoor = new DoubleDoor();
                    doubleDoor.setX(Integer.parseInt(x.getText()));
                    doubleDoor.setX_1(Integer.parseInt(x_1.getText()));
                    doubleDoor.setY(Integer.parseInt(y.getText()));
                    doubleDoor.setZ(Integer.parseInt(platbandWidth.getText()));
                    doubleDoor.calcMetalFrameParts();
                    doubleDoor.calcMetalList();
                    doubleDoor.calcSeal(true);
                    doubleDoor.calcHeater(true);
                    doubleDoor.calcHinge();
                    calcInnerDecoration(doubleDoor, innerDecoration);
                    calcOuterDecoration(doubleDoor, outerDecoration);
                    calcPlatband(doubleDoor, platbandType);
                    result = doubleDoor.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorSideTransom)) {
                    SingleDoorSideTransom singleDoorSideTransom = new SingleDoorSideTransom();
                    singleDoorSideTransom.setX(Integer.parseInt(x.getText()));
                    singleDoorSideTransom.setX_1(Integer.parseInt(x_1.getText()));
                    singleDoorSideTransom.setY(Integer.parseInt(y.getText()));
                    singleDoorSideTransom.setZ(Integer.parseInt(platbandWidth.getText()));
                    singleDoorSideTransom.calcMetalFrameParts();
                    singleDoorSideTransom.calcMetalList();
                    singleDoorSideTransom.calcSeal(true);
                    singleDoorSideTransom.calcHeater(true);
                    singleDoorSideTransom.calcHinge();
                    calcInnerDecoration(singleDoorSideTransom, innerDecoration);
                    calcOuterDecoration(singleDoorSideTransom, outerDecoration);
                    calcPlatband(singleDoorSideTransom, platbandType);
                    result = singleDoorSideTransom.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTopTransom)) {
                    SingleDoorTopTransom singleDoorTopTransom = new SingleDoorTopTransom();
                    singleDoorTopTransom.setX(Integer.parseInt(x.getText()));
                    singleDoorTopTransom.setY(Integer.parseInt(y.getText()));
                    singleDoorTopTransom.setY_1(Integer.parseInt(y_1.getText()));
                    singleDoorTopTransom.setZ(Integer.parseInt(platbandWidth.getText()));
                    singleDoorTopTransom.calcMetalFrameParts();
                    singleDoorTopTransom.calcMetalList();
                    singleDoorTopTransom.calcSeal(true);
                    singleDoorTopTransom.calcHeater(true);
                    singleDoorTopTransom.calcHinge();
                    calcInnerDecoration(singleDoorTopTransom, innerDecoration);
                    calcOuterDecoration(singleDoorTopTransom, outerDecoration);
                    calcPlatband(singleDoorTopTransom, platbandType);
                    result = singleDoorTopTransom.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTopSideTransoms)) {
                    SingleDoorTopSideTransom singleDoorTopSideTransom = new SingleDoorTopSideTransom();
                    singleDoorTopSideTransom.setX(Integer.parseInt(x.getText()));
                    singleDoorTopSideTransom.setX_1(Integer.parseInt(x_1.getText()));
                    singleDoorTopSideTransom.setY(Integer.parseInt(y.getText()));
                    singleDoorTopSideTransom.setY_1(Integer.parseInt(y_1.getText()));
                    singleDoorTopSideTransom.setZ(Integer.parseInt(platbandWidth.getText()));
                    singleDoorTopSideTransom.calcMetalFrameParts();
                    singleDoorTopSideTransom.calcMetalList();
                    singleDoorTopSideTransom.calcSeal(true);
                    singleDoorTopSideTransom.calcHeater(true);
                    singleDoorTopSideTransom.calcHinge();
                    calcInnerDecoration(singleDoorTopSideTransom, innerDecoration);
                    calcOuterDecoration(singleDoorTopSideTransom, outerDecoration);
                    calcPlatband(singleDoorTopSideTransom, platbandType);
                    result = singleDoorTopSideTransom.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.doubleDoorTopTransom)) {
                    DoubleDoorTopTransom singleDoorTopSideTransom = new DoubleDoorTopTransom();
                    singleDoorTopSideTransom.setX(Integer.parseInt(x.getText()));
                    singleDoorTopSideTransom.setX_1(Integer.parseInt(x_1.getText()));
                    singleDoorTopSideTransom.setY(Integer.parseInt(y.getText()));
                    singleDoorTopSideTransom.setY_1(Integer.parseInt(y_1.getText()));
                    singleDoorTopSideTransom.setZ(Integer.parseInt(platbandWidth.getText()));
                    singleDoorTopSideTransom.calcMetalFrameParts();
                    singleDoorTopSideTransom.calcMetalList();
                    singleDoorTopSideTransom.calcSeal(true);
                    singleDoorTopSideTransom.calcHeater(true);
                    singleDoorTopSideTransom.calcHinge();
                    calcInnerDecoration(singleDoorTopSideTransom, innerDecoration);
                    calcOuterDecoration(singleDoorTopSideTransom, outerDecoration);
                    calcPlatband(singleDoorTopSideTransom, platbandType);
                    result = singleDoorTopSideTransom.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTwoSideTransoms)) {
                    SingleDoorTwoSideTransom singleDoorTopSideTransom = new SingleDoorTwoSideTransom();
                    singleDoorTopSideTransom.setX(Integer.parseInt(x.getText()));
                    singleDoorTopSideTransom.setX_1(Integer.parseInt(x_1.getText()));
                    singleDoorTopSideTransom.setY(Integer.parseInt(y.getText()));
                    singleDoorTopSideTransom.setZ(Integer.parseInt(platbandWidth.getText()));
                    singleDoorTopSideTransom.calcMetalFrameParts();
                    singleDoorTopSideTransom.calcMetalList();
                    singleDoorTopSideTransom.calcSeal(true);
                    singleDoorTopSideTransom.calcHeater(true);
                    singleDoorTopSideTransom.calcHinge();
                    calcInnerDecoration(singleDoorTopSideTransom, innerDecoration);
                    calcOuterDecoration(singleDoorTopSideTransom, outerDecoration);
                    calcPlatband(singleDoorTopSideTransom, platbandType);
                    result = singleDoorTopSideTransom.toString();
                }
            }

        } else if (doorType.equalsIgnoreCase(LabelNames.fireproofDoor)) {
            if (doorComplexity.equalsIgnoreCase(LabelNames.singleFireProofDoor)) {
                SingleFireProofDoor singleFireProofDoor = new SingleFireProofDoor();
                singleFireProofDoor.setX(Integer.parseInt(x.getText()));
                singleFireProofDoor.setX_1(Integer.parseInt(x_1.getText()));
                singleFireProofDoor.setY(Integer.parseInt(y.getText()));
                singleFireProofDoor.calcMetalFrameParts();
                singleFireProofDoor.calcInnerMetalList();
                singleFireProofDoor.calcOuterMetalList();
                singleFireProofDoor.calcHinge();
                singleFireProofDoor.calcOgrask();
                singleFireProofDoor.calcDryWall();
                singleFireProofDoor.calcMineralWool();
                singleFireProofDoor.calcSeal();
                calcInnerDecorationFireProof(singleFireProofDoor, innerDecoration);
                calcOuterDecorationFireProof(singleFireProofDoor, outerDecoration);
                calcPlatbandFireProof(singleFireProofDoor, platbandType);
                result = singleFireProofDoor.toString();
            } else if (doorStructure.equalsIgnoreCase(LabelNames.doubleFireProofDoor)) {
                DoubleFireProofDoor doubleFireProofDoor = new DoubleFireProofDoor();
                doubleFireProofDoor.setX(Integer.parseInt(x.getText()));
                doubleFireProofDoor.setX_1(Integer.parseInt(x_1.getText()));
                doubleFireProofDoor.setY(Integer.parseInt(y.getText()));
                doubleFireProofDoor.calcMetalFrameParts();
                doubleFireProofDoor.calcInnerMetalList();
                doubleFireProofDoor.calcOuterMetalList();
                doubleFireProofDoor.calcHinge();
                doubleFireProofDoor.calcOgrask();
                doubleFireProofDoor.calcDryWall();
                doubleFireProofDoor.calcMineralWool();
                doubleFireProofDoor.calcSeal();
                calcInnerDecorationFireProof(doubleFireProofDoor, innerDecoration);
                calcOuterDecorationFireProof(doubleFireProofDoor, outerDecoration);
                calcPlatbandFireProof(doubleFireProofDoor, platbandType);
                result = doubleFireProofDoor.toString();
            }
        }
        return result;
    }


    private static void calcPlatband(AngledDoor angledDoor, String platbandType) {
        if (platbandType.equalsIgnoreCase(LabelNames.platbandWooden))
            angledDoor.calcPlatband(PlatbandType.WOODEN);
        if (platbandType.equalsIgnoreCase(LabelNames.platbandShagreen))
            angledDoor.calcPlatband(PlatbandType.METAL_PAINTING_SHAGREEN);
        if (platbandType.equalsIgnoreCase(LabelNames.platbandPF))
            angledDoor.calcPlatband(PlatbandType.METAL_PAINTING_PF);
        if (platbandType.equalsIgnoreCase(LabelNames.platbendAntic))
            angledDoor.calcPlatband(PlatbandType.METAL_PAINTING_ANTIC);
        if (platbandType.equalsIgnoreCase(LabelNames.platbandMdf10))
            angledDoor.calcPlatband(PlatbandType.MDF10);
        if (platbandType.equalsIgnoreCase(LabelNames.platbandMdf16))
            angledDoor.calcPlatband(PlatbandType.MDF16);
    }

    private static void calcPlatbandFireProof(FireProofDoorImpl fireProofDoor, String platbandType) {
        if (platbandType.equalsIgnoreCase(LabelNames.platbandShagreen))
            fireProofDoor.calcPlatband(PlatbandType.METAL_PAINTING_SHAGREEN);
        if (platbandType.equalsIgnoreCase(LabelNames.platbandPF))
            fireProofDoor.calcPlatband(PlatbandType.METAL_PAINTING_PF);
        if (platbandType.equalsIgnoreCase(LabelNames.platbendAntic))
            fireProofDoor.calcPlatband(PlatbandType.METAL_PAINTING_ANTIC);
    }

    private static void calcOuterDecoration(AngledDoor angledDoor, String outerDecoration) {
        if (outerDecoration.equalsIgnoreCase(LabelNames.outerselfAdhesiveFilm))
            angledDoor.calcOuterDecoration(OuterDecorationType.SELF_ADHESIVE_FILM);
        if (outerDecoration.equalsIgnoreCase(LabelNames.outerantiLayer))
            angledDoor.calcOuterDecoration(OuterDecorationType.ANTI_LAYER);
        if (outerDecoration.equalsIgnoreCase(LabelNames.outerpaintingShagreen))
            angledDoor.calcOuterDecoration(OuterDecorationType.PAINTING_SHAGREEN);
        if (outerDecoration.equalsIgnoreCase(LabelNames.outerpaintingAntic))
            angledDoor.calcOuterDecoration(OuterDecorationType.PAINTING_ANTIC);
        if (outerDecoration.equalsIgnoreCase(LabelNames.outerpaintingPF))
            angledDoor.calcOuterDecoration(OuterDecorationType.PAINTING_PF);
        if (outerDecoration.equalsIgnoreCase(LabelNames.outermdf10))
            angledDoor.calcOuterDecoration(OuterDecorationType.MDF10);
        if (outerDecoration.equalsIgnoreCase(LabelNames.outermdf16))
            angledDoor.calcOuterDecoration(OuterDecorationType.MDF16);
    }

    private static void calcInnerDecoration(AngledDoor angledDoor, String innerDecoration) {
        if (innerDecoration.equalsIgnoreCase(LabelNames.innerPlastic))
            angledDoor.calcInnerDecoration(InnerDecorationType.PLASTIC);
        if (innerDecoration.equalsIgnoreCase(LabelNames.innerLaminatedPlastic))
            angledDoor.calcInnerDecoration(InnerDecorationType.LAMINATED_PLASTIC);
        if (innerDecoration.equalsIgnoreCase(LabelNames.innerPaintingPF))
            angledDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_PF);
        if (innerDecoration.equalsIgnoreCase(LabelNames.innerPaintingShagreen))
            angledDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
        if (innerDecoration.equalsIgnoreCase(LabelNames.innerPaintingAntic))
            angledDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
        if (innerDecoration.equalsIgnoreCase(LabelNames.innermdf10))
            angledDoor.calcInnerDecoration(InnerDecorationType.MDF10);
        if (innerDecoration.equalsIgnoreCase(LabelNames.innermdf16))
            angledDoor.calcInnerDecoration(InnerDecorationType.MDF16);
    }

    private static void calcOuterDecorationFireProof(FireProofDoorImpl fireProofDoor, String outerDecoration) {
        if (outerDecoration.equalsIgnoreCase(LabelNames.outerselfAdhesiveFilm))
            fireProofDoor.calcOuterDecoration(OuterDecorationType.SELF_ADHESIVE_FILM);
        if (outerDecoration.equalsIgnoreCase(LabelNames.outerantiLayer))
            fireProofDoor.calcOuterDecoration(OuterDecorationType.ANTI_LAYER);
        if (outerDecoration.equalsIgnoreCase(LabelNames.outerpaintingShagreen))
            fireProofDoor.calcOuterDecoration(OuterDecorationType.PAINTING_SHAGREEN);
        if (outerDecoration.equalsIgnoreCase(LabelNames.outerpaintingAntic))
            fireProofDoor.calcOuterDecoration(OuterDecorationType.PAINTING_ANTIC);
        if (outerDecoration.equalsIgnoreCase(LabelNames.outerpaintingPF))
            fireProofDoor.calcOuterDecoration(OuterDecorationType.PAINTING_PF);
        if (outerDecoration.equalsIgnoreCase(LabelNames.outermdf10))
            fireProofDoor.calcOuterDecoration(OuterDecorationType.MDF10);
        if (outerDecoration.equalsIgnoreCase(LabelNames.outermdf16))
            fireProofDoor.calcOuterDecoration(OuterDecorationType.MDF16);
    }

    private static void calcInnerDecorationFireProof(FireProofDoorImpl fireProofDoor, String innerDecoration) {
        if (innerDecoration.equalsIgnoreCase(LabelNames.innerPaintingPF))
            fireProofDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_PF);
        if (innerDecoration.equalsIgnoreCase(LabelNames.innerPaintingShagreen))
            fireProofDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN);
        if (innerDecoration.equalsIgnoreCase(LabelNames.innerPaintingAntic))
            fireProofDoor.calcInnerDecoration(InnerDecorationType.METAL_LIST_PAINTING_ANTIC);
        if (innerDecoration.equalsIgnoreCase(LabelNames.innermdf10))
            fireProofDoor.calcInnerDecoration(InnerDecorationType.MDF10);
        if (innerDecoration.equalsIgnoreCase(LabelNames.innermdf16))
            fireProofDoor.calcInnerDecoration(InnerDecorationType.MDF16);
    }
}
