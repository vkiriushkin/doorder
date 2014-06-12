package sample.com.doorder.door;

import sample.com.doorder.door.types.AccessoriesType;

public interface Door {
	void calcMainLock(AccessoriesType mainLockType);

	void calcSecondaryLock(AccessoriesType secondaryLockType);

	void calcHandle(AccessoriesType handleType);

	void calcProtector(AccessoriesType protectorType);

	void calcSpyHole(AccessoriesType spyHoleType);

    void calcOptions(boolean shippingNeeded, String shipping,
                     boolean packagingNeeded,
                     boolean installationNeeded, String installNeeded,
                     double profit, double workCost, int profitPercent);
}
