package sample.com.doorder.door.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.com.doorder.door.Price;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OuterDecoration {

    public static final Logger LOGGER = LoggerFactory.getLogger(OuterDecoration.class);

    private double selfAdhesiveFilm;
    private double paintingShagreen;
    private double paintingAntic;
    private double paintingPF;
    private double antiLayer;
    private double mdf10;
    private double mdf16;
    private double totalOuterDecorationPrice;

    public OuterDecoration() {
    }

    public void calcSelfAdhesiveFilm(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for self adhesive film");
        if (width < 500 || width > 1200)
            throw new UnsupportedDimensions("Self adhesive film", height, width);
        LOGGER.info("Self adhesive film: dimension OK");
        if (width > 499 && width < 801) {
            selfAdhesiveFilm = 1.1 * height / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH();
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        if (width > 800 && width < 1201) {
	        double material = 1.1 * 1.5 * height / 1000;
            selfAdhesiveFilm = material * Price.SELF_ADHESIVE_FILM.getPriceInUAH() + ((width + height) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        LOGGER.info("Finish calculating outer decoration, self adhesive film price:{}", selfAdhesiveFilm);
    }

	public void calcSelfAdhesiveFilmWithoutTopTransom(int width, int height, int heightTransom) {
		LOGGER.info("Start calculating outer decoration without top transom");
		clear();
		LOGGER.info("Checking dimensions for self adhesive film without top transom");
		if (width < 500 || width > 1200)
			throw new UnsupportedDimensions("Self adhesive film, without top transom", height, width);
		LOGGER.info("Self adhesive film, without top transom: dimension OK");
		if (width > 499 && width < 801) {
			double material = 1.1 * heightTransom / 1000;
			selfAdhesiveFilm = material * Price.SELF_ADHESIVE_FILM.getPriceInUAH() + (height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000 + ((width + height) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
			totalOuterDecorationPrice += selfAdhesiveFilm;
		}
		if (width > 800 && width < 1201) {
			double material = 1.1 * 1.5 * heightTransom / 1000;
			selfAdhesiveFilm = material * Price.SELF_ADHESIVE_FILM.getPriceInUAH() + (height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000 + ((width + height) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
			totalOuterDecorationPrice += selfAdhesiveFilm;
		}
		LOGGER.info("Finish calculating outer decoration, self adhesive film price without top transom:{}", selfAdhesiveFilm);
	}

    public void calcPaintingShagreen(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
	    BigDecimal bd = new BigDecimal(((double)width * height) / 1000000 + (width + height) * 2 * 0.16 / 1000);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingShagreen = bd.doubleValue() * Price.PAINTING_SHAGREEN.getPriceInUAH();
        totalOuterDecorationPrice += paintingShagreen;
        LOGGER.info("Finish calculating outer decoration, painting shagreen price:{}", paintingShagreen);
    }

	public void calcPaintingShagreenWithoutTopTransom(int width, int height, int heightTransom) {
		LOGGER.info("Start calculating outer decoration without top transom");
		clear();
		BigDecimal bd = new BigDecimal(((double)width * heightTransom) / 1000000 + (width + heightTransom) * 2 * 0.16 / 1000);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		paintingShagreen = bd.doubleValue() * Price.PAINTING_SHAGREEN.getPriceInUAH() + (height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000;
		totalOuterDecorationPrice += paintingShagreen;
		LOGGER.info("Finish calculating outer decoration, painting shagreen price without top transom:{}", paintingShagreen);
	}

    public void calcPaintingAntic(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
	    BigDecimal bd = new BigDecimal(((double)width * height) / 1000000 + (width + height) * 2 * 0.16 / 1000);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingAntic = bd.doubleValue() * Price.PAINTING_ANTIC.getPriceInUAH();
        totalOuterDecorationPrice += paintingAntic;
        LOGGER.info("Finish calculating outer decoration, painting antic price:{}", paintingAntic);
    }

	public void calcPaintingAnticWithoutTopTransom(int width, int height, int heightTransom) {
		LOGGER.info("Start calculating outer decoration without top transom");
		clear();
		BigDecimal bd = new BigDecimal(((double)width * heightTransom) / 1000000 + (width + heightTransom) * 2 * 0.16 / 1000);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		paintingAntic = bd.doubleValue() * Price.PAINTING_ANTIC.getPriceInUAH() + (height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000;
		totalOuterDecorationPrice += paintingAntic;
		LOGGER.info("Finish calculating outer decoration, painting antic price without top transom:{}", paintingAntic);
	}

    public void calcPaintingPF(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
	    BigDecimal bd = new BigDecimal(((double)width * height) / 1000000 + (width + height) * 2 * 0.16 / 1000);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingPF = bd.doubleValue() * Price.PAINTING_PF.getPriceInUAH();
        totalOuterDecorationPrice += paintingPF;
        LOGGER.info("Finish calculating outer decoration, painting PF price:{}", paintingPF);

    }

	public void calcPaintingPFWithoutTopTransom(int width, int height, int heightTransom) {
		LOGGER.info("Start calculating outer decoration without top transom");
		clear();
		BigDecimal bd = new BigDecimal(((double)width * heightTransom) / 1000000 + (width + heightTransom) * 2 * 0.16 / 1000);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		paintingPF = bd.doubleValue() * Price.PAINTING_PF.getPriceInUAH() + (height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000;
		totalOuterDecorationPrice += paintingPF;
		LOGGER.info("Finish calculating outer decoration, painting PF price without top transom:{}", paintingPF);
	}

    public void calcAntiLayer(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for anti layer");
        if (width < 500 || width > 1200)
            throw new UnsupportedDimensions("Anti layer", height, width);
        LOGGER.info("Anti layer: dimension OK");
        if (width > 499 && width < 1201) {
            double material = 1.25 * height / 1000;
	        antiLayer = material * Price.ANTI_LAYER.getPriceInUAH() + ((width + height) * 2 *0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            totalOuterDecorationPrice += antiLayer;
        }
        LOGGER.info("Finish calculating outer decoration, anti layer price:{}", antiLayer);
    }

	public void calcAntiLayerWithoutTopTransom(int width, int height, int heightTransom) {
		LOGGER.info("Start calculating outer decoration without top transom");
		clear();
		LOGGER.info("Checking dimensions for anti layer without top transom");
		if (width < 500 || width > 1200)
			throw new UnsupportedDimensions("Anti layer without top transom", height, width);
		LOGGER.info("Anti layer: dimension OK without top transom");
		if (width > 499 && width < 1201) {
			double material = 1.25 * heightTransom / 1000;
			antiLayer = material * Price.ANTI_LAYER.getPriceInUAH() + (height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000 + ((width + height) * 2 *0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
			totalOuterDecorationPrice += antiLayer;
		}
		LOGGER.info("Finish calculating outer decoration, anti layer price without top transom:{}", antiLayer);
	}

    public void calcMdf10(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for mdf10");
        if (height < 1000 || height > 2350)
            throw new UnsupportedDimensions("MDF_10", height, width);
        LOGGER.info("MDF_10: dimension OK");
        if (height > 999 && height < 2051) {
	        BigDecimal bd = new BigDecimal((double)width * height / 1000000);
	        bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue() * Price.MDF_10.getPriceInUAH() + ((width + height) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            totalOuterDecorationPrice += mdf10;
        }
        if (height > 2050 && height < 2351) {
	        BigDecimal bd = new BigDecimal((double)width * height / 1000000);
	        bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue() * Price.MDF_10.getPriceInUAH() + 40 + ((width + height) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            totalOuterDecorationPrice += mdf10;
        }
        LOGGER.info("Finish calculating outer decoration, MDF_10 price:{}", mdf10);
    }

	public void calcMdf10WithoutTopTransom(int width, int height, int heightTransom) {
		LOGGER.info("Start calculating outer decoration without top transom");
		clear();
		LOGGER.info("Checking dimensions for mdf10 without top transom");
		if (heightTransom < 1000 || heightTransom > 2350)
			throw new UnsupportedDimensions("MDF_10 without top transom", height, width);
		LOGGER.info("MDF_10 without top transom: dimension OK");
		if (heightTransom > 999 && heightTransom < 2051) {
			BigDecimal bd = new BigDecimal((double)width * heightTransom / 1000000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			mdf10 = bd.doubleValue() * Price.MDF_10.getPriceInUAH() + (height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000 + ((width + height) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
			totalOuterDecorationPrice += mdf10;
		}
		if (heightTransom > 2050 && heightTransom < 2351) {
			BigDecimal bd = new BigDecimal((double)width * heightTransom / 1000000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			mdf10 = bd.doubleValue() * Price.MDF_10.getPriceInUAH() + 40 + (height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000 + ((width + height) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
			totalOuterDecorationPrice += mdf10;
		}
		LOGGER.info("Finish calculating outer decoration, MDF_10 price without top transom:{}", mdf10);
	}

    public void calcMdf16(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for mdf16");
        if (height < 1000 || height > 2350)
            throw new UnsupportedDimensions("MDF_16", height, width);
        LOGGER.info("MDF_16: dimension OK");
        if (height > 999 && height < 2051) {
	        BigDecimal bd = new BigDecimal((double)width * height / 1000000);
	        bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue() * Price.MDF_16.getPriceInUAH() + ((width + height) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            totalOuterDecorationPrice += mdf16;
        }
        if (height > 2050 && height < 2351) {
	        BigDecimal bd = new BigDecimal((double)width * height / 1000000);
	        bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue() * Price.MDF_16.getPriceInUAH() + 40 + ((width + height) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            totalOuterDecorationPrice += mdf16;
        }
        LOGGER.info("Finish calculating outer decoration, MDF_16 price:{}", mdf16);
    }

	public void calcMdf16WithoutTopTransom(int width, int height, int heightTransom) {
		LOGGER.info("Start calculating outer decoration without top transom");
		clear();
		LOGGER.info("Checking dimensions for mdf16 without top transom");
		if (heightTransom < 1000 || heightTransom > 2350)
			throw new UnsupportedDimensions("MDF_16 without top transom", height, width);
		LOGGER.info("MDF_16 without top transom: dimension OK");
		if (heightTransom > 999 && heightTransom < 2051) {
			BigDecimal bd = new BigDecimal((double)width * heightTransom / 1000000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			mdf16 = bd.doubleValue() * Price.MDF_16.getPriceInUAH() + (height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000 + ((width + height) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
			totalOuterDecorationPrice += mdf16;
		}
		if (heightTransom > 2050 && heightTransom < 2351) {
			BigDecimal bd = new BigDecimal((double)width * heightTransom / 1000000);
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			mdf16 = bd.doubleValue() * Price.MDF_16.getPriceInUAH() + 40 + (height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000 + ((width + height) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
			totalOuterDecorationPrice += mdf16;
		}
		LOGGER.info("Finish calculating outer decoration, MDF_16 price without top transom:{}", mdf16);
	}

    public void clear() {
        selfAdhesiveFilm = 0;
        paintingShagreen = 0;
        paintingAntic = 0;
        paintingPF = 0;
        antiLayer = 0;
        mdf10 = 0;
        mdf16 = 0;
        totalOuterDecorationPrice = 0;
    }

    public double getTotalOuterDecorationPrice() {
        return totalOuterDecorationPrice;
    }
}
