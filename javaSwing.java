import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class javaSwing {
    private static final int ID_TYPE = 0;
    private static final int ID_NUMBER = 1;
    private static final int FIRST_NAME = 2;
    private static final int EMAIL = 6;
    private static final int PASSWORD = 8;

    private static java.util.List<String[]> users = new java.util.ArrayList<>();

    public static void showLoginRegistrationMenu() {
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(3, 2));

        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        frame.add(new JLabel("Email:"));
        frame.add(emailField);
        frame.add(new JLabel("Contraseña:"));
        frame.add(passwordField);

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if (validateCredentials(email, password)) {
                    JOptionPane.showMessageDialog(frame, "Bienvenido a MyHotel");
                } else {
                    JOptionPane.showMessageDialog(frame, "Credenciales incorrectas", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.add(loginButton);

        JButton registerButton = new JButton("Registrar Usuario");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegistrationForm();
            }
        });
        frame.add(registerButton);

        frame.setVisible(true);
    }

    public static void showRegistrationForm() {
        JFrame frame = new JFrame("Registro de Usuario");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(10, 2));

        JTextField idTypeField = new JTextField();
        JTextField idNumberField = new JTextField();
        JTextField firstNameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField residentialAddressField = new JTextField();
        JTextField cityOfResidenceField = new JTextField();
        JTextField contactPhoneNumberField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JPasswordField confirmPasswordField = new JPasswordField();

        frame.add(new JLabel("Tipo de identificación:"));
        frame.add(idTypeField);
        frame.add(new JLabel("Documento de identificación:"));
        frame.add(idNumberField);
        frame.add(new JLabel("Nombres:"));
        frame.add(firstNameField);
        frame.add(new JLabel("Email:"));
        frame.add(emailField);
        frame.add(new JLabel("Dirección de residencia:"));
        frame.add(residentialAddressField);
        frame.add(new JLabel("Ciudad de residencia:"));
        frame.add(cityOfResidenceField);
        frame.add(new JLabel("Teléfono de contacto:"));
        frame.add(contactPhoneNumberField);
        frame.add(new JLabel("Contraseña:"));
        frame.add(passwordField);
        frame.add(new JLabel("Confirmar Contraseña:"));
        frame.add(confirmPasswordField);

        JButton registerButton = new JButton("Registrar");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los campos
                String idType = idTypeField.getText();
                String idNumber = idNumberField.getText();
                String firstName = firstNameField.getText();
                String email = emailField.getText();
                String residentialAddress = residentialAddressField.getText();
                String cityOfResidence = cityOfResidenceField.getText();
                String contactPhoneNumber = contactPhoneNumberField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                // Verificar si las contraseñas coinciden
                if (password.equals(confirmPassword)) {
                    // Registrar al usuario
                    registerUser(idType, idNumber, firstName, email, residentialAddress, cityOfResidence,
                            contactPhoneNumber, password);
                    JOptionPane.showMessageDialog(frame, "Usuario registrado satisfactoriamente");
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Las contraseñas no coinciden", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.add(registerButton);

        frame.setVisible(true);
    }

    public static boolean validateCredentials(String email, String password) {
        for (String[] user : users) {
            if (user != null && user[EMAIL] != null && user[PASSWORD] != null && user[EMAIL].equals(email)
                    && user[PASSWORD].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void registerUser(String idType, String idNumber, String firstName, String email,
            String residentialAddress, String cityOfResidence, String contactPhoneNumber, String password) {
        String[] user = new String[10];
        user[ID_TYPE] = idType;
        user[ID_NUMBER] = idNumber;
        user[FIRST_NAME] = firstName;
        user[EMAIL] = email;
        user[PASSWORD] = password;

        users.add(user);
    }

    public static void main(String[] args) {
        showLoginRegistrationMenu();
    }
}
