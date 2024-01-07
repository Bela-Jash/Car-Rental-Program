package screens.user_screens;

import screen_managers.UserScreenManager;
import services.CarService;
import utility.Console;

public class CarTypeScreen {
    private final CarService carService = new CarService();
    private final UserScreenManager userScreenManager;

    public CarTypeScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > List with Filter > Type");
        System.out.println("Choose one of these available car types as a filter:");
        carService.listAllCarTypes();

        int carTypeChoice = (int) Console.readNumber("Choice", 1, carService.getCarTypes().size());
        String carType = carService.getCarTypes().get(carTypeChoice - 1);

        carService.listCarsByType(carType);

        Console.continueOnEnter();
        userScreenManager.switchScreen("UserScreen");
    }
}
