package view;

import javax.swing.*;
import controller.RoomControl;
import model.Room;
import model.Reservation;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EditReservationScreen extends JFrame {
  private JComboBox<Room> roomComboBox;
  private JComboBox<Reservation> reservationComboBox;
  private JTextField checkInField;
  private JTextField checkOutField;
  private JTextField guestsField;
  private SimpleDateFormat dateFormat;

  public EditReservationScreen() {
    super("Modificar Reserva - MyHotel");

    dateFormat = new SimpleDateFormat("YYYY-MM-DD");

    // Configuración básica de la ventana
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(600, 400);
    setLocationRelativeTo(null);

    // Panel principal
    JPanel mainPanel = new JPanel();
    mainPanel.setBackground(Color.WHITE);
    mainPanel.setLayout(new BorderLayout(20, 20)); // Espacio entre componentes

    // Panel de título y descripción
    JPanel titlePanel = new JPanel();
    titlePanel.setBackground(Color.WHITE);
    titlePanel.setLayout(new BorderLayout());

    JLabel titleLabel = new JLabel("<html><h1>Modificar Reserva</h1></html>", SwingConstants.CENTER);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titlePanel.add(titleLabel, BorderLayout.NORTH);

    JLabel descriptionLabel = new JLabel(
        "<html><p>Seleccione una habitación y una reserva y luego ingrese las nuevas fechas y el número de huéspedes.</p></html>",
        SwingConstants.CENTER);
    titlePanel.add(descriptionLabel, BorderLayout.CENTER);

    mainPanel.add(titlePanel, BorderLayout.NORTH);

    // Panel de formulario
    JPanel formPanel = new JPanel();
    formPanel.setBackground(Color.WHITE);
    formPanel.setLayout(new GridLayout(5, 2, 10, 10)); // Filas, columnas, espacios

    JLabel roomLabel = new JLabel("Seleccionar Habitación:");
    JLabel reservationLabel = new JLabel("Seleccionar Reserva:");
    JLabel checkInLabel = new JLabel("Nueva Fecha de Entrada (YYYY-MM-DD):");
    JLabel checkOutLabel = new JLabel("Nueva Fecha de Salida (YYYY-MM-DD):");
    JLabel guestsLabel = new JLabel("Nuevo Número de Huéspedes:");

    List<Room> rooms = RoomControl.getRooms();
    roomComboBox = new JComboBox<>(rooms.toArray(new Room[0]));
    reservationComboBox = new JComboBox<>();
    checkInField = new JTextField();
    checkOutField = new JTextField();
    guestsField = new JTextField();

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
    formPanel.add(checkInLabel);
    formPanel.add(checkInField);
    formPanel.add(checkOutLabel);
    formPanel.add(checkOutField);
    formPanel.add(guestsLabel);
    formPanel.add(guestsField);

    mainPanel.add(formPanel, BorderLayout.CENTER);

    // Botón para modificar la reserva
    JButton modifyButton = new JButton("Modificar Reserva");
    modifyButton.addActionListener(e -> modifyReservation());
    mainPanel.add(modifyButton, BorderLayout.SOUTH);

    add(mainPanel);
    setVisible(true);
  }

  // Método para modificar la reserva
  private void modifyReservation() {
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
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(EditReservationScreen::new);
  }
}
