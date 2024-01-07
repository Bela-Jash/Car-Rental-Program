package models;

public class Admin extends Account {
    // ====================== Constructors ======================
    public Admin() {}

    public Admin(String name, String phoneNumber, String email, String password) {
        super(name, phoneNumber, email, password);
    }

    // ====================== Modifying ======================
    public void modifyCar() {}

    // ====================== Adding ======================
    public void addCar() {}
    public void addCarBrand() {}
    public void addCarType() {}

    // ====================== Removing ======================
    public void removeCar() {}
    public void removeCarBrand() {}
    public void removeCarType() {}

    // ====================== Listing ======================
    public void listAllUsers() {}
    public void listAllCarBrands() {}
    public void listAllCarTypes() {}
    public void listAllRentedCars() {}

}
