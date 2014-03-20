package sample.com.doorder.door.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.com.doorder.door.Price;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InnerDecoration {

    public static final Logger LOGGER = LoggerFactory.getLogger(InnerDecoration.class);

    protected double plastic;
    protected double laminate;
    protected double mdf10;
    protected double mdf16;
    private double withoutDecoration;
    protected double paintingPF;
    protected double paintingShagreen;
    protected double paintingAntic;
    protected double totalInnerDecorationPrice;

    public InnerDecoration() {
    }

    public void calcPlastic(int x, int y) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    BigDecimal bd = new BigDecimal(((double)x + y) * 2.2 * Price.START.getPriceInUAH() / 1000 + ((double)x * y) * 1.1 * Price.PLASTIC.getPriceInUAH() / 1000000);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    plastic = bd.doubleValue();
	    totalInnerDecorationPrice += plastic;
	    LOGGER.info("Finish calculating inner decoration, plastic price:{}", plastic);
    }

    public void calcLaminate(int x, int y) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    BigDecimal bd = new BigDecimal(((double)x + y) * 2.2 * Price.START.getPriceInUAH() / 1000 + ((double)x * y) * 1.1 * Price.LAMINATED_PLASTIC.getPriceInUAH() / 1000000);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    laminate = bd.doubleValue();
	    totalInnerDecorationPrice += laminate;
	    LOGGER.info("Finish calculating inner decoration, laminated plastic price:{}", laminate);
    }

    public void calcMdf10(int x, int y) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    LOGGER.info("Checking dimensions for mdf10");
	    if (y - 40 < 1000 || y - 40 > 2350)
		    throw new UnsupportedDimensions("MDF_10", y, x);
	    LOGGER.info("MDF_10: dimension OK");
	    if ((y - 40)>= 1000 && (y - 40) <= 2050) {
		    BigDecimal bd = new BigDecimal(((double)x - 40) * (y - 40) / 1000000 * Price.MDF_10.getPriceInUAH());
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    mdf10 = bd.doubleValue();
		    totalInnerDecorationPrice += mdf10;
	    }
	    if ((y - 40) > 2050 && (y - 40) < 2351) {
		    BigDecimal bd = new BigDecimal(((double)x - 40) * (y - 40) / 1000000 * Price.MDF_10.getPriceInUAH() + 40);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    mdf10 = bd.doubleValue();
		    totalInnerDecorationPrice += mdf10;
	    }
	    LOGGER.info("Finish calculating inner decoration, MDF_10 price:{}", mdf10);
    }

    public void calcMdf16(int x, int y) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    LOGGER.info("Checking dimensions for mdf16");
	    if (y - 40 < 1000 || y - 40 > 2350)
		    throw new UnsupportedDimensions("MDF_10", y, x);
	    LOGGER.info("MDF_16: dimension OK");
	    if ((y - 40)>= 1000 && (y - 40) <= 2050) {
		    BigDecimal bd = new BigDecimal(((double)x - 40) * (y - 40) / 1000000 * Price.MDF_16.getPriceInUAH());
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    mdf16 = bd.doubleValue();
		    totalInnerDecorationPrice += mdf16;
	    }
	    if ((y - 40) > 2050 && (y - 40) < 2351) {
		    BigDecimal bd = new BigDecimal(((double)x - 40) * (y - 40) / 1000000 * Price.MDF_16.getPriceInUAH() + 40);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    mdf16 = bd.doubleValue();
		    totalInnerDecorationPrice += mdf16;
	    }
	    LOGGER.info("Finish calculating inner decoration, MDF_16 price:{}", mdf16);
    }

    public void calcWithoutDecoration(int x, int y) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    BigDecimal bd = new BigDecimal(((double)x * y) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    withoutDecoration = bd.doubleValue();
	    totalInnerDecorationPrice += withoutDecoration;
	    LOGGER.info("Finish calculating inner decoration, without decoration price:{}", withoutDecoration);
    }

    public void calcPaintingPF(int x, int y) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    LOGGER.info("Checking dimensions for painting PF");
	    if (x - 40 < 500 || x - 40 > 1200 || y - 40 < 1000 || y - 40 > 2450)
		    throw new UnsupportedDimensions("Painting PF", y, x);
	    LOGGER.info("Painting PF: dimension OK");
	    if ((x - 40) > 499 && (x - 40) < 961 && (y - 40)>= 1000 && (y - 40) < 2031) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + ((double)x - 40) * (y - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingPF = bd.doubleValue();
		    totalInnerDecorationPrice += paintingPF;
	    }
	    if ((x - 40) > 499 && (x - 40) < 961 && (y - 40) > 2030 && (y - 40) < 2451) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 40) * (y - 40) * Price.PAINTING_PF
				    .getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingPF = bd.doubleValue();
		    totalInnerDecorationPrice += paintingPF;
	    }
	    if ((x - 40) > 960 && (x - 40) < 1201 && (y - 40)>= 1000 && (y - 40) < 2031) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 40) * (y - 40) * Price.PAINTING_PF
				    .getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingPF = bd.doubleValue();
		    totalInnerDecorationPrice += paintingPF;
	    }
	    if ((x - 40) > 960 && (x - 40) < 1201 && (y - 40) > 2030 && (y - 40) < 2451) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 40) * (y - 40) * Price.PAINTING_PF
				    .getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingPF = bd.doubleValue();
		    totalInnerDecorationPrice += paintingPF;
	    }
	    LOGGER.info("Finish calculating inner decoration, painting PF price:{}", paintingPF);
    }

    public void calcPaintingShagreen(int x, int y) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    LOGGER.info("Checking dimensions for painting shagreen");
	    if (x - 40 < 500 || x - 40 > 1200 || y - 40 < 1000 || y - 40 > 2450)
		    throw new UnsupportedDimensions("Painting PF", y, x);
	    LOGGER.info("Painting shagreen: dimension OK");
	    if ((x - 40) > 499 && (x - 40) < 961 && (y - 40)>= 1000 && (y - 40) < 2031) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + ((double)x - 40) * (y - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingShagreen = bd.doubleValue();
		    totalInnerDecorationPrice += paintingShagreen;
	    }
	    if ((x - 40) > 499 && (x - 40) < 961 && (y - 40) > 2030 && (y - 40) < 2451) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 40) * (y - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingShagreen = bd.doubleValue();
		    totalInnerDecorationPrice += paintingShagreen;
	    }
	    if ((x - 40) > 960 && (x - 40) < 1201 && (y - 40)>= 1000 && (y - 40) < 2031) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 40) * (y - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingShagreen = bd.doubleValue();
		    totalInnerDecorationPrice += paintingShagreen;
	    }
	    if ((x - 40) > 960 && (x - 40) < 1201 && (y - 40) > 2030 && (y - 40) < 2451) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 40) * (y - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingShagreen = bd.doubleValue();
		    totalInnerDecorationPrice += paintingShagreen;
	    }
	    LOGGER.info("Finish calculating inner decoration, painting shagreen price:{}", paintingShagreen);
    }

    public void calcPaintingAntic(int x, int y) {
	    LOGGER.info("Start calculating inner decoration");
	    clear();
	    LOGGER.info("Checking dimensions for painting antic");
	    if (x - 40 < 500 || x - 40 > 1200 || y - 40 < 1000 || y - 40 > 2450)
		    throw new UnsupportedDimensions("Painting PF", y, x);
	    LOGGER.info("Painting antic: dimension OK");
	    if ((x - 40) > 499 && (x - 40) < 961 && (y - 40)>= 1000 && (y - 40) < 2031) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + ((double)x - 40) * (y - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingAntic = bd.doubleValue();
		    totalInnerDecorationPrice += paintingAntic;
	    }
	    if ((x - 40) > 499 && (x - 40) < 961 && (y - 40) > 2030 && (y - 40) < 2451) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 40) * (y - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingAntic = bd.doubleValue();
		    totalInnerDecorationPrice += paintingAntic;
	    }
	    if ((x - 40) > 960 && (x - 40) < 1201 && (y - 40)>= 1000 && (y - 40) < 2031) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 40) * (y - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingAntic = bd.doubleValue();
		    totalInnerDecorationPrice += paintingAntic;
	    }
	    if ((x - 40) > 960 && (x - 40) < 1201 && (y - 40) > 2030 && (y - 40) < 2451) {
		    BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 40) * (y - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    paintingAntic = bd.doubleValue();
		    totalInnerDecorationPrice += paintingAntic;
	    }
	    LOGGER.info("Finish calculating inner decoration, painting antic price:{}", paintingAntic);
    }

    public void clear() {
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
