package screens.owner_screens;

import models.Car;
import screen_managers.OwnerScreenManager;
import utility.Console;
import utility.Patterns;

import java.util.regex.Pattern;

public class ChangeTypeScreen {
    private final OwnerScreenManager ownerScreenManager;

    public ChangeTypeScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Modify Car > Type");
        Car car = new Car();
        // ToDo: Fetch car id from CarToBeModified.txt or something, and assign it to car
        System.out.println("The previous type is: " + car.getType() + ".");
        String newType = Console.readText("Enter the new type", Patterns.carTypePattern, "Invalid format or too many characters. Please try again.");
        System.out.println("The type of this car will henceforth be: " + newType + ".");
        System.out.println("Are you sure you want to change it to that?");
        String choice = Console.readText("Choice (Y/N)", Pattern.compile("[YyNn]"), "Invalid choice. Please try again.");
        if (choice.equalsIgnoreCase("y")) {
            car.setType(newType);
            // ToDo: Update the file containing this specific car
            System.out.println("The type has been successfully changed to \"" + newType + "\".");
        }
        else {
            System.out.println("You have chosen not to change the type.");
        }

        Console.continueOnEnter();
        ownerScreenManager.switchScreen("ModifyCarScreen");
    }
}
