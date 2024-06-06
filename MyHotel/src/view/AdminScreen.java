package view;

import javax.swing.*;
import java.awt.*;

public class AdminScreen extends JFrame {
  public AdminScreen() {
    super("Administrador - MyHotel");

    // Configuración básica de la ventana
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(500, 400); // Ajuste del tamaño para acomodar mejor el contenido
    setLocationRelativeTo(null);

    // Barra de menú
    JMenuBar menuBar = new JMenuBar();
    JMenu adminMenu = new JMenu("Administración");

    JMenuItem checkAvailabilityItem = new JMenuItem("Verificar Disponibilidad");
    JMenuItem addRoomItem = new JMenuItem("Agregar Habitación al Inventario");
    JMenuItem editRoomItem = new JMenuItem("Editar Habitación en el Inventario");
    JMenuItem deleteRoomItem = new JMenuItem("Eliminar Habitación del Inventario");

    checkAvailabilityItem.addActionListener(e -> new RoomAvailableScreen());
    addRoomItem.addActionListener(e -> new AddRoomScreen());
    editRoomItem.addActionListener(e -> new EditRoomScreen());
    deleteRoomItem.addActionListener(e -> new DeleteRoomScreen());

    adminMenu.add(checkAvailabilityItem);
    adminMenu.add(addRoomItem);
    adminMenu.add(editRoomItem);
    adminMenu.add(deleteRoomItem);

    JMenuItem logoutItem = new JMenuItem("Cerrar sesión");
    logoutItem.addActionListener(e -> {
      dispose();
      new LoginScreen();
    });

    menuBar.add(adminMenu);
    menuBar.add(Box.createHorizontalGlue());
    menuBar.add(logoutItem);
    setJMenuBar(menuBar);

    // Panel de bienvenida
    JPanel welcomePanel = new JPanel();
    welcomePanel.setBackground(Color.WHITE);
    welcomePanel.setLayout(new BorderLayout());

    JLabel welcomeLabel = new JLabel("<html><h1>Bienvenido a <font color='#2ba8de'>MyHotel</font></h1></html>",
        SwingConstants.CENTER);
    welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));
    welcomePanel.add(welcomeLabel, BorderLayout.NORTH);

    JLabel adminLabel = new JLabel("Panel de Administración", SwingConstants.CENTER);
    adminLabel.setFont(new Font("Arial", Font.PLAIN, 24));
    welcomePanel.add(adminLabel, BorderLayout.CENTER);

    // Panel de botones
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(2, 2, 20, 20)); // 2 filas, 2 columnas, con espacio entre botones
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes alrededor

    JButton checkAvailabilityButton = new JButton("Verificar Disponibilidad");
    JButton addRoomButton = new JButton("Agregar Habitación");
    JButton editRoomButton = new JButton("Editar Habitación");
    JButton deleteRoomButton = new JButton("Eliminar Habitación");

    checkAvailabilityButton.addActionListener(e -> new RoomAvailableScreen());
    addRoomButton.addActionListener(e -> new AddRoomScreen());
    editRoomButton.addActionListener(e -> new EditRoomScreen());
    deleteRoomButton.addActionListener(e -> new DeleteRoomScreen());

    buttonPanel.add(checkAvailabilityButton);
    buttonPanel.add(addRoomButton);
    buttonPanel.add(editRoomButton);
    buttonPanel.add(deleteRoomButton);

    welcomePanel.add(buttonPanel, BorderLayout.SOUTH);

    add(welcomePanel);

    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(AdminScreen::new);
  }
}
