package sample;

import javafx.scene.control.TextField;
import sample.com.doorder.door.Door;
import sample.com.doorder.door.LabelNames;
import sample.com.doorder.door.SimpleDoor;
import sample.com.doorder.door.angled.*;
import sample.com.doorder.door.armour4040.*;
import sample.com.doorder.door.armour5030.*;
import sample.com.doorder.door.doubleframe.*;
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
                                    String platbandType,
                                    String mainLockType, String secondaryLockType,
                                    String handleType, String protectorType, String spyHoleType
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
                    calcMainLock(angledDoor, mainLockType);
                    calcSecondaryLock(angledDoor, secondaryLockType);
                    calcHandle(angledDoor, handleType);
                    calcProtector(angledDoor, protectorType);
                    calcSpyHole(angledDoor, spyHoleType);
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
	                calcMainLock(doubleDoor, mainLockType);
	                calcSecondaryLock(doubleDoor, secondaryLockType);
	                calcHandle(doubleDoor, handleType);
	                calcProtector(doubleDoor, protectorType);
	                calcSpyHole(doubleDoor, spyHoleType);
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
	                calcMainLock(singleDoorSideTransom, mainLockType);
	                calcSecondaryLock(singleDoorSideTransom, secondaryLockType);
	                calcHandle(singleDoorSideTransom, handleType);
	                calcProtector(singleDoorSideTransom, protectorType);
	                calcSpyHole(singleDoorSideTransom, spyHoleType);
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
	                calcMainLock(singleDoorTopTransom, mainLockType);
	                calcSecondaryLock(singleDoorTopTransom, secondaryLockType);
	                calcHandle(singleDoorTopTransom, handleType);
	                calcProtector(singleDoorTopTransom, protectorType);
	                calcSpyHole(singleDoorTopTransom, spyHoleType);
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
                    calcPlatband(singleDoorTopSideTransom, platbandType);
	                calcMainLock(singleDoorTopSideTransom, mainLockType);
	                calcSecondaryLock(singleDoorTopSideTransom, secondaryLockType);
	                calcHandle(singleDoorTopSideTransom, handleType);
	                calcProtector(singleDoorTopSideTransom, protectorType);
	                calcSpyHole(singleDoorTopSideTransom, spyHoleType);
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
                    calcPlatband(doubleDoorTopTransom, platbandType);
	                calcPlatband(doubleDoorTopTransom, platbandType);
	                calcMainLock(doubleDoorTopTransom, mainLockType);
	                calcSecondaryLock(doubleDoorTopTransom, secondaryLockType);
	                calcHandle(doubleDoorTopTransom, handleType);
	                calcProtector(doubleDoorTopTransom, protectorType);
	                calcSpyHole(doubleDoorTopTransom, spyHoleType);
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
                    calcPlatband(singleDoorTwoSideTransom, platbandType);
	                calcMainLock(singleDoorTwoSideTransom, mainLockType);
	                calcSecondaryLock(singleDoorTwoSideTransom, secondaryLockType);
	                calcHandle(singleDoorTwoSideTransom, handleType);
	                calcProtector(singleDoorTwoSideTransom, protectorType);
	                calcSpyHole(singleDoorTwoSideTransom, spyHoleType);
                    result = singleDoorTwoSideTransom.toString();
                }
            }

	        //armour 40x40 door
	        if (doorStructure.equalsIgnoreCase(LabelNames.door40x40)) {
		        if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoor)) {
			        Armour4040SingleDoor armour4040SingleDoor = new Armour4040SingleDoor();
			        armour4040SingleDoor.setX(Integer.parseInt(x.getText()));
			        armour4040SingleDoor.setY(Integer.parseInt(y.getText()));
			        armour4040SingleDoor.setZ(Integer.parseInt(platbandWidth.getText()));
			        armour4040SingleDoor.calcMetalFrameParts();
			        armour4040SingleDoor.calcMetalList();
			        armour4040SingleDoor.calcSeal(true);
			        armour4040SingleDoor.calcHeater(true);
			        armour4040SingleDoor.calcHinge();
			        calcInnerDecoration(armour4040SingleDoor, innerDecoration);
			        calcOuterDecoration(armour4040SingleDoor, outerDecoration);
			        calcPlatband(armour4040SingleDoor, platbandType);
                    calcMainLock(armour4040SingleDoor, mainLockType);
                    calcSecondaryLock(armour4040SingleDoor, secondaryLockType);
                    calcHandle(armour4040SingleDoor, handleType);
                    calcProtector(armour4040SingleDoor, protectorType);
                    calcSpyHole(armour4040SingleDoor, spyHoleType);
			        result = armour4040SingleDoor.toString();
		        }
		        if (doorComplexity.equalsIgnoreCase(LabelNames.doubleDoor)) {
			        Armour4040DoubleDoor armour4040DoubleDoor = new Armour4040DoubleDoor();
			        armour4040DoubleDoor.setX(Integer.parseInt(x.getText()));
			        armour4040DoubleDoor.setX_1(Integer.parseInt(x_1.getText()));
			        armour4040DoubleDoor.setY(Integer.parseInt(y.getText()));
			        armour4040DoubleDoor.setZ(Integer.parseInt(platbandWidth.getText()));
			        armour4040DoubleDoor.calcMetalFrameParts();
			        armour4040DoubleDoor.calcMetalList();
			        armour4040DoubleDoor.calcSeal(true);
			        armour4040DoubleDoor.calcHeater(true);
			        armour4040DoubleDoor.calcHinge();
			        calcInnerDecoration(armour4040DoubleDoor, innerDecoration);
			        calcOuterDecoration(armour4040DoubleDoor, outerDecoration);
			        calcPlatband(armour4040DoubleDoor, platbandType);
			        calcMainLock(armour4040DoubleDoor, mainLockType);
			        calcSecondaryLock(armour4040DoubleDoor, secondaryLockType);
			        calcHandle(armour4040DoubleDoor, handleType);
			        calcProtector(armour4040DoubleDoor, protectorType);
			        calcSpyHole(armour4040DoubleDoor, spyHoleType);
			        result = armour4040DoubleDoor.toString();
		        }
		        if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorSideTransom)) {
			        Armour4040SingleSideTransomDoor armour4040SingleSideTransomDoor = new Armour4040SingleSideTransomDoor();
			        armour4040SingleSideTransomDoor.setX(Integer.parseInt(x.getText()));
			        armour4040SingleSideTransomDoor.setX_1(Integer.parseInt(x_1.getText()));
			        armour4040SingleSideTransomDoor.setY(Integer.parseInt(y.getText()));
			        armour4040SingleSideTransomDoor.setZ(Integer.parseInt(platbandWidth.getText()));
			        armour4040SingleSideTransomDoor.calcMetalFrameParts();
			        armour4040SingleSideTransomDoor.calcMetalList();
			        armour4040SingleSideTransomDoor.calcSeal(true);
			        armour4040SingleSideTransomDoor.calcHeater(true);
			        armour4040SingleSideTransomDoor.calcHinge();
			        if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
				        calcInnerDecoration(armour4040SingleSideTransomDoor, innerDecoration);
			        } else {
				        armour4040SingleSideTransomDoor.calcInnerDecorationWithoutTopTransom(innerDecorationTypeBySelectedItem(innerDecoration));
			        }
			        if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
				        calcOuterDecoration(armour4040SingleSideTransomDoor, outerDecoration);
			        } else {
				        armour4040SingleSideTransomDoor.calcOuterDecorationWithoutTopTransom(outerDecorationTypeBySelectedItem(outerDecoration));
			        }
			        calcPlatband(armour4040SingleSideTransomDoor, platbandType);
			        calcMainLock(armour4040SingleSideTransomDoor, mainLockType);
			        calcSecondaryLock(armour4040SingleSideTransomDoor, secondaryLockType);
			        calcHandle(armour4040SingleSideTransomDoor, handleType);
			        calcProtector(armour4040SingleSideTransomDoor, protectorType);
			        calcSpyHole(armour4040SingleSideTransomDoor, spyHoleType);
			        result = armour4040SingleSideTransomDoor.toString();
		        }
		        if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTopTransom)) {
			        Armour4040SingleTopTransomDoor armour4040SingleTopTransomDoor = new Armour4040SingleTopTransomDoor();
			        armour4040SingleTopTransomDoor.setX(Integer.parseInt(x.getText()));
			        armour4040SingleTopTransomDoor.setY(Integer.parseInt(y.getText()));
			        armour4040SingleTopTransomDoor.setY_1(Integer.parseInt(y_1.getText()));
			        armour4040SingleTopTransomDoor.setZ(Integer.parseInt(platbandWidth.getText()));
			        armour4040SingleTopTransomDoor.calcMetalFrameParts();
			        armour4040SingleTopTransomDoor.calcMetalList();
			        armour4040SingleTopTransomDoor.calcSeal(true);
			        armour4040SingleTopTransomDoor.calcHeater(true);
			        armour4040SingleTopTransomDoor.calcHinge();
			        if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
				        calcInnerDecoration(armour4040SingleTopTransomDoor, innerDecoration);
			        } else {
				        armour4040SingleTopTransomDoor.calcInnerDecorationWithoutTopTransom(innerDecorationTypeBySelectedItem(innerDecoration));
			        }
			        if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
				        calcOuterDecoration(armour4040SingleTopTransomDoor, outerDecoration);
			        } else {
				        armour4040SingleTopTransomDoor.calcOuterDecorationWithoutTopTransom(outerDecorationTypeBySelectedItem(outerDecoration));
			        }
			        calcPlatband(armour4040SingleTopTransomDoor, platbandType);
			        calcMainLock(armour4040SingleTopTransomDoor, mainLockType);
			        calcSecondaryLock(armour4040SingleTopTransomDoor, secondaryLockType);
			        calcHandle(armour4040SingleTopTransomDoor, handleType);
			        calcProtector(armour4040SingleTopTransomDoor, protectorType);
			        calcSpyHole(armour4040SingleTopTransomDoor, spyHoleType);
			        result = armour4040SingleTopTransomDoor.toString();
		        }
		        if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTopSideTransoms)) {
			        Armour4040SingleTwoSideAndTopTransomDoor armour4040SingleTwoSideAndTopTransomDoor = new Armour4040SingleTwoSideAndTopTransomDoor();
			        armour4040SingleTwoSideAndTopTransomDoor.setX(Integer.parseInt(x.getText()));
			        armour4040SingleTwoSideAndTopTransomDoor.setX_1(Integer.parseInt(x_1.getText()));
			        armour4040SingleTwoSideAndTopTransomDoor.setY(Integer.parseInt(y.getText()));
			        armour4040SingleTwoSideAndTopTransomDoor.setY_1(Integer.parseInt(y_1.getText()));
			        armour4040SingleTwoSideAndTopTransomDoor.setZ(Integer.parseInt(platbandWidth.getText()));
			        armour4040SingleTwoSideAndTopTransomDoor.setX_2(Integer.parseInt(x_2.getText()));
			        armour4040SingleTwoSideAndTopTransomDoor.setX_3(Integer.parseInt(x_3.getText()));
			        armour4040SingleTwoSideAndTopTransomDoor.calcMetalFrameParts();
			        armour4040SingleTwoSideAndTopTransomDoor.calcMetalList();
			        armour4040SingleTwoSideAndTopTransomDoor.calcSeal(true);
			        armour4040SingleTwoSideAndTopTransomDoor.calcHeater(true);
			        armour4040SingleTwoSideAndTopTransomDoor.calcHinge();
			        if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
				        calcInnerDecoration(armour4040SingleTwoSideAndTopTransomDoor, innerDecoration);
			        } else {
				        armour4040SingleTwoSideAndTopTransomDoor.calcInnerDecorationWithoutTopSideTransom(innerDecorationTypeBySelectedItem(innerDecoration));
			        }
			        if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
				        calcOuterDecoration(armour4040SingleTwoSideAndTopTransomDoor, outerDecoration);
			        } else {
				        armour4040SingleTwoSideAndTopTransomDoor.calcOuterDecorationWithoutTopSideTransom(outerDecorationTypeBySelectedItem(outerDecoration));
			        }
			        calcPlatband(armour4040SingleTwoSideAndTopTransomDoor, platbandType);
			        calcMainLock(armour4040SingleTwoSideAndTopTransomDoor, mainLockType);
			        calcSecondaryLock(armour4040SingleTwoSideAndTopTransomDoor, secondaryLockType);
			        calcHandle(armour4040SingleTwoSideAndTopTransomDoor, handleType);
			        calcProtector(armour4040SingleTwoSideAndTopTransomDoor, protectorType);
			        calcSpyHole(armour4040SingleTwoSideAndTopTransomDoor, spyHoleType);
			        result = armour4040SingleTwoSideAndTopTransomDoor.toString();
		        }
		        if (doorComplexity.equalsIgnoreCase(LabelNames.doubleDoorTopTransom)) {
			        Armour4040DoubleTopTransomDoor armour4040DoubleTopTransomDoor = new Armour4040DoubleTopTransomDoor();
			        armour4040DoubleTopTransomDoor.setX(Integer.parseInt(x.getText()));
			        armour4040DoubleTopTransomDoor.setX_1(Integer.parseInt(x_1.getText()));
			        armour4040DoubleTopTransomDoor.setY(Integer.parseInt(y.getText()));
			        armour4040DoubleTopTransomDoor.setY_1(Integer.parseInt(y_1.getText()));
			        armour4040DoubleTopTransomDoor.setZ(Integer.parseInt(platbandWidth.getText()));
			        armour4040DoubleTopTransomDoor.calcMetalFrameParts();
			        armour4040DoubleTopTransomDoor.calcMetalList();
			        armour4040DoubleTopTransomDoor.calcSeal(true);
			        armour4040DoubleTopTransomDoor.calcHeater(true);
			        armour4040DoubleTopTransomDoor.calcHinge();
			        if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
				        calcInnerDecoration(armour4040DoubleTopTransomDoor, innerDecoration);
			        } else {
				        armour4040DoubleTopTransomDoor.calcInnerDecorationWithoutTopSideTransom(innerDecorationTypeBySelectedItem(innerDecoration));
			        }
			        if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
				        calcOuterDecoration(armour4040DoubleTopTransomDoor, outerDecoration);
			        } else {
				        armour4040DoubleTopTransomDoor.calcOuterDecorationWithoutTopSideTransom(outerDecorationTypeBySelectedItem(outerDecoration));
			        }
			        calcPlatband(armour4040DoubleTopTransomDoor, platbandType);
			        calcMainLock(armour4040DoubleTopTransomDoor, mainLockType);
			        calcSecondaryLock(armour4040DoubleTopTransomDoor, secondaryLockType);
			        calcHandle(armour4040DoubleTopTransomDoor, handleType);
			        calcProtector(armour4040DoubleTopTransomDoor, protectorType);
			        calcSpyHole(armour4040DoubleTopTransomDoor, spyHoleType);
			        result = armour4040DoubleTopTransomDoor.toString();
		        }
		        if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTwoSideTransoms)) {
			        Armour4040SingleTwoSideTransomDoor armour4040SingleTwoSideTransomDoor = new Armour4040SingleTwoSideTransomDoor();
			        armour4040SingleTwoSideTransomDoor.setX(Integer.parseInt(x.getText()));
			        armour4040SingleTwoSideTransomDoor.setX_1(Integer.parseInt(x_1.getText()));
			        armour4040SingleTwoSideTransomDoor.setY(Integer.parseInt(y.getText()));
			        armour4040SingleTwoSideTransomDoor.setZ(Integer.parseInt(platbandWidth.getText()));
			        armour4040SingleTwoSideTransomDoor.setX_2(Integer.parseInt(x_2.getText()));
			        armour4040SingleTwoSideTransomDoor.setX_3(Integer.parseInt(x_3.getText()));
			        armour4040SingleTwoSideTransomDoor.calcMetalFrameParts();
			        armour4040SingleTwoSideTransomDoor.calcMetalList();
			        armour4040SingleTwoSideTransomDoor.calcSeal(true);
			        armour4040SingleTwoSideTransomDoor.calcHeater(true);
			        armour4040SingleTwoSideTransomDoor.calcHinge();
			        if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
				        calcInnerDecoration(armour4040SingleTwoSideTransomDoor, innerDecoration);
			        } else {
				        armour4040SingleTwoSideTransomDoor.calcInnerDecorationWithoutTopTransom(innerDecorationTypeBySelectedItem(innerDecoration));
			        }
			        if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
				        calcOuterDecoration(armour4040SingleTwoSideTransomDoor, outerDecoration);
			        } else {
				        armour4040SingleTwoSideTransomDoor.calcOuterDecorationWithoutTopTransom(outerDecorationTypeBySelectedItem(outerDecoration));
			        }
			        calcPlatband(armour4040SingleTwoSideTransomDoor, platbandType);
			        calcMainLock(armour4040SingleTwoSideTransomDoor, mainLockType);
			        calcSecondaryLock(armour4040SingleTwoSideTransomDoor, secondaryLockType);
			        calcHandle(armour4040SingleTwoSideTransomDoor, handleType);
			        calcProtector(armour4040SingleTwoSideTransomDoor, protectorType);
			        calcSpyHole(armour4040SingleTwoSideTransomDoor, spyHoleType);
			        result = armour4040SingleTwoSideTransomDoor.toString();
		        }
	        }

	        //armour 50x30 door
	        if (doorStructure.equalsIgnoreCase(LabelNames.door50x30)) {
		        if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoor)) {
			        Armour5030SingleDoor armour5030SingleDoor = new Armour5030SingleDoor();
			        armour5030SingleDoor.setX(Integer.parseInt(x.getText()));
			        armour5030SingleDoor.setY(Integer.parseInt(y.getText()));
			        armour5030SingleDoor.setZ(Integer.parseInt(platbandWidth.getText()));
			        armour5030SingleDoor.calcMetalFrameParts();
			        armour5030SingleDoor.calcMetalList();
			        armour5030SingleDoor.calcSeal(true);
			        armour5030SingleDoor.calcHeater(true);
			        armour5030SingleDoor.calcHinge();
			        calcInnerDecoration(armour5030SingleDoor, innerDecoration);
			        calcOuterDecoration(armour5030SingleDoor, outerDecoration);
			        calcPlatband(armour5030SingleDoor, platbandType);
                    calcMainLock(armour5030SingleDoor, mainLockType);
                    calcSecondaryLock(armour5030SingleDoor, secondaryLockType);
                    calcHandle(armour5030SingleDoor, handleType);
                    calcProtector(armour5030SingleDoor, protectorType);
                    calcSpyHole(armour5030SingleDoor, spyHoleType);
			        result = armour5030SingleDoor.toString();
		        }
		        if (doorComplexity.equalsIgnoreCase(LabelNames.doubleDoor)) {
			        Armour5030DoubleDoor armour5030DoubleDoor = new Armour5030DoubleDoor();
			        armour5030DoubleDoor.setX(Integer.parseInt(x.getText()));
			        armour5030DoubleDoor.setX_1(Integer.parseInt(x_1.getText()));
			        armour5030DoubleDoor.setY(Integer.parseInt(y.getText()));
			        armour5030DoubleDoor.setZ(Integer.parseInt(platbandWidth.getText()));
			        armour5030DoubleDoor.calcMetalFrameParts();
			        armour5030DoubleDoor.calcMetalList();
			        armour5030DoubleDoor.calcSeal(true);
			        armour5030DoubleDoor.calcHeater(true);
			        armour5030DoubleDoor.calcHinge();
			        calcInnerDecoration(armour5030DoubleDoor, innerDecoration);
			        calcOuterDecoration(armour5030DoubleDoor, outerDecoration);
			        calcPlatband(armour5030DoubleDoor, platbandType);
			        calcMainLock(armour5030DoubleDoor, mainLockType);
			        calcSecondaryLock(armour5030DoubleDoor, secondaryLockType);
			        calcHandle(armour5030DoubleDoor, handleType);
			        calcProtector(armour5030DoubleDoor, protectorType);
			        calcSpyHole(armour5030DoubleDoor, spyHoleType);
			        result = armour5030DoubleDoor.toString();
		        }
		        if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorSideTransom)) {
			        Armour5030SingleSideTransomDoor armour5030SingleSideTransomDoor = new Armour5030SingleSideTransomDoor();
			        armour5030SingleSideTransomDoor.setX(Integer.parseInt(x.getText()));
			        armour5030SingleSideTransomDoor.setX_1(Integer.parseInt(x_1.getText()));
			        armour5030SingleSideTransomDoor.setY(Integer.parseInt(y.getText()));
			        armour5030SingleSideTransomDoor.setZ(Integer.parseInt(platbandWidth.getText()));
			        armour5030SingleSideTransomDoor.calcMetalFrameParts();
			        armour5030SingleSideTransomDoor.calcMetalList();
			        armour5030SingleSideTransomDoor.calcSeal(true);
			        armour5030SingleSideTransomDoor.calcHeater(true);
			        armour5030SingleSideTransomDoor.calcHinge();
			        if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
				        calcInnerDecoration(armour5030SingleSideTransomDoor, innerDecoration);
			        } else {
				        armour5030SingleSideTransomDoor.calcInnerDecorationWithoutTopTransom(innerDecorationTypeBySelectedItem(innerDecoration));
			        }
			        if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
				        calcOuterDecoration(armour5030SingleSideTransomDoor, outerDecoration);
			        } else {
				        armour5030SingleSideTransomDoor.calcOuterDecorationWithoutTopTransom(outerDecorationTypeBySelectedItem(outerDecoration));
			        }
			        calcPlatband(armour5030SingleSideTransomDoor, platbandType);
			        calcMainLock(armour5030SingleSideTransomDoor, mainLockType);
			        calcSecondaryLock(armour5030SingleSideTransomDoor, secondaryLockType);
			        calcHandle(armour5030SingleSideTransomDoor, handleType);
			        calcProtector(armour5030SingleSideTransomDoor, protectorType);
			        calcSpyHole(armour5030SingleSideTransomDoor, spyHoleType);
			        result = armour5030SingleSideTransomDoor.toString();
		        }
		        if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTopTransom)) {
			        Armour5030SingleTopTransomDoor armour5030SingleTopTransomDoor = new Armour5030SingleTopTransomDoor();
			        armour5030SingleTopTransomDoor.setX(Integer.parseInt(x.getText()));
			        armour5030SingleTopTransomDoor.setY(Integer.parseInt(y.getText()));
			        armour5030SingleTopTransomDoor.setY_1(Integer.parseInt(y_1.getText()));
			        armour5030SingleTopTransomDoor.setZ(Integer.parseInt(platbandWidth.getText()));
			        armour5030SingleTopTransomDoor.calcMetalFrameParts();
			        armour5030SingleTopTransomDoor.calcMetalList();
			        armour5030SingleTopTransomDoor.calcSeal(true);
			        armour5030SingleTopTransomDoor.calcHeater(true);
			        armour5030SingleTopTransomDoor.calcHinge();
			        if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
				        calcInnerDecoration(armour5030SingleTopTransomDoor, innerDecoration);
			        } else {
				        armour5030SingleTopTransomDoor.calcInnerDecorationWithoutTopTransom(innerDecorationTypeBySelectedItem(innerDecoration));
			        }
			        if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
				        calcOuterDecoration(armour5030SingleTopTransomDoor, outerDecoration);
			        } else {
				        armour5030SingleTopTransomDoor.calcOuterDecorationWithoutTopTransom(outerDecorationTypeBySelectedItem(outerDecoration));
			        }
			        calcPlatband(armour5030SingleTopTransomDoor, platbandType);
			        calcMainLock(armour5030SingleTopTransomDoor, mainLockType);
			        calcSecondaryLock(armour5030SingleTopTransomDoor, secondaryLockType);
			        calcHandle(armour5030SingleTopTransomDoor, handleType);
			        calcProtector(armour5030SingleTopTransomDoor, protectorType);
			        calcSpyHole(armour5030SingleTopTransomDoor, spyHoleType);
			        result = armour5030SingleTopTransomDoor.toString();
		        }
		        if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTopSideTransoms)) {
			        Armour5030SingleTwoSideAndTopTransomDoor armour5030SingleTwoSideAndTopTransomDoor = new Armour5030SingleTwoSideAndTopTransomDoor();
			        armour5030SingleTwoSideAndTopTransomDoor.setX(Integer.parseInt(x.getText()));
			        armour5030SingleTwoSideAndTopTransomDoor.setX_1(Integer.parseInt(x_1.getText()));
			        armour5030SingleTwoSideAndTopTransomDoor.setY(Integer.parseInt(y.getText()));
			        armour5030SingleTwoSideAndTopTransomDoor.setY_1(Integer.parseInt(y_1.getText()));
			        armour5030SingleTwoSideAndTopTransomDoor.setZ(Integer.parseInt(platbandWidth.getText()));
			        armour5030SingleTwoSideAndTopTransomDoor.setX_2(Integer.parseInt(x_2.getText()));
			        armour5030SingleTwoSideAndTopTransomDoor.setX_3(Integer.parseInt(x_3.getText()));
			        armour5030SingleTwoSideAndTopTransomDoor.calcMetalFrameParts();
			        armour5030SingleTwoSideAndTopTransomDoor.calcMetalList();
			        armour5030SingleTwoSideAndTopTransomDoor.calcSeal(true);
			        armour5030SingleTwoSideAndTopTransomDoor.calcHeater(true);
			        armour5030SingleTwoSideAndTopTransomDoor.calcHinge();
			        if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
				        calcInnerDecoration(armour5030SingleTwoSideAndTopTransomDoor, innerDecoration);
			        } else {
				        armour5030SingleTwoSideAndTopTransomDoor.calcInnerDecorationWithoutTopSideTransom(innerDecorationTypeBySelectedItem(innerDecoration));
			        }
			        if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
				        calcOuterDecoration(armour5030SingleTwoSideAndTopTransomDoor, outerDecoration);
			        } else {
				        armour5030SingleTwoSideAndTopTransomDoor.calcOuterDecorationWithoutTopSideTransom(outerDecorationTypeBySelectedItem(outerDecoration));
			        }
			        calcPlatband(armour5030SingleTwoSideAndTopTransomDoor, platbandType);
			        calcMainLock(armour5030SingleTwoSideAndTopTransomDoor, mainLockType);
			        calcSecondaryLock(armour5030SingleTwoSideAndTopTransomDoor, secondaryLockType);
			        calcHandle(armour5030SingleTwoSideAndTopTransomDoor, handleType);
			        calcProtector(armour5030SingleTwoSideAndTopTransomDoor, protectorType);
			        calcSpyHole(armour5030SingleTwoSideAndTopTransomDoor, spyHoleType);
			        result = armour5030SingleTwoSideAndTopTransomDoor.toString();
		        }
		        if (doorComplexity.equalsIgnoreCase(LabelNames.doubleDoorTopTransom)) {
			        Armour5030DoubleTopTransomDoor armour5030DoubleTopTransomDoor = new Armour5030DoubleTopTransomDoor();
			        armour5030DoubleTopTransomDoor.setX(Integer.parseInt(x.getText()));
			        armour5030DoubleTopTransomDoor.setX_1(Integer.parseInt(x_1.getText()));
			        armour5030DoubleTopTransomDoor.setY(Integer.parseInt(y.getText()));
			        armour5030DoubleTopTransomDoor.setY_1(Integer.parseInt(y_1.getText()));
			        armour5030DoubleTopTransomDoor.setZ(Integer.parseInt(platbandWidth.getText()));
			        armour5030DoubleTopTransomDoor.calcMetalFrameParts();
			        armour5030DoubleTopTransomDoor.calcMetalList();
			        armour5030DoubleTopTransomDoor.calcSeal(true);
			        armour5030DoubleTopTransomDoor.calcHeater(true);
			        armour5030DoubleTopTransomDoor.calcHinge();
			        if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
				        calcInnerDecoration(armour5030DoubleTopTransomDoor, innerDecoration);
			        } else {
				        armour5030DoubleTopTransomDoor.calcInnerDecorationWithoutTopSideTransom(innerDecorationTypeBySelectedItem(innerDecoration));
			        }
			        if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
				        calcOuterDecoration(armour5030DoubleTopTransomDoor, outerDecoration);
			        } else {
				        armour5030DoubleTopTransomDoor.calcOuterDecorationWithoutTopSideTransom(outerDecorationTypeBySelectedItem(outerDecoration));
			        }
			        calcPlatband(armour5030DoubleTopTransomDoor, platbandType);
			        calcMainLock(armour5030DoubleTopTransomDoor, mainLockType);
			        calcSecondaryLock(armour5030DoubleTopTransomDoor, secondaryLockType);
			        calcHandle(armour5030DoubleTopTransomDoor, handleType);
			        calcProtector(armour5030DoubleTopTransomDoor, protectorType);
			        calcSpyHole(armour5030DoubleTopTransomDoor, spyHoleType);
			        result = armour5030DoubleTopTransomDoor.toString();
		        }
		        if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTwoSideTransoms)) {
			        Armour5030SingleTwoSideTransomDoor armour5030SingleTwoSideTransomDoor = new Armour5030SingleTwoSideTransomDoor();
			        armour5030SingleTwoSideTransomDoor.setX(Integer.parseInt(x.getText()));
			        armour5030SingleTwoSideTransomDoor.setX_1(Integer.parseInt(x_1.getText()));
			        armour5030SingleTwoSideTransomDoor.setY(Integer.parseInt(y.getText()));
			        armour5030SingleTwoSideTransomDoor.setZ(Integer.parseInt(platbandWidth.getText()));
			        armour5030SingleTwoSideTransomDoor.setX_2(Integer.parseInt(x_2.getText()));
			        armour5030SingleTwoSideTransomDoor.setX_3(Integer.parseInt(x_3.getText()));
			        armour5030SingleTwoSideTransomDoor.calcMetalFrameParts();
			        armour5030SingleTwoSideTransomDoor.calcMetalList();
			        armour5030SingleTwoSideTransomDoor.calcSeal(true);
			        armour5030SingleTwoSideTransomDoor.calcHeater(true);
			        armour5030SingleTwoSideTransomDoor.calcHinge();
			        if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
				        calcInnerDecoration(armour5030SingleTwoSideTransomDoor, innerDecoration);
			        } else {
				        armour5030SingleTwoSideTransomDoor.calcInnerDecorationWithoutTopTransom(innerDecorationTypeBySelectedItem(innerDecoration));
			        }
			        if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
				        calcOuterDecoration(armour5030SingleTwoSideTransomDoor, outerDecoration);
			        } else {
				        armour5030SingleTwoSideTransomDoor.calcOuterDecorationWithoutTopTransom(outerDecorationTypeBySelectedItem(outerDecoration));
			        }
			        calcPlatband(armour5030SingleTwoSideTransomDoor, platbandType);
			        calcMainLock(armour5030SingleTwoSideTransomDoor, mainLockType);
			        calcSecondaryLock(armour5030SingleTwoSideTransomDoor, secondaryLockType);
			        calcHandle(armour5030SingleTwoSideTransomDoor, handleType);
			        calcProtector(armour5030SingleTwoSideTransomDoor, protectorType);
			        calcSpyHole(armour5030SingleTwoSideTransomDoor, spyHoleType);
			        result = armour5030SingleTwoSideTransomDoor.toString();
		        }
	        }

            //angled door double frame
            if (doorStructure.equalsIgnoreCase(LabelNames.angledDoubleDoor)) {
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoor)) {
                    DoubleFrameAngledDoor doubleFrameAngledDoor = new DoubleFrameAngledDoor();
                    doubleFrameAngledDoor.setX(Integer.parseInt(x.getText()));
                    doubleFrameAngledDoor.setY(Integer.parseInt(y.getText()));
                    doubleFrameAngledDoor.setZ(Integer.parseInt(platbandWidth.getText()));
                    doubleFrameAngledDoor.calcMetalFrameParts();
                    doubleFrameAngledDoor.calcMetalList();
                    doubleFrameAngledDoor.calcSeal(true);
                    doubleFrameAngledDoor.calcHeater(true);
                    doubleFrameAngledDoor.calcHinge();
                    calcInnerDecoration(doubleFrameAngledDoor, innerDecoration);
                    calcOuterDecoration(doubleFrameAngledDoor, outerDecoration);
                    calcPlatband(doubleFrameAngledDoor, platbandType);
                    calcMainLock(doubleFrameAngledDoor, mainLockType);
                    calcSecondaryLock(doubleFrameAngledDoor, secondaryLockType);
                    calcHandle(doubleFrameAngledDoor, handleType);
                    calcProtector(doubleFrameAngledDoor, protectorType);
                    calcSpyHole(doubleFrameAngledDoor, spyHoleType);
                    result = doubleFrameAngledDoor.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.doubleDoor)) {
                    DoubleFrameDoubleDoor doubleFrameDoubleDoor = new DoubleFrameDoubleDoor();
                    doubleFrameDoubleDoor.setX(Integer.parseInt(x.getText()));
                    doubleFrameDoubleDoor.setX_1(Integer.parseInt(x_1.getText()));
                    doubleFrameDoubleDoor.setY(Integer.parseInt(y.getText()));
                    doubleFrameDoubleDoor.setZ(Integer.parseInt(platbandWidth.getText()));
                    doubleFrameDoubleDoor.calcMetalFrameParts();
                    doubleFrameDoubleDoor.calcMetalList();
                    doubleFrameDoubleDoor.calcSeal(true);
                    doubleFrameDoubleDoor.calcHeater(true);
                    doubleFrameDoubleDoor.calcHinge();
                    calcInnerDecoration(doubleFrameDoubleDoor, innerDecoration);
                    calcOuterDecoration(doubleFrameDoubleDoor, outerDecoration);
                    calcPlatband(doubleFrameDoubleDoor, platbandType);
	                calcMainLock(doubleFrameDoubleDoor, mainLockType);
	                calcSecondaryLock(doubleFrameDoubleDoor, secondaryLockType);
	                calcHandle(doubleFrameDoubleDoor, handleType);
	                calcProtector(doubleFrameDoubleDoor, protectorType);
	                calcSpyHole(doubleFrameDoubleDoor, spyHoleType);
                    result = doubleFrameDoubleDoor.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorSideTransom)) {
                    DoubleFrameSingleSideTransomDoor doubleFrameSingleSideTransomDoor = new DoubleFrameSingleSideTransomDoor();
                    doubleFrameSingleSideTransomDoor.setX(Integer.parseInt(x.getText()));
                    doubleFrameSingleSideTransomDoor.setX_1(Integer.parseInt(x_1.getText()));
                    doubleFrameSingleSideTransomDoor.setY(Integer.parseInt(y.getText()));
                    doubleFrameSingleSideTransomDoor.setZ(Integer.parseInt(platbandWidth.getText()));
                    doubleFrameSingleSideTransomDoor.calcMetalFrameParts();
                    doubleFrameSingleSideTransomDoor.calcMetalList();
                    doubleFrameSingleSideTransomDoor.calcSeal(true);
                    doubleFrameSingleSideTransomDoor.calcHeater(true);
                    doubleFrameSingleSideTransomDoor.calcHinge();
                    if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
                        calcInnerDecoration(doubleFrameSingleSideTransomDoor, innerDecoration);
                    } else {
                        doubleFrameSingleSideTransomDoor.calcInnerDecorationWithoutTopTransom(innerDecorationTypeBySelectedItem(innerDecoration));
                    }
                    if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
                        calcOuterDecoration(doubleFrameSingleSideTransomDoor, outerDecoration);
                    } else {
                        doubleFrameSingleSideTransomDoor.calcOuterDecorationWithoutTopTransom(outerDecorationTypeBySelectedItem(outerDecoration));
                    }
                    calcPlatband(doubleFrameSingleSideTransomDoor, platbandType);
	                calcMainLock(doubleFrameSingleSideTransomDoor, mainLockType);
	                calcSecondaryLock(doubleFrameSingleSideTransomDoor, secondaryLockType);
	                calcHandle(doubleFrameSingleSideTransomDoor, handleType);
	                calcProtector(doubleFrameSingleSideTransomDoor, protectorType);
	                calcSpyHole(doubleFrameSingleSideTransomDoor, spyHoleType);
                    result = doubleFrameSingleSideTransomDoor.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTopTransom)) {
                    DoubleFrameSingleTopTransomDoor doubleFrameSingleTopTransomDoor = new DoubleFrameSingleTopTransomDoor();
                    doubleFrameSingleTopTransomDoor.setX(Integer.parseInt(x.getText()));
                    doubleFrameSingleTopTransomDoor.setY(Integer.parseInt(y.getText()));
                    doubleFrameSingleTopTransomDoor.setY_1(Integer.parseInt(y_1.getText()));
                    doubleFrameSingleTopTransomDoor.setZ(Integer.parseInt(platbandWidth.getText()));
                    doubleFrameSingleTopTransomDoor.calcMetalFrameParts();
                    doubleFrameSingleTopTransomDoor.calcMetalList();
                    doubleFrameSingleTopTransomDoor.calcSeal(true);
                    doubleFrameSingleTopTransomDoor.calcHeater(true);
                    doubleFrameSingleTopTransomDoor.calcHinge();
                    if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
                        calcInnerDecoration(doubleFrameSingleTopTransomDoor, innerDecoration);
                    } else {
                        doubleFrameSingleTopTransomDoor.calcInnerDecorationWithoutTopTransom(innerDecorationTypeBySelectedItem(innerDecoration));
                    }
                    if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
                        calcOuterDecoration(doubleFrameSingleTopTransomDoor, outerDecoration);
                    } else {
                        doubleFrameSingleTopTransomDoor.calcOuterDecorationWithoutTopTransom(outerDecorationTypeBySelectedItem(outerDecoration));
                    }
                    calcPlatband(doubleFrameSingleTopTransomDoor, platbandType);
	                calcMainLock(doubleFrameSingleTopTransomDoor, mainLockType);
	                calcSecondaryLock(doubleFrameSingleTopTransomDoor, secondaryLockType);
	                calcHandle(doubleFrameSingleTopTransomDoor, handleType);
	                calcProtector(doubleFrameSingleTopTransomDoor, protectorType);
	                calcSpyHole(doubleFrameSingleTopTransomDoor, spyHoleType);
                    result = doubleFrameSingleTopTransomDoor.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTopSideTransoms)) {
                    DoubleFrameSingleTwoSideAndTopTransomDoor doubleFrameSingleTwoSideAndTopTransomDoor = new DoubleFrameSingleTwoSideAndTopTransomDoor();
                    doubleFrameSingleTwoSideAndTopTransomDoor.setX(Integer.parseInt(x.getText()));
                    doubleFrameSingleTwoSideAndTopTransomDoor.setX_1(Integer.parseInt(x_1.getText()));
                    doubleFrameSingleTwoSideAndTopTransomDoor.setY(Integer.parseInt(y.getText()));
                    doubleFrameSingleTwoSideAndTopTransomDoor.setY_1(Integer.parseInt(y_1.getText()));
                    doubleFrameSingleTwoSideAndTopTransomDoor.setZ(Integer.parseInt(platbandWidth.getText()));
                    doubleFrameSingleTwoSideAndTopTransomDoor.setX_2(Integer.parseInt(x_2.getText()));
                    doubleFrameSingleTwoSideAndTopTransomDoor.setX_3(Integer.parseInt(x_3.getText()));
                    doubleFrameSingleTwoSideAndTopTransomDoor.calcMetalFrameParts();
                    doubleFrameSingleTwoSideAndTopTransomDoor.calcMetalList();
                    doubleFrameSingleTwoSideAndTopTransomDoor.calcSeal(true);
                    doubleFrameSingleTwoSideAndTopTransomDoor.calcHeater(true);
                    doubleFrameSingleTwoSideAndTopTransomDoor.calcHinge();
                    if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
                        calcInnerDecoration(doubleFrameSingleTwoSideAndTopTransomDoor, innerDecoration);
                    } else {
                        doubleFrameSingleTwoSideAndTopTransomDoor.calcInnerDecorationWithoutTopSideTransom(innerDecorationTypeBySelectedItem(innerDecoration));
                    }
                    if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
                        calcOuterDecoration(doubleFrameSingleTwoSideAndTopTransomDoor, outerDecoration);
                    } else {
                        doubleFrameSingleTwoSideAndTopTransomDoor.calcOuterDecorationWithoutTopSideTransom(outerDecorationTypeBySelectedItem(outerDecoration));
                    }
                    calcPlatband(doubleFrameSingleTwoSideAndTopTransomDoor, platbandType);
	                calcMainLock(doubleFrameSingleTwoSideAndTopTransomDoor, mainLockType);
	                calcSecondaryLock(doubleFrameSingleTwoSideAndTopTransomDoor, secondaryLockType);
	                calcHandle(doubleFrameSingleTwoSideAndTopTransomDoor, handleType);
	                calcProtector(doubleFrameSingleTwoSideAndTopTransomDoor, protectorType);
	                calcSpyHole(doubleFrameSingleTwoSideAndTopTransomDoor, spyHoleType);
                    result = doubleFrameSingleTwoSideAndTopTransomDoor.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.doubleDoorTopTransom)) {
                    DoubleFrameDoubleTopTransomDoor doubleFrameDoubleTopTransomDoor = new DoubleFrameDoubleTopTransomDoor();
                    doubleFrameDoubleTopTransomDoor.setX(Integer.parseInt(x.getText()));
                    doubleFrameDoubleTopTransomDoor.setX_1(Integer.parseInt(x_1.getText()));
                    doubleFrameDoubleTopTransomDoor.setY(Integer.parseInt(y.getText()));
                    doubleFrameDoubleTopTransomDoor.setY_1(Integer.parseInt(y_1.getText()));
                    doubleFrameDoubleTopTransomDoor.setZ(Integer.parseInt(platbandWidth.getText()));
                    doubleFrameDoubleTopTransomDoor.calcMetalFrameParts();
                    doubleFrameDoubleTopTransomDoor.calcMetalList();
                    doubleFrameDoubleTopTransomDoor.calcSeal(true);
                    doubleFrameDoubleTopTransomDoor.calcHeater(true);
                    doubleFrameDoubleTopTransomDoor.calcHinge();
                    if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
                        calcInnerDecoration(doubleFrameDoubleTopTransomDoor, innerDecoration);
                    } else {
                        doubleFrameDoubleTopTransomDoor.calcInnerDecorationWithoutTopSideTransom(innerDecorationTypeBySelectedItem(innerDecoration));
                    }
                    if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
                        calcOuterDecoration(doubleFrameDoubleTopTransomDoor, outerDecoration);
                    } else {
                        doubleFrameDoubleTopTransomDoor.calcOuterDecorationWithoutTopSideTransom(outerDecorationTypeBySelectedItem(outerDecoration));
                    }
                    calcPlatband(doubleFrameDoubleTopTransomDoor, platbandType);
	                calcMainLock(doubleFrameDoubleTopTransomDoor, mainLockType);
	                calcSecondaryLock(doubleFrameDoubleTopTransomDoor, secondaryLockType);
	                calcHandle(doubleFrameDoubleTopTransomDoor, handleType);
	                calcProtector(doubleFrameDoubleTopTransomDoor, protectorType);
	                calcSpyHole(doubleFrameDoubleTopTransomDoor, spyHoleType);
                    result = doubleFrameDoubleTopTransomDoor.toString();
                }
                if (doorComplexity.equalsIgnoreCase(LabelNames.singleDoorTwoSideTransoms)) {
                    DoubleFrameSingleTwoSideTransomDoor doubleFrameSingleTwoSideTransomDoor = new DoubleFrameSingleTwoSideTransomDoor();
                    doubleFrameSingleTwoSideTransomDoor.setX(Integer.parseInt(x.getText()));
                    doubleFrameSingleTwoSideTransomDoor.setX_1(Integer.parseInt(x_1.getText()));
                    doubleFrameSingleTwoSideTransomDoor.setY(Integer.parseInt(y.getText()));
                    doubleFrameSingleTwoSideTransomDoor.setZ(Integer.parseInt(platbandWidth.getText()));
                    doubleFrameSingleTwoSideTransomDoor.setX_2(Integer.parseInt(x_2.getText()));
                    doubleFrameSingleTwoSideTransomDoor.setX_3(Integer.parseInt(x_3.getText()));
                    doubleFrameSingleTwoSideTransomDoor.calcMetalFrameParts();
                    doubleFrameSingleTwoSideTransomDoor.calcMetalList();
                    doubleFrameSingleTwoSideTransomDoor.calcSeal(true);
                    doubleFrameSingleTwoSideTransomDoor.calcHeater(true);
                    doubleFrameSingleTwoSideTransomDoor.calcHinge();
                    if (innerTransomDecoration.equals(LabelNames.innerWithTransomDecoration)) {
                        calcInnerDecoration(doubleFrameSingleTwoSideTransomDoor, innerDecoration);
                    } else {
                        doubleFrameSingleTwoSideTransomDoor.calcInnerDecorationWithoutTopTransom(innerDecorationTypeBySelectedItem(innerDecoration));
                    }
                    if (outerTransomDecoration.equals(LabelNames.outerWithTransomDecoration)) {
                        calcOuterDecoration(doubleFrameSingleTwoSideTransomDoor, outerDecoration);
                    } else {
                        doubleFrameSingleTwoSideTransomDoor.calcOuterDecorationWithoutTopTransom(outerDecorationTypeBySelectedItem(outerDecoration));
                    }
                    calcPlatband(doubleFrameSingleTwoSideTransomDoor, platbandType);
	                calcMainLock(doubleFrameSingleTwoSideTransomDoor, mainLockType);
	                calcSecondaryLock(doubleFrameSingleTwoSideTransomDoor, secondaryLockType);
	                calcHandle(doubleFrameSingleTwoSideTransomDoor, handleType);
	                calcProtector(doubleFrameSingleTwoSideTransomDoor, protectorType);
	                calcSpyHole(doubleFrameSingleTwoSideTransomDoor, spyHoleType);
                    result = doubleFrameSingleTwoSideTransomDoor.toString();
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
	            calcMainLock(singleFireProofDoor, mainLockType);
	            calcSecondaryLock(singleFireProofDoor, secondaryLockType);
	            calcHandle(singleFireProofDoor, handleType);
	            calcProtector(singleFireProofDoor, protectorType);
	            calcSpyHole(singleFireProofDoor, spyHoleType);
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
	            calcMainLock(doubleFireProofDoor, mainLockType);
	            calcSecondaryLock(doubleFireProofDoor, secondaryLockType);
	            calcHandle(doubleFireProofDoor, handleType);
	            calcProtector(doubleFireProofDoor, protectorType);
	            calcSpyHole(doubleFireProofDoor, spyHoleType);
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

    private static void calcMainLock(Door angledDoor, String mainLock) {
        if (mainLock.equalsIgnoreCase(LabelNames.kale257))
            angledDoor.calcMainLock(AccessoriesType.MAIN_LOCKER_KALE_257L);
        if (mainLock.equalsIgnoreCase(LabelNames.kale189))
            angledDoor.calcMainLock(AccessoriesType.MAIN_LOCKER_KALE_1894);
        if (mainLock.equalsIgnoreCase(LabelNames.elbor))
            angledDoor.calcMainLock(AccessoriesType.MAIN_LOCKER_ELBOR);
    }

    private static void calcSecondaryLock(Door angledDoor, String secondaryLock) {
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

    private static void calcHandle(Door angledDoor, String handle) {
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

    private static void calcProtector(Door angledDoor, String protector) {
        if (protector.equalsIgnoreCase(LabelNames.noProtector))
            angledDoor.calcProtector(AccessoriesType.NO_PROTECTOR);
        if (protector.equalsIgnoreCase(LabelNames.apecsProtector))
            angledDoor.calcProtector(AccessoriesType.PROTECTOR_APECS);
    }

    private static void calcSpyHole(Door angledDoor, String spyHole) {
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
