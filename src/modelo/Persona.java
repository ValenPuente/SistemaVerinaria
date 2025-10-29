package modelo;

public abstract class Persona {
    // clase padre abstracta de la cual heredan Veterinario y Dueño!
    protected String nombre;
    protected int edad;


    // constructor de la clase padre ->
    public Persona(String nombre){
        this.nombre = nombre;
    }
}
