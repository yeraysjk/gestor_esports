package esports.gestor.Classes;

public class Usuari {
    private String nomUsuari;
    private String contrasenya;

    @Override
    public String toString() {
        return "Usuari{" +
                "nomUsuari='" + nomUsuari + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                '}';
    }

    public Usuari(String nomUsuari, String contrasenya) {
        this.nomUsuari = nomUsuari;
        this.contrasenya = contrasenya;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public boolean validarContrasenya(String contrasenya) {
        return this.contrasenya.equals(contrasenya);
    }
}
