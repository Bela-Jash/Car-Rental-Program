package screens.user_screens;

import screen_managers.UserScreenManager;
import utility.Console;

import java.util.regex.Pattern;

public class DeleteAccountScreen {
    private final UserScreenManager userScreenManager;

    public DeleteAccountScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Modify Account > Delete Account");
        System.out.println("This action cannot be undone! Are you sure you want to delete your account?");
        String choice = Console.readText("Choice (Y/N)", Pattern.compile("[YyNn]"), "Invalid choice. Please try again.");
        if (choice.equalsIgnoreCase("y")) {
            // ToDo: Delete account, and update files
            System.out.println("Account deleted successfully. You can sign up again any time.");
            Console.continueOnEnter();
            userScreenManager.switchScreen("WelcomeScreen");
        } else {
            System.out.println("You have chosen not to delete your account.");
            Console.continueOnEnter();
            userScreenManager.switchScreen("AccountScreen");
        }

    }
}
