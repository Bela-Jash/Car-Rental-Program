package services;

import models.Admin;
import models.Owner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.exit;

public class OwnerService extends AdminService {
    private Owner owner;
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
        displayAdminListHeaders();
        for (Admin admin : sortedAdmins)
            displayAdmin(admin);
    }

    public void listAllAdminsDescending(String sortBy) {
        initializeAdminsList();
        List<Admin> sortedAdmins = new ArrayList<>();
        switch (sortBy) {
            case "id" ->
                    sortedAdmins = admins.stream().sorted(Comparator.comparing(Admin::getId).reversed()).collect(Collectors.toList());
            case "name" ->
                    sortedAdmins = admins.stream().sorted(Comparator.comparing(Admin::getName).reversed()).collect(Collectors.toList());
            default -> {
                System.out.println("Invalid sorting choice. Please contact the company about it.");
                exit(1);
            }
        }
        displayAdminListHeaders();
        for (Admin admin : sortedAdmins)
            displayAdmin(admin);
    }

    public void searchAdmin(String key) {
        initializeAdminsList();
        displayAdminListHeaders();
        for (Admin admin : admins)
            if (key.equalsIgnoreCase(Integer.toString(admin.getId())) ||
                    key.equalsIgnoreCase(admin.getPhoneNumber()) ||
                    key.equalsIgnoreCase(admin.getEmail())
            )
                displayAdmin(admin);
    }

    private void displayAdminListHeaders() {
        System.out.printf("%-5s", "ID");
        System.out.printf("%-30s", "Name");
        System.out.printf("%-20s", "Phone Number");
        System.out.println( "Email");
    }

    private void displayAdmin(Admin admin) {
        System.out.printf("%-5s", admin.getId());
        System.out.printf("%-30s", admin.getName());
        System.out.printf("%-20s", admin.getPhoneNumber());
        System.out.println(admin.getEmail());
    }
}
