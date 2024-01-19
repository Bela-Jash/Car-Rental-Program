package screens.user_screens;

import screen_managers.UserScreenManager;
import screen_managers.UserScreenManagerImplementer;
import services.CarService;
import utility.Console;
import utility.Patterns;

public class SearchCarScreen {
    private final CarService carService = new CarService();
    private final UserScreenManager userScreenManager;

    public SearchCarScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > User Main Menu > Search Car");
        String key = Console.readText("Enter the car's ID number, brand, model, type, year, or color", Patterns.noPattern, "Too few or too many characters. Please try again.");
        System.out.println("Here are the cars with properties that match the term \"" + key + "\":");
        System.out.println("(If you don't see any car, that means there are none with that property.)");

        carService.searchCar(key);

        Console.continueOnEnter();
        userScreenManager.switchScreen("UserScreen");
    }
}
