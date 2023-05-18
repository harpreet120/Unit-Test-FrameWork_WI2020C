package com.example.testframeworkwi2020c;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.StandardSocketOptions;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UnicornController implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBoxId;

    @FXML
    private TextArea outputAreaId;

    @FXML
    private Button pathButtonId;

    @FXML
    private Button startButtonId;

    @FXML
    private Text successtagId;

    // Hard-Gecoded. Später noch anpassen
    private String[] exercises = {"Aufgabe 1", "Aufgabe 2", "Aufgabe 3"};

    // Hinzufügen der Aufgaben in das DropDown-Menü
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxId.getItems().addAll(exercises);
    }

    // Auswahl der Aufgabe aus dem DropDown
    public String getSelectedExercise(){
        return choiceBoxId.getValue();
    }

    // Rückgabe der Pfade von Java oder ZIP Dateien
    @FXML
    public String getPath(){
        FileChooser.ExtensionFilter ex1 = new FileChooser.ExtensionFilter("Java Files", "*.java");
        FileChooser.ExtensionFilter ex2 = new FileChooser.ExtensionFilter("ZIP Ordner", "*.zip");
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(ex1, ex2);
        File selectedFile = fileChooser.showOpenDialog(HelloApplication.stage);
        if(selectedFile != null){
            successtagId.setText("Du hast erfolgreich die Datei "+ selectedFile.getName()+" ausgewählt.");

            return selectedFile.getPath();
        }
        else {
            successtagId.setText("Du hast keine Datei ausgewählt.");
            return null;
        }
    }
}