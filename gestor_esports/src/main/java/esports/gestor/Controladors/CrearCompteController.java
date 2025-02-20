package esports.gestor.Controladors;

import esports.gestor.Classes.GestorUsuaris;
import esports.gestor.Classes.Usuari;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CrearCompteController {
    @FXML
    private TextField UsuariField;  // Campo para nombre de usuario

    @FXML
    private PasswordField ContrasenyaField;
    @FXML
    private PasswordField RepetirContrasenyaField;// Campo para la contraseña





    public void crearCompte(ActionEvent actionEvent) {
        String username = UsuariField.getText();

        String password = ContrasenyaField.getText();
        String repeatPassword = RepetirContrasenyaField.getText();
        GestorUsuaris gestorUsuaris = new GestorUsuaris();

        if (username == null || username.isEmpty() || password == null || password.isEmpty() || repeatPassword == null || repeatPassword.isEmpty()) {
            // Si los campos están vacíos
            System.out.println("Por favor, ingresa un nombre de usuario y una contraseña.");
        }

        else if (!password.equals(repeatPassword)) {
            System.out.println("Las contraseñas no coinciden.");
        }

        else {
            gestorUsuaris.afegirUsuari(username, password);
            System.out.println("cuenta creada con exito");
            enrereButton(actionEvent);

        }
    }

    public void enrereButton(ActionEvent actionEvent) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

