package com.ahsan.view;

import com.ahsan.EmailManager;
import com.ahsan.controller.BaseController;
import com.ahsan.controller.LoginWindowController;
import com.ahsan.controller.MainWindowController;
import com.ahsan.controller.OptionsWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {
    private EmailManager emailManager;
    private ArrayList<Stage> activeStages;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
        this.activeStages = new ArrayList<>();
    }

    private ColorTheme colorTheme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }
    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
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

    public void showOptionsWindow(){
        System.out.println("Show options window");
        BaseController controller = new OptionsWindowController(emailManager,"optionsWindow.fxml",this);
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
        activeStages.add(stage);
    }

    public void closeStage(Stage stage) {
        stage.close();
        activeStages.remove(stage);
    }

    public void updateStyles()
    {
        for (Stage stage : activeStages){
          Scene scene =  stage.getScene();
          scene.getStylesheets().clear();
          scene.getStylesheets().add(getClass().getResource(ColorTheme.getCssPath(getColorTheme())).toExternalForm());
          scene.getStylesheets().add(getClass().getResource(FontSize.getCssPath(getFontSize())).toExternalForm());
        }
    }
}
