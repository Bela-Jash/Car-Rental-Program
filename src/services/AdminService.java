package services;

import models.Admin;
import models.User;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AdminService {
    private final UserService userService = new UserService();

    protected List<Admin> admins = new ArrayList<>();

    protected void initializeAdminsList() {
        // ToDo: Read all admins from file and add them to the admins List
    }

    public List<Admin> getAdmins() {
        initializeAdminsList();
        return admins;
    }

    public void listAllRentedCars() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        displayRentedCarsListHeaders();
        for (User user : userService.getUsers())
            for (int i = 0; i < user.getRentedCars().size(); i++) {
                System.out.printf("%-10s", user.getRentedCars().get(i).getId());
                System.out.printf("%-20s", user.getRentedCars().get(i).getBrand());
                System.out.printf("%-20s", user.getRentedCars().get(i).getModel());
                System.out.printf("%-20s", user.getRentedCarsQuantities().get(i));
                System.out.printf("%-20s", user.getId());
                System.out.printf("Br. %-20s", numberFormat.format(user.getRentedCarsTotalPrices().get(i)));
                System.out.println(user.getRentedCarsEndDates().get(i).format(dateTimeFormatter));
            }
    }

    public void displayRentedCarsListHeaders() {
        System.out.printf("%-10s", "Car ID");
        System.out.printf("%-20s", "Car Brand");
        System.out.printf("%-20s", "Car Model");
        System.out.printf("%-20s", "Quantity");
        System.out.printf("%-20s", "User ID");
        System.out.printf("%-20s", "Total Price");
        System.out.println("Rented Until");
    }
}
