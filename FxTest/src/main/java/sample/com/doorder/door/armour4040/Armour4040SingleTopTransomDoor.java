package sample.com.doorder.door.armour4040;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.com.doorder.door.Price;
import sample.com.doorder.door.UnsupportedDimensions;
import sample.com.doorder.door.angled.Platband;
import sample.com.doorder.door.types.InnerDecorationType;
import sample.com.doorder.door.types.OuterDecorationType;
import sample.com.doorder.door.types.PlatbandType;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Armour4040SingleTopTransomDoor extends Armour4040Door {

	public static final Logger LOGGER = LoggerFactory.getLogger(Armour4040SingleTopTransomDoor.class);
	public static final int HINGE_NUMBER = 2;

	private int y_1;
	private Armour4040SingleTopTransomDoorInnerDecoration innerDecoration;
	private Armour4040SingleTopTransomDoorOuterDecoration outerDecoration;
	private Platband platband;

	public Armour4040SingleTopTransomDoor() {
		this.innerDecoration = new Armour4040SingleTopTransomDoorInnerDecoration();
		this.outerDecoration = new Armour4040SingleTopTransomDoorOuterDecoration();
		this.platband = new Platband();
	}

	@Override
	public void calcMetalFrameParts() {
		LOGGER.info("Start calculating metal frame parts");
		calcPipe40x40();
		calcPipe40x20();
		calcPipe20x20();
		totalPrice += metalFramesPartsTotalPrice;
		LOGGER.info("Finish calculating metal frame parts, price: {}, total price: {}", metalFramesPartsTotalPrice, totalPrice);
	}

	private void calcPipe40x40() {
		LOGGER.info("Checking dimensions for pipe 40x40");
		if (this.getY() >= 1060 && this.getY() <= 3000
				&& this.getX() >= 500 && this.getX() <= 1300
				&& (this.getY() - this.getY_1()) >= 60
				&& this.getY_1() >= 1000 && this.getY_1() <= 2550) {
			LOGGER.info("Pipe 40x40: Dimensions OK");
			BigDecimal bd = new BigDecimal(((((double)this.getX() + this.getY()) * 2 + this.getX()) * 1.1 / 1000 * Price.PIPE_40x40.getPriceInUAH()));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metal_40x40_Price = bd.doubleValue() ;
		} else
			throw new UnsupportedDimensions("Pipe 40x40", this.getY(), this.getX());

		metalFramesPartsTotalPrice += metal_40x40_Price;
		totalPrice += metal_40x40_Price;
		LOGGER.info("Finish calculating metal 40x40 parts, price: {}, total price: {}", metal_40x40_Price, totalPrice);
	}

	private void calcPipe40x20() {
		LOGGER.info("Checking dimensions for pipe 40x20");
		if (this.getY() >= 1060 && this.getY() <= 3000
				&& this.getX() >= 500 && this.getX() <= 1300
				&& (this.getY() - this.getY_1()) >= 60
				&& this.getY_1() >= 1000 && this.getY_1() <= 2550) {
			LOGGER.info("Pipe 40x20: Dimensions OK");
			BigDecimal bd = new BigDecimal((((double)this.getX() + this.getY_1()) * 2 * 1.1 / 1000 * Price.PIPE_40x20.getPriceInUAH()));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metal_40x20_Price = bd.doubleValue() ;
		} else
			throw new UnsupportedDimensions("Pipe 40x20", this.getY(), this.getX());
		metalFramesPartsTotalPrice += metal_40x20_Price;
		totalPrice += metal_40x20_Price;
		LOGGER.info("Finish calculating metal 40x20 parts, price: {}, total price: {}", metal_40x20_Price, totalPrice);
	}

	private void calcPipe20x20() {
		LOGGER.info("Checking dimensions for pipe 20x20");
		if (this.getY() >= 1000 && this.getY() <= 2060
				&& this.getX() >= 500 && this.getX() <= 900) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			BigDecimal bd = new BigDecimal((double)(2 * this.getX() + this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metal_20x20_Price = bd.doubleValue();
		} else if (this.getY() >= 2061 && this.getY() <= 2450
				&& this.getX() >= 500 && this.getX() <= 900) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			BigDecimal bd = new BigDecimal((double)(3 * this.getX() + this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metal_20x20_Price = bd.doubleValue();
		} else if (this.getY() >= 1000 && this.getY() <= 2060
				&& this.getX() >= 901 && this.getX() <= 1300) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			BigDecimal bd = new BigDecimal((double)(this.getX() + this.getY()) * 2.2 / 1000 * Price.PIPE_20x20.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metal_20x20_Price = bd.doubleValue();
		} else if (this.getY() >= 2061 && this.getY() <= 2450
				&& this.getX() >= 901 && this.getX() <= 1300) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			BigDecimal bd = new BigDecimal((double)(3 * this.getX() + 2 * this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metal_20x20_Price = bd.doubleValue();
		} else if (this.getY() > 2450 && this.getY() <= 3000
				&& this.getX() >= 500 && this.getX() <= 900) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			BigDecimal bd = new BigDecimal((double)(4 * this.getX() + this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metal_20x20_Price = bd.doubleValue();
		} else if (this.getY() > 2450 && this.getY() <= 3000
				&& this.getX() >= 901 && this.getX() <= 1300) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			BigDecimal bd = new BigDecimal((double)(4 * this.getX() + 2 * this.getY()) * 1.1 / 1000 * Price.PIPE_20x20.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metal_20x20_Price = bd.doubleValue();
		} else
			throw new UnsupportedDimensions("Pipe 20x20", this.getY(), this.getX());

		metalFramesPartsTotalPrice += metal_20x20_Price;
		totalPrice += metal_20x20_Price;
		LOGGER.info("Finish calculating metal 20x20 parts, price: {}, total price: {}", metal_20x20_Price, totalPrice);
	}

	@Override
	public void calcMetalList() {
		LOGGER.info("Start calculating metal list price");
		LOGGER.info("Checking dimensions for metal list");
		if (this.getY_1() >= 1000 && this.getY_1() <= 2060
				&& this.getX() >= 500 && this.getX() <= 1050) {
			LOGGER.info("Metal list: Dimensions OK");
			BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
					+ ((double)this.getY() - this.getY_1()) * this.getX() / 1000000 * Price.LIST_M2.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metalListPrice = bd.doubleValue();
		} else if (this.getY_1() >= 2061 && this.getY_1() <= 2550
				&& this.getX() >= 500 && this.getX() <= 1050) {
			LOGGER.info("Metal list: Dimensions OK");
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
					+ ((double)this.getY() - this.getY_1()) * this.getX() / 1000000 * Price.LIST_M2.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metalListPrice = bd.doubleValue();
		} else if (this.getY_1() >= 1000 && this.getY_1() <= 2060
				&& this.getX() >= 961 && this.getX() <= 1300) {
			LOGGER.info("Metal list: Dimensions OK");
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
					+ ((double)this.getY() - this.getY_1()) * this.getX() / 1000000 * Price.LIST_M2.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metalListPrice = bd.doubleValue();
		} else if (this.getY_1() >= 2061 && this.getY_1() <= 2550
				&& this.getX() >= 961 && this.getX() <= 1300) {
			LOGGER.info("Metal list: Dimensions OK");
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
					+ ((double)this.getY() - this.getY_1()) * this.getX() / 1000000 * Price.LIST_M2.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metalListPrice = bd.doubleValue();
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
		BigDecimal bd = new BigDecimal(((double) this.getY_1() + this.getX()) * 2 / 1000 * Price.SEAL.getPriceInUAH());
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
				this.outerDecoration.calcMdf10(this.getX(), this.getY(), this.getY_1());
				break;
			case MDF16:
				this.outerDecoration.calcMdf16(this.getX(), this.getY(), this.getY_1());
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
				this.outerDecoration.calcSelfAdhesiveFilmWithoutTopTransom(this.getX(), this.getY(), this.getY_1());
				break;
			case PAINTING_SHAGREEN:
				this.outerDecoration.calcPaintingShagreenWithoutTopTransom(this.getX(), this.getY(), this.getY_1());
				break;
			case PAINTING_ANTIC:
				this.outerDecoration.calcPaintingAnticWithoutTopTransom(this.getX(), this.getY(), this.getY_1());
				break;
			case PAINTING_PF:
				this.outerDecoration.calcPaintingPFWithoutTopTransom(this.getX(), this.getY(), this.getY_1());
				break;
			case ANTI_LAYER:
				this.outerDecoration.calcAntiLayerWithoutTopTransom(this.getX(), this.getY(), this.getY_1());
				break;
			case MDF10:
				this.outerDecoration.calcMdf10WithoutTopTransom(this.getX(), this.getY(), this.getY_1());
				break;
			case MDF16:
				this.outerDecoration.calcMdf16WithoutTopTransom(this.getX(), this.getY(), this.getY_1());
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
				this.innerDecoration.calcMdf10(this.getX(), this.getY(), this.getY_1());
				break;
			case MDF16:
				this.innerDecoration.calcMdf16(this.getX(), this.getY(), this.getY_1());
				break;
			case NO_DECORATION:
				this.innerDecoration.calcWithoutDecoration(this.getX(), this.getY());
				break;
			case METAL_LIST_PAINTING_PF:
				this.innerDecoration.calcPaintingPF(this.getX(), this.getY(), this.getY_1());
				break;
			case METAL_LIST_PAINTING_SHAGREEN:
				this.innerDecoration.calcPaintingShagreen(this.getX(), this.getY(), this.getY_1());
				break;
			case METAL_LIST_PAINTING_ANTIC:
				this.innerDecoration.calcPaintingAntic(this.getX(), this.getY(), this.getY_1());
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
				this.innerDecoration.calcPlasticWithoutTopTransom(this.getX(), this.getY(), this.getY_1());
				break;
			case LAMINATED_PLASTIC:
				this.innerDecoration.calcLaminateWithoutTopTransom(this.getX(), this.getY(), this.getY_1());
				break;
			case MDF10:
				this.innerDecoration.calcMdf10WithoutTopTransom(this.getX(), this.getY(), this.getY_1());
				break;
			case MDF16:
				this.innerDecoration.calcMdf16WithoutTopTransom(this.getX(), this.getY(), this.getY_1());
				break;
			case NO_DECORATION:
				this.innerDecoration.calcWithoutDecoration(this.getX(), this.getY());
				break;
			case METAL_LIST_PAINTING_PF:
				this.innerDecoration.calcPaintingPFWithoutTopTransom(this.getX(), this.getY(), this.getY_1());
				break;
			case METAL_LIST_PAINTING_SHAGREEN:
				this.innerDecoration.calcPaintingShagreenWithoutTopTransom(this.getX(), this.getY(), this.getY_1());
				break;
			case METAL_LIST_PAINTING_ANTIC:
				this.innerDecoration.calcPaintingAnticWithoutTopTransom(this.getX(), this.getY(), this.getY_1());
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

	public int getY_1() {
		return y_1;
	}

	public void setY_1(int y_1) {
		this.y_1 = y_1;
	}
}
