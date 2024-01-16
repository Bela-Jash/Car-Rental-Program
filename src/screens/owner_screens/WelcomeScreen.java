package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import services.OwnerService;
import utility.Console;
import utility.Patterns;

public class WelcomeScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final OwnerService ownerService = new OwnerService();

    public WelcomeScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("Welcome, owner.");
        System.out.println("Enter your credentials to log in.");
        boolean ownerIsAuthenticated;
        while (true) {
            String emailOrPhoneNumber = Console.readText("Enter your email or phone number", Patterns.noPattern, "Too many characters. Please try again.");
            String password = Console.readText("Enter your password", Patterns.noPattern, "Too many characters. Please try again.");
            ownerIsAuthenticated = ownerService.logIn(emailOrPhoneNumber, password);
            if (ownerIsAuthenticated) break;
            System.out.println("Your email or phone number, and/or password is incorrect. Please try again.");
        }

        System.out.println("Login successful!");
        Console.continueOnEnter();
        ownerScreenManager.switchScreen("OwnerScreen");
    }
}
