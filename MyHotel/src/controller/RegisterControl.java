package controller;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class RegisterControl {
  private static List<User> registeredUsers = new ArrayList<>();

  public static void registerUser(User user) {
    registeredUsers.add(user);
  }

  public static List<User> getRegisteredUsers() {
    return registeredUsers;
  }

  public static boolean isUserRegistered(String email) {
    for (User user : registeredUsers) {
      if (user.getEmail().equals(email)) {
        return true;
      }
    }
    return false;
  }
}
