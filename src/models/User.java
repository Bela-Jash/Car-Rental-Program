package models;

import file_manager.SchemaId;
import file_manager.Stream;
import file_manager.documentations.Constant;
import services.CarService;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User extends Account implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    // ====================== Fields ======================
//    private List<Car> rentedCars = new ArrayList<>();
    /** A map of a car as a key and its rent ending date as a value */
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

    // ==================== Stream Configs ====================

    private int m_roll;
    // generic type
    private static final String myName = "User";
    private static final String myDirPath = Constant._TableDirectory + myName + "/";

    // generic type
    public void display(){
        System.out.printf(String.valueOf("*").repeat(40) + "\n");
        System.out.printf("%-10s%-10s%-10s\n", "roll");
        System.out.printf("%-10d%-10s%-10f\n", m_roll);
        System.out.printf(String.valueOf("*").repeat(40) + "\n");
    }

    public void write()
    {
        SchemaId database = new SchemaId();
        database.incrementSize(myName);
        m_roll = database.getRoll(myName);

        // generic type
        Stream<User> stream = new Stream<>();
        stream.writer(this,  myDirPath + m_roll);
    }

    public void delete()
    {
        SchemaId database = new SchemaId();
        database.decrementSize(myName);

        // generic type
        Stream<User> stream = new Stream<>();
        stream.deleter( myDirPath + m_roll);

    }

    public User read(int roll)
    {
        // generic type
        Stream<User> stream = new Stream<>();
        return stream.reader(myDirPath + roll);
    }

    // generic type
    private static User read(String filePath)
    {
        // generic type
        Stream<User> stream = new Stream<>();
        return stream.reader(filePath);
    }

    // generic type
    public static List<User> readAll()
    {
        Stream<User> stream = new Stream<>(); // generic type
        List<User> ls = new ArrayList<>(); // generic type

        try {
            Files.walk(Paths.get(myDirPath), Integer.MAX_VALUE, FileVisitOption.FOLLOW_LINKS)
                    .filter(Files::isRegularFile)
                    .forEach(path -> {
                        ls.add(read(path.toString()));
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ls;
    }
}
