package vista;

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


    public FormSignIn() {
        inicializar();
        btnInicioDeSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // acción al toca el botón de inicio de sesión!!!

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
