package view;

import javax.swing.*;
import controller.RoomControl;
import model.Room;
import java.util.List;

public class EditRoomScreen extends JFrame {
  private JComboBox<Room> roomComboBox;
  private JTextField priceField;
  private JTextArea amenitiesField;
  private JCheckBox availabilityCheckBox;

  public EditRoomScreen() {
    super("Editar Habitación - MyHotel");

    JPanel editPanel = new JPanel();
    GroupLayout layout = new GroupLayout(editPanel);
    editPanel.setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    JLabel roomLabel = new JLabel("Seleccionar Habitación:");
    JLabel priceLabel = new JLabel("Precio:");
    JLabel amenitiesLabel = new JLabel("Comodidades:");
    JLabel availabilityLabel = new JLabel("Disponibilidad:");

    List<Room> rooms = RoomControl.getRooms();
    roomComboBox = new JComboBox<>(rooms.toArray(new Room[0]));
    priceField = new JTextField(20);
    amenitiesField = new JTextArea(5, 20);
    availabilityCheckBox = new JCheckBox("Disponible");

    JButton saveButton = new JButton("Guardar Cambios");

    roomComboBox.addActionListener(e -> {
      Room selectedRoom = (Room) roomComboBox.getSelectedItem();
      if (selectedRoom != null) {
        priceField.setText(String.valueOf(selectedRoom.getPrice()));
        amenitiesField.setText(selectedRoom.getAmenities());
        availabilityCheckBox.setSelected(selectedRoom.isAvailable());
      }
    });

    saveButton.addActionListener(e -> saveChanges());

    GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
    hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        .addComponent(roomLabel)
        .addComponent(priceLabel)
        .addComponent(amenitiesLabel)
        .addComponent(availabilityLabel));
    hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(roomComboBox)
        .addComponent(priceField)
        .addComponent(amenitiesField)
        .addComponent(availabilityCheckBox)
        .addComponent(saveButton));
    layout.setHorizontalGroup(hGroup);

    GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(roomLabel)
        .addComponent(roomComboBox));
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(priceLabel)
        .addComponent(priceField));
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(amenitiesLabel)
        .addComponent(amenitiesField));
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(availabilityLabel)
        .addComponent(availabilityCheckBox));
    vGroup.addComponent(saveButton);
    layout.setVerticalGroup(vGroup);

    add(editPanel);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  // Método para guardar los cambios en la habitación
  private void saveChanges() {
    Room selectedRoom = (Room) roomComboBox.getSelectedItem();
    if (selectedRoom != null) {
      try {
        double price = Double.parseDouble(priceField.getText());
        String amenities = amenitiesField.getText();
        boolean availability = availabilityCheckBox.isSelected();

        selectedRoom.setPrice(price);
        selectedRoom.setAmenities(amenities);
        selectedRoom.setAvailable(availability);

        RoomControl.updateRoom(selectedRoom);
        JOptionPane.showMessageDialog(this, "Habitación actualizada satisfactoriamente", "Operación Exitosa",
            JOptionPane.INFORMATION_MESSAGE);
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "El precio debe ser un valor numérico", "Error de Formato",
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(EditRoomScreen::new);
  }
}
