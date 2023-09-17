package com.animal.guessing;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuessingApplication extends Application {
    public static void main(String...args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        final TextField nameText = new TextField();
        nameText.setText("Ndemo Nancy");
        nameText.setLayoutX(10);
        nameText.setLayoutY(10);

        final Button button = new Button();
        button.setLayoutX(160);
        button.setLayoutY(10);
        button.setText("Say Hello");

        final Label greetingLabel = new Label();
        greetingLabel.setLayoutX(10);
        greetingLabel.setLayoutY(40);

        button.setOnAction(event -> greetingLabel.setText(String.format("Hello %s!", nameText.getText())));

        final Group root = new Group();
        root.getChildren().addAll(nameText, button, greetingLabel);

        primaryStage.setTitle("Guessing Game");
        primaryStage.setScene(new Scene(root, 240, 70));

        primaryStage.show();
    }
}
