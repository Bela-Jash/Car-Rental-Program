package models;

import file_manager.SchemaId;
import file_manager.Stream;
import file_manager.documentations.Constant;

import java.io.Serial;
import java.io.Serializable;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Account implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
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

    // ==================== Stream Configs ====================

    private int m_roll;
    // generic type
    private static final String myName = "Admin";
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
        Stream<Admin> stream = new Stream<>();
        stream.writer(this,  myDirPath + m_roll);
    }

    public void delete()
    {
        SchemaId database = new SchemaId();
        database.decrementSize(myName);

        // generic type
        Stream<Admin> stream = new Stream<>();
        stream.deleter( myDirPath + m_roll);

    }

    public Admin read(int roll)
    {
        // generic type
        Stream<Admin> stream = new Stream<>();
        return stream.reader(myDirPath + roll);
    }

    // generic type
    private static Admin read(String filePath)
    {
        // generic type
        Stream<Admin> stream = new Stream<>();
        return stream.reader(filePath);
    }

    // generic type
    public static List<Admin> readAll()
    {
        Stream<Admin> stream = new Stream<>(); // generic type
        List<Admin> ls = new ArrayList<>(); // generic type

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
