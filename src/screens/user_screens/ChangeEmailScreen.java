package screens.user_screens;

import screen_managers.UserScreenManager;
import services.UserService;
import utility.Console;
import utility.Patterns;

public class ChangeEmailScreen {
    private final UserService userService = new UserService();
    private final UserScreenManager userScreenManager;

    public ChangeEmailScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Modify Account > Email Address");
        System.out.println("Your previous email address is: " + userService.getLoggedInUser().getEmail() + ".");
        String newEmail = Console.readText("Enter your new email address", Patterns.emailPattern, "Please enter your email address with the correct format (e.g. janedoe123@gmail.com).");
        while (true) {
            String password = Console.readText("Enter your password", Patterns.noPattern, "Too few or too many characters. Please try again.");
            if (password.equals(userService.getLoggedInUser().getPassword())) {
                userService.getLoggedInUser().setEmail(newEmail);
                // ToDo: Write updated user into file, and update loggedInUser.txt
                break;
            }
            System.out.println("Incorrect password. Please try again.");
        }
        System.out.println("You have changed your email address successfully.");
        Console.continueOnEnter();
        userScreenManager.switchScreen("AccountScreen");
    }
}
