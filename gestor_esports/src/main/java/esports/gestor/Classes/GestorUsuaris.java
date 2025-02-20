package esports.gestor.Classes;
import java.util.HashMap;
import java.util.Map;

public class GestorUsuaris {

    public Map<String, Usuari> usuaris;

    public GestorUsuaris() {
        usuaris = new HashMap<>();
        // Afegim un usuari per prova
        usuaris.put("admin", new Usuari("admin", "1234"));
    }

    public boolean autenticarUsuari(String nomUsuari, String contrasenya) {
        Usuari usuari = usuaris.get(nomUsuari);
        return usuari != null && usuari.validarContrasenya(contrasenya);
    }

    public void afegirUsuari(String nomUsuari, String contrasenya) {
        if (!usuaris.containsKey(nomUsuari)) {
            usuaris.put(nomUsuari, new Usuari(nomUsuari, contrasenya));
        } else {
            System.out.println("⚠️ Aquest usuari ja existeix!");
        }
    }
}
