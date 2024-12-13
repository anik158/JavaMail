package com.ahsan.controller;

import com.ahsan.EmailManager;
import com.ahsan.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

public class MainWindowController extends BaseController {

    @FXML
    private TableView<?> emailTableView;

    @FXML
    private WebView emailWebView;

    @FXML
    private TreeView<?> emailsTreeView;

    public MainWindowController(EmailManager emailManager, String fxmlName, ViewFactory viewFactory) {
        super(emailManager, fxmlName, viewFactory);
    }

    @FXML
    void optionsAction() {
        viewFactory.showOptionsWindow();
    }

}
