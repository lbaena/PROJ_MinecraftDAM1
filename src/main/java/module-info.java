module lbaena.projecteminecraft {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens lbaena.projecteminecraft to javafx.fxml;
    exports lbaena.projecteminecraft;
}