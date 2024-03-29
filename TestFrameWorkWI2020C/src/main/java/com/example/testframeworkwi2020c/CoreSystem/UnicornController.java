package com.example.testframeworkwi2020c.CoreSystem;


import com.example.testframeworkwi2020c.testSammlung.Emojis;
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

    // Liste der Übunsgaufgaben für das DropDown
    private String[] exercises = {"04_OOP_Ü04", "04_OOP_Ü05", "04_OOP_Ü06", "04_OOP_Ü07", "04_OOP_Ü08", "05_Datentypen_Ü02", "05_Datentypen_Ü03",
            "05_Datentypen_Ü04", "05_Datentypen_Ü06", "05_Datentypen_Ü09", "05_Datentypen_Ü10", "05_Datentypen_Ü11",
            "05_Datentypen_Ü12", "05_Datentypen_Ü13", "05_Datentypen_Ü14", "06_Strings_Ü01", "06_Strings_Ü02", "06_Strings_Ü03", "07_Arrays_Ü01",
            "07_Arrays_Ü02", "08_User_Interaction_Ü01", "08_User_Interaction_Ü02", "08_User_Interaction_Ü03", "09_ArrayList_Hashtable_Ü01",
            "09_ArrayList_Hashtable_Ü02", "Exkurs_Binary_Ü01", "Exkurs_Binary_Ü02", "X-I_unfair_dice", "X-II_black_jack", "X-III_StringController"};

    /***
     * Hinzufügen der Aufgaben in das DropDown-Menü
     * @param url Vorgenerierter Parameter von JavaFX
     * @param resourceBundle Vorgenerierter Parameter von JavaFX
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxId.getItems().addAll(exercises);
    }

    /***
     * Auswahl der Aufgabe aus dem DropDown
     * @return Aufgabenbezeichnung als String
     */
    public String getSelectedExercise(){
        return choiceBoxId.getValue();
    }

    /***
     * Speicherung der Pfade Java oder ZIP Dateien in Variable filepath
     */
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

    /***
     * Vergleich wird angestoßen, indem der Testcontroller aufgerufen wird
     */
    @FXML
    public void startComparison(){
        String aufgabenname = getSelectedExercise();
        TestController tester = new TestController();
        String ausgabeAnNutzer = tester.startComparison(aufgabenname, filepath);
        outputAreaId.setText(ausgabeAnNutzer);
        if(ausgabeAnNutzer !=""){
            outputAreaId.setText(outputAreaId.getText()+"\n \nAlle Tests Abgeschlossen" + Emojis.SMIRKING.getEmoji());
        }
    }
}