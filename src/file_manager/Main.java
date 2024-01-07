package file_manager;

import java.util.Map;

import static file_manager.Reader.*;

public class Main
{
    public static void main(String[] args)
    {
        Map<Integer, Map<String, String>> user = readOne("user", "username", "Oswald Cobblepot");

        for (Map.Entry<Integer, Map<String, String>> map : user.entrySet())
        {
            System.out.println(map.getKey());
            for (Map.Entry<String, String> innerMap : map.getValue().entrySet())
            {
                System.out.println("\t" + innerMap.getKey() + ": " + innerMap.getValue());
            }
        }
    }
}