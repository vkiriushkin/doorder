package sample.com.doorder.door;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public enum Price {

	ANGLE_50x20(0, "price"),
	ANGLE_50x25(0, "price50"),
	PIPE_60x40(0, "price60"),
	PIPE_50x30(0, "price30"),
	PIPE_40x20(0, "price40"),
	PIPE_40x40(0, "price4040"),
	PIPE_25x25(0, "price25"),
	PIPE_20x20(0, "price20"),
	LIST_M2(0, "listm2"),
	LIST_1x2(0, "lprice"),
	LIST_1x2x1_5(0, "lprice15"),
	LIST_1_25x2_5(0, "lm_price"),
	LIST_1_25x2_5x1_5(0, "lm_price15"),
	HINGE(0, "pprice"),
	HEATER(0, "y_price"),
	SEAL(0, "yp_price"),
	ANTI_LAYER(0, "ot_price"),
	START(0, "in_price"),
	PLASTIC(0, "pl_price"),
	LAMINATED_PLASTIC(0, "la_price"),
	MDF_10(0, "m10_price"),
	MDF_16(0, "m16_price"),
	PAINTING_PF(0, "list_pf_price"),
	PAINTING_SHAGREEN(0, "list_mag_price"),
	PAINTING_ANTIC(0, "list_an_price"),
	PLATBAND_WOODEN(0, "dnal_price"),
	PLATBAND_METAL(0, "lit_nal_price"),
	SELF_ADHESIVE_FILM(0, "plenka"),
	OGRASK(0, "ogr"),
	DRYWALL(0, "gips"),
	MINERAL_WOOL(0, "vata"),
    //	PACKAGING(30),

	//accessories
	SPY_HOLE_200(0, "spy200"),
	SPY_HOLE_10_200(0, "spy10200"),

	TOP_LOCKER_KALE_257L(0, "kale257"),
	TOP_LOCKER_KALE_1894(0, "kale189"),
	TOP_LOCKER_ELBOR(0, "elbor"),

	BOTTOM_LOCKER_KALE_25R(0, "kale252"),
	BOTTOM_LOCKER_MOTTURA_54797(0, "mottura"),
	BOTTOM_LOCKER_APECS_2200(0, "apecs2200"),
	BOTTOM_LOCKER_KALE_2000(0, "kale2000"),

	PROTECTOR_APECS(0, "apecsProtector"),

	HANDLE_APECS_CHROME(0, "apecsCrome"),
	HANDLE_APECS_GOLD(0, "apecsGold"),
	HANDLE_APECS_PLAT_CHROME(0, "apecsCromePlank"),
	HANDLE_APECS_PLAT_GOLD(0, "apecsGoldPlank"),
	HANDLE_AYDEMIR_BROWN(0, "aydemirBrown"),
	HANDLE_AYDEMIR_BLACK(0, "aydemirBlack")
    ;

	private double priceInUAH;
    private String shortName;

	Price(double priceInUAH, String shortName) {
		this.priceInUAH = priceInUAH;
        this.shortName = shortName;
	}

	public double getPriceInUAH() {
		return priceInUAH;
	}

    public void setPriceInUAH(double priceInUAH) {
        this.priceInUAH = priceInUAH;
    }

    public String getShortName() {
        return shortName;
    }

    public static Price lookupPriceByShortName(String shortName) {
        for (Price price : Price.values()) {
            if (price.getShortName().equals(shortName))
                return price;
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Price{");
        sb.append("priceInUAH=").append(priceInUAH);
        sb.append(", shortName='").append(shortName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
