package sample.com.doorder.door.simple;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnsupportedDimensions extends RuntimeException {

    public static final Logger LOGGER = LoggerFactory.getLogger(UnsupportedDimensions.class);

    public UnsupportedDimensions(String stepName, double y, double x) {
        LOGGER.error("Wrong dimensions for {}. Height:{}, width:{}", stepName, y, x);
    }
}
