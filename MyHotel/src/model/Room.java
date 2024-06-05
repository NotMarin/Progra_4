package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Room {
  private String type;
  private Date checkInDate;
  private Date checkOutDate;
  private int capacity;
  private double price;
  private String amenities;
  private boolean available;
  private List<Reservation> reservations;
  private String id;

  public Room(String type, Date checkInDate, Date checkOutDate, int capacity, double price, String amenities,
      String id) {
    this.type = type;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.capacity = capacity;
    this.price = price;
    this.amenities = amenities;
    this.available = true;
    this.reservations = new ArrayList<>();
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public int getCapacity() {
    return capacity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getAmenities() {
    return amenities;
  }

  public void setAmenities(String amenities) {
    this.amenities = amenities;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }

  public Date getCheckInDate() {
    return checkInDate;
  }

  public void setCheckInDate(Date checkInDate) {
    this.checkInDate = checkInDate;
  }

  public Date getCheckOutDate() {
    return checkOutDate;
  }

  public void setCheckOutDate(Date checkOutDate) {
    this.checkOutDate = checkOutDate;
  }

  public void addReservation(Reservation reservation) {
    reservations.add(reservation);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void removeReservation(Reservation reservation) {
    reservations.remove(reservation);
    boolean stillReserved = false;
    for (Reservation r : reservations) {
      if (r.getCheckInDate().before(reservation.getCheckOutDate())
          && r.getCheckOutDate().after(reservation.getCheckInDate())) {
        stillReserved = true;
        break;
      }
    }
    if (!stillReserved) {
      setAvailable(true);
    }
  }

  @Override
  public String toString() {
    return type + " - Capacidad: " + capacity + " - Precio: " + price + " - Comodidades: " + amenities
        + " - Disponible: " + available;
  }
}
