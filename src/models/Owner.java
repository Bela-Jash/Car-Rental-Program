package models;

import file_manager.Stream;
import utility.Directory;

import java.io.Serial;

public class Owner extends Admin {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Stream<Owner> stream = new Stream<>();
    private final String className = "Owner";
    private final String classPath = className + "/";

    private String companyName;
    /** The maximum number of days between today and the starting date of the rent */
    private int maxDaysBetweenTodayAndStartDate = 180;
    /** The maximum number of days between the starting and ending date of the rent */
    private int maxDaysBetweenStartAndEndDate = 60;

    public Owner() {}
    public Owner(String name, String phoneNumber, String email, String password) {
        super(name, phoneNumber, email, password);
    }

    public void createAdminAccount() {}
    public void removeAdminAccount() {}
    public void removeUserAccount() {}
    public void listAllAdmins() {}
    private void initializeFields() {
        // ToDo: Read and assign fields from file
    }
    // ====================== Getters ======================
    public String getCompanyName() {
        initializeFields();
        companyName = "our car rental company"; // ToDo: Delete this line
        return companyName;
    }

    public int getMaxDaysBetweenTodayAndStartDate() {
        initializeFields();
        return maxDaysBetweenTodayAndStartDate;
    }

    public int getMaxDaysBetweenStartAndEndDate() {
        initializeFields();
        return maxDaysBetweenStartAndEndDate;
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

    public boolean setCompanyName(String companyName) {
        this.companyName = companyName;
        // ToDo: Write the updated field to file
        return stream.writer(this, Directory.TableDirectory + classPath + id);
    }

    public boolean setMaxDaysBetweenTodayAndStartDate(int maxDaysBetweenTodayAndStartDate) {
        this.maxDaysBetweenTodayAndStartDate = maxDaysBetweenTodayAndStartDate;
        return stream.writer(this, Directory.TableDirectory + classPath + id);
    }

    public boolean setMaxDaysBetweenStartAndEndDate(int maxDaysBetweenStartAndEndDate) {
        this.maxDaysBetweenStartAndEndDate = maxDaysBetweenStartAndEndDate;
        return stream.writer(this, Directory.TableDirectory + classPath + id);
    }
}
