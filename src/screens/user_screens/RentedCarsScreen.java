package screens.user_screens;

import screen_managers.UserScreenManager;
import screen_managers.UserScreenManagerImplementer;
import services.UserService;
import utility.Console;

public class RentedCarsScreen {
    private final UserService userService = new UserService();
    private final UserScreenManager userScreenManager;

    public RentedCarsScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > User Main Menu > List Rented Cars");
        System.out.println("Here are the cars you're currently renting:");
        System.out.println("(If you don't see any car, that means there are none you have rented.)");

        userService.listRentedCars();

        Console.continueOnEnter();
        userScreenManager.switchScreen("UserScreen");
    }
}
