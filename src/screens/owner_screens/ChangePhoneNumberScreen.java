package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import services.OwnerService;
import utility.Console;
import utility.Patterns;

public class ChangePhoneNumberScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final OwnerService ownerService = new OwnerService();

    public ChangePhoneNumberScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Modify Account > Phone Number");
        System.out.println("Your previous phone number is: " + ownerService.getOwner().getPhoneNumber() + ".");
        String newPhoneNumber = Console.readText("Enter your new phone number", Patterns.phoneNumberPattern, "Please enter your phone number with the correct format (09/07xxxxxxxx).");
        while (true) {
            String password = Console.readText("Enter your password", Patterns.noPattern, "Too few or too many characters. Please try again.");
            if (password.equals(ownerService.getOwner().getPassword())) {
                ownerService.getOwner().setPhoneNumber(newPhoneNumber);
                // ToDo: Write updated owner into file
                break;
            }
            System.out.println("Incorrect password. Please try again.");
        }
        System.out.println("You have changed your phone number successfully.");
        Console.continueOnEnter();
        ownerScreenManager.switchScreen("AccountScreen");
    }
}
