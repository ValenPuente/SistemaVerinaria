package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormContacto extends JFrame{
    private JPanel pnlPrincipal;
    private JLabel lblMensajeContacto;
    private JButton btnEmail;
    private JButton btnTelefono;
    private JPanel pnlCentral;

    public FormContacto() {
        btnEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnTelefono.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
