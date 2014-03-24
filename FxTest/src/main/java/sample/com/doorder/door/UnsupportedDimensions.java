package sample.com.doorder.door;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.Controller;

public class UnsupportedDimensions extends RuntimeException {

    public static final Logger LOGGER = LoggerFactory.getLogger(UnsupportedDimensions.class);

    public UnsupportedDimensions(String stepName, double y, double x) {
        LOGGER.error("Wrong dimensions for {}. Height:{}, width:{}", stepName, y, x);
        Controller.errorLabel.setText("Wrong dimensions for " + stepName + ". Height:" + y + ", width:" + x);
    }

    public UnsupportedDimensions(String stepName, String message, String dimensions) {
        LOGGER.error("Error while calculating {}. Reason: {}. Dimensions: {}", stepName, message, dimensions);
        Controller.errorLabel.setText("Error in "+ stepName
                + ". Reason: " + message
                + ". Dimensions: " + dimensions);
    }
}
