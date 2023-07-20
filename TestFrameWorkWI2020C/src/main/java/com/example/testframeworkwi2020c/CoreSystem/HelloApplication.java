package com.example.testframeworkwi2020c.CoreSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Eine JavaFX-Anwendung, die das Testframework startet und die Hauptansicht anzeigt.
 */
public class HelloApplication extends Application {

    public static Stage stage;

    /**
     * Die Startmethode für die JavaFX-Anwendung.
     * Diese Methode wird automatisch aufgerufen, wenn die Anwendung gestartet wird.
     *
     * @param stage Die Hauptbühne (Stage) der Anwendung.
     * @throws IOException Wenn ein Problem beim Laden der FXML-Datei oder beim Aufbau der Szene auftritt.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Die übergebene Stage wird in das statische Feld stage gespeichert, damit darauf später zugegriffen werden kann.
        this.stage = stage;

        // Lade das FXML-Layout der Hauptansicht aus der Ressourcen-Datei "unicorn-view.fxml"
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("unicorn-view.fxml"));

        // Erstelle eine neue Szene (Scene) mit dem geladenen FXML-Layout, der Breite 900 und Höhe 600.
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);

        // Füge der Szene die externe CSS-Datei "style.css" hinzu, um das Aussehen zu formatieren.
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // Setze den Titel des Fensters auf "Testframework"
        stage.setTitle("Testframework");

        // Setze die Szene auf die Stage
        stage.setScene(scene);

        // Zeige die Stage an
        stage.show();
    }

    /**
     * Die Hauptmethode der Anwendung.
     * Diese Methode wird aufgerufen, wenn die Anwendung gestartet wird und initialisiert das JavaFX-Framework.
     *
     * @param args Die Befehlszeilenargumente (wird in diesem Fall nicht verwendet).
     */
    public static void main(String[] args) {
        // Rufe die launch()-Methode auf, um die JavaFX-Anwendung zu starten.
        launch();
    }
}