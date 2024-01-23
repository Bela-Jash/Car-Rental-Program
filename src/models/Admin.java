package models;

import file_manager.Stream;
import utility.Directory;

import java.io.Serial;
import java.io.Serializable;

public class Admin extends Account implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Stream<Admin> stream = new Stream<>();
    private final String className = "Admin";
    private final String classPath = className + "/";
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
