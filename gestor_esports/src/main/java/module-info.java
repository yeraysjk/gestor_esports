module esports.gestor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens esports.gestor to javafx.fxml;
    opens esports.gestor.Controladors to javafx.fxml;

    exports esports.gestor;
}