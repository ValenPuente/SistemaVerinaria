package controlador;

import modelo.IPagable;
import modelo.PagoPayPal;

public class ControladorPago {

    // metodo para procesar pago por Paypal ->

    public String pagar(){
        // creamos objeto del tipo interfaz -->
        IPagable pagoPayPal = new PagoPayPal();

    }

}
