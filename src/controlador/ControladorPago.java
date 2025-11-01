package controlador;

import modelo.IPagable;
import modelo.PagoPayPal;
import modelo.PagoTarjetaCredito;
import modelo.Tratamiento;
import modelo.GestorConsulta;
import modelo.GestorPago;

public class ControladorPago {

    // creamos instancia de gestorConsulta -->
    GestorConsulta gestorConsulta = new GestorConsulta();
    GestorPago gestorFactura = new GestorPago();

    // metodo para procesar pago por Paypal ->

    public String pagarPayPal(){
        // creamos objeto del tipo interfaz pero que implemente a la lógica de pagar con Paypal -->
        IPagable metodoPago = new PagoPayPal(); // que sea del tipo Interfaz y no del tipo PagoPayPal!!!

        // obtenemos el ultimo Tratamiento registrado en el sistema -->
        Tratamiento tratamiento = gestorConsulta.obtenerUltimoTratamiento();

        // ahora llamamos al metodo del gestorFactura para procesarla! -->
        // recibe el String que devuelve
        // el metodo pagar del gestor!
        return gestorFactura.pagar(metodoPago, tratamiento);
    }

    public String pagarTarjetaCredito(){
        // creamos objeto del tipo interfaz pero que implemente a la lógica de pagar con Tarjeta de Crédito -->
        IPagable metodoPago = new PagoTarjetaCredito();

        // ahora llamamos al metodo del gestorFactura -->
        Tratamiento tratamiento = gestorConsulta.obtenerUltimoTratamiento();

        // ahora llamamos al metodo del gestorFactura para procesarla! -->
        return gestorFactura.pagar(metodoPago, tratamiento);
    }
}
