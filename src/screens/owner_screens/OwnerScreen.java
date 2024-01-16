package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import services.OwnerService;
import utility.Console;

import java.time.LocalDateTime;

public class OwnerScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final OwnerService ownerService = new OwnerService();

    public OwnerScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("Welcome Screen > Owner Main Menu");
        int currentHour = LocalDateTime.now().getHour();
        if (currentHour >= 6 && currentHour < 12)
            System.out.print("Good morning, ");
        else if (currentHour >= 12 && currentHour < 18)
            System.out.print("Good afternoon, ");
        else
            System.out.print("Good evening, ");
        System.out.println(ownerService.getOwner().getName() + ".");
        System.out.println("What would you like to do?");
        System.out.println("1) Change company name");
        System.out.println("2) Manage admin accounts");
        System.out.println("3) Manage user accounts");
        System.out.println("4) Manage cars");
        System.out.println("5) Modify your account");
        System.out.println("6) Exit");

        int ownerMainMenuChoice = (int) Console.readNumber("Choice", 1, 5);

        switch (ownerMainMenuChoice) {
            case 1: ownerScreenManager.switchScreen("CompanyNameScreen"); break;
            case 2: ownerScreenManager.switchScreen("ManageAdminsScreen"); break;
            case 3: ownerScreenManager.switchScreen("ManageUsersScreen"); break;
            case 4: ownerScreenManager.switchScreen("ManageCarsScreen"); break;
            case 5: ownerScreenManager.switchScreen("AccountScreen"); break;
            case 6: break;
        }
    }
}
