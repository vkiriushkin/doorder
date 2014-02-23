package sample.com.doorder.door.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.com.doorder.door.InnerDecorationType;
import sample.com.doorder.door.OuterDecorationType;
import sample.com.doorder.door.Price;

public class SingleDoorSideTransom extends AngledDoor {

    public static final Logger LOGGER = LoggerFactory.getLogger(SingleDoorTopTransom.class);

    private int heightTransom;
    private SingleDoorInnerDecoration innerDecoration;
    private OuterDecoration outerDecoration;

    public SingleDoorSideTransom() {
        this.outerDecoration = new SingleDoorSideTransomOuterDecoration();
        this.innerDecoration = new SingleDoorSideTransomInnerDesoration();
    }

    @Override
    public void calcMetalFrameParts() {
        LOGGER.info("Start calculating metal frame parts");
        calcL50x4Part();
        calcPipe40x40();
        calcPipe40x20();
        calcPipe20x20();
        LOGGER.info("Finish calculating metal frame parts, price: {}, total price: {}", metalFramesPartsTotalPrice, totalPrice);
    }

    private void calcPipe20x20() {
        LOGGER.info("Checking dimensions for pipe 20x20");
        if (this.getHeight() >= 1000 && this.getHeight() <= 2060
                && this.getWidth() >= 800 && this.getWidth() <= 1200) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (2 * this.getWidth() + 2 * this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getHeight() >= 2061 && this.getHeight() <= 2450
                && this.getWidth() >= 800 && this.getWidth() <= 1200) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (3 * this.getWidth() + 2 * this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getHeight() >= 1000 && this.getHeight() <= 2060
                && this.getWidth() >= 1201 && this.getWidth() <= 1500) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (2 * this.getWidth() + 3 * this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getHeight() >= 2061 && this.getHeight() <= 2450
                && this.getWidth() >= 1201 && this.getWidth() <= 1500) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (3 * this.getWidth() + 3 * this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getHeight() >= 1000 && this.getHeight() <= 2060
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
        totalPrice += metal_20x20_Price;
        LOGGER.info("Finish calculating metal 20x20 parts, price: {}, total price: {}", metal_20x20_Price, totalPrice);
    }

    private void calcPipe40x20() {
	    LOGGER.info("Checking dimensions for pipe 40x20");
	    if (this.getHeight() >= 1000 && this.getHeight() <= 2450 && this.getWidth() >= 800 && this.getWidth() <= 1950
			    && this.getHeightTransom() <= this.getHeight() - 150 && this.getHeightTransom() <= 1200) {
		    LOGGER.info("Pipe 40x20: Dimensions OK");
		    this.metal_40x20_Price = (this.getHeight() + this.getHeightTransom()) * 2 * 1.1 / 1000 * Price.PIPE_40x20.getPriceInUAH();
	    } else
		    throw new UnsupportedDimensions("Pipe 40x20", this.getHeight(), this.getWidth());
	    metalFramesPartsTotalPrice += metal_40x20_Price;
	    totalPrice += metal_40x20_Price;
	    LOGGER.info("Finish calculating metal 40x20 parts, price: {}, total price: {}", metal_40x20_Price, totalPrice);
    }

    private void calcPipe40x40() {
        LOGGER.info("Checking dimensions for pipe 40x40");
        if (this.getHeightTransom() <= this.getHeight() - 150) {
            LOGGER.info("Pipe 40x40: Dimensions OK");
            this.metal_40x40_Price = this.getHeight() / 1000 * Price.PIPE_40x40.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("Pipe 40x40", this.getHeight(), this.getWidth());

        metalFramesPartsTotalPrice += metal_40x40_Price;
        totalPrice += metal_40x40_Price;
        LOGGER.info("Finish calculating metal 40x40 parts, price: {}, total price: {}", metal_40x40_Price, totalPrice);
    }

    private void calcL50x4Part() {
        LOGGER.info("Checking dimensions for L50x4");
        if (this.getHeight() >= 1000 && this.getHeight() <= 2450 && this.getWidth() >= 800 && this.getWidth() <= 1950
		        && this.getHeightTransom() <= this.getHeight() - 150 && this.getHeightTransom() <= 1200) {
            LOGGER.info("L50x4: Dimensions OK");
            this.metal_L50x4_Price = (this.getWidth() + this.getHeight()) * 2 * 1.1 / 1000 * Price.ANGLE_50x20.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("L50x4", this.getHeight(), this.getWidth());

        metalFramesPartsTotalPrice += metal_L50x4_Price;
        totalPrice += metal_L50x4_Price;
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
        } else if (this.getHeight() >= 1000 && this.getHeight() <= 2030
		        && this.getWidth() >= 1201 && this.getWidth() <= 1950) {
	        LOGGER.info("Metal list: Dimensions OK");
	        this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH() * 1.5;
        } else if (this.getHeight() >= 2031 && this.getHeight() <= 2450
		        && this.getWidth() >= 1201 && this.getWidth() <= 1950) {
	        LOGGER.info("Metal list: Dimensions OK");
	        this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH() * 1.5;
        } else
            throw new UnsupportedDimensions("Metal list", this.getHeight(), this.getWidth());

        totalPrice += metalListPrice;
        LOGGER.info("Finish calculating metal list, price: {}, total price: {}", metalListPrice, totalPrice);
    }

    @Override
    public void calcHeater(boolean heaterNeeded) {
        LOGGER.info("Start calculating heater price");
        LOGGER.info("Checking dimensions for heater");
        if (this.getHeight() >= 1000 && this.getHeight() <= 3000
                && this.getWidth() >= 500 && this.getWidth() <= 1200) {
            LOGGER.info("Heater: Dimensions OK");
            double heaterMultiplier = heaterNeeded ? (double)this.getHeight() * this.getWidth() / 1000000 : 0.0;
            this.heaterPrice = heaterMultiplier * Price.HEATER.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("Heater", this.getHeight(), this.getWidth());

        totalPrice += heaterPrice;
        LOGGER.info("Finish calculating heater, price: {}, total price: {}", heaterPrice, totalPrice);
    }

    @Override
    public void calcSeal(boolean sealNeeded) {
        LOGGER.info("Start calculating seal price");
        LOGGER.info("Checking dimensions for seal");
        if (this.getHeight() >= 1000 && this.getHeight() <= 3000
                && this.getWidth() >= 500 && this.getWidth() <= 1200) {
            LOGGER.info("Seal: Dimensions OK");
            double heaterMultiplier = sealNeeded ? (this.getHeightTransom() + this.getHeight()) * 2 / 1000 : 0.0;
            this.sealPrice = heaterMultiplier * Price.SEAL.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("Seal", this.getHeight(), this.getWidth());

        totalPrice += sealPrice;
        LOGGER.info("Finish calculating seal, price: {}, total price: {}", sealPrice, totalPrice);
    }

    @Override
    public void calcOuterDecoration(OuterDecorationType outerDecorationType) {
        totalPrice -= outerDecorationPrice;
        outerDecoration.clear();
        switch (outerDecorationType) {
            case SELF_ADHESIVE_FILM:
                this.outerDecoration.calcSelfAdhesiveFilm(this.getWidth(), this.getHeight());
                break;
            case PAINTING_SHAGREEN:
                this.outerDecoration.calcPaintingShagreen(this.getWidth(), this.getHeight());
                break;
            case PAINTING_ANTIC:
                this.outerDecoration.calcPaintingAntic(this.getWidth(), this.getHeight());
                break;
            case PAINTING_PF:
                this.outerDecoration.calcPaintingPF(this.getWidth(), this.getHeight());
                break;
            case ANTI_LAYER:
                this.outerDecoration.calcAntiLayer(this.getWidth(), this.getHeight());
                break;
            case MDF10:
                this.outerDecoration.calcMdf10(this.getWidth(), this.getHeight());
                break;
            case MDF16:
                this.outerDecoration.calcMdf16(this.getWidth(), this.getHeight());
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
                this.outerDecoration.calcSelfAdhesiveFilmWithoutTopTransom(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case PAINTING_SHAGREEN:
                this.outerDecoration.calcPaintingShagreenWithoutTopTransom(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case PAINTING_ANTIC:
                this.outerDecoration.calcPaintingAnticWithoutTopTransom(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case PAINTING_PF:
                this.outerDecoration.calcPaintingPFWithoutTopTransom(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case ANTI_LAYER:
                this.outerDecoration.calcAntiLayerWithoutTopTransom(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case MDF10:
                this.outerDecoration.calcMdf10WithoutTopTransom(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case MDF16:
                this.outerDecoration.calcMdf16WithoutTopTransom(this.getWidth(), this.getHeight(), this.getHeightTransom());
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
                this.innerDecoration.calcPlastic(this.getWidth(), this.getHeight());
                break;
            case LAMINATED_PLASTIC:
                this.innerDecoration.calcLaminate(this.getWidth(), this.getHeight());
                break;
            case MDF10:
                this.innerDecoration.calcMdf10(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case MDF16:
                this.innerDecoration.calcMdf16(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case NO_DECORATION:
                this.innerDecoration.calcWithoutDecoration(this.getWidth(), this.getHeight());
                break;
            case METAL_LIST_PAINTING_PF:
                this.innerDecoration.calcPaintingPF(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case METAL_LIST_PAINTING_SHAGREEN:
                this.innerDecoration.calcPaintingShagreen(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case METAL_LIST_PAINTING_ANTIC:
                this.innerDecoration.calcPaintingAntic(this.getWidth(), this.getHeight(), this.getHeightTransom());
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
                this.innerDecoration.calcPlasticWithoutTopTransom(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case LAMINATED_PLASTIC:
                this.innerDecoration.calcLaminateWithoutTopTransom(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case MDF10:
                this.innerDecoration.calcMdf10WithoutTopTransom(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case MDF16:
                this.innerDecoration.calcMdf16WithoutTopTransom(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case NO_DECORATION:
                this.innerDecoration.calcWithoutDecoration(this.getWidth(), this.getHeight());
                break;
            case METAL_LIST_PAINTING_PF:
                this.innerDecoration.calcPaintingPFWithoutTopTransom(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case METAL_LIST_PAINTING_SHAGREEN:
                this.innerDecoration.calcPaintingShagreenWithoutTopTransom(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
            case METAL_LIST_PAINTING_ANTIC:
                this.innerDecoration.calcPaintingAnticWithoutTopTransom(this.getWidth(), this.getHeight(), this.getHeightTransom());
                break;
        }
        innerDecorationPrice = this.innerDecoration.getTotalInnerDecorationPrice();
        totalPrice += innerDecorationPrice;
    }

    public int getHeightTransom() {
        return heightTransom;
    }

    public void setHeightTransom(int heightTransom) {
        this.heightTransom = heightTransom;
    }


}

