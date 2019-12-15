package com.kodilla.tictactoe;

import javafx.application.Platform;

public class MenuOperating {
    //public static void newGame() {}
    //public static void undo() {}
    public static void closeProgram() {
        Platform.exit();
        System.exit(0);
    }
}

