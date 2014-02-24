package sample.com.doorder.door.simple;

import sample.com.doorder.door.Price;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleDoorOuterDecoration extends OuterDecoration{

    @Override
    public void calcSelfAdhesiveFilm(int x, int y) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for self adhesive film");
        if (x < 800 || x > 1950)
            throw new UnsupportedDimensions("Self adhesive film", y, x);
        LOGGER.info("Self adhesive film: dimension OK");
        if (x >= 800 && x <= 1200) {
            selfAdhesiveFilm = 1.1 * 1.5 * y / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH()
                    +((x + y) * 2 * 0.1 + (4 * y + 2 * x) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        if (x >= 1201 && x <= 1400) {
            double material = 1.1 * 2 * y / 1000;
            selfAdhesiveFilm = material * Price.SELF_ADHESIVE_FILM.getPriceInUAH()
                    +((x + y) * 2 * 0.1 + (4 * y + 2 * x) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        if (x >= 1401 && x <= 1950) {
            double material = 1.1 * 3 * y / 1000;
            selfAdhesiveFilm = material * Price.SELF_ADHESIVE_FILM.getPriceInUAH()
                    +((x + y) * 2 * 0.1 + (4 * y + 2 * x) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        LOGGER.info("Finish calculating outer decoration, self adhesive film price:{}", selfAdhesiveFilm);
    }

    @Override
    public void calcPaintingShagreen(int x, int y) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)x * y) / 1000000 + (x + y) * 2 * 0.1 / 1000
                + (2 * x + 4 * y) * 0.06 / 1000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingShagreen = bd.doubleValue() * Price.PAINTING_SHAGREEN.getPriceInUAH();
        totalOuterDecorationPrice += paintingShagreen;
        LOGGER.info("Finish calculating outer decoration, painting shagreen price:{}", paintingShagreen);
    }

    @Override
    public void calcPaintingAntic(int x, int y) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)x * y) / 1000000 + (x + y) * 2 * 0.1 / 1000
                + (2 * x + 4 * y) * 0.06 / 1000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingAntic = bd.doubleValue() * Price.PAINTING_ANTIC.getPriceInUAH();
        totalOuterDecorationPrice += paintingAntic;
        LOGGER.info("Finish calculating outer decoration, painting antic price:{}", paintingAntic);
    }

    @Override
    public void calcPaintingPF(int x, int y) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)x * y) / 1000000 + (x + y) * 2 * 0.1 / 1000
                + (2 * x + 4 * y) * 0.06 / 1000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingPF = bd.doubleValue() * Price.PAINTING_PF.getPriceInUAH();
        totalOuterDecorationPrice += paintingPF;
        LOGGER.info("Finish calculating outer decoration, painting PF price:{}", paintingPF);
    }

    @Override
    public void calcAntiLayer(int x, int y) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for anti layer");
        if (x < 800 || x > 1950)
            throw new UnsupportedDimensions("Anti layer", y, x);
        LOGGER.info("Anti layer: dimension OK");
        if (x >= 800 && x <= 1200) {
            double material = 1.25 * y / 1000;
            antiLayer = material * Price.ANTI_LAYER.getPriceInUAH()
                    + ((x + y) * 2 * 0.1 + (2 * x + 4 * y) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += antiLayer;
        }
        if (x >= 1201 && x <= 1400) {
            double material = 1.4 * y / 1000;
            antiLayer = material * Price.ANTI_LAYER.getPriceInUAH()
                    + ((x + y) * 2 * 0.1 + (2 * x + 4 * y) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += antiLayer;
        }
        if (x >= 1401 && x <= 1950) {
            double material = 2 * 1.25 * y / 1000;
            antiLayer = material * Price.ANTI_LAYER.getPriceInUAH()
                    + ((x + y) * 2 * 0.1 + (2 * x + 4 * y) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
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
        if (y > 999 && y < 2051) {
            BigDecimal bd = new BigDecimal((double)x * y / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue() * Price.MDF_10.getPriceInUAH()
                    + ((x + y) * 2 * 0.1 + (2 * x + 4 * y) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += mdf10;
        }
        if (y > 2050 && y < 2351) {
            BigDecimal bd = new BigDecimal((double)x * y / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue() * Price.MDF_10.getPriceInUAH() + 40
                    + ((x + y) * 2 * 0.1 + (2 * x + 4 * y) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
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
        if (y > 999 && y < 2051) {
            BigDecimal bd = new BigDecimal((double)x * y / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue() * Price.MDF_16.getPriceInUAH()
                    + ((x + y) * 2 * 0.1 + (2 * x + 4 * y) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += mdf16;
        }
        if (y > 2050 && y < 2351) {
            BigDecimal bd = new BigDecimal((double)x * y / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue() * Price.MDF_16.getPriceInUAH() + 40
                    + ((x + y) * 2 * 0.1 + (2 * x + 4 * y) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += mdf16;
        }
        LOGGER.info("Finish calculating outer decoration, MDF_16 price:{}", mdf16);
    }
}
