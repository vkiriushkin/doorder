package sample.com.doorder.door.simple;

import sample.com.doorder.door.Price;

public class DoubleDoor extends AngledDoor {

    public static final int HINGE_NUMBER = 4;

    private int secondWidth;

    public DoubleDoor() {
        outerDecoration = new DoubleDoorOuterDecoration();
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
        if (this.getHeight() >= 1000 && this.getHeight() <= 2060
                && this.getWidth() >= 1201 && this.getWidth() <= 1500) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (2 * this.getWidth() + 3 * this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getHeight() >= 2061 && this.getHeight() <= 2450
                && this.getWidth() >= 1201 && this.getWidth() <= 1500) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (3 * this.getWidth() + 3 * this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getHeight() >= 1000 && this.getHeight() <= 2060
                && this.getWidth() >= 800 && this.getWidth() <= 1200) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (2 * this.getWidth() + 2 * this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getHeight() >= 2061 && this.getHeight() <= 2450
                && this.getWidth() >= 800 && this.getWidth() <= 1200) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (3 * this.getWidth() + 2 * this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        }  else if (this.getHeight() >= 1000 && this.getHeight() <= 2060
                && this.getWidth() >= 1501 && this.getWidth() <= 1950) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (2 * this.getWidth() + 4 * this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getHeight() >= 2061 && this.getHeight() <= 2450
                && this.getWidth() >= 1501 && this.getWidth() <= 1950) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (3 * this.getWidth() + 4 * this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("Pipe 20x20", this.getHeight(), this.getWidth());

        metalFramesPartsTotalPrice += metal_20x20_Price;
        LOGGER.info("Finish calculating metal 20x20 parts, price: {}, total price: {}", metal_20x20_Price, totalPrice);
    }

    private void calcPipe40x20() {
        LOGGER.info("Checking dimensions for pipe 40x20");
        if (this.getHeight() >= 1000 && this.getHeight() <= 2450
                && this.getWidth() >= 800 && this.getWidth() <= 1950
                && this.getSecondWidth() >= getWidth()/2 && this.getSecondWidth() <= 1200
                && this.getWidth() - this.getSecondWidth() >= 150) {
            LOGGER.info("Pipe 40x20: Dimensions OK");
            this.metal_40x20_Price = (2 * this.getWidth() + 4 * this.getHeight()) * 1.1 / 1000 * Price.PIPE_40x20.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("Pipe 40x20", this.getHeight(), this.getWidth());
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
        if (this.getHeight() >= 1000 && this.getHeight() <= 2450
                && this.getWidth() >= 800 && this.getWidth() <= 1950
                && this.getSecondWidth() >= getWidth()/2 && this.getSecondWidth() <= 1200
                && this.getWidth() - this.getSecondWidth() >= 150) {
            LOGGER.info("L50x4: Dimensions OK");
            this.metal_L50x4_Price = (this.getWidth() + this.getHeight()) * 2 * 1.1 / 1000 * Price.ANGLE_50x20.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("L50x4", this.getHeight(), this.getWidth());

        metalFramesPartsTotalPrice += metal_L50x4_Price;
        LOGGER.info("Finish calculating metal L50x4 parts, price: {}, total price: {}", metal_L50x4_Price, totalPrice);
    }

    @Override
    public void calcMetalList() {
        LOGGER.info("Start calculating metal list price");
        LOGGER.info("Checking dimensions for metal list");
        if (this.getHeight() >= 1000 && this.getHeight() <= 2030
                && this.getWidth() >= 800 && this.getWidth() <= 950) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1x2.getPriceInUAH();
        } else if (this.getHeight() >= 2031 && this.getHeight() <= 2450
                && this.getWidth() >= 800 && this.getWidth() <= 950) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH();
        } else if (this.getHeight() >= 1000 && this.getHeight() <= 2030
                && this.getWidth() >= 951 && this.getWidth() <= 1200) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH();
        } else if (this.getHeight() >= 2031 && this.getHeight() <= 2450
                && this.getWidth() >= 951 && this.getWidth() <= 1200) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH();
        }  else if (this.getHeight() >= 1000 && this.getHeight() <= 2030
                && this.getWidth() >= 1201 && this.getWidth() <= 1950) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH() * 1.5;
        } else if (this.getHeight() >= 2031 && this.getHeight() <= 2450
                && this.getWidth() >= 1201 && this.getWidth() <= 1950) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH() * 1.5;
        }else
            throw new UnsupportedDimensions("Metal list", this.getHeight(), this.getWidth());

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
        double heaterMultiplier = heaterNeeded ? this.getHeight() * this.getWidth() / 1000000 : 0.0;
        this.heaterPrice = heaterMultiplier * Price.HEATER.getPriceInUAH();
        totalPrice += heaterPrice;
        LOGGER.info("Finish calculating heater, price: {}, total price: {}", heaterPrice, totalPrice);
    }

    @Override
    public void calcSeal(boolean sealNeeded) {
        LOGGER.info("Start calculating seal price");
        LOGGER.info("Checking dimensions for seal");
        double sealMultiplier = sealNeeded ? (3 * this.getHeight() + 2 * this.getWidth()) / 1000 : 0.0;
        this.sealPrice = sealMultiplier * Price.SEAL.getPriceInUAH();
        totalPrice += sealPrice;
        LOGGER.info("Finish calculating seal, price: {}, total price: {}", sealPrice, totalPrice);
    }

    public int getSecondWidth() {
        return secondWidth;
    }

    public void setSecondWidth(int secondWidth) {
        this.secondWidth = secondWidth;
    }
}
