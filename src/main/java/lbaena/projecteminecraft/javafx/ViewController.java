package lbaena.projecteminecraft.javafx;

import com.google.zxing.WriterException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lbaena.projecteminecraft.classes.*;
import lbaena.projecteminecraft.utils.QRCodeGeneratorUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewController {

    private static final int QR_SIZE = 90;

    @FXML
    private ListView<String[]> listView;

    private final Map<String, Image> qrCache = new HashMap<>();

    @FXML
    public void initialize() {
        List<Animal> animals = new ArrayList<>();

        animals.addAll(Chicken.getChickens());
        animals.addAll(Cow.getCows());
        animals.addAll(Octupus.getOctopuses());
        animals.addAll(Fish.getFishes());

        String[][] data = new String[animals.size()][];

        for (int i = 0; i < animals.size(); i++) {
            data[i] = animals.get(i).getParameters();
        }

        listView.setItems(FXCollections.observableArrayList(data));

        listView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(String[] item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                    return;
                }

                VBox linesBox = new VBox(8);

                for (String line : item) {
                    if (line == null || line.isBlank()) {
                        continue;
                    }

                    Label label = new Label(line);
                    label.setWrapText(true);

                    HBox lineBox = new HBox(12);
                    lineBox.setAlignment(Pos.CENTER_LEFT);

                    Image qrImage = getOrCreateQrImage(line);
                    if (qrImage != null) {
                        ImageView qrView = new ImageView(qrImage);
                        qrView.setFitWidth(QR_SIZE);
                        qrView.setFitHeight(QR_SIZE);
                        qrView.setPreserveRatio(true);
                        lineBox.getChildren().addAll(label, qrView);
                    } else {
                        lineBox.getChildren().add(label);
                    }

                    linesBox.getChildren().add(lineBox);
                }

                setText(null);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setGraphic(linesBox);
            }
        });
    }

    private Image getOrCreateQrImage(String line) {
        return qrCache.computeIfAbsent(line, this::generateQrImage);
    }

    private Image generateQrImage(String line) {
        try {
            String dataUri = QRCodeGeneratorUtil.createQR(line, QR_SIZE, QR_SIZE);
            int commaIndex = dataUri.indexOf(',');
            String base64 = commaIndex >= 0 ? dataUri.substring(commaIndex + 1) : dataUri;
            byte[] bytes = Base64.getDecoder().decode(base64);
            return new Image(new ByteArrayInputStream(bytes));
        } catch (WriterException | IOException | IllegalArgumentException e) {
            return null;
        }
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