package file_manager;

import java.io.*;

public class Stream<T> {
    public void writer(T data, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T reader(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            T loadedData = (T) ois.readObject();
            return loadedData;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleter(String filePath) {
        File fileToDelete = new File(filePath);

        if (fileToDelete.exists()) {
            if (fileToDelete.delete()) {
                System.out.println("File deleted successfully: " + filePath);
            } else {
                System.err.println("Failed to delete file: " + filePath);
            }
        } else {
            System.err.println("File not found: " + filePath);
        }
    }
}
