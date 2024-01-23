package models;

import file_manager.Stream;
import services.CarService;
import utility.Directory;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User extends Account implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Stream<User> stream = new Stream<>();
    private final String className = "User";
    private final String classPath = className + "/";
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

    // ====================== Setters ======================
    public boolean setId(int id) {
        this.id = id;
        return stream.writer(this, Directory.TableDirectory + classPath + id);
    }
    public boolean setName(String name) {
        this.name = name;
        return stream.writer(this, Directory.TableDirectory + classPath + id);
    }
    public boolean setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return stream.writer(this, Directory.TableDirectory + classPath + id);
    }
    public boolean setEmail(String email) {
        this.email = email;
        return stream.writer(this, Directory.TableDirectory + classPath + id);
    }
    public boolean setPassword(String password) {
        this.password = password;
        return stream.writer(this, Directory.TableDirectory + classPath + id);
    }
}
