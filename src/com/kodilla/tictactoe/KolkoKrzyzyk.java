package com.kodilla.tictactoe;

import com.kodilla.tictactoe.game.Game;
import com.kodilla.tictactoe.logic.Board;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KolkoKrzyzyk extends Application {
    private Image imageback = new Image("files/tlo.jpg");


    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        StackPane stackPane = new StackPane();
        stackPane.setBackground(background);
        Scene scene = new Scene(stackPane, 1600, 900, Color.BEIGE);

        stackPane.getChildren().add(MenuMaking.prepareMenu());
        stackPane.setAlignment(Pos.TOP_LEFT);
          

        primaryStage.setAlwaysOnTop(false);
        primaryStage.setOnCloseRequest((event -> MenuOperating.closeProgram()));
        primaryStage.getIcons().add(new Image("files/ikonka.jpg"));
        primaryStage.setHeight(600.0);
        primaryStage.setWidth(900.0);
        primaryStage.setMinHeight(300.0);
        primaryStage.setMinWidth(450.0);
        primaryStage.setTitle("Tic-tac-toe");
        primaryStage.setScene(scene);
        Game game = new Game(new Board(), stackPane);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


