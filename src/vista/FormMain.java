package vista;

import controlador.ControladorConsultas;
import modelo.Tratamiento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JLabel lblMensajeRegistroConsulta;
    private JTextField txtTelefono;
    private JTextField txtEmail;

    // creamos instancia de ControladorConsulta -->
    ControladorConsultas controladorConsultas = new ControladorConsultas();


    public FormMain() {
        inicializar();
        mostrarEnumTratamiento();

        btnConfirmarConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // acción que pasa al presionar el botón Confirmar!
                // recuperamos los datos de los text -->
                String nombreDuenio = txtNombre.getText();
                String apellidoDuenio = txtApellido.getText();
                String numTelefono = txtTelefono.getText();
                String email = txtEmail.getText();
                String tipoMascota = txtTipoMascota.getText();
                String nombreMascota = txtNombreMascota.getText();
                String edadMascota = txtEdadMascota.getText();
                String condicion = txtProblematica.getText();
                Tratamiento tratamientoSeleccionado = (Tratamiento) boxTratamiento.getSelectedItem();
                // tratamientoSeleccionado debe ser del tipo enum Tratamiento!!

                // llamamos al metodo del controladorConsultas para registrar la consulta
                String retorno = controladorConsultas.registrarConsulta(nombreDuenio, apellidoDuenio, numTelefono, email, tipoMascota, nombreMascota, edadMascota, condicion, tratamientoSeleccionado);
                lblMensajeRegistroConsulta.setText(retorno);
                if (retorno.equals("Consulta registrada exitosamente.")){
                    // ahora cerramos la ventana si se registró la consulta excitosamente -->
                    dispose();
                    // y tenemos que abrir una nueva vetana para mostrar el resumen de la consulta -->
                    FormPagoConsulta formPagoConsulta = new FormPagoConsulta();
                    formPagoConsulta.setVisible(true);

                }

            }
        });
    }

    public void mostrarEnumTratamiento(){
        boxTratamiento.setModel(new DefaultComboBoxModel<>(Tratamiento.values()));

        // (Opcional) acción al seleccionar:
        boxTratamiento.addActionListener(e -> {
            Tratamiento seleccionado = (Tratamiento) boxTratamiento.getSelectedItem();
            System.out.println("Seleccionaste: " + seleccionado);
        });
    }


    public void inicializar() {
        setContentPane(pnlPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }
}
