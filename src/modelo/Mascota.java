package modelo;

public class Mascota {
    // clase padre de las mascotas que heredarán los atributos -->
    private String id;
    private String tipo;
    private String nombre;
    private String edad;
    private Duenio duenio; // relación de asociación bidireccional 1 a n con la clase Dueño!


    // constructor de la clase mascota ->
    public Mascota(String tipo, String nombre, String edad, Duenio duenio){
        this.nombre = nombre;
        this.edad = edad;
        this.duenio = duenio;
    }

    // métodos getters ->
    public String getTipo() { return tipo;}
    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public Duenio getDuenio() { return duenio; }
}
