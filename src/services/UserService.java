package services;

import models.Car;
import models.User;
import utility.Console;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    // ====================== Fields ======================
    private final CarService carService = new CarService();
    private UserService userService;
    private List<User> users = new ArrayList<>();

    // ====================== Log In ======================
    public boolean logIn(String emailOrPhoneNumber, String password) {
        // ToDo: Delete the following two lines after implementing file read/write
        User user1 = new User("Abel", "0999999999", "a@b.c", "11111111");
        users.add(user1);
        initializeUsersList();
        for (User user : users)
            if (emailOrPhoneNumber.equals(user.getEmail()) ||
                    emailOrPhoneNumber.equals(user.getPhoneNumber()))
                if (password.equals(user.getPassword())) {
                    saveLoggedInUser(user);
                    return true;
                }
        return false;
    }

    // ====================== Sign Up ======================
    public void signUp(String name, String phoneNumber, String email, String password) {
        User user = new User();

        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        user.setPassword(password);

        saveRegisteredUser(user);
    }

    // ====================== Book a Car ======================
    public void bookCar(Car car, int carQuantity, LocalDate startDate, int numberOfRentingDays) {
        /*
        ToDo:
          - User user = getLoggedInUser;
          - Add the car to user.getRentedCars()
          - Add the carQuantity to user.getRentedCarsQuantities()
          - Add carQuantity * car.getBaseRate() to user.getRentedCarsTotalPrices()
          - Add the endDate to user.getRentedUsersEndDates()
          - Save updated user
          - Decrease the car.getQuantityAvailable() by carQuantity
          - Save updated car
         */
        car.setQuantityAvailable(car.getQuantityAvailable() - carQuantity);

        System.out.println("Car booked successfully.");
    }

    // ====================== List Rented Cars ======================
    public void listRentedCars() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        User user = getLoggedInUser();
        displayRentedCarsListHeaders();
        for (int i = 0; i < user.getRentedCars().size(); i++) {
            System.out.printf("%-5s", user.getRentedCars().get(i).getId());
            System.out.printf("%-20s", user.getRentedCars().get(i).getBrand());
            System.out.printf("%-20s", user.getRentedCars().get(i).getModel());
            System.out.printf("%-20s", user.getRentedCars().get(i).getType());
            System.out.printf("%-20s", user.getRentedCars().get(i).getColor());
            System.out.printf("%-15s", user.getRentedCars().get(i).getYear());
            System.out.printf("%-20s", user.getRentedCarsQuantities().get(i));
            System.out.printf("%-20s", numberFormat.format(user.getRentedCarsTotalPrices().get(i)));
            System.out.println(user.getRentedCarsEndDates().get(i).format(dateTimeFormatter));
        }
    }

    // ====================== Getters ======================
    public User getLoggedInUser() {
        User user = new User();
        // ToDo: Fetch user from loggedInUser.txt file, and assign it to user
        return user;
    }

    public List<User> getUsers() {
        initializeUsersList();
        return users;
    }

    // ====================== Reading ======================

    private void initializeUsersList() {
        // ToDo: Initialize users from files
    }

    // ====================== Writing ======================
    private void saveLoggedInUser(User user) {
        // ToDo: Write logged in user into loggedInUser.txt file
    }

    private void saveRegisteredUser(User user) {
        // ToDo: Add registered user to registeredUsers.txt file
        // ToDo: Write registered user into loggedInUser.txt file
    }

    public void displayRentedCarsListHeaders() {
        System.out.printf("%-5s", "ID");
        System.out.printf("%-20s", "Brand");
        System.out.printf("%-20s", "Model");
        System.out.printf("%-20s", "Type");
        System.out.printf("%-20s", "Color");
        System.out.printf("%-15s", "Year");
        System.out.printf("%-20s", "Quantity");
        System.out.printf("%-20s", "Total Price");
        System.out.println("Rented Until");
    }

    public void checkRentedCars() {
//        List<Car> cars = carService.getCars();
//        for (User user : users) {
//            for (var carDateMap : user.getRentedCars().entrySet())
//                if (carDateMap.getValue().isAfter(LocalDate.now()))
//                    /*
//                    ToDo: Return the rented car to cars List, i.e.,
//                      - add the carQuantity of the rented car to quantityAvailable in cars List
//                      - add the VINs of the rented car to the List of VINs of the car in cars
//                      - remove the car from rentedCars
//                     */
//
//        }
    }
}
