package view;

import javax.swing.*;
import controller.RoomControl;
import model.Room;
import java.awt.*;

public class DeleteRoomScreen extends JFrame {
  private JComboBox<Room> roomComboBox;

  public DeleteRoomScreen() {
    super("Eliminar Habitación - MyHotel");

    // Configuración básica de la ventana
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(600, 300);
    setLocationRelativeTo(null);

    // Panel principal
    JPanel mainPanel = new JPanel();
    mainPanel.setBackground(Color.WHITE);
    mainPanel.setLayout(new BorderLayout(20, 20)); // 20 px de espacio entre componentes

    // Panel de título y descripción
    JPanel titlePanel = new JPanel();
    titlePanel.setBackground(Color.WHITE);
    titlePanel.setLayout(new BorderLayout());

    JLabel titleLabel = new JLabel("<html><h1>Eliminar Habitación</h1></html>", SwingConstants.CENTER);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titlePanel.add(titleLabel, BorderLayout.NORTH);

    JLabel descriptionLabel = new JLabel("<html><p>Seleccione una habitación de la lista para eliminar.</p></html>",
        SwingConstants.CENTER);
    titlePanel.add(descriptionLabel, BorderLayout.CENTER);

    mainPanel.add(titlePanel, BorderLayout.NORTH);

    // Panel de formulario
    JPanel formPanel = new JPanel();
    formPanel.setBackground(Color.WHITE);
    GroupLayout layout = new GroupLayout(formPanel);
    formPanel.setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    JLabel roomLabel = new JLabel("Seleccionar Habitación:");

    roomComboBox = new JComboBox<>(RoomControl.getRooms().toArray(new Room[0]));

    JButton deleteButton = new JButton("Eliminar Habitación");

    deleteButton.addActionListener(e -> {
      Room selectedRoom = (Room) roomComboBox.getSelectedItem();
      if (selectedRoom != null) {
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar esta habitación?",
            "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
          RoomControl.deleteRoom(selectedRoom);
          JOptionPane.showMessageDialog(this, "Habitación eliminada satisfactoriamente", "Operación Exitosa",
              JOptionPane.INFORMATION_MESSAGE);
          roomComboBox.removeItem(selectedRoom);
        }
      }
    });

    GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
    hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        .addComponent(roomLabel));
    hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(roomComboBox)
        .addComponent(deleteButton));
    layout.setHorizontalGroup(hGroup);

    GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(roomLabel)
        .addComponent(roomComboBox));
    vGroup.addComponent(deleteButton);
    layout.setVerticalGroup(vGroup);

    mainPanel.add(formPanel, BorderLayout.CENTER);

    add(mainPanel);

    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(DeleteRoomScreen::new);
  }
}
