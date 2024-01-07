package models;

import utility.Console;
import utility.Patterns;

import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Account {
    // ====================== Fields ======================
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;

    // ====================== Constructors ======================
    public Account() {}
    public Account(String name, String phoneNumber, String email, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    // ====================== Getters ======================
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    // ====================== Setters ======================
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
