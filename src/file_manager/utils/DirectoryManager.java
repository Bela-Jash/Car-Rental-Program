package file_manager.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
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
}
