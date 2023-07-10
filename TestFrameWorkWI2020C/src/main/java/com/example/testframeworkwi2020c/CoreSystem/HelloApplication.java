package com.example.testframeworkwi2020c.CoreSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("unicorn-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
    //    scene.getStylesheets().add("src/main/resources/com/example/testframeworkwi2020c/style.css");
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Testfamework");

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) { launch(); }
}