package ch03.ex14;

import java.net.URL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    static URL getResource(String resource) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(resource);
    }

    public void start(Stage stage) {
        Image in = new Image(getResource("ch03/lena.jpg").toString());
        Image out = LatentImage.from(in)
                .transform((x, y, reader) -> reader.getColor((int) in.getWidth() - 1 - x, y).grayscale())
                .toImage();

        HBox root = new HBox();
        root.getChildren().addAll(new ImageView(in), new ImageView(out));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
