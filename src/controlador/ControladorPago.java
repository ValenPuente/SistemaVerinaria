package controlador;

import modelo.*;

public class ControladorPago {

    // creamos instancia de gestorConsulta -->
    GestorConsulta gestorConsulta = new GestorConsulta();
    GestorFactura gestorFactura = new GestorFactura();


    public String pagarConMetodoPago(MetodosPago metodoPago){

        // en base a la constante que recibimos del enum, ya sea PAYPAL o CREDITO, llamamos
        // al metodo estático de la clase MetodoPagoFactory para crear el objeto IPagable -->
        IPagable metodoPagoImpl = MetodoPagoFactory.crearMetodoPago(metodoPago);
        // de esta manera el objeto de la interfaz tendrá como implementación la lógica de la clase
        // PagoPayPal o PagoTarjetaCredito según corresponda!!!

        // obtenemos el ultimo Tratamiento registrado en el sistema -->
        Tratamiento tratamiento = gestorConsulta.obtenerUltimoTratamiento();

        // ahora llamamos al metodo del gestorFactura para procesarla! -->
        // recibe el String que devuelve
        // el metodo pagar del gestor!
        return gestorFactura.pagar(metodoPagoImpl, tratamiento); // pasamos como parámetro
        // el obejto del tipo IPagable que tiene implementada la lógica del metodo de pago que eligió
        // el usuario!
    }

    // de esta manera, el controlador no sabe cuál es el metodo de pago que se está utilizando,
    // solo sabe que está utilizando un objeto que implementa la interfaz IPagable!!!

}

