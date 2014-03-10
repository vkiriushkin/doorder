package sample;

import javafx.scene.image.Image;
import sample.com.doorder.door.LabelNames;

import java.util.Arrays;

public enum DoorType {
    ANGLED_SINGLE_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoor,LabelNames.leftOpeningDoor,"singleLeft.png",
            500, 1200, 1000, 2450,
            0, 0, 0, 0,
            0, 0, 0, 0),
    ANGLED_SINGLE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoor,LabelNames.rightOpeningDoor,"singleRight.png",
            500, 1200, 1000, 2450,
            0, 0, 0, 0,
            0, 0, 0, 0),
    ANGLED_SINGLE_TOP_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTopTransom,LabelNames.leftOpeningDoor,"singleTopTransomLeft.png",
            500, 1200, 1000, 3000,
            0, 0, 1000, 2450,
            0, 0, 0, 0),
    ANGLED_SINGLE_TOP_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTopTransom,LabelNames.rightOpeningDoor,"singleTopTransomRight.png",
            500, 1200, 1000, 3000,
            0, 0, 1000, 2450,
            0, 0, 0, 0),
    ANGLED_DOUBLE_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.doubleDoor,LabelNames.leftOpeningDoor,"doubleLeft.png",
            800, 1950, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0),
    ANGLED_DOUBLE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.doubleDoor,LabelNames.rightOpeningDoor,"doubleRight.png",
            800, 1950, 1000, 2450,
            400, 1200, 0, 0,
            0, 0, 0, 0),
    ANGLED_SINGLE_SIDE_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorSideTransom,LabelNames.leftOpeningDoor,"singleSideTransomLeft.png",
            800, 1950, 1000, 2450,
            0, 1200, 0, 0,
            0, 0, 0, 0),
    ANGLED_SINGLE_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorSideTransom,LabelNames.rightOpeningDoor,"singleSideTransomRight.png",
            800, 1950, 1000, 2450,
            0, 1200, 0, 0,
            0, 0, 0, 0),
    ANGLED_SINGLE_TOP_SIDE_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTopSideTransoms,LabelNames.leftOpeningDoor,"singleTopSideTransomLeft.png",
            800, 3000, 1000, 3000,
            500, 1250, 1000, 2450,
            0, 0, 0, 0),
    ANGLED_SINGLE_TOP_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTopSideTransoms,LabelNames.rightOpeningDoor,"singleTopSideTransomRight.png",
            800, 3000, 1000, 3000,
            500, 1250, 1000, 2450,
            0, 0, 0, 0),
    ANGLED_DOUBLE_TOP_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.doubleDoorTopTransom,LabelNames.leftOpeningDoor,"doubleTopTransomLeft.png",
            800, 1950, 1000, 3000,
            400, 1200, 1000, 2450,
            0, 0, 0, 0),
    ANGLED_DOUBLE_TOP_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.doubleDoorTopTransom,LabelNames.rightOpeningDoor,"doubleTopTransomRight.png",
            800, 1950, 1000, 3000,
            400, 1200, 1000, 2450,
            0, 0, 0, 0),
    ANGLED_SINGLE_TWO_SIDE_LEFT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTwoSideTransoms,LabelNames.leftOpeningDoor,"singleTwoSideTransomLeft.png",
            800, 3000, 1000, 2450,
            500, 1250, 0, 0,
            0, 0, 0, 0),
    ANGLED_SINGLE_TWO_SIDE_RIGHT(LabelNames.metalDoor,LabelNames.angledDoor,LabelNames.singleDoorTwoSideTransoms,LabelNames.rightOpeningDoor,"singleTwoSideTransomRight.png",
            800, 3000, 1000, 2450,
            500, 1250, 0, 0,
            0, 0, 0, 0),

    FIREPROOF_SINGLE_LEFT(LabelNames.fireproofDoor,null,LabelNames.singleDoor,LabelNames.leftOpeningDoor,"singleLeft.png",
            500, 1100, 1000, 2550,
            0, 0, 0, 0,
            0, 0, 0, 0),
    FIREPROOF_SINGLE_RIGHT(LabelNames.fireproofDoor,null,LabelNames.singleDoor,LabelNames.rightOpeningDoor,"singleRight.png",
            500, 1100, 1000, 2550,
            0, 0, 0, 0,
            0, 0, 0, 0),
    FIREPROOF_DOUBLE_LEFT(LabelNames.fireproofDoor,null,LabelNames.doubleDoor,LabelNames.leftOpeningDoor,"doubleLeft.png",
            800, 2000, 1000, 2550,
            0, 1100, 0, 0,
            0, 0, 0, 0),
    FIREPROOF_DOUBLE_RIGHT(LabelNames.fireproofDoor,null,LabelNames.doubleDoor,LabelNames.rightOpeningDoor,"doubleRight.png",
            800, 2000, 1000, 2550,
            0, 1100, 0, 0,
            0, 0, 0, 0),
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

    private DoorType(String doorType, String doorStructureType, String doorComplexityCategory, String doorOpeningSide, String doorImageName,
                     int minX, int maxX, int minY, int maxY,
                     int minX1, int maxX1, int minY1, int maxY1,
                     int minX2, int maxX2, int minX3, int maxX3) {
        this.doorType = doorType;
        this.doorStructureType = doorStructureType;
        this.doorComplexityCategory = doorComplexityCategory;
        this.doorOpeningSide = doorOpeningSide;
        this.doorImage = new Image(DoorType.class.getResourceAsStream(doorImageName));
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
}
