package com.example.testframeworkwi2020c;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class UnicornController implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBoxId;

    @FXML
    private TextArea outputAreaId;

    @FXML
    private Text successtagId;

    private String filepath;

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

    // Speicherung der Pfade Java oder ZIP Dateien in Variable filepath
    @FXML
    public void safePath(){
        FileChooser.ExtensionFilter ex1 = new FileChooser.ExtensionFilter("Jar Files", "*.jar");
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(ex1);
        File selectedFile = fileChooser.showOpenDialog(HelloApplication.stage);

        if(selectedFile != null){
            successtagId.setText("Du hast erfolgreich die Datei "+ selectedFile.getName()+" ausgewählt.");
            filepath = selectedFile.getPath();
            System.out.println(filepath);
        }
        else {
            successtagId.setText("Du hast keine Datei ausgewählt.");
        }
    }

    // Vergleich wird gestartet, indem eine Testklasse mit dem passenden Interface ITester aufgerufen wird
    // Ausgabefeld (outputAreaId) muss noch befüllt werden
    @FXML
    public void startComparison(){
        String aufgabenname = getSelectedExercise();
        ITester tester = new TestController();
        tester.startComparison(aufgabenname, filepath);
    }
}