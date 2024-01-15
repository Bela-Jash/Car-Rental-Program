package screens.owner_screens;

import models.Car;
import screen_managers.OwnerScreenManager;
import utility.Console;
import utility.Patterns;

import java.util.regex.Pattern;

public class ChangeColorScreen {
    private final OwnerScreenManager ownerScreenManager;

    public ChangeColorScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Modify Car > Color");
        Car car = new Car();
        // ToDo: Fetch car id from CarToBeModified.txt or something, and assign it to car
        System.out.println("The previous color is: " + car.getColor() + ".");
        String newColor = Console.readText("Enter the new color", Patterns.carColorPattern, "Invalid format or too many characters. Please try again.");
        System.out.println("The color of this car will henceforth be: " + newColor + ".");
        System.out.println("Are you sure you want to change it to that?");
        String choice = Console.readText("Choice (Y/N)", Pattern.compile("[YyNn]"), "Invalid choice. Please try again.");
        if (choice.equalsIgnoreCase("y")) {
            car.setColor(newColor);
            // ToDo: Update the file containing this specific car
            System.out.println("The color has been successfully changed to \"" + newColor + "\".");
        }
        else {
            System.out.println("You have chosen not to change the color.");
        }

        Console.continueOnEnter();
        ownerScreenManager.switchScreen("ModifyCarScreen");
    }
}
