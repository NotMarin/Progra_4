package view;

import javax.swing.*;
import controller.RegisterControl;
import model.User;

public class RegisterScreen extends JFrame {
  private JTextField idTypeField;
  private JTextField idNumberField;
  private JTextField firstNameField;
  private JTextField lastNameField;
  private JTextField emailField;
  private JTextField addressField;
  private JTextField cityField;
  private JTextField phoneField;
  private JPasswordField passwordField;
  private JPasswordField confirmPasswordField;

  public RegisterScreen() {
    super("Registro de usuario - MyHotel");

    JPanel registrationPanel = new JPanel();
    GroupLayout layout = new GroupLayout(registrationPanel);
    registrationPanel.setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    JLabel idTypeLabel = new JLabel("Tipo de Identificación:");
    JLabel idNumberLabel = new JLabel("Número de Identificación:");
    JLabel firstNameLabel = new JLabel("Nombres:");
    JLabel lastNameLabel = new JLabel("Apellidos:");
    JLabel emailLabel = new JLabel("Correo Electrónico:");
    JLabel addressLabel = new JLabel("Dirección de Residencia:");
    JLabel cityLabel = new JLabel("Ciudad de Residencia:");
    JLabel phoneLabel = new JLabel("Teléfono de Contacto:");
    JLabel passwordLabel = new JLabel("Contraseña:");
    JLabel confirmPasswordLabel = new JLabel("Confirmar Contraseña:");
    idTypeField = new JTextField(20);
    idNumberField = new JTextField(20);
    firstNameField = new JTextField(20);
    lastNameField = new JTextField(20);
    emailField = new JTextField(20);
    addressField = new JTextField(20);
    cityField = new JTextField(20);
    phoneField = new JTextField(20);
    passwordField = new JPasswordField(20);
    confirmPasswordField = new JPasswordField(20);

    JButton registerButton = new JButton("Registrar");

    registerButton.addActionListener(e -> {
      String idType = idTypeField.getText();
      String idNumber = idNumberField.getText();
      String firstName = firstNameField.getText();
      String lastName = lastNameField.getText();
      String email = emailField.getText();
      String address = addressField.getText();
      String city = cityField.getText();
      String phone = phoneField.getText();
      String password = new String(passwordField.getPassword());
      String confirmPassword = new String(confirmPasswordField.getPassword());
      if (RegisterControl.isUserRegistered(email)) {
        JOptionPane.showMessageDialog(this, "Este usuario ya está registrado", "Error de Registro",
            JOptionPane.ERROR_MESSAGE);
      } else {
        if (email.isEmpty() || password.isEmpty()) {
          JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Campos Vacíos",
              JOptionPane.WARNING_MESSAGE);
        } else {
          if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "La confirmación de la contraseña es incorrecta", "Error de Registro",
                JOptionPane.ERROR_MESSAGE);
          } else {
            User newUser = new User(idType, idNumber, firstName, lastName, email, address, city, phone, password);
            RegisterControl.registerUser(newUser);
            JOptionPane.showMessageDialog(this, "Usuario registrado satisfactoriamente", "Registro Exitoso",
                JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new LoginScreen();
          }
        }
      }
    });

    JButton loginButton = new JButton("Iniciar Sesión");
    loginButton.addActionListener(e -> {
      dispose();
      LoginScreen loginFrame = new LoginScreen();
      loginFrame.setVisible(true);
    });

    GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
    hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        .addComponent(idTypeLabel)
        .addComponent(idNumberLabel)
        .addComponent(firstNameLabel)
        .addComponent(lastNameLabel)
        .addComponent(emailLabel)
        .addComponent(addressLabel)
        .addComponent(cityLabel)
        .addComponent(phoneLabel)
        .addComponent(passwordLabel)
        .addComponent(confirmPasswordLabel));
    hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(idTypeField)
        .addComponent(idNumberField)
        .addComponent(firstNameField)
        .addComponent(lastNameField)
        .addComponent(emailField)
        .addComponent(addressField)
        .addComponent(cityField)
        .addComponent(phoneField)
        .addComponent(passwordField)
        .addComponent(confirmPasswordField)
        .addComponent(registerButton)
        .addComponent(loginButton));
    layout.setHorizontalGroup(hGroup);

    GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(idTypeLabel)
        .addComponent(idTypeField));
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(idNumberLabel)
        .addComponent(idNumberField));
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(firstNameLabel)
        .addComponent(firstNameField));
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(lastNameLabel)
        .addComponent(lastNameField));
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(emailLabel)
        .addComponent(emailField));
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(addressLabel)
        .addComponent(addressField));
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(cityLabel)
        .addComponent(cityField));
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(phoneLabel)
        .addComponent(phoneField));
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(passwordLabel)
        .addComponent(passwordField));
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(confirmPasswordLabel)
        .addComponent(confirmPasswordField));
    vGroup.addComponent(registerButton);
    vGroup.addComponent(loginButton);
    layout.setVerticalGroup(vGroup);

    add(registrationPanel);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
