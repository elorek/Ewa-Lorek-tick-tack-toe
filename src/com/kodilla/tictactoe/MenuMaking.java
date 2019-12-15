package com.kodilla.tictactoe;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuMaking {
    public static MenuBar prepareMenu() {
        MenuBar menu = new MenuBar();
        Menu file = new Menu("File");
        MenuItem newGame = new MenuItem("New Game");
        MenuItem undo = new MenuItem("Undo");
        MenuItem exit = new MenuItem("Exit");
        //newGame.setOnAction(event ->
        //undo.setOnAction(event ->
        exit.setOnAction(event -> MenuOperating.closeProgram());
        file.getItems().add(newGame);
        file.getItems().add(undo);
        file.getItems().add(exit);
        menu.getMenus().add(file);

        return menu;
    }
}

