package sample.com.doorder.door.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.com.doorder.door.*;

public class AngledDoor extends SimpleDoor {

    public static final Logger LOGGER = LoggerFactory.getLogger(AngledDoor.class);
    public static final int HINGE_NUMBER = 2;

	private InnerDecoration innerDecoration;
	private OuterDecoration outerDecoration;
	private Platband platband;

    public AngledDoor() {
        super();
	    this.innerDecoration = new InnerDecoration();
	    this.outerDecoration = new OuterDecoration();
	    this.platband = new Platband();
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
                && this.getWidth() >= 500 && this.getWidth() <= 900) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (2 * this.getWidth() + this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getHeight() >= 2061 && this.getHeight() <= 2450
                && this.getWidth() >= 500 && this.getWidth() <= 900) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (3 * this.getWidth() + this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getHeight() >= 1000 && this.getHeight() <= 2060
                && this.getWidth() >= 901 && this.getWidth() <= 1200) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (this.getWidth() + this.getHeight()) * 2.2 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getHeight() >= 2061 && this.getHeight() <= 2450
                && this.getWidth() >= 901 && this.getWidth() <= 1200) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (3 * this.getWidth() + 2 * this.getHeight()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("Pipe 20x20", this.getHeight(), this.getWidth());

        metalFramesPartsTotalPrice += metal_20x20_Price;
        LOGGER.info("Finish calculating metal 20x20 parts, price: {}, total price: {}", metal_20x20_Price, totalPrice);
    }

    private void calcPipe40x20() {
        LOGGER.info("Checking dimensions for pipe 40x20");
        if (this.getHeight() >= 1000 && this.getHeight() <= 2450
                && this.getWidth() >= 500 && this.getWidth() <= 1200) {
            LOGGER.info("Pipe 40x20: Dimensions OK");
            this.metal_40x20_Price = (this.getWidth() + this.getHeight()) * 2.2 / 1000 * Price.PIPE_40x20.getPriceInUAH();
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
                && this.getWidth() >= 500 && this.getWidth() <= 1200) {
            LOGGER.info("L50x4: Dimensions OK");
            this.metal_L50x4_Price = (this.getWidth() + this.getHeight()) * 2.2 / 1000 * Price.ANGLE_50x20.getPriceInUAH();
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
                && this.getWidth() >= 500 && this.getWidth() <= 960) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1x2.getPriceInUAH();
        } else if (this.getHeight() >= 2031 && this.getHeight() <= 2450
                && this.getWidth() >= 500 && this.getWidth() <= 960) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH();
        } else if (this.getHeight() >= 1000 && this.getHeight() <= 2030
                && this.getWidth() >= 961 && this.getWidth() <= 1200) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH();
        } else if (this.getHeight() >= 2031 && this.getHeight() <= 2450
                && this.getWidth() >= 961 && this.getWidth() <= 1200) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH();
        } else
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
        LOGGER.info("Checking dimensions for heater");
        if (this.getHeight() >= 1000 && this.getHeight() <= 2450
                && this.getWidth() >= 500 && this.getWidth() <= 1200) {
            LOGGER.info("Heater: Dimensions OK");
            double heaterMultiplier = heaterNeeded ? this.getHeight() * this.getWidth() / 1000000 : 0.0;
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
        if (this.getHeight() >= 1000 && this.getHeight() <= 2450
                && this.getWidth() >= 500 && this.getWidth() <= 1200) {
            LOGGER.info("Seal: Dimensions OK");
            double sealMultiplier = sealNeeded ? (this.getHeight() + this.getWidth()) * 2 / 1000 : 0.0;
            this.sealPrice = sealMultiplier * Price.SEAL.getPriceInUAH();
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
			    this.innerDecoration.calcMdf10(this.getWidth(), this.getHeight());
			    break;
		    case MDF16:
			    this.innerDecoration.calcMdf16(this.getWidth(), this.getHeight());
			    break;
		    case NO_DECORATION:
			    this.innerDecoration.calcWithoutDecoration(this.getWidth(), this.getHeight());
			    break;
		    case METAL_LIST_PAINTING_PF:
			    this.innerDecoration.calcPaintingPF(this.getWidth(), this.getHeight());
			    break;
		    case METAL_LIST_PAINTING_SHAGREEN:
			    this.innerDecoration.calcPaintingShagreen(this.getWidth(), this.getHeight());
			    break;
		    case METAL_LIST_PAINTING_ANTIC:
			    this.innerDecoration.calcPaintingAntic(this.getWidth(), this.getHeight());
			    break;
	    }
	    innerDecorationPrice = this.innerDecoration.getTotalInnerDecorationPrice();
	    totalPrice += innerDecorationPrice;
    }

    @Override
    public void calcPlatband(PlatbandType platbandType) {
	    totalPrice -= platbandPrice;
	    platband.clear();
	    switch (platbandType) {
		    case WOODEN:
			    this.platband.calcWoodenPlatband(this.getWidth(), this.getHeight());
			    break;
		    case METAL_PAINTING_PF:
			    this.platband.calcMetalPlatbandPaintingPF(this.getWidth(), this.getHeight());
			    break;
		    case METAL_PAINTING_SHAGREEN:
			    this.platband.calcMetalPlatbandPaintingShagreen(this.getWidth(), this.getHeight());
			    break;
		    case METAL_PAINTING_ANTIC:
			    this.platband.calcMetalPlatbandPaintingAntic(this.getWidth(), this.getHeight());
			    break;
		    case MDF10:
			    this.platband.calcMdf10Platband(this.getWidth(), this.getHeight(), this.getpWidth());
			    break;
		    case MDF16:
			    this.platband.calcMdf16Platband(this.getWidth(), this.getHeight(), this.getpWidth());
			    break;
	    }
	    platbandPrice = this.platband.getTotalPlatbandPrice();
	    totalPrice += platbandPrice;
    }

    @Override
    public void calcAccessories() {

    }
}
