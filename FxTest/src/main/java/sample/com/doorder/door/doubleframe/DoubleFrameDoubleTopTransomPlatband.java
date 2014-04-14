package sample.com.doorder.door.doubleframe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.com.doorder.door.Price;
import sample.com.doorder.door.UnsupportedDimensions;
import sample.com.doorder.door.angled.DoubleDoorTopTransom;
import sample.com.doorder.door.angled.Platband;
import sample.com.doorder.door.angled.SingleDoorTopSideTransom;
import sample.com.doorder.door.angled.SingleDoorTopTransom;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleFrameDoubleTopTransomPlatband extends Platband {

    public static final Logger LOGGER = LoggerFactory.getLogger(DoubleFrameDoubleTopTransomPlatband.class);

    @Override
    public void calcMetalPlatbandPaintingPF(int x, int y, Class caller) {
        LOGGER.info("Start calculating platband");
        clear();
        LOGGER.info("Checking dimensions for metal platband painting PF");
        if (y < 1000 || y > 2500)
            throw new UnsupportedDimensions("Metal platband painting PF", y, x);
        LOGGER.info("Metal platband painting PF: dimension OK");
        if (y >= 1000 && y <= 2500) {
            BigDecimal bd = new BigDecimal(((double) 2 * y + x) / 1000 * Price.PLATBAND_METAL.getPriceInUAH()
                    + (2 * y + x) * 0.07 * Price.PAINTING_PF.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            metalPlatbandPaintingPF = bd.doubleValue();
            totalPlatbandPrice += metalPlatbandPaintingPF;
        }
        LOGGER.info("Finish calculating platband, metal platband painting PF price:{}", metalPlatbandPaintingPF);
    }

    @Override
    public void calcMetalPlatbandPaintingShagreen(int x, int y, Class caller) {
        LOGGER.info("Start calculating platband");
        clear();
        LOGGER.info("Checking dimensions for metal platband painting shagreen");
        if (y < 1000 || y > 2500)
            throw new UnsupportedDimensions("Metal platband painting shagreen", y, x);
        LOGGER.info("Metal platband painting shagreen: dimension OK");
        if (y >= 1000 && y <= 2500) {
            BigDecimal bd = new BigDecimal(((double) 2 * y + x) / 1000 * Price.PLATBAND_METAL.getPriceInUAH()
                    + (2 * y + x) * 0.07 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            metalPlatbandPaintingShagreen = bd.doubleValue();
            totalPlatbandPrice += metalPlatbandPaintingShagreen;
        }
        LOGGER.info("Finish calculating platband, metal platband painting shagreen price:{}", metalPlatbandPaintingShagreen);

    }

    @Override
    public void calcMetalPlatbandPaintingAntic(int x, int y, Class caller) {
        LOGGER.info("Start calculating platband");
        clear();
        LOGGER.info("Checking dimensions for metal platband painting antic");
        if (y < 1000 || y > 2500)
            throw new UnsupportedDimensions("Metal platband painting antic", y, x);
        LOGGER.info("Metal platband painting antic: dimension OK");
        if (y >= 1000 && y <= 2500) {
            BigDecimal bd = new BigDecimal(((double) 2 * y + x) / 1000 * Price.PLATBAND_METAL.getPriceInUAH()
                    + (2 * y + x) * 0.07 * Price.PAINTING_ANTIC.getPriceInUAH() / 1000);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            metalPlatbandPaintingAntic = bd.doubleValue();
            totalPlatbandPrice += metalPlatbandPaintingAntic;
        }
        LOGGER.info("Finish calculating platband, metal platband painting antic price:{}", metalPlatbandPaintingAntic);

    }
}