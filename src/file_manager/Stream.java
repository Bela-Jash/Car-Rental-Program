package file_manager;

import java.io.*;

public class Stream<T> {
    public boolean writer(T data, String filePath) {
        boolean operationSuccessful = true;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(data);
        } catch (IOException e) {
            operationSuccessful = false;
        }
        return operationSuccessful;
    }

    public T reader(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    public boolean deleter(String filePath) {
        boolean operationSuccessful = true;
        File fileToDelete = new File(filePath);

        if (fileToDelete.exists()) {
            if (!fileToDelete.delete())
                operationSuccessful = false;
        }
        else
            operationSuccessful = false;
        return operationSuccessful;
    }
}
