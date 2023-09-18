package com.animal.guessing;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class Controller implements IView{

    private Game game;

    public void bind(Game g) {
        this.game = g;
    }

    @Override
    public void display(String s) {

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

            // Disable the cancel button
            Button cancel = (Button) tid.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancel.setDisable(true);

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
