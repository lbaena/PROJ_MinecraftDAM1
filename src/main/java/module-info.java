module lbaena.projecteminecraft {
    requires javafx.controls;
    requires javafx.fxml;


    opens lbaena.projecteminecraft to javafx.fxml;
    exports lbaena.projecteminecraft;
}