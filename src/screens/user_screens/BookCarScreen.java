package screens.user_screens;

import models.Car;
import models.Owner;
import screen_managers.UserScreenManager;
import services.CarService;
import services.UserService;
import utility.Console;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class BookCarScreen {
    private final UserScreenManager userScreenManager;
    private final CarService carService = new CarService();
    private final Owner owner = new Owner();
    private final UserService userService = new UserService();

    public BookCarScreen(UserScreenManager userScreenManager) {
        this.userScreenManager = userScreenManager;
    }

    public void display() {
        System.out.println();
        System.out.println("... > User Main Menu > Book a Car");
        int carId = (int) Console.readNumber("Enter the ID number of the car you want to rent", 1, carService.getCars().size());
        Car car = carService.getCars().get(carId - 1);
        System.out.println("Here are the details of the car with ID number " + carId + ": ");
        carService.displayCarProperties(car);
        System.out.println("Are you sure this is the car you want to rent?");
        String choice1 = Console.readText("Choice (Y/N)", Pattern.compile("[YyNn]"), "Invalid choice. Please try again.");

        if (choice1.equalsIgnoreCase("y")) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            int carQuantity = (int) Console.readNumber("Enter the quantity of this car you want to rent", 1, car.getQuantityAvailable());
            LocalDate today = LocalDate.now();
            LocalDate maxStartDate = today.plusDays(owner.getMaxDaysBetweenTodayAndStartDate());

            LocalDate startDate = Console.readDate("Enter the starting date (dd-MM-yyyy)", today, maxStartDate, "Starting date should be no earlier than today, and no later than " + maxStartDate.format(dateTimeFormatter) + ". Please try again.");

            int numberOfRentingDays = (int) Console.readNumber("Enter the number of days you want to rent the car", 1, owner.getMaxDaysBetweenStartAndEndDate());
            double price = numberOfRentingDays * car.getBaseRate();
            String formattedPrice = "Br. " + NumberFormat.getNumberInstance().format(price);

            System.out.println();
            System.out.println("Here's the information you entered so far:");
            System.out.println("Car ID number: " + carId);
            System.out.println("Car quantity: " + carQuantity);
            System.out.println("Start date: " + startDate);
            System.out.println("Number of days to rent: " + numberOfRentingDays);
            System.out.println();
            System.out.println("And here's the price: " + formattedPrice);

            System.out.println("Are you sure you want to rent this car?");
            String choice2 = Console.readText("Choice (Y/N)", Pattern.compile("[YyNn]"), "Invalid choice. Please try again.");
            if (choice2.equalsIgnoreCase("y"))
                userService.bookCar(car, carQuantity, startDate, numberOfRentingDays);
            else
                userScreenManager.switchScreen("UserScreen");
        }
        else
            userScreenManager.switchScreen("BookCarScreen");
    }
}
