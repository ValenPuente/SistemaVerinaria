package controlador;

import modelo.*;

public class ControladorFactura {

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

        // obtenemos el ultimo duenio registrado en el sistema -->
        Duenio duenio = gestorConsulta.obtenerUltimoDuenio();

        // creamos la clase factura
        Factura factura = new Factura(duenio, tratamiento);

        // ahora llamamos al metodo del gestorFactura para procesarla! -->
        // recibe el String que devuelve
        // el metodo pagar del gestor!
        return gestorFactura.pagar(metodoPagoImpl, factura); // pasamos como parámetro
        // el obejto del tipo IPagable que tiene implementada la lógica del metodo de pago que eligió
        // el usuario!
    }

    public String enviarConMetodoEnvio(MetodosEnvio metodoEnvio) {

        // en base a la constante que recibimos del enum, ya sea EMAIL o SMS, llamamos
        // al metodo estático de la clase MetodoEnvioFactory para crear el objeto INotificador -->
        INotificador notificadorImpl = MetodoEnvioFactory.crearMetodoEnvio(metodoEnvio);
        // de esta manera el objeto de la interfaz tendrá como implementación la lógica de la clase
        // EmailService o SMSService según corresponda!!!

        // obtenemos el ultimo Duenio registrado en el sistema -->
        Duenio duenio = gestorConsulta.obtenerUltimoDuenio();

        // obtenemos ultimo tratamiento registrado en el sistema -->
        Tratamiento tratamiento = gestorConsulta.obtenerUltimoTratamiento();

        // creamos la clase factura
        Factura factura = new Factura(duenio, tratamiento);

        // ahora llamamos al metodo del gestorFactura para enviarla! -->
        // recibe el String que devuelve
        return gestorFactura.enviar(notificadorImpl, factura); // pasamos como parámetro
        // el obejto del tipo INotificador que tiene implementada la lógica del metodo de envío que eligió
        // el usuario!

    }

    // de esta manera, el controlador no sabe cuál es el metodo de pago y envío que se está utilizando,
    // solo sabe que está utilizando un objeto que implementa la interfaz IPagable y INotificador!!!

}
