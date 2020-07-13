module SpringingGradleDog {

    requires javafx.fxml;
    requires javafx.controls;
    requires com.google.gson;

    opens sons.mamoun to javafx.fxml;
    exports sons.mamoun ;
}