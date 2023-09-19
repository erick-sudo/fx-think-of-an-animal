package com.animal.guessing;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;

public class Controller implements IView{

    @FXML
    private TextArea textArea;

    private StringProperty textProperty = new SimpleStringProperty();

    @FXML
    private Game game;

    public void bind(Game g) {
        this.game = g;
        textArea.textProperty().bindBidirectional(textProperty);
    }

    @Override
    public void display(String s) {
        textProperty.set(s);
    }

    @FXML
    public void playGame() {
        game.play();
    }

    public void saveGame() {
        try {
            game.save("animal.txt");
            display("Game saved successfully");
        } catch (Exception e) {
            display("Failed to save progress");
        }
    }

    public void loadGame() {
        try {
            game.load("animal.txt");
            display("Game loaded successfully");
        } catch (Exception e) {
            display("Could retrieve any previous game history. Please save to keep your progress before exiting game.");
        }
    }

    public void displayTree() {
        this.display(game.display());
    }

    @FXML
    private void exit() {
        System.exit(0);
    }

    @Override
    public void append(String s) {

    }

    @Override
    public String ask(String question) {
        String r = question + "\nText is required.";
        String s = "";
        boolean valid = false;
        while(!valid) {
            TextInputDialog tid = new TextInputDialog("");
            tid.setHeaderText(question);
            Stage alertStage = (Stage) tid.getDialogPane().getScene().getWindow();
            alertStage.initModality(Modality.APPLICATION_MODAL);
            alertStage.initStyle(StageStyle.UTILITY);
            alertStage.setAlwaysOnTop(true);

            // Disable the cancel button
            Button cancel = (Button) tid.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancel.setDisable(true);

            // Synchronize and wait for input
            tid.showAndWait();

            s = tid.getEditor().getText();
            valid = validate(s);
            if(!valid) {
                question = r;
            }
        }

        // Remove leading and/or trailing whitespace
        return s.trim();
    }

    @Override
    public boolean choose(String question) {
        String r = choose(question, "Yes", "No");
        if(r.equals("Yes")) {
            return true;
        }
        return false;
    }

    @Override
    public String choose(String question, String choice1, String choice2) {
        ButtonType b1 = new ButtonType(choice1);
        ButtonType b2 = new ButtonType(choice2);

        Alert alert = new Alert(Alert.AlertType.NONE, question, b1, b2);
        alert.setTitle("Choose");
        Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
        alertStage.initModality(Modality.APPLICATION_MODAL);
        alertStage.initStyle(StageStyle.UTILITY);
        alertStage.setAlwaysOnTop(true);

        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == b1) {
            return choice1;
        }
        return choice2;
    }

    private boolean validate(String s) {
        if((s == null) || (s == "") || (s.matches("\\s*"))) {
            return false;
        }
        return true;
    }
}
