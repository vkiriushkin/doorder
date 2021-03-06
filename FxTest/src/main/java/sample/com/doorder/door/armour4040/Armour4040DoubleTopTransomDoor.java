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

public class Armour4040DoubleTopTransomDoor extends Armour4040Door {

	public static final Logger LOGGER = LoggerFactory.getLogger(Armour4040DoubleTopTransomDoor.class);
	public static final int HINGE_NUMBER = 4;

	protected int x_1;
	protected int x_2;
	protected int x_3;
	protected int y_1;

	protected Armour4040DoubleTopTransomDoorInnerDecoration innerDecoration;
	protected Armour4040DoubleTopTransomDoorOuterDecoration outerDecoration;
	private Armour4040DoorPlatband platband;


	public Armour4040DoubleTopTransomDoor() {
		super();
		this.innerDecoration = new Armour4040DoubleTopTransomDoorInnerDecoration();
		this.outerDecoration = new Armour4040DoubleTopTransomDoorOuterDecoration();
		this.platband = new Armour4040DoorPlatband();
		this.productionPrice = 85;
		this.profitPrice = 450;
	}

	@Override
	public void calcMetalFrameParts() {
		LOGGER.info("Start calculating metal frame parts");
        checkDimensions();
		calcPipe40x40();
		calcPipe40x20();
		calcPipe20x20();
		totalPrice += metalFramesPartsTotalPrice;
		LOGGER.info("Finish calculating metal frame parts, price: {}, total price: {}", metalFramesPartsTotalPrice, totalPrice);
	}

    private void checkDimensions() {
        if (x_1 > this.getX() - 150)
            throw new UnsupportedDimensions("Значение x1 должно быть больше (x - 150)");
        if (this.getY() - this.getY_1() < 60 || this.getY() - this.getY_1() > 1000)
            throw new UnsupportedDimensions("Значение (y - y1) должно быть от 60 до 1000");
    }

