package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.ControladorPago;
import modelo.MetodosPago;

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

                // elegimos de instancia de enum PAYPAL -->
                MetodosPago metodoPago = MetodosPago.PAYPAL;

                // y lo pasamos como parámetro al metodo del controlador -->
                String retorno = controladorPago.pagarConMetodoPago(metodoPago);
                lblMensajePago.setText(retorno);


                // cerramos ventana una vez realizado el pago y abrimos la ventana para
                // el envío --->
                dispose();
                // y abrimos la ventana de FormContacto
                FormContacto formContacto = new FormContacto();
                formContacto.setVisible(true); // en true para que se vea la ventana!!

            }
        });

        btnTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // acción que ocurre al presionar el botón de Crédito

                // elegimos de instancia de enum CREDITO -->
                MetodosPago metodoPago = MetodosPago.CREDITO;

                // y lo pasamos como parámetro al metodo del controlador -->
                String retorno = controladorPago.pagarConMetodoPago(metodoPago);
                lblMensajePago.setText(retorno);


                // cerramos ventana una vez realizado el pago y abrimos la ventana para
                // el envío --->
                dispose();
                // y abrimos la ventana de FormContacto
                FormContacto formContacto = new FormContacto();
                formContacto.setVisible(true); // en true para que se vea la ventana!!
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
