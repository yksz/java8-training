package ch04.ex09;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    private Circle makeStar() {
        Circle star = new Circle();
        star.setCenterX(320.0);
        star.setCenterY(240.0);
        star.setRadius(30.0);
        star.setFill(Color.YELLOW);
        return star;
    }

    private Circle makePlanet() {
        Circle planet = new Circle();
        planet.setRadius(15.0);
        planet.setFill(Color.BLUE);
        return planet;
    }

    private Path makeEllipticOrbit() {
        double centerX = 320.0, centerY = 240.0;
        double radiusX = 300.0, radiusY = 100.0;

        MoveTo moveTo = new MoveTo();
        moveTo.setX(centerX - radiusX);
        moveTo.setY(centerY);

        ArcTo arcTo = new ArcTo();
        arcTo.setX(centerX - radiusX);
        arcTo.setY(centerY - 0.1);
        arcTo.setRadiusX(radiusX);
        arcTo.setRadiusY(radiusY);
        arcTo.setLargeArcFlag(true);
        arcTo.setSweepFlag(false);

        Path path = new Path();
        path.getElements().addAll(moveTo, arcTo, new ClosePath());
        path.setStroke(Color.WHITE);
        path.getStrokeDashArray().setAll(5.0);
        return path;
    }

    public void start(Stage stage) {
        Circle star = makeStar();
        Circle planet = makePlanet();
        Path ellipticOrbit = makeEllipticOrbit();

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(10000));
        pathTransition.setNode(planet);
        pathTransition.setPath(ellipticOrbit);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.play();

        Group root = new Group(ellipticOrbit, planet, star);
        stage.setScene(new Scene(root, 640, 480, Color.BLACK));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
