package sample.com.doorder.door.fireproof;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.com.doorder.door.angled.Platband;
import sample.com.doorder.door.UnsupportedDimensions;
import sample.com.doorder.door.types.InnerDecorationType;
import sample.com.doorder.door.types.OuterDecorationType;
import sample.com.doorder.door.types.PlatbandType;
import sample.com.doorder.door.Price;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SingleFireProofDoor extends FireProofDoorImpl {

	public static final Logger LOGGER = LoggerFactory.getLogger(SingleFireProofDoor.class);
	public static final int HINGE_NUMBER = 3;

    protected FireProofInnerDecoration innerDecoration;
    protected FireProofOuterDecoration outerDecoration;
    private Platband platband;

    public SingleFireProofDoor() {
        super();
        this.innerDecoration = new FireProofInnerDecoration();
        this.outerDecoration = new FireProofOuterDecoration();
        this.platband = new Platband();
	    this.productionPrice = 60;
	    this.profitPrice = 800;
    }

    @Override
	public void calcMetalFrameParts() {
		LOGGER.info("Start calculating metal frame parts");
		calcPipe40x40();
		calcPipe40x20();
		totalPrice += metalFramesPartsTotalPrice;
		LOGGER.info("Finish calculating metal frame parts, price: {}, total price: {}", metalFramesPartsTotalPrice, totalPrice);
	}

	private void calcPipe40x40() {
		LOGGER.info("Checking dimensions for pipe 40x40");
		if (this.getY() >= 1000 && this.getY() <= 2550
				&& this.getX() >= 500 && this.getX() <= 1100) {
			LOGGER.info("Pipe 40x40: Dimensions OK");
			BigDecimal bd = new BigDecimal(((double)this.getX() + this.getY()) * 2.2 / 1000 * Price.PIPE_40x40.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metal_40x40_Price = bd.doubleValue();
		} else
			throw new UnsupportedDimensions("Pipe 40x40", this.getY(), this.getX());
		metalFramesPartsTotalPrice += metal_40x40_Price;
		LOGGER.info("Finish calculating metal 40x40 parts, price: {}, total price: {}", metal_40x40_Price, totalPrice);
	}

	private void calcPipe40x20() {
		LOGGER.info("Checking dimensions for pipe 40x20");
		if (this.getY() >= 1000 && this.getY() <= 2060
				&& this.getX() >= 500 && this.getX() <= 900) {
			LOGGER.info("Pipe 40x20: Dimensions OK");
			BigDecimal bd = new BigDecimal((((double)this.getX() + this.getY()) * 2.2 / 1000 + 1.1 * ((double)this.getY() + 2 * this.getX()) / 1000) * Price.PIPE_40x20.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metal_40x20_Price = bd.doubleValue();
		} else if (this.getY() >= 2061 && this.getY() <= 2550
				&& this.getX() >= 500 && this.getX() <= 900) {
			LOGGER.info("Pipe 40x20: Dimensions OK");
			BigDecimal bd = new BigDecimal((((double)this.getX() + this.getY()) * 2.2 / 1000 + 1.1 * ((double)this.getY() + 3 * this.getX()) / 1000) * Price.PIPE_40x20.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metal_40x20_Price = bd.doubleValue();
		} else if (this.getY() >= 1000 && this.getY() <= 2060
				&& this.getX() >= 901 && this.getX() <= 1100) {
			LOGGER.info("Pipe 40x20: Dimensions OK");
			BigDecimal bd = new BigDecimal((((double)this.getX() + this.getY()) * 2.2 / 1000 + 2.2 * ((double)this.getY() + this.getX()) / 1000) * Price.PIPE_40x20.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metal_40x20_Price = bd.doubleValue();
		} else if (this.getY() >= 2061 && this.getY() <= 2550
				&& this.getX() >= 901 && this.getX() <= 1100) {
			LOGGER.info("Pipe 40x20: Dimensions OK");
			BigDecimal bd = new BigDecimal((((double)this.getX() + this.getY()) * 2.2 / 1000 + 1.1 * ((double)2 * this.getY() + 3 * this.getX()) / 1000) * Price.PIPE_40x20.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metal_40x20_Price = bd.doubleValue();
		} else
			throw new UnsupportedDimensions("Pipe 40x20", this.getY(), this.getX());
		metalFramesPartsTotalPrice += metal_40x20_Price;
		LOGGER.info("Finish calculating metal 40x20 parts, price: {}, total price: {}", metal_40x20_Price, totalPrice);
	}

	@Override
	public void calcInnerMetalList() {
		LOGGER.info("Checking dimensions for inner metal list");
		if (this.getY() - 40 >= 1000 && this.getY() - 40 <= 2060
				&& this.getX() - 40 >= 500 && this.getX() - 40 <= 1050) {
			LOGGER.info("Inner metal list: Dimensions OK");
			this.innerMetalListPrice = Price.LIST_1x2x1_5.getPriceInUAH();
		} else if (this.getY() - 40 >= 2061 && this.getY() - 40 <= 2550
				&& this.getX() - 40 >= 500 && this.getX() - 40 <= 1050) {
			LOGGER.info("Inner metal list: Dimensions OK");
			this.innerMetalListPrice = Price.LIST_1_25x2_5x1_5.getPriceInUAH();
		} else if (this.getY() - 40 >= 1000 && this.getY() - 40 <= 2060
				&& this.getX() - 40 >= 1051 && this.getX() - 40 <= 1100) {
			LOGGER.info("Inner metal list: Dimensions OK");
			this.innerMetalListPrice = Price.LIST_1_25x2_5x1_5.getPriceInUAH();
		} else if (this.getY() - 40 >= 2061 && this.getY() - 40 <= 2550
				&& this.getX() - 40 >= 1051 && this.getX() - 40 <= 1100) {
			LOGGER.info("Inner metal list: Dimensions OK");
			this.innerMetalListPrice = Price.LIST_1_25x2_5x1_5.getPriceInUAH();
		} else
			throw new UnsupportedDimensions("Inner metal list", this.getY(), this.getX());
		totalPrice += innerMetalListPrice;
		LOGGER.info("Finish calculating inner metal list, price: {}, total price: {}", innerMetalListPrice, totalPrice);
	}

	@Override
	public void calcOuterMetalList() {
		LOGGER.info("Checking dimensions for outer metal list");
		if (this.getY() >= 1000 && this.getY() <= 2060
				&& this.getX() >= 500 && this.getX() <= 1050) {
			LOGGER.info("Outer metal list: Dimensions OK");
			this.outerMetalListPrice = Price.LIST_1x2x1_5.getPriceInUAH();
		} else if (this.getY() >= 2061 && this.getY() <= 2550
				&& this.getX() >= 500 && this.getX() <= 1050) {
			LOGGER.info("Outer metal list: Dimensions OK");
			this.outerMetalListPrice = Price.LIST_1_25x2_5x1_5.getPriceInUAH();
		} else if (this.getY() >= 1000 && this.getY() <= 2060
				&& this.getX() >= 1051 && this.getX() <= 1100) {
			LOGGER.info("Outer metal list: Dimensions OK");
			this.outerMetalListPrice = Price.LIST_1_25x2_5x1_5.getPriceInUAH();
		} else if (this.getY() >= 2061 && this.getY() <= 2550
				&& this.getX() >= 1051 && this.getX() <= 1100) {
			LOGGER.info("Outer metal list: Dimensions OK");
			this.outerMetalListPrice = Price.LIST_1_25x2_5x1_5.getPriceInUAH();
		} else
			throw new UnsupportedDimensions("Outer metal list", this.getY(), this.getX());
		totalPrice += outerMetalListPrice;
		LOGGER.info("Finish calculating outer metal list, price: {}, total price: {}", outerMetalListPrice, totalPrice);
	}

	@Override
	public void calcHinge() {
		LOGGER.info("Start calculating hinge price");
		this.hingePrice = HINGE_NUMBER * Price.HINGE.getPriceInUAH();
		totalPrice += hingePrice;
		LOGGER.info("Finish calculating hinge, price: {}, total price: {}", hingePrice, totalPrice);
	}

	@Override
	public void calcOgrask() {
		LOGGER.info("Start calculating ogrask price");
		this.ograskPrice = ((double)this.getX() + this.getY()) * 2 / 1000 * Price.OGRASK.getPriceInUAH();
		totalPrice += ograskPrice;
		LOGGER.info("Finish calculating ogrask, price: {}, total price: {}", ograskPrice, totalPrice);
	}

	@Override
	public void calcDryWall() {
		LOGGER.info("Start calculating dryWall price");
		BigDecimal bd = new BigDecimal(((double)this.getX() * this.getY()) * 2 / 1000000 * Price.DRYWALL.getPriceInUAH());
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		this.dryWallPrice = bd.doubleValue();
		totalPrice += dryWallPrice;
		LOGGER.info("Finish calculating dryWall, price: {}, total price: {}", dryWallPrice, totalPrice);
	}

	@Override
	public void calcMineralWool() {
		LOGGER.info("Start calculating mineral wool price");
		BigDecimal bd = new BigDecimal(((double)this.getX() * this.getY()) / 1000000 * Price.MINERAL_WOOL.getPriceInUAH());
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		this.mineralWoolPrice = bd.doubleValue();
		totalPrice += mineralWoolPrice;
		LOGGER.info("Finish calculating mineral wool, price: {}, total price: {}", mineralWoolPrice, totalPrice);
	}

	@Override
	public void calcSeal() {
		LOGGER.info("Start calculating seal price");
		BigDecimal bd = new BigDecimal((((double)this.getY() + this.getX()) * 2 / 1000) * Price.SEAL.getPriceInUAH());
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		this.sealPrice = bd.doubleValue();
		totalPrice += sealPrice;
		LOGGER.info("Finish calculating seal, price: {}, total price: {}", sealPrice, totalPrice);
	}

	@Override
	public void calcOuterDecoration(OuterDecorationType outerDecorationType) {
        if (outerDecorationType.equals(InnerDecorationType.MDF10) || outerDecorationType.equals(InnerDecorationType.MDF16) && this.getY() > 2350)
            throw new UnsupportedDimensions("Outer decoration", "Can't apply MDF decoration", String.valueOf(this.getY()));
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
        if (innerDecorationType.equals(InnerDecorationType.MDF10) || innerDecorationType.equals(InnerDecorationType.MDF16) && this.getY() > 2350)
            throw new UnsupportedDimensions("Inner decoration", "Can't apply MDF decoration", String.valueOf(this.getY()));
        totalPrice -= innerDecorationPrice;
        innerDecoration.clear();
        switch (innerDecorationType) {
            case MDF10:
                this.innerDecoration.calcMdf10(this.getX(), this.getY());
                break;
            case MDF16:
                this.innerDecoration.calcMdf16(this.getX(), this.getY());
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
            case METAL_PAINTING_PF:
                this.platband.calcMetalPlatbandPaintingPF(this.getX(), this.getY(), this.getClass());
                break;
            case METAL_PAINTING_SHAGREEN:
                this.platband.calcMetalPlatbandPaintingShagreen(this.getX(), this.getY(), this.getClass());
                break;
            case METAL_PAINTING_ANTIC:
                this.platband.calcMetalPlatbandPaintingAntic(this.getX(), this.getY(), this.getClass());
                break;
            case NO_PLATBAND:
                this.platband.calcNoPlatband(this.getX(), this.getY(), 0, this.getClass());
                break;
        }
        platbandPrice = this.platband.getTotalPlatbandPrice();
        totalPrice += platbandPrice;
	}

}
