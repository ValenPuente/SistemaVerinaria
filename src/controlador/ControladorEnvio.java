package controlador;

import modelo.*;

public class ControladorEnvio {
    // controlador que actúa de intermediario entre la clase FormContacto de la vista y
    // la clase GestrorEnvio de la capa modelo!!!
    GestorConsulta gestorConsulta = new GestorConsulta();
    GestorFactura gestorFactura = new GestorFactura();


    public String enviarConMetodoEnvio(MetodosEnvio metodoEnvio) {

        // en base a la constante que recibimos del enum, ya sea EMAIL o SMS, llamamos
        // al metodo estático de la clase MetodoEnvioFactory para crear el objeto INotificador -->
        INotificador notificadorImpl = MetodoEnvioFactory.crearMetodoEnvio(metodoEnvio);
        // de esta manera el objeto de la interfaz tendrá como implementación la lógica de la clase
        // EmailService o SMSService según corresponda!!!

        // obtenemos el ultimo Duenio registrado en el sistema -->
        Duenio duenio = gestorConsulta.obtenerUltimoDuenio();

        // ahora llamamos al metodo del gestorFactura para enviarla! -->
        // recibe el String que devuelve
        return gestorFactura.enviar(notificadorImpl, duenio); // pasamos como parámetro
        // el obejto del tipo INotificador que tiene implementada la lógica del metodo de envío que eligió
        // el usuario!

    }
}