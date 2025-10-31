package modelo;

public abstract class Mascota {
    // clase padre de las mascotas que heredarán los atributos -->
    protected String nombre;
    protected int edad;
    protected Duenio duenio; // relación de asociación bidireccional 1 a n con la clase Dueño!


    // constructor de la clase mascota ->
    public Mascota(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
        this.duenio = duenio;
    }

    // métodos getters ->
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public Duenio getDuenio() {
        return duenio;
    }
}
