package screens.user_screens;

import screen_managers.UserScreenManager;
import services.UserService;
import utility.Console;
import utility.Patterns;

public class ChangeNameScreen {
    private final UserService userService = new UserService();
    private final UserScreenManager userScreenManager;

    public ChangeNameScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Modify Account > Name");
        System.out.println("Your previous name is: " + userService.getLoggedInUser().getName() + ".");
        String newName = Console.readText("Enter your new full name", Patterns.namePattern, "Please enter your full name with the correct format (e.g. John Doe).");
        while (true) {
            String password = Console.readText("Enter your password", Patterns.noPattern, "Too few or too many characters. Please try again.");
            if (password.equals(userService.getLoggedInUser().getPassword())) {
                userService.getLoggedInUser().setName(newName);
                // ToDo: Write updated user into file, and update loggedInUser.txt
                break;
            }
            System.out.println("Incorrect password. Please try again.");
        }
        System.out.println("You have changed your name successfully, " + newName + ".");
        Console.continueOnEnter();
        userScreenManager.switchScreen("AccountScreen");
    }
}
