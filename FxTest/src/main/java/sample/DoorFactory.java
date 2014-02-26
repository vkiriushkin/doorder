package sample;

import javafx.scene.control.TextField;
import sample.com.doorder.door.*;
import sample.com.doorder.door.simple.*;

public class DoorFactory {


    public static void createDoor(String doorType, String doorStructure, String doorComplexity,
                                  TextField x, TextField y,
                                  TextField x_1, TextField y_1,
                                  TextField x_2, TextField x_3,
                                  TextField platbandWidth,
                                  String innerDecoration, String outerDecoration,
                                  String platbandType) {
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

                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.doubleDoor)) {
                    DoubleDoor doubleDoor = new DoubleDoor();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorSideTransom)) {
                    SingleDoorSideTransom singleDoorSideTransom = new SingleDoorSideTransom();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTopTransom)) {
                    SingleDoorTopTransom singleDoorTopTransom = new SingleDoorTopTransom();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTopSideTransoms)) {
                    SingleDoorTopSideTransom singleDoorTopSideTransom = new SingleDoorTopSideTransom();
                }
            }

        } else if (doorType.equalsIgnoreCase(LabelNames.fireproofDoor)) {
            if (doorStructure.equalsIgnoreCase(LabelNames.singleFireProofDoor)) {
                SingleFireProofDoor singleFireProofDoor = new SingleFireProofDoor();
            } else if (doorStructure.equalsIgnoreCase(LabelNames.doubleFireProofDoor)) {
                DoubleFireProofDoor doubleFireProofDoor = new DoubleFireProofDoor();
            }
        }
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
}
