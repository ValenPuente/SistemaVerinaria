package modelo;

import java.util.ArrayList;

public class Duenio extends Persona {
    // tiene como atributos propios -->
    private String numTelefono;
    private String email;

    public Duenio(String nombre, String apellido, String numTelefono, String email) {
        super(nombre, apellido);
        this.numTelefono = numTelefono;
        this.email = email;
    }

    //getters ->
    public String getNumTelefono() {
        return numTelefono;
    }

    public String getEmail() {
        return email;
    }
}
