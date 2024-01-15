package file_manager;

import java.util.HashMap;
import java.util.Map;

public class Database_Initializer {
    public static void main(String[] args)
    {
        HashMap<String, Map<Integer, Integer>> one = new HashMap<>();
        Map<Integer, Integer> two = new HashMap<>();
        two.put(0, 0);
        two.put(1, 0);
        one.put("Admin", two);
    }
}
