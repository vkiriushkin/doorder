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
    SHIPPING(130, "shipping"),

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
	HANDLE_AYDEMIR_BLACK(0, "aydemirBlack"),

    MANUFACTURINGCOSTS(0, "manufacturingCosts"),
    PACKAGING(0, "packaging"),
    FIREPROOFINSTALLATION(0, "fireproofInstallation"),
    CLOSER(0, "closer"),

    ANGLEDSINGLE(0, "angledSingle"),
    ANGLEDSINGLETOP(0, "angledSingleTop"),
    ANGLEDSINGLESIDE(0, "angledSingleSide"),
    ANGLEDSINGLETWOSIDE(0, "angledSingleTwoSide"),
    ANGLEDSINGLETOPSIDE(0, "angledSingleTopSide"),
    ANGLEDDOUBLE(0, "angledDouble"),
    ANGLEDDOUBLETOP(0, "angledDoubleTop"),

    DOUBLEFRAMESINGLE(0, "doubleFrameSingle"),
    DOUBLEFRAMESINGLETOP(0, "doubleFrameSingleTop"),
    DOUBLEFRAMESINGLESIDE(0, "doubleFrameSingleSide"),
    DOUBLEFRAMESINGLETWOSIDE(0, "doubleFrameSingleTwoSide"),
    DOUBLEFRAMESINGLETOPSIDE(0, "doubleFrameSingleTopSide"),
    DOUBLEFRAMEDOUBLE(0, "doubleFrameDouble"),
    DOUBLEFRAMEDOUBLETOP(0, "doubleFrameDoubleTop"),

    ANGLED40X40SINGLE(0, "angled40x40Single"),
    ANGLED40X40SINGLETOP(0, "angled40x40SingleTop"),
    ANGLED40X40SINGLESIDE(0, "angled40x40SingleSide"),
    ANGLED40X40SINGLETWOSIDE(0, "angled40x40SingleTwoSide"),
    ANGLED40X40SINGLETOPSIDE(0, "angled40x40SingleTopSide"),
    ANGLED40X40DOUBLE(0, "angled40x40Double"),
    ANGLED40X40DOUBLETOP(0, "angled40x40DoubleTop"),

    ANGLED50X30SINGLE(0, "angled50x30Single"),
    ANGLED50X30SINGLETOP(0, "angled50x30SingleTop"),
    ANGLED50X30SINGLESIDE(0, "angled50x30SingleSide"),
    ANGLED50X30SINGLETWOSIDE(0, "angled50x30SingleTwoSide"),
    ANGLED50X30SINGLETOPSIDE(0, "angled50x30SingleTopSide"),
    ANGLED50X30DOUBLE(0, "angled50x30Double"),
    ANGLED50X30DOUBLETOP(0, "angled50x30DoubleTop"),

    FIREPROOFSINGLE(0, "fireproofSingle"),
    FIREPROOFDOUBLE(0, "fireproofDouble"),

    ANGLEDSINGLEWORK(0, "angledSingleWork"),
    ANGLEDSINGLETOPWORK(0, "angledSingleTopWork"),
    ANGLEDSINGLESIDEWORK(0, "angledSingleSideWork"),
    ANGLEDSINGLETWOSIDEWORK(0, "angledSingleTwoSideWork"),
    ANGLEDSINGLETOPSIDEWORK(0, "angledSingleTopSideWork"),
    ANGLEDDOUBLEWORK(0, "angledDoubleWork"),
    ANGLEDDOUBLETOPWORK(0, "angledDoubleTopWork"),

    DOUBLEFRAMESINGLEWORK(0, "doubleFrameSingleWork"),
    DOUBLEFRAMESINGLETOPWORK(0, "doubleFrameSingleTopWork"),
    DOUBLEFRAMESINGLESIDEWORK(0, "doubleFrameSingleSideWork"),
    DOUBLEFRAMESINGLETWOSIDEWORK(0, "doubleFrameSingleTwoSideWork"),
    DOUBLEFRAMESINGLETOPSIDEWORK(0, "doubleFrameSingleTopSideWork"),
    DOUBLEFRAMEDOUBLEWORK(0, "doubleFrameDoubleWork"),
    DOUBLEFRAMEDOUBLETOPWORK(0, "doubleFrameDoubleTopWork"),

    ANGLED40X40SINGLEWORK(0, "angled40x40SingleWork"),
    ANGLED40X40SINGLETOPWORK(0, "angled40x40SingleTopWork"),
    ANGLED40X40SINGLESIDEWORK(0, "angled40x40SingleSideWork"),
    ANGLED40X40SINGLETWOSIDEWORK(0, "angled40x40SingleTwoSideWork"),
    ANGLED40X40SINGLETOPSIDEWORK(0, "angled40x40SingleTopSideWork"),
    ANGLED40X40DOUBLEWORK(0, "angled40x40DoubleWork"),
    ANGLED40X40DOUBLETOPWORK(0, "angled40x40DoubleTopWork"),

    ANGLED50X30SINGLEWORK(0, "angled50x30SingleWork"),
    ANGLED50X30SINGLETOPWORK(0, "angled50x30SingleTopWork"),
    ANGLED50X30SINGLESIDEWORK(0, "angled50x30SingleSideWork"),
    ANGLED50X30SINGLETWOSIDEWORK(0, "angled50x30SingleTwoSideWork"),
    ANGLED50X30SINGLETOPSIDEWORK(0, "angled50x30SingleTopSideWork"),
    ANGLED50X30DOUBLEWORK(0, "angled50x30DoubleWork"),
    ANGLED50X30DOUBLETOPWORK(0, "angled50x30DoubleTopWork"),

    FIREPROOFSINGLEWORK(0, "fireproofSingleWork"),
    FIREPROOFDOUBLEWORK(0, "fireproofDoubleWork")
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
