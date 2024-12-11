package com.ahsan.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginWindowController {
    @FXML
    private TextField email;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField password;

    @FXML
    void loginButtonAction() {
        System.out.println("Click");
    }
}
