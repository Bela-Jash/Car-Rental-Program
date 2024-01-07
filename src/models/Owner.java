package models;

public class Owner extends Admin {
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
}
