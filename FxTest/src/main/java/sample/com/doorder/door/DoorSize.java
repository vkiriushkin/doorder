package sample.com.doorder.door;

public class DoorSize {
    private static DoorSize ourInstance = new DoorSize();

    private int doorWidthInMillimeters;
    private int doorHeightInMillimeters;

    public static DoorSize getInstance() {
        return ourInstance;
    }

    private DoorSize() {
    }

    public int getDoorWidthInMillimeters() {
        return doorWidthInMillimeters;
    }

    public void setDoorWidthInMillimeters(int doorWidthInMillimeters) {
        this.doorWidthInMillimeters = doorWidthInMillimeters;
    }

    public int getDoorHeightInMillimeters() {
        return doorHeightInMillimeters;
    }

    public void setDoorHeightInMillimeters(int doorHeightInMillimeters) {
        this.doorHeightInMillimeters = doorHeightInMillimeters;
    }
}
