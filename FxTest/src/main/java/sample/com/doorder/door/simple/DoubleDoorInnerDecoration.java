package sample.com.doorder.door.simple;

import sample.com.doorder.door.Price;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleDoorInnerDecoration extends InnerDecoration {

    @Override
    public void calcPlastic(int width, int height) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        plastic = (2 * width + 4 * height) * 1.1 * Price.START.getPriceInUAH() / 1000 + ((double)width * height) * 1.1 * Price.PLASTIC.getPriceInUAH() / 1000000;
        totalInnerDecorationPrice += plastic;
        LOGGER.info("Finish calculating inner decoration, plastic price:{}", plastic);
    }

    @Override
    public void calcLaminate(int width, int height) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal((2 * width + 4 * height) * 1.1 * Price.START.getPriceInUAH() / 1000 + ((double)width * height) * 1.1 * Price.LAMINATED_PLASTIC.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        laminate = bd.doubleValue();
        totalInnerDecorationPrice += laminate;
        LOGGER.info("Finish calculating inner decoration, laminated plastic price:{}", laminate);
    }

    @Override
    public void calcMdf10(int width, int height) {
        super.calcMdf10(width, height);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void calcMdf16(int width, int height) {
        super.calcMdf16(width, height);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void calcWithoutDecoration(int width, int height) {
        super.calcWithoutDecoration(width, height);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void calcPaintingPF(int width, int height) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting PF");
        if (width - 50 < 800 || width - 50 > 1950 || height - 50 < 1000 || height - 50 > 2450)
            throw new UnsupportedDimensions("Painting PF", height, width);
        LOGGER.info("Painting PF: dimension OK");
        if ((width - 50) >= 800 && (width - 50) <= 950 && (height - 50) >= 1000 && (height - 50) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + (width - 50) * (height - 50) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((width - 50) >= 800 && (width - 50) <= 950 && (height - 50) >= 2031 && (height - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)width - 50) * (height - 50) * Price.PAINTING_PF
                    .getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((width - 50) >= 951 && (width - 50) <= 1200 && (height - 50) >= 1000 && (height - 50) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)width - 50) * (height - 50) * Price.PAINTING_PF
                    .getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((width - 50) >= 951 && (width - 50) <= 1200 && (height - 50) >= 2031 && (height - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)width - 50) * (height - 50) * Price.PAINTING_PF
                    .getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((width - 50) >= 1201 && (width - 50) <= 1950 && (height - 50) >= 1000 && (height - 50) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() * 1.5 + ((double)width - 50) * (height - 50) * Price.PAINTING_PF
                    .getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((width - 50) >= 1201 && (width - 50) <= 1950 && (height - 50) >= 2031 && (height - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() * 1.5 + ((double)width - 50) * (height - 50) * Price.PAINTING_PF
                    .getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        LOGGER.info("Finish calculating inner decoration, painting PF price:{}", paintingPF);
    }

    @Override
    public void calcPaintingShagreen(int width, int height) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting shagreen");
        if (width - 50 < 800 || width - 50 > 1950 || height - 50 < 1000 || height - 50 > 2450)
            throw new UnsupportedDimensions("Painting PF", height, width);
        LOGGER.info("Painting shagreen: dimension OK");
        if ((width - 50) >= 800 && (width - 50) <= 950 && (height - 50) >= 1000 && (height - 50) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + (width - 50) * (height - 50) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((width - 50) >= 800 && (width - 50) <= 950 && (height - 50) >= 2031 && (height - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)width - 50) * (height - 50) * Price.PAINTING_SHAGREEN
                    .getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((width - 50) >= 951 && (width - 50) <= 1200 && (height - 50) >= 1000 && (height - 50) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)width - 50) * (height - 50) * Price.PAINTING_SHAGREEN
                    .getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((width - 50) >= 951 && (width - 50) <= 1200 && (height - 50) >= 2031 && (height - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)width - 50) * (height - 50) * Price.PAINTING_SHAGREEN
                    .getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((width - 50) >= 1201 && (width - 50) <= 1950 && (height - 50) >= 1000 && (height - 50) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() * 1.5 + ((double)width - 50) * (height - 50) * Price.PAINTING_SHAGREEN
                    .getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((width - 50) >= 1201 && (width - 50) <= 1950 && (height - 50) >= 2031 && (height - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() * 1.5 + ((double)width - 50) * (height - 50) * Price.PAINTING_SHAGREEN
                    .getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        LOGGER.info("Finish calculating inner decoration, painting shagreen price:{}", paintingShagreen);
    }

    @Override
    public void calcPaintingAntic(int width, int height) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting antic");
        if (width - 50 < 800 || width - 50 > 1950 || height - 50 < 1000 || height - 50 > 2450)
            throw new UnsupportedDimensions("Painting PF", height, width);
        LOGGER.info("Painting antic: dimension OK");
        if ((width - 50) >= 800 && (width - 50) <= 950 && (height - 50) >= 1000 && (height - 50) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + (width - 50) * (height - 50) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((width - 50) >= 800 && (width - 50) <= 950 && (height - 50) >= 2031 && (height - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)width - 50) * (height - 50) * Price.PAINTING_ANTIC
                    .getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((width - 50) >= 951 && (width - 50) <= 1200 && (height - 50) >= 1000 && (height - 50) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)width - 50) * (height - 50) * Price.PAINTING_ANTIC
                    .getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((width - 50) >= 951 && (width - 50) <= 1200 && (height - 50) >= 2031 && (height - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)width - 50) * (height - 50) * Price.PAINTING_ANTIC
                    .getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((width - 50) >= 1201 && (width - 50) <= 1950 && (height - 50) >= 1000 && (height - 50) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() * 1.5 + ((double)width - 50) * (height - 50) * Price.PAINTING_ANTIC
                    .getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((width - 50) >= 1201 && (width - 50) <= 1950 && (height - 50) >= 2031 && (height - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() * 1.5 + ((double)width - 50) * (height - 50) * Price.PAINTING_ANTIC
                    .getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        LOGGER.info("Finish calculating inner decoration, painting antic price:{}", paintingAntic);
    }
}
