package com.kodilla.tictactoe;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class CongratulationsWindow {
    public void ShowCongratulations() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Congratulations! You won! Do you want to play again?");
        alert.showAndWait();
        Button button1 = new Button("Yes");
        Button button2 = new Button("No");
        //button1.setOnAction(event -> );
        button2.setOnAction(event -> MenuOperating.closeProgram());

    }
}
