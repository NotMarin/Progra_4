package view;

import javax.swing.*;
import controller.RoomControl;
import model.Room;
import model.Reservation;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class CancelReservationScreen extends JFrame {
  private JComboBox<Room> roomComboBox;
  private JComboBox<Reservation> reservationComboBox;

  public CancelReservationScreen() {
    super("Cancelar Reservación - MyHotel");

    // Configuración básica de la ventana
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(600, 400); // Ajuste del tamaño para acomodar mejor el contenido
    setLocationRelativeTo(null);

    // Panel principal
    JPanel mainPanel = new JPanel();
    mainPanel.setBackground(Color.WHITE);
    mainPanel.setLayout(new BorderLayout(20, 20)); // 20 px de espacio entre componentes

    // Panel de título y descripción
    JPanel titlePanel = new JPanel();
    titlePanel.setBackground(Color.WHITE);
    titlePanel.setLayout(new BorderLayout());

    JLabel titleLabel = new JLabel("<html><h1>Cancelar Reservación</h1></html>", SwingConstants.CENTER);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titlePanel.add(titleLabel, BorderLayout.NORTH);

    JLabel descriptionLabel = new JLabel(
        "<html><p>Seleccione una habitación y luego una reservación para cancelar.</p></html>", SwingConstants.CENTER);
    titlePanel.add(descriptionLabel, BorderLayout.CENTER);

    mainPanel.add(titlePanel, BorderLayout.NORTH);

    // Panel de formulario
    JPanel formPanel = new JPanel();
    formPanel.setBackground(Color.WHITE);
    formPanel.setLayout(new GridLayout(5, 1, 10, 10)); // 5 filas, 1 columna, 10 px de espacio entre filas

    JLabel roomLabel = new JLabel("Seleccionar Habitación:");
    JLabel reservationLabel = new JLabel("Seleccionar Reservación:");

    List<Room> rooms = RoomControl.getRooms();
    roomComboBox = new JComboBox<>(rooms.toArray(new Room[0]));
    reservationComboBox = new JComboBox<>();

    roomComboBox.addActionListener(e -> {
      Room selectedRoom = (Room) roomComboBox.getSelectedItem();
      if (selectedRoom != null) {
        List<Reservation> reservations = selectedRoom.getReservations();
        reservationComboBox.removeAllItems();
        for (Reservation reservation : reservations) {
          reservationComboBox.addItem(reservation);
        }
      }
    });

    formPanel.add(roomLabel);
    formPanel.add(roomComboBox);
    formPanel.add(reservationLabel);
    formPanel.add(reservationComboBox);

    mainPanel.add(formPanel, BorderLayout.CENTER);

    // Panel de botón
    JPanel buttonPanel = new JPanel();
    buttonPanel.setBackground(Color.WHITE);
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

    JButton cancelReservationButton = new JButton("Cancelar Reservación");

    cancelReservationButton.addActionListener(e -> {
      Room selectedRoom = (Room) roomComboBox.getSelectedItem();
      Reservation selectedReservation = (Reservation) reservationComboBox.getSelectedItem();

      if (selectedRoom != null && selectedReservation != null) {
        long diff = selectedReservation.getCheckInDate().getTime() - new Date().getTime();
        long diffDays = diff / (1000 * 60 * 60 * 24);
        selectedRoom.removeReservation(selectedReservation);
        RoomControl.updateRoom(selectedRoom);
        if (diffDays >= 7) {
          JOptionPane.showMessageDialog(this,
              "Reservación cancelada exitosamente. Usted es elegible para un reembolso.",
              "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(this,
              "Reservación cancelada exitosamente. No es posible un reembolso debido a la cancelación tardía.",
              "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
      } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una habitación y una reservación.", "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    });

    buttonPanel.add(cancelReservationButton);
    mainPanel.add(buttonPanel, BorderLayout.SOUTH);

    add(mainPanel);

    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(CancelReservationScreen::new);
  }
}
