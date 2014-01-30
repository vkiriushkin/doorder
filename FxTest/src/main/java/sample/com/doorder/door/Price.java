package sample.com.doorder.door;

import java.math.BigDecimal;

public enum Price {

    ANGLE_50x20(10.1),
    PIPE_40x20(8.5),
    PIPE_40x40(100),
    PIPE_20x20(6.5),
    LIST_M2(50),
    LIST_1x2(200),
    LIST_1_25x2_5(150),
    HINGE(12),
    HEATER(12),
    SEAL(12),
    ANTI_LAYER(12),
    START(12),
    PLASTIC(112),
    LAMINATED_PLASTIC(150),
    MDF_10(100),
    MDF_16(200),
    PAINTING_PF(30),
    PAINTING_SHAGREEN(70),
    PAINTING_ANTIC(80),
    PLATBAND_WOODEN(10),
    PLATBAND_METAL(20),
    SELF_ADHESIVE_FILM(20);

    private double priceInUAH;

    Price(double priceInUAH) {
        this.priceInUAH = priceInUAH;
    }

    public double getPriceInUAH() {
        return priceInUAH;
    }
}
