package modelo;

public class PagoPayPal implements IPagable {

    @Override
    public String procesarPago(Factura factura) {
        // Lógica para procesar el pago a través de PayPal
        System.out.println("Procesando pago por PayPal para el tratamiento con costo: " + factura.getTratamiento().getCosto());
        // Aquí se podría agregar la integración con la API de PayPal
        return "Pago realizado con PayPal exitosamente!!";
    }
}
