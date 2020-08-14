package view;

import model.User;
import service.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Menu {
    private static final String PAUSE = "Press Enter to continue";
    private final String[] menuItems = {
            "\t\tMENU",
            "1. Show all users",
            "2. Add user",
            "3. Delete user",
            "4. Edit user",
            "0. Exit"
    };
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final UserManager userManager = new UserManager();
    private boolean check = true;

    public void showMenuItems(String[] menu) {
        Arrays.asList(menu).forEach(System.out::println);
    }
    public int enterChoice() {
        showMenuItems(menuItems);
        System.out.print("Enter a number, please: ");
        return Integer.parseInt(inputReader());
    }

    public String inputReader() {
        String input = null;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return input;
    }

    public void pauseConsol() {
        System.out.println(PAUSE);
        inputReader();
    }

    public void show() {
        System.out.println("\t\tLIST OF USERS");
        userManager.showUsers();
        pauseConsol();
        runMenu();
    }

    public void add() {
        System.out.print("First Name: ");
        String inputFirstName = inputReader();
        System.out.print("Last Name: ");
        String inputLastName = inputReader();
        System.out.print("Age: ");
        Integer inputAge = Integer.parseInt(inputReader());
        System.out.print("Phone Number: ");
        String inputPhoneNumber = inputReader();
        userManager.addUser(new User(inputFirstName, inputLastName, inputAge, inputPhoneNumber));
        pauseConsol();
        runMenu();
    }

    public void delete() {
        System.out.print("User ID: ");
        Integer inputUserId = Integer.parseInt(inputReader());
        check = userManager.removeUser(inputUserId);
        if (check) {
            System.out.println("User with ID " + inputUserId + " was removed!");
        } else if (check) {
            System.out.println("There is no user with this ID!");
        }
        pauseConsol();
        runMenu();
    }

    public void edit() {
        System.out.print("User ID: ");
        Integer inputUserId = Integer.parseInt(inputReader());
        System.out.print("New First Name: ");
        String inputFirstName = inputReader();
        System.out.print("New Last Name: ");
        String inputLastName = inputReader();
        System.out.print("New Age: ");
        Integer inputAge = Integer.parseInt(inputReader());
        System.out.print("New Phone Number: ");
        String inputPhoneNumber = inputReader();
        check = userManager.editUser(inputUserId, inputFirstName, inputLastName, inputAge, inputPhoneNumber);
        if (check) {
            System.out.println("User with ID " + inputUserId + " was edited!");
        } else if (check) {
            System.out.println("There is no user with this ID!");
        }
        pauseConsol();
        runMenu();
    }

    public void runMenu() {
        switch (enterChoice()) {
            case 1 -> show();
            case 2 -> add();
            case 3 -> delete();
            case 4 -> edit();
            case 0 -> System.exit(0);
            default -> {
                System.out.println("Wrong input, try one more time");
                runMenu();
            }
        }
    }
}

