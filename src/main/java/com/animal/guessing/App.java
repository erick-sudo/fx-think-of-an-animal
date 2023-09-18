package com.animal.guessing;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static void main(String...args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 550);

        // Create a view
        Controller controllerView = new Controller();

        // Create a game
        Game game = new Game(controllerView);

        // Bind view to game
        controllerView.bind(game);

        stage.setScene(scene);
        stage.show();
    }
}
