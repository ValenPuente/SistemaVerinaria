package modelo;

public class GestorPago {

    public String pagar(IPagable metodoPago, Tratamiento tratamiento){
        // recibimos como parámetro un objeto del tipo interfaz IPagable

        // de esta forma es independiente de las clases PagoTarjetaCredito y PagoPayPal

        // es decir, usamos la implementación que tenga incluída el objeto interfaz!!!

        return metodoPago.procesarPago(tratamiento);
    }

    public String enviar(INotificador metodoNotificador, Duenio duenio){
        // recibimos como parámetro un objeto del tipo interfaz INotificador

        // de esta forma es independiente de las clases EmailService y SMSService

        // es decir, usamos la implementación que tenga incluída el objeto interfaz!!!

        return metodoNotificador.enviarFactura(duenio);
    }
}

