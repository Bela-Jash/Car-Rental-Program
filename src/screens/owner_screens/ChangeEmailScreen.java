package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import services.OwnerService;
import utility.Console;
import utility.Patterns;

public class ChangeEmailScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final OwnerService ownerService = new OwnerService();

    public ChangeEmailScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Modify Account > Email Address");
        System.out.println("Your previous email address is: " + ownerService.getOwner().getEmail() + ".");
        String newEmail = Console.readText("Enter your new email address", Patterns.emailPattern, "Please enter your email address with the correct format (e.g. janedoe123@gmail.com).");
        while (true) {
            String password = Console.readText("Enter your password", Patterns.noPattern, "Too many characters. Please try again.");
            if (password.equals(ownerService.getOwner().getPassword())) {
                ownerService.getOwner().setEmail(newEmail);
                // ToDo: Write updated owner into file
                break;
            }
            System.out.println("Incorrect password. Please try again.");
        }
        System.out.println("You have changed your email address successfully.");
        Console.continueOnEnter();
        ownerScreenManager.switchScreen("AccountScreen");
    }
}
