package sample.com.doorder.door.simple;

public class Accessories {

	private double spyHolePrice;
	private double topLockerPrice;
	private double bottomLockerPrice;
	private double totalAccessoriesPrice;

//	public void calcSpyHolder(int type) {
//		totalAccessoriesPrice -= spyHolePrice;
//		switch (type) {
//			case 0:
//				spyHolePrice = 0;
//				break;
//			case 1:
//				spyHolePrice = Price.SPY_HOLE_TYPE1.getPriceInUAH();
//				break;
//			case 2:
//				spyHolePrice = Price.SPY_HOLE_TYPE2.getPriceInUAH();
//				break;
//			case 3:
//				spyHolePrice = Price.SPY_HOLE_TYPE3.getPriceInUAH();
//				break;
//		}
//		totalAccessoriesPrice += spyHolePrice;
//	}

//	public void calcTopLocker(int type) {
//		totalAccessoriesPrice -= topLockerPrice;
//		switch (type) {
//			case 0:
//				topLockerPrice = 0;
//				break;
//			case 1:
//				topLockerPrice = Price.TOP_LOCKER_TYPE1.getPriceInUAH();
//				break;
//			case 2:
//				topLockerPrice = Price.TOP_LOCKER_TYPE2.getPriceInUAH();
//				break;
//			case 3:
//				topLockerPrice = Price.TOP_LOCKER_TYPE3.getPriceInUAH();
//				break;
//		}
//		totalAccessoriesPrice += topLockerPrice;
//	}
//
//	public void calcBottomLocker(int type) {
//		totalAccessoriesPrice -= bottomLockerPrice;
//		switch (type) {
//			case 0:
//				bottomLockerPrice = 0;
//				break;
//			case 1:
//				bottomLockerPrice = Price.BOTTOM_LOCKER_TYPE1.getPriceInUAH();
//				break;
//			case 2:
//				bottomLockerPrice = Price.BOTTOM_LOCKER_TYPE2.getPriceInUAH();
//				break;
//			case 3:
//				bottomLockerPrice = Price.BOTTOM_LOCKER_TYPE3.getPriceInUAH();
//				break;
//		}
//		totalAccessoriesPrice += bottomLockerPrice;
//	}

	public double getTotalAccessoriesPrice() {
		return totalAccessoriesPrice;
	}
}
