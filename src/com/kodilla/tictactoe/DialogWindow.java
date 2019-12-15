package com.kodilla.tictactoe;

import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;

public class DialogWindow {
    private JTextField nameField;

    public DialogWindow(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void prepareDialogWindow() {
        JPanel dialogWindow = new JPanel();
        dialogWindow.setSize(new Dimension(300, 150));
        dialogWindow.setLayout(null);
        JLabel hello = new JLabel("Hello, this is a tic-tac-toe game!");
        hello.setVerticalAlignment(SwingConstants.TOP);
        hello.setBounds(20, 20, 200, 30);
        hello.setHorizontalAlignment(SwingConstants.CENTER);
        hello.setVerticalAlignment(SwingConstants.CENTER);
        JLabel name = new JLabel("Name: ");
        name.setBounds(20, 30, 200, 30);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        dialogWindow.add(hello, name);
        JTextField nameField = new JTextField();
        nameField.setBounds(170, 30, 200, 30);
        dialogWindow.add(nameField);
        JLabel crossOrCircle = new JLabel("Do you want to have crosses or circles?");
        Button play = new Button();
        play.setText("Let's play!");
        //play.setOnAction();
    }

}

