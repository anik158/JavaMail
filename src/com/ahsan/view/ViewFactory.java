package com.ahsan.view;

import com.ahsan.EmailManager;
import com.ahsan.controller.BaseController;
import com.ahsan.controller.LoginWindowController;
import com.ahsan.controller.MainWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {
    private EmailManager emailManager;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    public void showLoginWindow() {
        System.out.println("Show login window");

        BaseController controller = new LoginWindowController(emailManager,"loginWindow.fxml",this);
        initializeStage(controller);
    }

    public void showMainWindow() {
        System.out.println("Show main window");
        BaseController controller = new MainWindowController(emailManager,"mainWindow.fxml",this);
        initializeStage(controller);

    }

    private void initializeStage(BaseController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getName()));
        fxmlLoader.setController(controller);
        Parent parent;
        try{
            parent = fxmlLoader.load();
        }catch (IOException e){
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}
