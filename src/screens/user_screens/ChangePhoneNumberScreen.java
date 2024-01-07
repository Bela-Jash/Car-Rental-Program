package screens.user_screens;

import screen_managers.UserScreenManager;
import services.UserService;
import utility.Console;
import utility.Patterns;

public class ChangePhoneNumberScreen {
    private final UserService userService = new UserService();
    private final UserScreenManager userScreenManager;

    public ChangePhoneNumberScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Modify Account > Phone Number");
        System.out.println("Your previous phone number is: " + userService.getLoggedInUser().getPhoneNumber() + ".");
        String newPhoneNumber = Console.readText("Enter your new phone number", Patterns.phoneNumberPattern, "Please enter your phone number with the correct format (09/07xxxxxxxx).");
        while (true) {
            String password = Console.readText("Enter your password", Patterns.noPattern, "Too many characters. Please try again.");
            if (password.equals(userService.getLoggedInUser().getPassword())) {
                userService.getLoggedInUser().setPhoneNumber(newPhoneNumber);
                // ToDo: Write updated user into file, and update loggedInUser.txt
                break;
            }
            System.out.println("Incorrect password. Please try again.");
        }
        System.out.println("You have changed your phone number successfully.");
        Console.continueOnEnter();
        userScreenManager.switchScreen("AccountScreen");
    }
}
