package sample.com.doorder.door.fireproof;

import sample.com.doorder.door.Accessories;
import sample.com.doorder.door.types.AccessoriesType;

public abstract class FireProofDoorImpl implements FireProofDoor {

	private int x;
	private int y;
	private int x_1;
    protected Accessories accessories;

	protected double totalPrice;
	protected double metalFramesPartsTotalPrice;
	protected double metal_40x40_Price;
	protected double metal_40x20_Price;
	protected double innerMetalListPrice;
	protected double outerMetalListPrice;
	protected double hingePrice;
	protected double ograskPrice;
	protected double dryWallPrice;
	protected double mineralWoolPrice;
	protected double sealPrice;
	protected double outerDecorationPrice;
	protected double innerDecorationPrice;
	protected double platbandPrice;
    protected double mainLockPrice;
    protected double secondaryLockPrice;
    protected double handlePrice;
    protected double protectorPrice;
    protected double spyHolePrice;

	public FireProofDoorImpl() {
		totalPrice = 0;
		metalFramesPartsTotalPrice = 0;
		metal_40x40_Price = 0;
		metal_40x20_Price = 0;
		innerMetalListPrice = 0;
		outerMetalListPrice = 0;
		hingePrice = 0;
		ograskPrice = 0;
		dryWallPrice = 0;
		mineralWoolPrice = 0;
		sealPrice = 0;
		outerDecorationPrice = 0;
		innerDecorationPrice = 0;
		platbandPrice = 0;
        this.mainLockPrice = 0;
        this.secondaryLockPrice = 0;
        this.handlePrice = 0;
        this.protectorPrice = 0;
        this.spyHolePrice = 0;
        this.accessories = new Accessories();
	}

    @Override
    public void calcMainLock(AccessoriesType mainLockType) {
        totalPrice -= accessories.getMainLockPrice();
        accessories.calcMainLock(mainLockType);
        mainLockPrice = this.accessories.getMainLockPrice();
        totalPrice += mainLockPrice;
    }

    @Override
    public void calcSecondaryLock(AccessoriesType secondaryLockType) {
        totalPrice -= accessories.getSecondaryLockPrice();
        accessories.calcSecondaryLock(secondaryLockType);
        secondaryLockPrice = this.accessories.getSecondaryLockPrice();
        totalPrice += secondaryLockPrice;
    }

    @Override
    public void calcHandle(AccessoriesType handleType) {
        totalPrice -= accessories.getHandlePrice();
        accessories.calcHandle(handleType);
        handlePrice = this.accessories.getHandlePrice();
        totalPrice += handlePrice;
    }

    @Override
    public void calcProtector(AccessoriesType protectorType) {
        totalPrice -= accessories.getProtectorPrice();
        accessories.calcProtector(protectorType);
        protectorPrice = this.accessories.getProtectorPrice();
        totalPrice += protectorPrice;
    }

    @Override
    public void calcSpyHole(AccessoriesType spyHoleType) {
        totalPrice -= accessories.getSpyHolePrice();
        accessories.calcSpyHolder(spyHoleType);
        spyHolePrice = this.accessories.getSpyHolePrice();
        totalPrice += spyHolePrice;
    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX_1() {
		return x_1;
	}

	public void setX_1(int x_1) {
		this.x_1 = x_1;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getMetalFramesPartsTotalPrice() {
		return metalFramesPartsTotalPrice;
	}

	public void setMetalFramesPartsTotalPrice(double metalFramesPartsTotalPrice) {
		this.metalFramesPartsTotalPrice = metalFramesPartsTotalPrice;
	}

	public double getMetal_40x40_Price() {
		return metal_40x40_Price;
	}

	public void setMetal_40x40_Price(double metal_40x40_Price) {
		this.metal_40x40_Price = metal_40x40_Price;
	}

	public double getMetal_40x20_Price() {
		return metal_40x20_Price;
	}

	public void setMetal_40x20_Price(double metal_40x20_Price) {
		this.metal_40x20_Price = metal_40x20_Price;
	}

	public double getInnerMetalListPrice() {
		return innerMetalListPrice;
	}

	public void setInnerMetalListPrice(double innerMetalListPrice) {
		this.innerMetalListPrice = innerMetalListPrice;
	}

	public double getOuterMetalListPrice() {
		return outerMetalListPrice;
	}

	public void setOuterMetalListPrice(double outerMetalListPrice) {
		this.outerMetalListPrice = outerMetalListPrice;
	}

	public double getHingePrice() {
		return hingePrice;
	}

	public void setHingePrice(double hingePrice) {
		this.hingePrice = hingePrice;
	}

	public double getOgraskPrice() {
		return ograskPrice;
	}

	public void setOgraskPrice(double ograskPrice) {
		this.ograskPrice = ograskPrice;
	}

	public double getDryWallPrice() {
		return dryWallPrice;
	}

	public void setDryWallPrice(double dryWallPrice) {
		this.dryWallPrice = dryWallPrice;
	}

	public double getMineralWoolPrice() {
		return mineralWoolPrice;
	}

	public void setMineralWoolPrice(double mineralWoolPrice) {
		this.mineralWoolPrice = mineralWoolPrice;
	}

	public double getSealPrice() {
		return sealPrice;
	}

	public void setSealPrice(double sealPrice) {
		this.sealPrice = sealPrice;
	}

	public double getOuterDecorationPrice() {
		return outerDecorationPrice;
	}

	public void setOuterDecorationPrice(double outerDecorationPrice) {
		this.outerDecorationPrice = outerDecorationPrice;
	}

	public double getInnerDecorationPrice() {
		return innerDecorationPrice;
	}

	public void setInnerDecorationPrice(double innerDecorationPrice) {
		this.innerDecorationPrice = innerDecorationPrice;
	}

	public double getPlatbandPrice() {
		return platbandPrice;
	}

	public void setPlatbandPrice(double platbandPrice) {
		this.platbandPrice = platbandPrice;
	}

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("x=").append(x).append("\n");
        sb.append("y=").append(y).append("\n");
        sb.append("x_1=").append(x_1).append("\n");
        sb.append("metal_40x40_Price=").append(metal_40x40_Price).append("\n");
        sb.append("metal_40x20_Price=").append(metal_40x20_Price).append("\n");
        sb.append("innerMetalListPrice=").append(innerMetalListPrice).append("\n");
        sb.append("outerMetalListPrice=").append(outerMetalListPrice).append("\n");
        sb.append("hingePrice=").append(hingePrice).append("\n");
        sb.append("ograskPrice=").append(ograskPrice).append("\n");
        sb.append("dryWallPrice=").append(dryWallPrice).append("\n");
        sb.append("mineralWoolPrice=").append(mineralWoolPrice).append("\n");
        sb.append("sealPrice=").append(sealPrice).append("\n");
        sb.append("outerDecorationPrice=").append(outerDecorationPrice).append("\n");
        sb.append("innerDecorationPrice=").append(innerDecorationPrice).append("\n");
        sb.append("platbandPrice=").append(platbandPrice).append("\n");
        sb.append("mainLockPrice=").append(mainLockPrice).append("\n");
        sb.append("secondaryLockPrice=").append(secondaryLockPrice).append("\n");
        sb.append("handlePrice=").append(handlePrice).append("\n");
        sb.append("protectorPrice=").append(protectorPrice).append("\n");
        sb.append("spyHolePrice=").append(spyHolePrice).append("\n");
        return sb.toString();
    }
}
