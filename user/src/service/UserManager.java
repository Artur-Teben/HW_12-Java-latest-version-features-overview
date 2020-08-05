package service;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private User user;
    static Integer userId = 1;
    private static final Map<Integer, User> users = new HashMap<>();

    public static void addUser(String firstName, String lastName, Integer age, String phoneNumber) {
        users.put(userId++, new User(firstName, lastName, age, phoneNumber));
    }

    public boolean removeUser(Integer userId) {
        user = users.get(userId);
        if (user != null) {
            users.remove(userId);
            return true;
        }
        return false;
    }

    public boolean editUser(Integer userId, String firstName, String lastName, Integer age, String phoneNumber) {
        user = users.get(userId);
        if (user == null) {
            return false;
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setPhoneNumber(phoneNumber);
        return true;
    }

    public void showUsers() {
        if (users.isEmpty()) {
            System.out.println("List of users is empty!");
        }
        users.forEach((key, value) -> System.out.println("ID: " + key + " | " + value));
    }
}
