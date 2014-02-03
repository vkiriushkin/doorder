package sample.com.doorder.door;

public interface Door {

    void calcMetalFrameParts();

    void calcMetalList();

    void calcHinge();

    void calcHeater(boolean heaterNeeded);

    void calcSeal(boolean sealNeeded);

    void calcOuterFacing();

    void calcInnerFacing();

    void calcPlatband();

    void calcAccessories();

}
