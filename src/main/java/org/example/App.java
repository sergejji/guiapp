package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        try {
            URL fxmlUrl = getClass().getClassLoader().getResource("primary.fxml");
            GridPane root = FXMLLoader.load(fxmlUrl);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception ex){ ex.printStackTrace(); }
    }

    public static void main(String[] args) {
        launch();
    }

}