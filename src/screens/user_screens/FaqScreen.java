package screens.user_screens;

import screen_managers.UserScreenManager;
import utility.Console;

public class FaqScreen {
    private final UserScreenManager userScreenManager;

    public FaqScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println("FAQ");
        Console.continueOnEnter();
    }
}
