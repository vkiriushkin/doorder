package sample.com.doorder.door.simple;

import sample.com.doorder.door.Price;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SingleDoorInnerDecoration extends InnerDecoration {

    @Override
    public void calcPlastic(int width, int height) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        plastic = (4 * width + 2 * height) * 1.1 * Price.START.getPriceInUAH() / 1000 + (width * height) * 1.1 * Price.PLASTIC.getPriceInUAH() / 1000000;
        totalInnerDecorationPrice += plastic;
        LOGGER.info("Finish calculating inner decoration, plastic price:{}", plastic);
    }

	public void calcPlasticWithoutTopTransom(int width, int height, int heightTransom) {
		LOGGER.info("Start calculating inner decoration without top transom");
		clear();
		plastic = (width + heightTransom) * 2.2 * Price.START.getPriceInUAH() / 1000 + ((double)width * heightTransom) * 1.1 * Price.PLASTIC.getPriceInUAH() / 1000000
				+ ((double)height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000;
		totalInnerDecorationPrice += plastic;
		LOGGER.info("Finish calculating inner decoration, plastic price without top transom:{}", plastic);
	}

    @Override
    public void calcLaminate(int width, int height) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        BigDecimal bd = new BigDecimal((4 * width + 2 * height) * 1.1 * Price.START.getPriceInUAH() / 1000 + (width * height) * 1.1 * Price.LAMINATED_PLASTIC.getPriceInUAH() / 1000000);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        laminate = bd.doubleValue();
        totalInnerDecorationPrice += laminate;
        LOGGER.info("Finish calculating inner decoration, laminated plastic price:{}", laminate);
    }

	public void calcLaminateWithoutTopTransom(int width, int height, int heightTransom) {
		LOGGER.info("Start calculating inner decoratio nwithout top transom");
		clear();
		BigDecimal bd = new BigDecimal((width + heightTransom) * 2.2 * Price.START.getPriceInUAH() / 1000 + (width * heightTransom) * 1.1 * Price.LAMINATED_PLASTIC.getPriceInUAH() / 1000000
				+ (height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		laminate = bd.doubleValue();
		totalInnerDecorationPrice += laminate;
		LOGGER.info("Finish calculating inner decoration, laminated plastic price without top transom:{}", laminate);
	}

    public void calcMdf10(int width, int height, int heightTransom) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for mdf10");
        if (heightTransom - 40 < 1000 || heightTransom - 40 > 2350)
            throw new UnsupportedDimensions("MDF_10", height, width);
        LOGGER.info("MDF_10: dimension OK");
        if ((heightTransom - 40) >=1000 && (heightTransom - 40) <= 2050) {
            double material = ((double)(width - 40) * (height - 40)) / 1000000;
            mdf10 = material * Price.MDF_10.getPriceInUAH();
            totalInnerDecorationPrice += mdf10;
        }
        if ((heightTransom - 40) > 2050 && (heightTransom - 40) <= 2350) {
            double material = (double)(width - 40) * (height - 40) / 1000000;
            mdf10 = material * Price.MDF_10.getPriceInUAH() + 40;
            totalInnerDecorationPrice += mdf10;
        }
        LOGGER.info("Finish calculating inner decoration, MDF_10 price:{}", mdf10);
    }

	public void calcMdf10WithoutTopTransom(int width, int height, int heightTransom) {
		LOGGER.info("Start calculating inner decoration without top transom");
		clear();
		LOGGER.info("Checking dimensions for mdf10 without top transom");
		if (heightTransom - 40 < 1000 || heightTransom - 40 > 2350)
			throw new UnsupportedDimensions("MDF_10 without top transom", height, width);
		LOGGER.info("MDF_10 without top transom: dimension OK");
		if ((heightTransom - 40) >=1000 && (heightTransom - 40) <= 2050) {
			double material = ((double)(width - 40) * (heightTransom - 40)) / 1000000;
			mdf10 = material * Price.MDF_10.getPriceInUAH() + (height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000;
			totalInnerDecorationPrice += mdf10;
		}
		if ((heightTransom - 40) > 2050 && (heightTransom - 40) <= 2350) {
			double material = (double)(width - 40) * (heightTransom - 40) / 1000000;
			mdf10 = material * Price.MDF_10.getPriceInUAH() + 40 + (height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000;
			totalInnerDecorationPrice += mdf10;
		}
		LOGGER.info("Finish calculating inner decoration, MDF_10 price without top transom:{}", mdf10);
	}

    public void calcMdf16(int width, int height, int heightTransom) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for mdf16");
        if (heightTransom - 40 < 1000 || heightTransom - 40 > 2350)
            throw new UnsupportedDimensions("MDF_16", height, width);
        LOGGER.info("MDF_16: dimension OK");
        if ((heightTransom - 40) >=1000 && (heightTransom - 40) <= 2050) {
            double material = ((double)(width - 40) * (height - 40)) / 1000000;
            mdf16 = material * Price.MDF_16.getPriceInUAH();
            totalInnerDecorationPrice += mdf16;
        }
        if ((heightTransom - 40) > 2050 && (heightTransom - 40) <= 2350) {
            double material = (double)(width - 40) * (height - 40) / 1000000;
            mdf16 = material * Price.MDF_16.getPriceInUAH() + 40;
            totalInnerDecorationPrice += mdf16;
        }
        LOGGER.info("Finish calculating inner decoration, MDF_16 price:{}", mdf16);
    }

	public void calcMdf16WithoutTopTransom(int width, int height, int heightTransom) {
		LOGGER.info("Start calculating inner decoration without top transom");
		clear();
		LOGGER.info("Checking dimensions for mdf16 without top transom");
		if (heightTransom - 40 < 1000 || heightTransom - 40 > 2350)
			throw new UnsupportedDimensions("MDF_16 without top transom", height, width);
		LOGGER.info("MDF_16 without top transom: dimension OK");
		if ((heightTransom - 40) >=1000 && (heightTransom - 40) <= 2050) {
			double material = ((double)(width - 40) * (heightTransom - 40)) / 1000000;
			mdf16 = material * Price.MDF_16.getPriceInUAH() + (height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000;
			totalInnerDecorationPrice += mdf16;
		}
		if ((heightTransom - 40) > 2050 && (heightTransom - 40) <= 2350) {
			double material = (double)(width - 40) * (heightTransom - 40) / 1000000;
			mdf16 = material * Price.MDF_16.getPriceInUAH() + 40 + (height - heightTransom) * width * Price.PAINTING_PF.getPriceInUAH() / 1000000;
			totalInnerDecorationPrice += mdf16;
		}
		LOGGER.info("Finish calculating inner decoration, MDF_16 price without top transom:{}", mdf16);
	}

    @Override
    public void calcWithoutDecoration(int width, int height) {
        super.calcWithoutDecoration(width, height);
    }

    public void calcPaintingPF(int width, int height, int heightTransom) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting PF");
        if (width - 40 < 500 || width - 40 > 1200 || heightTransom - 40 < 1000 || heightTransom - 40 > 2450)
            throw new UnsupportedDimensions("Painting PF", height, width);
        LOGGER.info("Painting PF: dimension OK");
        if ((width - 40) >= 500 && (width - 40) <= 960 && (heightTransom - 40) >=1000 && (heightTransom - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000 + ((double)height - heightTransom) * width / 1000000 * Price.LIST_M2.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((width - 40) >= 500 && (width - 40) <= 960 && (heightTransom - 40) > 2030 && (heightTransom - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_PF
                    .getPriceInUAH() / 1000000 + ((double)height - heightTransom) * width / 1000000 * Price.LIST_M2.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((width - 40) > 960 && (width - 40) <= 1200 && (heightTransom - 40) >=1000 && (heightTransom - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_PF
                    .getPriceInUAH() / 1000000 + ((double)height - heightTransom) * width / 1000000 * Price.LIST_M2.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        if ((width - 40) > 960 && (width - 40) <= 1200 && (height - 40) > 2030 && (height - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_PF
                    .getPriceInUAH() / 1000000 + ((double)height - heightTransom) * width / 1000000 * Price.LIST_M2.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingPF = bd.doubleValue();
            totalInnerDecorationPrice += paintingPF;
        }
        LOGGER.info("Finish calculating inner decoration, painting PF price:{}", paintingPF);
    }

	public void calcPaintingPFWithoutTopTransom(int width, int height, int heightTransom) {
		LOGGER.info("Start calculating inner decoration without top transom");
		clear();
		LOGGER.info("Checking dimensions for painting PF without top transom");
		if (width - 40 < 500 || width - 40 > 1200 || heightTransom - 40 < 1000 || heightTransom - 40 > 2450)
			throw new UnsupportedDimensions("Painting PF without top transom", height, width);
		LOGGER.info("Painting PF without top transom: dimension OK");
		if ((width - 40) >= 500 && (width - 40) <= 960 && (heightTransom - 40) >=1000 && (heightTransom - 40) <= 2030) {
			BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + ((double)width - 40) * (heightTransom - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000
					+ ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			paintingPF = bd.doubleValue();
			totalInnerDecorationPrice += paintingPF;
		}
		if ((width - 40) >= 500 && (width - 40) <= 960 && (heightTransom - 40) > 2030 && (heightTransom - 40) <= 2450) {
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)width - 40) * (heightTransom - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000
					+ ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			paintingPF = bd.doubleValue();
			totalInnerDecorationPrice += paintingPF;
		}
		if ((width - 40) > 960 && (width - 40) <= 1200 && (heightTransom - 40) >=1000 && (heightTransom - 40) <= 2030) {
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)width - 40) * (heightTransom - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000
					+ ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			paintingPF = bd.doubleValue();
			totalInnerDecorationPrice += paintingPF;
		}
		if ((width - 40) > 960 && (width - 40) <= 1200 && (height - 40) > 2030 && (height - 40) <= 2450) {
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + ((double)width - 40) * (heightTransom - 40) * Price.PAINTING_PF.getPriceInUAH() / 1000000
					+ ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			paintingPF = bd.doubleValue();
			totalInnerDecorationPrice += paintingPF;
		}
		LOGGER.info("Finish calculating inner decoration, painting PF price without top transom:{}", paintingPF);
	}

    public void calcPaintingShagreen(int width, int height, int heightTransom) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting shagreen");
        if (width - 40 < 500 || width - 40 > 1200 || heightTransom - 40 < 1000 || heightTransom - 40 > 2450)
            throw new UnsupportedDimensions("Painting PF", height, width);
        LOGGER.info("Painting shagreen: dimension OK");
        if ((width - 40) >= 500 && (width - 40) <= 960 && (heightTransom - 40) >=1000 && (heightTransom - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + (width - 40) * (heightTransom - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)height - heightTransom) * width / 1000000 * Price.LIST_M2.getPriceInUAH() + ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((width - 40) >= 500 && (width - 40) <= 960 && (heightTransom - 40) > 2030 && (heightTransom - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)height - heightTransom) * width / 1000000 * Price.LIST_M2.getPriceInUAH() + ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((width - 40) > 960 && (width - 40) <= 1200 && (heightTransom - 40) >=1000 && (heightTransom - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)height - heightTransom) * width / 1000000 * Price.LIST_M2.getPriceInUAH() + ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        if ((width - 40) > 960 && (width - 40) <= 1200 && (heightTransom - 40) > 2030 && (heightTransom - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
                    + ((double)height - heightTransom) * width / 1000000 * Price.LIST_M2.getPriceInUAH() + ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingShagreen = bd.doubleValue();
            totalInnerDecorationPrice += paintingShagreen;
        }
        LOGGER.info("Finish calculating inner decoration, painting shagreen price:{}", paintingShagreen);
    }

	public void calcPaintingShagreenWithoutTopTransom(int width, int height, int heightTransom) {
		LOGGER.info("Start calculating inner decoration without top transom");
		clear();
		LOGGER.info("Checking dimensions for painting shagreen without top transom");
		if (width - 40 < 500 || width - 40 > 1200 || heightTransom - 40 < 1000 || heightTransom - 40 > 2450)
			throw new UnsupportedDimensions("Painting PF without top transom", height, width);
		LOGGER.info("Painting shagreen without top transom: dimension OK");
		if ((width - 40) >= 500 && (width - 40) <= 960 && (heightTransom - 40) >=1000 && (heightTransom - 40) <= 2030) {
			BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + (width - 40) * (heightTransom - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
					+ ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			paintingShagreen = bd.doubleValue();
			totalInnerDecorationPrice += paintingShagreen;
		}
		if ((width - 40) >= 500 && (width - 40) <= 960 && (heightTransom - 40) > 2030 && (heightTransom - 40) <= 2450) {
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
					+ ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			paintingShagreen = bd.doubleValue();
			totalInnerDecorationPrice += paintingShagreen;
		}
		if ((width - 40) > 960 && (width - 40) <= 1200 && (heightTransom - 40) >=1000 && (heightTransom - 40) <= 2030) {
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
					+ ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			paintingShagreen = bd.doubleValue();
			totalInnerDecorationPrice += paintingShagreen;
		}
		if ((width - 40) > 960 && (width - 40) <= 1200 && (heightTransom - 40) > 2030 && (heightTransom - 40) <= 2450) {
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (height - 40) * Price.PAINTING_SHAGREEN.getPriceInUAH() / 1000000
					+ ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			paintingShagreen = bd.doubleValue();
			totalInnerDecorationPrice += paintingShagreen;
		}
		LOGGER.info("Finish calculating inner decoration, painting shagreen price without top transom:{}", paintingShagreen);
	}

    public void calcPaintingAntic(int width, int height, int heightTransom) {
        LOGGER.info("Start calculating inner decoration");
        clear();
        LOGGER.info("Checking dimensions for painting antic");
        if (width - 40 < 500 || width - 40 > 1200 || heightTransom - 40 < 1000 || heightTransom - 40 > 2450)
            throw new UnsupportedDimensions("Painting PF", height, width);
        LOGGER.info("Painting antic: dimension OK");
        if ((width - 40) >= 500 && (width - 40) <= 960 && (heightTransom - 40) >=1000 && (heightTransom - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + (width - 40) * (heightTransom - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)height - heightTransom) * width / 1000000 * Price.LIST_M2.getPriceInUAH() + ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((width - 40) >= 500 && (width - 40) <= 960 && (heightTransom - 40) > 2030 && (heightTransom - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (heightTransom - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)height - heightTransom) * width / 1000000 * Price.LIST_M2.getPriceInUAH() + ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((width - 40) > 960 && (width - 40) <= 1200 && (heightTransom - 40) >=1000 && (heightTransom - 40) <= 2030) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (heightTransom - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)height - heightTransom) * width / 1000000 * Price.LIST_M2.getPriceInUAH() + ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        if ((width - 40) > 960 && (width - 40) <= 1200 && (heightTransom - 40) > 2030 && (heightTransom - 40) <= 2450) {
            BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (heightTransom - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
                    + ((double)height - heightTransom) * width / 1000000 * Price.LIST_M2.getPriceInUAH() + ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            paintingAntic = bd.doubleValue();
            totalInnerDecorationPrice += paintingAntic;
        }
        LOGGER.info("Finish calculating inner decoration, painting antic price:{}", paintingAntic);
    }

	public void calcPaintingAnticWithoutTopTransom(int width, int height, int heightTransom) {
		LOGGER.info("Start calculating inner decoration");
		clear();
		LOGGER.info("Checking dimensions for painting antic");
		if (width - 40 < 500 || width - 40 > 1200 || heightTransom - 40 < 1000 || heightTransom - 40 > 2450)
			throw new UnsupportedDimensions("Painting PF", height, width);
		LOGGER.info("Painting antic: dimension OK");
		if ((width - 40) >= 500 && (width - 40) <= 960 && (heightTransom - 40) >=1000 && (heightTransom - 40) <= 2030) {
			BigDecimal bd = new BigDecimal(Price.LIST_1x2.getPriceInUAH() + (width - 40) * (heightTransom - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
					+ ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			paintingAntic = bd.doubleValue();
			totalInnerDecorationPrice += paintingAntic;
		}
		if ((width - 40) >= 500 && (width - 40) <= 960 && (heightTransom - 40) > 2030 && (heightTransom - 40) <= 2450) {
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (heightTransom - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
					+ ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			paintingAntic = bd.doubleValue();
			totalInnerDecorationPrice += paintingAntic;
		}
		if ((width - 40) > 960 && (width - 40) <= 1200 && (heightTransom - 40) >=1000 && (heightTransom - 40) <= 2030) {
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (heightTransom - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
					+ ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			paintingAntic = bd.doubleValue();
			totalInnerDecorationPrice += paintingAntic;
		}
		if ((width - 40) > 960 && (width - 40) <= 1200 && (heightTransom - 40) > 2030 && (heightTransom - 40) <= 2450) {
			BigDecimal bd = new BigDecimal(Price.LIST_1_25x2_5.getPriceInUAH() + (width - 40) * (heightTransom - 40) * Price.PAINTING_ANTIC.getPriceInUAH() / 1000000
					+ ((double)height - heightTransom) * width / 1000000 * Price.PAINTING_PF.getPriceInUAH());
			bd = bd.setScale(2, RoundingMode.HALF_UP);
			paintingAntic = bd.doubleValue();
			totalInnerDecorationPrice += paintingAntic;
		}
		LOGGER.info("Finish calculating inner decoration, painting antic price:{}", paintingAntic);
	}
}
