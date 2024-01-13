package models;

import services.CarService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User extends Account {
    // ====================== Fields ======================
    private List<Car> rentedCars;
    private List<Integer> rentedCarsQuantities;
    private List<LocalDate> rentedCarsEndDates;
    private List<Double> rentedCarsTotalPrices;

    // ====================== Constructors ======================
    public User() {}

    public User(String name, String phoneNumber, String email, String password) {
        super(name, phoneNumber, email, password);
    }

    // ====================== Getters ======================
    public List<Car> getRentedCars() {
        return rentedCars;
    }

    public List<Integer> getRentedCarsQuantities() {
        return rentedCarsQuantities;
    }

    public List<LocalDate> getRentedCarsEndDates() {
        return rentedCarsEndDates;
    }

    public List<Double> getRentedCarsTotalPrices() {
        return rentedCarsTotalPrices;
    }
}
