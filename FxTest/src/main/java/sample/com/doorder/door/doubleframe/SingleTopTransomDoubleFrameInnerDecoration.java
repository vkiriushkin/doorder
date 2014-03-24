package sample.com.doorder.door.doubleframe;


import sample.com.doorder.door.Price;
import sample.com.doorder.door.UnsupportedDimensions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SingleTopTransomDoubleFrameInnerDecoration extends AngledDoubleFrameInnerDecoration {

    public void calcPlastic(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)x * 4 + 2 * y) * 1.1 * Price.START.getPriceInUAH() / 1000
                + ((double)x * y) * 1.1 * Price.PLASTIC.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        plastic = bd.doubleValue();
        totalInnerDecorationPrice += plastic;
        LOGGER.info("Finish calculating inner decoration, plastic price:{}", plastic);
    }

    public void calcPlasticWithoutTopTransom(int x, int y, int y_1) {
        LOGGER.info("Start calculating inner decoration without top transom");
        clear();
        BigDecimal bd = new BigDecimal(((double)x + y_1) * 2.2 * Price.START.getPriceInUAH() / 1000
                + ((double)x * y_1) * 1.1 * Price.PLASTIC.getPriceInUAH() / 1000000
                + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        plastic = bd.doubleValue();
        totalInnerDecorationPrice += plastic;
        LOGGER.info("Finish calculating inner decoration, plastic price without top transom:{}", plastic);
    }

    public void calcLaminate(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)x * 4 + 2 * y) * 1.1 * Price.START.getPriceInUAH() / 1000
                + ((double)x * y) * 1.1 * Price.LAMINATED_PLASTIC.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        laminate = bd.doubleValue();
        totalInnerDecorationPrice += laminate;
        LOGGER.info("Finish calculating inner decoration, laminated plastic price:{}", laminate);
    }

    public void calcLaminateWithoutTopTransom(int x, int y, int y_1) {
        LOGGER.info("Start calculating inner decoration without top transom");
        clear();
        BigDecimal bd = new BigDecimal(((double)x + y_1) * 2.2 * Price.START.getPriceInUAH() / 1000
                + ((double)x * y_1) * 1.1 * Price.LAMINATED_PLASTIC.getPriceInUAH() / 1000000
                + ((double)y - y_1) * x * Price.PAINTING_PF.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        laminate = bd.doubleValue();
        totalInnerDecorationPrice += laminate;
        LOGGER.info("Finish calculating inner decoration, laminated plastic price without top transom:{}", laminate);
    }

    public void calcPaintingPF(int x, int y, int y_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting PF");
        if (x - 40 < 500 || x - 40 > 1200 || y_1 - 40 < 1000 || y_1 - 40 > 2450)
            throw new UnsupportedDimensions("Painting PF", y, x);
        LOGGER.info("Painting PF: dimension OK");
        if ((x - 40) >= 500 && (x - 40) <= 960 && (y_1 - 40) >=1000 && (y_1 - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - 40) * (y - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.LIST_M2.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 40) >= 500 && (x - 40) <= 960 && (y_1 - 40) > 2030 && (y_1 - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.LIST_M2.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 40) > 960 && (x - 40) <= 1200 && (y_1 - 40) >=1000 && (y_1 - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.LIST_M2.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 40) > 960 && (x - 40) <= 1200 && (y - 40) > 2030 && (y - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.LIST_M2.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        LOGGER.info("Finish calculating inner decoration, painting PF price:{}", paintingPF);
    }

    public void calcPaintingPFWithoutTopTransom(int x, int y, int y_1) {
        LOGGER.info("Start calculating inner decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for painting PF without top transom");
        if (x - 40 < 500 || x - 40 > 1200 || y_1 - 40 < 1000 || y_1 - 40 > 2450)
            throw new UnsupportedDimensions("Painting PF without top transom", y, x);
        LOGGER.info("Painting PF without top transom: dimension OK");
        if ((x - 40) >= 500 && (x - 40) <= 960 && (y_1 - 40) >=1000 && (y_1 - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 40) >= 500 && (x - 40) <= 960 && (y_1 - 40) > 2030 && (y_1 - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 40) > 960 && (x - 40) <= 1200 && (y_1 - 40) >=1000 && (y_1 - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x - 40) > 960 && (x - 40) <= 1200 && (y - 40) > 2030 && (y - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        LOGGER.info("Finish calculating inner decoration, painting PF price without top transom:{}", paintingPF);
    }

    public void calcPaintingShagreen(int x, int y, int y_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting shagreen");
        if (x - 40 < 500 || x - 40 > 1200 || y_1 - 40 < 1000 || y_1 - 40 > 2450)
            throw new UnsupportedDimensions("Painting PF", y, x);
        LOGGER.info("Painting shagreen: dimension OK");
        if ((x - 40) >= 500 && (x - 40) <= 960 && (y_1 - 40) >=1000 && (y_1 - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.LIST_M2.getPriceInUAH()
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 40) >= 500 && (x - 40) <= 960 && (y_1 - 40) > 2030 && (y_1 - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.LIST_M2.getPriceInUAH()
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 40) > 960 && (x - 40) <= 1200 && (y_1 - 40) >=1000 && (y_1 - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.LIST_M2.getPriceInUAH()
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 40) > 960 && (x - 40) <= 1200 && (y_1 - 40) > 2030 && (y_1 - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.LIST_M2.getPriceInUAH()
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        LOGGER.info("Finish calculating inner decoration, painting shagreen price:{}", paintingShagreen);
    }

    public void calcPaintingShagreenWithoutTopTransom(int x, int y, int y_1) {
        LOGGER.info("Start calculating inner decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for painting shagreen without top transom");
        if (x - 40 < 500 || x - 40 > 1200 || y_1 - 40 < 1000 || y_1 - 40 > 2450)
            throw new UnsupportedDimensions("Painting PF without top transom", y, x);
        LOGGER.info("Painting shagreen without top transom: dimension OK");
        if ((x - 40) >= 500 && (x - 40) <= 960 && (y_1 - 40) >=1000 && (y_1 - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 40) >= 500 && (x - 40) <= 960 && (y_1 - 40) > 2030 && (y_1 - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 40) > 960 && (x - 40) <= 1200 && (y_1 - 40) >=1000 && (y_1 - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x - 40) > 960 && (x - 40) <= 1200 && (y_1 - 40) > 2030 && (y_1 - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        LOGGER.info("Finish calculating inner decoration, painting shagreen price without top transom:{}", paintingShagreen);
    }

    public void calcPaintingAntic(int x, int y, int y_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting antic");
        if (x - 40 < 500 || x - 40 > 1200 || y_1 - 40 < 1000 || y_1 - 40 > 2450)
            throw new UnsupportedDimensions("Painting PF", y, x);
        LOGGER.info("Painting antic: dimension OK");
        if ((x - 40) >= 500 && (x - 40) <= 960 && (y_1 - 40) >=1000 && (y_1 - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.LIST_M2.getPriceInUAH()
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 40) >= 500 && (x - 40) <= 960 && (y_1 - 40) > 2030 && (y_1 - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.LIST_M2.getPriceInUAH()
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 40) > 960 && (x - 40) <= 1200 && (y_1 - 40) >=1000 && (y_1 - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.LIST_M2.getPriceInUAH()
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 40) > 960 && (x - 40) <= 1200 && (y_1 - 40) > 2030 && (y_1 - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.LIST_M2.getPriceInUAH()
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        LOGGER.info("Finish calculating inner decoration, painting antic price:{}", paintingAntic);
    }

    public void calcPaintingAnticWithoutTopTransom(int x, int y, int y_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting antic");
        if (x - 40 < 500 || x - 40 > 1200 || y_1 - 40 < 1000 || y_1 - 40 > 2450)
            throw new UnsupportedDimensions("Painting PF", y, x);
        LOGGER.info("Painting antic: dimension OK");
        if ((x - 40) >= 500 && (x - 40) <= 960 && (y_1 - 40) >=1000 && (y_1 - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 40) >= 500 && (x - 40) <= 960 && (y_1 - 40) > 2030 && (y_1 - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 40) > 960 && (x - 40) <= 1200 && (y_1 - 40) >=1000 && (y_1 - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x - 40) > 960 && (x - 40) <= 1200 && (y_1 - 40) > 2030 && (y_1 - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 40) * (y_1 - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)y - y_1) * x / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        LOGGER.info("Finish calculating inner decoration, painting antic price:{}", paintingAntic);
    }
}
