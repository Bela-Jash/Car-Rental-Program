package services;

import models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.System.exit;

public class OwnerService extends AdminService {
    private Owner owner;
    private UserService userService = new UserService();
    public boolean logIn(String emailOrPhoneNumber, String password) {
        fetchOwnerCredentials();
        return (emailOrPhoneNumber.equals(owner.getEmail()) ||
                emailOrPhoneNumber.equals(owner.getPhoneNumber())) &&
                password.equals(owner.getPassword());
    }

    private void fetchOwnerCredentials() {
        // ToDo: Fetch owner credentials from file, and assign it to the field owner
    }

    public Owner getOwner() {
        fetchOwnerCredentials();
        return owner;
    }

    public void listAllAdminsAscending(String sortBy) {
        initializeAdminsList();
        List<Admin> sortedAdmins = new ArrayList<>();
        switch (sortBy) {
            case "id" ->
                    sortedAdmins = admins.stream().sorted(Comparator.comparing(Admin::getId)).collect(Collectors.toList());
            case "name" ->
                    sortedAdmins = admins.stream().sorted(Comparator.comparing(Admin::getName).thenComparing(Admin::getId)).collect(Collectors.toList());
            default -> {
                System.out.println("Invalid sorting choice. Please contact the company about it.");
                exit(1);
            }
        }
        displayAccountListHeaders();
        for (Admin admin : sortedAdmins)
            displayAccount(admin);
    }

    public void listAllAdminsDescending(String sortBy) {
        initializeAdminsList();
        List<Admin> sortedAdmins = new ArrayList<>();
        switch (sortBy) {
            case "id" ->
                    sortedAdmins = admins.stream().sorted(Comparator.comparing(Admin::getId).reversed()).collect(Collectors.toList());
            case "name" ->
                    sortedAdmins = admins.stream().sorted(Comparator.comparing(Admin::getName).thenComparing(Admin::getId).reversed()).collect(Collectors.toList());
            default -> {
                System.out.println("Invalid sorting choice. Please contact the company about it.");
                exit(1);
            }
        }
        displayAccountListHeaders();
        for (Admin admin : sortedAdmins)
            displayAccount(admin);
    }

    public void searchAdmin(String key) {
        initializeAdminsList();
        displayAccountListHeaders();
        Pattern pattern = Pattern.compile(key.toLowerCase());
        for (Admin admin : admins)
            if (pattern.matcher(Integer.toString(admin.getId())).find() ||
                    pattern.matcher(admin.getName().toLowerCase()).find() ||
                    pattern.matcher(admin.getPhoneNumber().toLowerCase()).find() ||
                    pattern.matcher(admin.getEmail().toLowerCase()).find()
            )
                displayAccount(admin);
    }

    public void createAdmin(String name, String phoneNumber, String email, String password) {
        Admin admin = new Admin();

        admin.setName(name);
        admin.setPhoneNumber(phoneNumber);
        admin.setEmail(email);
        admin.setPassword(password);

        saveRegisteredAdmin(admin);
    }

    public void deleteAdmin(Admin admin) {
        // ToDo: Delete admin account, and update files
    }

    public void deleteUser(User user) {
        // ToDo: Delete user account, and update files
    }

    private void saveRegisteredAdmin(Admin admin) {
        // ToDo: Write registered admin into file
    }

    public void listAllUsersAscending(String sortBy) {
        List<User> users = userService.getUsers();
        List<User> sortedUsers = new ArrayList<>();
        switch (sortBy) {
            case "id" ->
                    sortedUsers = users.stream().sorted(Comparator.comparing(User::getId).reversed()).collect(Collectors.toList());
            case "name" ->
                    sortedUsers = users.stream().sorted(Comparator.comparing(User::getName).thenComparing(User::getId).reversed()).collect(Collectors.toList());
            default -> {
                System.out.println("Invalid sorting choice. Please contact the company about it.");
                exit(1);
            }
        }

        displayAccountListHeaders();
        for (User user : sortedUsers)
            displayAccount(user);
    }

    public void listAllUsersDescending(String sortBy) {
        List<User> users = userService.getUsers();
        List<User> sortedUsers = new ArrayList<>();
        switch (sortBy) {
            case "id" ->
                    sortedUsers = users.stream().sorted(Comparator.comparing(User::getId).reversed()).collect(Collectors.toList());
            case "name" ->
                    sortedUsers = users.stream().sorted(Comparator.comparing(User::getName).thenComparing(User::getId).reversed()).collect(Collectors.toList());
            default -> {
                System.out.println("Invalid sorting choice. Please contact the company about it.");
                exit(1);
            }
        }

        displayAccountListHeaders();
        for (User user : sortedUsers)
            displayAccount(user);
    }

    public void searchUser(String key) {
        List<User> users = userService.getUsers();
        displayAccountListHeaders();
        Pattern pattern = Pattern.compile(key.toLowerCase());
        for (User user : users)
            if (pattern.matcher(Integer.toString(user.getId())).find() ||
                    pattern.matcher(user.getName().toLowerCase()).find() ||
                    pattern.matcher(user.getPhoneNumber().toLowerCase()).find() ||
                    pattern.matcher(user.getEmail().toLowerCase()).find()
            )
                displayAccount(user);
    }

    private void displayAccountListHeaders() {
        System.out.printf("%-5s", "ID");
        System.out.printf("%-30s", "Name");
        System.out.printf("%-20s", "Phone Number");
        System.out.println( "Email");
    }

    private void displayAccount(Account account) {
        System.out.printf("%-5s", account.getId());
        System.out.printf("%-30s", account.getName());
        System.out.printf("%-20s", account.getPhoneNumber());
        System.out.println(account.getEmail());
    }
}
