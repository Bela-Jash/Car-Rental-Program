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
        System.out.println(String.valueOf("<>").repeat(20));
        System.out.format("status: %d\ndescription: %s\n", status, description);
        System.out.println(String.valueOf("<>").repeat(20));

    }
}
