package view;

import javax.swing.*;
import controller.RoomControl;
import model.Room;
import java.util.List;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SearchRoomScreen extends JFrame {
  private JTextArea resultArea;
  private JTextField checkInField;
  private JTextField checkOutField;
  private JTextField numGuestsField;
  private JComboBox<String> roomTypeComboBox;
  private SimpleDateFormat dateFormat;

  public SearchRoomScreen() {
    super("Buscar Habitaciones Disponibles - MyHotel");

    dateFormat = new SimpleDateFormat("YYYY-MM-DD");

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JLabel checkInLabel = new JLabel("Fecha de Entrada (YYYY-MM-DD):");
    JLabel checkOutLabel = new JLabel("Fecha de Salida (YYYY-MM-DD):");
    JLabel numGuestsLabel = new JLabel("Número de Huéspedes:");
    JLabel roomTypeLabel = new JLabel("Tipo de Habitación:");

    checkInField = new JTextField(10);
    checkOutField = new JTextField(10);
    numGuestsField = new JTextField(5);
    roomTypeComboBox = new JComboBox<>(new String[] { "Acomodación sencilla", "Acomodación múltiple" });

    JButton searchButton = new JButton("Buscar Habitaciones Disponibles");

    resultArea = new JTextArea(20, 40);
    resultArea.setEditable(false);

    searchButton.addActionListener(e -> {
      String checkInDateStr = checkInField.getText();
      String checkOutDateStr = checkOutField.getText();
      String numGuestsStr = numGuestsField.getText();
      if (!checkInDateStr.isEmpty() && !checkOutDateStr.isEmpty() && !numGuestsStr.isEmpty()) {
        try {
          Date checkInDate = dateFormat.parse(checkInDateStr);
          Date checkOutDate = dateFormat.parse(checkOutDateStr);
          List<Room> availableRooms = RoomControl.checkAvailability(checkInDate, checkOutDate);
          showAvailableRooms(availableRooms);
        } catch (ParseException ex) {
          JOptionPane.showMessageDialog(this, "Por favor, ingrese fechas en el formato correcto (YYYY-MM-DD).", "Error",
              JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido de huéspedes.", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      } else {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    });

    panel.add(checkInLabel);
    panel.add(checkInField);
    panel.add(checkOutLabel);
    panel.add(checkOutField);
    panel.add(numGuestsLabel);
    panel.add(numGuestsField);
    panel.add(roomTypeLabel);
    panel.add(roomTypeComboBox);
    panel.add(searchButton);
    panel.add(new JScrollPane(resultArea));

    add(panel);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void showAvailableRooms(List<Room> availableRooms) {
    if (availableRooms.isEmpty()) {
      resultArea.setText("No hay habitaciones disponibles para los criterios especificados.\n");
    } else {
      StringBuilder sb = new StringBuilder();
      sb.append("Habitaciones disponibles para los criterios especificados:\n");
      for (Room room : availableRooms) {
        sb.append("Tipo: ").append(room.getType())
            .append(" - Capacidad: ").append(room.getCapacity())
            .append(" - Precio: ").append(room.getPrice())
            .append(" - Comodidades: ").append(room.getAmenities()).append("\n");
      }
      resultArea.setText(sb.toString());
    }
  }
}
