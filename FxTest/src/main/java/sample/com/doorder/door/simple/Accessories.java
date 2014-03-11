package sample.com.doorder.door.simple;

import sample.com.doorder.door.AccessoriesType;
import sample.com.doorder.door.Price;

public class Accessories {

	private double spyHolePrice;
	private double mainLockPrice;
	private double secondaryLockPrice;
	private double handlePrice;
	private double protectorPrice;
	private double totalAccessoriesPrice;

	public void calcSpyHolder(AccessoriesType spyHoleType) {
		totalAccessoriesPrice -= spyHolePrice;
		switch (spyHoleType) {
			case SPY_HOLE_200:
				spyHolePrice = Price.SPY_HOLE_200.getPriceInUAH();
				break;
			case SPY_HOLE_10_200:
				spyHolePrice = Price.SPY_HOLE_10_200.getPriceInUAH();
				break;
            case NO_SPY_HOLE:
                spyHolePrice = 0;
                break;
		}
		totalAccessoriesPrice += spyHolePrice;
	}

	public void calcMainLock(AccessoriesType mainLockType) {
		totalAccessoriesPrice -= mainLockPrice;
		switch (mainLockType) {
			case MAIN_LOCKER_KALE_257L:
				mainLockPrice = Price.TOP_LOCKER_KALE_257L.getPriceInUAH();
				break;
			case MAIN_LOCKER_KALE_1894:
				mainLockPrice = Price.TOP_LOCKER_KALE_1894.getPriceInUAH();
				break;
			case MAIN_LOCKER_ELBOR:
				mainLockPrice = Price.TOP_LOCKER_ELBOR.getPriceInUAH();
				break;
		}
		totalAccessoriesPrice += mainLockPrice;
	}

	public void calcSecondaryLock(AccessoriesType secondaryLockType) {
		totalAccessoriesPrice -= secondaryLockPrice;
		switch (secondaryLockType) {
			case SECONDARY_LOCKER_KALE_25R:
				secondaryLockPrice = Price.BOTTOM_LOCKER_KALE_25R.getPriceInUAH();
				break;
			case SECONDARY_LOCKER_MOTTURA_54797:
				secondaryLockPrice = Price.BOTTOM_LOCKER_MOTTURA_54797.getPriceInUAH();
				break;
			case SECONDARY_LOCKER_APECS_2200:
				secondaryLockPrice = Price.BOTTOM_LOCKER_APECS_2200.getPriceInUAH();
				break;
			case SECONDARY_LOCKER_KALE_2000:
				secondaryLockPrice = Price.BOTTOM_LOCKER_KALE_2000.getPriceInUAH();
				break;
            case NO_SECONDARY_LOCKER:
                secondaryLockPrice = 0;
                break;
		}
		totalAccessoriesPrice += secondaryLockPrice;
	}

    public void calcHandle(AccessoriesType handleType) {
        totalAccessoriesPrice -= handlePrice;
        switch (handleType) {
            case HANDLE_APECS_CHROME:
                handlePrice = Price.HANDLE_APECS_CHROME.getPriceInUAH();
                break;
            case HANDLE_APECS_GOLD:
                handlePrice = Price.HANDLE_APECS_GOLD.getPriceInUAH();
                break;
            case HANDLE_APECS_PLAT_CHROME:
                handlePrice = Price.HANDLE_APECS_PLAT_CHROME.getPriceInUAH();
                break;
            case HANDLE_APECS_PLAT_GOLD:
                handlePrice = Price.HANDLE_APECS_PLAT_GOLD.getPriceInUAH();
                break;
            case HANDLE_AYDEMIR_BROWN:
                handlePrice = Price.HANDLE_AYDEMIR_BROWN.getPriceInUAH();
                break;
            case HANDLE_AYDEMIR_BLACK:
                handlePrice = Price.HANDLE_AYDEMIR_BLACK.getPriceInUAH();
                break;
        }
        totalAccessoriesPrice += handlePrice;
    }

    public void calcProtector(AccessoriesType protectorType) {
        totalAccessoriesPrice -= protectorPrice;
        switch (protectorType) {
            case PROTECTOR_APECS:
                protectorPrice = Price.PROTECTOR_APECS.getPriceInUAH();
                break;
            case NO_PROTECTOR:
                protectorPrice = 0;
                break;
        }
        totalAccessoriesPrice += protectorPrice;
    }

	public double getTotalAccessoriesPrice() {
		return totalAccessoriesPrice;
	}

    public double getSpyHolePrice() {
        return spyHolePrice;
    }

    public double getMainLockPrice() {
        return mainLockPrice;
    }

    public double getSecondaryLockPrice() {
        return secondaryLockPrice;
    }

    public double getHandlePrice() {
        return handlePrice;
    }

    public double getProtectorPrice() {
        return protectorPrice;
    }
}
