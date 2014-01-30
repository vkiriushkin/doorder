package sample.com.doorder.door.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.com.doorder.door.Price;
import sample.com.doorder.door.SimpleDoor;

public class AngledDoor extends SimpleDoor {

    public static final Logger LOGGER = LoggerFactory.getLogger(AngledDoor.class);

    public AngledDoor() {
        super();
    }

    @Override
    public void calcMetalFrameParts() {
        LOGGER.debug("Start calculating metal frame parts");
        calcL50x4Part();
        calcPipe40x40();
        calcPipe40x20();
        calcPipe20x20();
        totalPrice += metalFramesPartsTotalPrice;
    }

    private void calcPipe20x20() {
        LOGGER.debug("Checking dimensions for pipe 20x20");
        if (this.getHeight() >= 1000 && this.getHeight() <= 2060
                && this.getWidth() >= 500 && this.getWidth() <= 900) {
            LOGGER.debug("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (2 * this.getWidth() + this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getHeight() >= 2061 && this.getHeight() <= 2450
                && this.getWidth() >= 500 && this.getWidth() <= 900) {
            LOGGER.debug("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (3 * this.getWidth() + this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getHeight() >= 1000 && this.getHeight() <= 2060
                && this.getWidth() >= 901 && this.getWidth() <= 1200) {
            LOGGER.debug("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (this.getWidth() + this.getHeight()) * 2.2 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getHeight() >= 2061 && this.getHeight() <= 2450
                && this.getWidth() >= 901 && this.getWidth() <= 1200) {
            LOGGER.debug("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (3 * this.getWidth() + 2 * this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("Pipe 20x20", this.getHeight(), this.getWidth());

        metalFramesPartsTotalPrice += metal_20x20_Price;
    }

    private void calcPipe40x20() {
        LOGGER.debug("Checking dimensions for pipe 40x20");
        if (this.getHeight() >= 1000 && this.getHeight() <= 2450
                && this.getWidth() >= 500 && this.getWidth() <= 1200) {
            LOGGER.debug("Pipe 40x20: Dimensions OK");
            this.metal_40x20_Price = (this.getWidth() + this.getHeight()) * 2.2 / 1000 * Price.PIPE_40x20.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("Pipe 40x20", this.getHeight(), this.getWidth());
        metalFramesPartsTotalPrice += metal_40x20_Price;
    }

    private void calcPipe40x40() {
        LOGGER.debug("Pipe 40x40 is not needed in this model");
        this.metal_40x40_Price = 0.0;
        metalFramesPartsTotalPrice += metal_40x20_Price;
    }

    private void calcL50x4Part() {
        LOGGER.debug("Checking dimensions for L50x4");
        if (this.getHeight() >= 1000 && this.getHeight() <= 2450
                && this.getWidth() >= 500 && this.getWidth() <= 1200) {
            LOGGER.debug("L50x4: Dimensions OK");
            this.metal_L50x4_Price = (this.getWidth() + this.getHeight()) * 2.2 / 1000 * Price.ANGLE_50x20.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("L50x4", this.getHeight(), this.getWidth());

        metalFramesPartsTotalPrice += metal_L50x4_Price;
    }

    @Override
    public void calcMetalList() {

    }

    @Override
    public void calcHinge() {

    }

    @Override
    public void calcHeater() {

    }

    @Override
    public void calcSeal() {

    }

    @Override
    public void calcOuterFacing() {

    }

    @Override
    public void calcInnerFacing() {

    }

    @Override
    public void calcPlatband() {

    }

    @Override
    public void calcAccessories() {

    }
}
