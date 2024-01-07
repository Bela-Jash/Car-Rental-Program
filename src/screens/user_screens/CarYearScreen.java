package screens.user_screens;

import screen_managers.UserScreenManager;
import services.CarService;
import utility.Console;

public class CarYearScreen {
    private final CarService carService = new CarService();
    private final UserScreenManager userScreenManager;

    public CarYearScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > List with Filter > Year");
        System.out.println("Choose one of these available car years as a filter:");
        carService.listAllCarYears();

        int carYearChoice = (int) Console.readNumber("Choice", 1, carService.getCarYears().size());
        int carYear = carService.getCarYears().get(carYearChoice - 1);

        carService.listCarsByYear(carYear);

        Console.continueOnEnter();
        userScreenManager.switchScreen("UserScreen");
    }
}
