package screens.owner_screens;

import models.Car;
import screen_managers.OwnerScreenManager;
import services.CarService;
import utility.Console;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ChangeQuantityScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final CarService carService = new CarService();

    public ChangeQuantityScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Modify Car > Quantity Available");

        // ToDo (Done): Fetch car id from CarToBeModified.txt or something, and assign it to car
        int toBeModifiedCarId = carService.fetchToBeModifiedCarId();
        if (toBeModifiedCarId == -1) {
            System.out.println("Could not fetch the ID number of the car to be modified. Please try again.");
        }
        else {
            Car car = carService.fetchCarById(toBeModifiedCarId);

            System.out.println("The previous quantity available is: " + car.getQuantityAvailable() + ".");
            int newQuantityAvailable = (int) Console.readNumber("Enter the new quantity available", 0, 999);
            System.out.println("The quantity available of this car will henceforth be: " + newQuantityAvailable + ".");
            System.out.println("Are you sure you want to change it to that?");
            String choice = Console.readText("Choice (Y/N)", Pattern.compile("[YyNn]"), "Invalid choice. Please try again.");
            if (choice.equalsIgnoreCase("y")) {
                car.setQuantityAvailable(newQuantityAvailable);
                // ToDo: Update the file containing this specific car
                System.out.println("The quantity available has been successfully changed to \"" + newQuantityAvailable + "\".");
            } else {
                System.out.println("You have chosen not to change the quantity available.");
            }
        }
        Console.continueOnEnter();
        ownerScreenManager.switchScreen("ModifyCarScreen");
    }
}
