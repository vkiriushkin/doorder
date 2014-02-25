package sample.com.doorder.door.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.com.doorder.door.Price;

public class Platband {

	public static final Logger LOGGER = LoggerFactory.getLogger(Platband.class);

	private double woodenPlatband;
	private double metalPlatbandPaintingPF;
	private double metalPlatbandPaintingShagreen;
	private double metalPlatbandPaintingAntic;
	private double mdf10Platband;
	private double mdf16Platband;

	private double totalPlatbandPrice;

	public void calcWoodenPlatband(int x, int y) {
		LOGGER.info("Start calculating platband");
		clear();
		LOGGER.info("Checking dimensions for wooden platband");
		if (y < 1000 || y > 2150)
			throw new UnsupportedDimensions("Wooden platband", y, x);
		LOGGER.info("Wooden platband: dimension OK");
		if (y >= 1000 && y <= 2150) {
			woodenPlatband = (2 * y + x) * 1.1 / 1000 * Price.PLATBAND_WOODEN.getPriceInUAH();
			totalPlatbandPrice += woodenPlatband;
		}
		LOGGER.info("Finish calculating platband, wooden platband price:{}", woodenPlatband);
	}

	public void calcMetalPlatbandPaintingPF(int x, int y) {
		LOGGER.info("Start calculating platband");
		clear();
		LOGGER.info("Checking dimensions for metal platband painting PF");
		if (y < 1000 || y > 2500)
			throw new UnsupportedDimensions("Metal platband painting PF", y, x);
		LOGGER.info("Metal platband painting PF: dimension OK");
		if (y >= 1000 && y <= 2500) {
			double material = (2 * y + x) * 1.1 / 1000;
			metalPlatbandPaintingPF = material * Price.PLATBAND_METAL.getPriceInUAH() + (2 * y + x) * 0.07 * Price
					.PAINTING_PF.getPriceInUAH() / 1000;
			totalPlatbandPrice += metalPlatbandPaintingPF;
		}
		LOGGER.info("Finish calculating platband, metal platband painting PF price:{}", metalPlatbandPaintingPF);
	}

	public void calcMetalPlatbandPaintingShagreen(int x, int y) {
		LOGGER.info("Start calculating platband");
		clear();
		LOGGER.info("Checking dimensions for metal platband painting shagreen");
		if (y < 1000 || y > 2500)
			throw new UnsupportedDimensions("Metal platband painting shagreen", y, x);
		LOGGER.info("Metal platband painting shagreen: dimension OK");
		if (y >= 1000 && y <= 2500) {
			double material = (2 * y + x) * 1.1 / 1000;
			metalPlatbandPaintingShagreen = material * Price.PLATBAND_METAL.getPriceInUAH() + (2 * y + x) * 0.07 * Price
					.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
			totalPlatbandPrice += metalPlatbandPaintingShagreen;
		}
		LOGGER.info("Finish calculating platband, metal platband painting shagreen price:{}", metalPlatbandPaintingShagreen);
	}

	public void calcMetalPlatbandPaintingAntic(int x, int y) {
		LOGGER.info("Start calculating platband");
		clear();
		LOGGER.info("Checking dimensions for metal platband painting antic");
		if (y < 1000 || y > 2500)
			throw new UnsupportedDimensions("Metal platband painting antic", y, x);
		LOGGER.info("Metal platband painting antic: dimension OK");
		if (y >= 1000 && y <= 2500) {
			double material = (2 * y + x) * 1.1 / 1000;
			metalPlatbandPaintingAntic = material * Price.PLATBAND_METAL.getPriceInUAH() + (2 * y + x) * 0.07 * Price
					.PAINTING_ANTIC.getPriceInUAH() / 1000;
			totalPlatbandPrice += metalPlatbandPaintingAntic;
		}
		LOGGER.info("Finish calculating platband, metal platband painting antic price:{}", metalPlatbandPaintingAntic);
	}

	public void calcMdf10Platband(int x, int y, int z) {
		LOGGER.info("Start calculating platband");
		clear();
		LOGGER.info("Checking dimensions for platband mdf10");
		if (y < 1000 || y > 2350)
			throw new UnsupportedDimensions("Platband mdf10", y, x);
		LOGGER.info("Platband mdf10: dimension OK");
		if (y >= 100 && y <= 2350) {
			double material = ((double)2 * y + x) / 1000;
			if (z >=30 && z <=60)
				mdf10Platband = material * z * Price.MDF_10.getPriceInUAH() / 1000 + 60;
			else if (z > 60 && z <=100)
				mdf10Platband = material * z * Price.MDF_10.getPriceInUAH() / 1000;
			else
				throw new UnsupportedDimensions("Platband mdf10 (platband)", 0, z);
			totalPlatbandPrice += mdf10Platband;
		}
		LOGGER.info("Finish calculating platband, platband mdf10:{}", mdf10Platband);
	}

	public void calcMdf16Platband(int x, int y, int z) {
		LOGGER.info("Start calculating platband");
		clear();
		LOGGER.info("Checking dimensions for platband mdf16");
		if (y < 1000 || y > 2350)
			throw new UnsupportedDimensions("Platband mdf16", y, x);
		LOGGER.info("Platband mdf16: dimension OK");
		if (y >= 1000 && y <= 2350) {
			double material = ((double)2 * y + x) / 1000;
			if (z >=30 && z <=60)
				mdf16Platband = material * z * Price.MDF_16.getPriceInUAH() / 1000 + 60;
			else if (z > 60 && z <=100)
				mdf16Platband = material * z * Price.MDF_16.getPriceInUAH() / 1000;
			else
				throw new UnsupportedDimensions("Platband mdf16 (platband)", 0, z);
			totalPlatbandPrice += mdf16Platband;
		}
		LOGGER.info("Finish calculating platband, platband mdf16:{}", mdf16Platband);
	}

	public double getTotalPlatbandPrice() {
		return totalPlatbandPrice;
	}

	public void clear() {
		woodenPlatband = 0;
		metalPlatbandPaintingPF = 0;
		metalPlatbandPaintingShagreen = 0;
		metalPlatbandPaintingAntic = 0;
		mdf10Platband = 0;
		mdf16Platband = 0;
		totalPlatbandPrice = 0;
	}
}
