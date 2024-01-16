package programs;

import screen_managers.OwnerScreenManager;
import screen_managers.OwnerScreenManagerImplementer;

public abstract class OwnerProgram {
    public static void main(String[] args) {
        OwnerScreenManager manager = new OwnerScreenManagerImplementer();
        manager.switchScreen("WelcomeScreen");
        System.out.println();
        System.out.println("Thank you for using this program. See you soon!");
    }
}
