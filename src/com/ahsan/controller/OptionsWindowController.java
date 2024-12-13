package com.ahsan.controller;

import com.ahsan.EmailManager;
import com.ahsan.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;

public class OptionsWindowController extends BaseController {
    @FXML
    private Slider fontSizePicker;

    @FXML
    private ChoiceBox<?> themePicker;

    public OptionsWindowController(EmailManager emailManager, String fxmlName, ViewFactory viewFactory) {
        super(emailManager, fxmlName, viewFactory);
    }

    @FXML
    void applyButton() {

    }

    @FXML
    void cancelButton() {

    }
}
