package esports.gestor.Controladors;

import esports.gestor.Classes.GestorUsuaris;
import esports.gestor.Classes.Usuari;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginController {
    GestorUsuaris gestorUsuaris = new GestorUsuaris();
    @FXML
    private TextField usernameField;  // Campo para nombre de usuario

    @FXML
    private PasswordField passwordField;  // Campo para la contraseña

    // Método que se ejecuta cuando se hace clic en el botón de login
    @FXML
    private void onLoginClick(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            // Si los campos están vacíos
            System.out.println("Por favor, ingresa un nombre de usuario y una contraseña.");
        } else {
            // Validación de usuario (reemplaza con tu propia lógica)
            if (gestorUsuaris.autenticarUsuari(username, password)) {
                // Si las credenciales son correctas, cambiar de pantalla
                cambiarPantalla("/MainView.fxml");
            } else {
                // Si las credenciales son incorrectas
                System.out.println("Credenciales incorrectas.");
            }
        }
    }
    @FXML
    private void onRegisterClick(ActionEvent event) {
        cambiarPantalla("/CrearCompteView.fxml");
    }


    // Método para cambiar de pantalla (cargar la siguiente pantalla)
    private void cambiarPantalla(String pantalla) {
        try {
            // Cargar la nueva pantalla (FXML)
            FXMLLoader loader = new FXMLLoader(getClass().getResource(pantalla));
            Parent root = loader.load();

            // Obtener el escenario actual
            Stage stage = (Stage) usernameField.getScene().getWindow();

            // Establecer la nueva escena
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
