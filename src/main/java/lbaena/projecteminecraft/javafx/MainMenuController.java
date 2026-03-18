package lbaena.projecteminecraft.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.Objects;

public class MainMenuController {

    private void changeScene(String fxml) {
        try {
            Stage stage = new Stage();
            stage = (Stage) Stage.getWindows().filtered(w -> w.isShowing()).get(0);
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lbaena/projecteminecraft/" + fxml))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToCreate() {
        changeScene("Create.fxml");
    }

    @FXML
    private void goToDelete() {
        changeScene("Delete.fxml");
    }

    @FXML
    private void goToView() {
        changeScene("View.fxml");
    }
}