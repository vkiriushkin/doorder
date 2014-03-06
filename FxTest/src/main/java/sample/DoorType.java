package sample;

import javafx.scene.image.Image;
import sample.com.doorder.door.LabelNames;

import java.util.Arrays;

public enum DoorType {
    ANGLED_SINGLE_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoor,LabelNames.leftOpeningDoor,"singleLeft.png"),
    ANGLED_SINGLE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoor,LabelNames.rightOpeningDoor,"singleRight.png"),
    ANGLED_SINGLE_TOP_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTopTransom,LabelNames.leftOpeningDoor,"singleTopTransomLeft.png"),
    ANGLED_SINGLE_TOP_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTopTransom,LabelNames.rightOpeningDoor,"singleTopTransomRight.png"),
    ANGLED_DOUBLE_TOP_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.doubleDoorTopTransom,LabelNames.leftOpeningDoor,"doubleTopTransomLeft.png"),
    ANGLED_DOUBLE_TOP_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.doubleDoorTopTransom,LabelNames.rightOpeningDoor,"doubleTopTransomRight.png"),
    ANGLED_SINGLE_SIDE_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorSideTransom,LabelNames.leftOpeningDoor,"singleSideTransomLeft.png"),
    ANGLED_SINGLE_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorSideTransom,LabelNames.rightOpeningDoor,"singleSideTransomRight.png"),
    ANGLED_SINGLE_TWO_SIDE_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTwoSideTransoms,LabelNames.leftOpeningDoor,"singleTwoSideTransomLeft.png"),
    ANGLED_SINGLE_TWO_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTwoSideTransoms,LabelNames.rightOpeningDoor,"singleTwoSideTransomRight.png"),
    ANGLED_SINGLE_TOP_SIDE_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTopSideTransoms,LabelNames.leftOpeningDoor,"singleTopSideTransomLeft.png"),
    ANGLED_SINGLE_TOP_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTopSideTransoms,LabelNames.rightOpeningDoor,"singleTopSideTransomRight.png"),
    ANGLED_DOUBLE_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.doubleDoor,LabelNames.leftOpeningDoor,"doubleLeft.png"),
    ANGLED_DOUBLE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.doubleDoor,LabelNames.rightOpeningDoor,"doubleRight.png")
    ;

    public static DoorType selectDoorBy(String doorType, String doorStructureType, String doorComplexityCategory, String doorOpeningSide) {
        DoorType selectedDoorType = null;
        for (DoorType door : Arrays.asList(DoorType.values())) {
            if (door.getDoorType().equals(doorType)
                    && door.getDoorStructureType().equals(doorStructureType)
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

    private DoorType(String doorType, String doorStructureType, String doorComplexityCategory, String doorOpeningSide, String doorImageName) {
        this.doorType = doorType;
        this.doorStructureType = doorStructureType;
        this.doorComplexityCategory = doorComplexityCategory;
        this.doorOpeningSide = doorOpeningSide;
        this.doorImage = new Image(DoorType.class.getResourceAsStream(doorImageName));
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
}
