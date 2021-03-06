package sample.com.doorder.door.armour4040;

import sample.com.doorder.door.Price;
import sample.com.doorder.door.UnsupportedDimensions;
import sample.com.doorder.door.angled.InnerDecoration;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Armour4040DoubleDoorInnerDecoration extends InnerDecoration {

    @Override
    public void calcPlastic(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal((2 * (double)x + 4 * y) * 1.1 * Price.START.getPriceInUAH() / 1000 + ((double)x * y) * 1.1 * Price.PLASTIC.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        plastic = bd.doubleValue();
        totalInnerDecorationPrice += plastic;
        LOGGER.info("Finish calculating inner decoration, plastic price:{}", plastic);
    }

    @Override
    public void calcLaminate(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal((2 * (double)x + 4 * y) * 1.1 * Price.START.getPriceInUAH() / 1000 + ((double)x * y) * 1.1 * Price.LAMINATED_PLASTIC.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        laminate = bd.doubleValue();
        totalInnerDecorationPrice += laminate;
        LOGGER.info("Finish calculating inner decoration, laminated plastic price:{}", laminate);
    }

    @Override
    public void calcMdf10(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for mdf10");
        if (y - 40 < 1000 || y - 40 > 2350)
            throw new UnsupportedDimensions("Выберите другой вид внутренней отделки (максимальная высота для МДФ 2350мм)");
        LOGGER.info("MDF_10: dimension OK");
        if ((y - 40)>= 1000 && (y - 40) <= 2050) {
            BigDecimal bd = new BigDecimal(((double)x - 40) * (y - 40) / 1000000 * Price.MDF_10.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue();
            totalInnerDecorationPrice += mdf10;
        }
        if ((y - 40) > 2050 && (y - 40) < 2351) {
            BigDecimal bd = new BigDecimal(((double)x - 40) * (y - 40) / 1000000 * Price.MDF_10.getPriceInUAH() + 80);
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
            throw new UnsupportedDimensions("Выберите другой вид внутренней отделки (максимальная высота для МДФ 2350мм)");
        LOGGER.info("MDF_16: dimension OK");
        if ((y - 40)>= 1000 && (y - 40) <= 2050) {
            BigDecimal bd = new BigDecimal(((double)x - 40) * (y - 40) / 1000000 * Price.MDF_16.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue();
            totalInnerDecorationPrice += mdf16;
        }
        if ((y - 40) > 2050 && (y - 40) < 2351) {
            BigDecimal bd = new BigDecimal(((double)x - 40) * (y - 40) / 1000000 * Price.MDF_16.getPriceInUAH() + 80);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue();
            totalInnerDecorationPrice += mdf16;
        }
        LOGGER.info("Finish calculating inner decoration, MDF_16 price:{}", mdf16);
    }

    @Override
    public void calcWithoutDecoration(int x, int y) {
        super.calcWithoutDecoration(x, y);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void calcPaintingPF(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting PF");
        if (x - 80 < 800 || x - 80 > 2000 || y - 80 < 1000 || y - 80 > 2550)
            throw new UnsupportedDimensions("Painting PF", y, x);
        LOGGER.info("Painting PF: dimension OK");
        if ((x - 80) >= 800 && (x - 80) <= 1000 && (y - 80) >= 1000 && (y - 80) <= 2060) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + ((double)x - 80) * (y - 80) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 80) >= 800 && (x - 80) <= 1000 && (y - 80) >= 2061 && (y - 80) <= 2550) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 80) * (y - 80) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 80) >= 1001 && (x - 80) <= 1200 && (y - 80) >= 1000 && (y - 80) <= 2060) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 80) * (y - 80) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 80) >= 1001 && (x - 80) <= 1200 && (y - 80) >= 2061 && (y - 80) <= 2550) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 80) * (y - 80) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 80) >= 1201 && (x - 80) <= 2000 && (y - 80) >= 1000 && (y - 80) <= 2060) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() * 1.5 + ((double)x - 80) * (y - 80) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 80) >= 1201 && (x - 80) <= 2000 && (y - 80) >= 2061 && (y - 80) <= 2550) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() * 1.5 + ((double)x - 80) * (y - 80) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        LOGGER.info("Finish calculating inner decoration, painting PF price:{}", paintingPF);
    }

    @Override
    public void calcPaintingShagreen(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting shagreen");
        if (x - 80 < 800 || x - 80 > 2000 || y - 80 < 1000 || y - 80 > 2550)
            throw new UnsupportedDimensions("Painting PF", y, x);
        LOGGER.info("Painting shagreen: dimension OK");
        if ((x - 80) >= 800 && (x - 80) <= 1000 && (y - 80) >= 1000 && (y - 80) <= 2060) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + ((double)x - 80) * (y - 80) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 80) >= 800 && (x - 80) <= 1000 && (y - 80) >= 2061 && (y - 80) <= 2550) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 80) * (y - 80) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 80) >= 1001 && (x - 80) <= 1200 && (y - 80) >= 1000 && (y - 80) <= 2060) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 80) * (y - 80) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 80) >= 1001 && (x - 80) <= 1200 && (y - 80) >= 2061 && (y - 80) <= 2550) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 80) * (y - 80) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 80) >= 1201 && (x - 80) <= 2000 && (y - 80) >= 1000 && (y - 80) <= 2060) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() * 1.5 + ((double)x - 80) * (y - 80) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 80) >= 1201 && (x - 80) <= 2000 && (y - 80) >= 2061 && (y - 80) <= 2550) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() * 1.5 + ((double)x - 80) * (y - 80) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        LOGGER.info("Finish calculating inner decoration, painting shagreen price:{}", paintingShagreen);
    }

    @Override
    public void calcPaintingAntic(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting antic");
        if (x - 80 < 800 || x - 80 > 2000 || y - 80 < 1000 || y - 80 > 2550)
            throw new UnsupportedDimensions("Painting PF", y, x);
        LOGGER.info("Painting antic: dimension OK");
        if ((x - 80) >= 800 && (x - 80) <= 1000 && (y - 80) >= 1000 && (y - 80) <= 2060) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + ((double)x - 80) * (y - 80) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 80) >= 800 && (x - 80) <= 1000 && (y - 80) >= 2061 && (y - 80) <= 2550) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 80) * (y - 80) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 80) >= 1001 && (x - 80) <= 1200 && (y - 80) >= 1000 && (y - 80) <= 2060) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 80) * (y - 80) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 80) >= 1001 && (x - 80) <= 1200 && (y - 80) >= 2061 && (y - 80) <= 2550) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)x - 80) * (y - 80) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 80) >= 1201 && (x - 80) <= 2000 && (y - 80) >= 1000 && (y - 80) <= 2060) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() * 1.5 + ((double)x - 80) * (y - 80) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 80) >= 1201 && (x - 80) <= 2000 && (y - 80) >= 2061 && (y - 80) <= 2550) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() * 1.5 + ((double)x - 80) * (y - 80) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        LOGGER.info("Finish calculating inner decoration, painting antic price:{}", paintingAntic);
    }
}
