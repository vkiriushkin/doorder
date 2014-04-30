package sample.com.doorder.door.angled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.com.doorder.door.Price;
import sample.com.doorder.door.UnsupportedDimensions;
import sample.com.doorder.door.armour4040.Armour4040DoubleTopTransomDoor;
import sample.com.doorder.door.armour4040.Armour4040SingleTopTransomDoor;
import sample.com.doorder.door.armour4040.Armour4040SingleTwoSideAndTopTransomDoor;
import sample.com.doorder.door.armour5030.Armour5030DoubleTopTransomDoor;
import sample.com.doorder.door.armour5030.Armour5030SingleTopTransomDoor;
import sample.com.doorder.door.armour5030.Armour5030SingleTwoSideAndTopTransomDoor;
import sample.com.doorder.door.doubleframe.DoubleFrameDoubleTopTransomDoor;
import sample.com.doorder.door.doubleframe.DoubleFrameSingleTopTransomDoor;
import sample.com.doorder.door.doubleframe.DoubleFrameSingleTwoSideAndTopTransomDoor;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Platband {

    public static final Logger LOGGER = LoggerFactory.getLogger(Platband.class);

    protected double woodenPlatband;
    protected double metalPlatbandPaintingPF;
    protected double metalPlatbandPaintingShagreen;
    protected double metalPlatbandPaintingAntic;
    private double mdf10Platband;
    private double mdf16Platband;

    protected double totalPlatbandPrice;

    public void calcWoodenPlatband(int x, int y, Class caller) {
        LOGGER.info("Start calculating platband");
        clear();
        LOGGER.info("Checking dimensions for wooden platband");
        if (y < 1000 || y > 2150)
            throw new UnsupportedDimensions("Wooden platband", y, x);
        LOGGER.info("Wooden platband: dimension OK");
        if (y >= 1000 && y <= 2150) {
            BigDecimal bd = new BigDecimal((2 * y + x) * 1.1 / 1000 * Price.PLATBAND_WOODEN.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            woodenPlatband = bd.doubleValue();
            totalPlatbandPrice += woodenPlatband;
        }
        LOGGER.info("Finish calculating platband, wooden platband price:{}", woodenPlatband);
    }

    public void calcMetalPlatbandPaintingPF(int x, int y, Class caller) {
        LOGGER.info("Start calculating platband");
        clear();
        LOGGER.info("Checking dimensions for metal platband painting PF");
        if (caller.equals(SingleDoorTopTransom.class)
                || caller.equals(DoubleDoorTopTransom.class)
                || caller.equals(SingleDoorTopSideTransom.class)

                || caller.equals(Armour4040DoubleTopTransomDoor.class)
                || caller.equals(Armour4040SingleTopTransomDoor.class)
                || caller.equals(Armour4040SingleTwoSideAndTopTransomDoor.class)

                || caller.equals(Armour5030DoubleTopTransomDoor.class)
                || caller.equals(Armour5030SingleTopTransomDoor.class)
                || caller.equals(Armour5030SingleTwoSideAndTopTransomDoor.class)

                || caller.equals(DoubleFrameDoubleTopTransomDoor.class)
                || caller.equals(DoubleFrameSingleTopTransomDoor.class)
                || caller.equals(DoubleFrameSingleTwoSideAndTopTransomDoor.class)) {

            if (y < 1000 || y > 3000)
                throw new UnsupportedDimensions("Metal platband painting PF", y, x);
            LOGGER.info("Metal platband painting PF: dimension OK");
            if (y >= 1000 && y <= 3000) {
                BigDecimal bd = new BigDecimal(((double) 2 * y + x) * 1.1 / 1000 * Price.PLATBAND_METAL.getPriceInUAH()
                        + (2 * y + x) * 0.07 * Price.PAINTING_PF.getPriceInUAH() / 1000);
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                metalPlatbandPaintingPF = bd.doubleValue();
                totalPlatbandPrice += metalPlatbandPaintingPF;
            }
        } else {
            if (y < 1000 || y > 2500)
                throw new UnsupportedDimensions("Metal platband painting PF", y, x);
            LOGGER.info("Metal platband painting PF: dimension OK");
            if (y >= 1000 && y <= 2500) {
                BigDecimal bd = new BigDecimal(((double) 2 * y + x) * 1.1 / 1000 * Price.PLATBAND_METAL.getPriceInUAH()
                        + (2 * y + x) * 0.07 * Price.PAINTING_PF.getPriceInUAH() / 1000);
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                metalPlatbandPaintingPF = bd.doubleValue();
                totalPlatbandPrice += metalPlatbandPaintingPF;
            }
        }
        LOGGER.info("Finish calculating platband, metal platband painting PF price:{}", metalPlatbandPaintingPF);
    }

    public void calcMetalPlatbandPaintingShagreen(int x, int y, Class caller) {
        LOGGER.info("Start calculating platband");
        clear();
        LOGGER.info("Checking dimensions for metal platband painting shagreen");
        if (caller.equals(SingleDoorTopTransom.class)
                || caller.equals(DoubleDoorTopTransom.class)
                || caller.equals(SingleDoorTopSideTransom.class)) {
            if (y < 1000 || y > 3000)
                throw new UnsupportedDimensions("Metal platband painting shagreen", y, x);
            LOGGER.info("Metal platband painting shagreen: dimension OK");
            if (y >= 1000 && y <= 3000) {
                BigDecimal bd = new BigDecimal(((double) 2 * y + x) * 1.1 / 1000 * Price.PLATBAND_METAL.getPriceInUAH()
                        + (2 * y + x) * 0.07 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                metalPlatbandPaintingShagreen = bd.doubleValue();
                totalPlatbandPrice += metalPlatbandPaintingShagreen;
            }
        } else {
            if (y < 1000 || y > 2500)
                throw new UnsupportedDimensions("Metal platband painting shagreen", y, x);
            LOGGER.info("Metal platband painting shagreen: dimension OK");
            if (y >= 1000 && y <= 2500) {
                BigDecimal bd = new BigDecimal(((double) 2 * y + x) * 1.1 / 1000 * Price.PLATBAND_METAL.getPriceInUAH()
                        + (2 * y + x) * 0.07 * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000);
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                metalPlatbandPaintingShagreen = bd.doubleValue();
                totalPlatbandPrice += metalPlatbandPaintingShagreen;
            }
        }
        LOGGER.info("Finish calculating platband, metal platband painting shagreen price:{}", metalPlatbandPaintingShagreen);
    }

    public void calcMetalPlatbandPaintingAntic(int x, int y, Class caller) {
        LOGGER.info("Start calculating platband");
        clear();
        LOGGER.info("Checking dimensions for metal platband painting antic");
        if (caller.equals(SingleDoorTopTransom.class)
                || caller.equals(DoubleDoorTopTransom.class)
                || caller.equals(SingleDoorTopSideTransom.class)) {
            if (y < 1000 || y > 3000)
                throw new UnsupportedDimensions("Metal platband painting antic", y, x);
            LOGGER.info("Metal platband painting antic: dimension OK");
            if (y >= 1000 && y <= 3000) {
                BigDecimal bd = new BigDecimal(((double) 2 * y + x) * 1.1 / 1000 * Price.PLATBAND_METAL.getPriceInUAH()
                        + (2 * y + x) * 0.07 * Price.PAINTING_ANTIC.getPriceInUAH() / 1000);
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                metalPlatbandPaintingAntic = bd.doubleValue();
                totalPlatbandPrice += metalPlatbandPaintingAntic;
            }
        } else {
            if (y < 1000 || y > 2500)
                throw new UnsupportedDimensions("Metal platband painting antic", y, x);
            LOGGER.info("Metal platband painting antic: dimension OK");
            if (y >= 1000 && y <= 2500) {
                BigDecimal bd = new BigDecimal(((double) 2 * y + x) * 1.1 / 1000 * Price.PLATBAND_METAL.getPriceInUAH()
                        + (2 * y + x) * 0.07 * Price.PAINTING_ANTIC.getPriceInUAH() / 1000);
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                metalPlatbandPaintingAntic = bd.doubleValue();
                totalPlatbandPrice += metalPlatbandPaintingAntic;
            }
        }
        LOGGER.info("Finish calculating platband, metal platband painting antic price:{}", metalPlatbandPaintingAntic);
    }

    public void calcMdf10Platband(int x, int y, int z, Class caller) {
        LOGGER.info("Start calculating platband");
        clear();
        LOGGER.info("Checking dimensions for platband mdf10");
        if (caller.equals(SingleDoorTopTransom.class)
                || caller.equals(DoubleDoorTopTransom.class)
                || caller.equals(SingleDoorTopSideTransom.class)) {
            if (y < 1000 || y > 3000)
                throw new UnsupportedDimensions("Platband mdf10", y, x);
            LOGGER.info("Platband mdf10: dimension OK");
            if (y >= 100 && y <= 3000) {
                if (z >= 30 && z <= 60) {
                    BigDecimal bd = new BigDecimal(((double) 2 * y + x) / 1000 * z * Price.MDF_10.getPriceInUAH() / 1000 + 60);
                    bd = bd.setScale(2, RoundingMode.HALF_UP);
                    mdf10Platband = bd.doubleValue();
                } else if (z > 60 && z <= 100) {
                    BigDecimal bd = new BigDecimal(((double) 2 * y + x) / 1000 * z * Price.MDF_10.getPriceInUAH() / 1000);
                    bd = bd.setScale(2, RoundingMode.HALF_UP);
                    mdf10Platband = bd.doubleValue();
                } else
                    throw new UnsupportedDimensions("Platband mdf10 (platband)", 0, z);
                totalPlatbandPrice += mdf10Platband;
            }
        } else {
            if (y < 1000 || y > 2350)
                throw new UnsupportedDimensions("Platband mdf10", y, x);
            LOGGER.info("Platband mdf10: dimension OK");
            if (y >= 100 && y <= 2350) {
                if (z >= 30 && z <= 60) {
                    BigDecimal bd = new BigDecimal(((double) 2 * y + x) / 1000 * z * Price.MDF_10.getPriceInUAH() / 1000 + 60);
                    bd = bd.setScale(2, RoundingMode.HALF_UP);
                    mdf10Platband = bd.doubleValue();
                } else if (z > 60 && z <= 100) {
                    BigDecimal bd = new BigDecimal(((double) 2 * y + x) / 1000 * z * Price.MDF_10.getPriceInUAH() / 1000);
                    bd = bd.setScale(2, RoundingMode.HALF_UP);
                    mdf10Platband = bd.doubleValue();
                } else
                    throw new UnsupportedDimensions("Platband mdf10 (platband)", 0, z);
                totalPlatbandPrice += mdf10Platband;
            }
        }
        LOGGER.info("Finish calculating platband, platband mdf10:{}", mdf10Platband);
    }

    public void calcMdf16Platband(int x, int y, int z, Class caller) {
        LOGGER.info("Start calculating platband");
        clear();
        LOGGER.info("Checking dimensions for platband mdf16");
        if (caller.equals(SingleDoorTopTransom.class)
                || caller.equals(DoubleDoorTopTransom.class)
                || caller.equals(SingleDoorTopSideTransom.class)) {
            if (y < 1000 || y > 3000)
                throw new UnsupportedDimensions("Platband mdf16", y, x);
            LOGGER.info("Platband mdf16: dimension OK");
            if (y >= 1000 && y <= 3000) {
                if (z >= 30 && z <= 60) {
                    BigDecimal bd = new BigDecimal(((double) 2 * y + x) / 1000 * z * Price.MDF_16.getPriceInUAH() / 1000 + 60);
                    bd = bd.setScale(2, RoundingMode.HALF_UP);
                    mdf16Platband = bd.doubleValue();
                } else if (z > 60 && z <= 100) {
                    BigDecimal bd = new BigDecimal(((double) 2 * y + x) / 1000 * z * Price.MDF_16.getPriceInUAH() / 1000);
                    bd = bd.setScale(2, RoundingMode.HALF_UP);
                    mdf16Platband = bd.doubleValue();
                } else
                    throw new UnsupportedDimensions("Platband mdf16 (platband)", 0, z);
                totalPlatbandPrice += mdf16Platband;
            }
        } else {
            if (y < 1000 || y > 2350)
                throw new UnsupportedDimensions("Platband mdf16", y, x);
            LOGGER.info("Platband mdf16: dimension OK");
            if (y >= 1000 && y <= 2350) {
                if (z >= 30 && z <= 60) {
                    BigDecimal bd = new BigDecimal(((double) 2 * y + x) / 1000 * z * Price.MDF_16.getPriceInUAH() / 1000 + 60);
                    bd = bd.setScale(2, RoundingMode.HALF_UP);
                    mdf16Platband = bd.doubleValue();
                } else if (z > 60 && z <= 100) {
                    BigDecimal bd = new BigDecimal(((double) 2 * y + x) / 1000 * z * Price.MDF_16.getPriceInUAH() / 1000);
                    bd = bd.setScale(2, RoundingMode.HALF_UP);
                    mdf16Platband = bd.doubleValue();
                } else
                    throw new UnsupportedDimensions("Platband mdf16 (platband)", 0, z);
                totalPlatbandPrice += mdf16Platband;
            }
        }
        LOGGER.info("Finish calculating platband, platband mdf16:{}", mdf16Platband);
    }

    public void calcNoPlatband(int x, int y, int z, Class aClass) {
        clear();
    }

    public double getTotalPlatbandPrice() {
        return totalPlatbandPrice;
    }

    public void clear() {
        woodenPlatband = 0;
        metalPlatbandPaintingPF = 0;
        metalPlatbandPaintingShagreen = 0;
        metalPlatbandPaintingAntic = 0;
        mdf10Platband = 0;
        mdf16Platband = 0;
        totalPlatbandPrice = 0;
    }

}
