package screens.user_screens;

import screen_managers.UserScreenManager;
import services.CarService;
import utility.Console;

public class CarBrandScreen {
    private final UserScreenManager userScreenManager;
    private final CarService carService = new CarService();

    public CarBrandScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > List with Filter > Brand");
        System.out.println("Choose one of these available car brands as a filter:");
        carService.listAllCarBrands();

        int carBrandChoice = (int) Console.readNumber("Choice", 1, carService.getCarBrands().size());
        String carBrand = carService.getCarBrands().get(carBrandChoice - 1);

        carService.listCarsByBrand(carBrand);

        Console.continueOnEnter();
        userScreenManager.switchScreen("UserScreen");
    }
}
