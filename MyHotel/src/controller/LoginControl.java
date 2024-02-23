package controller;

import model.User;
import java.util.List;

public class LoginControl {
  private static List<User> registeredUsers = RegisterControl.getRegisteredUsers();

  public static boolean login(String email, String password) {
    for (User user : registeredUsers) {
      if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
        return true;
      }
    }
    return false;
  }
}
