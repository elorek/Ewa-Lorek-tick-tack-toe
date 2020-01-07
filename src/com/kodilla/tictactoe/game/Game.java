package com.kodilla.tictactoe.game;

import com.kodilla.tictactoe.logic.Board;
import com.kodilla.tictactoe.logic.Figure;
import com.kodilla.tictactoe.logic.FigureColor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Game {
    private Board board;
    private GridPane gridPane;
    private FigureColor whoseMove = FigureColor.CROSS;
    private Image imageCircle = new Image("file:src/com/kodilla/tictactoe/files/kolko.jpg");
    private Image imageCross = new Image("file:src/com/kodilla/tictactoe/files/krzyzyk.jpg");
    private boolean willReset = false;
    private Window stage;
    private final Stage dialog;
    private final VBox dialogVbox;

    public Game(Board board, GridPane gridPane, Stage stage) {
        this.board = board;
        this.gridPane = gridPane;
        this.stage = stage;
        this.gridPane.setOnMouseClicked(d -> {
            if (!willReset) {
                System.out.println(d.getX() + "," + d.getY());
                int x = (int) (d.getX() / 300);
                int y = (int) (d.getY() / 300);
                System.out.println(x + "," + y);
                boolean moved = board.doMove(x, y, new Figure(whoseMove));
                if (moved) {
                    whoseMove = getOpposite(whoseMove);
                    display();
                    checkWinner();
                }
                display();
            } else {
                board.resetBoard();
                display();
                willReset = false;
            }
        });
        dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        dialogVbox = new VBox(20);
        Scene dialogScene = new Scene(dialogVbox, 350, 100);
        dialog.setScene(dialogScene);
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

    private void checkWinner() {
        FigureColor winner = FigureColor.NONE;
        for (int col = 0; col < 3; col++) {
            winner = (winner == FigureColor.NONE) ? checkColumnWinner(col, FigureColor.CROSS) : winner;
            winner = (winner == FigureColor.NONE) ? checkColumnWinner(col, FigureColor.CIRCLE) : winner;
        }
        for (int row = 0; row < 3; row++) {
            winner = (winner == FigureColor.NONE) ? checkRowWinner(row, FigureColor.CROSS) : winner;
            winner = (winner == FigureColor.NONE) ? checkRowWinner(row, FigureColor.CIRCLE) : winner;
        }
        for (int diag = 0; diag < 3; diag++) {
            winner = (winner == FigureColor.NONE) ? checkFirstDiagonalWinner(diag, FigureColor.CROSS) : winner;
            winner = (winner == FigureColor.NONE) ? checkFirstDiagonalWinner(diag, FigureColor.CIRCLE) : winner;
        }
        for (int diag = 0; diag < 3; diag++) {
            winner = (winner == FigureColor.NONE) ? checkSecondDiagonalWinner(diag, FigureColor.CROSS) : winner;
            winner = (winner == FigureColor.NONE) ? checkSecondDiagonalWinner(diag, FigureColor.CIRCLE) : winner;
        }
        if (winner != FigureColor.NONE) {
            display();
            dialogVbox.getChildren().clear();
            dialogVbox.getChildren().add(new Text("The winner is: " + winner));
            dialog.show();
            willReset = true;
        }
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

    private FigureColor checkFirstDiagonalWinner(int diag, FigureColor color) {
        FigureColor winner = FigureColor.NONE;
        if (board.getFigure(0, 0).getColor() == color &&
                board.getFigure(1, 1).getColor() == color &&
                board.getFigure(2, 2).getColor() == color) {
            winner = color;
        }
        return winner;
    }

    private FigureColor checkSecondDiagonalWinner(int diag, FigureColor color) {
        FigureColor winner = FigureColor.NONE;
        if (board.getFigure(0, 2).getColor() == color &&
                board.getFigure(1, 1).getColor() == color &&
                board.getFigure(2, 0).getColor() == color) {
            winner = color;
        }
        return winner;
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
