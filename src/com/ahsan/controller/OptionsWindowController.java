package com.ahsan.controller;

import com.ahsan.EmailManager;
import com.ahsan.view.ColorTheme;
import com.ahsan.view.FontSize;
import com.ahsan.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsWindowController extends BaseController implements Initializable {
    @FXML
    private Slider fontSizePicker;

    @FXML
    private ChoiceBox<ColorTheme> themePicker;

    public OptionsWindowController(EmailManager emailManager, String fxmlName, ViewFactory viewFactory) {
        super(emailManager, fxmlName, viewFactory);
    }

    @FXML
    void applyButton() {
        viewFactory.setColorTheme(themePicker.getValue());
        viewFactory.setFontSize(FontSize.values()[(int)fontSizePicker.getValue()]);
        System.out.println(viewFactory.getColorTheme());
        System.out.println(viewFactory.getFontSize());
    }

    @FXML
    void cancelButton() {
        Stage stage = (Stage) fontSizePicker.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpColorTheme();
        setUpFontSizePicker();
    }


    private void setUpColorTheme() {
        themePicker.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        themePicker.setValue(viewFactory.getColorTheme());
    }

    private void setUpFontSizePicker() {
        fontSizePicker.setMin(0);
        fontSizePicker.setMax(FontSize.values().length-1);
        fontSizePicker.setValue(viewFactory.getFontSize().ordinal());
        fontSizePicker.setMinorTickCount(2);
        fontSizePicker.setMajorTickUnit(1);
        fontSizePicker.setBlockIncrement(1);
        fontSizePicker.setSnapToTicks(true);
        fontSizePicker.setShowTickLabels(true);
        fontSizePicker.setShowTickMarks(true);
        fontSizePicker.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                int i = object.intValue();
                return FontSize.values()[i].toString();
            }

            @Override
            public Double fromString(String string) {
                return 0.0;
            }
        });

        fontSizePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            fontSizePicker.setValue(newValue.intValue());
        });
    }
}
