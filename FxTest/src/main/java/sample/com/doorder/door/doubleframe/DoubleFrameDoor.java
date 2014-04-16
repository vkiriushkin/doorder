package sample.com.doorder.door.doubleframe;

import sample.com.doorder.door.Accessories;
import sample.com.doorder.door.SimpleDoor;
import sample.com.doorder.door.angled.Platband;
import sample.com.doorder.door.types.AccessoriesType;
import sample.com.doorder.door.types.PlatbandType;

public abstract class DoubleFrameDoor extends SimpleDoor {

    protected Accessories accessories;
    protected Platband platband;
    protected double metal_50x30_Price;
    protected double metal_25x25_Price;

    protected DoubleFrameDoor() {
        super();
        this.accessories = new Accessories();
        this.platband = new DoubleFrameDoorPlatband();
        this.metal_50x30_Price = 0;
        this.metal_25x25_Price = 0;
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
    public double getMetal_50x30_Price() {
        return metal_50x30_Price;
    }

    public double getMetal_25x25_Price() {
        return metal_25x25_Price;
    }

    @Override
    public void calcPlatband(PlatbandType platbandType) {
        totalPrice -= platbandPrice;
        platband.clear();
        switch (platbandType) {
            case WOODEN:
                this.platband.calcWoodenPlatband(this.getX(), this.getY(), this.getClass());
                break;
            case METAL_PAINTING_PF:
                this.platband.calcMetalPlatbandPaintingPF(this.getX(), this.getY(), this.getClass());
                break;
            case METAL_PAINTING_SHAGREEN:
                this.platband.calcMetalPlatbandPaintingShagreen(this.getX(), this.getY(), this.getClass());
                break;
            case METAL_PAINTING_ANTIC:
                this.platband.calcMetalPlatbandPaintingAntic(this.getX(), this.getY(), this.getClass());
                break;
            case MDF10:
                this.platband.calcMdf10Platband(this.getX(), this.getY(), this.getZ(), this.getClass());
                break;
            case MDF16:
                this.platband.calcMdf16Platband(this.getX(), this.getY(), this.getZ(), this.getClass());
                break;
        }
        platbandPrice = this.platband.getTotalPlatbandPrice();
        totalPrice += platbandPrice;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("x=").append(this.getX()).append("\n");
        sb.append("y=").append(this.getY()).append("\n");
        sb.append("z=").append(this.getZ()).append("\n");
        sb.append("metalFramesPartsTotalPrice=").append(metalFramesPartsTotalPrice).append("\n");
        sb.append("metal_L50x4_Price=").append(metal_L50x4_Price).append("\n");
        sb.append("metal_40x40_Price=").append(metal_40x40_Price).append("\n");
        sb.append("metal_50x30_Price=").append(metal_50x30_Price).append("\n");
        sb.append("metal_20x20_Price=").append(metal_20x20_Price).append("\n");
        sb.append("metal_25x25_Price=").append(metal_25x25_Price).append("\n");
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
        sb.append("productionPrice=").append(productionPrice).append("\n");
        sb.append("profitPrice=").append(profitPrice).append("\n");
        sb.append("fixedProductionPrice=").append(fixedProductionPrice).append("\n");
        return sb.toString();
    }
}
