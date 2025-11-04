package vista;

import controlador.ControladorEnvio;
import modelo.MetodosEnvio;

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

        inicializar();


        btnEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // acción al presionar el botón de Email

                // creamos instancia de enum EMAIL -->
                MetodosEnvio metodoEnvio = MetodosEnvio.EMAIL;

                // llamamos al metodo del controlador pasando el enum como parámetro -->
                String retorno = controladorEnvio.enviarConMetodoEnvio(metodoEnvio);

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
                // acción al presionar el botón de SMS

                // creamos instancia de enum SMS -->
                MetodosEnvio metodoEnvio = MetodosEnvio.SMS;

                // llamamos al metodo del controlador pasando el enum como parámetro -->
                String retorno = controladorEnvio.enviarConMetodoEnvio(metodoEnvio);

                lblMensajeContacto.setText(retorno);

                // una vez se envió el email, volvemos a la ventana principal!
                /* dispose(); // cerramos la ventana actual
                FormMain formMain = new FormMain();
                formMain.setVisible(true); // en true para que se vea la ventana!!

                 */
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
