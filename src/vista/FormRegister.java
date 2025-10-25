package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormRegister extends JFrame {
    private JPanel pnlPrincipal;
    private JPanel pnlSuperior;
    private JPanel pnlCentral;
    private JPanel pnlInferior;
    private JTextField txtIdEmpleado;
    private JTextField txtNombre;
    private JTextField txtClave;
    private JButton btnRegistrase;
    private JButton btnIniciarSesion;

    public FormRegister() {
        inicializar(); // metodo que se crea para inicializar la ventana

        btnRegistrase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // accíon que ocurre al presionar el botón de registrarse
                // primero se debe validar si los datos ingresados son correctos o no -->
                // recuperamos los datos ingresados por el usuario!
                String idEmpleado = txtIdEmpleado.getText();
                String nombre = txtNombre.getText();
                String clave = txtClave.getText();
            }
        });
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // accíon que ocurre al presionar el botón de iniciar sesión
                // debemos cerrar la ventana y abrir una nueva que se de inicio de sesión -->
                dispose(); // cierra la ventana actual
                // creamos instancia de la clase FormSignIn -->
                FormSignIn formSignIn = new FormSignIn();
                // ponemos visibilidad en true ->
                formSignIn.setVisible(true);

            }
        });
    }


    public void inicializar() { // esto es para inicializar la ventana, se pone siempre!
        setContentPane(pnlPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }
}
