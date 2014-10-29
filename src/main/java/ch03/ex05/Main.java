package ch03.ex05;

import java.net.URL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public static Image transform(Image in, ColorTransformer f) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                out.getPixelWriter().setColor(x, y,
                        f.apply(x, y, in.getPixelReader().getColor(x, y)));
        return out;
    }

    static URL getResource(String resource) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(resource);
    }

    public void start(Stage stage) {
        Image in = new Image(getResource("ch03/lena.jpg").toString());
        Image out = transform(in, (x, y, colorAtXY) -> {
            if (x <= 10 || x >= in.getWidth() - 10
                    || y <= 10 || y >= in.getHeight() - 10)
                return Color.GRAY;
            else
                return colorAtXY;
        });

        Pane root = new Pane();
        root.getChildren().add(new ImageView(out));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
