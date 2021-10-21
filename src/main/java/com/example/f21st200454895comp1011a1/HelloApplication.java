package com.example.f21st200454895comp1011a1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("expeditions-by-year-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Everest Expeditions 2000-2020");
        stage.setScene(scene);
        stage.show();

        Image image= new Image(getClass().getResource("/img/icon.png").toExternalForm());
        stage.getIcons().add(image);
    }

    public static void main(String[] args) {
        launch();
    }
}