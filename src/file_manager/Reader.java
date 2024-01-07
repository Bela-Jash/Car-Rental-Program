package file_manager;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;

public class Reader {
    public static Map<String, String> readSchema(String title) {
        Map<String, String> pairs = new HashMap<>();
        String directory = "Schema";
        String file = title + ".txt";
        Path fullPath = Paths.get(directory).resolve(file);

        ByteBuffer buffer = ByteBuffer.allocate(1024); // Adjust the size as needed

        try (FileChannel flCh = FileChannel.open(fullPath, StandardOpenOption.READ)) {
            StringBuilder currentKey = new StringBuilder();
            StringBuilder currentValue = new StringBuilder();
            boolean isKey = true;

            while (flCh.read(buffer) != -1) {
                buffer.flip();

                while (buffer.hasRemaining()) {
                    char currentChar = (char) buffer.get();

                    if (currentChar == '\n') {
                        if (isKey) {
                            currentKey.append('\n');
                        } else {
                            pairs.put(currentKey.toString().replace("\n", ""), currentValue.toString().replace("\n", ""));
                            currentKey.setLength(0);
                            currentValue.setLength(0);
                        }

                        isKey = !isKey;
                    } else {
                        if (isKey) {
                            currentKey.append(currentChar);
                        } else {
                            currentValue.append(currentChar);
                        }
                    }
                }

                buffer.clear();
            }
        } catch (IOException x) {
            System.out.format("IOException: %s%n", x);
        }

        return pairs;
    }

    public static Map<String, String> read(String filePath) {
        Map<String, String> dataMap = new HashMap<>();

        try (FileChannel fileChannel = FileChannel.open(Path.of(filePath), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024); // Adjust the size as needed

            StringBuilder currentKey = new StringBuilder();
            StringBuilder currentValue = new StringBuilder();
            boolean isKey = true;

            while (fileChannel.read(buffer) != -1) {
                buffer.flip();

                while (buffer.hasRemaining()) {
                    char currentChar = (char) buffer.get();

                    if (currentChar == ':') {
                        isKey = false;
                    } else if (currentChar == '\n') {
                        dataMap.put(currentKey.toString(), currentValue.toString());
                        currentKey.setLength(0);
                        currentValue.setLength(0);
                        isKey = true;
                    } else {
                        if (isKey) {
                            currentKey.append(currentChar);
                        } else {
                            currentValue.append(currentChar);
                        }
                    }
                }

                buffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataMap;
    }

    public static Map<Integer, Map<String, String>> readAll(String schema) {
        String directoryPath = "ra/" + schema;
        Map<Integer, Map<String, String>> map = new HashMap<>();

        try {
            try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
                paths
                        .filter(Files::isRegularFile)
                        .forEach(path -> {
                            try {
                                int key = getIntFromDirectoryPath(path.toString());
                                Map<String, String> value = read(path.toString());
                                map.put(key, value);
                            } catch (Exception e) {
                                // Handle exceptions, e.g., log or print an error message
                                System.err.println("Error processing file: " + path.toString());
                                e.printStackTrace();
                            }
                        });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<Integer, Map<String, String>> readOne(String schema, String searchBy, String index) {
        String directoryPath = "ra/" + schema;
        Map<Integer, Map<String, String>> map = new HashMap<>();

        try {
            try (
                    Stream<Path> paths = Files.walk(Paths.get(directoryPath))
            ) {
                paths
                        .filter(Files::isRegularFile)
                        .forEach(path -> {
                            try {
                                Map<String, String> value = read(path.toString());
                                if (Objects.equals(value.get(searchBy), index)) {
                                    int key = getIntFromDirectoryPath(path.toString());
                                    map.put(key, value);
                                }
                            } catch (Exception e) {
                                System.err.println("Error processing file: " + path.toString());
                                e.printStackTrace();
                            }
                        });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    private static int getIntFromDirectoryPath(String dirPath) {
        String[] roots = dirPath.split("[/\\\\]");  // Match both forward and backward slashes
        String[] filename = roots[roots.length - 1].split("\\.");

        try {
            return Integer.parseInt(filename[0]);
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer from: " + dirPath);
            e.printStackTrace();
            return -1; // or handle the error as appropriate for your application
        }
    }
}