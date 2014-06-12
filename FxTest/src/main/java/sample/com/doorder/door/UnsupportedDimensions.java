package sample.com.doorder.door;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.Controller;

public class UnsupportedDimensions extends RuntimeException {

    public static final Logger LOGGER = LoggerFactory.getLogger(UnsupportedDimensions.class);

    public UnsupportedDimensions(String message) {
        LOGGER.error(message);
        Controller.errorLabel.setText(message);
        Controller.errorLabelOrderPane.setText(message);
    }

    public UnsupportedDimensions(String stepName, double y, double x) {
        LOGGER.error("Wrong dimensions for {}. Height:{}, width:{}", stepName, y, x);
        Controller.errorLabel.setText("Неправильный размер для " + stepName + ". y:" + y + ", x:" + x);
        Controller.errorLabelOrderPane.setText("Неправильный размер для " + stepName + ". y:" + y + ", x:" + x);
    }

    public UnsupportedDimensions(String stepName, String message, String dimensions) {
        LOGGER.error("Error while calculating {}. Reason: {}. Dimensions: {}", stepName, message, dimensions);
        Controller.errorLabel.setText("Error in "+ stepName + ". Reason: " + message + ". Dimensions: " + dimensions);
        Controller.errorLabelOrderPane.setText("Error in "+ stepName + ". Reason: " + message + ". Dimensions: " + dimensions);
    }
}
