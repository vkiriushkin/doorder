package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.com.doorder.door.Door;
import sample.com.doorder.door.MetalDoor;
import sample.com.doorder.door.LabelNames;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

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

    public VBox step1VBox;
    public Label step1Label;
    public ComboBox<String> doorTypeCombo;
    public ComboBox<String> doorStructureTypeCombo;
    public ComboBox<String> doorComplexityCategoryCombo;
    public ComboBox<String> doorOpeningSideCombo;
    public ImageView selectedDoorImage;
    public TextField x;
    public TextField y;
    public TextField x_1;
    public TextField y_1;
    public TextField x_2;
    public TextField x_3;

    public VBox step2VBox;
    public Label step2Label;
    public ComboBox<String> outerDecorationTypeCombo;
    public ComboBox<String> innerDecorationTypeCombo;
    public TextField outerColor;
    public TextField outerConfiguration;
    public TextField innerColor;
    public TextField innerConfiguration;
    public ComboBox<String> platbandTypeCombo;
    public TextField platbandWidth;

    public VBox step3VBox;
    public Label step3Label;
    public ComboBox<String> shippingCombo;
    public TextField shippingCostInput;
    public ToggleGroup packagingGroup = new ToggleGroup();
    public RadioButton packagingYes;
    public RadioButton packagingNo;
    public ToggleGroup installationGroup = new ToggleGroup();
    public RadioButton installationYes;
    public RadioButton installationNo;

    public VBox step4VBox;
    public Label step4Label;
    public TextField personalName;
    public TextArea personalAddress;
    public TextField personalPhone;
    public TextArea personalNotes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initStepLabels();

        step1VBox.setVisible(true);
        step2VBox.setVisible(false);
        step3VBox.setVisible(false);
        step4VBox.setVisible(false);

        //step1
        doorTypeCombo.getItems().setAll(
                LabelNames.metalDoor,
                LabelNames.fireproofDoor);
        doorTypeCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
                if (newValue.equalsIgnoreCase(LabelNames.metalDoor)) {
                    doorStructureTypeCombo.setDisable(false);
                    updateComplexityCategoryComboBox(LabelNames.metalDoor);
                    updateDoorStructureTypeComboBox();
                }
                if (newValue.equalsIgnoreCase(LabelNames.fireproofDoor)) {
                    doorStructureTypeCombo.setDisable(true);
                    doorComplexityCategoryCombo.getItems().clear();
                    updateComplexityCategoryComboBox(LabelNames.fireproofDoor);
                }
            }
        });
        doorStructureTypeCombo.setDisable(true);

        doorOpeningSideCombo.getItems().setAll(
                LabelNames.leftOpeningDoor,
                LabelNames.rightOpeningDoor
        );

        //step2
        outerDecorationTypeCombo.getItems().setAll(
                LabelNames.outerselfAdhesiveFilm,
                LabelNames.outerantiLayer,
                LabelNames.outerpaintingShagreen,
                LabelNames.outerpaintingAntic,
                LabelNames.outerpaintingPF,
                LabelNames.outermdf10,
                LabelNames.outermdf16
        );
        innerDecorationTypeCombo.getItems().setAll(
                LabelNames.innerPlastic,
                LabelNames.innerLaminatedPlastic,
                LabelNames.innerPaintingPF,
                LabelNames.innerPaintingShagreen,
                LabelNames.innerPaintingAntic,
                LabelNames.innermdf10,
                LabelNames.innermdf16
        );
        platbandTypeCombo.getItems().setAll(
                LabelNames.platbandWooden,
                LabelNames.platbandShagreen,
                LabelNames.platbandPF,
                LabelNames.platbendAntic,
                LabelNames.platbandMdf10,
                LabelNames.platbandMdf16
        );

        //step3
        initStep3();

    }

    private void initStepLabels() {
        //        step1Label.setStyle("#current-step");
        step1Label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Step 1 clicked");
                step2VBox.setVisible(false);
                step3VBox.setVisible(false);
                step4VBox.setVisible(false);
                step1VBox.setVisible(true);
            }
        });

        step2Label.getStyleClass().add("#current-step");
        step2Label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Step 2 clicked");
                step1VBox.setVisible(false);
                step3VBox.setVisible(false);
                step4VBox.setVisible(false);
                step2VBox.setVisible(true);
            }
        });

//        step3Label.setStyle("#step");
        step3Label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Step 3 clicked");
                step1VBox.setVisible(false);
                step2VBox.setVisible(false);
                step4VBox.setVisible(false);
                step3VBox.setVisible(true);
            }
        });

//        step4Label.setStyle("#step");
        step4Label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Step 4 clicked");
                step1VBox.setVisible(false);
                step2VBox.setVisible(false);
                step3VBox.setVisible(false);
                step4VBox.setVisible(true);
            }
        });
    }

    private void initStep3() {
        packagingYes.setToggleGroup(packagingGroup);
        packagingNo.setToggleGroup(packagingGroup);
        installationYes.setToggleGroup(installationGroup);
        installationNo.setToggleGroup(installationGroup);

        shippingCombo.getItems().setAll(
                LabelNames.shippingSelf,
                LabelNames.shippingVendor,
                LabelNames.shippingCompany
        );
    }

    private void updateDoorStructureTypeComboBox() {
        doorStructureTypeCombo.getItems().setAll(
                LabelNames.angledDoor
//                LabelNames.angledDoubleDoor,
//                LabelNames.door40x40,
//                LabelNames.door50x30
        );
    }

    private void updateComplexityCategoryComboBox(String doorType) {
        if (doorType.equalsIgnoreCase(LabelNames.metalDoor)) {
            doorComplexityCategoryCombo.getItems().clear();
            doorComplexityCategoryCombo.getItems().setAll(
                    LabelNames.singleDoor,
                    LabelNames.doubleDoor,
                    LabelNames.singleDoorSideTransom,
                    LabelNames.singleDoorTwoSideTransoms,
                    LabelNames.singleDoorTopTransom,
                    LabelNames.doubleDoorTopTransom,
                    LabelNames.singleDoorTopSideTransoms
            );
        } else if (doorType.equalsIgnoreCase(LabelNames.fireproofDoor)) {
            doorComplexityCategoryCombo.getItems().clear();
            doorComplexityCategoryCombo.getItems().setAll(
                    LabelNames.singleFireProofDoor,
                    LabelNames.doubleFireProofDoor
            );
        }
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

    public void showStepNotification(ActionEvent actionEvent) {
        Label clickedLabel = (Label) actionEvent.getSource();
        System.out.println("Label clicked: " + clickedLabel.getText());
    }

    public void calculateDoorPrice(ActionEvent actionEvent) {
        String resultString = DoorFactory.createDoor(
                doorTypeCombo.getSelectionModel().getSelectedItem(),
                doorStructureTypeCombo.getSelectionModel().getSelectedItem(),
                doorComplexityCategoryCombo.getSelectionModel().getSelectedItem(),
                x, y, x_1, y_1, x_2, x_3, platbandWidth,
                innerDecorationTypeCombo.getSelectionModel().getSelectedItem(),
                outerDecorationTypeCombo.getSelectionModel().getSelectedItem(),
                platbandTypeCombo.getSelectionModel().getSelectedItem()
        );

        Stage stage = new Stage();
        TextArea textArea = new TextArea(resultString);
        textArea.setPrefWidth(300);
        textArea.setPrefHeight(300);
        stage.setHeight(300);
        stage.setWidth(300);
        stage.setScene(new Scene(textArea));
        stage.show();
    }

}
