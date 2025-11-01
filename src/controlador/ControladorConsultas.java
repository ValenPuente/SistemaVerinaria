package controlador;

import modelo.*;

public class ControladorConsultas {
    // intermediario entre FormMain y las clases de la capa modelo!
    // creamos instancias de las clases de la capa modelo ->
    GestorConsulta gestorConsulta = new GestorConsulta();
    GestorVeterinarios gestorVeterinarios = new GestorVeterinarios();

    // constructor vacío ->
    public ControladorConsultas() {
    }
    // metodo que registra la consulta al txt de consultas -->

    public String registrarConsulta(String nombreDuenio, String apellidoDuenio, String numTelefono, String email, String tipoMascota, String nombreMascota, String edadMascota, String condicion, Tratamiento tratamientoSeleccionado) {
        // recibimos como parámetro todos los datos que se ponen en la ventana

        // verificamos primero que los datos no estén vacíos ->
        if (nombreDuenio.isEmpty() || apellidoDuenio.isEmpty() || numTelefono.isEmpty() || email.isEmpty() || tipoMascota.isEmpty() || nombreMascota.isEmpty() || edadMascota.isEmpty() || condicion.isEmpty() || tratamientoSeleccionado == null) {
            return "ERROR: Todos los campos son obligatorios.";
        }

        // formamos las instancias de las clases duenio y mascota correspondientes -->
        Duenio duenio = new Duenio(nombreDuenio, apellidoDuenio, numTelefono, email);
        Mascota mascota = new Mascota(tipoMascota, nombreMascota, edadMascota, duenio);

        // creamos instancia de consulta -->
        // para eso seleccionamos un veterinario que está en el txt de manera aleatoria ->
        Veterinario vetAsignado = gestorVeterinarios.elegirVeterinario();

        // ahora generar una fecha de manera aleatoria que sea válida a partir del día actual ->
        String fechaConsulta = gestorConsulta.generarFechaAleatoria();

        // creamos instancia de consulta -->
        Consulta consulta = new Consulta(vetAsignado, mascota, fechaConsulta, condicion, tratamientoSeleccionado);

        // llamamos al metodo de gestor consulta para que guarde la respectiva consulta -->
        boolean registrado = gestorConsulta.guardarConsulta(consulta);
        // vemos que devuelve el booleano ->
        if (registrado) {
            return "Consulta registrada exitosamente.";
        } else {
            return "ERROR: No se pudo registrar la consulta.";
        }

    }
}