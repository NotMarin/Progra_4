package view;

import javax.swing.*;
import controller.RoomControl;
import model.Room;

public class DeleteRoomScreen extends JFrame {
  private JComboBox<Room> roomComboBox;

  public DeleteRoomScreen() {
    super("Eliminar Habitación - MyHotel");

    JPanel deletePanel = new JPanel();
    GroupLayout layout = new GroupLayout(deletePanel);
    deletePanel.setLayout(layout);
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

    add(deletePanel);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
