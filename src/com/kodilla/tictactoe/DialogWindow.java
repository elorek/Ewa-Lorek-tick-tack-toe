package com.kodilla.tictactoe;

import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;

public class DialogWindow {
    public static JPanel prepareDialogWindow() {
        JPanel dialogWindow = new JPanel();
        dialogWindow.setSize(new Dimension(300, 150));
        dialogWindow.setLayout(null);
        JLabel hello = new JLabel("Hello, this is a tic-tac-toe game!");
        hello.setVerticalAlignment(SwingConstants.TOP);
        hello.setBounds(20, 20, 200, 30);
        hello.setHorizontalAlignment(SwingConstants.CENTER);
        hello.setVerticalAlignment(SwingConstants.CENTER);
        dialogWindow.add(hello);
        String name = JOptionPane.showInputDialog("What's your name?");
        JOptionPane.showMessageDialog(null, "My name is " + name);
        Button play = new Button("Let's play!");
        play.setOnAction(event -> dialogWindow.setVisible(false));
        return dialogWindow;

    }
}





