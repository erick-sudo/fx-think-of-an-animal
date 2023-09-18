# Guessing Game - Animal

In the game, the player is asked to think of an animal.
- The computer then tries to work out the animal the user is thinking of by asking a series of yes/no questions.
- Non-leaf nodes in the tree represent decision points/questions.
- If the answer is yes, the computer then progresses to the right subtree to continue trying to identify the animal.
- If the answer is no, the computer progresses to the left subtree to continue trying to identify the animal.
- When the computer reaches a leaf node, the node will contain an answer (i.e. an animal).
- The computer will then ask the user if that is the animal.
- If the computer has correctly identified the animal, it wins and displays an appropriate message.
- If the computer does not correctly identify the animal, the player wins and the computer displays an appropriate message and asks for a distinguishing/differentiating question, adds that question to the tree and adds the new animal to the tree.
- The tree can continue to grow as you play the game.
- The player will then be asked if he/she wishes to play again. The game continues until the player gives a negative response.


```
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
```

```agsl
private boolean infoQueryDialogue(String info) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Choose");
        alert.setHeaderText(info);
        alert.setGraphic(null);
        Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
        alertStage.initModality(Modality.APPLICATION_MODAL);
        alertStage.initStyle(StageStyle.UTILITY);
        alertStage.setAlwaysOnTop(true);

        // Customize the buttons
        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");
        alert.getButtonTypes().setAll(yesButton, noButton);

        AtomicReference<ButtonType> responseButton = new AtomicReference<>();

        alert.showAndWait().ifPresent(result -> {
            if(result == yesButton) {
                responseButton.set(result);
            } else if (result == noButton) {
                responseButton.set(result);
            }
        });

        return responseButton.get().getText().equals("Yes") ? true : false;
    }

    private String requestAnswerDialogue(String question) {
        // A text field with a custom text formatter
        TextField animalInputTextField = new TextField();

        // A text input dialog
        TextInputDialog animalInputDialog = new TextInputDialog();
        animalInputDialog.setTitle("Confirmation");
        animalInputDialog.setHeaderText(question);
        animalInputDialog.getDialogPane().setContent(new VBox(animalInputTextField));

        Stage alertStage = (Stage) animalInputDialog.getDialogPane().getScene().getWindow();
        alertStage.initModality(Modality.APPLICATION_MODAL);
        alertStage.initStyle(StageStyle.UTILITY);
        alertStage.setAlwaysOnTop(true);

        // Lookup for the ok button and disable it by default
        Button okButton = (Button) animalInputDialog.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setDisable(true);
        // Bind the button's disable property to the text property of 'animalInputTextField'
        okButton.disableProperty().bind(animalInputTextField.textProperty().isEmpty());

        // Wait animal input confirmation
        Optional<String> optionalAnimal = animalInputDialog.showAndWait();

        if(optionalAnimal.isPresent()) {
            return animalInputTextField.getText();
        } else {
            return null;
        }
    }
```

```agsl
//        // Button Styles
//        String buttonStyles = "-fx-padding: 5px; -fx-font-weight: bold; -fx-text-fill: teal; -fx-border-width: 1px; -fx-border-color: teal; ";
//
//        // Load game button
//        Button loadGameButton = new Button("Load a Game");
//        loadGameButton.setStyle(buttonStyles);
//
//        // Save game button
//        Button saveGameButton = new Button("Save a Game");
//        saveGameButton.setStyle(buttonStyles);
//
//        // Display Tree button
//        Button displayGameButton = new Button("Display the Tree");
//        displayGameButton.setStyle(buttonStyles);
//
//        // Play game button
//        Button playGameButton = new Button("Play Game");
//        playGameButton.setStyle(buttonStyles);
//        playGameButton.setOnAction(e -> game.play());
//
//        // Exit game button
//        Button exitGameButton = new Button("Exit");
//        exitGameButton.setStyle(buttonStyles + " -fx-min-width: 300px");
//        exitGameButton.setOnAction(e -> System.exit(0));
//
//        // Heading label
//        Label headingLabel = new Label("Animal Guessing Game");
//        headingLabel.setFont(new Font("Arial", 24));
//        headingLabel.setStyle("-fx-padding: 0.6em; -fx-text-fill: teal; -fx-font-weight: bolder;");
//        BorderPane headingPane = new BorderPane();
//        headingPane.setCenter(headingLabel);
//
//        // Text area for messages
//        TextArea gameTextArea = new TextArea("Think of an animal. If my tree is non-empty, I will ask yes/no questions to try to work out your animal. Think of an animal now and press play to start.");
//        gameTextArea.setWrapText(true);
//
//        // Control widgets to the scene
//        VBox leftSidePane = new VBox();
//        leftSidePane.getChildren().addAll(
//                loadGameButton,
//                saveGameButton,
//                displayGameButton,
//                playGameButton
//        );
//        leftSidePane.setSpacing(40);
//        leftSidePane.setStyle("-fx-padding: 1em");
//
//        BorderPane middleBorderPane = new BorderPane();
//
//        // Middle border pane
//        middleBorderPane.setLeft(leftSidePane);
//        middleBorderPane.setCenter(gameTextArea);
//        middleBorderPane.setStyle("-fx-padding: 0.4em;");
//
//        // Bottom Pane
//        HBox bottomPane = new HBox(exitGameButton);
//        bottomPane.setAlignment(Pos.BOTTOM_RIGHT);
//        bottomPane.setStyle("-fx-padding: 2em");
//
//        // Root Pane
//        BorderPane root = new BorderPane();
//        root.setTop(headingPane);
//        root.setCenter(middleBorderPane);
//        root.setBottom(bottomPane);
//
//        // Set window title
//        primaryStage.setTitle("Animal");
//        // Set scene
//        primaryStage.setScene(new Scene(root, 700, 500));
//        primaryStage.setResizable(false);
//        // Show stage
//        primaryStage.show();
```