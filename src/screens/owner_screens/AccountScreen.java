package screens.owner_screens;

import screen_managers.OwnerScreenManager;
import utility.Console;

public class AccountScreen {
    private final OwnerScreenManager ownerScreenManager;

    public AccountScreen(OwnerScreenManager ownerScreenManager) {
        this.ownerScreenManager = ownerScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("Welcome Screen > Owner Main Menu > Modify Account");
        System.out.println("What would you like to do?");
        System.out.println("1) Change your name");
        System.out.println("2) Change your phone number");
        System.out.println("3) Change your email address");
        System.out.println("4) Change your password");
        System.out.println("5) Go back");

        int modifyAccountChoice = (int) Console.readNumber("Choice", 1, 5);

        switch (modifyAccountChoice) {
            case 1: ownerScreenManager.switchScreen("ChangeNameScreen");
            case 2: ownerScreenManager.switchScreen("ChangePhoneNumberScreen");
            case 3: ownerScreenManager.switchScreen("ChangeEmailScreen");
            case 4: ownerScreenManager.switchScreen("ChangePasswordScreen");
            case 5: break;
        }
    }
}
