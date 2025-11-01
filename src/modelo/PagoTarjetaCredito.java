package modelo;

public class PagoTarjetaCredito implements IPagable {

    @Override
    public String procesarPago(Tratamiento tratamiento) {
        // Lógica para procesar el pago con tarjeta de crédito
        System.out.println("Procesando pago con tarjeta de crédito por un monto de: " + tratamiento.getCosto());
        // Aquí se podría agregar la lógica real de procesamiento de pagos
        return "Pago realizado con tarjeta de credito exitosamente!!";
    }
}
