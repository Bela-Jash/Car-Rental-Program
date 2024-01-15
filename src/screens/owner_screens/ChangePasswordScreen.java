package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import services.OwnerService;
import utility.Console;
import utility.Patterns;

import java.util.regex.Pattern;

public class ChangePasswordScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final OwnerService ownerService = new OwnerService();

    public ChangePasswordScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Modify Account > Password");
        Console.readText("Enter your previous password", Pattern.compile(ownerService.getOwner().getPassword()), "Incorrect password. Please try again.");
        String newPassword = Console.readText("Enter your new password", Patterns.passwordPattern, "Your password should contain only the English alphabet letters, numbers, and/or symbols, and should be from 8 to 25 characters long.");
        Console.readText("Confirm your new password", Pattern.compile(newPassword), "The confirmed password doesn't match the original one. Please try again.");
        ownerService.getOwner().setPassword(newPassword);
        // ToDo: Write updated owner into file
        System.out.println("You have changed your password successfully.");
        Console.continueOnEnter();
        ownerScreenManager.switchScreen("AccountScreen");
    }
}
