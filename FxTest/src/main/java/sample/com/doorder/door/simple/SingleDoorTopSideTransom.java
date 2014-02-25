package sample.com.doorder.door.simple;

import sample.com.doorder.door.InnerDecorationType;
import sample.com.doorder.door.OuterDecorationType;
import sample.com.doorder.door.Price;

public class SingleDoorTopSideTransom extends AngledDoor {

	private int x_1;
	private int y_1;

	public int getX_1() {
		return x_1;
	}

	private SingleDoorTopSideTransomInnerDecoration innerDecoration;
	private SingleDoorTopSideTransomOuterDecoration outerDecoration;

	public SingleDoorTopSideTransom() {
		this.outerDecoration = new SingleDoorTopSideTransomOuterDecoration();
		this.innerDecoration = new SingleDoorTopSideTransomInnerDecoration();
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
		double part1 = 0;
		double part2 = 0;

		LOGGER.info("Checking dimensions for pipe 20x20");
		if (this.getX() >= 800 && this.getX() <= 1200) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			part1 = 2 * (double) this.getY() * 1.1 / 1000;
		} else if (this.getX() >= 1201 && this.getX() <= 1500) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			part1 = 3 * (double) this.getY() * 1.1 / 1000;
		} else if (this.getX() >= 1501 && this.getX() <= 2000) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			part1 = 4 * (double) this.getY() * 1.1 / 1000;
		} else if (this.getX() >= 2001 && this.getX() <= 2500) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			part1 = 5 * (double) this.getY() * 1.1 / 1000;
		} else if (this.getX() >= 2501 && this.getX() <= 3000) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			part1 = 6 * (double) this.getY() * 1.1 / 1000;
		} else
			throw new UnsupportedDimensions("Pipe 20x20", this.getY(), this.getX());

		LOGGER.info("Checking dimensions for pipe 20x20");
		if (this.getY() >= 1000 && this.getY() <= 2060) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			part2 = 2 * (double) this.getX() * 1.1 / 1000;
		} else if (this.getY() >= 2061 && this.getY() <= 2500) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			part2 = 3 * (double) this.getX() * 1.1 / 1000;
		} else if (this.getY() >= 2501 && this.getY() <= 3000) {
			LOGGER.info("Pipe 20x20: Dimensions OK");
			part2 = 4 * (double) this.getX() * 1.1 / 1000;
		} else
			throw new UnsupportedDimensions("Pipe 20x20", this.getY(), this.getX());

		this.metal_20x20_Price = (part1 + part2) * Price.PIPE_20x20.getPriceInUAH();
		metalFramesPartsTotalPrice += metal_20x20_Price;
		totalPrice += metal_20x20_Price;
		LOGGER.info("Finish calculating metal 20x20 parts, price: {}, total price: {}", metal_20x20_Price, totalPrice);
	}

	private void calcPipe40x20() {
		LOGGER.info("Checking dimensions for pipe 40x20");
		if (this.getY() >= 1000 && this.getY() <= 3000 && this.getX() >= 800 && this.getX() <= 3000
				&& this.getX_1() >= 500 && this.getX_1() <= 1250
				&& this.getY() - this.getY_1() >= 60 && this.getY() - this.getY_1() <= 1000
				&& this.getY_1() >= 1000 && this.getY_1() <= 2450) {
			LOGGER.info("Pipe 40x20: Dimensions OK");
			this.metal_40x20_Price = ((double) this.getY_1() + this.getX_1()) * 2 / 1000 * Price.PIPE_40x20.getPriceInUAH();
		} else
			throw new UnsupportedDimensions("Pipe 40x20", this.getY(), this.getX());
		metalFramesPartsTotalPrice += metal_40x20_Price;
		totalPrice += metal_40x20_Price;
		LOGGER.info("Finish calculating metal 40x20 parts, price: {}, total price: {}", metal_40x20_Price, totalPrice);
	}

	private void calcPipe40x40() {
		LOGGER.info("Checking dimensions for pipe 40x40");
		if (this.getY() >= 1000 && this.getY() <= 3000 && this.getX() >= 800 && this.getX() <= 3000
				&& this.getX_1() >= 500 && this.getX_1() <= 1250
				&& this.getY() - this.getY_1() >= 60 && this.getY() - this.getY_1() <= 1000
				&& this.getY_1() >= 1000 && this.getY_1() <= 2450) {
			LOGGER.info("Pipe 40x40: Dimensions OK");
			this.metal_40x40_Price = ((double) this.getX() + 2 * this.getY_1()) / 1000 * Price.PIPE_40x40.getPriceInUAH();
		} else
			throw new UnsupportedDimensions("Pipe 40x40", this.getY(), this.getX());

		metalFramesPartsTotalPrice += metal_40x40_Price;
		totalPrice += metal_40x40_Price;
		LOGGER.info("Finish calculating metal 40x40 parts, price: {}, total price: {}", metal_40x40_Price, totalPrice);
	}

	private void calcL50x4Part() {
		LOGGER.info("Checking dimensions for L50x4");
		if (this.getY() >= 1000 && this.getY() <= 3000 && this.getX() >= 800 && this.getX() <= 3000
				&& this.getX_1() >= 500 && this.getX_1() <= 1250
				&& this.getY() - this.getY_1() >= 60 && this.getY() - this.getY_1() <= 1000
				&& this.getY_1() >= 1000 && this.getY_1() <= 2450) {
			LOGGER.info("L50x4: Dimensions OK");
			this.metal_L50x4_Price = ((double) this.getX() + this.getY()) * 2 * 1.1 / 1000 * Price.ANGLE_50x20.getPriceInUAH();
		} else
			throw new UnsupportedDimensions("L50x4", this.getY(), this.getX());

		metalFramesPartsTotalPrice += metal_L50x4_Price;
		totalPrice += metal_L50x4_Price;
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
	public void calcHeater(boolean heaterNeeded) {
		LOGGER.info("Start calculating heater price");
		double heaterMultiplier = heaterNeeded ? (double) this.getY() * this.getX() / 1000000 : 0.0;
		this.heaterPrice = heaterMultiplier * Price.HEATER.getPriceInUAH();
		totalPrice += heaterPrice;
		LOGGER.info("Finish calculating heater, price: {}, total price: {}", heaterPrice, totalPrice);
	}

	@Override
	public void calcSeal(boolean sealNeeded) {
		double heaterMultiplier = sealNeeded ? (this.getX_1() + this.getY_1()) * 2 / 1000 : 0.0;
		this.sealPrice = heaterMultiplier * Price.SEAL.getPriceInUAH();
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

	public void setX_1(int x_1) {
		this.x_1 = x_1;
	}

	public int getY_1() {
		return y_1;
	}

	public void setY_1(int y_1) {
		this.y_1 = y_1;
	}
}
