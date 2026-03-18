package lbaena.projecteminecraft.javafx;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class DeleteController {

    @FXML
    private ListView<String> listView;

    @FXML
    public void initialize() {
        // 🔹 PLACEHOLDER lista
        listView.setItems(FXCollections.observableArrayList(
                "Registro 1",
                "Registro 2",
                "Registro 3"
        ));
    }

    @FXML
    private void handleDelete() {
        String selected = listView.getSelectionModel().getSelectedItem();

        if (selected != null) {
            // 🔹 PLACEHOLDER
            System.out.println("Eliminar: " + selected);
        }

        goToMenu();
    }

    private void goToMenu() {
        try {
            Stage stage = (Stage) listView.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lbaena/projecteminecraft/MainMenu.fxml"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}