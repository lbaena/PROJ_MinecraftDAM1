package lbaena.projecteminecraft.javafx;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lbaena.projecteminecraft.animals.AnimalHandler;

import java.util.Objects;

public class DeleteController {

    @FXML
    private ComboBox<String> animalClassCombo;
    @FXML
    private TextField nameField;

    @FXML
    public void initialize() {
        animalClassCombo.setItems(FXCollections.observableArrayList("Cow", "Chicken", "Fish", "Octopus"));
    }

    @FXML
    private void handleDelete() {
        String selectedType = animalClassCombo.getValue();
        String name = nameField.getText();

        if (selectedType == null) {
            showAlert(Alert.AlertType.ERROR, "Validació", "Selecciona un tipus d'animal");
            return;
        }
        if (name == null || name.trim().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validació", "Introdueix el nom de l'animal");
            return;
        }

        boolean removed = AnimalHandler.removeAnimalByTypeAndName(selectedType, name);

        if (removed) {
            showAlert(Alert.AlertType.INFORMATION, "Correcte", "Animal eliminat correctament");
            goToMenu();
            return;
        }

        showAlert(Alert.AlertType.WARNING, "No trobat", "No s'ha trobat cap animal amb aquest nom");
    }

    @FXML
    private void goToMenu() {
        try {
            Stage stage = (Stage) animalClassCombo.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/lbaena/projecteminecraft/MainMenu.fxml")))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handleBack() {
        goToMenu();
    }
}