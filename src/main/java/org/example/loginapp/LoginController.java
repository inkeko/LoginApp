package org.example.loginapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    public void initialize() {
        // Gomb állapotának figyelése
        usernameField.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> checkFields());
    }

    private void checkFields() {
        boolean usernameFilled = !usernameField.getText().trim().isEmpty();
        boolean passwordFilled = !passwordField.getText().trim().isEmpty();
        loginButton.setDisable(!(usernameFilled && passwordFilled));
    }
    @FXML
    public void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();


        if (username.equals("admin") && password.equals("1234")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/dashboard.fxml"));
                Parent root = loader.load();

                // A vezérlő lekérése
                DashboardController controller = loader.getController();
                controller.setWelcomeMessage("Üdvözlünk, " + username + "!");

                // Új ablak megjelenítése
                Stage stage = new Stage();
                stage.setTitle("Főmenü");
                stage.setScene(new Scene(root, 400, 300));
                stage.show();

                // Aktuális ablak bezárása
                ((Stage) usernameField.getScene().getWindow()).close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText("Hibás bejelentkezés");
            alert.setContentText("Hibás felhasználónév vagy jelszó!");
            alert.showAndWait();
        }
    }
}

