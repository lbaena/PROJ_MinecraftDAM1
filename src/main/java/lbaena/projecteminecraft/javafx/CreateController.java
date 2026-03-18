package lbaena.projecteminecraft.javafx;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lbaena.projecteminecraft.classes.Animal;
import lbaena.projecteminecraft.classes.Chicken;
import lbaena.projecteminecraft.classes.Cow;
import lbaena.projecteminecraft.classes.Fish;
import lbaena.projecteminecraft.classes.Octupus;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

public class CreateController {

    @FXML
    private ComboBox<String> animalClassCombo;
    @FXML
    private TextField nameField;
    @FXML
    private TextArea descriptionField;
    @FXML
    private TextField ageField;
    @FXML
    private ComboBox<String> genderCombo;
    @FXML
    private TextField weightField;
    @FXML
    private Spinner<Integer> healthPointsSpinner;
    @FXML
    private Spinner<Integer> hungerSpinner;
    @FXML
    private TextField typeField;
    @FXML
    private TextField habitatField;
    @FXML
    private TextField uuidField;

    private static final Map<String, Supplier<Animal>> ANIMAL_FACTORY = Map.of(
            "Cow", Cow::new,
            "Chicken", Chicken::new,
            "Fish", Fish::new,
            "Octopus", Octupus::new
    );

    @FXML
    public void initialize() {
        animalClassCombo.setItems(FXCollections.observableArrayList("Cow", "Chicken", "Fish", "Octopus"));
        genderCombo.setItems(FXCollections.observableArrayList("Male", "Female"));
        healthPointsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 200, 100));
        hungerSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        animalClassCombo.valueProperty().addListener((obs, oldValue, newValue) -> updateAutomaticFields(newValue));
        if (animalClassCombo.getValue() != null) {
            updateAutomaticFields(animalClassCombo.getValue());
        }
    }

    @FXML
    private void handleCreate() {
        if (!isInputValid()) {
            return;
        }

        Animal animal = createAnimalInstance(animalClassCombo.getValue());
        if (animal == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Animal type not supported");
            return;
        }

        animal.name = nameField.getText().trim();
        animal.description = descriptionField.getText().trim();
        animal.age = ageField.getText().trim();
        animal.gender = genderCombo.getValue();
        animal.weight = weightField.getText().trim();

        UUID generatedUuid = UUID.randomUUID();
        animal.uuid = generatedUuid;
        uuidField.setText(generatedUuid.toString());

        setAnimalStatus(animal, healthPointsSpinner.getValue(), hungerSpinner.getValue());

        animal.saveToFile();

        showAlert(Alert.AlertType.INFORMATION, "Success", "Animal created correctly");
        goToMenu();
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

    private void updateAutomaticFields(String selectedClass) {
        Animal animal = createAnimalInstance(selectedClass);

        if (animal == null) {
            typeField.clear();
            habitatField.clear();
            uuidField.clear();
            return;
        }

        typeField.setText(animal.getType().getDisplayName());
        habitatField.setText(animal.getHabitat().getDisplayName());
        uuidField.setText(UUID.randomUUID().toString());
    }

    private Animal createAnimalInstance(String selectedClass) {
        Supplier<Animal> supplier = ANIMAL_FACTORY.get(selectedClass);
        return supplier != null ? supplier.get() : null;
    }

    private boolean isInputValid() {
        if (animalClassCombo.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, "Validation", "Selecciona un tipus d'Animal");
            return false;
        }
        if (nameField.getText() == null || nameField.getText().trim().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation", "El nom és obligatori");
            return false;
        }
        if (descriptionField.getText() == null || descriptionField.getText().trim().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation", "La descripció es obligatòria");
            return false;
        }
        if (ageField.getText() == null || ageField.getText().trim().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation", "L'edat es obligatòria");
            return false;
        }
        if (genderCombo.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, "Validation", "Selecciona un gènere");
            return false;
        }
        if (weightField.getText() == null || weightField.getText().trim().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation", "El pes de l'animal és obligatori");
            return false;
        }

        return true;
    }

    private void setAnimalStatus(Animal animal, int healthPoints, int hunger) {
        try {
            Field healthField = Animal.class.getDeclaredField("healthPoints");
            Field hungerField = Animal.class.getDeclaredField("hunger");
            healthField.setAccessible(true);
            hungerField.setAccessible(true);
            healthField.setInt(animal, healthPoints);
            hungerField.setInt(animal, hunger);
        } catch (ReflectiveOperationException e) {}
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}