package screens.owner_screens;

import models.Car;
import screen_managers.OwnerScreenManager;
import utility.Console;
import utility.Patterns;

import java.util.regex.Pattern;

public class ChangeModelScreen {
    private final OwnerScreenManager ownerScreenManager;

    public ChangeModelScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Modify Car > Model");
        Car car = new Car();
        // ToDo: Fetch car id from CarToBeModified.txt or something, and assign it to car
        System.out.println("The previous model is: " + car.getModel() + ".");
        String newModel = Console.readText("Enter the new model", Patterns.carModelPattern, "Invalid format or too many characters. Please try again.");
        System.out.println("The model of this car will henceforth be: " + newModel + ".");
        System.out.println("Are you sure you want to change it to that?");
        String choice = Console.readText("Choice (Y/N)", Pattern.compile("[YyNn]"), "Invalid choice. Please try again.");
        if (choice.equalsIgnoreCase("y")) {
            car.setModel(newModel);
            // ToDo: Update the file containing this specific car
            System.out.println("The model has been successfully changed to \"" + newModel + "\".");
        } else {
            System.out.println("You have chosen not to change the model.");
        }

        Console.continueOnEnter();
        ownerScreenManager.switchScreen("ModifyCarScreen");
    }
}
