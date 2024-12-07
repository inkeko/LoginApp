package org.example.loginapp;



import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label welcomeLabel;

    public void setWelcomeMessage(String message) {
        welcomeLabel.setText(message);
    }
}

