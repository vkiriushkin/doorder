package sample.com.doorder.door.simple;

import sample.com.doorder.door.Price;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SingleDoorSideTransomOuterDecoration extends OuterDecoration {

    @Override
    public void calcSelfAdhesiveFilm(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for self adhesive film");
        if (width < 800 || width > 1950)
            throw new UnsupportedDimensions("Self adhesive film", height, width);
        LOGGER.info("Self adhesive film: dimension OK");
        if (width >= 800 && width <= 1200) {
            selfAdhesiveFilm = 1.1 * 1.5 * height / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH() + ((width + height) * 2 * 0.1 + (2 * width + 4 * height) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        if (width >= 1201 && width <= 1400) {
            double material = 1.1 * 2 * height / 1000;
            selfAdhesiveFilm = material * Price.SELF_ADHESIVE_FILM.getPriceInUAH() + ((width + height) * 2 * 0.1 + (2 * width + 4 * height) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        if (width >= 1401 && width <= 1950) {
            double material = 1.1 * 3 * height / 1000;
            selfAdhesiveFilm = material * Price.SELF_ADHESIVE_FILM.getPriceInUAH() + ((width + height) * 2 * 0.1 + (2 * width + 4 * height) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        LOGGER.info("Finish calculating outer decoration, self adhesive film price:{}", selfAdhesiveFilm);
    }

    public void calcSelfAdhesiveFilmWithoutTopTransom(int width, int height, int heightTransom) {
        LOGGER.info("Start calculating outer decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for self adhesive film without top transom");
        if (heightTransom < 500 || heightTransom > 1200)
            throw new UnsupportedDimensions("Self adhesive film, without top transom", height, width);
        LOGGER.info("Self adhesive film, without top transom: dimension OK");
        if (heightTransom >= 500 && heightTransom <= 800) {
            double material = 1.1 * height / 1000;
            selfAdhesiveFilm = material * Price.SELF_ADHESIVE_FILM.getPriceInUAH() + ((double)width - heightTransom) * height * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((width + height) * 2 * 0.1 + (2 * width + 4 * height) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        if (heightTransom >= 801 && heightTransom <= 1200) {
            double material = 1.1 * 1.5 * height / 1000;
            selfAdhesiveFilm = material * Price.SELF_ADHESIVE_FILM.getPriceInUAH() + ((double)width - heightTransom) * height * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((width + height) * 2 * 0.1 + (2 * width + 4 * height) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        LOGGER.info("Finish calculating outer decoration, self adhesive film price without top transom:{}", selfAdhesiveFilm);
    }

    public void calcPaintingShagreen(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)width * height) / 1000000
                + (width + height) * 2 * 0.1 / 1000 + (4 * height + 2 * width) * 0.06 / 1000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingShagreen = bd.doubleValue() * Price.PAINTING_SHAGREEN.getPriceInUAH();
        totalOuterDecorationPrice += paintingShagreen;
        LOGGER.info("Finish calculating outer decoration, painting shagreen price:{}", paintingShagreen);
    }

    public void calcPaintingShagreenWithoutTopTransom(int width, int height, int heightTransom) {
        LOGGER.info("Start calculating outer decoration without top transom");
        clear();
        BigDecimal bd = new BigDecimal(((double)height * heightTransom) / 1000000
                + (height + heightTransom) * 2 * 0.1 / 1000 + (4 * height + 2 * heightTransom) * 0.06 / 1000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingShagreen = bd.doubleValue() * Price.PAINTING_SHAGREEN.getPriceInUAH() + ((double)width - heightTransom) * height * Price.PAINTING_PF.getPriceInUAH() / 1000000;
        totalOuterDecorationPrice += paintingShagreen;
        LOGGER.info("Finish calculating outer decoration, painting shagreen price without top transom:{}", paintingShagreen);
    }

    public void calcPaintingAntic(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)width * height) / 1000000 + (width + height) * 2 * 0.1 / 1000 + (4 * height + 2 * width) * 0.06 / 1000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingAntic = bd.doubleValue() * Price.PAINTING_ANTIC.getPriceInUAH();
        totalOuterDecorationPrice += paintingAntic;
        LOGGER.info("Finish calculating outer decoration, painting antic price:{}", paintingAntic);
    }

    public void calcPaintingAnticWithoutTopTransom(int width, int height, int heightTransom) {
        LOGGER.info("Start calculating outer decoration without top transom");
        clear();
        BigDecimal bd = new BigDecimal(((double)height * heightTransom) / 1000000
                + (heightTransom + height) * 2 * 0.1 / 1000 + (4 * height + 2 * heightTransom) * 0.06 / 1000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingAntic = bd.doubleValue() * Price.PAINTING_ANTIC.getPriceInUAH()
                + ((double)width - heightTransom) * height * Price.PAINTING_PF.getPriceInUAH() / 1000000;
        totalOuterDecorationPrice += paintingAntic;
        LOGGER.info("Finish calculating outer decoration, painting antic price without top transom:{}", paintingAntic);
    }

    public void calcPaintingPF(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)width * height) / 1000000
                + (width + height) * 2 * 0.1 / 1000 + (4 * height + 2 * width) * 0.06 / 1000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingPF = bd.doubleValue() * Price.PAINTING_PF.getPriceInUAH();
        totalOuterDecorationPrice += paintingPF;
        LOGGER.info("Finish calculating outer decoration, painting PF price:{}", paintingPF);

    }

    public void calcPaintingPFWithoutTopTransom(int width, int height, int heightTransom) {
        LOGGER.info("Start calculating outer decoration without top transom");
        clear();
        BigDecimal bd = new BigDecimal(((double)height * heightTransom) / 1000000
                + (heightTransom + height) * 2 * 0.1 / 1000 + (4 * height + 2 * heightTransom) * 0.06 / 1000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingPF = bd.doubleValue() * Price.PAINTING_PF.getPriceInUAH() + (width - heightTransom) * height * Price.PAINTING_PF.getPriceInUAH() / 1000000;
        totalOuterDecorationPrice += paintingPF;
        LOGGER.info("Finish calculating outer decoration, painting PF price without top transom:{}", paintingPF);
    }

    public void calcAntiLayer(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for anti layer");
        if (width < 800 || width > 1950)
            throw new UnsupportedDimensions("Anti layer", height, width);
        LOGGER.info("Anti layer: dimension OK");
        if (width >= 800 && width <= 1200) {
            double material = 1.25 * height / 1000;
            antiLayer = material * Price.ANTI_LAYER.getPriceInUAH()
                    + ((width + height) * 2 * 0.1 + (4 * height + 2 * width) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += antiLayer;
        }
        if (width >= 1201 && width <= 1400) {
            double material = 1.4 * height / 1000;
            antiLayer = material * Price.ANTI_LAYER.getPriceInUAH()
                    + ((width + height) * 2 * 0.1 + (4 * height + 2 * width) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += antiLayer;
        }
        if (width >= 1401 && width <= 1950) {
            double material = 1.25 * 2 *  height / 1000;
            antiLayer = material * Price.ANTI_LAYER.getPriceInUAH()
                    + ((width + height) * 2 * 0.1 + (4 * height + 2 * width) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += antiLayer;
        }
        LOGGER.info("Finish calculating outer decoration, anti layer price:{}", antiLayer);
    }

    public void calcAntiLayerWithoutTopTransom(int width, int height, int heightTransom) {
        LOGGER.info("Start calculating outer decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for anti layer without top transom");
        if (width < 500 || width > 1200)
            throw new UnsupportedDimensions("Anti layer without top transom", height, width);
        LOGGER.info("Anti layer: dimension OK without top transom");
        if (width >= 500 && width <= 1200) {
            double material = 1.25 * height / 1000;
            antiLayer = material * Price.ANTI_LAYER.getPriceInUAH() + (width - heightTransom) * height* Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((width + height) * 2 * 0.1 + (4 * height + 2 * width) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += antiLayer;
        }
        LOGGER.info("Finish calculating outer decoration, anti layer price without top transom:{}", antiLayer);
    }

    public void calcMdf10(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for mdf10");
        if (height < 1000 || height > 2350)
            throw new UnsupportedDimensions("MDF_10", height, width);
        LOGGER.info("MDF_10: dimension OK");
        if (height >= 100 && height <= 2050) {
            BigDecimal bd = new BigDecimal((double)width * height / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue() * Price.MDF_10.getPriceInUAH()
                    + ((width + height) * 2 * 0.1 + (4 * height + 2 * width) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += mdf10;
        }
        if (height > 2050 && height <= 2350) {
            BigDecimal bd = new BigDecimal((double)width * height / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue() * Price.MDF_10.getPriceInUAH() + 80 + ((width + height) * 2 * 0.1
                    +(width + height) * 2 * 0.1 + (4 * height + 2 * width) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += mdf10;
        }
        LOGGER.info("Finish calculating outer decoration, MDF_10 price:{}", mdf10);
    }

    public void calcMdf10WithoutTopTransom(int width, int height, int heightTransom) {
        LOGGER.info("Start calculating outer decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for mdf10 without top transom");
        if (height < 1000 || height > 2350)
            throw new UnsupportedDimensions("MDF_10 without top transom", height, width);
        LOGGER.info("MDF_10 without top transom: dimension OK");
        if (height >= 1000 && height <= 2050) {
            BigDecimal bd = new BigDecimal((double)height * heightTransom / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue() * Price.MDF_10.getPriceInUAH() + (width - heightTransom) * height * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((width + height) * 2 * 0.1 + (4 * height + 2 * width) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += mdf10;
        }
        if (height >= 2051 && height <= 2350) {
            BigDecimal bd = new BigDecimal((double)height * heightTransom / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf10 = bd.doubleValue() * Price.MDF_10.getPriceInUAH() + 80 + (width - heightTransom) * height * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((width + height) * 2 * 0.1 + (4 * height + 2 * width) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += mdf10;
        }
        LOGGER.info("Finish calculating outer decoration, MDF_10 price without top transom:{}", mdf10);
    }

    public void calcMdf16(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for mdf16");
        if (height < 1000 || height > 2350)
            throw new UnsupportedDimensions("MDF_16", height, width);
        LOGGER.info("MDF_16: dimension OK");
        if (height >= 1000 && height <= 2050) {
            BigDecimal bd = new BigDecimal((double)width * height / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue() * Price.MDF_16.getPriceInUAH()
                    + ((width + height) * 2 * 0.1 + (4 * height + 2 * width) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += mdf16;
        }
        if (height >= 2051 && height <= 2350) {
            BigDecimal bd = new BigDecimal((double)width * height / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue() * Price.MDF_16.getPriceInUAH() + 40 + ((width + height) * 2 * 0.2 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            totalOuterDecorationPrice += mdf16;
        }
        LOGGER.info("Finish calculating outer decoration, MDF_16 price:{}", mdf16);
    }

    public void calcMdf16WithoutTopTransom(int width, int height, int heightTransom) {
        LOGGER.info("Start calculating outer decoration without top transom");
        clear();
        LOGGER.info("Checking dimensions for mdf16 without top transom");
        if (height < 1000 || height > 2350)
            throw new UnsupportedDimensions("MDF_16 without top transom", height, width);
        LOGGER.info("MDF_16 without top transom: dimension OK");
        if (height >= 1000 && height <= 2050) {
            BigDecimal bd = new BigDecimal((double)height * heightTransom / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue() * Price.MDF_16.getPriceInUAH() + (width - heightTransom) * height * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((width + height) * 2 * 0.1 + (4 * height + 2 * width) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += mdf16;
        }
        if (height >= 2051 && height <= 2350) {
            BigDecimal bd = new BigDecimal((double)height * heightTransom / 1000000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            mdf16 = bd.doubleValue() * Price.MDF_16.getPriceInUAH() + 80 + (width - heightTransom) * height * Price.PAINTING_PF.getPriceInUAH() / 1000000
                    + ((width + height) * 2 * 0.1 + (4 * height + 2 * width) * 0.08) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000;
            totalOuterDecorationPrice += mdf16;
        }
        LOGGER.info("Finish calculating outer decoration, MDF_16 price without top transom:{}", mdf16);
    }
}
