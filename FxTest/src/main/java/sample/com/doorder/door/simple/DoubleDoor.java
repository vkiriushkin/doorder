package sample.com.doorder.door.simple;

import sample.com.doorder.door.Price;

public class DoubleDoor extends AngledDoor {

    public static final int HINGE_NUMBER = 4;

    private int x_1;

    public DoubleDoor() {
        outerDecoration = new DoubleDoorOuterDecoration();
        innerDecoration = new DoubleDoorInnerDecoration();
    }

    @Override
    public void calcMetalFrameParts() {
        LOGGER.info("Start calculating metal frame parts");
        calcL50x4Part();
        calcPipe40x40();
        calcPipe40x20();
        calcPipe20x20();
        totalPrice += metalFramesPartsTotalPrice;
        LOGGER.info("Finish calculating metal frame parts, price: {}, total price: {}", metalFramesPartsTotalPrice, totalPrice);
    }

    private void calcPipe20x20() {
        LOGGER.info("Checking dimensions for pipe 20x20");
        if (this.getY() >= 1000 && this.getY() <= 2060
                && this.getX() >= 1201 && this.getX() <= 1500) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (2 * this.getX() + 3 * this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getY() >= 2061 && this.getY() <= 2450
                && this.getX() >= 1201 && this.getX() <= 1500) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (3 * this.getX() + 3 * this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getY() >= 1000 && this.getY() <= 2060
                && this.getX() >= 800 && this.getX() <= 1200) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (2 * this.getX() + 2 * this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getY() >= 2061 && this.getY() <= 2450
                && this.getX() >= 800 && this.getX() <= 1200) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (3 * this.getX() + 2 * this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        }  else if (this.getY() >= 1000 && this.getY() <= 2060
                && this.getX() >= 1501 && this.getX() <= 1950) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (2 * this.getX() + 4 * this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getY() >= 2061 && this.getY() <= 2450
                && this.getX() >= 1501 && this.getX() <= 1950) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (3 * this.getX() + 4 * this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("Pipe 20x20", this.getY(), this.getX());

        metalFramesPartsTotalPrice += metal_20x20_Price;
        LOGGER.info("Finish calculating metal 20x20 parts, price: {}, total price: {}", metal_20x20_Price, totalPrice);
    }

    private void calcPipe40x20() {
        LOGGER.info("Checking dimensions for pipe 40x20");
        if (this.getY() >= 1000 && this.getY() <= 2450
                && this.getX() >= 800 && this.getX() <= 1950
                && this.getX_1() >= getX()/2 && this.getX_1() <= 1200
                && this.getX() - this.getX_1() >= 150) {
            LOGGER.info("Pipe 40x20: Dimensions OK");
            this.metal_40x20_Price = (2 * this.getX() + 4 * this.getY()) * 1.1 / 1000 * Price.PIPE_40x20.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("Pipe 40x20", this.getY(), this.getX());
        metalFramesPartsTotalPrice += metal_40x20_Price;
        LOGGER.info("Finish calculating metal 40x20 parts, price: {}, total price: {}", metal_40x20_Price, totalPrice);
    }

    private void calcPipe40x40() {
        LOGGER.info("Pipe 40x40 is not needed in this model");
        this.metal_40x40_Price = 0.0;
        metalFramesPartsTotalPrice += metal_40x40_Price;
        LOGGER.info("Finish calculating metal 40x40 parts, price: {}, total price: {}", metal_40x40_Price, totalPrice);
    }

    private void calcL50x4Part() {
        LOGGER.info("Checking dimensions for L50x4");
        if (this.getY() >= 1000 && this.getY() <= 2450
                && this.getX() >= 800 && this.getX() <= 1950
                && this.getX_1() >= getX()/2 && this.getX_1() <= 1200
                && this.getX() - this.getX_1() >= 150) {
            LOGGER.info("L50x4: Dimensions OK");
            this.metal_L50x4_Price = (this.getX() + this.getY()) * 2 * 1.1 / 1000 * Price.ANGLE_50x20.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("L50x4", this.getY(), this.getX());

        metalFramesPartsTotalPrice += metal_L50x4_Price;
        LOGGER.info("Finish calculating metal L50x4 parts, price: {}, total price: {}", metal_L50x4_Price, totalPrice);
    }

    @Override
    public void calcMetalList() {
        LOGGER.info("Start calculating metal list price");
        LOGGER.info("Checking dimensions for metal list");
        if (this.getY() >= 1000 && this.getY() <= 2030
                && this.getX() >= 800 && this.getX() <= 950) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1x2.getPriceInUAH();
        } else if (this.getY() >= 2031 && this.getY() <= 2450
                && this.getX() >= 800 && this.getX() <= 950) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH();
        } else if (this.getY() >= 1000 && this.getY() <= 2030
                && this.getX() >= 951 && this.getX() <= 1200) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH();
        } else if (this.getY() >= 2031 && this.getY() <= 2450
                && this.getX() >= 951 && this.getX() <= 1200) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH();
        }  else if (this.getY() >= 1000 && this.getY() <= 2030
                && this.getX() >= 1201 && this.getX() <= 1950) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH() * 1.5;
        } else if (this.getY() >= 2031 && this.getY() <= 2450
                && this.getX() >= 1201 && this.getX() <= 1950) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH() * 1.5;
        }else
            throw new UnsupportedDimensions("Metal list", this.getY(), this.getX());

        totalPrice += metalListPrice;
        LOGGER.info("Finish calculating metal list, price: {}, total price: {}", metalListPrice, totalPrice);
    }

    @Override
    public void calcHinge() {
        LOGGER.info("Start calculating hinge price");
        this.hingePrice = HINGE_NUMBER * Price.HINGE.getPriceInUAH();
        totalPrice += hingePrice;
        LOGGER.info("Finish calculating hinge, price: {}, total price: {}", hingePrice, totalPrice);
    }

    @Override
    public void calcHeater(boolean heaterNeeded) {
        LOGGER.info("Start calculating heater price");
        double heaterMultiplier = heaterNeeded ? this.getY() * this.getX() / 1000000 : 0.0;
        this.heaterPrice = heaterMultiplier * Price.HEATER.getPriceInUAH();
        totalPrice += heaterPrice;
        LOGGER.info("Finish calculating heater, price: {}, total price: {}", heaterPrice, totalPrice);
    }

    @Override
    public void calcSeal(boolean sealNeeded) {
        LOGGER.info("Start calculating seal price");
        LOGGER.info("Checking dimensions for seal");
        double sealMultiplier = sealNeeded ? (3 * this.getY() + 2 * this.getX()) / 1000 : 0.0;
        this.sealPrice = sealMultiplier * Price.SEAL.getPriceInUAH();
        totalPrice += sealPrice;
        LOGGER.info("Finish calculating seal, price: {}, total price: {}", sealPrice, totalPrice);
    }

    public int getX_1() {
        return x_1;
    }

    public void setX_1(int x_1) {
        this.x_1 = x_1;
    }
}
