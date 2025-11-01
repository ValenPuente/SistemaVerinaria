package modelo;

public class Veterinario extends Persona {
    // clase que modela la entidad de los veterinarios!!
    // atributos
    private String idEmpleado; // lo ponemos en final porque no queremos que cambie!
    private String clave; // lo ponemos en final porque no queremos que cambie!


    // constructor ->
    public Veterinario(String idEmpleado, String nombre, String apellido, String clave){
        super(nombre, apellido); // llama al constructor de la clase padre!!
        this.idEmpleado = idEmpleado;
        this.clave = clave;
    }

    public Veterinario(String nombre, String apellido) {
        super(nombre, apellido);
    }

    // getters ->
    public String getIdEmpleado() {
        return idEmpleado;
    }
    public String getClave() {
        return clave;
    }

}
