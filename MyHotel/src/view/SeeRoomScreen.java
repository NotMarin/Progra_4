package view;

import javax.swing.*;
import controller.RoomControl;
import model.Room;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SeeRoomScreen extends JFrame {
  private JComboBox<Room> roomComboBox;
  private JTextArea detailsArea;

  public SeeRoomScreen() {
    super("View Room Details - MyHotel");

    // Crear el panel principal con un fondo blanco
    JPanel panel = new JPanel();
    panel.setBackground(Color.WHITE);
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // Establecer el diseño del panel principal
    GroupLayout layout = new GroupLayout(panel);
    panel.setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    // Título
    JLabel titleLabel = new JLabel("<html>Detalles de <font color='#2ba8de'>MyRoom</font></html>");
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

    JLabel roomLabel = new JLabel("Seleccione la habitación:");
    roomLabel.setFont(new Font("Arial", Font.PLAIN, 16));

    // Obtener lista de habitaciones
    List<Room> rooms = RoomControl.getRooms();
    roomComboBox = new JComboBox<>(rooms.toArray(new Room[0]));
    roomComboBox.setFont(new Font("Arial", Font.PLAIN, 16));

    // Área de texto para detalles de la habitación
    detailsArea = new JTextArea(10, 30);
    detailsArea.setEditable(false);
    detailsArea.setFont(new Font("Arial", Font.PLAIN, 14));
    detailsArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    JScrollPane scrollPane = new JScrollPane(detailsArea);

    // Acción para cuando se seleccione una habitación
    roomComboBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Room selectedRoom = (Room) roomComboBox.getSelectedItem();
        if (selectedRoom != null) {
          showRoomDetails(selectedRoom);
        }
      }
    });

    // Configuración del GroupLayout
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(titleLabel)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roomLabel)
                .addComponent(roomComboBox))
            .addComponent(scrollPane));

    layout.setVerticalGroup(
        layout.createSequentialGroup()
            .addComponent(titleLabel)
            .addGap(20)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(roomLabel)
                .addComponent(roomComboBox))
            .addGap(20)
            .addComponent(scrollPane));

    add(panel);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(500, 400); // Tamaño ajustado para acomodar el contenido
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void showRoomDetails(Room room) {
    StringBuilder details = new StringBuilder();
    details.append("Tipo de Habitación: ").append(room.getType()).append("\n");
    details.append("Capacidad: ").append(room.getCapacity()).append("\n");
    details.append("Precio por Noche: ").append(room.getPrice()).append("\n");
    details.append("Servicios: ").append(room.getAmenities()).append("\n");

    detailsArea.setText(details.toString());
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new SeeRoomScreen());
  }
}
