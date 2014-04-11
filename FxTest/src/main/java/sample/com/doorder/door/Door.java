package sample.com.doorder.door;

import sample.com.doorder.door.types.AccessoriesType;

public interface Door {
	void calcMainLock(AccessoriesType mainLockType);

	void calcSecondaryLock(AccessoriesType secondaryLockType);

	void calcHandle(AccessoriesType handleType);

	void calcProtector(AccessoriesType protectorType);

	void calcSpyHole(AccessoriesType spyHoleType);
}
