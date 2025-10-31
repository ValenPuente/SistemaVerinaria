package modelo;

import java.util.ArrayList;

public class Duenio extends Persona {
    // tiene como atributos propios -->
    ArrayList<Mascota> mascotas = new ArrayList<>(); // relación 1 a n con la clase Mascota, asociación
    // bidireccional!
    private String numTelefono;
    private String email;

    public Duenio(String nombre, String apellido, String numTelefono, String email) {
        super(nombre, apellido);
        this.numTelefono = numTelefono;
        this.email = email;
    }

    // metodo para agregar una mascota al dueño ->
    public void agregarMascota(Mascota mascota){ // recibimos mascota por parámetro
        mascotas.add(mascota);
    }

}
