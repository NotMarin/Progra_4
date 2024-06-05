package view;

import javax.swing.*;

public class HomeScreen extends JFrame {
  public HomeScreen() {
    super("Inicio de sesión - MyHotel");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 400);
    setLocationRelativeTo(null);

    JMenuBar menuBar = new JMenuBar();

    JMenu bookingsMenu = new JMenu("Reservas");
    JMenuItem makeBookingItem = new JMenuItem("Realizar reserva");
    JMenuItem modifyBookingItem = new JMenuItem("Modificar reserva");
    JMenuItem cancelBookingItem = new JMenuItem("Cancelar reserva");
    JMenuItem bookingsHistoryItem = new JMenuItem("Historial de reservas");

    makeBookingItem.addActionListener(e -> {
      new MakeReservationScreen();
    });

    modifyBookingItem.addActionListener(e -> {
      new EditReservationScreen();
    });

    cancelBookingItem.addActionListener(e -> {
      new CancelReservationScreen();
    });

    bookingsHistoryItem.addActionListener(e -> {
      new ReservationHistoryScreen();
    });

    bookingsMenu.add(makeBookingItem);
    bookingsMenu.add(modifyBookingItem);
    bookingsMenu.add(cancelBookingItem);
    bookingsMenu.add(bookingsHistoryItem);

    JMenu roomMenu = new JMenu("Habitaciones");
    JMenuItem viewRoomItem = new JMenuItem("Ver detalles de habitación");
    JMenuItem searchRoomItem = new JMenuItem("Buscar Habitación");

    viewRoomItem.addActionListener(e -> {
      new SeeRoomScreen();
    });

    searchRoomItem.addActionListener(e -> {
      new SearchRoomScreen();
    });

    roomMenu.add(viewRoomItem);
    roomMenu.add(searchRoomItem);

    JMenuItem logoutItem = new JMenuItem("Cerrar sesión");
    logoutItem.addActionListener(e -> {
      dispose();
      new LoginScreen();
    });

    menuBar.add(bookingsMenu);
    menuBar.add(roomMenu);
    menuBar.add(logoutItem);

    setJMenuBar(menuBar);

    setVisible(true);
  }
}
