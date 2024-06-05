package view;

import javax.swing.*;
import controller.RoomControl;
import model.Room;
import model.Reservation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EditReservationScreen extends JFrame {
  private JComboBox<Room> roomComboBox;
  private JComboBox<Reservation> reservationComboBox;
  private JTextField checkInField;
  private JTextField checkOutField;
  private JTextField guestsField;
  private SimpleDateFormat dateFormat;

  public EditReservationScreen() {
    super("Modificar Reserva - MyHotel");

    dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JLabel roomLabel = new JLabel("Seleccionar Habitación:");
    JLabel reservationLabel = new JLabel("Seleccionar Reserva:");
    JLabel checkInLabel = new JLabel("Nueva Fecha de Entrada (yyyy-MM-dd):");
    JLabel checkOutLabel = new JLabel("Nueva Fecha de Salida (yyyy-MM-dd):");
    JLabel guestsLabel = new JLabel("Nuevo Número de Huéspedes:");

    List<Room> rooms = RoomControl.getRooms();
    roomComboBox = new JComboBox<>(rooms.toArray(new Room[0]));
    reservationComboBox = new JComboBox<>();
    checkInField = new JTextField(10);
    checkOutField = new JTextField(10);
    guestsField = new JTextField(5);

    JButton modifyButton = new JButton("Modificar Reserva");

    roomComboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Room selectedRoom = (Room) roomComboBox.getSelectedItem();
        if (selectedRoom != null) {
          List<Reservation> reservations = selectedRoom.getReservations();
          reservationComboBox.removeAllItems();
          for (Reservation reservation : reservations) {
            reservationComboBox.addItem(reservation);
          }
        }
      }
    });

    modifyButton.addActionListener(e -> {
      Room selectedRoom = (Room) roomComboBox.getSelectedItem();
      Reservation selectedReservation = (Reservation) reservationComboBox.getSelectedItem();
      String checkInStr = checkInField.getText();
      String checkOutStr = checkOutField.getText();
      String guestsStr = guestsField.getText();

      if (selectedRoom != null && selectedReservation != null && !checkInStr.isEmpty() && !checkOutStr.isEmpty()
          && !guestsStr.isEmpty()) {
        try {
          Date checkInDate = dateFormat.parse(checkInStr);
          Date checkOutDate = dateFormat.parse(checkOutStr);
          int numGuests = Integer.parseInt(guestsStr);

          selectedReservation.setCheckInDate(checkInDate);
          selectedReservation.setCheckOutDate(checkOutDate);
          selectedReservation.setNumGuests(numGuests);

          RoomControl.updateRoom(selectedRoom);
          JOptionPane.showMessageDialog(this, "Reserva modificada satisfactoriamente", "Operación Exitosa",
              JOptionPane.INFORMATION_MESSAGE);
        } catch (ParseException ex) {
          JOptionPane.showMessageDialog(this, "Por favor, ingrese fechas en el formato correcto (yyyy-MM-dd).", "Error",
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
    panel.add(reservationLabel);
    panel.add(reservationComboBox);
    panel.add(checkInLabel);
    panel.add(checkInField);
    panel.add(checkOutLabel);
    panel.add(checkOutField);
    panel.add(guestsLabel);
    panel.add(guestsField);
    panel.add(modifyButton);

    add(panel);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
