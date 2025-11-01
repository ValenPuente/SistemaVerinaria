package controlador;

import modelo.*;

public class ControladorEnvio {
    // controlador que actúa de intermediario entre la clase FormContacto de la vista y
    // la clase GestrorEnvio de la capa modelo!!!
    GestorConsulta gestorConsulta = new GestorConsulta();
    GestorEnvio gestorEnvio = new GestorEnvio();

    public String enviarFacturaSMS(){

        // recuperamos el ultimo dueño registrado en el sistema -->
        Duenio duenio = gestorConsulta.obtenerUltimoDuenio();

        // creamos instancia de la clase SMSService que implementa la interfaz INotificador -->
        INotificador notificador = new SMSService();

        // llamamos al metodo enviar del gestorEnvio -->
        return gestorEnvio.enviar(notificador, duenio);
    }

    public String enviarFacturaEmail(){

        // recuperamos el ultimo dueño registrado en el sistema -->
        Duenio duenio = gestorConsulta.obtenerUltimoDuenio();

        // creamos instancia de la clase EmailService que implementa la interfaz INotificador -->
        INotificador notificador = new EmailService();

        // llamamos al metodo enviar del gestorEnvio -->
        return gestorEnvio.enviar(notificador, duenio);
    }


}
