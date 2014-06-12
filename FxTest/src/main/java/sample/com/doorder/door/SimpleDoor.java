package sample.com.doorder.door;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

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
    protected double mainLockPrice;
    protected double secondaryLockPrice;
    protected double handlePrice;
    protected double protectorPrice;
    protected double spyHolePrice;
    protected double shippingPrice;
    protected double packagePrice;
    protected double installationPrice;
	protected double productionPrice;
	protected double profitPrice;
	protected double fixedProductionPrice;

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
        this.mainLockPrice = 0;
        this.secondaryLockPrice = 0;
        this.handlePrice = 0;
        this.protectorPrice = 0;
        this.spyHolePrice = 0;
        this.sealPrice = 0;
        this.platbandPrice = 0;
        this.heaterPrice = 0;
        this.totalPrice = 0;
        this.outerDecorationPrice = 0;
	    this.fixedProductionPrice = Price.MANUFACTURINGCOSTS.getPriceInUAH();
    }

    @Override
    public void calcOptions(boolean shippingNeeded, String shipping, boolean packagingNeeded, boolean installationNeeded, String installPrice,
                            double profit, double workCost, int profitPercent) {

        this.profitPrice = profit;
        this.productionPrice = workCost;
        totalPrice += profit;
        totalPrice += workCost;
        totalPrice += fixedProductionPrice;

        //installation
        if (installationNeeded) {
            BigDecimal bd = new BigDecimal(installPrice);
            bd.setScale(2, RoundingMode.HALF_UP);
            this.installationPrice = bd.doubleValue();
            totalPrice += this.installationPrice;
        } else {
            this.installationPrice = 0.0;
        }

        //package
        if (packagingNeeded) {
            BigDecimal bd = new BigDecimal((double)x * y * 2 * Price.PACKAGING.getPriceInUAH() / 1000000);
            bd.setScale(2, RoundingMode.HALF_UP);
            packagePrice = bd.doubleValue();
            totalPrice += packagePrice;
        } else {
            packagePrice = 0.0;
        }

        //shipping
        if (shippingNeeded) {
            shippingPrice = Double.parseDouble(shipping);
            totalPrice += shippingPrice;
        } else
            shippingPrice = 0.0;

        //add profit percent
        BigDecimal bd = new BigDecimal(totalPrice).add(new BigDecimal(totalPrice).multiply(new BigDecimal(profitPercent)).divide(new BigDecimal(100)));
        bd.setScale(2, RoundingMode.HALF_UP);
        totalPrice = bd.doubleValue();
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
        Locale locale  = new Locale("en", "UK");
        String pattern = "###.##";
        DecimalFormat decimalFormat = (DecimalFormat)
                NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return Double.valueOf(decimalFormat.format(totalPrice));
//        return totalPrice;
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

    public double getSpyHolePrice() {
        return spyHolePrice;
    }

    public double getShippingPrice() {
        return shippingPrice;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public double getInstallationPrice() {
        return installationPrice;
    }

	public double getProductionPrice() {
		return productionPrice;
	}

	public double getProfitPrice() {
		return profitPrice;
	}

	public double getFixedProductionPrice() {
		return fixedProductionPrice;
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
        sb.append("mainLockPrice=").append(mainLockPrice).append("\n");
        sb.append("secondaryLockPrice=").append(secondaryLockPrice).append("\n");
        sb.append("handlePrice=").append(handlePrice).append("\n");
        sb.append("protectorPrice=").append(protectorPrice).append("\n");
        sb.append("spyHolePrice=").append(spyHolePrice).append("\n");
        sb.append("shippingPrice=").append(shippingPrice).append("\n");
        sb.append("installationPrice=").append(installationPrice).append("\n");
        sb.append("packagePrice=").append(packagePrice).append("\n");
		sb.append("productionPrice=").append(this.productionPrice).append("\n");
		sb.append("profitPrice=").append(this.profitPrice).append("\n");
		sb.append("fixedProductionPrice=").append(fixedProductionPrice).append("\n");
        return sb.toString();
    }
}
