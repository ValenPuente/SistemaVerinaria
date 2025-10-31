package controlador;

import modelo.Tratamiento;
import modelo.Duenio;
import modelo.Mascota;
import modelo.Persona;
import modelo.Veterinario;

public class ControladorConsultas {
    // intermediario entre FormMain y las clases de la capa modelo!


    // constructor vacío ->
    public ControladorConsultas() {
    }
    // metodo que registra la consulta al txt de consultas -->

    public String registrarConsulta(String nombreDuenio, String apellidoDuenio, String tipoMascota, String nombreMascota, String edadMascota, String problematica, Tratamiento tratamientoSeleccionado){
    // recibimos como parámetro todos los datos que se ponen en la ventana
        // formamos las instancias de las clases correspondientes -->
        Duenio duenio = new Duenio(nombreDuenio, apellidoDuenio

    }





}
