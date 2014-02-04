package sample.com.doorder.door.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.com.doorder.door.Price;

public class OuterDecoration {

    public static final Logger LOGGER = LoggerFactory.getLogger(OuterDecoration.class);

    private double selfAdhesiveFilm;
    private double paintingShagreen;
    private double paintingAntic;
    private double paintingPF;
    private double antiLayer;
    private double mdf10;
    private double mdf16;
    private double totalOuterDecorationPrice;

    public OuterDecoration() {
    }

    public void calcSelfAdhesiveFilm(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        LOGGER.info("Checking dimensions for self adhesive film");
        if (width < 500 || width > 1200)
            throw new UnsupportedDimensions("Self adhesive film", height, width);
        LOGGER.info("Self adhesive film: dimension OK");
        if (width > 499 && width < 801) {
            selfAdhesiveFilm = 1.1 * height / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH();
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        if (width > 800 && width < 1201) {
            selfAdhesiveFilm = 1.1 * 1.5 * height / 1000 * Price.SELF_ADHESIVE_FILM.getPriceInUAH();
            totalOuterDecorationPrice += selfAdhesiveFilm;
        }
        LOGGER.info("Finish calculating outer decoration, self adhesive film price:{}", selfAdhesiveFilm);
    }

    public void calcPaintingShagreen(int width, int height) {
        LOGGER.info("Start calculating outer decoration");
        clear();
        paintingShagreen = ((width * height) / 1000000 + (width + height) * 2 * 0.16 / 1000) * Price.PAINTING_SHAGREEN.getPriceInUAH();
        totalOuterDecorationPrice += paintingShagreen;
        LOGGER.info("Finish calculating outer decoration, painting shagreen price:{}", paintingShagreen);
    }

    public void calcPaintingAntic(int width, int height) {
        clear();
    }

    public void calcPaintinPF(int width, int height) {
        clear();
    }

    public void calcAntiLayer(int width, int height) {
        clear();
    }

    public void calcMdf10(int width, int height) {
        clear();
    }

    public void calcMdf16(int width, int height) {
        clear();
    }

    public void clear() {
        selfAdhesiveFilm = 0;
        paintingShagreen = 0;
        paintingAntic = 0;
        paintingPF = 0;
        antiLayer = 0;
        mdf10 = 0;
        mdf16 = 0;
    }

    public double getTotalOuterDecorationPrice() {
        return totalOuterDecorationPrice;
    }
}
