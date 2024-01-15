package file_manager.utils;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.FileVisitOption;
import java.util.EnumSet;
public class DirectoryManager {
    public static void createDirectory(String schemaTitle) {
        Path path = Paths.get(schemaTitle);

        try {
            Files.createDirectories(path);
            System.out.println("Directory created successfully at: " + path);
        } catch (IOException e) {
            System.err.println("Error creating directory: " + e.getMessage());
        }
    }

    public static void deleteDirectory(String directoryPath) {
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

            System.out.println("Directory deleted successfully: " + path);
        } catch (DirectoryNotEmptyException e) {
            System.err.println("Error: Directory not empty");
        } catch (IOException e) {
            System.err.println("Error deleting directory: " + e.getMessage());
        }
    }

    public static void cleanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        // Check if the provided path is a directory
        if (directory.isDirectory()) {
            // Get all files and subdirectories in the directory
            File[] files = directory.listFiles();

            // Delete each file and subdirectory
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // Recursive call to delete files in subdirectories
                        cleanDirectory(file.getAbsolutePath());
                    } else {
                        // Delete the file
                        if (!file.delete()) {
                            System.err.println("Failed to delete file: " + file.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            System.err.println("Invalid directory path: " + directoryPath);
        }
    }
}
