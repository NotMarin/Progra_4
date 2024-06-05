package view;

import javax.swing.*;
import controller.RoomControl;
import model.Room;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SeeRoomScreen extends JFrame {
  private JComboBox<Room> roomComboBox;
  private JTextArea detailsArea;

  public SeeRoomScreen() {
    super("View Room Details - MyHotel");

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JLabel roomLabel = new JLabel("Select Room:");

    List<Room> rooms = RoomControl.getRooms();
    roomComboBox = new JComboBox<>(rooms.toArray(new Room[0]));

    detailsArea = new JTextArea(10, 30);
    detailsArea.setEditable(false);

    roomComboBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Room selectedRoom = (Room) roomComboBox.getSelectedItem();
        if (selectedRoom != null) {
          showRoomDetails(selectedRoom);
        }
      }
    });

    panel.add(roomLabel);
    panel.add(roomComboBox);
    panel.add(new JScrollPane(detailsArea));

    add(panel);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void showRoomDetails(Room room) {
    StringBuilder details = new StringBuilder();
    details.append("Room Type: ").append(room.getType()).append("\n");
    details.append("Capacity: ").append(room.getCapacity()).append("\n");
    details.append("Price per Night: ").append(room.getPrice()).append("\n");
    details.append("Amenities: ").append(room.getAmenities()).append("\n");

    detailsArea.setText(details.toString());
  }
}
