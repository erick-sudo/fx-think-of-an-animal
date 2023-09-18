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
        stage.setTitle("Animal");
        Scene scene = new Scene(fxmlLoader.load(), 1000, 550);

        // Create a view
        Controller controllerView = fxmlLoader.getController();

        // Create a game
        Game game = new Game(controllerView);

        // Bind view to game
        controllerView.bind(game);

        stage.setScene(scene);
        stage.show();
    }
}
