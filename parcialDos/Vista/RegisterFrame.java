package Vista;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    private JTextField campoTipoId, campoNumeroId, campoNombres, campoApellidos, campoCorreo, campoDireccionResidencial, campoCiudadResidencia, campoTelefonoContacto;
    private JPasswordField campoContrasena, campoConfirmarContrasena;
    private JButton botonVolver, botonRegistrar;

    public RegisterFrame() {
        setTitle("Registrar");
        setSize(500, 700); // Ajustado para mejor espacio
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(5, 10, 5, 10); // Márgenes para cada componente
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        campoTipoId = new JTextField(20);
        campoNumeroId = new JTextField(20);
        campoNombres = new JTextField(20);
        campoApellidos = new JTextField(20);
        campoCorreo = new JTextField(20);
        campoDireccionResidencial = new JTextField(20);
        campoCiudadResidencia = new JTextField(20);
        campoTelefonoContacto = new JTextField(20);
        campoContrasena = new JPasswordField(20);
        campoConfirmarContrasena = new JPasswordField(20);
        botonVolver = new JButton("Volver");
        botonRegistrar = new JButton("Registrar");

        addComponent("Tipo de identificación (CC, TI, PA):", campoTipoId, gbc);
        addComponent("Número de identificación:", campoNumeroId, gbc);
        addComponent("Nombre:", campoNombres, gbc);
        addComponent("Apellido:", campoApellidos, gbc);
        addComponent("Correo electrónico:", campoCorreo, gbc);
        addComponent("Dirección residencial:", campoDireccionResidencial, gbc);
        addComponent("Ciudad de residencia:", campoCiudadResidencia, gbc);
        addComponent("Número de contacto:", campoTelefonoContacto, gbc);
        addComponent("Contraseña:", campoContrasena, gbc);
        addComponent("Confirmar contraseña:", campoConfirmarContrasena, gbc);
        addComponent(null, botonVolver, gbc);
        addComponent(null, botonRegistrar, gbc);
    }

    private void addComponent(String label, JComponent component, GridBagConstraints gbc) {
        if (label != null) {
            gbc.gridx = 0;
            add(new JLabel(label), gbc);
        }
        gbc.gridx = 1;
        add(component, gbc);
    }
    
    public JTextField getCampoTipoId() { return campoTipoId; }
    public JTextField getCampoNumeroId() { return campoNumeroId; }
    public JTextField getCampoNombres() { return campoNombres; }
    public JTextField getCampoApellidos() { return campoApellidos; }
    public JTextField getCampoCorreo() { return campoCorreo; }
    public JTextField getCampoDireccionResidencial() { return campoDireccionResidencial; }
    public JTextField getCampoCiudadResidencia() { return campoCiudadResidencia; }
    public JTextField getCampoTelefonoContacto() { return campoTelefonoContacto; }
    public JPasswordField getCampoContrasena() { return campoContrasena; }
    public JPasswordField getCampoConfirmarContrasena() { return campoConfirmarContrasena; }
    public JButton getBotonVolver() { return botonVolver; }
    public JButton getBotonRegistrarse() { return botonRegistrar; }
}
