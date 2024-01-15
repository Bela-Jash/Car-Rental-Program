package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import services.OwnerService;
import utility.Console;
import utility.Patterns;

import java.util.regex.Pattern;

public class CreateAdminScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final OwnerService ownerService = new OwnerService();

    public CreateAdminScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Manage Admins > Create Admin");
        System.out.println("Enter the credentials for creating the admin account.");
        String name = Console.readText("Enter their full name", Patterns.namePattern, "Please enter their full name with the correct format (e.g. John Doe).");
        String phoneNumber = Console.readText("Enter their phone number", Patterns.phoneNumberPattern, "Please enter their phone number with the correct format (09/07xxxxxxxx).");
        String email = Console.readText("Enter their email address", Patterns.emailPattern, "Please enter their email address with the correct format (e.g. janedoe123@gmail.com).");
        String password = Console.readText("Enter their password", Patterns.passwordPattern, "The password should contain only the English alphabet letters, numbers, and/or symbols, and should be from 8 to 25 characters long.");
        Console.readText("Confirm their password", Pattern.compile(password), "The confirmed password doesn't match the original one. Please try again.");

        ownerService.createAdmin(name, phoneNumber, email, password);

        System.out.println("Admin successfully created.");

        Console.continueOnEnter();
        ownerScreenManager.switchScreen("ManageAdminsScreen");
    }
}
