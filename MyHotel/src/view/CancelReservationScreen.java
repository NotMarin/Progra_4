package view;

import javax.swing.*;
import controller.RoomControl;
import model.Room;
import model.Reservation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class CancelReservationScreen extends JFrame {
  private JComboBox<Room> roomComboBox;
  private JComboBox<Reservation> reservationComboBox;

  public CancelReservationScreen() {
    super("Cancel Reservation - MyHotel");

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JLabel roomLabel = new JLabel("Select Room:");
    JLabel reservationLabel = new JLabel("Select Reservation:");

    List<Room> rooms = RoomControl.getRooms();
    roomComboBox = new JComboBox<>(rooms.toArray(new Room[0]));
    reservationComboBox = new JComboBox<>();

    JButton cancelReservationButton = new JButton("Cancel Reservation");

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

    cancelReservationButton.addActionListener(e -> {
      Room selectedRoom = (Room) roomComboBox.getSelectedItem();
      Reservation selectedReservation = (Reservation) reservationComboBox.getSelectedItem();

      if (selectedRoom != null && selectedReservation != null) {
        long diff = selectedReservation.getCheckInDate().getTime() - new Date().getTime();
        long diffDays = diff / (1000 * 60 * 60 * 24);
        selectedRoom.removeReservation(selectedReservation);
        RoomControl.updateRoom(selectedRoom);
        if (diffDays >= 7) {
          JOptionPane.showMessageDialog(this, "Reservation canceled successfully. You are eligible for a refund.",
              "Operation Successful", JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(this,
              "Reservation canceled successfully. No refund is possible due to late cancellation.",
              "Operation Successful", JOptionPane.INFORMATION_MESSAGE);
        }
      } else {
        JOptionPane.showMessageDialog(this, "Please select a room and a reservation.", "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    });

    panel.add(roomLabel);
    panel.add(roomComboBox);
    panel.add(reservationLabel);
    panel.add(reservationComboBox);
    panel.add(cancelReservationButton);

    add(panel);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
