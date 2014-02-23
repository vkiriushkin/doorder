package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import sample.com.doorder.door.LabelNames;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    public Pane doorTypesPane;
    public AnchorPane doorsAnchorPane;
    public Pane lockerTypesPane;
    public AnchorPane lockerAnchorPane;
    public Pane accessoriesPane;
    public Pane orderPane;

    public Group apecs2000Group;
    public Group kale2000Group;
    public Group metalDoorGroup;
    public Group fireProofGroup;

    public VBox step1;
    public ComboBox<String> doorTypeCombo;
    public ComboBox<String> doorStructureTypeCombo;

    public VBox step2;
    public VBox step3;
    public VBox step4;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        doorTypeCombo.getItems().setAll(
                LabelNames.metalDoor,
                LabelNames.fireproofDoor);
        doorTypeCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
                if (newValue.equalsIgnoreCase(LabelNames.metalDoor))
                        doorStructureTypeCombo.setDisable(false);
                if (newValue.equalsIgnoreCase(LabelNames.fireproofDoor))
                        doorStructureTypeCombo.setDisable(true);
            }
        });
        doorStructureTypeCombo.getItems().setAll(
                LabelNames.angledDoor,
                LabelNames.angledDoubleDoor,
                LabelNames.door40x40,
                LabelNames.door50x30);
        doorStructureTypeCombo.setDisable(true);
    }

    public void showDoorTypesPane(ActionEvent actionEvent) {
        orderPane.setVisible(false);
        lockerTypesPane.setVisible(false);
        doorTypesPane.setVisible(true);
    }

    public void showMetalDoorGroup(ActionEvent actionEvent) {
        fireProofGroup.setVisible(false);
        metalDoorGroup.setVisible(true);
        doorsAnchorPane.setPrefHeight(metalDoorGroup.getLayoutBounds().getHeight());
    }

    public void showFireProofGroup(ActionEvent actionEvent) {
        metalDoorGroup.setVisible(false);
        fireProofGroup.setVisible(true);
        doorsAnchorPane.setPrefHeight(fireProofGroup.getLayoutBounds().getHeight());
        doorsAnchorPane.setMaxHeight(fireProofGroup.getLayoutBounds().getHeight());
    }

    public void showLockerTypesPane(ActionEvent actionEvent) {
        orderPane.setVisible(false);
        doorTypesPane.setVisible(false);
        lockerTypesPane.setVisible(true);
    }

    public void showApecs2000Group(ActionEvent actionEvent) {
        apecs2000Group.setVisible(true);
        lockerAnchorPane.setPrefHeight(apecs2000Group.getLayoutBounds().getHeight());
    }


    public void showOrderPane(ActionEvent actionEvent) {
        doorTypesPane.setVisible(false);
        lockerTypesPane.setVisible(false);
        orderPane.setVisible(true);
    }

}
