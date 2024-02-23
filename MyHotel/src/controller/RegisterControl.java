package controller;

import java.util.ArrayList;
import java.util.List;
import model.User;

public class RegisterControl {
  private static List<User> registeredUsers = new ArrayList<>();

  public static void registerUser(User user) {
    registeredUsers.add(user);
  }

  public static List<User> getRegisteredUsers() {
    return registeredUsers;
  }

  public User getCurrentUsers() {
    for (User user : registeredUsers) {
      return user;
    }
    return null; // Add a return statement outside of the for loop to ensure that the method
                 // always returns a User object.
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
