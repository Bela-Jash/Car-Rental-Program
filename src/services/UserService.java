package services;

import models.Car;
import models.User;
import utility.Console;

import java.time.LocalDate;
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

        System.out.println("Signup successful!");
        Console.continueOnEnter();
    }

    // ====================== Book a Car ======================
    public void bookCar(Car car, int carQuantity, LocalDate startDate, int numberOfRentingDays) {
        /*
        ToDo:
          - User user = getLoggedInUser;
          - Add the car to user.getRentedCars()
          - Add the carQuantity to user.getRentedCarsQuantities()
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
//        displayCarListHeaders();
//        for (Car rentedCar : getLoggedInUser().getRentedCars().keySet())
//            carService.displayCar(rentedCar);
    }

    // ====================== Getters ======================
    public User getLoggedInUser() {
        User user = new User();
        // ToDo: Fetch user from loggedInUser.txt file, and assign it to user
        return user;
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

    public void displayRentedCar(Car car) {
        if (car.getQuantityAvailable() != 0) {
            System.out.printf("%-5s", car.getId());
            System.out.printf("%-20s", car.getBrand());
            System.out.printf("%-20s", car.getModel());
            System.out.printf("%-20s", car.getType());
            System.out.printf("%-20s", car.getColor());
            System.out.printf("%-15s", car.getYear());
            System.out.printf("%-25s", car.getQuantityAvailable());
            System.out.printf("Br. %.2f %n", car.getBaseRate());
        }
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
