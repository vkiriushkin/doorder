package sample.com.doorder.door.angled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.com.doorder.door.Price;
import sample.com.doorder.door.UnsupportedDimensions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OuterDecoration {

	public static final Logger LOGGER = LoggerFactory.getLogger(OuterDecoration.class);

	protected double selfAdhesiveFilm;
	protected double paintingShagreen;
	protected double paintingAntic;
	protected double paintingPF;
	protected double antiLayer;
	protected double mdf10;
	protected double mdf16;
	protected double totalOuterDecorationPrice;

	public OuterDecoration() {
	}

	public void calcSelfAdhesiveFilm(int x, int y) {
		LOGGER.info("Start calculating outer decoration");
		clear();
		LOGGER.info("Checking dimensions for self adhesive film");
		if (x < 500 || x > 1200)
			throw new UnsupportedDimensions("Self adhesive film", y, x);
		LOGGER.info("Self adhesive film: dimension OK");
		if (x >= 500 && x <= 800) {
			BigDecimal bd = new BigDecimal(1.1 * (double) y / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH()
                    + (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			selfAdhesiveFilm = bd.doubleValue();
			totalOuterDecorationPrice += selfAdhesiveFilm;
		}
		if (x > 800 && x <= 1200) {
			BigDecimal bd = new BigDecimal(1.1 * 1.5 * (double) y / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH()
					+ (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			selfAdhesiveFilm = bd.doubleValue();
			totalOuterDecorationPrice += selfAdhesiveFilm;
		}
		LOGGER.info("Finish calculating outer decoration, self adhesive film price:{}", selfAdhesiveFilm);
	}

	public void calcSelfAdhesiveFilmWithoutTopTransom(int x, int y, int y_1) {
		LOGGER.info("Start calculating outer decoration without top transom");
		clear();
		LOGGER.info("Checking dimensions for self adhesive film without top transom");
		if (x < 500 || x > 1200)
			throw new UnsupportedDimensions("Self adhesive film, without top transom", y, x);
		LOGGER.info("Self adhesive film, without top transom: dimension OK");
		if (x >= 500 && x <= 800) {
			BigDecimal bd = new BigDecimal(1.1 * (double) y_1 / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH()
					+ ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000
					+ (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			selfAdhesiveFilm = bd.doubleValue();
			totalOuterDecorationPrice += selfAdhesiveFilm;
		}
		if (x > 800 && x <= 1200) {
			BigDecimal bd = new BigDecimal(1.1 * 1.5 * (double) y_1 / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH()
					+ ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000
					+ (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			selfAdhesiveFilm = bd.doubleValue();
			totalOuterDecorationPrice += selfAdhesiveFilm;
		}
		LOGGER.info("Finish calculating outer decoration, self adhesive film price without top transom:{}", selfAdhesiveFilm);
	}

	public void calcPaintingShagreen(int x, int y) {
		LOGGER.info("Start calculating outer decoration");
		clear();
		BigDecimal bd = new BigDecimal((((double) x * y) / 1000000
				+ ((double)x + y) * 2 * 0.16 / 1000) * Price.PAINTING_SHAGREEN.getPriceInUAH());
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		paintingShagreen = bd.doubleValue();
		totalOuterDecorationPrice += paintingShagreen;
		LOGGER.info("Finish calculating outer decoration, painting shagreen price:{}", paintingShagreen);
	}

	public void calcPaintingShagreenWithoutTopTransom(int x, int y, int y_1) {
		LOGGER.info("Start calculating outer decoration without top transom");
		clear();
		BigDecimal bd = new BigDecimal((((double) x * y_1) / 1000000
				+ ((double)x + y_1) * 2 * 0.16 / 1000) * Price.PAINTING_SHAGREEN.getPriceInUAH()
				+ ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		paintingShagreen = bd.doubleValue();
		totalOuterDecorationPrice += paintingShagreen;
		LOGGER.info("Finish calculating outer decoration, painting shagreen price without top transom:{}", paintingShagreen);
	}

	public void calcPaintingAntic(int x, int y) {
		LOGGER.info("Start calculating outer decoration");
		clear();
		BigDecimal bd = new BigDecimal((((double) x * y) / 1000000 + ((double)x + y) * 2 * 0.16 / 1000) * Price.PAINTING_ANTIC.getPriceInUAH());
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		paintingAntic = bd.doubleValue();
		totalOuterDecorationPrice += paintingAntic;
		LOGGER.info("Finish calculating outer decoration, painting antic price:{}", paintingAntic);
	}

	public void calcPaintingAnticWithoutTopTransom(int x, int y, int y_1) {
		LOGGER.info("Start calculating outer decoration without top transom");
		clear();
		BigDecimal bd = new BigDecimal((((double) x * y_1) / 1000000
				+ ((double)x + y_1) * 2 * 0.16 / 1000) * Price.PAINTING_ANTIC.getPriceInUAH()
				+ ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		paintingAntic = bd.doubleValue();
		totalOuterDecorationPrice += paintingAntic;
		LOGGER.info("Finish calculating outer decoration, painting antic price without top transom:{}", paintingAntic);
	}

	public void calcPaintingPF(int x, int y) {
		LOGGER.info("Start calculating outer decoration");
		clear();
		BigDecimal bd = new BigDecimal((((double) x * y) / 1000000
				+ ((double)x + y) * 2 * 0.16 / 1000) * Price.PAINTING_PF.getPriceInUAH());
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		paintingPF = bd.doubleValue();
		totalOuterDecorationPrice += paintingPF;
		LOGGER.info("Finish calculating outer decoration, painting PF price:{}", paintingPF);

	}

	public void calcPaintingPFWithoutTopTransom(int x, int y, int y_1) {
		LOGGER.info("Start calculating outer decoration without top transom");
		clear();
		BigDecimal bd = new BigDecimal((((double) x * y_1) / 1000000
				+ ((double)x + y_1) * 2 * 0.16 / 1000) * Price.PAINTING_PF.getPriceInUAH()
				+ ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		paintingPF = bd.doubleValue();
		totalOuterDecorationPrice += paintingPF;
		LOGGER.info("Finish calculating outer decoration, painting PF price without top transom:{}", paintingPF);
	}

	public void calcAntiLayer(int x, int y) {
		LOGGER.info("Start calculating outer decoration");
		clear();
		LOGGER.info("Checking dimensions for anti layer");
		if (x < 500 || x > 1200)
			throw new UnsupportedDimensions("Anti layer", y, x);
		LOGGER.info("Anti layer: dimension OK");
		if (x >= 500 && x <= 1200) {
			BigDecimal bd = new BigDecimal((1.25 * (double) y / 1000) * Price.ANTI_LAYER.getPriceInUAH()
					+ (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			antiLayer = bd.doubleValue();
			totalOuterDecorationPrice += antiLayer;
		}
		LOGGER.info("Finish calculating outer decoration, anti layer price:{}", antiLayer);
	}

	public void calcAntiLayerWithoutTopTransom(int x, int y, int y_1) {
		LOGGER.info("Start calculating outer decoration without top transom");
		clear();
		LOGGER.info("Checking dimensions for anti layer without top transom");
		if (x < 500 || x > 1200)
			throw new UnsupportedDimensions("Anti layer without top transom", y, x);
		LOGGER.info("Anti layer: dimension OK without top transom");
		if (x >= 500 && x <= 1200) {
			BigDecimal bd = new BigDecimal((1.25 * (double) y_1 / 1000) * Price.ANTI_LAYER.getPriceInUAH()
					+ ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000
					+ (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			antiLayer = bd.doubleValue();
			totalOuterDecorationPrice += antiLayer;
		}
		LOGGER.info("Finish calculating outer decoration, anti layer price without top transom:{}", antiLayer);
	}

	public void calcMdf10(int x, int y) {
		LOGGER.info("Start calculating outer decoration");
		clear();
		LOGGER.info("Checking dimensions for mdf10");
		if (y < 1000 || y > 2350)
			throw new UnsupportedDimensions("Выберите другой вид наружной отделки (максимальная высота для МДФ 2350мм)");
		LOGGER.info("MDF_10: dimension OK");
		if (y >= 1000 && y <= 2050) {
			BigDecimal bd = new BigDecimal((double) x * y / 1000000 * Price.MDF_10.getPriceInUAH()
					+ (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			mdf10 = bd.doubleValue();
			totalOuterDecorationPrice += mdf10;
		}
		if (y > 2050 && y <= 2350) {
			BigDecimal bd = new BigDecimal((double) x * y / 1000000 * Price.MDF_10.getPriceInUAH() + 40
					+ (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			mdf10 = bd.doubleValue();
			totalOuterDecorationPrice += mdf10;
		}
		LOGGER.info("Finish calculating outer decoration, MDF_10 price:{}", mdf10);
	}

	public void calcMdf10WithoutTopTransom(int x, int y, int y_1) {
		LOGGER.info("Start calculating outer decoration without top transom");
		clear();
		LOGGER.info("Checking dimensions for mdf10 without top transom");
		if (y_1 < 1000 || y_1 > 2350)
			throw new UnsupportedDimensions("Выберите другой вид наружной отделки (максимальная высота для МДФ 2350мм)");
		LOGGER.info("MDF_10 without top transom: dimension OK");
		if (y_1 >= 1000 && y_1 <= 2050) {
			BigDecimal bd = new BigDecimal((double) x * y_1 / 1000000 * Price.MDF_10.getPriceInUAH()
					+ ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000
					+ (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			mdf10 = bd.doubleValue();
			totalOuterDecorationPrice += mdf10;
		}
		if (y_1 > 2050 && y_1 <= 2350) {
			BigDecimal bd = new BigDecimal((double) x * y_1 / 1000000 * Price.MDF_10.getPriceInUAH() + 40
					+ ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000
					+ (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			mdf10 = bd.doubleValue();
			totalOuterDecorationPrice += mdf10;
		}
		LOGGER.info("Finish calculating outer decoration, MDF_10 price without top transom:{}", mdf10);
	}

	public void calcMdf16(int x, int y) {
		LOGGER.info("Start calculating outer decoration");
		clear();
		LOGGER.info("Checking dimensions for mdf16");
		if (y < 1000 || y > 2350)
			throw new UnsupportedDimensions("Выберите другой вид наружной отделки (максимальная высота для МДФ 2350мм)");
		LOGGER.info("MDF_16: dimension OK");
		if (y >= 1000 && y <= 2050) {
			BigDecimal bd = new BigDecimal((double) x * y / 1000000 * Price.MDF_16.getPriceInUAH()
					+ (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			mdf16 = bd.doubleValue();
			totalOuterDecorationPrice += mdf16;
		}
		if (y > 2050 && y <= 2350) {
			BigDecimal bd = new BigDecimal((double) x * y / 1000000 * Price.MDF_16.getPriceInUAH() + 40
					+ (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			mdf16 = bd.doubleValue();
			totalOuterDecorationPrice += mdf16;
		}
		LOGGER.info("Finish calculating outer decoration, MDF_16 price:{}", mdf16);
	}

	public void calcMdf16WithoutTopTransom(int x, int y, int y_1) {
		LOGGER.info("Start calculating outer decoration without top transom");
		clear();
		LOGGER.info("Checking dimensions for mdf16 without top transom");
		if (y_1 < 1000 || y_1 > 2350)
			throw new UnsupportedDimensions("Выберите другой вид наружной отделки (максимальная высота для МДФ 2350мм)");
		LOGGER.info("MDF_16 without top transom: dimension OK");
		if (y_1 >= 1000 && y_1 <= 2050) {
			BigDecimal bd = new BigDecimal((double) x * y_1 / 1000000 * Price.MDF_16.getPriceInUAH()
					+ ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000
					+ (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			mdf16 = bd.doubleValue();
			totalOuterDecorationPrice += mdf16;
		}
		if (y_1 > 2050 && y_1 <= 2350) {
			BigDecimal bd = new BigDecimal((double) x * y_1 / 1000000 * Price.MDF_16.getPriceInUAH() + 40
					+ ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000
					+ (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			mdf16 = bd.doubleValue();
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
