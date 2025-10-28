package modelo;

public class Veterinario {
    // clase que modela la entidad de los veterinarios!!
    // atributos
    private String idEmpleado;
    private String nombre;
    private String clave;
    private Especialidad especialidad; // tiene como atributo un enum!


    // constructor ->
    public Veterinario(String idEmpleado, String nombre, String clave){
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.clave = clave;
    }

    // getters ->
    public String getIdEmpleado() {
        return idEmpleado;
    }
    public String getNombre() {
        return nombre;
    }
    public String getClave() {
        return clave;
    }


}
