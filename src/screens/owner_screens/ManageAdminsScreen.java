package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import utility.Console;

public class ManageAdminsScreen {
    private final OwnerScreenManager ownerScreenManager;

    public ManageAdminsScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("Welcome Screen > Owner Main Menu > Manage Admins");
        System.out.println("What would you like to do?");
        System.out.println("1) List all admins");
        System.out.println("2) Search for an admin");
        System.out.println("3) Create an admin account");
        System.out.println("4) Delete an admin account");
        System.out.println("5) Go back");

        int manageAdminsChoice = (int) Console.readNumber("Choice", 1, 5);

        switch (manageAdminsChoice) {
            case 1: ownerScreenManager.switchScreen("AllAdminsScreen"); break;
            case 2: ownerScreenManager.switchScreen("SearchAdminScreen"); break;
            case 3: ownerScreenManager.switchScreen("CreateAdminScreen"); break;
            case 4: ownerScreenManager.switchScreen("DeleteAdminScreen"); break;
            case 5: ownerScreenManager.switchScreen("OwnerScreen"); break;
        }
    }
}
