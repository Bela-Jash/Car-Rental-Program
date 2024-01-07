package screens.user_screens;

import screen_managers.UserScreenManager;
import services.CarService;
import utility.Console;

public class AllCarsScreen {
    private final UserScreenManager userScreenManager;
    private final CarService carService = new CarService();

    public AllCarsScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > User Main Menu > List All Cars");
        carService.listAllCars();
        Console.continueOnEnter();
        userScreenManager.switchScreen("UserScreen");
    }
}
