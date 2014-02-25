package sample.com.doorder.door.simple;

import sample.com.doorder.door.FireProofDoor;

public abstract class FireProofDoorImpl implements FireProofDoor {

	private int x;
	private int y;
	private int x_1;

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
	protected double accessoriesPrice;

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
		accessoriesPrice = 0;
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

	public double getAccessoriesPrice() {
		return accessoriesPrice;
	}

	public void setAccessoriesPrice(double accessoriesPrice) {
		this.accessoriesPrice = accessoriesPrice;
	}
}
