package controlador;

import modelo.GestorVeterinarios;
import modelo.Veterinario;

public class ControladorVeterinarios {
    GestorVeterinarios gestorVeterinarios = new GestorVeterinarios(); // creamos instancia para usar los
    // métodos de la clase GestorVeterinarios!!
    // este controlador se encargará de verificar la integridad de los datos de los veterinarios para
    // el register y el log in, actúa entre intermediario entre las clases de FormRegister y FormSignIn
    // de la capa vista y la clase GestorVeterinarios de la capa modelo!!

    public ControladorVeterinarios() {
        // constructor vacío!!
    }


    public String registrarVeterinario(String idEmpleado, String nombre, String apellido, String clave) {
        // recibe como parámetro los datos ingresados por el usuario!
        // primero verificamos que los datos no estén vacíos!!
        if (idEmpleado.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || clave.isEmpty()) {
            return "ERROR: Todos los campos son obligatorios";
        }

        // creamos instancia de veterinario ->
        Veterinario vet = new Veterinario(idEmpleado, nombre, apellido, clave);

        // vericamos primero si ya existe ese id de empleado!!
        if (gestorVeterinarios.validaridEmpleado(idEmpleado)) {
            return "ERROR: El ID de empleado ya está registrado";
        }

        // si no existe, procedemos a registrarlo!!
        // llamamos a metodo del gestorVeterinarios para verificar primero si ya se encuentra registrado el
        // veterinario!
        if (!gestorVeterinarios.verificarVeterinarioExistente(vet)) { // verificamos primero si ya existe!
            // si no existe, lo agregamos al archivo de veterinarios!!
            boolean agregado = gestorVeterinarios.agregarVeterinarios(vet);
            if (agregado) {
                return "Veterinario registrado exitosamente"; //retornamos este String a la capa vista!!
            } else {
                return "ERROR: No se pudo registrar el veterinario";
            }
        } else {
            return "ERROR: El veterinario ya está registrado";
        }
    }

    public String iniciarSesionVeterinario(String idEmpleado, String nombre, String apellido, String clave) {
        // metodo para el inicio de sesión de los veterinarios!!
        // primero verificamos que los datos no estén vacíos!!
        if (idEmpleado.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || clave.isEmpty()) {
            return "ERROR: Todos los campos son obligatorios.";
        }

        // ahora usamos el metodo del gestorVeterinarios para verificar si el veterinario existe!!
        Veterinario vet = new Veterinario(idEmpleado, nombre, apellido, clave);
        if (gestorVeterinarios.verificarVeterinarioExistente(vet)) {
            return "Inicio de sesión exitoso"; // retornamos este String a la capa vista!!
        } else {
            return "ERROR: Credenciales incorrectas o veterinario no registrado";
        }
    }
}

