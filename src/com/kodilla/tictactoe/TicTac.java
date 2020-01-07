package com.kodilla.tictactoe;

import com.kodilla.tictactoe.game.Game;
import com.kodilla.tictactoe.logic.Board;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;

public class TicTac extends Application {
    private Image imageback = new Image("file:src/com/kodilla/tictactoe/files/tlo.jpg");

    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        GridPane gridPane = new GridPane();
        gridPane.setBackground(background);
        Scene scene = new Scene(gridPane, 900, 900, Color.BEIGE);
        JPanel congrats = new JPanel();
        congrats.add(new JLabel("Congratulations, you won!"));
        for(int i=0; i<3; i++) {
            gridPane.getColumnConstraints().add(new ColumnConstraints(302));
            gridPane.getRowConstraints().add(new RowConstraints(285));
        }
        primaryStage.getIcons().add(new Image("file:src/com/kodilla/tictactoe/files/ikonka.jpg"));
        primaryStage.setHeight(900.0);
        primaryStage.setWidth(900.0);
        primaryStage.setMinHeight(900.0);
        primaryStage.setMinWidth(900.0);
        primaryStage.setTitle("Tic-tac-toe");
        primaryStage.setScene(scene);
        Game game = new Game(new Board(), gridPane, primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


