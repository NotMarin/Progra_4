package view;

import javax.swing.*;

public class AdminScreen extends JFrame {
  public AdminScreen() {
    super("Administrador - MyHotel");

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(600, 400);
    setLocationRelativeTo(null);

    JMenuBar menuBar = new JMenuBar();

    JMenu adminMenu = new JMenu("Administración");

    JMenuItem checkAvailabilityItem = new JMenuItem("Verificar Disponibilidad");
    JMenuItem addRoomItem = new JMenuItem("Agregar Habitación al Inventario");
    JMenuItem editRoomItem = new JMenuItem("Editar Habitación en el Inventario");
    JMenuItem deleteRoomItem = new JMenuItem("Eliminar Habitación del Inventario");

    checkAvailabilityItem.addActionListener(e -> {
      new RoomAvailableScreen();
    });

    addRoomItem.addActionListener(e -> {
      new AddRoomScreen();
    });

    editRoomItem.addActionListener(e -> {
      new EditRoomScreen();
    });

    deleteRoomItem.addActionListener(e -> {
      new DeleteRoomScreen();
    });

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
    menuBar.add(logoutItem);

    setJMenuBar(menuBar);

    setVisible(true);
  }
}
