package view;

import javax.swing.*;
import java.awt.*;
import controller.LoginControl;

public class LoginScreen extends JFrame {
  private JTextField emailField;
  private JPasswordField passwordField;

  public LoginScreen() {
    super("Inicio de Sesión - MyHotel");

    JPanel loginPanel = new JPanel();
    loginPanel.setBackground(Color.WHITE);
    GroupLayout layout = new GroupLayout(loginPanel);
    loginPanel.setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    // Cargar el logo del hotel
    String logoPath = "MyHotel/assets/MyHotelLogo.png";
    ImageIcon logoIcon = new ImageIcon(logoPath);
    if (logoIcon.getIconWidth() == -1) {
      System.out.println("Logo no encontrado en " + logoPath);
    }
    Image image = logoIcon.getImage();
    Image scaledImage = image.getScaledInstance(350, 350, Image.SCALE_SMOOTH); // Ajusta los valores de ancho y alto
                                                                               // según necesites
    logoIcon = new ImageIcon(scaledImage);
    JLabel logoLabel = new JLabel(logoIcon);

    // Título con "MyHotel" en azul claro
    JLabel titleLabel = new JLabel("<html>Bienvenido a <font color='#2ba8de'>MyHotel</font></html>");
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

    JLabel emailLabel = new JLabel("Correo:");
    JLabel passwordLabel = new JLabel("Contraseña:");
    emailField = new JTextField(20);
    passwordField = new JPasswordField(20);
    JButton loginButton = new JButton("Iniciar Sesión");
    JButton registerButton = new JButton("Registrarse");

    loginButton.addActionListener(e -> {
      String email = emailField.getText();
      String password = new String(passwordField.getPassword());
      if (email.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(LoginScreen.this, "Por favor, complete todos los campos", "Campos Vacíos",
            JOptionPane.WARNING_MESSAGE);
      } else {
        if (email.equals("admin") && password.equals("admin")) {
          JOptionPane.showMessageDialog(LoginScreen.this, "Inicio de sesión como Administrador", "¡Bienvenido!",
              JOptionPane.INFORMATION_MESSAGE);
          dispose();
          new AdminScreen();
        } else {
          boolean access = LoginControl.login(email, password);
          if (access) {
            JOptionPane.showMessageDialog(LoginScreen.this, "Inicio de sesión exitoso", "¡Bienvenido!",
                JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new HomeScreen();
          } else {
            JOptionPane.showMessageDialog(LoginScreen.this, "Credenciales incorrectas", "Error de Inicio de Sesión",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    registerButton.addActionListener(e -> {
      dispose();
      RegisterScreen registerScreen = new RegisterScreen();
      registerScreen.setVisible(true);
    });

    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(logoLabel)
            .addComponent(titleLabel)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(emailLabel)
                    .addComponent(passwordLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(emailField)
                    .addComponent(passwordField)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(loginButton)
                .addComponent(registerButton)));

    layout.setVerticalGroup(
        layout.createSequentialGroup()
            .addComponent(logoLabel)
            .addComponent(titleLabel)
            .addGap(20)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(emailLabel)
                .addComponent(emailField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(passwordLabel)
                .addComponent(passwordField))
            .addGap(20)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(loginButton)
                .addComponent(registerButton)));

    add(loginPanel);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(350, 600); // Aumenté el tamaño para acomodar el logo y el título
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new LoginScreen());
  }
}
