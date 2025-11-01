package modelo;

public class EmailService implements INotificador {

    @Override
    public String enviarFactura(Duenio duenio) {
        // Lógica para enviar la factura por email al duenio -->
        return "Enviando factura por email al dueño: " + duenio.getEmail();

    }
}
