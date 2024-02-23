package view;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class HomeScreen extends JFrame {
  public HomeScreen() {
    super("Inicio de sesión - MyHotel");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 500);
    setLocationRelativeTo(null);

    // Crear un JLabel con la imagen de fondo
    JLabel background = new JLabel(new ImageIcon("MyHotel/assets/MyHotelScreen.jpeg"));
    background.setLayout(new GridBagLayout()); // Usar GridBagLayout para centrar los paneles
    setContentPane(background); // Establecer el JLabel como el panel de contenido

    // Configurar restricciones para GridBagLayout
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.BOTH;

    // Crear y añadir el panel de bienvenida
    background.add(createWelcomePanel(), gbc);

    // Crear y añadir el panel de navegación
    gbc.gridy = 1;
    background.add(createNavPanel(), gbc);

    setVisible(true);
  }

  private JPanel createWelcomePanel() {
    JPanel welcomePanel = new JPanel(new GridBagLayout());
    welcomePanel.setOpaque(false); // Hacer el panel transparente para que se vea la imagen de fondo

    // Panel con fondo negro y opacidad
    JPanel opaquePanel = new JPanel(new GridBagLayout());
    opaquePanel.setBackground(new Color(0, 0, 0, 150)); // Fondo negro con opacidad
    opaquePanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Añadir margenes

    JLabel welcomeLabel = new JLabel("Bienvenido", JLabel.CENTER);
    welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24));
    welcomeLabel.setForeground(Color.WHITE); // Establecer el color del texto

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(0, 0, 0, 0);
    gbc.anchor = GridBagConstraints.CENTER;
    opaquePanel.add(welcomeLabel, gbc);

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.BOTH;
    welcomePanel.add(opaquePanel, gbc);

    return welcomePanel;
  }

  private JPanel createNavPanel() {
    JPanel navPanel = new JPanel(new GridBagLayout());
    navPanel.setOpaque(false); // Hacer el panel transparente

    // Panel con fondo negro y opacidad
    JPanel opaquePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    opaquePanel.setBackground(new Color(0, 0, 0, 150)); // Fondo negro con opacidad
    opaquePanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Añadir margenes

    JMenuBar menuBar = createMenuBar();
    menuBar.setBorder(new CompoundBorder(
        new EmptyBorder(5, 5, 5, 5), // Márgenes internos
        new LineBorder(Color.GRAY, 1, true) // Borde redondeado
    ));

    opaquePanel.add(menuBar);

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.BOTH;
    navPanel.add(opaquePanel, gbc);

    return navPanel;
  }

  private JMenuBar createMenuBar() {
    JMenuBar menuBar = new JMenuBar();

    // Menú de Reservas
    JMenu bookingsMenu = new JMenu("Reservas");
    bookingsMenu.add(createMenuItem("Realizar reserva", () -> new MakeReservationScreen()));
    bookingsMenu.add(createMenuItem("Modificar reserva", () -> new EditReservationScreen()));
    bookingsMenu.add(createMenuItem("Cancelar reserva", () -> new CancelReservationScreen()));
    bookingsMenu.add(createMenuItem("Historial de reservas", () -> new ReservationHistoryScreen()));
    menuBar.add(bookingsMenu);

    // Menú de Habitaciones
    JMenu roomMenu = new JMenu("Habitaciones");
    roomMenu.add(createMenuItem("Ver detalles de habitación", () -> new SeeRoomScreen()));
    roomMenu.add(createMenuItem("Buscar Habitación", () -> new SearchRoomScreen()));
    menuBar.add(roomMenu);

    // Opción de Cerrar Sesión
    JMenuItem logoutItem = new JMenuItem("Cerrar sesión");
    logoutItem.addActionListener(e -> {
      dispose();
      new LoginScreen();
    });
    menuBar.add(logoutItem);

    return menuBar;
  }

  private JMenuItem createMenuItem(String title, Runnable action) {
    JMenuItem menuItem = new JMenuItem(title);
    menuItem.addActionListener(e -> action.run());
    return menuItem;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(HomeScreen::new);
  }
}
