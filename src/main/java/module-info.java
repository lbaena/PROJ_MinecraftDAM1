module lbaena.projecteminecraft {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires com.google.zxing;
    requires java.desktop;
    requires com.google.zxing.javase;
    requires java.sql;


    opens lbaena.projecteminecraft to javafx.fxml;
    exports lbaena.projecteminecraft;
    exports lbaena.projecteminecraft.javafx;
    opens lbaena.projecteminecraft.javafx to javafx.fxml;
}