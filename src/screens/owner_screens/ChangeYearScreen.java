package screens.owner_screens;

import models.Car;
import screen_managers.OwnerScreenManager;
import utility.Console;
import utility.Patterns;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ChangeYearScreen {
    private final OwnerScreenManager ownerScreenManager;

    public ChangeYearScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Modify Car > Year");
        Car car = new Car();
        // ToDo: Fetch car id from CarToBeModified.txt or something, and assign it to car
        System.out.println("The previous year is: " + car.getYear() + ".");
        int newYear = (int) Console.readNumber("Enter the new year", 1900, LocalDate.now().getYear());
        System.out.println("The year of this car will henceforth be: " + newYear + ".");
        System.out.println("Are you sure you want to change it to that?");
        String choice = Console.readText("Choice (Y/N)", Pattern.compile("[YyNn]"), "Invalid choice. Please try again.");
        if (choice.equalsIgnoreCase("y")) {
            car.setYear(newYear);
            // ToDo: Update the file containing this specific car
            System.out.println("The year has been successfully changed to \"" + newYear + "\".");
        } else {
            System.out.println("You have chosen not to change the year.");
        }

        Console.continueOnEnter();
        ownerScreenManager.switchScreen("ModifyCarScreen");
    }
}
