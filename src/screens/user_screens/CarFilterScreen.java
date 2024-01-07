package screens.user_screens;

import screen_managers.UserScreenManager;
import utility.Console;

public class CarFilterScreen {
    private final UserScreenManager userScreenManager;

    public CarFilterScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > User Main Menu > List Cars with Filter");
        System.out.println("Which filter do you choose?");
        System.out.println("1) Brand");
        System.out.println("2) Type");
        System.out.println("3) Year");
        System.out.println("4) Go back");

        int carFilterChoice = (int) Console.readNumber("Choice", 1, 4);

        switch (carFilterChoice) {
            case 1: userScreenManager.switchScreen("CarBrandScreen");break;
            case 2: userScreenManager.switchScreen("CarTypeScreen"); break;
            case 3: userScreenManager.switchScreen("CarYearScreen"); break;
            case 4: userScreenManager.switchScreen("UserScreen"); break;
        }

    }
}
