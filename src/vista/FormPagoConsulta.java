package vista;

import javax.swing.*;

public class FormPagoConsulta extends JFrame {

    private JPanel pnlSuperior;
    private JPanel pnlCentral;
    private JPanel pnlInferior;
    private JPanel pnlPrincipal;

    public FormPagoConsulta() {
        inicializar();





    }

    public void inicializar() {
        setContentPane(pnlPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }
}
