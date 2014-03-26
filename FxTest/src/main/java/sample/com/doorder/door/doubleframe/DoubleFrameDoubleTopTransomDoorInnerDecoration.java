package sample.com.doorder.door.doubleframe;

import sample.com.doorder.door.Price;
import sample.com.doorder.door.UnsupportedDimensions;
import sample.com.doorder.door.angled.InnerDecoration;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleFrameDoubleTopTransomDoorInnerDecoration extends InnerDecoration {

    public void calcPlastic(int x, int y, int x_1, int y_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal((4 * (double)x + 4 * y_1 + 2 * y) * 1.1 * Price.START.getPriceInUAH() / 1000
                + ((double) x * y) * 1.1 * Price.PLASTIC.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        plastic = bd.doubleValue();
        totalInnerDecorationPrice += plastic;
        LOGGER.info("Finish calculating inner decoration, plastic price:{}", plastic);
    }

    public void calcPlasticWithoutTopSideTransom(int x, int y, int x_1, int y_1) {
        LOGGER.info("Start calculating inner decoration without top transom");
        clear();
        BigDecimal bd = new BigDecimal((4 * (double)y_1 + 2 * x) * 1.1 * Price.START.getPriceInUAH() / 1000
                + ((double)x * y_1) * 1.1 * Price.PLASTIC.getPriceInUAH() / 1000000
                + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        plastic = bd.doubleValue();
        totalInnerDecorationPrice += plastic;
        LOGGER.info("Finish calculating inner decoration, plastic price without top transom:{}", plastic);
    }

    public void calcLaminate(int x, int y, int x_1, int y_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal((4 * (double)x + 4 * y_1 + 2 * y) * 1.1 * Price.START.getPriceInUAH() / 1000
                + ((double) x * y) * 1.1 * Price.LAMINATED_PLASTIC.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        laminate = bd.doubleValue();
        totalInnerDecorationPrice += laminate;
        LOGGER.info("Finish calculating inner decoration, laminated plastic price:{}", laminate);
    }

    public void calcLaminateWithoutTopSideTransom(int x, int y, int x_1, int y_1) {
        LOGGER.info("Start calculating inner decoratio nwithout top transom");
        clear();
        BigDecimal bd = new BigDecimal((4 * (double)y_1 + 2 * x) * 1.1 * Price.START.getPriceInUAH() / 1000
                + ((double)x * y_1) * 1.1 * Price.LAMINATED_PLASTIC.getPriceInUAH() / 1000000
                + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        laminate = bd.doubleValue();
        totalInnerDecorationPrice += laminate;
        LOGGER.info("Finish calculating inner decoration, laminated plastic price without top transom:{}", laminate);;
    }

    public void calcPaintingPF(int x, int y, int x_1, int y_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting PF");
        if (x - 50 < 800 || x - 50 > 1950 || y_1 - 50 < 1000 || y_1 - 50 > 2450)
            throw new UnsupportedDimensions("Painting PF", y, x);
        LOGGER.info("Painting PF: dimension OK");
        if ((x - 50) >= 800 && (x - 50) <= 950 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 50) >= 800 && (x - 50) <= 950 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 50) > 951 && (x - 50) <= 1200 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 50) > 951 && (x - 50) <= 1200 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 50) > 1200 && (x - 50) <= 1950 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(1.5 * Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 50) > 1200 && (x - 50) <= 1950 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(1.5 * Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        LOGGER.info("Finish calculating inner decoration, painting PF price:{}", paintingPF);
    }

    public void calcPaintingPFWithoutTopSideTransom(int x, int y, int x_1, int y_1) {
        LOGGER.info("Start calculating inner decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for painting PF without top transom");
        if (x - 50 < 800 || x - 50 > 1950 || y_1 - 50 < 1000 || y_1 - 50 > 2450)
            throw new UnsupportedDimensions("Painting PF without top transom", y, x);
        LOGGER.info("Painting PF without top transom: dimension OK");
        if ((x - 50) >= 800 && (x - 50) <= 950 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 50) >= 800 && (x - 50) <= 950 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 50) > 951 && (x - 50) <= 1200 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 50) > 951 && (x - 50) <= 1200 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 50) > 1200 && (x - 50) <= 1950 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(1.5 * Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 50) > 1200 && (x - 50) <= 1950 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(1.5 * Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        LOGGER.info("Finish calculating inner decoration, painting PF price without top transom:{}", paintingPF);
    }

    public void calcPaintingShagreen(int x, int y, int x_1, int y_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting shagreen");
        if (x - 50 < 800 || x - 50 > 1950 || y_1 - 50 < 1000 || y_1 - 50 > 2450)
            throw new UnsupportedDimensions("Painting PF", y, x);
        LOGGER.info("Painting shagreen: dimension OK");
        if ((x - 50) >= 800 && (x - 50) <= 950 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 50) >= 800 && (x - 50) <= 950 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 50) > 951 && (x - 50) <= 1200 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 50) > 951 && (x - 50) <= 1200 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 50) > 1200 && (x - 50) <= 1950 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(1.5 * Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 50) > 1200 && (x - 50) <= 1950 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(1.5 * Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        LOGGER.info("Finish calculating inner decoration, painting shagreen price:{}", paintingShagreen);
    }

    public void calcPaintingShagreenWithoutTopSideTransom(int x, int y, int x_1, int y_1) {
        LOGGER.info("Start calculating inner decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for painting shagreen without top transom");
        if (x - 50 < 800 || x - 50 > 1950 || y_1 - 50 < 1000 || y_1 - 50 > 2450)
            throw new UnsupportedDimensions("Painting PF without top transom", y, x);
        LOGGER.info("Painting shagreen without top transom: dimension OK");
        if ((x - 50) >= 800 && (x - 50) <= 950 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 50) >= 800 && (x - 50) <= 950 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 50) > 951 && (x - 50) <= 1200 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 50) > 951 && (x - 50) <= 1200 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 50) > 1200 && (x - 50) <= 1950 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(1.5 * Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 50) > 1200 && (x - 50) <= 1950 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(1.5 * Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        LOGGER.info("Finish calculating inner decoration, painting shagreen price without top transom:{}", paintingShagreen);
    }

    public void calcPaintingAntic(int x, int y, int x_1, int y_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting antic");
        if (x - 50 < 800 || x - 50 > 1950 || y_1 - 50 < 1000 || y_1 - 50 > 2450)
            throw new UnsupportedDimensions("Painting PF", y, x);
        LOGGER.info("Painting antic: dimension OK");
        if ((x - 50) >= 800 && (x - 50) <= 950 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 50) >= 800 && (x - 50) <= 950 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 50) > 951 && (x - 50) <= 1200 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 50) > 951 && (x - 50) <= 1200 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 50) > 1200 && (x - 50) <= 1950 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(1.5 * Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 50) > 1200 && (x - 50) <= 1950 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(1.5 * Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y - 50) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.LIST_M2.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        LOGGER.info("Finish calculating inner decoration, painting antic price:{}", paintingAntic);
    }

    public void calcPaintingAnticWithoutTopSideTransom(int x, int y, int x_1, int y_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting antic");
        if (x - 50 < 800 || x - 50 > 1950 || y_1 - 50 < 1000 || y_1 - 50 > 2450)
            throw new UnsupportedDimensions("Painting PF", y, x);
        LOGGER.info("Painting antic: dimension OK");
        if ((x - 50) >= 800 && (x - 50) <= 950 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 50) >= 800 && (x - 50) <= 950 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 50) > 951 && (x - 50) <= 1200 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 50) > 951 && (x - 50) <= 1200 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 50) > 1200 && (x - 50) <= 1950 && (y_1 - 50) >= 1000 && (y_1 - 50) <= 2000) {
            BigDecimal bd = new BigDecimal(1.5 * Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 50) > 1200 && (x - 50) <= 1950 && (y_1 - 50) > 2000 && (y_1 - 50) <= 2450) {
            BigDecimal bd = new BigDecimal(1.5 * Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 50) * (y_1 - 50) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        LOGGER.info("Finish calculating inner decoration, painting antic price:{}", paintingAntic);
    }
}
