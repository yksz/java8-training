package ch04.ex10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Browser extends Application {

    public void start(Stage stage) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        TextField urlBar = new TextField("http://www.google.com");
        webEngine.locationProperty().addListener(prop -> {
            urlBar.setText(webEngine.getLocation());
        });
        urlBar.setOnAction(event -> {
            String url = urlBar.getText();
            webEngine.load(url);
            urlBar.setText(webEngine.getLocation());
        });
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            WebHistory webHistory = webEngine.getHistory();
            if (webHistory.getCurrentIndex() > 0) {
                webHistory.go(-1);
                urlBar.setText(webEngine.getLocation());
            }
        });

        VBox root = new VBox(urlBar, backButton, webView);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
