package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.ControladorPago;

public class FormPago extends JFrame {
    private JPanel panel1;
    private JButton btnPaypal;
    private JButton btnTarjeta;
    private JLabel lblMensajePago;
    private JPanel pnlPrincipal;


    // instancia de controlador Pago para usar sus métodos ->
    ControladorPago controladorPago = new ControladorPago();

    public FormPago(){
        inicializar();


        btnPaypal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // acción que ocurre al presionar el botón de Paypal
                // llamamos al metodo del controladorPagos para procesar el pago por Paypal!!
                String retorno = controladorPago.pagarPayPal();
                lblMensajePago.setText(retorno);

                // esperamos unos segundos para que el usuario pueda ver el mensaje de confirmación
                try {
                    Thread.sleep(3000); // pausa de 3 segundos (3000 milisegundos)
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                // cerramos ventana una vez realizado el pago y abrimos la ventana para
                // el envío --->
                dispose();
                // y abrimos la ventana de FormContacto

            }
        });

        btnTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // acción que ocurre al presionar el botón de Credito
                // llamamos al metodo del controladorPagos para procesar el pago por Tareta de credito!
                String retorno = controladorPago.pagarTarjetaCredito();
                lblMensajePago.setText(retorno);

                // esperamos unos segundos para que el usuario pueda ver el mensaje de confirmación
                try {
                    Thread.sleep(3000); // pausa de 3 segundos (3000 milisegundos)
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                // cerramos ventana una vez realizado el pago y abrimos la ventana para
                // el envío --->
                dispose();
                // y abrimos la ventana de FormContacto
            }
        });
    }


    public void inicializar() {
        setContentPane(pnlPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }
}
