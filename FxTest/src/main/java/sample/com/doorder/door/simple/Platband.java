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

	public void calcWoodenPlatband(int width, int height) {
		LOGGER.info("Start calculating platband");
		clear();
		LOGGER.info("Checking dimensions for wooden platband");
		if (height < 1000 || height > 2150)
			throw new UnsupportedDimensions("Wooden platband", height, width);
		LOGGER.info("Wooden platband: dimension OK");
		if (width > 999 && width < 2151) {
			woodenPlatband = (2 * height + width) * 1.1 / 1000 * Price.PLATBAND_WOODEN.getPriceInUAH();
			totalPlatbandPrice += woodenPlatband;
		}
		LOGGER.info("Finish calculating platband, wooden platband price:{}", woodenPlatband);
	}

	public void calcMetalPlatbandPaintingPF(int width, int height) {
		LOGGER.info("Start calculating platband");
		clear();
		LOGGER.info("Checking dimensions for metal platband painting PF");
		if (height < 1000 || height > 2500)
			throw new UnsupportedDimensions("Metal platband painting PF", height, width);
		LOGGER.info("Metal platband painting PF: dimension OK");
		if (width > 999 && width < 2501) {
			double material = (2 * height + width) * 1.1 / 1000;
			metalPlatbandPaintingPF = material * Price.PLATBAND_METAL.getPriceInUAH() + (2 * height + width) * 0.07 * Price
					.PAINTING_PF.getPriceInUAH() / 1000;
			totalPlatbandPrice += metalPlatbandPaintingPF;
		}
		LOGGER.info("Finish calculating platband, metal platband painting PF price:{}", metalPlatbandPaintingPF);
	}

	public void calcMetalPlatbandPaintingShagreen(int width, int height) {
		LOGGER.info("Start calculating platband");
		clear();
		LOGGER.info("Checking dimensions for metal platband painting shagreen");
		if (height < 1000 || height > 2500)
			throw new UnsupportedDimensions("Metal platband painting shagreen", height, width);
		LOGGER.info("Metal platband painting shagreen: dimension OK");
		if (width > 999 && width < 2501) {
			double material = (2 * height + width) * 1.1 / 1000;
			metalPlatbandPaintingShagreen = material * Price.PLATBAND_METAL.getPriceInUAH() + (2 * height + width) * 0.07 * Price
					.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
			totalPlatbandPrice += metalPlatbandPaintingShagreen;
		}
		LOGGER.info("Finish calculating platband, metal platband painting shagreen price:{}", metalPlatbandPaintingShagreen);
	}

	public void calcMetalPlatbandPaintingAntic(int width, int height) {
		LOGGER.info("Start calculating platband");
		clear();
		LOGGER.info("Checking dimensions for metal platband painting antic");
		if (height < 1000 || height > 2500)
			throw new UnsupportedDimensions("Metal platband painting antic", height, width);
		LOGGER.info("Metal platband painting antic: dimension OK");
		if (width > 999 && width < 2501) {
			double material = (2 * height + width) * 1.1 / 1000;
			metalPlatbandPaintingAntic = material * Price.PLATBAND_METAL.getPriceInUAH() + (2 * height + width) * 0.07 * Price
					.PAINTING_ANTIC.getPriceInUAH() / 1000;
			totalPlatbandPrice += metalPlatbandPaintingAntic;
		}
		LOGGER.info("Finish calculating platband, metal platband painting antic price:{}", metalPlatbandPaintingAntic);
	}

	public void calcMdf10Platband(int width, int height, int pWidth) {
		LOGGER.info("Start calculating platband");
		clear();
		LOGGER.info("Checking dimensions for platband mdf10");
		if (height < 1000 || height > 2350)
			throw new UnsupportedDimensions("Platband mdf10", height, width);
		LOGGER.info("Platband mdf10: dimension OK");
		if (width > 999 && width < 2351) {
			double material = (2 * height + width) / 1000;
			if (pWidth >=30 && pWidth <=60)
				mdf10Platband = material * pWidth * Price.MDF_10.getPriceInUAH() / 1000 + 60;
			else if (pWidth > 60 && pWidth <=100)
				mdf10Platband = material * pWidth * Price.MDF_10.getPriceInUAH() / 1000;
			else
				throw new UnsupportedDimensions("Platband mdf10 (platband)", 0, pWidth);
			totalPlatbandPrice += mdf10Platband;
		}
		LOGGER.info("Finish calculating platband, platband mdf10:{}", mdf10Platband);
	}

	public void calcMdf16Platband(int width, int height, int pWidth) {
		LOGGER.info("Start calculating platband");
		clear();
		LOGGER.info("Checking dimensions for platband mdf16");
		if (height < 1000 || height > 2350)
			throw new UnsupportedDimensions("Platband mdf16", height, width);
		LOGGER.info("Platband mdf16: dimension OK");
		if (width > 999 && width < 2351) {
			double material = (2 * height + width) / 1000;
			if (pWidth >=30 && pWidth <=60)
				mdf16Platband = material * pWidth * Price.MDF_16.getPriceInUAH() / 1000 + 60;
			else if (pWidth > 60 && pWidth <=100)
				mdf16Platband = material * pWidth * Price.MDF_16.getPriceInUAH() / 1000;
			else
				throw new UnsupportedDimensions("Platband mdf16 (platband)", 0, pWidth);
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
