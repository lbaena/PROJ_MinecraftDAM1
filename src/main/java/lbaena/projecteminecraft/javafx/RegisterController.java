package lbaena.projecteminecraft.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lbaena.projecteminecraft.users.UserHandler;

public class RegisterController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleRegister() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        UserHandler handler = new UserHandler();

        if (handler.addNewUser(name, email, password)) {
            showAlert("Éxito", "Usuario creado correctamente");
            goToLogin();
        } else {
            showAlert("Error", "No se pudo crear el usuario");
        }
    }

    @FXML
    private void goToLogin() {
        try {
            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lbaena/projecteminecraft/login.fxml"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}