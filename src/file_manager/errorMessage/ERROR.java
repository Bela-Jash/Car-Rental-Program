package file_manager.errorMessage;

public class ERROR {
    private int status;
    private String description;
    public ERROR(int status, String description)
    {
        this.description = description;
        this.status = status;
    }
    public void print()
    {
        System.out.format("\nstatus: %n\ndescription: %s\n", status, description);
    }
}
