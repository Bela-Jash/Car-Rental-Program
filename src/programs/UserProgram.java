package programs;

import screen_managers.UserScreenManager;
import screen_managers.UserScreenManagerImplementer;

public abstract class UserProgram {
    public static void main(String[] args) {
        UserScreenManager manager = new UserScreenManagerImplementer();
        /*
        ToDo: Read loggedInUser.txt, and
              - if it is empty, manager.switchScreen("WelcomeScreen");
              - else, manager.switchScreen("UserScreen")
         */
        manager.switchScreen("WelcomeScreen");
        System.out.println();
        System.out.println("Thank you for using our program. See you soon!");
    }
}