package vista;

import controlador.ControladorVeterinarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormSignIn extends JFrame {
    private JPanel pnlPrincipal;
    private JPanel pnlSuperior;
    private JPanel pnlCentral;
    private JPanel pnlInferior;
    private JTextField txtIdEmpleado;
    private JTextField txtNombre;
    private JTextField txtClave;
    private JButton btnInicioDeSesion;
    private JLabel iblMensaje;

    // creamos instancia de controladorVeterinarios para usar sus métodos ->
    ControladorVeterinarios controladorVeterinarios = new ControladorVeterinarios();

    public FormSignIn() {
        inicializar();
        btnInicioDeSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // acción al toca el botón de inicio de sesión!!!
                // recuperamos los datos ingresados por el veterinario -->
                String idEmpleado = txtIdEmpleado.getText();
                String nombre = txtNombre.getText();
                String clave = txtClave.getText();
                // llamamos al controlador para verificar si el inicio de sesión es correcto!!
                String retorno = controladorVeterinarios.iniciarSesionVeterinario(idEmpleado, nombre, clave);
                // mostramos el resultado en un cuadro de diálogo ->

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
