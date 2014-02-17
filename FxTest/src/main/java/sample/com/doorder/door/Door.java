package sample.com.doorder.door;

public interface Door {

    void calcMetalFrameParts();

    void calcMetalList();

    void calcHinge();

    void calcHeater(boolean heaterNeeded);

    void calcSeal(boolean sealNeeded);

    void calcOuterDecoration(OuterDecorationType outerDecorationType);

    void calcInnerDecoration(InnerDecorationType innerDecorationType);

    void calcPlatband(PlatbandType platbandType);

    void calcAccessories();

}
