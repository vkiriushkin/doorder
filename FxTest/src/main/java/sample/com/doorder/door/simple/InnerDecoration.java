package sample.com.doorder.door.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InnerDecoration {

    public static final Logger LOGGER = LoggerFactory.getLogger(InnerDecoration.class);

    private double plastic;
    private double laminate;
    private double mdf10;
    private double mdf16;
    private double withoutDecoration;
    private double paintingPF;
    private double paintingShagreen;
    private double paintingAntic;
    private double totalInnerDecorationPrice;

    public InnerDecoration() {
    }

    public void calcPlastic(int width, int height) {

    }

    public void calcLaminate(int width, int height) {

    }

    public void calcMdf10(int width, int height) {

    }

    public void calcMdf16(int width, int height) {

    }

    public void calcWithoutDecoration(int width, int height) {

    }

    public void calcPaintingPF(int width, int height) {

    }

    public void calcPaintingShagreen(int width, int height) {

    }

    public void calcPaintingAntic(int width, int height) {

    }

    private void clear() {
        plastic = 0;
        laminate = 0;
        mdf10 = 0;
        mdf16 = 0;
        withoutDecoration = 0;
        paintingPF = 0;
        paintingShagreen = 0;
        paintingAntic = 0;
        totalInnerDecorationPrice = 0;
    }

    public double getTotalInnerDecorationPrice() {
        return totalInnerDecorationPrice;
    }
}
