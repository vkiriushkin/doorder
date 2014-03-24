package sample.com.doorder.door.fireproof;


import sample.com.doorder.door.Price;
import sample.com.doorder.door.angled.InnerDecoration;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FireProofInnerDecoration extends InnerDecoration {

    @Override
    public void calcMdf10(int x, int y) {
        super.calcMdf10(x, y);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void calcMdf16(int x, int y) {
        super.calcMdf16(x, y);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void calcPaintingPF(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)x - 40) * (y - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingPF = bd.doubleValue();
        totalInnerDecorationPrice += paintingPF;
        LOGGER.info("Finish calculating inner decoration, painting pf price:{}", paintingPF);
    }

    @Override
    public void calcPaintingShagreen(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)x - 40) * (y - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingShagreen = bd.doubleValue();
        totalInnerDecorationPrice += paintingShagreen;
        LOGGER.info("Finish calculating inner decoration, painting shagreen price:{}", paintingShagreen);
    }

    @Override
    public void calcPaintingAntic(int x, int y) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal(((double)x - 40) * (y - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        paintingAntic = bd.doubleValue();
        totalInnerDecorationPrice += paintingAntic;
        LOGGER.info("Finish calculating inner decoration, painting antic price:{}", paintingAntic);
    }
}
