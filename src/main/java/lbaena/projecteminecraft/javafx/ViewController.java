package lbaena.projecteminecraft.javafx;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import lbaena.projecteminecraft.classes.Animal;
import lbaena.projecteminecraft.classes.Chicken;

import java.util.ArrayList;
import java.util.List;

public class ViewController {

    @FXML
    private ListView<String[]> listView;

    @FXML
    public void initialize() {
        List<Animal> animals = new ArrayList<>();

        animals.addAll(Chicken.getChickens());
        animals.addAll(.getChickens());
        animals.addAll(Chicken.getChickens());
        animals.addAll(Chicken.getChickens());


        listView.setItems(FXCollections.observableArrayList(datos));

        listView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(String[] item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    StringBuilder sb = new StringBuilder();

                    for (int i = 0; i < item.length; i++) {
                        sb.append("Campo ").append(i + 1).append(": ")
                                .append(item[i]).append("\n");
                    }

                    setText(sb.toString());
                }
            }
        });
    }

    @FXML
    private void goToMenu() {
        try {
            Stage stage = (Stage) listView.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lbaena/projecteminecraft/MainMenu.fxml"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}