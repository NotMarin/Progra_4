package model;

import java.util.ArrayList;
import java.util.List;

public class User {
  private String idType;
  private String idNumber;
  private String firstName;
  private String lastName;
  private String email;
  private String homeAddress;
  private String cityResidence;
  private String contactNumber;
  private String password;
  private List<Reservation> reservations;

  public User(String idType, String idNumber, String firstName, String lastName, String email, String homeAddress,
      String cityResidence, String contactNumber, String password) {
    this.idType = idType;
    this.idNumber = idNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.homeAddress = homeAddress;
    this.cityResidence = cityResidence;
    this.contactNumber = contactNumber;
    this.password = password;
    this.reservations = new ArrayList<>();
  }

  public String getIdType() {
    return idType;
  }

  public void setIdType(String idType) {
    this.idType = idType;
  }

  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(String homeAddress) {
    this.homeAddress = homeAddress;
  }

  public String getCityResidence() {
    return cityResidence;
  }

  public void setCityResidence(String cityResidence) {
    this.cityResidence = cityResidence;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }

  public void addReservation(Reservation reservation) {
    reservations.add(reservation);
  }

  public void removeReservation(Reservation reservation) {
    reservations.remove(reservation);
  }
}
