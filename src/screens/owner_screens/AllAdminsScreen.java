package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import services.OwnerService;
import utility.Console;

public class AllAdminsScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final OwnerService ownerService = new OwnerService();

    public AllAdminsScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("Owner Main Menu > Manage Admins > All Admins");
        System.out.println("How would you like to sort them?");
        System.out.println("1) By ID number (ascending)");
        System.out.println("2) By ID number (descending)");
        System.out.println("3) By name (ascending)");
        System.out.println("4) By name (descending)");
        System.out.println("5) Go back");
        System.out.println("6) Main menu");

        int listSortedAdminsChoice = (int) Console.readNumber("Choice", 1, 6);

        switch (listSortedAdminsChoice) {
            case 1: ownerService.listAllAdminsAscending("id"); break;
            case 2: ownerService.listAllAdminsDescending("id"); break;
            case 3: ownerService.listAllAdminsAscending("name"); break;
            case 4: ownerService.listAllAdminsDescending("name"); break;
            case 5: ownerScreenManager.switchScreen("ManageAdminsScreen"); break;
            case 6: ownerScreenManager.switchScreen("OwnerScreen"); break;
        }
    }
}
