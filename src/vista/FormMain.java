package vista;

import javax.swing.*;

public class FormMain extends JFrame{


    private JPanel pnlPrincipal;
    private JPanel pnlSuperior;
    private JPanel pnlCentral;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTipoMascota;
    private JTextField txtNombreMascota;
    private JTextField txtEdadMascota;
    private JTextField txtProblematica;
    private JComboBox boxTratamiento;
    private JButton btnConfirmarConsulta;
    private JLabel lblMensajeRegistroCoinsulta;



    public FormMain() {
        inicializar();

        // métodos al presionar botones se agregarán aquí!!






    }



    public void inicializar() {
        setContentPane(pnlPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

}
