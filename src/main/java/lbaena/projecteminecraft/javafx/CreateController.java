package lbaena.projecteminecraft.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateController {

    @FXML
    private TextField field1, field2, field3;

    @FXML
    private void handleCreate() {
        String f1 = field1.getText();
        String f2 = field2.getText();
        String f3 = field3.getText();

        // 🔹 PLACEHOLDER
        System.out.println("Crear: " + f1 + ", " + f2 + ", " + f3);

        goToMenu();
    }

    private void goToMenu() {
        try {
            Stage stage = (Stage) field1.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lbaena/projecteminecraft/MainMenu.fxml"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}