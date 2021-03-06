package sample.com.doorder.door.doubleframe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.com.doorder.door.Price;
import sample.com.doorder.door.UnsupportedDimensions;
import sample.com.doorder.door.types.InnerDecorationType;
import sample.com.doorder.door.types.OuterDecorationType;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleFrameSingleSideTransomDoor extends DoubleFrameAngledDoor {

    public static final Logger LOGGER = LoggerFactory.getLogger(DoubleFrameSingleSideTransomDoor.class);
    public static final int HINGE_NUMBER = 2;

    protected int x_1;
    private DoubleFrameSingleSideTransomDoorInnerDecoration innerDecoration;
    private DoubleFrameSingleSideTransomDoorOuterDecoration outerDecoration;

    public DoubleFrameSingleSideTransomDoor() {
        this.outerDecoration = new DoubleFrameSingleSideTransomDoorOuterDecoration();
        this.innerDecoration = new DoubleFrameSingleSideTransomDoorInnerDecoration();
	    this.productionPrice = 85;
	    this.profitPrice = 400;
    }

    @Override
    public void calcMetalFrameParts() {
        LOGGER.info("Start calculating metal frame parts");
        checkDimensions();
        calcL50x4Part();
        calcPipe40x40();
        calcPipe40x20();
        calcPipe20x20();
        calcPipe25x25();
        totalPrice += metalFramesPartsTotalPrice;
        LOGGER.info("Finish calculating metal frame parts, price: {}, total price: {}", metalFramesPartsTotalPrice, totalPrice);
    }

    private void checkDimensions() {
        if ((this.getX() - x_1) < 150)
            throw new UnsupportedDimensions("Значение (x-x1) должно быть больше или равно 150 мм");
        if (x_1 < this.getX() / 2)
            throw new UnsupportedDimensions("Значение x1 должно быть больше или равно (х/2)");
    }

    private void calcL50x4Part() {
        LOGGER.info("Checking dimensions for L50x4");
        if (this.getY() >= 1000 && this.getY() <= 2450 && this.getX() >= 800 && this.getX() <= 1950
                && this.getX_1() <= this.getX() - 150 && this.getX_1() <= 1200) {
            LOGGER.info("L50x4: Dimensions OK");
            BigDecimal bd = new BigDecimal(((double) this.getX() + this.getY()) * 2 * 1.1 / 1000 * Price.ANGLE_50x20.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            this.metal_L50x4_Price = bd.doubleValue();
        } else
            throw new UnsupportedDimensions("L50x4", this.getY(), this.getX());

        metalFramesPartsTotalPrice += metal_L50x4_Price;
        LOGGER.info("Finish calculating metal L50x4 parts, price: {}, total price: {}", metal_L50x4_Price, totalPrice);
    }

    private void calcPipe40x40() {
        LOGGER.info("Checking dimensions for pipe 40x40");
        if (this.getX_1() <= this.getX() - 150) {
            LOGGER.info("Pipe 40x40: Dimensions OK");
            BigDecimal bd = new BigDecimal((double) this.getY() / 1000 * Price.PIPE_40x40.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            this.metal_40x40_Price = bd.doubleValue();
        } else
            throw new UnsupportedDimensions("Pipe 40x40", this.getY(), this.getX());

        metalFramesPartsTotalPrice += metal_40x40_Price;
        LOGGER.info("Finish calculating metal 40x40 parts, price: {}, total price: {}", metal_40x40_Price, totalPrice);
    }

    private void calcPipe40x20() {
        LOGGER.info("Checking dimensions for 40x20");
        if (this.getY() >= 1000 && this.getY() <= 2450 && this.getX() >= 800 && this.getX() <= 1950
                && this.getX_1() <= this.getX() - 150 && this.getX_1() <= 1200) {
            LOGGER.info("40x20: Dimensions OK");
            BigDecimal bd = new BigDecimal(((double) this.getX_1() + this.getY()) * 2.2 / 1000 * Price.PIPE_40x20.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            this.metal_40x20_Price = bd.doubleValue();
        } else
            throw new UnsupportedDimensions("40x20", this.getY(), this.getX());

        metalFramesPartsTotalPrice += metal_40x20_Price;
        LOGGER.info("Finish calculating metal 40x20 parts, price: {}, total price: {}", metal_40x20_Price, totalPrice);
    }

    private void calcPipe20x20() {
        LOGGER.info("Checking dimensions for pipe 20x20");
        if (this.getY() >= 1000 && this.getY() <= 2060
                && this.getX() >= 800 && this.getX() <= 1200) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            BigDecimal bd = new BigDecimal((2 * (double) this.getX() + 2 * this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            this.metal_20x20_Price = bd.doubleValue();
        } else if (this.getY() >= 2061 && this.getY() <= 2450
                && this.getX() >= 800 && this.getX() <= 1200) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            BigDecimal bd = new BigDecimal((3 * (double) this.getX() + 2 * this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            this.metal_20x20_Price = bd.doubleValue();
        } else if (this.getY() >= 1000 && this.getY() <= 2060
                && this.getX() >= 1201 && this.getX() <= 1500) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            BigDecimal bd = new BigDecimal((2 * (double) this.getX() + 3 * this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            this.metal_20x20_Price = bd.doubleValue();
        } else if (this.getY() >= 2061 && this.getY() <= 2450
                && this.getX() >= 1201 && this.getX() <= 1500) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            BigDecimal bd = new BigDecimal((3 * (double) this.getX() + 3 * this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            this.metal_20x20_Price = bd.doubleValue();
        } else if (this.getY() >= 1000 && this.getY() <= 2060
                && this.getX() >= 1501 && this.getX() <= 1950) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            BigDecimal bd = new BigDecimal((2 * (double) this.getX() + 4 * this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            this.metal_20x20_Price = bd.doubleValue();
        } else if (this.getY() >= 2061 && this.getY() <= 2450
                && this.getX() >= 1501 && this.getX() <= 1950) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            BigDecimal bd = new BigDecimal((3 * (double) this.getX() + 4 * this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            this.metal_20x20_Price = bd.doubleValue();
        } else
            throw new UnsupportedDimensions("Pipe 20x20", this.getY(), this.getX());

        metalFramesPartsTotalPrice += metal_20x20_Price;
        LOGGER.info("Finish calculating metal 20x20 parts, price: {}, total price: {}", metal_20x20_Price, totalPrice);
    }

    private void calcPipe25x25() {
        LOGGER.info("Checking dimensions for 25x25");
        if (this.getY() >= 1000 && this.getY() <= 2450 && this.getX() >= 800 && this.getX() <= 1950
                && this.getX_1() <= this.getX() - 150 && this.getX_1() <= 1200) {
            LOGGER.info("25x25: Dimensions OK");
            BigDecimal bd = new BigDecimal(((double) this.getX_1() + this.getY()) * 2.2 / 1000 * Price.PIPE_25x25.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            this.metal_25x25_Price = bd.doubleValue();
        } else
            throw new UnsupportedDimensions("25x25", this.getY(), this.getX());

        metalFramesPartsTotalPrice += metal_25x25_Price;
        LOGGER.info("Finish calculating metal 25x25 parts, price: {}, total price: {}", metal_25x25_Price, totalPrice);
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
        } else if (this.getY() >= 1000 && this.getY() <= 2030
                && this.getX() >= 1201 && this.getX() <= 1950) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH() * 1.5;
        } else if (this.getY() >= 2031 && this.getY() <= 2450
                && this.getX() >= 1201 && this.getX() <= 1950) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH() * 1.5;
        } else
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
        BigDecimal bd = new BigDecimal((double) this.getY() * this.getX() / 1000000 * Price.HEATER.getPriceInUAH());
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        double price = heaterNeeded ? bd.doubleValue() : 0.0;
        this.heaterPrice = price;
        totalPrice += heaterPrice;
        LOGGER.info("Finish calculating heater, price: {}, total price: {}", heaterPrice, totalPrice);
    }

    @Override
    public void calcSeal(boolean sealNeeded) {
        LOGGER.info("Start calculating seal price");
        BigDecimal bd = new BigDecimal(((double) this.getX_1() + this.getY()) * 4 / 1000 * Price.SEAL.getPriceInUAH());
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        double price = sealNeeded ? bd.doubleValue() : 0.0;
        this.sealPrice = price;
        totalPrice += sealPrice;
        LOGGER.info("Finish calculating seal, price: {}, total price: {}", sealPrice, totalPrice);
    }

    @Override
    public void calcOuterDecoration(OuterDecorationType outerDecorationType) {
        totalPrice -= outerDecorationPrice;
        outerDecoration.clear();
        switch (outerDecorationType) {
            case SELF_ADHESIVE_FILM:
                this.outerDecoration.calcSelfAdhesiveFilm(this.getX(), this.getY());
                break;
            case PAINTING_SHAGREEN:
                this.outerDecoration.calcPaintingShagreen(this.getX(), this.getY(), this.getX_1());
                break;
            case PAINTING_ANTIC:
                this.outerDecoration.calcPaintingAntic(this.getX(), this.getY(), this.getX_1());
                break;
            case PAINTING_PF:
                this.outerDecoration.calcPaintingPF(this.getX(), this.getY(), this.getX_1());
                break;
            case ANTI_LAYER:
                this.outerDecoration.calcAntiLayer(this.getX(), this.getY());
                break;
            case MDF10:
                this.outerDecoration.calcMdf10(this.getX(), this.getY());
                break;
            case MDF16:
                this.outerDecoration.calcMdf16(this.getX(), this.getY());
                break;
        }
        outerDecorationPrice = this.outerDecoration.getTotalOuterDecorationPrice();
        totalPrice += outerDecorationPrice;
    }

    public void calcOuterDecorationWithoutTopTransom(OuterDecorationType outerDecorationType) {
        totalPrice -= outerDecorationPrice;
        outerDecoration.clear();
        switch (outerDecorationType) {
            case SELF_ADHESIVE_FILM:
                this.outerDecoration.calcSelfAdhesiveFilmWithoutTopTransom(this.getX(), this.getY(), this.getX_1());
                break;
            case PAINTING_SHAGREEN:
                this.outerDecoration.calcPaintingShagreenWithoutTopTransom(this.getX(), this.getY(), this.getX_1());
                break;
            case PAINTING_ANTIC:
                this.outerDecoration.calcPaintingAnticWithoutTopTransom(this.getX(), this.getY(), this.getX_1());
                break;
            case PAINTING_PF:
                this.outerDecoration.calcPaintingPFWithoutTopTransom(this.getX(), this.getY(), this.getX_1());
                break;
            case ANTI_LAYER:
                this.outerDecoration.calcAntiLayerWithoutTopTransom(this.getX(), this.getY(), this.getX_1());
                break;
            case MDF10:
                this.outerDecoration.calcMdf10WithoutTopTransom(this.getX(), this.getY(), this.getX_1());
                break;
            case MDF16:
                this.outerDecoration.calcMdf16WithoutTopTransom(this.getX(), this.getY(), this.getX_1());
                break;
        }
        outerDecorationPrice = this.outerDecoration.getTotalOuterDecorationPrice();
        totalPrice += outerDecorationPrice;
    }

    @Override
    public void calcInnerDecoration(InnerDecorationType innerDecorationType) {
        totalPrice -= innerDecorationPrice;
        innerDecoration.clear();
        switch (innerDecorationType) {
            case PLASTIC:
                this.innerDecoration.calcPlastic(this.getX(), this.getY());
                break;
            case LAMINATED_PLASTIC:
                this.innerDecoration.calcLaminate(this.getX(), this.getY());
                break;
            case NO_DECORATION:
                this.innerDecoration.calcWithoutDecoration(this.getX(), this.getY());
                break;
            case METAL_LIST_PAINTING_PF:
                this.innerDecoration.calcPaintingPF(this.getX(), this.getY());
                break;
            case METAL_LIST_PAINTING_SHAGREEN:
                this.innerDecoration.calcPaintingShagreen(this.getX(), this.getY(), this.getX_1());
                break;
            case METAL_LIST_PAINTING_ANTIC:
                this.innerDecoration.calcPaintingAntic(this.getX(), this.getY(), this.getX_1());
                break;
        }
        innerDecorationPrice = this.innerDecoration.getTotalInnerDecorationPrice();
        totalPrice += innerDecorationPrice;
    }

    public void calcInnerDecorationWithoutTopTransom(InnerDecorationType innerDecorationType) {
        totalPrice -= innerDecorationPrice;
        innerDecoration.clear();
        switch (innerDecorationType) {
            case PLASTIC:
                this.innerDecoration.calcPlasticWithoutTopTransom(this.getX(), this.getY(), this.getX_1());
                break;
            case LAMINATED_PLASTIC:
                this.innerDecoration.calcLaminateWithoutTopTransom(this.getX(), this.getY(), this.getX_1());
                break;
            case NO_DECORATION:
                this.innerDecoration.calcWithoutDecoration(this.getX(), this.getY());
                break;
            case METAL_LIST_PAINTING_PF:
                this.innerDecoration.calcPaintingPFWithoutTopTransom(this.getX(), this.getY(), this.getX_1());
                break;
            case METAL_LIST_PAINTING_SHAGREEN:
                this.innerDecoration.calcPaintingShagreenWithoutTopTransom(this.getX(), this.getY(), this.getX_1());
                break;
            case METAL_LIST_PAINTING_ANTIC:
                this.innerDecoration.calcPaintingAnticWithoutTopTransom(this.getX(), this.getY(), this.getX_1());
                break;
        }
        innerDecorationPrice = this.innerDecoration.getTotalInnerDecorationPrice();
        totalPrice += innerDecorationPrice;
    }

    public int getX_1() {
        return x_1;
    }

    public void setX_1(int x_1) {
        this.x_1 = x_1;
    }



}
