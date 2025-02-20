package esports.gestor.Controladors;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class TorneigController {
    @FXML
    private TextField nomTorneigField;
    @FXML
    private TextField dataTorneigField;
    @FXML
    private TextField jocTorneigField;
    @FXML
    private TextField formatTorneigField;
    @FXML
    private TextField premisTorneigField;


    @FXML
    private void crearTorneig(ActionEvent event) {
        System.out.println("Creant torneig...");
    }
    @FXML
    private void modificarTorneig(ActionEvent event) {
        System.out.println("Modificant torneig...");
    }
    @FXML
    private void eliminarTorneig(ActionEvent event) {
        System.out.println("Eliminant torneig...");
    }

    @FXML
    private void enrereButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
