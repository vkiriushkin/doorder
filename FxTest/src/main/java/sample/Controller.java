package sample;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import javax.swing.*;

public class Controller {

    public Pane doorTypesPane;
    public ImageView andledDoorImageView;
    public Pane orderPane;
    public Group metalDoorGroup;
    public Group fireProofGroup;

    public void showOrderPane(ActionEvent actionEvent) {
        doorTypesPane.setVisible(false);
        orderPane.setVisible(true);
    }

    public void showDoorTypesPane(ActionEvent actionEvent) {
        orderPane.setVisible(false);
        doorTypesPane.setVisible(true);
    }

    public void showMetalDoorGroup(ActionEvent actionEvent) {
        fireProofGroup.setVisible(false);
        metalDoorGroup.setVisible(true);
    }

    public void showFireProofGroup(ActionEvent actionEvent) {
        metalDoorGroup.setVisible(false);
        fireProofGroup.setVisible(true);
    }
}
