package modelo;

public class Consulta {
    // clase que surge de la relación muchos a muchos entre Veterinario y Mascota! Un veterinario puede tenexr
    // muchas mascotas a su cargo y una mascota puede ser atendida por varios veterinarios! Para guardar datos
    // extra de esa relación de asociación muchos a muchos creamos esta clase intermedia!! Esto aplica el
    // principio GRASP de fabricación pura!!

    // atributos de la clase consulta ->
    private Veterinario veterinario;
    private Mascota mascota;
    private String fecha; // fecha de la consulta
    private String condicion; // problema que presenta la mascota en la consulta
    private Tratamiento tratamiento; // enum con el tratamiento dado en la consulta, que contiene
    // el coste!

    // constructor de la clase consulta ->
    public Consulta(Veterinario veterinario, Mascota mascota, String fecha, String condicion, Tratamiento tratamiento) {
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.fecha = fecha;
        this.condicion = condicion;
        this.tratamiento = tratamiento;
    }

    // métodos getters ->
    public Veterinario getVeterinario() {
        return veterinario;
    }
    public Mascota getMascota() {
        return mascota;
    }
    public String getFecha() {
        return fecha;
    }
    public Tratamiento getTratamiento() {
        return tratamiento;
    }
    public String getCondicion() { return condicion; }
}
