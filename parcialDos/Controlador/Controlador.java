package Controlador;

import Modelo.Usuario;
import Vista.HomeFrame;
import Vista.LoginFrame;
import Vista.RegisterFrame;
import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controlador {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private LoginFrame loginFrame;
    private RegisterFrame registerFrame;

    public Controlador() {
        loginFrame = new LoginFrame();
        registerFrame = new RegisterFrame();

        usuarios.add(new Usuario("CC", "0001", "Admin", "User", "admin123@test.com", "123 Admin St", "Admin City", "1234567890", "admin"));

        loginFrame.getBotonIniciarSesion().addActionListener(e -> iniciarSesionUsuario());
        loginFrame.getBotonRegistrarse().addActionListener(e -> mostrarFormularioRegistro());
        registerFrame.getBotonRegistrarse().addActionListener(e -> registrarUsuario());
        registerFrame.getBotonVolver().addActionListener(e -> registerFrame.setVisible(false));

        loginFrame.setVisible(true);
    }

    private void iniciarSesionUsuario() {
        String email = loginFrame.getEmail();
        String contrasena = loginFrame.getContrasena();

        for (Usuario usuario : usuarios) {
            if (usuario.getCorreoElectronico().equalsIgnoreCase(email) && usuario.getContrasena().equals(contrasena)) {
                abrirHomeFrame(usuario);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Credenciales inválidas", "Inicio de sesión fallido", JOptionPane.ERROR_MESSAGE);
    }

    private void abrirHomeFrame(Usuario usuario) {
        String rol = usuario.getCorreoElectronico().equals("admin123@test.com") ? "admin" : "cliente";
        HomeFrame homeFrame = new HomeFrame(rol);

        homeFrame.setVisible(true);
    }

    private void mostrarFormularioRegistro() {
        registerFrame.setVisible(true);
    }

    private void registrarUsuario() {
        String tipoId = registerFrame.getCampoTipoId().getText().toUpperCase();
        String numeroId = registerFrame.getCampoNumeroId().getText();
        String nombres = registerFrame.getCampoNombres().getText();
        String apellidos = registerFrame.getCampoApellidos().getText();
        String correo = registerFrame.getCampoCorreo().getText();
        String direccionResidencial = registerFrame.getCampoDireccionResidencial().getText();
        String ciudadResidencia = registerFrame.getCampoCiudadResidencia().getText();
        String telefonoContacto = registerFrame.getCampoTelefonoContacto().getText();
        String contrasena = new String(registerFrame.getCampoContrasena().getPassword());
        String confirmarContrasena = new String(registerFrame.getCampoConfirmarContrasena().getPassword());

        if (!contrasena.equals(confirmarContrasena)) {
            JOptionPane.showMessageDialog(registerFrame, "Las contraseñas no coinciden.", "Error de registro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!tipoIdValido(tipoId) || !numeroIdValido(numeroId) || !correoValido(correo)) {
            return;
        }

        Usuario nuevoUsuario = new Usuario(tipoId, numeroId, nombres, apellidos, correo, direccionResidencial, ciudadResidencia, telefonoContacto, contrasena);
        usuarios.add(nuevoUsuario);
        JOptionPane.showMessageDialog(registerFrame, "Usuario registrado exitosamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        registerFrame.setVisible(false);
    }

    private boolean tipoIdValido(String tipoId) {
        if (!(tipoId.equals("CC") || tipoId.equals("TI") || tipoId.equals("PA"))) {
            JOptionPane.showMessageDialog(registerFrame, "Identificación inválida. Debe ser CC, TI o PA.", "Error de registro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean numeroIdValido(String numeroId) {
        if (!numeroId.matches("\\d+")) {
            JOptionPane.showMessageDialog(registerFrame, "Número de identificación inválido. Debe ser un número.", "Error de registro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean correoValido(String correo) {
        String patronCorreo = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern patron = Pattern.compile(patronCorreo);
        Matcher coincidencia = patron.matcher(correo);
        if (!coincidencia.matches()) {
            JOptionPane.showMessageDialog(registerFrame, "Formato de correo inválido.", "Error de registro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
