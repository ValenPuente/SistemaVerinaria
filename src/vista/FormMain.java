package vista;

import controlador.ControladorConsultas;
import modelo.Tratamiento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMain extends JFrame {

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

    // instancia del controlador
    ControladorConsultas controladorConsultas = new ControladorConsultas();

    public FormMain() {
        inicializar();
        mostrarEnumTratamiento();

        btnConfirmarConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 1) recuperar datos del formulario
                String nombreDuenio   = txtNombre.getText();
                String apellidoDuenio = txtApellido.getText();
                String numTelefono    = txtTelefono.getText();
                String email          = txtEmail.getText();
                String tipoMascota    = txtTipoMascota.getText();
                String nombreMascota  = txtNombreMascota.getText();
                String edadMascota    = txtEdadMascota.getText();
                String condicion      = txtProblematica.getText();
                Tratamiento tratamientoSeleccionado =
                        (Tratamiento) boxTratamiento.getSelectedItem(); // enum Tratamiento

                // 2) VALIDAR a través del CONTROLADOR -> MODELO (mensaje específico o null)
                String mensajeError = controladorConsultas.validarDatosConsulta(
                        nombreDuenio, apellidoDuenio,
                        numTelefono, email,
                        tipoMascota, nombreMascota, edadMascota,
                        condicion, tratamientoSeleccionado
                );

                // 3) si NO pasa, mostrar mensaje de error y retornar
                if (mensajeError != null) {
                    lblMensajeRegistroConsulta.setText(mensajeError);
                    return;
                }

                // 4) si SÍ pasa, seguir con el flujo de guardado de la consulta dentro de los archivos txt!
                String retorno = controladorConsultas.registrarConsulta(
                        nombreDuenio, apellidoDuenio, numTelefono, email,
                        tipoMascota, nombreMascota, edadMascota,
                        condicion, tratamientoSeleccionado
                );
                lblMensajeRegistroConsulta.setText(retorno);

                // (tu pausa de 2s para que se vea el mensaje)
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                if ("Consulta registrada exitosamente.".equals(retorno)) {
                    dispose();
                    FormPago formPago = new FormPago();
                    formPago.setVisible(true);
                }
            }
        });
    }

    public void mostrarEnumTratamiento() {
        boxTratamiento.setModel(new DefaultComboBoxModel<>(Tratamiento.values()));
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
