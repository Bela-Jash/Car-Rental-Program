package file_manager;

import java.io.*;

public class Stream<T> {
    public void writer(T data, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(data);
            System.out.println("Data written to file: " + data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T reader(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            T loadedData = (T) ois.readObject();
            System.out.println("Data loaded from file: " + loadedData);
            return loadedData;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
