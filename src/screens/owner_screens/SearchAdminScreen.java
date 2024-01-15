package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import services.OwnerService;
import utility.Console;
import utility.Patterns;

public class SearchAdminScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final OwnerService ownerService = new OwnerService();

    public SearchAdminScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Manage Admins > Search Admin");
        String key = Console.readText("Enter the admin's ID number, name, phone number, or email", Patterns.noPattern, "Too many characters. Please try again.");
        System.out.println("Here are the admins with properties that match the term term \"" + key + "\":");
        System.out.println("(If you don't see any admin, that means there are none with that information.)");

        ownerService.searchAdmin(key);

        Console.continueOnEnter();
        ownerScreenManager.switchScreen("ManageAdminsScreen");
    }
}
