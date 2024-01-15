package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import services.OwnerService;
import utility.Console;

public class AllRentedCarsScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final OwnerService ownerService = new OwnerService();

    public AllRentedCarsScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Manage Cars > List Rented Cars");
        ownerService.listAllRentedCars();

        Console.continueOnEnter();
        ownerScreenManager.switchScreen("ManageCarsScreen");
    }
}
