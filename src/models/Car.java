package models;

import file_manager.Stream;
import utility.Directory;

import java.io.Serial;
import java.io.Serializable;

public class Car implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Stream<Car> stream = new Stream<>();
    private final String className = "Car";
    private final String classPath = className + "/";
    // ====================== Fields ======================
    private int id;
    private String brand;
    private String model;
    private String type;
    private String color;
    private int year;
    private int quantityAvailable;
    private double baseRate;

    // ====================== Constructors ======================
    public Car() {}

    public Car(int id, String brand, String model, String type, String color, int year, int quantityAvailable, double baseRate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.color = color;
        this.year = year;
        this.quantityAvailable = quantityAvailable;
        this.baseRate = baseRate;
    }

    // ====================== Getters ======================
    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public double getBaseRate() {
        return baseRate;
    }

    // ====================== Setters ======================
    public boolean setId(int id) {
        this.id = id;
        // ToDo (Done): Write updated field to file
        // ToDo: Utilize this return value at the method call
        return stream.writer(this, Directory.TableDirectory + classPath + id);

    }

    public boolean setBrand(String brand) {
        this.brand = brand;
        // ToDo (Done): Write updated field to file
        // ToDo: Utilize this return value at the method call
        return stream.writer(this, Directory.TableDirectory + classPath + id);
    }

    public boolean setModel(String model) {
        this.model = model;
        // ToDo (Done): Write updated field to file
        // ToDo: Utilize this return value at the method call
        return stream.writer(this, Directory.TableDirectory + classPath + id);
    }

    public boolean setType(String type) {
        this.type = type;
        // ToDo (Done): Write updated field to file
        // ToDo: Utilize this return value at the method call
        return stream.writer(this, Directory.TableDirectory + classPath + id);
    }

    public boolean setColor(String color) {
        this.color = color;
        // ToDo (Done): Write updated field to file
        // ToDo: Utilize this return value at the method call
        return stream.writer(this, Directory.TableDirectory + classPath + id);
    }

    public boolean setYear(int year) {
        this.year = year;
        // ToDo (Done): Write updated field to file
        // ToDo: Utilize this return value at the method call
        return stream.writer(this, Directory.TableDirectory + classPath + id);
    }

    public boolean setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
        // ToDo (Done): Write updated field to file
        // ToDo: Utilize this return value at the method call
        return stream.writer(this, Directory.TableDirectory + classPath + id);
    }

    public boolean setBaseRate(double baseRate) {
        this.baseRate = baseRate;
        // ToDo (Done): Write updated field to file
        // ToDo: Utilize this return value at the method call
        return stream.writer(this, Directory.TableDirectory + classPath + id);
    }
}
