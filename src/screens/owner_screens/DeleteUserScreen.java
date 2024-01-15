package screens.owner_screens;

import models.User;
import screen_managers.OwnerScreenManager;
import services.OwnerService;
import services.UserService;
import utility.Console;

import java.util.regex.Pattern;

public class DeleteUserScreen {
    private final OwnerScreenManager ownerScreenManager;
    private final OwnerService ownerService = new OwnerService();
    private final UserService userService = new UserService();

    public DeleteUserScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > Manage Users > Delete User");
        // ToDo: Adjust the max value of userIDChoice to be the last car id from file
        int userIdChoice = (int) Console.readNumber("Enter the ID number of the user you want to delete", 1, userService.getUsers().size());
        // ToDo: Fetch user from file using userIDChoice (modify the following line)
        User user = userService.getUsers().get(userIdChoice - 1);
        System.out.println("Here's the information of the user you're trying to delete:");
        System.out.println("Name: " + user.getName());
        System.out.println("Phone number: " + user.getPhoneNumber());
        System.out.println("Email: " + user.getEmail());
        System.out.println("This action cannot be undone! Are you sure you want to delete this user account?");
        String choice = Console.readText("Choice (Y/N)", Pattern.compile("[YyNn]"), "Invalid choice. Please try again.");
        if (choice.equalsIgnoreCase("y")) {
            ownerService.deleteUser(user);
            System.out.println("User account deleted successfully.");
        } else {
            System.out.println("You have chosen not to delete the user account.");
        }
        Console.continueOnEnter();
        ownerScreenManager.switchScreen("ManageUsersScreen");
    }
}
