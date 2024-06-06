package view;

import javax.swing.*;
import controller.RoomControl;
import model.Room;
import model.Reservation;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MakeReservationScreen extends JFrame {
  private JComboBox<Room> roomComboBox;
  private JTextField nameField;
  private JTextField checkInDateField;
  private JTextField checkOutDateField;
  private JTextField numGuestsField;
  private SimpleDateFormat dateFormat;

  public MakeReservationScreen() {
    super("Realizar Reserva - MyHotel");

    dateFormat = new SimpleDateFormat("YYYY-MM-DD");

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JLabel roomLabel = new JLabel("Seleccionar Habitación:");
    JLabel nameLabel = new JLabel("Nombre:");
    JLabel checkInDateLabel = new JLabel("Fecha de Entrada (YYYY-MM-DD):");
    JLabel checkOutDateLabel = new JLabel("Fecha de Salida (YYYY-MM-DD):");
    JLabel numGuestsLabel = new JLabel("Número de Huéspedes:");

    List<Room> rooms = RoomControl.getRooms();
    roomComboBox = new JComboBox<>(rooms.toArray(new Room[0]));
    nameField = new JTextField(20);
    checkInDateField = new JTextField(10);
    checkOutDateField = new JTextField(10);
    numGuestsField = new JTextField(5);

    JButton reserveButton = new JButton("Realizar Reserva");

    reserveButton.addActionListener(e -> {
      Room selectedRoom = (Room) roomComboBox.getSelectedItem();
      String name = nameField.getText();
      String checkInDateStr = checkInDateField.getText();
      String checkOutDateStr = checkOutDateField.getText();
      String numGuestsStr = numGuestsField.getText();

      if (selectedRoom != null && !name.isEmpty() && !checkInDateStr.isEmpty() && !checkOutDateStr.isEmpty()
          && !numGuestsStr.isEmpty()) {
        try {
          Date checkInDate = dateFormat.parse(checkInDateStr);
          Date checkOutDate = dateFormat.parse(checkOutDateStr);
          int numGuests = Integer.parseInt(numGuestsStr);

          if (numGuests <= selectedRoom.getCapacity()) {
            Reservation newReservation = new Reservation(checkInDate, checkOutDate, name, numGuests);
            boolean reservationSuccessful = RoomControl.bookRoom(selectedRoom, newReservation);
            if (reservationSuccessful) {
              JOptionPane.showMessageDialog(this, "Reserva realizada satisfactoriamente", "Operación Exitosa",
                  JOptionPane.INFORMATION_MESSAGE);
            } else {
              JOptionPane.showMessageDialog(this, "La habitación ya no está disponible para las fechas seleccionadas.",
                  "Error", JOptionPane.ERROR_MESSAGE);
            }
          } else {
            JOptionPane.showMessageDialog(this, "El número de huéspedes excede la capacidad de la habitación.", "Error",
                JOptionPane.ERROR_MESSAGE);
          }
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

    panel.add(roomLabel);
    panel.add(roomComboBox);
    panel.add(nameLabel);
    panel.add(nameField);
    panel.add(checkInDateLabel);
    panel.add(checkInDateField);
    panel.add(checkOutDateLabel);
    panel.add(checkOutDateField);
    panel.add(numGuestsLabel);
    panel.add(numGuestsField);
    panel.add(reserveButton);

    add(panel);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
