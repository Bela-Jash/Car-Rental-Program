package screens.owner_screens;

import models.Owner;
import screen_managers.OwnerScreenManager;
import utility.Console;
import utility.Patterns;

import java.util.regex.Pattern;

public class CompanyNameScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final Owner owner = new Owner();

    public CompanyNameScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("Welcome Screen > Owner Main Menu > Change Company Name");
        System.out.println("Your previous company name is \"" + owner.getCompanyName() + "\".");
        String newCompanyName = Console.readText("Enter the new name of the company", Patterns.noPattern, "Too many characters. Please try again.");
        System.out.println("Your company name will henceforth be \"" + newCompanyName + "\".");
        System.out.println("Are you sure you want to change it to that?");
        String choice = Console.readText("Choice (Y/N)", Pattern.compile("[YyNn]"), "Invalid choice. Please try again.");
        if (choice.equalsIgnoreCase("y")) {
            owner.setCompanyName(newCompanyName);
            System.out.println("Your company's name has been successfully changed to \"" + newCompanyName + "\".");
        }
        else {
            System.out.println("You have chosen not to change your company's name.");
        }

        Console.continueOnEnter();
        ownerScreenManager.switchScreen("OwnerScreen");
    }
}
