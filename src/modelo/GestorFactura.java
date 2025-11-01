package modelo;

public class GestorFactura {

    public String pagar(IPagable metodoPago, Tratamiento tratamiento){
        // recibimos como parámetro un objeto del tipo interfaz IPagable

        // de esta forma es independiente de las clases PagoTarjetaCredito y PagoPayPal

        // es decir, usamos la implementación que tenga incluída el objeto interfaz!!!

        return metodoPago.procesarPago(tratamiento);
    }
}

