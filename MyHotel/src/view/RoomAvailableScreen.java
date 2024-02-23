package view;

import javax.swing.*;
import controller.RoomControl;
import model.Room;
import java.util.List;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RoomAvailableScreen extends JFrame {
  private JTextArea resultArea;
  private SimpleDateFormat dateFormat;

  public RoomAvailableScreen() {
    super("Verificar Disponibilidad - MyHotel");

    dateFormat = new SimpleDateFormat("YYYY-MM-DD");

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JLabel periodLabel = new JLabel("Ingrese el período de tiempo (por ejemplo, '2024-06-10' al '2024-06-15'):");
    JTextField startDateField = new JTextField(10);
    JTextField endDateField = new JTextField(10);
    JButton checkButton = new JButton("Verificar Disponibilidad");

    resultArea = new JTextArea(20, 40);
    resultArea.setEditable(false);

    checkButton.addActionListener(e -> {
      String startDateStr = startDateField.getText();
      String endDateStr = endDateField.getText();
      if (!startDateStr.isEmpty() && !endDateStr.isEmpty()) {
        try {
          Date startDate = dateFormat.parse(startDateStr);
          Date endDate = dateFormat.parse(endDateStr);
          List<Room> availableRooms = RoomControl.checkAvailability(startDate, endDate);
          showAvailability(availableRooms);
        } catch (ParseException ex) {
          JOptionPane.showMessageDialog(this, "Por favor, ingrese fechas en el formato correcto (YYYY-MM-DD).", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      } else {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese ambas fechas.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    });

    panel.add(periodLabel);
    panel.add(new JLabel("Fecha Inicio:"));
    panel.add(startDateField);
    panel.add(new JLabel("Fecha Fin:"));
    panel.add(endDateField);
    panel.add(checkButton);
    panel.add(new JScrollPane(resultArea));

    add(panel);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void showAvailability(List<Room> availableRooms) {
    if (availableRooms.isEmpty()) {
      resultArea.setText("No hay habitaciones disponibles para el período especificado.\n");
    } else {
      StringBuilder sb = new StringBuilder();
      sb.append("Habitaciones disponibles para el período especificado:\n");
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
