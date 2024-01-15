package screens.user_screens;

import screen_managers.UserScreenManager;
import services.UserService;
import utility.Console;
import utility.Patterns;

import java.util.regex.Pattern;

public class SignupScreen {
    private final UserService userService = new UserService();
    private final UserScreenManager userScreenManager;

    public SignupScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        String name = Console.readText("Enter your full name", Patterns.namePattern, "Please enter your full name with the correct format (e.g. John Doe).");
        String phoneNumber = Console.readText("Enter your phone number", Patterns.phoneNumberPattern, "Please enter your phone number with the correct format (09/07xxxxxxxx).");
        String email = Console.readText("Enter your email address", Patterns.emailPattern, "Please enter your email address with the correct format (e.g. janedoe123@gmail.com).");
        String password = Console.readText("Enter your password", Patterns.passwordPattern, "Your password should contain only the English alphabet letters, numbers, and/or symbols, and should be from 8 to 25 characters long.");
        Console.readText("Confirm your password", Pattern.compile(password), "The confirmed password doesn't match the original one. Please try again.");

        userService.signUp(name, phoneNumber, email, password);

        System.out.println("Signup successful!");

        Console.continueOnEnter();
        userScreenManager.switchScreen("UserScreen");
    }
}
