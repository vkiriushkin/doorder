package sample.com.doorder.door.fireproof;

import sample.com.doorder.door.Price;
import sample.com.doorder.door.angled.OuterDecoration;
import sample.com.doorder.door.UnsupportedDimensions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FireProofOuterDecoration extends OuterDecoration {

    @Override
    public void calcSelfAdhesiveFilm(int x, int y) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for self adhesive film");
        if (x < 500 || x > 1100)
            throw new UnsupportedDimensions("Self adhesive film", y, x);
        LOGGER.info("Self adhesive film: dimension OK");
        if (x >= 500 && x <= 890) {
	        BigDecimal bd = new BigDecimal(1.1 * (double)y / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH()
			        + (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
	        bd = bd.setScale(2, RoundingMode.HALF_UP);
	        selfAdhesiveFilm = bd.doubleValue();
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        if (x > 890 && x <= 1100) {
	        BigDecimal bd = new BigDecimal(1.1 * 1.5 * (double)y / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH()
			        + (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
	        bd = bd.setScale(2, RoundingMode.HALF_UP);
	        selfAdhesiveFilm = bd.doubleValue();
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        LOGGER.info("Finish calculating outer decoration, self adhesive film price:{}", selfAdhesiveFilm);
    }

    @Override
    public void calcPaintingShagreen(int x, int y) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)x * y) / 1000000 + (x + y) * 2 * 0.2 / 1000);
        bd = bd.multiply(new BigDecimal(Price.PAINTING_SHAGREEN.getPriceInUAH())).setScale(2, RoundingMode.HALF_UP);
        paintingShagreen = bd.doubleValue();
        totalOuterDecorationPrice += paintingShagreen;
        LOGGER.info("Finish calculating outer decoration, painting shagreen price:{}", paintingShagreen);

    }

    @Override
    public void calcPaintingAntic(int x, int y) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)x * y) / 1000000 + (x + y) * 2 * 0.2 / 1000);
        bd = bd.multiply(new BigDecimal(Price.PAINTING_ANTIC.getPriceInUAH())).setScale(2, RoundingMode.HALF_UP);
        paintingAntic = bd.doubleValue();
        totalOuterDecorationPrice += paintingAntic;
        LOGGER.info("Finish calculating outer decoration, painting antic price:{}", paintingAntic);

    }

    @Override
    public void calcPaintingPF(int x, int y) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)x * y) / 1000000 + (x + y) * 2 * 0.2 / 1000);
        bd = bd.multiply(new BigDecimal(Price.PAINTING_PF.getPriceInUAH())).setScale(2, RoundingMode.HALF_UP);
        paintingPF = bd.doubleValue();
        totalOuterDecorationPrice += paintingPF;
        LOGGER.info("Finish calculating outer decoration, painting PF price:{}", paintingPF);

    }

    @Override
    public void calcAntiLayer(int x, int y) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for anti layer");
        if (x < 500 || x > 1100)
            throw new UnsupportedDimensions("Anti layer", y, x);
        LOGGER.info("Anti layer: dimension OK");
        if (x >= 500 && x <= 1100) {
	        BigDecimal bd = new BigDecimal(1.25 * (double)y / 1000 * Price.ANTI_LAYER.getPriceInUAH()
			        +  + (((double)x + y) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000));
	        bd = bd.setScale(2, RoundingMode.HALF_UP);
	        antiLayer = bd.doubleValue();
            totalOuterDecorationPrice += antiLayer;
        }
        LOGGER.info("Finish calculating outer decoration, anti layer price:{}", antiLayer);
    }

    @Override
    public void calcMdf10(int x, int y) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for mdf10");
        if (y < 1000 || y > 2350)
            throw new UnsupportedDimensions("MDF_10", y, x);
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

    @Override
    public void calcMdf16(int x, int y) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for mdf16");
        if (y < 1000 || y > 2350)
            throw new UnsupportedDimensions("MDF_16", y, x);
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
}
