package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import price.Decryptor;
import sample.com.doorder.door.LabelNames;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    public static Stage primaryStage;

    public Pane doorTypesPane;
    public Pane angledDoorsPane;
    public Pane fireproofDoorsPane;

    public Pane lockerTypesPane;
    public Pane mainLockerTypesPane;
    public Pane secondaryLockerTypesPane;

    public Pane accessoriesPane;
    public Pane separateHandlersPane;
    public Pane handlersOnPlankPane;
    public Pane armouredPane;
    public Pane spyHolePane;

    public Pane orderPane;

    public VBox step1VBox;
    public Label step1Label;
    public ComboBox<String> doorTypeCombo;
    public ComboBox<String> doorStructureTypeCombo;
    public ComboBox<String> doorComplexityCategoryCombo;
    public Button goToNextStep2Button;
    public static Label brokenPriceLabel;

    public VBox step2VBox;
    public Label step2Label;
    public ComboBox<String> doorOpeningSideCombo;
    public ImageView selectedDoorImage;
    public TextField x;
    public TextField y;
    public TextField x_1;
    public TextField y_1;
    public TextField x_2;
    public TextField x_3;
    public Label xDimensions;
    public Label yDimensions;
    public Label x1Dimensions;
    public Label y1Dimensions;
    public Label x2Dimensions;
    public Label x3Dimensions;
    public Button goToPreviousStep1Button;
    public Button goToNextStep3Button;

    public VBox step3VBox;
    public Label step3Label;
    public ComboBox<String> outerDecorationTypeCombo;
    public ComboBox<String> innerDecorationTypeCombo;
    public ComboBox<String> outerTransomDecorationTypeCombo;
    public ComboBox<String> innerTransomDecorationTypeCombo;
    public TextField outerColor;
    public TextField outerConfiguration;
    public TextField innerColor;
    public TextField innerConfiguration;
    public ComboBox<String> platbandTypeCombo;
    public TextField platbandWidth;
    public Button goToPreviousStep2Button;
    public Button goToNextStep4Button;

    public VBox step4VBox;
    public ComboBox<String> mainLockCombo;
    public ComboBox<String> secondaryLockCombo;
    public ComboBox<String> handleCombo;
    public ComboBox<String> spyHoleCombo;
    public ComboBox<String> armourStrapCombo;
    public Button goToPreviousStep3Button;
    public Button goToNextStep5Button;

    public VBox step5VBox;
    public Label step5Label;
    public ComboBox<String> shippingCombo;
    public TextField shippingCostInput;
    public ToggleGroup packagingGroup = new ToggleGroup();
    public RadioButton packagingYes;
    public RadioButton packagingNo;
    public ToggleGroup installationGroup = new ToggleGroup();
    public RadioButton installationYes;
    public RadioButton installationNo;
    public Button goToPreviousStep4Button;
    public Button goToNextStep6Button;

    public VBox step6VBox;
    public Label step6Label;
    public TextField personalName;
    public TextArea personalAddress;
    public TextField personalPhone;
    public TextArea personalNotes;
    public Button goToPreviousStep5Button;

    public Button createOrderButton;
    public static Label errorLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        decryptPrices();

        step1VBox.setVisible(true);
        step2VBox.setVisible(false);
        step3VBox.setVisible(false);
        step4VBox.setVisible(false);
        step5VBox.setVisible(false);
        step6VBox.setVisible(false);

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
                    updateInnerDecorationComboBox(LabelNames.metalDoor);
                    updatePlatbandComboBox(LabelNames.metalDoor);
                    updateDoorStructureTypeComboBox();
                }
                if (newValue.equalsIgnoreCase(LabelNames.fireproofDoor)) {
                    doorStructureTypeCombo.setDisable(true);
                    doorStructureTypeCombo.getSelectionModel().clearSelection();
                    doorComplexityCategoryCombo.getItems().clear();
                    updateComplexityCategoryComboBox(LabelNames.fireproofDoor);
                    updateInnerDecorationComboBox(LabelNames.fireproofDoor);
                    updatePlatbandComboBox(LabelNames.fireproofDoor);
                }
            }
        });
        doorStructureTypeCombo.setDisable(true);

        doorComplexityCategoryCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
                if (newValue.equalsIgnoreCase(LabelNames.singleDoorTopTransom)
                        || newValue.equalsIgnoreCase(LabelNames.singleDoorSideTransom)
                        || newValue.equalsIgnoreCase(LabelNames.singleDoorTopSideTransoms)
                        || newValue.equalsIgnoreCase(LabelNames.singleDoorTwoSideTransoms)
                        || newValue.equalsIgnoreCase(LabelNames.doubleDoorTopTransom)) {
                    outerTransomDecorationTypeCombo.setDisable(false);
                    innerTransomDecorationTypeCombo.setDisable(false);
                } else {
                    outerTransomDecorationTypeCombo.setDisable(true);
                    innerTransomDecorationTypeCombo.setDisable(true);
                }
            }
        });

        doorOpeningSideCombo.getItems().setAll(
                LabelNames.leftOpeningDoor,
                LabelNames.rightOpeningDoor
        );
        doorOpeningSideCombo.getSelectionModel().selectFirst();
        doorOpeningSideCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
                updateDoorImage();
            }
        });

        //step3
        initStep3();

        //step4
        initStep4();

        //step5
        initStep5();

    }

    private void decryptPrices() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open price");
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            try {
                Scanner scanner = new Scanner(selectedFile);
                while (scanner.hasNext()) {
                    String encryptedString = scanner.nextLine();
                    String key = encryptedString.substring(0, 24);
                    String prices = encryptedString.substring(24, encryptedString.length());
                    System.out.println(key);
                    System.out.println(prices);
                    Decryptor.decrypt(key, prices);

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public void goToNextStep2() {
        step1VBox.setVisible(false);
        step2VBox.setVisible(true);
        //set proper picture of the door
        updateDoorImage();
        //set dimensions limits
        updateDimensions();
    }

    private void updateDoorImage() {
        Image newImage = DoorType.selectDoorBy(doorTypeCombo.getSelectionModel().getSelectedItem(),
                doorStructureTypeCombo.getSelectionModel().getSelectedItem(),
                doorComplexityCategoryCombo.getSelectionModel().getSelectedItem(),
                doorOpeningSideCombo.getSelectionModel().getSelectedItem()).getDoorImage();
        selectedDoorImage.setImage(newImage);
    }

    private void updateDimensions() {
        DoorType doorType = DoorType.selectDoorBy(doorTypeCombo.getSelectionModel().getSelectedItem(),
                doorStructureTypeCombo.getSelectionModel().getSelectedItem(),
                doorComplexityCategoryCombo.getSelectionModel().getSelectedItem(),
                doorOpeningSideCombo.getSelectionModel().getSelectedItem());
        xDimensions.setText("От " + doorType.getMinX() + " до " + doorType.getMaxX());
        yDimensions.setText("От " + doorType.getMinY() + " до " + doorType.getMaxY());

        x1Dimensions.setText("");
        y1Dimensions.setText("");
        x2Dimensions.setText("");
        x3Dimensions.setText("");

        if (doorType.getMinX1() == 0 && doorType.getMaxX1() == 0)
            x_1.setDisable(true);
        else {
            x_1.setDisable(false);
            x1Dimensions.setText("От " + doorType.getMinX1() + " до " + doorType.getMaxX1());
        }

        if (doorType.getMinY1() == 0 && doorType.getMaxY1() == 0)
            y_1.setDisable(true);
        else {
            y_1.setDisable(false);
            y1Dimensions.setText("От " + doorType.getMinY1() + " до " + doorType.getMaxY1());
        }

        if (doorType.getMinX2() == 0 && doorType.getMaxX2() == 0)
            x_2.setDisable(true);
        else {
            x_2.setDisable(false);
            x2Dimensions.setText("От " + doorType.getMinX2() + " до " + doorType.getMaxX2());
        }

        if (doorType.getMinX3() == 0 && doorType.getMaxX3() == 0)
            x_3.setDisable(true);
        else {
            x_3.setDisable(false);
            x3Dimensions.setText("От " + doorType.getMinX3() + " до " + doorType.getMaxX3());
        }

        if (doorType.equals(DoorType.ANGLED_SINGLE_TWO_SIDE_LEFT)
                || doorType.equals(DoorType.ANGLED_SINGLE_TWO_SIDE_RIGHT)
                || doorType.equals(DoorType.ANGLED_SINGLE_TOP_SIDE_LEFT)
                || doorType.equals(DoorType.ANGLED_SINGLE_TOP_SIDE_RIGHT)) {
            x_2.setDisable(false);
            x_3.setDisable(false);
        }
    }

    public void goToNextStep3() {
        step2VBox.setVisible(false);
        step3VBox.setVisible(true);
    }
    public void goToNextStep4() {
        step3VBox.setVisible(false);
        step4VBox.setVisible(true);
    }
    public void goToNextStep5() {
        step4VBox.setVisible(false);
        step5VBox.setVisible(true);
    }
    public void goToNextStep6() {
        step5VBox.setVisible(false);
        step6VBox.setVisible(true);
    }
    public void goToPreviousStep1() {
        step2VBox.setVisible(false);
        step1VBox.setVisible(true);
    }
    public void goToPreviousStep2() {
        step3VBox.setVisible(false);
        step2VBox.setVisible(true);
    }
    public void goToPreviousStep3() {
        step4VBox.setVisible(false);
        step3VBox.setVisible(true);
    }
    public void goToPreviousStep4() {
        step5VBox.setVisible(false);
        step4VBox.setVisible(true);
    }

    public void goToPreviousStep5() {
        step6VBox.setVisible(false);
        step5VBox.setVisible(true);
    }

    private void initStep3() {
        outerDecorationTypeCombo.getItems().setAll(
                LabelNames.outerselfAdhesiveFilm,
                LabelNames.outerantiLayer,
                LabelNames.outerpaintingShagreen,
                LabelNames.outerpaintingAntic,
                LabelNames.outerpaintingPF,
                LabelNames.outermdf10,
                LabelNames.outermdf16
        );
        outerDecorationTypeCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue.equals(LabelNames.outerselfAdhesiveFilm)
                        || newValue.equals(LabelNames.outerantiLayer)
                        || newValue.equals(LabelNames.outerpaintingShagreen)
                        || newValue.equals(LabelNames.outerpaintingAntic)
                        || newValue.equals(LabelNames.outerpaintingPF)) {
                    outerColor.setDisable(false);
                    outerConfiguration.setDisable(true);
                } else if(newValue.equals(LabelNames.outermdf10)
                        || newValue.equals(LabelNames.outermdf16)) {
                    outerColor.setDisable(false);
                    outerConfiguration.setDisable(false);
                }
            }
        });

        outerTransomDecorationTypeCombo.getItems().setAll(
            LabelNames.outerWithTransomDecoration,
            LabelNames.outerNoTransomDecoration
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
        innerDecorationTypeCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue.equals(LabelNames.innerPaintingPF)
                        || newValue.equals(LabelNames.innerPaintingShagreen)
                        || newValue.equals(LabelNames.innerPaintingAntic)) {
                    innerColor.setDisable(false);
                    innerConfiguration.setDisable(true);
                } else if(newValue.equals(LabelNames.innermdf10)
                        || newValue.equals(LabelNames.innermdf16)) {
                    innerColor.setDisable(false);
                    innerConfiguration.setDisable(false);
                }
            }
        });

        innerTransomDecorationTypeCombo.getItems().setAll(
                LabelNames.innerWithTransomDecoration,
                LabelNames.innerNoTransomDecoration
        );

        platbandTypeCombo.getItems().setAll(
                LabelNames.platbandWooden,
                LabelNames.platbandShagreen,
                LabelNames.platbandPF,
                LabelNames.platbendAntic,
                LabelNames.platbandMdf10,
                LabelNames.platbandMdf16
        );
        platbandTypeCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue.equals(LabelNames.platbandMdf10)
                        || newValue.equals(LabelNames.platbandMdf16)) {
                    platbandWidth.setDisable(false);
                } else
                    platbandWidth.setDisable(true);
            }
        });

        innerColor.setDisable(true);
        outerColor.setDisable(true);
        innerConfiguration.setDisable(true);
        outerConfiguration.setDisable(true);
        platbandWidth.setDisable(true);
    }

    private void initStep4() {
        mainLockCombo.getItems().setAll(
                LabelNames.kale257,
                LabelNames.kale189,
                LabelNames.elbor
        );

        secondaryLockCombo.getItems().setAll(
                LabelNames.kale252,
                LabelNames.mottura,
                LabelNames.apecs2200,
                LabelNames.kale2000,
                LabelNames.noSecondaryLock
        );

        handleCombo.getItems().setAll(
                LabelNames.apecsCrome,
                LabelNames.apecsGold,
                LabelNames.apecsCromePlank,
                LabelNames.apecsGoldPlank,
                LabelNames.aydemirBrown,
                LabelNames.aydemirBlack
        );

        armourStrapCombo.getItems().setAll(
                LabelNames.apecsProtector,
                LabelNames.noProtector
                );

        spyHoleCombo.getItems().setAll(
                LabelNames.spy200,
                LabelNames.spy10200,
                LabelNames.noSpy
        );
    }

    private void initStep5() {
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
                LabelNames.angledDoor,
                LabelNames.angledDoubleDoor,
                LabelNames.door40x40
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

    private void updateInnerDecorationComboBox(String doorType) {
        if (doorType.equalsIgnoreCase(LabelNames.metalDoor)) {
            innerDecorationTypeCombo.getItems().clear();
            innerDecorationTypeCombo.getItems().setAll(
                    LabelNames.innerPlastic,
                    LabelNames.innerLaminatedPlastic,
                    LabelNames.innerPaintingPF,
                    LabelNames.innerPaintingShagreen,
                    LabelNames.innerPaintingAntic,
                    LabelNames.innermdf10,
                    LabelNames.innermdf16,
                    LabelNames.innerNoTransomDecoration
            );
        } else if (doorType.equalsIgnoreCase(LabelNames.fireproofDoor)) {
            innerDecorationTypeCombo.getItems().clear();
            innerDecorationTypeCombo.getItems().setAll(
                    LabelNames.innerPaintingPF,
                    LabelNames.innerPaintingShagreen,
                    LabelNames.innerPaintingAntic,
                    LabelNames.innermdf10,
                    LabelNames.innermdf16
            );
        }
    }

    private void updatePlatbandComboBox(String doorType) {
        if (doorType.equalsIgnoreCase(LabelNames.metalDoor)) {
            platbandTypeCombo.getItems().clear();
            platbandTypeCombo.getItems().setAll(
                    LabelNames.platbandWooden,
                    LabelNames.platbandShagreen,
                    LabelNames.platbandPF,
                    LabelNames.platbendAntic,
                    LabelNames.platbandMdf10,
                    LabelNames.platbandMdf16
            );
        } else if (doorType.equalsIgnoreCase(LabelNames.fireproofDoor)) {
            platbandTypeCombo.getItems().clear();
            platbandTypeCombo.getItems().setAll(
                    LabelNames.platbandShagreen,
                    LabelNames.platbandPF,
                    LabelNames.platbendAntic
            );
        }
    }

    public void showLockerTypesPane(ActionEvent actionEvent) {
        orderPane.setVisible(false);
        doorTypesPane.setVisible(false);
        accessoriesPane.setVisible(false);
        lockerTypesPane.setVisible(true);
    }

    public void showMainLockersPane(ActionEvent actionEvent) {
        secondaryLockerTypesPane.setVisible(false);
        mainLockerTypesPane.setVisible(true);
    }

    public void showSecondaryLockersPane(ActionEvent actionEvent) {
        mainLockerTypesPane.setVisible(false);
        secondaryLockerTypesPane.setVisible(true);
    }

    public static void showBrokenPriceLabel() {
        brokenPriceLabel.setVisible(true);
    }

    public void showDoorTypesPane(ActionEvent actionEvent) {
        orderPane.setVisible(false);
        accessoriesPane.setVisible(false);
        lockerTypesPane.setVisible(false);
        doorTypesPane.setVisible(true);
    }

    public void showMetalDoorPane(ActionEvent actionEvent) {
        fireproofDoorsPane.setVisible(false);
        angledDoorsPane.setVisible(true);
    }

    public void showFireProofPane(ActionEvent actionEvent) {
        angledDoorsPane.setVisible(false);
        fireproofDoorsPane.setVisible(true);
    }

    public void showOrderPane(ActionEvent actionEvent) {
        lockerTypesPane.setVisible(false);
        accessoriesPane.setVisible(false);
        doorTypesPane.setVisible(false);
        orderPane.setVisible(true);
    }

    public void showAccessoriesPane(ActionEvent actionEvent) {
        lockerTypesPane.setVisible(false);
        doorTypesPane.setVisible(false);
        orderPane.setVisible(false);
        accessoriesPane.setVisible(true);
    }

    public void showSeparateHandlersPane(ActionEvent actionEvent) {
        handlersOnPlankPane.setVisible(false);
        armouredPane.setVisible(false);
        spyHolePane.setVisible(false);
        separateHandlersPane.setVisible(true);
    }

    public void showHandlersOnPanePane(ActionEvent actionEvent) {
        separateHandlersPane.setVisible(false);
        armouredPane.setVisible(false);
        spyHolePane.setVisible(false);
        handlersOnPlankPane.setVisible(true);
    }

    public void showArmourPane(ActionEvent actionEvent) {
        separateHandlersPane.setVisible(false);
        spyHolePane.setVisible(false);
        handlersOnPlankPane.setVisible(false);
        armouredPane.setVisible(true);
    }

    public void showSpyHolePane(ActionEvent actionEvent) {
        separateHandlersPane.setVisible(false);
        armouredPane.setVisible(false);
        handlersOnPlankPane.setVisible(false);
        spyHolePane.setVisible(true);
    }

    public void calculateDoorPrice(ActionEvent actionEvent) {
        errorLabel.setText("");
        String resultString = DoorFactory.createDoor(
                doorTypeCombo.getSelectionModel().getSelectedItem(),
                doorStructureTypeCombo.getSelectionModel().getSelectedItem(),
                doorComplexityCategoryCombo.getSelectionModel().getSelectedItem(),
                x, y, x_1, y_1, x_2, x_3, platbandWidth,
                innerDecorationTypeCombo.getSelectionModel().getSelectedItem(),
                outerDecorationTypeCombo.getSelectionModel().getSelectedItem(),
                innerTransomDecorationTypeCombo.getSelectionModel().getSelectedItem(),
                outerTransomDecorationTypeCombo.getSelectionModel().getSelectedItem(),
                platbandTypeCombo.getSelectionModel().getSelectedItem()
//                mainLockCombo.getSelectionModel().getSelectedItem(),
//                secondaryLockCombo.getSelectionModel().getSelectedItem(),
//                handleCombo.getSelectionModel().getSelectedItem(),
//                armourStrapCombo.getSelectionModel().getSelectedItem(),
//                spyHoleCombo.getSelectionModel().getSelectedItem()
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
