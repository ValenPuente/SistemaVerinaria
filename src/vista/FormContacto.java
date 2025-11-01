package vista;

import controlador.ControladorEnvio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormContacto extends JFrame{
    private JPanel pnlPrincipal;
    private JLabel lblMensajeContacto;
    private JButton btnEmail;
    private JButton btnTelefono;
    private JPanel pnlCentral;

    // instancia de la clase ControladorEnvio para usar sus métodos ->
    ControladorEnvio controladorEnvio = new ControladorEnvio();

    public FormContacto() {
        btnEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // acción al presionar el botón de Email
                // llamamos al metodo del controlador -->
                String retorno = controladorEnvio.enviarFacturaEmail();
                lblMensajeContacto.setText(retorno);

                // una vez se envió el email, volvemos a la ventana principal!
                dispose(); // cerramos la ventana actual
                FormMain formMain = new FormMain();
                formMain.setVisible(true); // en true para que se vea la ventana!!
            }
        });
        btnTelefono.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // acción al presionar el botón de Teléfono
                // llamamos al metodo del controlador -->
                String retorno = controladorEnvio.enviarFacturaSMS();
                lblMensajeContacto.setText(retorno);

                // una vez se envió el SMS, volvemos a la ventana principal!
                dispose(); // cerramos la ventana actual
                FormMain formMain = new FormMain();
                formMain.setVisible(true); // en true para que se vea la ventana!!
            }
        });
    }

    public void inicializar() {
        setContentPane(pnlCentral);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }
}
