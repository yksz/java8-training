package ch04.ex04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 320, 480);

        Circle circle = new Circle();
        circle.setFill(Color.DODGERBLUE);
        circle.setCenterY(scene.getHeight() / 2.0);
        circle.centerXProperty().bind(Bindings.divide(scene.widthProperty(), 2));
        circle.radiusProperty().bind(Bindings.divide(scene.widthProperty(), 2));
        root.getChildren().add(circle);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
