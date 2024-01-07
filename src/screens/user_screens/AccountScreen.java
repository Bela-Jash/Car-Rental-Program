package screens.user_screens;

import screen_managers.UserScreenManager;
import utility.Console;

public class AccountScreen {
    private final UserScreenManager userScreenManager;

    public AccountScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > User Main Menu > Modify Account");
        System.out.println("What would you like to do?");
        System.out.println("1) Change your name");
        System.out.println("2) Change your phone number");
        System.out.println("3) Change your email address");
        System.out.println("4) Change your password");
        System.out.println("5) Delete your account");
        System.out.println("6) Go back");

        int modifyAccountChoice = (int) Console.readNumber("Choice", 1, 6);

        switch (modifyAccountChoice) {
            case 1: userScreenManager.switchScreen("ChangeNameScreen"); break;
            case 2: userScreenManager.switchScreen("ChangePhoneNumberScreen"); break;
            case 3: userScreenManager.switchScreen("ChangeEmailScreen"); break;
            case 4: userScreenManager.switchScreen("ChangePasswordScreen"); break;
            case 5: userScreenManager.switchScreen("DeleteAccountScreen"); break;
            case 6: userScreenManager.switchScreen("UserScreen"); break;
        }
    }
}
