package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import services.CarService;
import utility.Console;
import utility.Patterns;

import java.time.LocalDate;

public class AddCarScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final CarService carService = new CarService();

    public AddCarScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Manage Cars > Add Car");
        String brand = Console.readText("Enter the brand: ", Patterns.carBrandPattern, "Invalid format or too few or too many characters. Please try again.");
        String model = Console.readText("Enter the model: ", Patterns.carModelPattern, "Invalid format or too few or too many characters. Please try again.");
        String type = Console.readText("Enter the type: ", Patterns.carTypePattern, "Invalid format or too few or too many characters. Please try again.");
        String color = Console.readText("Enter the color: ", Patterns.carColorPattern, "Invalid format or too few or too many characters. Please try again.");
        int year = (int) Console.readNumber("Enter the year: ", 1900, LocalDate.now().getYear());
        int quantityAvailable = (int) Console.readNumber("Enter the quantity available: ", 0, 999);
        double baseRate = Console.readNumber("Enter the base rate: ", 1, 10_000_000);

        carService.addCar(brand, model, type, color, year, quantityAvailable, baseRate);

        System.out.println("Car added successfully.");
        Console.continueOnEnter();
        ownerScreenManager.switchScreen("ManageCarsScreen");
    }
}
