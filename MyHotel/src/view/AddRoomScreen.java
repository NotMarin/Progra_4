package view;

import javax.swing.*;
import java.awt.*;
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

    // Crear el panel principal con un fondo blanco
    JPanel addPanel = new JPanel();
    addPanel.setBackground(Color.WHITE);
    addPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // Establecer el diseño del panel principal
    GroupLayout layout = new GroupLayout(addPanel);
    addPanel.setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    // Título
    JLabel titleLabel = new JLabel("<html>Agregar Habitación a <font color='#2ba8de'>MyHotel</font></html>");
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

    JLabel typeLabel = new JLabel("Tipo de Habitación:");
    JLabel capacityLabel = new JLabel("Capacidad:");
    JLabel priceLabel = new JLabel("Precio:");
    JLabel amenitiesLabel = new JLabel("Comodidades:");

    typeComboBox = new JComboBox<>(new String[] { "Sencilla", "Múltiple" });
    capacityField = new JTextField(20);
    priceField = new JTextField(20);
    amenitiesField = new JTextArea(5, 20);
    amenitiesField.setLineWrap(true);
    amenitiesField.setWrapStyleWord(true);
    JScrollPane amenitiesScrollPane = new JScrollPane(amenitiesField);

    JButton addButton = new JButton("Agregar");

    addButton.addActionListener(e -> {
      String type = (String) typeComboBox.getSelectedItem();
      Date checkInDate = new Date();
      Date checkOutDate = new Date();
      int capacity;
      double price;
      String amenities = amenitiesField.getText();
      String id = "Habitacion" + (RoomControl.getRooms().size() + 1);
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

    // Configuración del GroupLayout
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(titleLabel)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(typeLabel)
                    .addComponent(capacityLabel)
                    .addComponent(priceLabel)
                    .addComponent(amenitiesLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(typeComboBox)
                    .addComponent(capacityField)
                    .addComponent(priceField)
                    .addComponent(amenitiesScrollPane)
                    .addComponent(addButton))));

    layout.setVerticalGroup(
        layout.createSequentialGroup()
            .addComponent(titleLabel)
            .addGap(20)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(typeLabel)
                .addComponent(typeComboBox))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(capacityLabel)
                .addComponent(capacityField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(priceLabel)
                .addComponent(priceField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(amenitiesLabel)
                .addComponent(amenitiesScrollPane))
            .addGap(20)
            .addComponent(addButton));

    add(addPanel);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(500, 400); // Tamaño ajustado para acomodar el contenido
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new AddRoomScreen());
  }
}
