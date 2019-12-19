package com.kodilla.tictactoe.game;

import com.kodilla.tictactoe.logic.Board;
import com.kodilla.tictactoe.logic.Figure;
import com.kodilla.tictactoe.logic.FigureColor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Game {
    private Board board;
    private GridPane gridPane;
    private FigureColor whoseMove = FigureColor.CROSS;
    private Image imageCircle = new Image("files/kolko.jpg");
    private Image imageCross = new Image("files/krzyzyk.jpg");

    public Game(Board board, GridPane gridPane) {
        this.board = board;
        this.gridPane = gridPane;
        this.gridPane.setOnMouseClicked(d -> {
            System.out.println(d.getX() + "," + d.getY());
            int x = (int) (d.getX() / 300);
            int y = (int) (d.getY() / 180);
            System.out.println(x + "," + y);
            boolean moved = board.doMove(x, y, new Figure(whoseMove));
            if (moved) {
                whoseMove = getOpposite(whoseMove);
                checkWinner();

            }
            display();
        });

    }

    private void checkWinner() {
        FigureColor winner = FigureColor.NONE;
        for (int col = 0; col < 3; col++) {
            winner = (winner == FigureColor.NONE) ? checkColumnWinner(col, FigureColor.CROSS) : winner;
            winner = (winner == FigureColor.NONE) ? checkColumnWinner(col, FigureColor.CIRCLE) : winner;
        }
        for(int row = 0; row<3; row++) {
            winner = (winner == FigureColor.NONE) ? checkRowWinner(row, FigureColor.CROSS) : winner;
            winner = (winner == FigureColor.NONE) ? checkRowWinner(row, FigureColor.CIRCLE) : winner;
        }
        // dodac sprawdzenie po przekatnych

        // jezeli winner rozny od NONE to wyswietl komunikat ze ktos wygral
    }

    private FigureColor checkRowWinner(int row, FigureColor color) {
        FigureColor winner = FigureColor.NONE;
        if (board.getFigure(0, row).getColor() == color &&
                board.getFigure(1, row).getColor() == color &&
                board.getFigure(2, row).getColor() == color) {
            winner = color;
        }
        return winner;
    }

    private FigureColor checkColumnWinner(int col, FigureColor color) {
        FigureColor winner = FigureColor.NONE;
        if (board.getFigure(col, 0).getColor() == color &&
                board.getFigure(col, 1).getColor() == color &&
                board.getFigure(col, 2).getColor() == color) {
            winner = color;
        }
        return winner;
    }

    private void display() {
        gridPane.getChildren().clear();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Image image = getImage(board.getFigure(x, y));
                ImageView view = new ImageView(image);
                gridPane.add(view, x, y);
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

    public Image getImage(Figure figure) {
        if (figure.getColor() == FigureColor.CROSS)
            return imageCross;
        else if (figure.getColor() == FigureColor.CIRCLE)
            return imageCircle;
        else
            return null;
    }
}
