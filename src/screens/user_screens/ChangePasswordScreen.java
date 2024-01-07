package screens.user_screens;

import screen_managers.UserScreenManager;
import services.UserService;
import utility.Console;
import utility.Patterns;

import java.util.regex.Pattern;

public class ChangePasswordScreen {
    private final UserService userService = new UserService();
    private final UserScreenManager userScreenManager;

    public ChangePasswordScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Modify Account > Password");
        Console.readText("Enter your previous password", Pattern.compile(userService.getLoggedInUser().getPassword()), "Incorrect password. Please try again.");
        String newPassword = Console.readText("Enter your new password", Patterns.passwordPattern, "Your password should contain only the English alphabet letters, numbers, and/or symbols, and should be from 8 to 25 characters long.");
        Console.readText("Confirm your new password", Pattern.compile(newPassword), "The confirmed password doesn't match the original one. Please try again.");
        userService.getLoggedInUser().setPassword(newPassword);
        // ToDo: Write updated user into file, and update loggedInUser.txt
        System.out.println("You have changed your password successfully.");
        Console.continueOnEnter();
        userScreenManager.switchScreen("AccountScreen");
    }
}
