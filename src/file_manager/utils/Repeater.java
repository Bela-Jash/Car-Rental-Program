package file_manager.utils;

public class Repeater {
    public static String write(char ch, int times)
    {
        StringBuilder v = new StringBuilder();
        v.append(String.valueOf(ch).repeat(Math.max(0, times)));
        return v.toString();
    }
}
