package com.kodilla.tictactoe.game;

import com.kodilla.tictactoe.logic.Board;
import com.kodilla.tictactoe.logic.Figure;
import com.kodilla.tictactoe.logic.FigureColor;
import javafx.scene.layout.StackPane;

public class Game {
    private Board board;
    private StackPane stackPane;
    private FigureColor whoseMove = FigureColor.CROSS;

    public Game(Board board, StackPane stackPane) {
        this.board = board;
        this.stackPane = stackPane;
        this.stackPane.setOnMouseClicked(d -> {
            System.out.println(d.getX() + "," + d.getY());
            int x = (int) (d.getX() / 300);
            int y = (int) (d.getY() / 180);
            System.out.println(x + "," + y);
            boolean moved = board.doMove(x, y, new Figure(whoseMove));
            if (moved) {
                whoseMove = getOpposite(whoseMove);
            }
            display();
        });

    }

    private void display() {
        stackPane.getChildren().clear();
        for(int x=0; x<3; x++) {
            for(int y=0; y<3; y++) {
                Figure figure = board.getFigure(x, y);
                // w zaleznosci od figure.getcolor() ustawic odpowiedni obrazek w x, y na stackpane
            }
        }
    }

    private FigureColor getOpposite(FigureColor whoseMove) {
        if (whoseMove == FigureColor.CIRCLE) {
            return FigureColor.CROSS;
        } else {
            return FigureColor.CIRCLE;
        }
    }
}
