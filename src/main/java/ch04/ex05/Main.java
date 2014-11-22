package ch04.ex05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    private static final double RANGE = 0.25;

    public void start(Stage stage) {
        ProgressBar gauge = new ProgressBar(0.0);

        Button smaller = new Button("Smaller");
        smaller.setOnAction(event -> gauge.setProgress(gauge.getProgress() - RANGE));
        smaller.disableProperty().bind(
                BindingUtils.observe(t -> t.doubleValue() <= 0.0, gauge.progressProperty()));

        Button larger = new Button("Larger");
        larger.setOnAction(event -> gauge.setProgress(gauge.getProgress() + RANGE));
        larger.disableProperty().bind(
                BindingUtils.observe(t -> t.doubleValue() >= 1.0, gauge.progressProperty()));

        HBox root = new HBox(10, smaller, gauge, larger);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
