package sample.com.doorder.door.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.com.doorder.door.*;

public class AngledDoor extends SimpleDoor {

    public static final Logger LOGGER = LoggerFactory.getLogger(AngledDoor.class);
    public static final int HINGE_NUMBER = 2;

	protected InnerDecoration innerDecoration;
	protected OuterDecoration outerDecoration;
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
        if (this.getY() >= 1000 && this.getY() <= 2060
                && this.getX() >= 500 && this.getX() <= 900) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (2 * this.getX() + this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getY() >= 2061 && this.getY() <= 2450
                && this.getX() >= 500 && this.getX() <= 900) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (3 * this.getX() + this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getY() >= 1000 && this.getY() <= 2060
                && this.getX() >= 901 && this.getX() <= 1200) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (this.getX() + this.getY()) * 2.2 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else if (this.getY() >= 2061 && this.getY() <= 2450
                && this.getX() >= 901 && this.getX() <= 1200) {
            LOGGER.info("Pipe 20x20: Dimensions OK");
            this.metal_20x20_Price = (3 * this.getX() + 2 * this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("Pipe 20x20", this.getY(), this.getX());

        metalFramesPartsTotalPrice += metal_20x20_Price;
        LOGGER.info("Finish calculating metal 20x20 parts, price: {}, total price: {}", metal_20x20_Price, totalPrice);
    }

    private void calcPipe40x20() {
        LOGGER.info("Checking dimensions for pipe 40x20");
        if (this.getY() >= 1000 && this.getY() <= 2450
                && this.getX() >= 500 && this.getX() <= 1200) {
            LOGGER.info("Pipe 40x20: Dimensions OK");
            this.metal_40x20_Price = (this.getX() + this.getY()) * 2.2 / 1000 * Price.PIPE_40x20.getPriceInUAH();
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
                && this.getX() >= 500 && this.getX() <= 1200) {
            LOGGER.info("L50x4: Dimensions OK");
            this.metal_L50x4_Price = (this.getX() + this.getY()) * 2.2 / 1000 * Price.ANGLE_50x20.getPriceInUAH();
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
                && this.getX() >= 500 && this.getX() <= 960) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1x2.getPriceInUAH();
        } else if (this.getY() >= 2031 && this.getY() <= 2450
                && this.getX() >= 500 && this.getX() <= 960) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH();
        } else if (this.getY() >= 1000 && this.getY() <= 2030
                && this.getX() >= 961 && this.getX() <= 1200) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH();
        } else if (this.getY() >= 2031 && this.getY() <= 2450
                && this.getX() >= 961 && this.getX() <= 1200) {
            LOGGER.info("Metal list: Dimensions OK");
            this.metalListPrice = Price.LIST_1_25x2_5.getPriceInUAH();
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
        LOGGER.info("Checking dimensions for heater");
        if (this.getY() >= 1000 && this.getY() <= 2450
                && this.getX() >= 500 && this.getX() <= 1200) {
            LOGGER.info("Heater: Dimensions OK");
            double heaterMultiplier = heaterNeeded ? this.getY() * this.getX() / 1000000 : 0.0;
            this.heaterPrice = heaterMultiplier * Price.HEATER.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("Heater", this.getY(), this.getX());

        totalPrice += heaterPrice;
        LOGGER.info("Finish calculating heater, price: {}, total price: {}", heaterPrice, totalPrice);
    }

    @Override
    public void calcSeal(boolean sealNeeded) {
        LOGGER.info("Start calculating seal price");
        LOGGER.info("Checking dimensions for seal");
        if (this.getY() >= 1000 && this.getY() <= 2450
                && this.getX() >= 500 && this.getX() <= 1200) {
            LOGGER.info("Seal: Dimensions OK");
            double sealMultiplier = sealNeeded ? (this.getY() + this.getX()) * 2 / 1000 : 0.0;
            this.sealPrice = sealMultiplier * Price.SEAL.getPriceInUAH();
        } else
            throw new UnsupportedDimensions("Seal", this.getY(), this.getX());

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
				this.outerDecoration.calcPaintingShagreen(this.getX(), this.getY());
				break;
			case PAINTING_ANTIC:
				this.outerDecoration.calcPaintingAntic(this.getX(), this.getY());
				break;
			case PAINTING_PF:
				this.outerDecoration.calcPaintingPF(this.getX(), this.getY());
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
		    case MDF10:
			    this.innerDecoration.calcMdf10(this.getX(), this.getY());
			    break;
		    case MDF16:
			    this.innerDecoration.calcMdf16(this.getX(), this.getY());
			    break;
		    case NO_DECORATION:
			    this.innerDecoration.calcWithoutDecoration(this.getX(), this.getY());
			    break;
		    case METAL_LIST_PAINTING_PF:
			    this.innerDecoration.calcPaintingPF(this.getX(), this.getY());
			    break;
		    case METAL_LIST_PAINTING_SHAGREEN:
			    this.innerDecoration.calcPaintingShagreen(this.getX(), this.getY());
			    break;
		    case METAL_LIST_PAINTING_ANTIC:
			    this.innerDecoration.calcPaintingAntic(this.getX(), this.getY());
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
			    this.platband.calcWoodenPlatband(this.getX(), this.getY());
			    break;
		    case METAL_PAINTING_PF:
			    this.platband.calcMetalPlatbandPaintingPF(this.getX(), this.getY());
			    break;
		    case METAL_PAINTING_SHAGREEN:
			    this.platband.calcMetalPlatbandPaintingShagreen(this.getX(), this.getY());
			    break;
		    case METAL_PAINTING_ANTIC:
			    this.platband.calcMetalPlatbandPaintingAntic(this.getX(), this.getY());
			    break;
		    case MDF10:
			    this.platband.calcMdf10Platband(this.getX(), this.getY(), this.getZ());
			    break;
		    case MDF16:
			    this.platband.calcMdf16Platband(this.getX(), this.getY(), this.getZ());
			    break;
	    }
	    platbandPrice = this.platband.getTotalPlatbandPrice();
	    totalPrice += platbandPrice;
    }

    @Override
    public void calcAccessories() {

    }
}
