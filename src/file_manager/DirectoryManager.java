package file_manager;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoryManager {
    public boolean createDirectory(String schemaTitle) {
        boolean operationSuccessful = true;
        Path path = Paths.get(schemaTitle);

        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            operationSuccessful = false;
        }

        return operationSuccessful;
    }

    public boolean deleteDirectory(String directoryPath) {
        boolean operationSuccessful = true;
        Path path = Paths.get(directoryPath);

        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            operationSuccessful = false;
        }

        return operationSuccessful;
    }

    public boolean cleanDirectory(String directoryPath) {
        boolean operationSuccessful = true;
        File directory = new File(directoryPath);

        // Check if the provided path is a directory
        if (directory.isDirectory()) {
            // Get all files and subdirectories in the directory
            File[] files = directory.listFiles();

            // Delete each file and subdirectory
            if (files != null)
                for (File file : files) {
                    if (file.isDirectory())
                        cleanDirectory(file.getAbsolutePath()); // Recursive call to delete files in subdirectories
                    else
                        if (!file.delete()) // Delete the file
                            operationSuccessful = false;
                }
        }
        else
            operationSuccessful = false;

        return operationSuccessful;
    }
}
