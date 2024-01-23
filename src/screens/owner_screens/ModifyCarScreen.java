package screens.owner_screens;

import models.Car;
import screen_managers.OwnerScreenManager;
import services.CarService;
import utility.Console;

public class ModifyCarScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final CarService carService = new CarService();

    public ModifyCarScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Manage Cars > Modify Car");

        while (true) {
            int carIDChoice = (int) Console.readNumber("Enter the ID number of the car you want to modify", 1, carService.getLastCarId());
            // ToDo (Done): Change the way the specific car is fetched, and the max of carIDChoice
            Car car = carService.fetchCarById(carIDChoice);
            if (car != null) {
                // ToDo (Done): Save carIDChoice to a file so that other screens can access and modify the car
                carService.saveToBeModifiedCarId(carIDChoice);
                break;
            }
            System.out.println("There is no car with an ID number of " + carIDChoice + ". Please try again.");
        }

        System.out.println("What would you like to change about the car?");
        System.out.println("1) Brand");
        System.out.println("2) Model");
        System.out.println("3) Type");
        System.out.println("4) Color");
        System.out.println("5) Year");
        System.out.println("6) Quantity Available");
        System.out.println("7) Base Rate");
        System.out.println("8) Go back");
        int modifyCarChoice = (int) Console.readNumber("Choice", 1, 8);

        switch (modifyCarChoice) {
            case 1: ownerScreenManager.switchScreen("ChangeBrandScreen"); break;
            case 2: ownerScreenManager.switchScreen("ChangeModelScreen"); break;
            case 3: ownerScreenManager.switchScreen("ChangeTypeScreen"); break;
            case 4: ownerScreenManager.switchScreen("ChangeColorScreen"); break;
            case 5: ownerScreenManager.switchScreen("ChangeYearScreen"); break;
            case 6: ownerScreenManager.switchScreen("ChangeQuantityScreen"); break;
            case 7: ownerScreenManager.switchScreen("ChangeBaseRateScreen"); break;
            case 8: ownerScreenManager.switchScreen("ManageCarsScreen"); break;
        }

    }
}
