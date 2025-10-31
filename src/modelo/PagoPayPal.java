package modelo;

public class PagoPayPal implements IPagable {

    public boolean procesarPago(Tratamiento tratamiento) {
        // Lógica para procesar el pago a través de PayPal
        System.out.println("Procesando pago por PayPal para el tratamiento con costo: " + tratamiento.getCosto());
        // Aquí se podría agregar la integración con la API de PayPal
        return true; // Retorna true si el pago fue exitoso
    }
}