	private void calcPipe40x40() {
		LOGGER.info("Checking dimensions for pipe 40x40");
		if (this.getX() >= 800 && this.getX() <= 2000
				&& this.getY() >= 1000 && this.getY() <= 3000
				&& x_1 >= this.getX() / 2 && x_1 <= 1200
				&& y_1 >= 1000 && y_1 <= 2450
				&& this.getY() - y_1 >= 60 && this.getY() - y_1 <= 1000) {
			LOGGER.info("Pipe 40x40: Dimensions OK");
			BigDecimal bd = new BigDecimal((((double) this.getX() + this.getY()) * 2 * 1.1 + this.getX()) / 1000 * Price.PIPE_40x40.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metal_40x40_Price = bd.doubleValue();
		} else
			throw new UnsupportedDimensions("Pipe 40x40", this.getY(), this.getX());

		metalFramesPartsTotalPrice += metal_40x40_Price;
		LOGGER.info("Finish calculating metal 40x40 parts, price: {}, total price: {}", metal_40x40_Price, totalPrice);
	}

	private void calcPipe40x20() {
		LOGGER.info("Checking dimensions for pipe 40x20");
		if (this.getX() >= 800 && this.getX() <= 2000
				&& this.getY() >= 1000 && this.getY() <= 3000
				&& x_1 >= this.getX() / 2 && x_1 <= 1200
				&& y_1 >= 1000 && y_1 <= 2450
				&& this.getY() - y_1 >= 60 && this.getY() - y_1 <= 1000) {
			LOGGER.info("Pipe 40x20: Dimensions OK");
			BigDecimal bd = new BigDecimal(((2 * (double) this.getX() + 4 * this.getY()) * 1.1) / 1000 * Price.PIPE_40x20.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metal_40x20_Price = bd.doubleValue();
		} else
			throw new UnsupportedDimensions("Pipe 40x20", this.getY(), this.getX());

		metalFramesPartsTotalPrice += metal_40x20_Price;
		LOGGER.info("Finish calculating metal 40x20 parts, price: {}, total price: {}", metal_40x20_Price, totalPrice);
	}

	private void calcPipe20x20() {
		double part1 = 0;
		double part2 = 0;

		LOGGER.info("Checking dimensions for pipe 20x20");
		if (this.getX() >= 800 && this.getX() <= 1200) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			BigDecimal bd = new BigDecimal(2 * (double) this.getY() * 1.1 / 1000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			part1 = bd.doubleValue();
		} else if (this.getX() >= 1201 && this.getX() <= 1500) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			BigDecimal bd = new BigDecimal(3 * (double) this.getY() * 1.1 / 1000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			part1 = bd.doubleValue();
		} else if (this.getX() >= 1501 && this.getX() <= 2000) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			BigDecimal bd = new BigDecimal(4 * (double) this.getY() * 1.1 / 1000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			part1 = bd.doubleValue();
		} else
			throw new UnsupportedDimensions("Pipe 20x20", this.getY(), this.getX());

		LOGGER.info("Checking dimensions for pipe 20x20");
		if (this.getY() >= 1000 && this.getY() <= 2060) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			BigDecimal bd = new BigDecimal(2 * (double) this.getX() * 1.1 / 1000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			part2 = bd.doubleValue();
		} else if (this.getY() >= 2061 && this.getY() <= 2500) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			BigDecimal bd = new BigDecimal(3 * (double) this.getX() * 1.1 / 1000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			part2 = bd.doubleValue();
		} else if (this.getY() >= 2501 && this.getY() <= 3000) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			BigDecimal bd = new BigDecimal(4 * (double) this.getX() * 1.1 / 1000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			part2 = bd.doubleValue();
		} else
			throw new UnsupportedDimensions("Pipe 20x20", this.getY(), this.getX());

		this.metal_20x20_Price = (part1 + part2) * Price.PIPE_20x20.getPriceInUAH();
		metalFramesPartsTotalPrice += metal_20x20_Price;
		LOGGER.info("Finish calculating metal 20x20 parts, price: {}, total price: {}", metal_20x20_Price, totalPrice);
	}

	@Override
	public void calcMetalList() {
		LOGGER.info("Start calculating metal list price");
		LOGGER.info("Checking dimensions for metal list");
		if (this.getY_1() >= 1000 && this.getY_1() <= 2000
				&& this.getX() >= 800 && this.getX() <= 950) {
			LOGGER.info("Metal list: Dimensions OK");
			BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
					+ ((this.getY() - this.getY_1()) * this.getX()) * Price.LIST_M2.getPriceInUAH() / 1000000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metalListPrice = bd.doubleValue();
		} else if (this.getY_1() >= 2001 && this.getY_1() <= 2450
				&& this.getX() >= 800 && this.getX() <= 950) {
			LOGGER.info("Metal list: Dimensions OK");
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
					+ ((this.getY() - this.getY_1()) * this.getX()) * Price.LIST_M2.getPriceInUAH() / 1000000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metalListPrice = bd.doubleValue();
		} else if (this.getY_1() >= 1000 && this.getY_1() <= 2000
				&& this.getX() >= 951 && this.getX() <= 1200) {
			LOGGER.info("Metal list: Dimensions OK");
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
					+ ((this.getY() - this.getY_1()) * this.getX()) * Price.LIST_M2.getPriceInUAH() / 1000000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metalListPrice = bd.doubleValue();
		} else if (this.getY_1() >= 2001 && this.getY_1() <= 2450
				&& this.getX() >= 951 && this.getX() <= 1200) {
			LOGGER.info("Metal list: Dimensions OK");
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
					+ ((this.getY() - this.getY_1()) * this.getX()) * Price.LIST_M2.getPriceInUAH() / 1000000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metalListPrice = bd.doubleValue();
		} else if (this.getY_1() >= 1000 && this.getY_1() <= 2000
				&& this.getX() >= 1201 && this.getX() <= 2000) {
			LOGGER.info("Metal list: Dimensions OK");
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() * 1.5
					+ ((this.getY() - this.getY_1()) * this.getX()) * Price.LIST_M2.getPriceInUAH() / 1000000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metalListPrice = bd.doubleValue();
		} else if (this.getY_1() >= 2001 && this.getY_1() <= 2450
				&& this.getX() >= 1201 && this.getX() <= 2000) {
			LOGGER.info("Metal list: Dimensions OK");
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() * 1.5
					+ ((this.getY() - this.getY_1()) * this.getX()) * Price.LIST_M2.getPriceInUAH() / 1000000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			this.metalListPrice = bd.doubleValue();
		} else
			throw new UnsupportedDimensions("Metal list", this.getY_1(), this.getX());

		totalPrice += metalListPrice;
		LOGGER.info("Finish calculating metal list, price: {}, total price: {}", metalListPrice, totalPrice);
	}

	@Override
	public void calcHinge() {
		LOGGER.info("Start calculating hinge price");
		BigDecimal bd = new BigDecimal(HINGE_NUMBER * Price.HINGE.getPriceInUAH());
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		this.hingePrice = bd.doubleValue();
		totalPrice += hingePrice;
		LOGGER.info("Finish calculating hinge, price: {}, total price: {}", hingePrice, totalPrice);
	}

	@Override
	public void calcHeater(boolean heaterNeeded) {
		LOGGER.info("Start calculating heater price");
		BigDecimal bd = new BigDecimal((double)this.getY() * this.getX() / 1000000 * Price.HEATER.getPriceInUAH());
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		double price = heaterNeeded ? bd.doubleValue() : 0.0;
		this.heaterPrice = price;
		totalPrice += heaterPrice;
		LOGGER.info("Finish calculating heater, price: {}, total price: {}", heaterPrice, totalPrice);
	}

	@Override
	public void calcSeal(boolean sealNeeded) {
		BigDecimal bd = new BigDecimal(((2 * (double)this.getX() + 3 * this.getY_1()) / 1000) * Price.SEAL.getPriceInUAH());
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
				this.outerDecoration.calcSelfAdhesiveFilm(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case PAINTING_SHAGREEN:
				this.outerDecoration.calcPaintingShagreen(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case PAINTING_ANTIC:
				this.outerDecoration.calcPaintingAntic(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case PAINTING_PF:
				this.outerDecoration.calcPaintingPF(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case ANTI_LAYER:
				this.outerDecoration.calcAntiLayer(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case MDF10:
				this.outerDecoration.calcMdf10(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case MDF16:
				this.outerDecoration.calcMdf16(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
		}
		outerDecorationPrice = this.outerDecoration.getTotalOuterDecorationPrice();
		totalPrice += outerDecorationPrice;
	}

	public void calcOuterDecorationWithoutTopSideTransom(OuterDecorationType outerDecorationType) {
		totalPrice -= outerDecorationPrice;
		outerDecoration.clear();
		switch (outerDecorationType) {
			case SELF_ADHESIVE_FILM:
				this.outerDecoration.calcSelfAdhesiveFilmWithoutTopSideTransom(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case PAINTING_SHAGREEN:
				this.outerDecoration.calcPaintingShagreenWithoutTopSideTransom(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case PAINTING_ANTIC:
				this.outerDecoration.calcPaintingAnticWithoutTopSideTransom(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case PAINTING_PF:
				this.outerDecoration.calcPaintingPFWithoutTopSideTransom(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case ANTI_LAYER:
				this.outerDecoration.calcAntiLayerWithoutTopSideTransom(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case MDF10:
				this.outerDecoration.calcMdf10WithoutTopSideTransom(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case MDF16:
				this.outerDecoration.calcMdf16WithoutTopSideTransom(this.getX(), this.getY(), this.getX_1(), this.getY_1());
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
				this.innerDecoration.calcPlastic(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case LAMINATED_PLASTIC:
				this.innerDecoration.calcLaminate(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case MDF10:
				this.innerDecoration.calcMdf10(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case MDF16:
				this.innerDecoration.calcMdf16(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case NO_DECORATION:
				this.innerDecoration.calcWithoutDecoration(this.getX(), this.getY());
				break;
			case METAL_LIST_PAINTING_PF:
				this.innerDecoration.calcPaintingPF(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case METAL_LIST_PAINTING_SHAGREEN:
				this.innerDecoration.calcPaintingShagreen(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case METAL_LIST_PAINTING_ANTIC:
				this.innerDecoration.calcPaintingAntic(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
		}
		innerDecorationPrice = this.innerDecoration.getTotalInnerDecorationPrice();
		totalPrice += innerDecorationPrice;
	}

	public void calcInnerDecorationWithoutTopSideTransom(InnerDecorationType innerDecorationType) {
		totalPrice -= innerDecorationPrice;
		innerDecoration.clear();
		switch (innerDecorationType) {
			case PLASTIC:
				this.innerDecoration.calcPlasticWithoutTopSideTransom(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case LAMINATED_PLASTIC:
				this.innerDecoration.calcLaminateWithoutTopSideTransom(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case MDF10:
				this.innerDecoration.calcMdf10WithoutTopSideTransom(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case MDF16:
				this.innerDecoration.calcMdf16WithoutTopSideTransom(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case NO_DECORATION:
				this.innerDecoration.calcWithoutDecoration(this.getX(), this.getY());
				break;
			case METAL_LIST_PAINTING_PF:
				this.innerDecoration.calcPaintingPFWithoutTopSideTransom(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case METAL_LIST_PAINTING_SHAGREEN:
				this.innerDecoration.calcPaintingShagreenWithoutTopSideTransom(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
			case METAL_LIST_PAINTING_ANTIC:
				this.innerDecoration.calcPaintingAnticWithoutTopSideTransom(this.getX(), this.getY(), this.getX_1(), this.getY_1());
				break;
		}
		innerDecorationPrice = this.innerDecoration.getTotalInnerDecorationPrice();
		totalPrice += innerDecorationPrice;
	}

	@Override
	public void calcPlatband(PlatbandType platbandType) {
        if ((platbandType.equals(PlatbandType.METAL_PAINTING_ANTIC)
                || platbandType.equals(PlatbandType.METAL_PAINTING_PF)
                || platbandType.equals(PlatbandType.METAL_PAINTING_SHAGREEN))
                && this.getY() > 3000)
            throw new UnsupportedDimensions("Значение y должно быть меньше или равно 3000 мм");
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
            case NO_PLATBAND:
                this.platband.calcNoPlatband(this.getX(), this.getY(), this.getZ(), this.getClass());
                break;
		}
		platbandPrice = this.platband.getTotalPlatbandPrice();
		totalPrice += platbandPrice;
	}

	public int getX_1() {
		return x_1;
	}

	public void setX_1(int x_1) {
		this.x_1 = x_1;
	}

	public int getX_2() {
		return x_2;
	}

	public void setX_2(int x_2) {
		this.x_2 = x_2;
	}

	public int getX_3() {
		return x_3;
	}

	public void setX_3(int x_3) {
		this.x_3 = x_3;
	}

	public int getY_1() {
		return y_1;
	}

	public void setY_1(int y_1) {
		this.y_1 = y_1;
	}
}
