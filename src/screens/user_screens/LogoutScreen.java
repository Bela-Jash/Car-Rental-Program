package screens.user_screens;

import screen_managers.UserScreenManager;
import services.UserService;
import utility.Console;

import java.util.regex.Pattern;

public class LogoutScreen {
    private final UserScreenManager userScreenManager;
    private final UserService userService = new UserService();

    public LogoutScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > User Main Menu > Log Out");
        System.out.println("Are you sure you want to log out?");
        String choice = Console.readText("Choice (Y/N)", Pattern.compile("[YyNn]"), "Invalid choice. Please try again.");
        if (choice.equalsIgnoreCase("y")) {
            userService.logOut();
            Console.continueOnEnter();
            userScreenManager.switchScreen("WelcomeScreen");
        }
        else
            userScreenManager.switchScreen("UserScreen");
    }
}
