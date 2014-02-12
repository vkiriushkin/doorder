package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Controller {

    public Text resultText;
    public TextField userName;
    public PasswordField passwordField;
    public Pane doorTypesPane;
    public ImageView andledDoorImageView;
    public Pane orderPane;

    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        resultText.setText(String.format("%s/%s",userName.getText(),passwordField.getText()));

    }

    public void showOrderPane(ActionEvent actionEvent) {
        orderPane.setVisible(true);
    }

    public void hideOrderPane(ActionEvent actionEvent) {
        orderPane.setVisible(false);
    }


}
