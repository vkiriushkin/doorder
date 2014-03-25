package sample.com.doorder.door.doubleframe;

import sample.com.doorder.door.Price;
import sample.com.doorder.door.UnsupportedDimensions;
import sample.com.doorder.door.angled.OuterDecoration;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleFrameSingleSideTransomDoorOuterDecoration extends OuterDecoration {

    @Override
    public void calcSelfAdhesiveFilm(int x, int y) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for self adhesive film");
        if (x < 800 || x > 1950)
            throw new UnsupportedDimensions("Self adhesive film", y, x);
        LOGGER.info("Self adhesive film: dimension OK");
        if (x >= 800 && x <= 1200) {
            BigDecimal bd = new BigDecimal(1.1 * 1.5 * (double)y / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH()
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            selfAdhesiveFilm = bd.doubleValue();
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        if (x >= 1201 && x <= 1400) {
            BigDecimal bd = new BigDecimal(1.1 * 2 * (double)y / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH()
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            selfAdhesiveFilm = bd.doubleValue();
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        if (x >= 1401 && x <= 1950) {
            BigDecimal bd = new BigDecimal(1.1 * 3 * (double)y / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH()
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            selfAdhesiveFilm = bd.doubleValue();
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        LOGGER.info("Finish calculating outer decoration, self adhesive film price:{}", selfAdhesiveFilm);
    }

    public void calcSelfAdhesiveFilmWithoutTopTransom(int x, int y, int x_1) {
        LOGGER.info("Start calculating outer decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for self adhesive film without top transom");
        if (x_1 < 500 || x_1 > 1200)
            throw new UnsupportedDimensions("Self adhesive film, without top transom", y, x);
        LOGGER.info("Self adhesive film, without top transom: dimension OK");
        if (x_1 >= 500 && x_1 <= 800) {
            BigDecimal bd = new BigDecimal(1.1 * (double) y / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            selfAdhesiveFilm = bd.doubleValue();
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        if (x_1 >= 801 && x_1 <= 1200) {
            BigDecimal bd = new BigDecimal(1.1 * 1.5 * (double) y / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            selfAdhesiveFilm = bd.doubleValue();
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        LOGGER.info("Finish calculating outer decoration, self adhesive film price without top transom:{}", selfAdhesiveFilm);
    }

    public void calcPaintingShagreen(int x, int y, int x_1) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        BigDecimal bd = new BigDecimal((((double)x * y) / 1000000
                + ((double)x + y) * 2 * 0.1 / 1000 + (4 * y + 2 * x) * 0.06 / 1000
                + ((double)x_1 + y) * 2 * 0.13 / 1000) * Price.PAINTING_SHAGREEN.getPriceInUAH());
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingShagreen = bd.doubleValue();
        totalOuterDecorationPrice += paintingShagreen;
        LOGGER.info("Finish calculating outer decoration, painting shagreen price:{}", paintingShagreen);
    }

    public void calcPaintingShagreenWithoutTopTransom(int x, int y, int x_1) {
        LOGGER.info("Start calculating outer decoration without top transom");
        clear();
        BigDecimal bd = new BigDecimal((((double)y * x_1) / 1000000
                + ((double)y + x_1) * 2 * 0.1 / 1000 + (4 * y + 2 * x_1) * 0.06 / 1000
                + ((double)x_1 + y) * 2 * 0.13 / 1000) * Price.PAINTING_SHAGREEN.getPriceInUAH()
                + ((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingShagreen = bd.doubleValue();
        totalOuterDecorationPrice += paintingShagreen;
        LOGGER.info("Finish calculating outer decoration, painting shagreen price without top transom:{}", paintingShagreen);
    }

    public void calcPaintingAntic(int x, int y, int x_1) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        BigDecimal bd = new BigDecimal((((double)x * y) / 1000000
                + ((double)x + y) * 2 * 0.1 / 1000 + (4 * y + 2 * x) * 0.06 / 1000
                + ((double)x_1 + y) * 2 * 0.13 / 1000) * Price.PAINTING_ANTIC.getPriceInUAH());
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingAntic = bd.doubleValue();
        totalOuterDecorationPrice += paintingAntic;
        LOGGER.info("Finish calculating outer decoration, painting antic price:{}", paintingAntic);
    }

    public void calcPaintingAnticWithoutTopTransom(int x, int y, int x_1) {
        LOGGER.info("Start calculating outer decoration without top transom");
        clear();
        BigDecimal bd = new BigDecimal((((double)y * x_1) / 1000000
                + ((double)y + x_1) * 2 * 0.1 / 1000 + (4 * y + 2 * x_1) * 0.06 / 1000
                + ((double)x_1 + y) * 2 * 0.13 / 1000) * Price.PAINTING_ANTIC.getPriceInUAH()
                + ((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingAntic = bd.doubleValue();
        totalOuterDecorationPrice += paintingAntic;
        LOGGER.info("Finish calculating outer decoration, painting antic price without top transom:{}", paintingAntic);
    }

    public void calcPaintingPF(int x, int y, int x_1) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        BigDecimal bd = new BigDecimal((((double)x * y) / 1000000
                + ((double)x + y) * 2 * 0.1 / 1000 + (4 * y + 2 * x) * 0.06 / 1000
                + ((double)x_1 + y) * 2 * 0.13 / 1000) * Price.PAINTING_PF.getPriceInUAH());
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingPF = bd.doubleValue();
        totalOuterDecorationPrice += paintingPF;
        LOGGER.info("Finish calculating outer decoration, painting PF price:{}", paintingPF);

    }

    public void calcPaintingPFWithoutTopTransom(int x, int y, int x_1) {
        LOGGER.info("Start calculating outer decoration without top transom");
        clear();
        BigDecimal bd = new BigDecimal((((double)y * x_1) / 1000000
                + ((double)y + x_1) * 2 * 0.1 / 1000 + (4 * y + 2 * x_1) * 0.06 / 1000
                + ((double)x_1 + y) * 2 * 0.13 / 1000) * Price.PAINTING_PF.getPriceInUAH()
                + ((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingPF = bd.doubleValue();
        totalOuterDecorationPrice += paintingPF;
        LOGGER.info("Finish calculating outer decoration, painting PF price without top transom:{}", paintingPF);
    }

    public void calcAntiLayer(int x, int y) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for anti layer");
        if (x < 800 || x > 1950)
            throw new UnsupportedDimensions("Anti layer", y, x);
        LOGGER.info("Anti layer: dimension OK");
        if (x >= 800 && x <= 1200) {
            BigDecimal bd = new BigDecimal((1.25 * (double) y / 1000) * Price.ANTI_LAYER.getPriceInUAH()
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            antiLayer = bd.doubleValue();
            totalOuterDecorationPrice += antiLayer;
        }
        if (x >= 1201 && x <= 1400) {
            BigDecimal bd = new BigDecimal((1.4 * (double) y / 1000) * Price.ANTI_LAYER.getPriceInUAH()
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            antiLayer = bd.doubleValue();
            totalOuterDecorationPrice += antiLayer;
        }
        if (x >= 1401 && x <= 1950) {
            BigDecimal bd = new BigDecimal((1.25 * 2 * (double) y / 1000) * Price.ANTI_LAYER.getPriceInUAH()
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            antiLayer = bd.doubleValue();
            totalOuterDecorationPrice += antiLayer;
        }
        LOGGER.info("Finish calculating outer decoration, anti layer price:{}", antiLayer);
    }

    public void calcAntiLayerWithoutTopTransom(int x, int y, int x_1) {
        LOGGER.info("Start calculating outer decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for anti layer without top transom");
        if (x < 500 || x > 1200)
            throw new UnsupportedDimensions("Anti layer without top transom", y, x);
        LOGGER.info("Anti layer: dimension OK without top transom");
        if (x >= 500 && x <= 1200) {
            BigDecimal bd = new BigDecimal(1.25 * (double)y / 1000 * Price.ANTI_LAYER.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
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
            throw new UnsupportedDimensions("MDF_10", y, x);
        LOGGER.info("MDF_10: dimension OK");
        if (y >= 100 && y <= 2050) {
            BigDecimal bd = new BigDecimal((double)x * y / 1000000  * Price.MDF_10.getPriceInUAH()
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue();
            totalOuterDecorationPrice += mdf10;
        }
        if (y > 2050 && y <= 2350) {
            BigDecimal bd = new BigDecimal((double)x * y / 1000000  * Price.MDF_10.getPriceInUAH() + 80
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue();
            totalOuterDecorationPrice += mdf10;
        }
        LOGGER.info("Finish calculating outer decoration, MDF_10 price:{}", mdf10);
    }

    public void calcMdf10WithoutTopTransom(int x, int y, int x_1) {
        LOGGER.info("Start calculating outer decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for mdf10 without top transom");
        if (y < 1000 || y > 2350)
            throw new UnsupportedDimensions("MDF_10 without top transom", y, x);
        LOGGER.info("MDF_10 without top transom: dimension OK");
        if (y >= 1000 && y <= 2050) {
            BigDecimal bd = new BigDecimal((double)y * x_1 / 1000000  * Price.MDF_10.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue();
            totalOuterDecorationPrice += mdf10;
        }
        if (y >= 2051 && y <= 2350) {
            BigDecimal bd = new BigDecimal((double)y * x_1 / 1000000  * Price.MDF_10.getPriceInUAH() + 80
                    + ((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
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
            throw new UnsupportedDimensions("MDF_16", y, x);
        LOGGER.info("MDF_16: dimension OK");
        if (y >= 1000 && y <= 2050) {
            BigDecimal bd = new BigDecimal((double)x * y / 1000000 * Price.MDF_16.getPriceInUAH()
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue();
            totalOuterDecorationPrice += mdf16;
        }
        if (y >= 2051 && y <= 2350) {
            BigDecimal bd = new BigDecimal((double)x * y / 1000000 * Price.MDF_16.getPriceInUAH() + 80
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue();
            totalOuterDecorationPrice += mdf16;
        }
        LOGGER.info("Finish calculating outer decoration, MDF_16 price:{}", mdf16);
    }

    public void calcMdf16WithoutTopTransom(int x, int y, int x_1) {
        LOGGER.info("Start calculating outer decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for mdf16 without top transom");
        if (y < 1000 || y > 2350)
            throw new UnsupportedDimensions("MDF_16 without top transom", y, x);
        LOGGER.info("MDF_16 without top transom: dimension OK");
        if (y >= 1000 && y <= 2050) {
            BigDecimal bd = new BigDecimal((double)y * x_1 / 1000000 * Price.MDF_16.getPriceInUAH()
                    + ((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue();
            totalOuterDecorationPrice += mdf16;
        }
        if (y >= 2051 && y <= 2350) {
            BigDecimal bd = new BigDecimal((double)y * x_1 / 1000000 * Price.MDF_16.getPriceInUAH() + 80
                    + ((double)x - x_1) * y * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + (((double)x + y) * 2 * 0.07) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue();
            totalOuterDecorationPrice += mdf16;
        }
        LOGGER.info("Finish calculating outer decoration, MDF_16 price without top transom:{}", mdf16);
    }
}
