package sample.com.doorder.door;

public interface MetalDoor extends Door {

    void calcMetalFrameParts();

    void calcMetalList();

    void calcHinge();

    void calcHeater(boolean heaterNeeded);

    void calcSeal(boolean sealNeeded);

    void calcOuterDecoration(OuterDecorationType outerDecorationType);

    void calcInnerDecoration(InnerDecorationType innerDecorationType);

    void calcPlatband(PlatbandType platbandType);

    void calcMainLock(AccessoriesType mainLockType);

    void calcSecondaryLock(AccessoriesType secondaryLockType);

    void calcHandle(AccessoriesType handleType);

    void calcProtector(AccessoriesType protectorType);

    void calcSpyHole(AccessoriesType spyHoleType);

}
