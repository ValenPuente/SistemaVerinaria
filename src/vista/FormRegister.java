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
    private JLabel lblMensaje;
    private JTextField txtApellido;

    // creamos instancia de controladorVeterinarios para usar sus métodos ->
    controlador.ControladorVeterinarios controladorVeterinarios = new controlador.ControladorVeterinarios();

    public FormRegister() {
        inicializar(); // metodo que se crea para inicializar la ventana

        btnRegistrase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // accíon que ocurre al presionar el botón de registrarse
                // recuperamos los datos ingresados por el usuario en la ventana con .getText()!! -->
                String idEmpleado = txtIdEmpleado.getText(); // formato de texto!!
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String clave = txtClave.getText();
                // llamamos al metodo del controladorVeterinarios para agregarlos al archivo txt!
                String retorno = controladorVeterinarios.registrarVeterinario(idEmpleado, nombre, apellido, clave);
                // lo mostramos en un label ->
                lblMensaje.setText(retorno);
                if (lblMensaje.getText().equals("Veterinario registrado exitosamente")) {
                    // cerramos ventana actual -->
                    dispose();
                    // abrimos ventana principal -->
                    FormMain formMain = new FormMain();
                    formMain.setVisible(true); // en true para que se vea la ventana!!
                }
            }
        });

        // botón de iniciar sesión ->
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // accíon que ocurre al presionar el botón de iniciar sesión
                // debemos cerrar la ventana y abrir una nueva que sea destinada al inicio de sesión -->
                dispose(); // cierra la ventana actual de register!!!
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
