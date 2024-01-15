package file_manager;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RUN
{
    public static void main(String[] args)
    {
//        Foo i = new Foo("foo", 12.34);
        List<Foo> item = Foo.readAll();
        for (Foo i : item)
        {
            i.display();
        }

//        i.write();

        SchemaId Database = new SchemaId();
//        Database.resetDatabase();
        Database.display();

//        File directory = new File("");
//        System.out.println(directory.isDirectory());

    }
}
