module org.example.loginapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens org.example.loginapp to javafx.fxml;
    exports org.example.loginapp;
}