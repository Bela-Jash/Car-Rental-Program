package models;

import file_manager.SchemaId;
import file_manager.Stream;
import file_manager.documentations.Constant;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Owner extends Admin implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String companyName;
    /** The maximum number of days between today and the starting date of the rent */
    private int maxDaysBetweenTodayAndStartDate = 180;
    /** The maximum number of days between the starting and ending date of the rent */
    private int maxDaysBetweenStartAndEndDate = 60;

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
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
        // ToDo: Write the updated field to file
    }

    public void setMaxDaysBetweenTodayAndStartDate(int maxDaysBetweenTodayAndStartDate) {
        this.maxDaysBetweenTodayAndStartDate = maxDaysBetweenTodayAndStartDate;
    }

    public void setMaxDaysBetweenStartAndEndDate(int maxDaysBetweenStartAndEndDate) {
        this.maxDaysBetweenStartAndEndDate = maxDaysBetweenStartAndEndDate;
    }

    // ==================== Stream Configs ====================

    private int m_roll;
    // generic type
    private static final String myName = "Owner";
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
        Stream<Owner> stream = new Stream<>();
        stream.writer(this,  myDirPath + m_roll);
    }

    public void delete()
    {
        SchemaId database = new SchemaId();
        database.decrementSize(myName);

        // generic type
        Stream<Owner> stream = new Stream<>();
        stream.deleter( myDirPath + m_roll);

    }

    public Owner read(int roll)
    {
        // generic type
        Stream<Owner> stream = new Stream<>();
        return stream.reader(myDirPath + roll);
    }

}
