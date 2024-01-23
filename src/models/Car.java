package models;

import java.io.Serial;
import java.io.Serializable;

public class Car implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
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
    public void setId(int id) {
        this.id = id;
        // ToDo: Write updated field to file
    }

    public void setBrand(String brand) {
        this.brand = brand;
        // ToDo: Write updated field to file
    }

    public void setModel(String model) {
        this.model = model;
        // ToDo: Write updated field to file
    }

    public void setType(String type) {
        this.type = type;
        // ToDo: Write updated field to file
    }

    public void setColor(String color) {
        this.color = color;
        // ToDo: Write updated field to file
    }

    public void setYear(int year) {
        this.year = year;
        // ToDo: Write updated field to file
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
        // ToDo: Write updated field to file
    }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
        // ToDo: Write updated field to file
    }
}
