package sample.com.doorder.door.simple;

import sample.com.doorder.door.Price;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleFireProofInnerDecoration extends FireProofInnerDecoration{

    @Override
    public void calcMdf10(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for mdf10");
        if (y - 40 < 1000 || y - 40 > 2350)
            throw new UnsupportedDimensions("MDF_10", y, x);
        LOGGER.info("MDF_10: dimension OK");
        if ((y - 40) >=1000 && (y - 40) <= 2050) {
	        BigDecimal bd = new BigDecimal((((double) (x - 40) * (y - 40)) / 1000000) * Price.MDF_10.getPriceInUAH());
	        bd = bd.setScale(2, RoundingMode.HALF_UP);
	        mdf10 = bd.doubleValue();
            totalInnerDecorationPrice += mdf10;
        }
        if ((y - 40) > 2050 && (y - 40) <= 2350) {
	        BigDecimal bd = new BigDecimal((((double) (x - 40) * (y - 40)) / 1000000) * Price.MDF_10.getPriceInUAH() + 80);
	        bd = bd.setScale(2, RoundingMode.HALF_UP);
	        mdf10 = bd.doubleValue();
            totalInnerDecorationPrice += mdf10;
        }
        LOGGER.info("Finish calculating inner decoration, MDF_10 price:{}", mdf10);
    }

    @Override
    public void calcMdf16(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for mdf16");
        if (y - 40 < 1000 || y - 40 > 2350)
            throw new UnsupportedDimensions("MDF_10", y, x);
        LOGGER.info("MDF_16: dimension OK");
        if ((y - 40) >=1000 && (y - 40) <= 2050) {
	        BigDecimal bd = new BigDecimal((((double) (x - 40) * (y - 40)) / 1000000) * Price.MDF_16.getPriceInUAH());
	        bd = bd.setScale(2, RoundingMode.HALF_UP);
	        mdf16 = bd.doubleValue();
            totalInnerDecorationPrice += mdf16;
        }
        if ((y - 40) > 2050 && (y - 40) <= 2350) {
	        BigDecimal bd = new BigDecimal((((double) (x - 40) * (y - 40)) / 1000000) * Price.MDF_16.getPriceInUAH() + 80);
	        bd = bd.setScale(2, RoundingMode.HALF_UP);
	        mdf16 = bd.doubleValue();
            totalInnerDecorationPrice += mdf16;
        }
        LOGGER.info("Finish calculating inner decoration, MDF_16 price:{}", mdf16);
    }

    @Override
    public void calcPaintingPF(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)x - 40) * (y - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingPF = bd.doubleValue();
        totalInnerDecorationPrice += paintingPF;
        LOGGER.info("Finish calculating inner decoration, painting pf price:{}", paintingPF);
    }

    @Override
    public void calcPaintingShagreen(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)x - 40) * (y - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingShagreen = bd.doubleValue();
        totalInnerDecorationPrice += paintingShagreen;
        LOGGER.info("Finish calculating inner decoration, painting shagreen price:{}", paintingShagreen);
    }

    @Override
    public void calcPaintingAntic(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)x - 40) * (y - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingAntic = bd.doubleValue();
        totalInnerDecorationPrice += paintingAntic;
        LOGGER.info("Finish calculating inner decoration, painting antic price:{}", paintingAntic);
    }
}
