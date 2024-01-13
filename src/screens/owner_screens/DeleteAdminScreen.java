package screens.owner_screens;

import models.Admin;
import screen_managers.OwnerScreenManager;
import services.OwnerService;
import utility.Console;

import java.util.regex.Pattern;

public class DeleteAdminScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final OwnerService ownerService = new OwnerService();

    public DeleteAdminScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Manage Admins > Delete Admin");
        int adminIdChoice = (int) Console.readNumber("Enter the ID number of the admin you want to delete", 1, ownerService.getAdmins().size());
        // ToDo: Change the way the specific admin is fetched, and the max of adminIDChoice
        Admin admin = ownerService.getAdmins().get(adminIdChoice - 1);
        System.out.println("Here's the information of the admin you're trying to delete:");
        System.out.println("Name: " + admin.getName());
        System.out.println("Phone number: " + admin.getPhoneNumber());
        System.out.println("Email: " + admin.getEmail());
        System.out.println("This action cannot be undone! Are you sure you want to delete this admin account?");
        String choice = Console.readText("Choice (Y/N)", Pattern.compile("[YyNn]"), "Invalid choice. Please try again.");
        if (choice.equalsIgnoreCase("y")) {
            ownerService.deleteAdmin(admin);
            System.out.println("Admin account deleted successfully.");
        } else {
            System.out.println("You have chosen not to delete the admin account.");
        }
        Console.continueOnEnter();
        ownerScreenManager.switchScreen("ManageAdminsScreen");
    }
}
