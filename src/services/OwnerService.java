package services;

import models.Account;
import models.Admin;
import models.Owner;
import models.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
        for (Admin admin : admins)
            if (key.equalsIgnoreCase(Integer.toString(admin.getId())) ||
                    key.equalsIgnoreCase(admin.getPhoneNumber()) ||
                    key.equalsIgnoreCase(admin.getEmail())
            )
                displayAccount(admin);
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
        for (User user : users)
            if (key.equalsIgnoreCase(Integer.toString(user.getId())) ||
                    key.equalsIgnoreCase(user.getPhoneNumber()) ||
                    key.equalsIgnoreCase(user.getEmail())
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
