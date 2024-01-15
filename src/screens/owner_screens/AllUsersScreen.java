package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import services.OwnerService;
import utility.Console;

public class AllUsersScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final OwnerService ownerService = new OwnerService();

    public AllUsersScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Manage Users > All Users");
        System.out.println("How would you like to sort them?");
        System.out.println("1) By ID number (ascending)");
        System.out.println("2) By ID number (descending)");
        System.out.println("3) By name (ascending)");
        System.out.println("4) By name (descending)");

        int listSortedUsersChoice = (int) Console.readNumber("Choice", 1, 4);

        switch (listSortedUsersChoice) {
            case 1: ownerService.listAllUsersAscending("id"); break;
            case 2: ownerService.listAllUsersDescending("id"); break;
            case 3: ownerService.listAllUsersAscending("name"); break;
            case 4: ownerService.listAllUsersDescending("name"); break;
        }

        Console.continueOnEnter();
        ownerScreenManager.switchScreen("ManageUsersScreen");
    }
}
