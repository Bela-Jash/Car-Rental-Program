package file_manager;

import file_manager.documentations.Constant;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class Streamer
{
    private int m_roll;
    private static String myName;
    private static String myDirPath = Constant._TableDirectory + myName + "/";

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


        Stream<Foo> stream = new Stream<>();
        stream.writer(this,  myDirPath + m_roll);
    }

    public void delete()
    {
        SchemaId database = new SchemaId();
        database.decrementSize(myName);

        Stream<Foo> stream = new Stream<>();
        stream.deleter( myDirPath + m_roll);

    }

    public Foo read(int roll)
    {
        Stream<Foo> stream = new Stream<>();
        return stream.reader(myDirPath + roll);
    }

    private static Foo read(String filePath)
    {
        Stream<Foo> stream = new Stream<>();
        return stream.reader(filePath);
    }

    public static List<Foo> readAll()
    {
        Stream<Foo> stream = new Stream<>();
        List<Foo> ls = new ArrayList<>();

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