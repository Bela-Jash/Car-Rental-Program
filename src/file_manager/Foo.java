package file_manager;

import file_manager.documentations.Constant;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class Foo implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
    private String m_data;
    private double m_size;

    public Foo(String data, double size)
    {
        m_data = data;
        m_size = size;
    }

    public String getData()
    {
        return m_data;
    }

    public double getSize()
    {
        return m_size;
    }

    public void setData(String data)
    {
        m_data = data;
    }

    public void setSize(double size)
    {
        m_size = size;
    }
    private int m_roll;
    // generic type
    private static final String myName = "Foo";
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
        Stream<Foo> stream = new Stream<>();
        stream.writer(this,  myDirPath + m_roll);
    }

    public void delete()
    {
        SchemaId database = new SchemaId();
        database.decrementSize(myName);

        // generic type
        Stream<Foo> stream = new Stream<>();
        stream.deleter( myDirPath + m_roll);

    }
    public void update()
    {
        Stream<Foo> stream = new Stream<>();
        stream.writer(this,  myDirPath + m_roll);
    }

    public Foo read(int roll)
    {
        // generic type
        Stream<Foo> stream = new Stream<>();
        return stream.reader(myDirPath + roll);
    }

    // generic type
    private static Foo read(String filePath)
    {
        // generic type
        Stream<Foo> stream = new Stream<>();
        return stream.reader(filePath);
    }

    // generic type
    public static List<Foo> readAll()
    {
        Stream<Foo> stream = new Stream<>(); // generic type
        List<Foo> ls = new ArrayList<>(); // generic type

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