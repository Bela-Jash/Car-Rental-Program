package screens.user_screens;

import models.Owner;
import screen_managers.UserScreenManager;
import screen_managers.UserScreenManagerImplementer;
import utility.Console;

public class WelcomeScreen {
    private final Owner owner = new Owner();
    private final UserScreenManager userScreenManager;

    public WelcomeScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("Welcome to " + owner.getCompanyName() + ".");
        System.out.println("What would you like to do?");
        System.out.println("1) Log in");
        System.out.println("2) Sign up");
        System.out.println("3) FAQ");
        System.out.println("4) Exit");

        int welcomeMenuChoice = (int) Console.readNumber("Choice", 1, 4);

        switch (welcomeMenuChoice) {
            case 1: userScreenManager.switchScreen("LoginScreen"); break;
            case 2: userScreenManager.switchScreen("SignupScreen"); break;
            case 3: userScreenManager.switchScreen("FaqScreen");
                    userScreenManager.switchScreen("WelcomeScreen"); break;
            case 4: break;
        }
    }
}
