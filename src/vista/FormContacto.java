package vista;

import controlador.ControladorFactura;
import modelo.MetodosEnvio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormContacto extends JFrame {
    private JPanel pnlPrincipal;
    private JLabel lblMensajeContacto;
    private JButton btnEmail;
    private JButton btnTelefono;
    private JPanel pnlCentral;

    // instancia del controlador
    ControladorFactura controladorFactura = new ControladorFactura();

    public FormContacto() {
        inicializar();

        btnEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MetodosEnvio metodoEnvio = MetodosEnvio.EMAIL;
                String retorno = controladorFactura.enviarConMetodoEnvio(metodoEnvio);
                mostrarMensajeYVolver(retorno); // <-- muestra 3s y vuelve
            }
        });

        btnTelefono.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MetodosEnvio metodoEnvio = MetodosEnvio.SMS;
                String retorno = controladorFactura.enviarConMetodoEnvio(metodoEnvio);
                mostrarMensajeYVolver(retorno); // <-- muestra 3s y vuelve
            }
        });
    }

    private void mostrarMensajeYVolver(String mensaje) {
        // mostrar el mensaje y deshabilitar botones para evitar doble envío
        lblMensajeContacto.setText(mensaje);
        btnEmail.setEnabled(false);
        btnTelefono.setEnabled(false);

        // esperar 3s SIN bloquear la UI y luego cerrar y volver al main
        javax.swing.Timer t = new javax.swing.Timer(3000, ev -> {
            dispose();                    // cerrar esta ventana
            new FormMain().setVisible(true); // volver al formulario principal
        });
        t.setRepeats(false);
        t.start();
    }

    public void inicializar() {
        setContentPane(pnlCentral); // si querés usar pnlPrincipal, cambialo acá
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }
}
