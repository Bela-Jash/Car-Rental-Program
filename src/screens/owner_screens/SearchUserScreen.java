package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import services.OwnerService;
import utility.Console;
import utility.Patterns;

public class SearchUserScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final OwnerService ownerService = new OwnerService();

    public SearchUserScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Manage Users > Search User");
        String key = Console.readText("Enter the user's ID number, name, phone number, or email", Patterns.noPattern, "Too few or too many characters. Please try again.");
        System.out.println("Here are the users with properties that match the term term \"" + key + "\":");
        System.out.println("(If you don't see any user, that means there are none with that information.)");

        ownerService.searchUser(key);

        Console.continueOnEnter();
        ownerScreenManager.switchScreen("ManageUsersScreen");
    }
}
