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

    public Pane decorationTypesPane;
    public Pane innerDecorationTypesPane;
    public Pane outerDecorationTypesPane;

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
    public Label wrongDimensionsLabel;
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
    public Label step4Label;
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

    //settings
    public Pane settingsPane;
    public TextField profitPercent;
    public TextArea contactInformation;
    public Button saveSettingsButton;

    //errorLabels
    //step1
    public Label doorTypeErrorLabel;
    //step2
    public Label doorDimensionsErrorLabel;
    //step3
    public Label decorationTypeErrorLabel;
    //step4
    public Label accessoriesErrorLabel;
    //step5
    public Label optionalServicesErrorlabel;
    //step6
    public Label customerInformationErrorLabel;

    //locks price labels
    public Label apecs2200PriceLabel;
    public Label kale2000PriceLabel;
    public Label kale252PriceLabel;
    public Label motturaPriceLabel;

    public Label kale189PriceLabel;
    public Label elborPriceLabel;
    public Label kale257PriceLabel;

    //accessories price labels
    public Label apecsProtectorPrice;
    public Label apecsCromePrice;
    public Label apecsGoldPrice;
    public Label apecsCromePlankPrice;
    public Label apecsGoldPlankPrice;
    public Label aydemirBrownPrice;
    public Label aydemirBlackPrice;
    public Label spy200Price;
    public Label spy10200Price;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        decryptPrices();

        apecs2200PriceLabel.setText(LabelNames.apecs2200Price);
        kale2000PriceLabel.setText(LabelNames.kale2000Price);
        kale252PriceLabel.setText(LabelNames.kale252Price);
        motturaPriceLabel.setText(LabelNames.motturaPrice);

        kale189PriceLabel.setText(LabelNames.kale189Price);
        elborPriceLabel.setText(LabelNames.elborPrice);
        kale257PriceLabel.setText(LabelNames.kale257Price);

        apecsProtectorPrice.setText(LabelNames.apecsProtectorPrice);
        apecsCromePrice.setText(LabelNames.apecsCromePrice);
        apecsGoldPrice.setText(LabelNames.apecsGoldPrice);
        apecsCromePlankPrice.setText(LabelNames.apecsCromePlankPrice);
        apecsGoldPlankPrice.setText(LabelNames.apecsGoldPlankPrice);
        aydemirBrownPrice.setText(LabelNames.aydemirBrownPrice);
        aydemirBlackPrice.setText(LabelNames.aydemirBlackPrice);
        spy200Price.setText(LabelNames.spy200Price);
        spy10200Price.setText(LabelNames.spy10200Price);

        step1VBox.setVisible(true);
        step2VBox.setVisible(false);
        step3VBox.setVisible(false);
        step4VBox.setVisible(false);
        step5VBox.setVisible(false);
        step6VBox.setVisible(false);

        //step1
        step1Label.setStyle("-fx-background-color: #8bc8ef");
        doorTypeCombo.getItems().setAll(
                LabelNames.metalDoor,
                LabelNames.fireproofDoor);
        doorTypeCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
                clearAllSteps();
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

        doorStructureTypeCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
                clearAllSteps();
                if (newValue != null )
                    updateInnerDecorationComboBoxNoMDF(newValue);
            }
        });

        doorComplexityCategoryCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
                clearAllSteps();
                if (newValue != null && (newValue.equalsIgnoreCase(LabelNames.singleDoorTopTransom)
                        || newValue.equalsIgnoreCase(LabelNames.singleDoorSideTransom)
                        || newValue.equalsIgnoreCase(LabelNames.singleDoorTopSideTransoms)
                        || newValue.equalsIgnoreCase(LabelNames.singleDoorTwoSideTransoms)
                        || newValue.equalsIgnoreCase(LabelNames.doubleDoorTopTransom))) {
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

        //step2
        initStep2();

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
        step1Label.setStyle("-fx-background-color: #e39a20");
        step2Label.setStyle("-fx-background-color: #8bc8ef");
        doorTypeErrorLabel.setText("");
        ComboBox<String> wrongCombobox = step1ValuesValidated();
        if (wrongCombobox == null) {
            step1VBox.setVisible(false);
            step2VBox.setVisible(true);
            //set proper picture of the door
            updateDoorImage();
            //set dimensions limits
            updateDimensions();
        } else {
            if (wrongCombobox == doorTypeCombo)
                doorTypeErrorLabel.setText("Не выбран тип дверного блока");
            if (wrongCombobox == doorStructureTypeCombo)
                doorTypeErrorLabel.setText("Не выбран тип конструкции");
            if (wrongCombobox == doorComplexityCategoryCombo)
                doorTypeErrorLabel.setText("Не выбрана категория сложности");
        }
    }

    private ComboBox<String> step1ValuesValidated() {
        if (doorTypeCombo.getSelectionModel().getSelectedItem() == null)
            return doorTypeCombo;
        else if (!doorStructureTypeCombo.isDisabled() && doorStructureTypeCombo.getSelectionModel().getSelectedItem() == null)
            return doorStructureTypeCombo;
        else if (doorComplexityCategoryCombo.getSelectionModel().getSelectedItem() == null)
            return doorComplexityCategoryCombo;
        else
            return null;
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
                || doorType.equals(DoorType.ANGLED_SINGLE_TOP_SIDE_RIGHT)
                || doorType.equals(DoorType.DOUBLEFRAME_SINGLE_TWO_SIDE_LEFT)
                || doorType.equals(DoorType.DOUBLEFRAME_SINGLE_TWO_SIDE_RIGHT)
                || doorType.equals(DoorType.DOUBLEFRAME_SINGLE_TOP_SIDE_LEFT)
                || doorType.equals(DoorType.DOUBLEFRAME_SINGLE_TOP_SIDE_RIGHT)
                || doorType.equals(DoorType.ARMOUR40_40_SINGLE_TWO_SIDE_LEFT)
                || doorType.equals(DoorType.ARMOUR40_40_SINGLE_TWO_SIDE_RIGHT)
                || doorType.equals(DoorType.ARMOUR40_40_SINGLE_TOP_SIDE_LEFT)
                || doorType.equals(DoorType.ARMOUR40_40_SINGLE_TOP_SIDE_RIGHT)) {
            x_2.setDisable(false);
            x_3.setDisable(false);
        }
    }

    public void goToNextStep3() {
        step2Label.setStyle("-fx-background-color: #e39a20");
        step3Label.setStyle("-fx-background-color: #8bc8ef");
        doorDimensionsErrorLabel.setText("");
        TextField wrongTextField = step2ValuesValidated();
        if (checkSum() && wrongTextField == null) {
            step2VBox.setVisible(false);
            step3VBox.setVisible(true);
        } else {
            if (wrongTextField == x)
                doorDimensionsErrorLabel.setText("Неверное значени Х");
            if (wrongTextField == y)
                doorDimensionsErrorLabel.setText("Неверное значени Y");
            if (wrongTextField == x_1)
                doorDimensionsErrorLabel.setText("Неверное значени Х_1");
            if (wrongTextField == x_2)
                doorDimensionsErrorLabel.setText("Неверное значени Х_2");
            if (wrongTextField == x_3)
                doorDimensionsErrorLabel.setText("Неверное значени Х_3");
            if (wrongTextField == y_1)
                doorDimensionsErrorLabel.setText("Неверное значени Y_1");
        }
    }

    private boolean checkSum() {
        if (!x_1.isDisabled() && !x_1.getText().isEmpty()
                && !x_2.isDisabled() && !x_2.getText().isEmpty()
                && !x_3.isDisabled() && !x_3.getText().isEmpty()) {
            if (Integer.parseInt(x.getText()) != (Integer.parseInt(x_1.getText()) + Integer.parseInt(x_2.getText()) + Integer.parseInt(x_3.getText()))) {
                doorDimensionsErrorLabel.setText("Не выполняется условие: x = x1 + x2 + x3");
                return false;
            } else {
                return true;
            }
        } else
            return true;
    }

    private TextField step2ValuesValidated() {
        DoorType doorType = DoorType.selectDoorBy(doorTypeCombo.getSelectionModel().getSelectedItem(),
                doorStructureTypeCombo.getSelectionModel().getSelectedItem(),
                doorComplexityCategoryCombo.getSelectionModel().getSelectedItem(),
                doorOpeningSideCombo.getSelectionModel().getSelectedItem());
        if (x.getText().equals("")
                || (Integer.parseInt(x.getText()) < doorType.getMinX())
                || Integer.parseInt(x.getText()) > doorType.getMaxX())
            return x;
        else if (y.getText().equals("")
                || (Integer.parseInt(y.getText()) < doorType.getMinY())
                || Integer.parseInt(y.getText()) > doorType.getMaxY())
            return y;
        else if (!x_1.isDisabled() && (x_1.getText().equals("")
                || (Integer.parseInt(x_1.getText()) < doorType.getMinX1())
                || Integer.parseInt(x_1.getText()) > doorType.getMaxX1()))
            return x_1;
        else if (!y_1.isDisabled() && (y_1.getText().equals("")
                || (Integer.parseInt(y_1.getText()) < doorType.getMinY1())
                || Integer.parseInt(y_1.getText()) > doorType.getMaxY1()))
            return y_1;
        else if (!x_2.isDisabled() && (x_2.getText().equals("")
                || (Integer.parseInt(x_2.getText()) < doorType.getMinX2())))
            return x_2;
        else if (!x_3.isDisabled() && (x_3.getText().equals("")
                || (Integer.parseInt(x_3.getText()) < doorType.getMinX3())))
            return x_3;
        return null;
    }

    public void goToNextStep4() {
        step3Label.setStyle("-fx-background-color: #e39a20");
        step4Label.setStyle("-fx-background-color: #8bc8ef");
        decorationTypeErrorLabel.setText("");
        ComboBox<String> wrongCombobox = step3ValuesValidated();
        TextField wrongTextField = step3TextFieldsValidated();
        if (wrongCombobox == null && wrongTextField == null) {
            step3VBox.setVisible(false);
            step4VBox.setVisible(true);
        } else {
            if (wrongCombobox == outerDecorationTypeCombo)
                decorationTypeErrorLabel.setText("Не выбрано значение вида наружной отделки");
            if (wrongCombobox == outerTransomDecorationTypeCombo)
                decorationTypeErrorLabel.setText("Не выбрано значение наружной отделки фрамуги");
            if (wrongCombobox == innerDecorationTypeCombo)
                decorationTypeErrorLabel.setText("Не выбрано значение вида внутренней отделки");
            if (wrongCombobox == innerTransomDecorationTypeCombo)
                decorationTypeErrorLabel.setText("Не выбрано значение внутренней отделки фрамуги");
            if (wrongCombobox == platbandTypeCombo)
                decorationTypeErrorLabel.setText("Не выбрано значение вида наличника");
            if (wrongTextField == outerColor)
                decorationTypeErrorLabel.setText("Не введен цвет наружной отделки");
            if (wrongTextField == outerConfiguration)
                decorationTypeErrorLabel.setText("Не введена конфигурация наружной отделки");
            if (wrongTextField == innerColor)
                decorationTypeErrorLabel.setText("Не введен цвет внутренней отделки");
            if (wrongTextField == innerConfiguration)
                decorationTypeErrorLabel.setText("Не введена конфигурация внутренней отделки");
            if (wrongTextField == platbandWidth)
                decorationTypeErrorLabel.setText("Не введено значение ширины наличника");
        }
    }

    private ComboBox<String> step3ValuesValidated() {
        if (outerDecorationTypeCombo.getSelectionModel().getSelectedItem() == null)
            return outerDecorationTypeCombo;
        else if (!outerTransomDecorationTypeCombo.isDisabled() && outerTransomDecorationTypeCombo.getSelectionModel().getSelectedItem() == null)
            return outerTransomDecorationTypeCombo;
        else if (innerDecorationTypeCombo.getSelectionModel().getSelectedItem() == null)
            return innerDecorationTypeCombo;
        else if (!innerTransomDecorationTypeCombo.isDisabled() && innerTransomDecorationTypeCombo.getSelectionModel().getSelectedItem() == null)
            return innerTransomDecorationTypeCombo;
        else if (!platbandTypeCombo.isDisabled() && platbandTypeCombo.getSelectionModel().getSelectedItem() == null)
            return platbandTypeCombo;
        else
            return null;
    }

    private TextField step3TextFieldsValidated() {
        if (!outerColor.isDisabled() && outerColor.getText().equals(""))
            return outerColor;
        else if (!outerConfiguration.isDisabled() && outerConfiguration.getText().equals(""))
            return outerConfiguration;
        else if (!innerColor.isDisabled() && innerColor.getText().equals(""))
            return innerColor;
        else if (!innerConfiguration.isDisabled() && innerConfiguration.getText().equals(""))
            return innerConfiguration;
        else if (!platbandWidth.isDisabled() && platbandWidth.getText().equals(""))
            return platbandWidth;
        else
            return null;
    }

    public void goToNextStep5() {
        step4Label.setStyle("-fx-background-color: #e39a20");
        step5Label.setStyle("-fx-background-color: #8bc8ef");
        accessoriesErrorLabel.setText("");
        ComboBox<String> wrongCombobox = step4ValuesValidated();
        if (wrongCombobox == null) {
            step4VBox.setVisible(false);
            step5VBox.setVisible(true);
        } else {
            if (wrongCombobox == mainLockCombo)
                accessoriesErrorLabel.setText("Не выбран основной замок");
            if (wrongCombobox == secondaryLockCombo)
                accessoriesErrorLabel.setText("Не выбран дополнительный замок");
            if (wrongCombobox == handleCombo)
                accessoriesErrorLabel.setText("Не выбрана ручка");
            if (wrongCombobox == spyHoleCombo)
                accessoriesErrorLabel.setText("Не выбран глазок");
            if (wrongCombobox == armourStrapCombo)
                accessoriesErrorLabel.setText("Не выбрана броненакладка");
        }
    }

    private ComboBox<String> step4ValuesValidated() {
        if (mainLockCombo.getSelectionModel().getSelectedItem() == null)
            return mainLockCombo;
        else if (secondaryLockCombo.getSelectionModel().getSelectedItem() == null)
            return secondaryLockCombo;
        else if (handleCombo.getSelectionModel().getSelectedItem() == null)
            return handleCombo;
        else if (spyHoleCombo.getSelectionModel().getSelectedItem() == null)
            return spyHoleCombo;
        else if (!armourStrapCombo.isDisabled() && armourStrapCombo.getSelectionModel().getSelectedItem() == null)
            return armourStrapCombo;
        else
            return null;
    }

    public void goToNextStep6() {
        step5Label.setStyle("-fx-background-color: #e39a20");
        step6Label.setStyle("-fx-background-color: #8bc8ef");
        optionalServicesErrorlabel.setText("");
        if (shippingCombo.getSelectionModel().getSelectedItem() == null)
            optionalServicesErrorlabel.setText("Не выбран способ доставки");
        else if(!shippingCostInput.isDisabled() && shippingCostInput.getText().equals(""))
            optionalServicesErrorlabel.setText("Не введена стоимость доставки");
        else if(packagingGroup.getSelectedToggle() == null)
            optionalServicesErrorlabel.setText("Не выбрана необходимость упаковки");
        else if(installationGroup.getSelectedToggle() == null)
            optionalServicesErrorlabel.setText("Не выбрана необходимость установки");
        else {
            step5VBox.setVisible(false);
            step6VBox.setVisible(true);
        }
    }
    public void goToPreviousStep1() {
        step2Label.setStyle("-fx-background-color: #e39a20");
        step1Label.setStyle("-fx-background-color: #8bc8ef");
        step2VBox.setVisible(false);
        step1VBox.setVisible(true);
    }
    public void goToPreviousStep2() {
        step3Label.setStyle("-fx-background-color: #e39a20");
        step2Label.setStyle("-fx-background-color: #8bc8ef");
        step3VBox.setVisible(false);
        step2VBox.setVisible(true);
    }
    public void goToPreviousStep3() {
        step4Label.setStyle("-fx-background-color: #e39a20");
        step3Label.setStyle("-fx-background-color: #8bc8ef");
        step4VBox.setVisible(false);
        step3VBox.setVisible(true);
    }
    public void goToPreviousStep4() {
        step5Label.setStyle("-fx-background-color: #e39a20");
        step4Label.setStyle("-fx-background-color: #8bc8ef");
        step5VBox.setVisible(false);
        step4VBox.setVisible(true);
    }

    public void goToPreviousStep5() {
        step6Label.setStyle("-fx-background-color: #e39a20");
        step5Label.setStyle("-fx-background-color: #8bc8ef");
        step6VBox.setVisible(false);
        step5VBox.setVisible(true);
    }

    private void initStep2() {
        x.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                updateDimensionsLabel();
            }
        });
        x_1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                updateDimensionsLabel();
            }
        });
        x_2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                updateDimensionsLabel();
            }
        });
        x_3.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                updateDimensionsLabel();
            }
        });
        y.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                updateDimensionsLabel();
            }
        });
        y_1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                updateDimensionsLabel();
            }
        });
    }

    private void updateDimensionsLabel() {
        if (!x.getText().equals("") && Integer.parseInt(x.getText()) % 10 != 0) {
            wrongDimensionsLabel.setText("Значение x должно быть кратным 10");
        } else if (!x_1.getText().equals("") && Integer.parseInt(x_1.getText()) % 10 != 0) {
            wrongDimensionsLabel.setText("Значение x1 должно быть кратным 10");
        } else if (!x_2.getText().equals("") && Integer.parseInt(x_2.getText()) % 10 != 0) {
            wrongDimensionsLabel.setText("Значение x2 должно быть кратным 10");
        } else if (!x_3.getText().equals("") && Integer.parseInt(x_3.getText()) % 10 != 0) {
            wrongDimensionsLabel.setText("Значение x3 должно быть кратным 10");
        } else if (!y.getText().equals("") && Integer.parseInt(y.getText()) % 10 != 0) {
            wrongDimensionsLabel.setText("Значение y должно быть кратным 10");
        } else if (!y_1.getText().equals("") && Integer.parseInt(y_1.getText()) % 10 != 0) {
            wrongDimensionsLabel.setText("Значение y1 должно быть кратным 10");
        } else {
            wrongDimensionsLabel.setText("");
        }
    }

    private void initStep3() {
        outerDecorationTypeCombo.getItems().clear();
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
                if (newValue != null) {
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
            }
        });

        outerTransomDecorationTypeCombo.getItems().clear();
        outerTransomDecorationTypeCombo.getItems().setAll(
            LabelNames.outerWithTransomDecoration,
            LabelNames.outerNoTransomDecoration
        );

        innerDecorationTypeCombo.getItems().clear();
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
                if (newValue != null) {
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
            }
        });

        innerTransomDecorationTypeCombo.getItems().clear();
        innerTransomDecorationTypeCombo.getItems().setAll(
                LabelNames.innerWithTransomDecoration,
                LabelNames.innerNoTransomDecoration
        );

        platbandTypeCombo.getItems().clear();
        platbandTypeCombo.getItems().setAll(
                LabelNames.platbandWooden,
                LabelNames.platbandShagreen,
                LabelNames.platbandPF,
                LabelNames.platbendAntic,
                LabelNames.platbandMdf10,
                LabelNames.platbandMdf16,
                LabelNames.noPlatband
        );
        platbandTypeCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue != null) {
                    if (newValue.equals(LabelNames.platbandMdf10)
                            || newValue.equals(LabelNames.platbandMdf16)) {
                        platbandWidth.setDisable(false);
                    } else
                        platbandWidth.setDisable(true);
                }
            }
        });

        innerColor.setDisable(true);
        innerColor.setText("");
        outerColor.setDisable(true);
        outerColor.setText("");
        innerConfiguration.setDisable(true);
        innerConfiguration.setText("");
        outerConfiguration.setDisable(true);
        outerConfiguration.setText("");
        platbandWidth.setDisable(true);
        platbandWidth.setText("");
    }

    private void initStep4() {
        mainLockCombo.getItems().clear();
        mainLockCombo.getItems().setAll(
                LabelNames.kale252,
                LabelNames.mottura,
                LabelNames.apecs2200,
                LabelNames.kale2000
        );
        mainLockCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue != null) {
                    if (newValue.equals(LabelNames.mottura)) {
                        handleCombo.getItems().clear();
                        handleCombo.getItems().setAll(
                                LabelNames.apecsCrome,
                                LabelNames.apecsGold
                        );
                        armourStrapCombo.getItems().clear();
                        armourStrapCombo.getItems().setAll(
                                LabelNames.apecsProtectorCrome,
                                LabelNames.apecsProtectorGold
                        );
                        armourStrapCombo.setDisable(false);
                    } else {
                        handleCombo.getItems().clear();
                        handleCombo.getItems().setAll(
                                LabelNames.apecsCrome,
                                LabelNames.apecsGold,
                                LabelNames.apecsCromePlank,
                                LabelNames.apecsGoldPlank,
                                LabelNames.aydemirBrown,
                                LabelNames.aydemirBlack
                        );
                        armourStrapCombo.getItems().clear();
                        armourStrapCombo.getItems().setAll(
                                LabelNames.apecsProtectorCrome,
                                LabelNames.apecsProtectorGold,
                                LabelNames.noProtector
                        );
                    }

                }
            }
        });

        secondaryLockCombo.getItems().clear();
        secondaryLockCombo.getItems().setAll(
                LabelNames.kale257,
                LabelNames.kale189,
                LabelNames.elbor,
                LabelNames.noSecondaryLock
        );

        handleCombo.getItems().clear();
        handleCombo.getItems().setAll(
                LabelNames.apecsCrome,
                LabelNames.apecsGold,
                LabelNames.apecsCromePlank,
                LabelNames.apecsGoldPlank,
                LabelNames.aydemirBrown,
                LabelNames.aydemirBlack
        );
        handleCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue != null) {
                    if (newValue.equals(LabelNames.apecsCromePlank)
                            || newValue.equals(LabelNames.apecsGoldPlank)) {
                        armourStrapCombo.setDisable(true);
                    } else
                        armourStrapCombo.setDisable(false);
                }
            }
        });

        armourStrapCombo.getItems().clear();
        armourStrapCombo.getItems().setAll(
                LabelNames.apecsProtectorCrome,
                LabelNames.apecsProtectorGold,
                LabelNames.noProtector
                );

        spyHoleCombo.getItems().clear();
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
        shippingCostInput.setText("");
        shippingCostInput.setDisable(true);

        shippingCombo.getItems().clear();
        shippingCombo.getItems().setAll(
                LabelNames.shippingSelf,
                LabelNames.shippingVendor,
                LabelNames.shippingCompany
        );
        shippingCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue != null) {
                    if (newValue.equals(LabelNames.shippingCompany)) {
                        shippingCostInput.setDisable(false);
                    } else
                        shippingCostInput.setDisable(true);
                }
            }
        });
    }

    private void updateDoorStructureTypeComboBox() {
        doorStructureTypeCombo.getItems().setAll(
                LabelNames.angledDoor,
                LabelNames.angledDoubleDoor,
                LabelNames.door40x40,
                LabelNames.door50x30
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

    private void updateInnerDecorationComboBoxNoMDF(String doorStructure) {
        if (doorStructure.equalsIgnoreCase(LabelNames.angledDoubleDoor)) {
            innerDecorationTypeCombo.getItems().clear();
            innerDecorationTypeCombo.getItems().setAll(
                    LabelNames.innerPlastic,
                    LabelNames.innerLaminatedPlastic,
                    LabelNames.innerPaintingPF,
                    LabelNames.innerPaintingShagreen,
                    LabelNames.innerPaintingAntic,
                    LabelNames.innerNoTransomDecoration
            );
        } else  {
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
                    LabelNames.platbandMdf16,
                    LabelNames.noPlatband
            );
        } else if (doorType.equalsIgnoreCase(LabelNames.fireproofDoor)) {
            platbandTypeCombo.getItems().clear();
            platbandTypeCombo.getItems().setAll(
                    LabelNames.platbandShagreen,
                    LabelNames.platbandPF,
                    LabelNames.platbendAntic,
                    LabelNames.noPlatband
            );
        }
    }

    public void showLockerTypesPane(ActionEvent actionEvent) {
        orderPane.setVisible(false);
        doorTypesPane.setVisible(false);
        accessoriesPane.setVisible(false);
        decorationTypesPane.setVisible(false);
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
        decorationTypesPane.setVisible(false);
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
        decorationTypesPane.setVisible(false);
        orderPane.setVisible(true);
    }

    public void showAccessoriesPane(ActionEvent actionEvent) {
        lockerTypesPane.setVisible(false);
        doorTypesPane.setVisible(false);
        orderPane.setVisible(false);
        decorationTypesPane.setVisible(false);
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

    public void showDecorationTypesPane(ActionEvent actionEvent) {
        orderPane.setVisible(false);
        accessoriesPane.setVisible(false);
        lockerTypesPane.setVisible(false);
        doorTypesPane.setVisible(false);
        decorationTypesPane.setVisible(true);
    }

    public void showOuterDecorationTypesPane(ActionEvent actionEvent) {
        innerDecorationTypesPane.setVisible(false);
        outerDecorationTypesPane.setVisible(true);
    }

    public void showInnerDecorationTypesPane(ActionEvent actionEvent) {
        outerDecorationTypesPane.setVisible(false);
        innerDecorationTypesPane.setVisible(true);
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
                platbandTypeCombo.getSelectionModel().getSelectedItem(),
                mainLockCombo.getSelectionModel().getSelectedItem(),
                secondaryLockCombo.getSelectionModel().getSelectedItem(),
                handleCombo.getSelectionModel().getSelectedItem(),
                armourStrapCombo.getSelectionModel().getSelectedItem(),
                spyHoleCombo.getSelectionModel().getSelectedItem(),
                shippingCostInput.getText(),
                packagingYes.isSelected(),
                installationYes.isSelected()
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

    public void showApecs2200ZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("apecs2200_original.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root, kale2000Zoomed.getWidth(), kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showKale2000LockZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("kale2000LockOriginal.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root, kale2000Zoomed.getWidth(), kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showKale2000ZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("kale2000_Original.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root, kale2000Zoomed.getWidth(), kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showKale189LockZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("kale189LockOriginal.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showKale189ZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("kale189_Original.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showKale252rLockZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("kale252rLockOriginal.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showKale252rZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("kale252rOriginal.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showKale257LockZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("kale257LockOriginal.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showKale257ZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("kale257_Original.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showMotturaLockZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("motturaLockOriginal.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showMotturaZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("motturaOriginal.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showElborLockZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("elborLockOriginal.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showElborZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("elbor_Original.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showApecsChromeZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("apecsChrome_Original.png"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showApecsGoldZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("apecsGold_Original.png"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showApecsPlankChromeZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("apecsPlankChrome_Original.png"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showApecsPlankGoldZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("apecsPlankGold_Original.png"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showAydemirBlackZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("aydemirBlack_Original.png"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showAydemirBrownZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("aydemirBrown_Original.png"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showFireProofDoorZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("fireProofDoorOriginal.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showAngledDoorZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("angledDoorOriginal.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showAngledWithTwoDoorZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("angledWithTwoOriginal.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showProfilePipeDoorZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("profilePipeDoorOriginal.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showProfilePipeWithTwoDoorZoomedImage() {
        Stage stage = new Stage();
        Group root = new Group();
        Image kale2000Zoomed = new Image(Controller.class.getResourceAsStream("profilePipeWithTwoDoorOriginal.jpg"));
        ImageView imageView = new ImageView(kale2000Zoomed);
        root.getChildren().add(imageView);
        stage.setScene(new Scene(root,kale2000Zoomed.getWidth(),kale2000Zoomed.getHeight()));
        stage.show();
    }

    public void showSettingsPane(ActionEvent event) {
        settingsPane.setVisible(true);
    }

    public void saveSettings(ActionEvent event) {
        settingsPane.setVisible(false);
    }

    private void clearAllSteps() {
        //clear step2
        x.setText("");
        x_1.setText("");
        x_2.setText("");
        x_3.setText("");
        y.setText("");
        y_1.setText("");

        //clear step3
        initStep3();
        initStep3();
        initStep4();
        initStep5();
    }


}
