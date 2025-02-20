package esports.gestor.Controladors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {

    private void carregarVista(String fxml, String titol, Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(titol);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void obrirGestioTornejos(ActionEvent event) {
        // Obtenemos el Stage a partir del botón u otro nodo que disparó el evento
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        carregarVista("/TorneigView.fxml", "Gestió de Tornejos", stage);
    }

    @FXML
    private void obrirGestioParticipants(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        carregarVista("/ParticipantsView.fxml", "Gestió de Participants", stage);
    }

    @FXML
    private void obrirGestioDades(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        carregarVista("/DadesView.fxml", "Gestió de Dades", stage);
    }
}
