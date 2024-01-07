package models;

import java.util.ArrayList;
import java.util.List;

public class Car {
    // ====================== Fields ======================
    private int id;
    private String brand;
    private String model;
    private String type;
    private String color;
    private int year;
    private int quantityAvailable;
    private double baseRate;
    private List<String> VINs;

    // ====================== Constructors ======================
    public Car() {}

    public Car(int id, String brand, String model, String type, String color, int year, int quantityAvailable, double baseRate, List<String> VINs) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.color = color;
        this.year = year;
        this.quantityAvailable = quantityAvailable;
        this.baseRate = baseRate;
        VINs = new ArrayList<>(quantityAvailable);
        this.VINs = VINs;
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

    public List<String> getVINs() {
        return VINs;
    }

    // ====================== Setters ======================
    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public void setVIN(List<String> VINs) {
        this.VINs = VINs;
    }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }
}
