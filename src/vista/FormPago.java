package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ControladorFactura;
import modelo.MetodosPago;

public class FormPago extends JFrame {
    private JPanel panel1;
    private JButton btnPaypal;
    private JButton btnTarjeta;
    private JLabel lblMensajePago;
    private JPanel pnlPrincipal;

    // instancia de controlador
    ControladorFactura controladorFactura = new ControladorFactura();

    public FormPago(){
        inicializar();

        btnPaypal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MetodosPago metodoPago = MetodosPago.PAYPAL;
                String retorno = controladorFactura.pagarConMetodoPago(metodoPago);

                mostrarMensajeYSeguir(retorno); // <-- muestra 3s y luego navega
            }
        });

        btnTarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MetodosPago metodoPago = MetodosPago.CREDITO;
                String retorno = controladorFactura.pagarConMetodoPago(metodoPago);

                mostrarMensajeYSeguir(retorno); // <-- muestra 3s y luego navega
            }
        });
    }

    private void mostrarMensajeYSeguir(String mensaje){
        // mostrar el mensaje y deshabilitar botones
        lblMensajePago.setText(mensaje);
        btnPaypal.setEnabled(false);
        btnTarjeta.setEnabled(false);

        // esperar 3s sin bloquear la UI y entonces cerrar y abrir FormContacto
        javax.swing.Timer t = new javax.swing.Timer(3000, ev -> {
            dispose();
            new FormContacto().setVisible(true);
        });
        t.setRepeats(false);
        t.start();
    }

    public void inicializar() {
        setContentPane(pnlPrincipal);   // asegúrate de que lblMensajePago esté dentro de pnlPrincipal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }
}
