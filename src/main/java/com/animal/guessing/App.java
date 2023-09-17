package com.animal.guessing;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String...args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Create a view
        Controller controllerView = new Controller();

        // Create a game
        Game game = new Game(controllerView);

        // Bind view to game
        controllerView.bind(game);

        // Confirmation dialog
        DialogPane confirmationDalogPane = new DialogPane();

        // Button Styles
        String buttonStyles = "-fx-padding: 5px; -fx-font-weight: bold; -fx-text-fill: teal; -fx-border-width: 1px; -fx-border-color: teal; ";

        // Load game button
        Button loadGameButton = new Button("Load a Game");
        loadGameButton.setStyle(buttonStyles);

        // Save game button
        Button saveGameButton = new Button("Save a Game");
        saveGameButton.setStyle(buttonStyles);

        // Display Tree button
        Button displayGameButton = new Button("Display the Tree");
        displayGameButton.setStyle(buttonStyles);

        // Play game button
        Button playGameButton = new Button("Play Game");
        playGameButton.setStyle(buttonStyles);
        playGameButton.setOnAction(e -> game.play());

        // Exit game button
        Button exitGameButton = new Button("Exit");
        exitGameButton.setStyle(buttonStyles + " -fx-min-width: 300px");
        exitGameButton.setOnAction(e -> System.exit(0));

        // Heading label
        Label headingLabel = new Label("Animal Guessing Game");
        headingLabel.setFont(new Font("Arial", 24));
        headingLabel.setStyle("-fx-padding: 0.6em; -fx-text-fill: teal; -fx-font-weight: bolder;");
        BorderPane headingPane = new BorderPane();
        headingPane.setCenter(headingLabel);

        // Text area for messages
        TextArea gameTextArea = new TextArea("Think of an animal. If my tree is non-empty, I will ask yes/no questions to try to work out your animal. Think of an animal now and press play to start.");
        gameTextArea.setWrapText(true);

        // Control widgets to the scene
        VBox leftSidePane = new VBox();
        leftSidePane.getChildren().addAll(
                loadGameButton,
                saveGameButton,
                displayGameButton,
                playGameButton
        );
        leftSidePane.setSpacing(40);
        leftSidePane.setStyle("-fx-padding: 1em");

        BorderPane middleBorderPane = new BorderPane();

        // Middle border pane
        middleBorderPane.setLeft(leftSidePane);
        middleBorderPane.setCenter(gameTextArea);
        middleBorderPane.setStyle("-fx-padding: 0.4em;");

        // Bottom Pane
        HBox bottomPane = new HBox(exitGameButton);
        bottomPane.setAlignment(Pos.BOTTOM_RIGHT);
        bottomPane.setStyle("-fx-padding: 2em");

        // Root Pane
        BorderPane root = new BorderPane();
        root.setTop(headingPane);
        root.setCenter(middleBorderPane);
        root.setBottom(bottomPane);

        // Set window title
        primaryStage.setTitle("Animal");
        // Set scene
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.setResizable(false);
        // Show stage
        primaryStage.show();
    }
}
