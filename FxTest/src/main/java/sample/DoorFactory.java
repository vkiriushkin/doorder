package sample;

import javafx.scene.control.TextField;
import sample.com.doorder.door.*;
import sample.com.doorder.door.angled.*;
import sample.com.doorder.door.doubleframe.AngledDoubleFrameDoor;
import sample.com.doorder.door.fireproof.DoubleFireProofDoor;
import sample.com.doorder.door.fireproof.FireProofDoorImpl;
import sample.com.doorder.door.fireproof.SingleFireProofDoor;
import sample.com.doorder.door.types.AccessoriesType;
import sample.com.doorder.door.types.InnerDecorationType;
import sample.com.doorder.door.types.OuterDecorationType;
import sample.com.doorder.door.types.PlatbandType;

public class DoorFactory {


    public static String createDoor(String doorType, String doorStructure, String doorComplexity,
                                    TextField x, TextField y,
                                    TextField x_1, TextField y_1,
                                    TextField x_2, TextField x_3,
                                    TextField platbandWidth,
                                    String innerDecoration, String outerDecoration,
                                    String innerTransomDecoration, String outerTransomDecoration,
                                    String platbandType
//                                    String mainLockType, String secondaryLockType,
//                                    String handleType, String protectorType, String spyHoleType
    ) {
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
//                    calcMainLock(angledDoor, mainLockType);
//                    calcSecondaryLock(angledDoor, secondaryLockType);
//                    calcHandle(angledDoor, handleType);
//                    calcProtector(angledDoor, protectorType);
//                    calcSpyHole(angledDoor, spyHoleType);
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
                    if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
                        calcInnerDecoration(singleDoorSideTransom, innerDecoration);
                    } else {
                        singleDoorSideTransom.calcInnerDecorationWithoutTopTransom(innerDecorationTypeBySelectedItem(innerDecoration));
                    }
                    if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
                        calcOuterDecoration(singleDoorSideTransom, outerDecoration);
                    } else {
                        singleDoorSideTransom.calcOuterDecorationWithoutTopTransom(outerDecorationTypeBySelectedItem(outerDecoration));
                    }
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
                    if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
                        calcInnerDecoration(singleDoorTopTransom, innerDecoration);
                    } else {
                        singleDoorTopTransom.calcInnerDecorationWithoutTopTransom(innerDecorationTypeBySelectedItem(innerDecoration));
                    }
                    if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
                        calcOuterDecoration(singleDoorTopTransom, outerDecoration);
                    } else {
                        singleDoorTopTransom.calcOuterDecorationWithoutTopTransom(outerDecorationTypeBySelectedItem(outerDecoration));
                    }
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
                    singleDoorTopSideTransom.setX_2(Integer.parseInt(x_2.getText()));
                    singleDoorTopSideTransom.setX_3(Integer.parseInt(x_3.getText()));
                    singleDoorTopSideTransom.calcMetalFrameParts();
                    singleDoorTopSideTransom.calcMetalList();
                    singleDoorTopSideTransom.calcSeal(true);
                    singleDoorTopSideTransom.calcHeater(true);
                    singleDoorTopSideTransom.calcHinge();
                    if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
                        calcInnerDecoration(singleDoorTopSideTransom, innerDecoration);
                    } else {
                        singleDoorTopSideTransom.calcInnerDecorationWithoutTopSideTransom(innerDecorationTypeBySelectedItem(innerDecoration));
                    }
                    if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
                        calcOuterDecoration(singleDoorTopSideTransom, outerDecoration);
                    } else {
                        singleDoorTopSideTransom.calcOuterDecorationWithoutTopSideTransom(outerDecorationTypeBySelectedItem(outerDecoration));
                    }
                    calcInnerDecoration(singleDoorTopSideTransom, innerDecoration);
                    calcOuterDecoration(singleDoorTopSideTransom, outerDecoration);
                    calcPlatband(singleDoorTopSideTransom, platbandType);
                    result = singleDoorTopSideTransom.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.doubleDoorTopTransom)) {
                    DoubleDoorTopTransom doubleDoorTopTransom = new DoubleDoorTopTransom();
                    doubleDoorTopTransom.setX(Integer.parseInt(x.getText()));
                    doubleDoorTopTransom.setX_1(Integer.parseInt(x_1.getText()));
                    doubleDoorTopTransom.setY(Integer.parseInt(y.getText()));
                    doubleDoorTopTransom.setY_1(Integer.parseInt(y_1.getText()));
                    doubleDoorTopTransom.setZ(Integer.parseInt(platbandWidth.getText()));
                    doubleDoorTopTransom.calcMetalFrameParts();
                    doubleDoorTopTransom.calcMetalList();
                    doubleDoorTopTransom.calcSeal(true);
                    doubleDoorTopTransom.calcHeater(true);
                    doubleDoorTopTransom.calcHinge();
                    if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
                        calcInnerDecoration(doubleDoorTopTransom, innerDecoration);
                    } else {
                        doubleDoorTopTransom.calcInnerDecorationWithoutTopSideTransom(innerDecorationTypeBySelectedItem(innerDecoration));
                    }
                    if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
                        calcOuterDecoration(doubleDoorTopTransom, outerDecoration);
                    } else {
                        doubleDoorTopTransom.calcOuterDecorationWithoutTopSideTransom(outerDecorationTypeBySelectedItem(outerDecoration));
                    }
                    calcInnerDecoration(doubleDoorTopTransom, innerDecoration);
                    calcOuterDecoration(doubleDoorTopTransom, outerDecoration);
                    calcPlatband(doubleDoorTopTransom, platbandType);
                    result = doubleDoorTopTransom.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTwoSideTransoms)) {
                    SingleDoorTwoSideTransom singleDoorTwoSideTransom = new SingleDoorTwoSideTransom();
                    singleDoorTwoSideTransom.setX(Integer.parseInt(x.getText()));
                    singleDoorTwoSideTransom.setX_1(Integer.parseInt(x_1.getText()));
                    singleDoorTwoSideTransom.setY(Integer.parseInt(y.getText()));
                    singleDoorTwoSideTransom.setZ(Integer.parseInt(platbandWidth.getText()));
                    singleDoorTwoSideTransom.setX_2(Integer.parseInt(x_2.getText()));
                    singleDoorTwoSideTransom.setX_3(Integer.parseInt(x_3.getText()));
                    singleDoorTwoSideTransom.calcMetalFrameParts();
                    singleDoorTwoSideTransom.calcMetalList();
                    singleDoorTwoSideTransom.calcSeal(true);
                    singleDoorTwoSideTransom.calcHeater(true);
                    singleDoorTwoSideTransom.calcHinge();
                    if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
                        calcInnerDecoration(singleDoorTwoSideTransom, innerDecoration);
                    } else {
                        singleDoorTwoSideTransom.calcInnerDecorationWithoutTopTransom(innerDecorationTypeBySelectedItem(innerDecoration));
                    }
                    if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
                        calcOuterDecoration(singleDoorTwoSideTransom, outerDecoration);
                    } else {
                        singleDoorTwoSideTransom.calcOuterDecorationWithoutTopTransom(outerDecorationTypeBySelectedItem(outerDecoration));
                    }
                    calcInnerDecoration(singleDoorTwoSideTransom, innerDecoration);
                    calcOuterDecoration(singleDoorTwoSideTransom, outerDecoration);
                    calcPlatband(singleDoorTwoSideTransom, platbandType);
                    result = singleDoorTwoSideTransom.toString();
                }
            }

            //angled door double frame
            if (doorStructure.equalsIgnoreCase(LabelNames.angledDoubleDoor)) {
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoor)) {
                    AngledDoubleFrameDoor angledDoubleFrameDoor = new AngledDoubleFrameDoor();
                    angledDoubleFrameDoor.setX(Integer.parseInt(x.getText()));
                    angledDoubleFrameDoor.setY(Integer.parseInt(y.getText()));
                    angledDoubleFrameDoor.setZ(Integer.parseInt(platbandWidth.getText()));
                    angledDoubleFrameDoor.calcMetalFrameParts();
                    angledDoubleFrameDoor.calcMetalList();
                    angledDoubleFrameDoor.calcSeal(true);
                    angledDoubleFrameDoor.calcHeater(true);
                    angledDoubleFrameDoor.calcHinge();
                    calcInnerDecoration(angledDoubleFrameDoor, innerDecoration);
                    calcOuterDecoration(angledDoubleFrameDoor, outerDecoration);
                    calcPlatband(angledDoubleFrameDoor, platbandType);
//                    calcMainLock(angledDoubleFrameDoor, mainLockType);
//                    calcSecondaryLock(angledDoubleFrameDoor, secondaryLockType);
//                    calcHandle(angledDoubleFrameDoor, handleType);
//                    calcProtector(angledDoubleFrameDoor, protectorType);
//                    calcSpyHole(angledDoubleFrameDoor, spyHoleType);
                    result = angledDoubleFrameDoor.toString();
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
                    if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
                        calcInnerDecoration(singleDoorSideTransom, innerDecoration);
                    } else {
                        singleDoorSideTransom.calcInnerDecorationWithoutTopTransom(innerDecorationTypeBySelectedItem(innerDecoration));
                    }
                    if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
                        calcOuterDecoration(singleDoorSideTransom, outerDecoration);
                    } else {
                        singleDoorSideTransom.calcOuterDecorationWithoutTopTransom(outerDecorationTypeBySelectedItem(outerDecoration));
                    }
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
                    if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
                        calcInnerDecoration(singleDoorTopTransom, innerDecoration);
                    } else {
                        singleDoorTopTransom.calcInnerDecorationWithoutTopTransom(innerDecorationTypeBySelectedItem(innerDecoration));
                    }
                    if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
                        calcOuterDecoration(singleDoorTopTransom, outerDecoration);
                    } else {
                        singleDoorTopTransom.calcOuterDecorationWithoutTopTransom(outerDecorationTypeBySelectedItem(outerDecoration));
                    }
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
                    singleDoorTopSideTransom.setX_2(Integer.parseInt(x_2.getText()));
                    singleDoorTopSideTransom.setX_3(Integer.parseInt(x_3.getText()));
                    singleDoorTopSideTransom.calcMetalFrameParts();
                    singleDoorTopSideTransom.calcMetalList();
                    singleDoorTopSideTransom.calcSeal(true);
                    singleDoorTopSideTransom.calcHeater(true);
                    singleDoorTopSideTransom.calcHinge();
                    if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
                        calcInnerDecoration(singleDoorTopSideTransom, innerDecoration);
                    } else {
                        singleDoorTopSideTransom.calcInnerDecorationWithoutTopSideTransom(innerDecorationTypeBySelectedItem(innerDecoration));
                    }
                    if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
                        calcOuterDecoration(singleDoorTopSideTransom, outerDecoration);
                    } else {
                        singleDoorTopSideTransom.calcOuterDecorationWithoutTopSideTransom(outerDecorationTypeBySelectedItem(outerDecoration));
                    }
                    calcInnerDecoration(singleDoorTopSideTransom, innerDecoration);
                    calcOuterDecoration(singleDoorTopSideTransom, outerDecoration);
                    calcPlatband(singleDoorTopSideTransom, platbandType);
                    result = singleDoorTopSideTransom.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.doubleDoorTopTransom)) {
                    DoubleDoorTopTransom doubleDoorTopTransom = new DoubleDoorTopTransom();
                    doubleDoorTopTransom.setX(Integer.parseInt(x.getText()));
                    doubleDoorTopTransom.setX_1(Integer.parseInt(x_1.getText()));
                    doubleDoorTopTransom.setY(Integer.parseInt(y.getText()));
                    doubleDoorTopTransom.setY_1(Integer.parseInt(y_1.getText()));
                    doubleDoorTopTransom.setZ(Integer.parseInt(platbandWidth.getText()));
                    doubleDoorTopTransom.calcMetalFrameParts();
                    doubleDoorTopTransom.calcMetalList();
                    doubleDoorTopTransom.calcSeal(true);
                    doubleDoorTopTransom.calcHeater(true);
                    doubleDoorTopTransom.calcHinge();
                    if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
                        calcInnerDecoration(doubleDoorTopTransom, innerDecoration);
                    } else {
                        doubleDoorTopTransom.calcInnerDecorationWithoutTopSideTransom(innerDecorationTypeBySelectedItem(innerDecoration));
                    }
                    if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
                        calcOuterDecoration(doubleDoorTopTransom, outerDecoration);
                    } else {
                        doubleDoorTopTransom.calcOuterDecorationWithoutTopSideTransom(outerDecorationTypeBySelectedItem(outerDecoration));
                    }
                    calcInnerDecoration(doubleDoorTopTransom, innerDecoration);
                    calcOuterDecoration(doubleDoorTopTransom, outerDecoration);
                    calcPlatband(doubleDoorTopTransom, platbandType);
                    result = doubleDoorTopTransom.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTwoSideTransoms)) {
                    SingleDoorTwoSideTransom singleDoorTwoSideTransom = new SingleDoorTwoSideTransom();
                    singleDoorTwoSideTransom.setX(Integer.parseInt(x.getText()));
                    singleDoorTwoSideTransom.setX_1(Integer.parseInt(x_1.getText()));
                    singleDoorTwoSideTransom.setY(Integer.parseInt(y.getText()));
                    singleDoorTwoSideTransom.setZ(Integer.parseInt(platbandWidth.getText()));
                    singleDoorTwoSideTransom.setX_2(Integer.parseInt(x_2.getText()));
                    singleDoorTwoSideTransom.setX_3(Integer.parseInt(x_3.getText()));
                    singleDoorTwoSideTransom.calcMetalFrameParts();
                    singleDoorTwoSideTransom.calcMetalList();
                    singleDoorTwoSideTransom.calcSeal(true);
                    singleDoorTwoSideTransom.calcHeater(true);
                    singleDoorTwoSideTransom.calcHinge();
                    if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
                        calcInnerDecoration(singleDoorTwoSideTransom, innerDecoration);
                    } else {
                        singleDoorTwoSideTransom.calcInnerDecorationWithoutTopTransom(innerDecorationTypeBySelectedItem(innerDecoration));
                    }
                    if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
                        calcOuterDecoration(singleDoorTwoSideTransom, outerDecoration);
                    } else {
                        singleDoorTwoSideTransom.calcOuterDecorationWithoutTopTransom(outerDecorationTypeBySelectedItem(outerDecoration));
                    }
                    calcInnerDecoration(singleDoorTwoSideTransom, innerDecoration);
                    calcOuterDecoration(singleDoorTwoSideTransom, outerDecoration);
                    calcPlatband(singleDoorTwoSideTransom, platbandType);
                    result = singleDoorTwoSideTransom.toString();
                }
            }

        } else if (doorType.equalsIgnoreCase(LabelNames.fireproofDoor)) {
            if (doorComplexity.equalsIgnoreCase(LabelNames.singleFireProofDoor)) {
                SingleFireProofDoor singleFireProofDoor = new SingleFireProofDoor();
                singleFireProofDoor.setX(Integer.parseInt(x.getText()));
//                singleFireProofDoor.setX_1(Integer.parseInt(x_1.getText()));
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
            } else if (doorComplexity.equalsIgnoreCase(LabelNames.doubleFireProofDoor)) {
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

    private static void calcPlatband(SimpleDoor angledDoor, String platbandType) {
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

    private static void calcOuterDecoration(SimpleDoor angledDoor, String outerDecoration) {
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

    private static void calcInnerDecoration(SimpleDoor angledDoor, String innerDecoration) {
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
        if (innerDecoration.equalsIgnoreCase(LabelNames.innerNoTransomDecoration))
            angledDoor.calcInnerDecoration(InnerDecorationType.NO_DECORATION);
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
        if (innerDecoration.equalsIgnoreCase(LabelNames.innerNoTransomDecoration))
            fireProofDoor.calcInnerDecoration(InnerDecorationType.NO_DECORATION);
    }

    private static void calcMainLock(AngledDoor angledDoor, String mainLock) {
        if (mainLock.equalsIgnoreCase(LabelNames.kale257))
            angledDoor.calcMainLock(AccessoriesType.MAIN_LOCKER_KALE_257L);
        if (mainLock.equalsIgnoreCase(LabelNames.kale189))
            angledDoor.calcMainLock(AccessoriesType.MAIN_LOCKER_KALE_1894);
        if (mainLock.equalsIgnoreCase(LabelNames.elbor))
            angledDoor.calcMainLock(AccessoriesType.MAIN_LOCKER_ELBOR);
    }

    private static void calcSecondaryLock(AngledDoor angledDoor, String secondaryLock) {
        if (secondaryLock.equalsIgnoreCase(LabelNames.noSecondaryLock))
            angledDoor.calcSecondaryLock(AccessoriesType.NO_SECONDARY_LOCKER);
        if (secondaryLock.equalsIgnoreCase(LabelNames.kale252))
            angledDoor.calcSecondaryLock(AccessoriesType.SECONDARY_LOCKER_KALE_25R);
        if (secondaryLock.equalsIgnoreCase(LabelNames.mottura))
            angledDoor.calcSecondaryLock(AccessoriesType.SECONDARY_LOCKER_MOTTURA_54797);
        if (secondaryLock.equalsIgnoreCase(LabelNames.apecs2200))
            angledDoor.calcSecondaryLock(AccessoriesType.SECONDARY_LOCKER_APECS_2200);
        if (secondaryLock.equalsIgnoreCase(LabelNames.kale2000))
            angledDoor.calcSecondaryLock(AccessoriesType.SECONDARY_LOCKER_KALE_2000);
    }

    private static void calcHandle(AngledDoor angledDoor, String handle) {
        if (handle.equalsIgnoreCase(LabelNames.apecsCrome))
            angledDoor.calcHandle(AccessoriesType.HANDLE_APECS_CHROME);
        if (handle.equalsIgnoreCase(LabelNames.apecsGold))
            angledDoor.calcHandle(AccessoriesType.HANDLE_APECS_GOLD);
        if (handle.equalsIgnoreCase(LabelNames.apecsCromePlank))
            angledDoor.calcHandle(AccessoriesType.HANDLE_APECS_PLAT_CHROME);
        if (handle.equalsIgnoreCase(LabelNames.apecsGoldPlank))
            angledDoor.calcHandle(AccessoriesType.HANDLE_APECS_PLAT_GOLD);
        if (handle.equalsIgnoreCase(LabelNames.aydemirBrown))
            angledDoor.calcHandle(AccessoriesType.HANDLE_AYDEMIR_BROWN);
        if (handle.equalsIgnoreCase(LabelNames.aydemirBlack))
            angledDoor.calcHandle(AccessoriesType.HANDLE_AYDEMIR_BLACK);
    }

    private static void calcProtector(AngledDoor angledDoor, String protector) {
        if (protector.equalsIgnoreCase(LabelNames.noProtector))
            angledDoor.calcProtector(AccessoriesType.NO_PROTECTOR);
        if (protector.equalsIgnoreCase(LabelNames.apecsProtector))
            angledDoor.calcProtector(AccessoriesType.PROTECTOR_APECS);
    }

    private static void calcSpyHole(AngledDoor angledDoor, String spyHole) {
        if (spyHole.equalsIgnoreCase(LabelNames.spy200))
            angledDoor.calcSpyHole(AccessoriesType.SPY_HOLE_200);
        if (spyHole.equalsIgnoreCase(LabelNames.spy10200))
            angledDoor.calcSpyHole(AccessoriesType.SPY_HOLE_10_200);
        if (spyHole.equalsIgnoreCase(LabelNames.noSpy))
            angledDoor.calcSpyHole(AccessoriesType.NO_SPY_HOLE);
    }

    private static InnerDecorationType innerDecorationTypeBySelectedItem(String selectedItem) {
        if (selectedItem.equalsIgnoreCase(LabelNames.innerPlastic))
            return InnerDecorationType.PLASTIC;
        if (selectedItem.equalsIgnoreCase(LabelNames.innerLaminatedPlastic))
            return InnerDecorationType.LAMINATED_PLASTIC;
        if (selectedItem.equalsIgnoreCase(LabelNames.innerPaintingPF))
            return InnerDecorationType.METAL_LIST_PAINTING_PF;
        if (selectedItem.equalsIgnoreCase(LabelNames.innerPaintingShagreen))
            return InnerDecorationType.METAL_LIST_PAINTING_SHAGREEN;
        if (selectedItem.equalsIgnoreCase(LabelNames.innerPaintingAntic))
            return InnerDecorationType.METAL_LIST_PAINTING_ANTIC;
        if (selectedItem.equalsIgnoreCase(LabelNames.innermdf10))
            return InnerDecorationType.MDF10;
        if (selectedItem.equalsIgnoreCase(LabelNames.innermdf16))
            return InnerDecorationType.MDF16;
        if (selectedItem.equalsIgnoreCase(LabelNames.innerNoTransomDecoration))
            return InnerDecorationType.NO_DECORATION;
        return null;
    }

    private static OuterDecorationType outerDecorationTypeBySelectedItem(String selectedItem) {
        if (selectedItem.equalsIgnoreCase(LabelNames.outerselfAdhesiveFilm))
            return OuterDecorationType.SELF_ADHESIVE_FILM;
        if (selectedItem.equalsIgnoreCase(LabelNames.outerantiLayer))
            return OuterDecorationType.ANTI_LAYER;
        if (selectedItem.equalsIgnoreCase(LabelNames.outerpaintingShagreen))
            return OuterDecorationType.PAINTING_SHAGREEN;
        if (selectedItem.equalsIgnoreCase(LabelNames.outerpaintingAntic))
            return OuterDecorationType.PAINTING_ANTIC;
        if (selectedItem.equalsIgnoreCase(LabelNames.outerpaintingPF))
            return OuterDecorationType.PAINTING_PF;
        if (selectedItem.equalsIgnoreCase(LabelNames.outermdf10))
            return OuterDecorationType.MDF10;
        if (selectedItem.equalsIgnoreCase(LabelNames.outermdf16))
            return OuterDecorationType.MDF16;
        return null;
    }
}
