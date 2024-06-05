package view;

import javax.swing.*;
import controller.RoomControl;
import model.Room;
import java.util.Date;

public class AddRoomScreen extends JFrame {
  private JComboBox<String> typeComboBox;
  private JTextField capacityField;
  private JTextField priceField;
  private JTextArea amenitiesField;

  public AddRoomScreen() {
    super("Agregar Habitación - MyHotel");

    JPanel addPanel = new JPanel();
    GroupLayout layout = new GroupLayout(addPanel);
    addPanel.setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    JLabel typeLabel = new JLabel("Tipo de Habitación:");
    JLabel capacityLabel = new JLabel("Capacidad:");
    JLabel priceLabel = new JLabel("Precio:");
    JLabel amenitiesLabel = new JLabel("Comodidades:");

    typeComboBox = new JComboBox<>(new String[] { "Sencilla", "Múltiple" });
    capacityField = new JTextField(20);
    priceField = new JTextField(20);
    amenitiesField = new JTextArea(5, 20);

    JButton addButton = new JButton("Agregar");

    addButton.addActionListener(e -> {
      String type = (String) typeComboBox.getSelectedItem();
      Date checkInDate = new Date();
      Date checkOutDate = new Date();
      int capacity;
      double price;
      String amenities = amenitiesField.getText();
      String id = "Habitacion" + RoomControl.getRooms().size() + 1;
      try {
        capacity = Integer.parseInt(capacityField.getText());
        price = Double.parseDouble(priceField.getText());
        if (amenities.isEmpty()) {
          JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos", "Campos Vacíos",
              JOptionPane.WARNING_MESSAGE);
        } else {
          Room newRoom = new Room(type, checkInDate, checkOutDate, capacity, price, amenities, id);
          RoomControl.addRoom(newRoom);
          JOptionPane.showMessageDialog(this, "Habitación agregada satisfactoriamente", "Operación Exitosa",
              JOptionPane.INFORMATION_MESSAGE);
          dispose();
        }
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Capacidad y Precio deben ser valores numéricos", "Error de Formato",
            JOptionPane.ERROR_MESSAGE);
      }
    });

    GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
    hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        .addComponent(typeLabel)
        .addComponent(capacityLabel)
        .addComponent(priceLabel)
        .addComponent(amenitiesLabel));
    hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(typeComboBox)
        .addComponent(capacityField)
        .addComponent(priceField)
        .addComponent(amenitiesField)
        .addComponent(addButton));
    layout.setHorizontalGroup(hGroup);

    GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(typeLabel)
        .addComponent(typeComboBox));
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(capacityLabel)
        .addComponent(capacityField));
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(priceLabel)
        .addComponent(priceField));
    vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(amenitiesLabel)
        .addComponent(amenitiesField));
    vGroup.addComponent(addButton);
    layout.setVerticalGroup(vGroup);

    add(addPanel);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
