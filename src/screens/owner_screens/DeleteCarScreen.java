package screens.owner_screens;

import models.Car;
import screen_managers.OwnerScreenManager;
import services.CarService;
import utility.Console;

import java.util.regex.Pattern;

public class DeleteCarScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final CarService carService = new CarService();

    public DeleteCarScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Manage Cars > Delete Car");
        // ToDo: Adjust the max value of carIDChoice to be the last car id from file
        int carIdChoice = (int) Console.readNumber("Enter the ID number of the car you want to delete", 1, carService.getCars().size());
        // ToDo: Fetch car from file using carIDChoice (modify the following line)
        Car car = carService.getCars().get(carIdChoice - 1);
        System.out.println("Here's the information of the car you're trying to delete:");
        System.out.println("Brand: " + car.getBrand());
        System.out.println("Model: " + car.getModel());
        System.out.println("Type: " + car.getType());
        System.out.println("Color: " + car.getColor());
        System.out.println("Year: " + car.getYear());
        System.out.println("Quantity available: " + car.getQuantityAvailable());
        System.out.println("Base Rate: Br. " + car.getBaseRate());
        System.out.println("This action cannot be undone! Are you sure you want to delete this car?");
        String choice = Console.readText("Choice (Y/N)", Pattern.compile("[YyNn]"), "Invalid choice. Please try again.");
        if (choice.equalsIgnoreCase("y")) {
            carService.deleteCar(car);
            System.out.println("Car deleted successfully.");
        } else {
            System.out.println("You have chosen not to delete the car.");
        }

        Console.continueOnEnter();
        ownerScreenManager.switchScreen("ManageCarsScreen");
    }
}
