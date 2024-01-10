package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import utility.Console;

public class ManageUsersScreen {
    private final OwnerScreenManager ownerScreenManager;

    public ManageUsersScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("Welcome Screen > Owner Main Menu > Manage Users");
        System.out.println("What would you like to do?");
        System.out.println("1) List all users");
        System.out.println("2) Search for a user");
        System.out.println("3) Delete a user");
        System.out.println("4) Go back");

        int manageUsersChoice = (int) Console.readNumber("Choice", 1, 4);

        switch (manageUsersChoice) {
            case 1: ownerScreenManager.switchScreen("AllUsersScreen"); break;
            case 2: ownerScreenManager.switchScreen("SearchUserScreen"); break;
            case 3: ownerScreenManager.switchScreen("DeleteUserScreen"); break;
            case 4: ownerScreenManager.switchScreen("OwnerScreen"); break;
        }
    }
}
