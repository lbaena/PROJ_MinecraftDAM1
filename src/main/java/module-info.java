module lbaena.projecteminecraft {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires com.google.zxing;
    requires java.desktop;
    requires com.google.zxing.javase;


    opens lbaena.projecteminecraft to javafx.fxml;
    exports lbaena.projecteminecraft;
}