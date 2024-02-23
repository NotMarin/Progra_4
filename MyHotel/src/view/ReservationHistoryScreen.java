package view;

import javax.swing.*;
import controller.RoomControl;
import model.Reservation;
import java.awt.*;
import java.util.List;

public class ReservationHistoryScreen extends JFrame {
  private JTextArea historyArea;

  public ReservationHistoryScreen() {
    super("Historial de Reservas - MyHotel");
    initializeUI();
    loadReservationHistory();
  }

  private void initializeUI() {
    // Configurar el panel principal
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // Crear el área de texto para mostrar el historial
    historyArea = new JTextArea(20, 40);
    historyArea.setEditable(false);
    historyArea.setFont(new Font("Serif", Font.PLAIN, 14));
    historyArea.setLineWrap(true);
    historyArea.setWrapStyleWord(true);

    // Añadir un panel de desplazamiento para el área de texto
    JScrollPane scrollPane = new JScrollPane(historyArea);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setBorder(BorderFactory.createTitledBorder("MyReservations"));

    // Añadir el panel de desplazamiento al panel principal
    mainPanel.add(scrollPane, BorderLayout.CENTER);

    // Añadir el botón para refrescar el historial
    JButton refreshButton = new JButton("Actualizar Historial");
    refreshButton.addActionListener(e -> loadReservationHistory());
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    buttonPanel.add(refreshButton);

    mainPanel.add(buttonPanel, BorderLayout.SOUTH);

    // Añadir el panel principal al marco
    add(mainPanel);

    // Configuración de la ventana
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void loadReservationHistory() {
    // Obtener la lista de reservas
    List<Reservation> reservations = RoomControl.getReservations();

    // Construir la cadena de texto con el historial de reservas
    StringBuilder history = new StringBuilder();
    if (reservations.isEmpty()) {
      history.append("No hay reservas realizadas.");
    } else {
      for (Reservation reservation : reservations) {
        history.append(reservation.toString()).append("\n\n");
      }
    }

    // Establecer el texto en el área de historial
    historyArea.setText(history.toString());
  }
}
