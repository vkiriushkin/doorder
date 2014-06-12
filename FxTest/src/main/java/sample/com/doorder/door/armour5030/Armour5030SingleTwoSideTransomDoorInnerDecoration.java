package sample.com.doorder.door.armour5030;

import sample.com.doorder.door.Price;
import sample.com.doorder.door.UnsupportedDimensions;
import sample.com.doorder.door.angled.InnerDecoration;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Armour5030SingleTwoSideTransomDoorInnerDecoration extends InnerDecoration {

    public void calcPlastic(int x, int y, int x_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal((2 * (double)x + 6 * y) * 1.1 * Price.START.getPriceInUAH() / 1000
                + ((double)x * y) * 1.1 * Price.PLASTIC.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        plastic = bd.doubleValue();
        totalInnerDecorationPrice += plastic;
        LOGGER.info("Finish calculating inner decoration, plastic price:{}", plastic);
    }

    public void calcPlasticWithoutTopTransom(int x, int y, int x_1) {
        LOGGER.info("Start calculating inner decoration without top transom");
        clear();
        BigDecimal bd = new BigDecimal(((double)y + x_1) * 2.2 * Price.START.getPriceInUAH() / 1000 +
                +((double)x_1 * y) * 1.1 * Price.PLASTIC.getPriceInUAH() / 1000000
                +((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        plastic = bd.doubleValue();
        totalInnerDecorationPrice += plastic;
        LOGGER.info("Finish calculating inner decoration, plastic price without top transom:{}", plastic);
    }

    public void calcLaminate(int x, int y, int x_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal((2 * (double)x + 6 * y) * 1.1 * Price.START.getPriceInUAH() / 1000
                + ((double) x * y) * 1.1 * Price.LAMINATED_PLASTIC.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        laminate = bd.doubleValue();
        totalInnerDecorationPrice += laminate;
        LOGGER.info("Finish calculating inner decoration, laminated plastic price:{}", laminate);
    }

    public void calcLaminateWithoutTopTransom(int x, int y, int x_1) {
        LOGGER.info("Start calculating inner decoratio nwithout top transom");
        clear();
        BigDecimal bd = new BigDecimal(((double)y + x_1) * 2.2 * Price.START.getPriceInUAH() / 1000
                + ((double)x_1 * y) * 1.1 * Price.LAMINATED_PLASTIC.getPriceInUAH() / 1000000
                + ((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        laminate = bd.doubleValue();
        totalInnerDecorationPrice += laminate;
        LOGGER.info("Finish calculating inner decoration, laminated plastic price without top transom:{}", laminate);
    }

    public void calcMdf10(int x, int y, int x_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for mdf10");
        if (y - 30 < 1000 || y - 30 > 2350)
            throw new UnsupportedDimensions("Выберите другой вид внутренней отделки (максимальная высота для МДФ 2350мм)");
        LOGGER.info("MDF_10: dimension OK");
        if ((y - 30) >= 1000 && (y - 30) <= 2050) {
            BigDecimal bd = new BigDecimal(((((double)x - 30) * (y - 30)) / 1000000) * Price.MDF_10.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue();
            totalInnerDecorationPrice += mdf10;
        }
        if ((y - 30) > 2050 && (y - 30) <= 2350) {
            BigDecimal bd = new BigDecimal(((((double)x - 30) * (y - 30)) / 1000000) * Price.MDF_10.getPriceInUAH() + 120);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue();
            totalInnerDecorationPrice += mdf10;
        }
        LOGGER.info("Finish calculating inner decoration, MDF_10 price:{}", mdf10);
    }

    public void calcMdf10WithoutTopTransom(int x, int y, int x_1) {
        LOGGER.info("Start calculating inner decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for mdf10 without top transom");
        if (y - 30 < 1000 || y - 30 > 2350)
            throw new UnsupportedDimensions("Выберите другой вид внутренней отделки (максимальная высота для МДФ 2350мм)");
        LOGGER.info("MDF_10 without top transom: dimension OK");
        if ((y - 30) >= 1000 && (y - 30) <= 2050) {
            BigDecimal bd = new BigDecimal(((double)(y - 30) * (x_1 - 30)) / 1000000 * Price.MDF_10.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue();
            totalInnerDecorationPrice += mdf10;
        }
        if ((y - 30) > 2050 && (y - 30) <= 2350) {
            BigDecimal bd = new BigDecimal(((double)(y - 30) * (x_1 - 30)) / 1000000 * Price.MDF_10.getPriceInUAH() + 40
                    + ((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue();
            totalInnerDecorationPrice += mdf10;
        }
        LOGGER.info("Finish calculating inner decoration, MDF_10 price without top transom:{}", mdf10);
    }

    public void calcMdf16(int x, int y, int x_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for mdf16");
        if (y - 30 < 1000 || y - 30 > 2350)
            throw new UnsupportedDimensions("Выберите другой вид внутренней отделки (максимальная высота для МДФ 2350мм)");
        LOGGER.info("MDF_16: dimension OK");
        if ((y - 30) >= 1000 && (y - 30) <= 2050) {
            BigDecimal bd = new BigDecimal(((((double)x - 30) * (y - 30)) / 1000000) * Price.MDF_16.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue();
            totalInnerDecorationPrice += mdf16;
        }
        if ((y - 30) > 2050 && (y - 30) <= 2350) {
            BigDecimal bd = new BigDecimal(((((double)x - 30) * (y - 30)) / 1000000) * Price.MDF_16.getPriceInUAH() + 120);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue();
            totalInnerDecorationPrice += mdf16;
        }
        LOGGER.info("Finish calculating inner decoration, MDF_16 price:{}", mdf16);
    }

    public void calcMdf16WithoutTopTransom(int x, int y, int x_1) {
        LOGGER.info("Start calculating inner decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for mdf16 without top transom");
        if (y - 30 < 1000 || y - 30 > 2350)
            throw new UnsupportedDimensions("Выберите другой вид внутренней отделки (максимальная высота для МДФ 2350мм)");
        LOGGER.info("MDF_16 without top transom: dimension OK");
        if ((y - 30) >= 1000 && (y - 30) <= 2050) {
            BigDecimal bd = new BigDecimal(((double)(y - 30) * (x_1 - 30)) / 1000000 * Price.MDF_16.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue();
            totalInnerDecorationPrice += mdf16;
        }
        if ((y - 30) > 2050 && (y - 30) <= 2350) {
            BigDecimal bd = new BigDecimal(((double)(y - 30) * (x_1 - 30)) / 1000000 * Price.MDF_16.getPriceInUAH() + 40
                    + ((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue();
            totalInnerDecorationPrice += mdf16;
        }
        LOGGER.info("Finish calculating inner decoration, MDF_16 price without top transom:{}", mdf16);
    }

    public void calcPaintingPF(int x, int y, int x_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting PF");
        if (x_1 - 60 < 500 || x_1 - 60 > 1200 || y - 60 < 1000 || y - 60 > 2450)
            throw new UnsupportedDimensions("Painting PF", y, x);
        LOGGER.info("Painting PF: dimension OK");
        if ((x_1 - 60) >= 500 && (x_1 - 60) <= 960 && (y - 60) >= 1000 && (y - 60) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.LIST_M2.getPriceInUAH() / 1000000
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x_1 - 60) >= 500 && (x_1 - 60) <= 960 && (y - 60) > 2030 && (y - 60) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.LIST_M2.getPriceInUAH() / 1000000
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x_1 - 60) > 960 && (x_1 - 60) <= 1200 && (y - 60) >= 1000 && (y - 60) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.LIST_M2.getPriceInUAH() / 1000000
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x_1 - 60) > 960 && (x_1 - 60) <= 1200 && (y - 60) > 2030 && (y - 60) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.LIST_M2.getPriceInUAH() / 1000000
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.CEILING);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        LOGGER.info("Finish calculating inner decoration, painting PF price:{}", paintingPF);
    }

    public void calcPaintingPFWithoutTopTransom(int x, int y, int x_1) {
        LOGGER.info("Start calculating inner decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for painting PF without top transom");
        if (x_1 - 60 < 500 || x_1 - 60 > 1200 || y - 60 < 1000 || y - 60 > 2450)
            throw new UnsupportedDimensions("Painting PF without top transom", y, x);
        LOGGER.info("Painting PF without top transom: dimension OK");
        if ((x_1 - 60) >= 500 && (x_1 - 60) <= 1000 && (y - 60) >=1000 && (y - 60) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x_1 - 60) >= 500 && (x_1 - 60) <= 1000 && (y - 60) > 2030 && (y - 60) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x_1 - 60) > 1000 && (x_1 - 60) <= 1200 && (y - 60) >=1000 && (y - 60) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((x_1 - 60) > 1000 && (x_1 - 60) <= 1200 && (y - 60) > 2030 && (y - 60) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        LOGGER.info("Finish calculating inner decoration, painting PF price without top transom:{}", paintingPF);
    }

    public void calcPaintingShagreen(int x, int y, int x_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting shagreen");
        if (x_1 - 60 < 500 || x_1 - 60 > 1200 || y - 60 < 1000 || y - 60 > 2450)
            throw new UnsupportedDimensions("Painting PF", y, x);
        LOGGER.info("Painting shagreen: dimension OK");
        if ((x_1 - 60) >= 500 && (x_1 - 60) <= 960 && (y - 60) >= 1000 && (y - 60) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.LIST_M2.getPriceInUAH() / 1000000
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x_1 - 60) >= 500 && (x_1 - 60) <= 960 && (y - 60) > 2030 && (y - 60) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.LIST_M2.getPriceInUAH() / 1000000
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x_1 - 60) > 960 && (x_1 - 60) <= 1200 && (y - 60) >= 1000 && (y - 60) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.LIST_M2.getPriceInUAH() / 1000000
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x_1 - 60) > 960 && (x_1 - 60) <= 1200 && (y - 60) > 2030 && (y - 60) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.LIST_M2.getPriceInUAH() / 1000000
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        LOGGER.info("Finish calculating inner decoration, painting shagreen price:{}", paintingShagreen);
    }

    public void calcPaintingShagreenWithoutTopTransom(int x, int y, int x_1) {
        LOGGER.info("Start calculating inner decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for painting shagreen without top transom");
        if (x_1 - 60 < 500 || x_1 - 60 > 1200 || y - 60 < 1000 || y - 60 > 2450)
            throw new UnsupportedDimensions("Painting PF without top transom", y, x);
        LOGGER.info("Painting shagreen without top transom: dimension OK");
        if ((x_1 - 60) >= 500 && (x_1 - 60) <= 1000 && (y - 60) >=1000 && (y - 60) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x_1 - 60) * (y - 60) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)x - x_1) * y / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x_1 - 60) >= 500 && (x_1 - 60) <= 1000 && (y - 60) > 2030 && (y - 60) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x_1 - 60) * (y - 60) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)x - x_1) * y / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x_1 - 60) > 1000 && (x_1 - 60) <= 1200 && (y - 60) >=1000 && (y - 60) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x_1 - 60) * (y - 60) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)x - x_1) * y / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((x_1 - 60) > 1000 && (x_1 - 60) <= 1200 && (y - 60) > 2030 && (y - 60) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x_1 - 60) * (y - 60) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)x - x_1) * y / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        LOGGER.info("Finish calculating inner decoration, painting shagreen price without top transom:{}", paintingShagreen);
    }

    public void calcPaintingAntic(int x, int y, int x_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting antic");
        if (x_1 - 60 < 500 || x_1 - 60 > 1200 || y - 60 < 1000 || y - 60 > 2450)
            throw new UnsupportedDimensions("Painting PF", y, x);
        LOGGER.info("Painting antic: dimension OK");
        if ((x_1 - 60) >= 500 && (x_1 - 60) <= 960 && (y - 60) >= 1000 && (y - 60) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.LIST_M2.getPriceInUAH() / 1000000
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x_1 - 60) >= 500 && (x_1 - 60) <= 960 && (y - 60) > 2030 && (y - 60) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.LIST_M2.getPriceInUAH() / 1000000
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x_1 - 60) > 960 && (x_1 - 60) <= 1200 && (y - 60) >= 1000 && (y - 60) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.LIST_M2.getPriceInUAH() / 1000000
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x_1 - 60) > 960 && (x_1 - 60) <= 1200 && (y - 60) > 2030 && (y - 60) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.LIST_M2.getPriceInUAH() / 1000000
                    + ((double)x - 60) * (y - 60) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        LOGGER.info("Finish calculating inner decoration, painting antic price:{}", paintingAntic);
    }

    public void calcPaintingAnticWithoutTopTransom(int x, int y, int x_1) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting antic");
        if (x_1 - 60 < 500 || x_1 - 60 > 1200 || y - 60 < 1000 || y - 60 > 2450)
            throw new UnsupportedDimensions("Painting PF", y, x);
        LOGGER.info("Painting antic: dimension OK");
        if ((x_1 - 60) >= 500 && (x_1 - 60) <= 1000 && (y - 60) >=1000 && (y - 60) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH()
                    + ((double)x_1 - 60) * (y - 60) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)x - x_1) * y / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x_1 - 60) >= 500 && (x_1 - 60) <= 1000 && (y - 60) > 2030 && (y - 60) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x_1 - 60) * (y - 60) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)x - x_1) * y / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x_1 - 60) > 1000 && (x_1 - 60) <= 1200 && (y - 60) >=1000 && (y - 60) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x_1 - 60) * (y - 60) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)x - x_1) * y / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((x_1 - 60) > 1000 && (x_1 - 60) <= 1200 && (y - 60) > 2030 && (y - 60) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH()
                    + ((double)x_1 - 60) * (y - 60) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)x - x_1) * y / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        LOGGER.info("Finish calculating inner decoration, painting antic price:{}", paintingAntic);
    }

}
