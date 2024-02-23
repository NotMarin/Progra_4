package Vista;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField campoCorreo;
    private JPasswordField campoContrasena;
    private JButton botonIniciarSesion;
    private JButton botonRegistrarse;

    public LoginFrame() {
        setTitle("My Hotel");
        setSize(400, 400); // Ajusta el tamaño para acomodar el mensaje de bienvenida
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);

        // Mensaje de bienvenida
        JLabel labelBienvenida = new JLabel("Bienvenido a My Hotel", JLabel.CENTER);
        labelBienvenida.setFont(new Font("Serif", Font.BOLD, 16));
        gbc.insets = new Insets(20, 20, 15, 20);  // Margen superior más grande
        add(labelBienvenida, gbc);

        campoCorreo = new JTextField(20);
        campoContrasena = new JPasswordField(20);
        botonIniciarSesion = new JButton("Iniciar sesión");
        botonRegistrarse = new JButton("Registrarse");

        campoCorreo.setToolTipText("Introduce tu correo electrónico");
        campoContrasena.setToolTipText("Introduce tu contraseña");
        botonIniciarSesion.setToolTipText("Haz clic para iniciar sesión");
        botonRegistrarse.setToolTipText("Haz clic para registrarte");

        // Restablece los márgenes para los otros componentes
        gbc.insets = new Insets(10, 20, 10, 20);
        add(new JLabel("Correo electrónico:"), gbc);
        add(campoCorreo, gbc);
        add(new JLabel("Contraseña:"), gbc);
        add(campoContrasena, gbc);
        add(botonIniciarSesion, gbc);
        add(botonRegistrarse, gbc);

        campoCorreo.requestFocusInWindow();
    }

    public String getEmail() {
        return campoCorreo.getText().trim();
    }

    public String getContrasena() {
        return new String(campoContrasena.getPassword());
    }

    public JButton getBotonIniciarSesion() {
        return botonIniciarSesion;
    }

    public JButton getBotonRegistrarse() {
        return botonRegistrarse;
    }
}
