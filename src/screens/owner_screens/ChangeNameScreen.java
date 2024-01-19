package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import services.OwnerService;
import utility.Console;
import utility.Patterns;

public class ChangeNameScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final OwnerService ownerService = new OwnerService();

    public ChangeNameScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Modify Account > Name");
        System.out.println("Your previous name is: " + ownerService.getOwner().getName() + ".");
        String newName = Console.readText("Enter your new full name", Patterns.namePattern, "Please enter your full name with the correct format (e.g. John Doe).");
        while (true) {
            String password = Console.readText("Enter your password", Patterns.noPattern, "Too few or too many characters. Please try again.");
            if (password.equals(ownerService.getOwner().getPassword())) {
                ownerService.getOwner().setName(newName);
                // ToDo: Write updated owner into file
                break;
            }
            System.out.println("Incorrect password. Please try again.");
        }
        System.out.println("You have changed your name successfully, " + newName + ".");
        Console.continueOnEnter();
        ownerScreenManager.switchScreen("AccountScreen");
    }
}
