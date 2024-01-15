package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import services.CarService;
import utility.Console;
import utility.Patterns;

public class SearchCarScreen {
    private final CarService carService = new CarService();
    private final OwnerScreenManager ownerScreenManager;

    public SearchCarScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Manage Cars > Search Car");
        String key = Console.readText("Enter the car's ID number, brand, model, type, year, or color", Patterns.noPattern, "Too many characters. Please try again.");
        System.out.println("Here are the cars with properties that match the term \"" + key + "\":");
        System.out.println("(If you don't see any car, that means there are none with that property.)");

        carService.searchCar(key);

        Console.continueOnEnter();
        ownerScreenManager.switchScreen("ManageCarsScreen");
    }
}
