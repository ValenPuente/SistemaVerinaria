package modelo;

public class GestorEnvio {

    // clase que se encarga de gestionar el envío de facturas a los dueños -->
    public String enviar(INotificador notificador, Duenio duenio){ // recibimos
        // como parámetro un objeto del tipo interfaz INotificador el cual nos permitirá usar la
        // implementación que tenga incluída el objeto interfaz!!! Ya sea SMSService o EmailService!!
        // De esta manera queda independiente de estas dos clases concretas!!!

        return notificador.enviarFactura(duenio);
    }
}
