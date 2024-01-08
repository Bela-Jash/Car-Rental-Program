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
        System.out.println("How would you like to sort them?");
        System.out.println("1) By ID number (ascending)");
        System.out.println("2) By ID number (descending)");
        System.out.println("3) By brand (ascending)");
        System.out.println("4) By brand (descending)");
        System.out.println("5) By type (ascending)");
        System.out.println("6) By type (descending)");
        System.out.println("7) By year (ascending)");
        System.out.println("8) By year (descending)");
        System.out.println("9) By quantity available (ascending)");
        System.out.println("10) By quantity available (descending)");
        System.out.println("11) By base rate (ascending)");
        System.out.println("12) By base rate (descending)");

        int listSortedCarsChoice = (int) Console.readNumber("Choice", 1, 12);

        switch (listSortedCarsChoice) {
            case 1: carService.listAllCarsAscending("id"); break;
            case 2: carService.listAllCarsDescending("id"); break;
            case 3: carService.listAllCarsAscending("brand"); break;
            case 4: carService.listAllCarsDescending("brand"); break;
            case 5: carService.listAllCarsAscending("type"); break;
            case 6: carService.listAllCarsDescending("type"); break;
            case 7: carService.listAllCarsAscending("year"); break;
            case 8: carService.listAllCarsDescending("year"); break;
            case 9: carService.listAllCarsAscending("quantityAvailable"); break;
            case 10: carService.listAllCarsDescending("quantityAvailable"); break;
            case 11: carService.listAllCarsAscending("baseRate"); break;
            case 12: carService.listAllCarsDescending("baseRate"); break;
        }

        Console.continueOnEnter();
        userScreenManager.switchScreen("UserScreen");
    }
}
