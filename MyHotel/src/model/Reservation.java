package model;

import java.util.Date;

public class Reservation {
  private Date checkInDate;
  private Date checkOutDate;
  private String name;
  private int numGuests;

  public Reservation(Date checkInDate, Date checkOutDate, String name, int numGuests) {
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.name = name;
    this.numGuests = numGuests;
  }

  public boolean intersectsWith(Date otherCheckInDate, Date otherCheckOutDate) {
    return (otherCheckInDate.before(checkOutDate) && otherCheckOutDate.after(checkInDate));
  }

  // Getters and Setters for the new fields
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumGuests() {
    return numGuests;
  }

  public void setNumGuests(int numGuests) {
    this.numGuests = numGuests;
  }

  @Override
  public String toString() {
    return "Reserva para " + name + " del " + checkInDate + " al " + checkOutDate + " para " + numGuests + " huéspedes";
  }
}
