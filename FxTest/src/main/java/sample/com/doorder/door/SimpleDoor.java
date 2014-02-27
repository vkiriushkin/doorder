package sample.com.doorder.door;

public abstract class SimpleDoor implements MetalDoor {

    protected double totalPrice;
    protected double metalFramesPartsTotalPrice;
    protected double metal_L50x4_Price;
    protected double metal_40x40_Price;
    protected double metal_40x20_Price;
    protected double metal_20x20_Price;
    protected double metalListPrice;
    protected double hingePrice;
    protected double heaterPrice;
    protected double sealPrice;
    protected double outerDecorationPrice;
    protected double innerDecorationPrice;
    protected double platbandPrice;
    protected double accessoriesPrice;

    private int x;
    private int y;
	private int z;

    public SimpleDoor() {
        this.hingePrice = 0;
        this.metalFramesPartsTotalPrice = 0;
        this.metal_L50x4_Price = 0;
        this.metal_40x40_Price = 0;
        this.metal_40x20_Price = 0;
        this.metal_20x20_Price = 0;
        this.metalListPrice = 0;
        this.innerDecorationPrice = 0;
        this.accessoriesPrice = 0;
        this.sealPrice = 0;
        this.platbandPrice = 0;
        this.heaterPrice = 0;
        this.totalPrice = 0;
        this.outerDecorationPrice = 0;
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

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public double getTotalPrice() {
        return totalPrice;
    }

    public double getMetalFramesPartsTotalPrice() {
        return metalFramesPartsTotalPrice;
    }

    public double getMetal_L50x4_Price() {
        return metal_L50x4_Price;
    }

    public double getMetal_40x40_Price() {
        return metal_40x40_Price;
    }

    public double getMetal_40x20_Price() {
        return metal_40x20_Price;
    }

    public double getMetal_20x20_Price() {
        return metal_20x20_Price;
    }

    public double getMetalListPrice() {
        return metalListPrice;
    }

    public double getHingePrice() {
        return hingePrice;
    }

    public double getHeaterPrice() {
        return heaterPrice;
    }

    public double getSealPrice() {
        return sealPrice;
    }

    public double getOuterDecorationPrice() {
        return outerDecorationPrice;
    }

    public double getInnerDecorationPrice() {
        return innerDecorationPrice;
    }

    public double getPlatbandPrice() {
        return platbandPrice;
    }

    public double getAccessoriesPrice() {
        return accessoriesPrice;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("x=").append(x).append("\n");
        sb.append("y=").append(y).append("\n");
        sb.append("z=").append(z).append("\n");
        sb.append("metalFramesPartsTotalPrice=").append(metalFramesPartsTotalPrice).append("\n");
        sb.append("metal_L50x4_Price=").append(metal_L50x4_Price).append("\n");
        sb.append("metal_40x40_Price=").append(metal_40x40_Price).append("\n");
        sb.append("metal_40x20_Price=").append(metal_40x20_Price).append("\n");
        sb.append("metal_20x20_Price=").append(metal_20x20_Price).append("\n");
        sb.append("metalListPrice=").append(metalListPrice).append("\n");
        sb.append("hingePrice=").append(hingePrice).append("\n");
        sb.append("heaterPrice=").append(heaterPrice).append("\n");
        sb.append("sealPrice=").append(sealPrice).append("\n");
        sb.append("outerDecorationPrice=").append(outerDecorationPrice).append("\n");
        sb.append("innerDecorationPrice=").append(innerDecorationPrice).append("\n");
        sb.append("platbandPrice=").append(platbandPrice).append("\n");
        return sb.toString();
    }
}
