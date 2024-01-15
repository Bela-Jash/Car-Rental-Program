package file_manager;

import models.Car;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RUN
{
    public static void main(String[] args)
    {
        Car boo = new Car();
        boo.setBrand("Toyota");
        boo.setModel("Vits");

        boo.write();
        SchemaId Database = new SchemaId();
        Database.display();
    }
}
