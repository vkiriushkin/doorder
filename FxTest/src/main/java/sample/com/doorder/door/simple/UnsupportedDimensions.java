package sample.com.doorder.door.simple;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnsupportedDimensions extends RuntimeException {

    public static final Logger LOGGER = LoggerFactory.getLogger(UnsupportedDimensions.class);

    public UnsupportedDimensions(String stepName, double height, double width) {
        LOGGER.error("Wrong dimensions for {}. Height:{}, width:{}", stepName, height, width);
    }
}
