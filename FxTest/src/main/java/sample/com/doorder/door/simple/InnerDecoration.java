package sample.com.doorder.door.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.com.doorder.door.Price;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InnerDecoration {

    public static final Logger LOGGER = LoggerFactory.getLogger(InnerDecoration.class);

    private double plastic;
    private double laminate;
    private double mdf10;
    private double mdf16;
    private double withoutDecoration;
    private double paintingPF;
    private double paintingShagreen;
    private double paintingAntic;
    private double totalInnerDecorationPrice;

    public InnerDecoration() {
    }

    public void calcPlastic(int width, int height) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    plastic = (width + height) * 2.2 * Price.START.getPriceInUAH() / 1000 + (width * height) * 1.1 * Price.PLASTIC.getPriceInUAH() / 1000000;
	    totalInnerDecorationPrice += plastic;
	    LOGGER.info("Finish calculating inner decoration, plastic price:{}", plastic);
    }

    public void calcLaminate(int width, int height) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    BigDecimal bd = new BigDecimal((width + height) * 2.2 * Price.START.getPriceInUAH() / 1000 + (width * height) * 1.1 * Price.LAMINATED_PLASTIC.getPriceInUAH() / 1000000);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    laminate = bd.doubleValue();
	    totalInnerDecorationPrice += laminate;
	    LOGGER.info("Finish calculating inner decoration, laminated plastic price:{}", laminate);
    }

    public void calcMdf10(int width, int height) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    LOGGER.info("Checking dimensions for mdf10");
	    if (height - 40 < 1000 || height - 40 > 2350)
		    throw new UnsupportedDimensions("MDF_10", height, width);
	    LOGGER.info("MDF_10: dimension OK");
	    if ((height - 40) > 999 && (height - 40) < 2051) {
		    double material = ((double)(width - 40) * (height - 40)) / 1000000;
		    mdf10 = material * Price.MDF_10.getPriceInUAH();
		    totalInnerDecorationPrice += mdf10;
	    }
	    if ((height - 40) > 2050 && (height - 40) < 2351) {
		    double material = (double)(width - 40) * (height - 40) / 1000000;
		    mdf10 = material * Price.MDF_10.getPriceInUAH() + 40;
		    totalInnerDecorationPrice += mdf10;
	    }
	    LOGGER.info("Finish calculating inner decoration, MDF_10 price:{}", mdf10);
    }

    public void calcMdf16(int width, int height) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    LOGGER.info("Checking dimensions for mdf16");
	    if (height - 40 < 1000 || height - 40 > 2350)
		    throw new UnsupportedDimensions("MDF_10", height, width);
	    LOGGER.info("MDF_16: dimension OK");
	    if ((height - 40) > 999 && (height - 40) < 2051) {
		    double material = ((double)(width - 40) * (height - 40)) / 1000000;
		    mdf16 = material * Price.MDF_16.getPriceInUAH();
		    totalInnerDecorationPrice += mdf16;
	    }
	    if ((height - 40) > 2050 && (height - 40) < 2351) {
		    double material = (double)(width - 40) * (height - 40) / 1000000;
		    mdf16 = material * Price.MDF_16.getPriceInUAH() + 40;
		    totalInnerDecorationPrice += mdf16;
	    }
	    LOGGER.info("Finish calculating inner decoration, MDF_16 price:{}", mdf16);
    }

    public void calcWithoutDecoration(int width, int height) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    withoutDecoration = ((double)width * height) * Price.PAINTING_PF.getPriceInUAH() / 1000000;
	    totalInnerDecorationPrice += withoutDecoration;
	    LOGGER.info("Finish calculating inner decoration, without decoration price:{}", withoutDecoration);
    }

    public void calcPaintingPF(int width, int height) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    LOGGER.info("Checking dimensions for painting PF");
	    if (width - 40 < 500 || width - 40 > 1200 || height - 40 < 1000 || height - 40 > 2450)
		    throw new UnsupportedDimensions("Painting PF", height, width);
	    LOGGER.info("Painting PF: dimension OK");
	    if ((width - 40) > 499 && (width - 40) < 961 && (height - 40) > 999 && (height - 40) < 2031) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingPF = bd.doubleValue();
		    totalInnerDecorationPrice += paintingPF;
	    }
	    if ((width - 40) > 499 && (width - 40) < 961 && (height - 40) > 2030 && (height - 40) < 2451) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_PF
				    .getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingPF = bd.doubleValue();
		    totalInnerDecorationPrice += paintingPF;
	    }
	    if ((width - 40) > 960 && (width - 40) < 1201 && (height - 40) > 999 && (height - 40) < 2031) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_PF
				    .getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingPF = bd.doubleValue();
		    totalInnerDecorationPrice += paintingPF;
	    }
	    if ((width - 40) > 960 && (width - 40) < 1201 && (height - 40) > 2030 && (height - 40) < 2451) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_PF
				    .getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingPF = bd.doubleValue();
		    totalInnerDecorationPrice += paintingPF;
	    }
	    LOGGER.info("Finish calculating inner decoration, painting PF price:{}", paintingPF);
    }

    public void calcPaintingShagreen(int width, int height) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    LOGGER.info("Checking dimensions for painting shagreen");
	    if (width - 40 < 500 || width - 40 > 1200 || height - 40 < 1000 || height - 40 > 2450)
		    throw new UnsupportedDimensions("Painting PF", height, width);
	    LOGGER.info("Painting shagreen: dimension OK");
	    if ((width - 40) > 499 && (width - 40) < 961 && (height - 40) > 999 && (height - 40) < 2031) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingShagreen = bd.doubleValue();
		    totalInnerDecorationPrice += paintingShagreen;
	    }
	    if ((width - 40) > 499 && (width - 40) < 961 && (height - 40) > 2030 && (height - 40) < 2451) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingShagreen = bd.doubleValue();
		    totalInnerDecorationPrice += paintingShagreen;
	    }
	    if ((width - 40) > 960 && (width - 40) < 1201 && (height - 40) > 999 && (height - 40) < 2031) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingShagreen = bd.doubleValue();
		    totalInnerDecorationPrice += paintingShagreen;
	    }
	    if ((width - 40) > 960 && (width - 40) < 1201 && (height - 40) > 2030 && (height - 40) < 2451) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingShagreen = bd.doubleValue();
		    totalInnerDecorationPrice += paintingShagreen;
	    }
	    LOGGER.info("Finish calculating inner decoration, painting shagreen price:{}", paintingShagreen);
    }

    public void calcPaintingAntic(int width, int height) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    LOGGER.info("Checking dimensions for painting antic");
	    if (width - 40 < 500 || width - 40 > 1200 || height - 40 < 1000 || height - 40 > 2450)
		    throw new UnsupportedDimensions("Painting PF", height, width);
	    LOGGER.info("Painting antic: dimension OK");
	    if ((width - 40) > 499 && (width - 40) < 961 && (height - 40) > 999 && (height - 40) < 2031) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingAntic = bd.doubleValue();
		    totalInnerDecorationPrice += paintingAntic;
	    }
	    if ((width - 40) > 499 && (width - 40) < 961 && (height - 40) > 2030 && (height - 40) < 2451) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingAntic = bd.doubleValue();
		    totalInnerDecorationPrice += paintingAntic;
	    }
	    if ((width - 40) > 960 && (width - 40) < 1201 && (height - 40) > 999 && (height - 40) < 2031) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingAntic = bd.doubleValue();
		    totalInnerDecorationPrice += paintingAntic;
	    }
	    if ((width - 40) > 960 && (width - 40) < 1201 && (height - 40) > 2030 && (height - 40) < 2451) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingAntic = bd.doubleValue();
		    totalInnerDecorationPrice += paintingAntic;
	    }
	    LOGGER.info("Finish calculating inner decoration, painting antic price:{}", paintingAntic);
    }

    private void clear() {
        plastic = 0;
        laminate = 0;
        mdf10 = 0;
        mdf16 = 0;
        withoutDecoration = 0;
        paintingPF = 0;
        paintingShagreen = 0;
        paintingAntic = 0;
        totalInnerDecorationPrice = 0;
    }

    public double getTotalInnerDecorationPrice() {
        return totalInnerDecorationPrice;
    }
}
