package modelo;

public class Veterinario extends Persona {
    // clase que modela la entidad de los veterinarios!!
    // atributos
    private final String idEmpleado; // lo ponemos en final porque no queremos que cambie!
    private final String clave; // lo ponemos en final porque no queremos que cambie!
    //private Especialidad especialidad; // tiene como atributo un enum!


    // constructor ->
    public Veterinario(String idEmpleado, String nombre, String apellido, String clave){
        super(nombre, apellido); // llama al constructor de la clase padre!!
        this.idEmpleado = idEmpleado;
        this.clave = clave;
        //this.especialidad = asignarEspecialidadAutomatico();
    }

    // getters ->
    public String getIdEmpleado() {
        return idEmpleado;
    }
    public String getClave() {
        return clave;
    }

    /*public Especialidad getEspecialidad() {
        return especialidad;
    }

    // metodo para asignar especialidad de forma automática según el idEmpleado ->
    // lo hacemos privado para que no sea accesible desde fuera!
    private Especialidad asignarEspecialidadAutomatico(){
        // asigna una especialidad de manera al azar -->
        // lista con todas las especialidades disponibles!!
        Especialidad[] especialidades = Especialidad.values();
        // generamos un número aleatorio entre 0 y la cantidad de especialidades -1
        int indiceAleatorio = (int) (Math.random() * especialidades.length);
        return especialidades[indiceAleatorio]; // lo retona al constructor!
    }
*/
}
