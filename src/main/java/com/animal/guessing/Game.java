package com.animal.guessing;

import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class Game {

    private IView view;

    public Game(IView v) {

    }

    public void play() {
        TextInputDialog animalInputDialog = new TextInputDialog();
        animalInputDialog.setTitle("Confirmation");
        animalInputDialog.setHeaderText("What is your animal?");

        // ButtonType okButton = new ButtonType("OK");
        // ButtonType cancelButton = new ButtonType("Cancel");
        // animalInputDialog.getDialogPane().getButtonTypes().setAll(okButton, cancelButton);

        // Wait animal input confirmation
        Optional<String> optionalAnimal = animalInputDialog.showAndWait();

        if(optionalAnimal.isPresent()) {

        } else {
            System.out.println("Cancelled");
        }
    }

    public void load(String fname) throws Exception {

    }

    public void save(String fname) throws Exception {

    }

    public String display() {
        return null;
    }

    private void help() {

    }
}
