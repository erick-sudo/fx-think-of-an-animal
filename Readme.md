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
