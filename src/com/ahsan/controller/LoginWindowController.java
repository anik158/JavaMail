package com.ahsan.controller;

import com.ahsan.EmailManager;
import com.ahsan.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends BaseController {

    @FXML
    private Button errorLabel;

    @FXML
    private TextField email;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField password;

    public LoginWindowController(EmailManager emailManager, String fxmlName, ViewFactory viewFactory) {
        super(emailManager, fxmlName, viewFactory);
    }

    @FXML
    void loginButtonAction() {
        System.out.println("Click");
        viewFactory.showMainWindow();
        Stage stage = (Stage) loginButton.getScene().getWindow();
        viewFactory.closeStage(stage);
    }
}
