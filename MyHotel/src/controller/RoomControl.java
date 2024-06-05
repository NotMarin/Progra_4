package controller;

import model.Room;
import model.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomControl {
  private static List<Room> rooms = new ArrayList<>();

  public static void addRoom(Room room) {
    rooms.add(room);
  }

  public static List<Room> getRooms() {
    return rooms;
  }

  public static void updateRoom(Room room) {
    // Implementación para actualizar una habitación
  }

  public static void deleteRoom(Room room) {
    rooms.remove(room);
  }

  public static List<Room> checkAvailability(Date startDate, Date endDate) {
    List<Room> availableRooms = new ArrayList<>();
    for (Room room : rooms) {
      if (room.isAvailable()) {
        boolean available = true;
        for (Reservation reservation : room.getReservations()) {
          if (reservation.intersectsWith(startDate, endDate)) {
            available = false;
            break;
          }
        }
        if (available) {
          availableRooms.add(room);
        }
      }
    }
    return availableRooms;
  }

  public static List<Room> searchAvailableRooms(Date checkInDate, Date checkOutDate, int numGuests, String roomType) {
    List<Room> availableRooms = new ArrayList<>();
    for (Room room : rooms) {
      if (room.getType().equalsIgnoreCase(roomType) && room.getCapacity() >= numGuests
          && room.isAvailable()) {
        availableRooms.add(room);
      }
    }
    return availableRooms;
  }

  public static boolean bookRoom(Room room, Reservation reservation) {
    if (room.isAvailable()) {
      room.addReservation(reservation);
      room.setAvailable(false);
      return true;
    }
    return false;
  }

  public static List<Reservation> getReservations() {
    List<Reservation> allReservations = new ArrayList<>();
    for (Room room : rooms) {
      allReservations.addAll(room.getReservations());
    }
    return allReservations;
  }
}
