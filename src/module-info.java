module FirstJavaFX {

    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.web;
    requires java.desktop;

    opens com.ahsan;
    opens com.ahsan.view;
}