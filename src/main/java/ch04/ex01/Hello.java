package ch04.ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Hello extends Application {

    public void start(Stage stage) {
        String message = "Hello, FX";
        Label label = new Label("Hello, FX");
        label.setFont(new Font(100));
        TextField textField = new TextField(message);
        label.textProperty().bind(textField.textProperty());
        VBox root = new VBox(textField, label);
        stage.setScene(new Scene(root));
        stage.setTitle("Hello");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
