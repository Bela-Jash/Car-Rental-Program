package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import utility.Console;

public class ManageCarsScreen {
    private final OwnerScreenManager ownerScreenManager;

    public ManageCarsScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("Welcome Screen > Owner Main Menu > Manage Cars");
        System.out.println("What would you like to do?");
        System.out.println("1) List all cars");
        System.out.println("2) List all rented cars");
        System.out.println("3) Search for a car");
        System.out.println("4) Add a car");
        System.out.println("5) Modify a car");
        System.out.println("6) Delete a car");
        System.out.println("7) Go back");

        int manageCarsChoice = (int) Console.readNumber("Choice", 1, 7);

        switch (manageCarsChoice) {
            case 1: ownerScreenManager.switchScreen("AllCarsScreen"); break;
            case 2: ownerScreenManager.switchScreen("AllRentedCarsScreen"); break;
            case 3: ownerScreenManager.switchScreen("SearchCarScreen"); break;
            case 4: ownerScreenManager.switchScreen("AddCarScreen"); break;
            case 5: ownerScreenManager.switchScreen("ModifyCarScreen"); break;
            case 6: ownerScreenManager.switchScreen("DeleteCarScreen"); break;
            case 7: ownerScreenManager.switchScreen("OwnerScreen"); break;
        }
    }
}
