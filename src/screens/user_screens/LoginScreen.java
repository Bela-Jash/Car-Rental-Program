package screens.user_screens;

import screen_managers.UserScreenManager;
import services.UserService;
import utility.Console;
import utility.Patterns;

public class LoginScreen {
    private final UserService userService = new UserService();
    private final UserScreenManager userScreenManager;

    public LoginScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("Welcome Screen > Log In");
        System.out.println("Enter your credentials to log in.");
        boolean userIsAuthenticated;
        while (true) {
            String emailOrPhoneNumber = Console.readText("Enter your email or phone number", Patterns.noPattern, "Too few or too many characters. Please try again.");
            String password = Console.readText("Enter your password", Patterns.noPattern, "Too few or too many characters. Please try again.");
            userIsAuthenticated = userService.logIn(emailOrPhoneNumber, password);
            if (userIsAuthenticated) break;
            System.out.println("Your email or phone number, and/or password is incorrect. Please try again.");
        }
        System.out.println("Login successful!");
        Console.continueOnEnter();

        userScreenManager.switchScreen("UserScreen");
    }
}
