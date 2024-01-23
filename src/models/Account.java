package models;

public abstract class Account {
    // ====================== Fields ======================
    int id;
    String name;
    String phoneNumber;
    String email;
    String password;

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

}
