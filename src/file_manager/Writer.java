package file_manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import static file_manager.Reader.*;

public class Writer {
    static String Database = "./database/";
    static String Table = Database + "Tables/";
    static String SchemaDir = Database + "Schemas/";

    public static void designSchema(String title, Map<String, String> pairs)
    {
        Path fullPath = Paths.get(SchemaDir).resolve(title);

        String strKey;
        String strValue;
        byte[] dataKey;
        byte[] dataValue;
        ByteBuffer outKey;
        ByteBuffer outValue;

        try (
                FileChannel fileChannel = FileChannel.open(fullPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ)
        ) {
            for (Map.Entry<String, String> pair: pairs.entrySet()) {
                strKey = pair.getKey() + "\n";
                strValue = pair.getValue() + "\n";

                dataKey = strKey.getBytes();
                dataValue = strValue.getBytes();

                outKey = ByteBuffer.wrap(dataKey);
                outValue = ByteBuffer.wrap(dataValue);

                while (outKey.hasRemaining())
                    fileChannel.write(outKey);
                outKey.rewind();

                while (outValue.hasRemaining())
                    fileChannel.write(outValue);
                outValue.rewind();
            }
        } catch (IOException x) {
            System.out.format("IOException: %s", x);
        }

        try {
            Files.createDirectory(Paths.get(Table + title));
        } catch (IOException e) {
            System.err.println("Error creating directory: " + e.getMessage());
        }

        try (
                FileChannel fileChannel = FileChannel.open(Paths.get(SchemaDir).resolve("ids"), StandardOpenOption.APPEND)
        ) {
            strKey = title + "\n";
            strValue = "1" + "\n";

            dataKey = strKey.getBytes();
            dataValue = strValue.getBytes();

            outKey = ByteBuffer.wrap(dataKey);
            outValue = ByteBuffer.wrap(dataValue);

            while (outKey.hasRemaining())
                fileChannel.write(outKey);
            outKey.rewind();

            while (outValue.hasRemaining())
                fileChannel.write(outValue);
            outValue.rewind();
        } catch (IOException x) {
            System.out.format("IOException: %s", x);
        }
    }
    private static void updateSchemaIds (String title, Map<String, String> pairs)
    {
        String file = title;
        Path fullPath = Paths.get(SchemaDir).resolve(file);

        String strKey;
        String strValue;
        byte[] dataKey;
        byte[] dataValue;
        ByteBuffer outKey;
        ByteBuffer outValue;

        try (
                FileChannel fileChannel = FileChannel.open(fullPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ)
        ) {
            for (Map.Entry<String, String> pair: pairs.entrySet())
            {
                strKey = pair.getKey() + "\n";
                strValue = pair.getValue() + "\n";

                dataKey = strKey.getBytes();
                dataValue = strValue.getBytes();

                outKey = ByteBuffer.wrap(dataKey);
                outValue = ByteBuffer.wrap(dataValue);

                while (outKey.hasRemaining())
                    fileChannel.write(outKey);
                outKey.rewind();

                while (outValue.hasRemaining())
                    fileChannel.write(outValue);
                outValue.rewind();
            }
        } catch (IOException x) {
            System.out.format("IOException: %s", x);
        }
    }
    public static void write(String schema, Map<String, String> dataMap)
    {

        Map<String, String> schemas = readSchema("ids");

        String directory = Table + schema;
        String file = schemas.get(schema);
        Path fullPath = Paths.get(directory).resolve(file);

        try (FileChannel fileChannel = FileChannel.open(fullPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ)) {
            fileChannel.truncate(0);

            for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                String keyValueString = entry.getKey() + ":" + entry.getValue() + "\n";
                byte[] data = keyValueString.getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(data);

                while (buffer.hasRemaining()) {
                    fileChannel.write(buffer);
                }
            }

            int i = Integer.parseInt(schemas.get(schema)) + 1;
            schemas.put(schema, Integer.toString(i));
            updateSchemaIds("ids", schemas);
        } catch (IOException e) {
            System.out.format("IOException: %s%n", e);
        }
    }
    public static void updateFile(String schema, String key, String value, int id)
    {
        Map<String, String> dataMap = read(Table + schema + "/" + String.valueOf(id));
        dataMap.put(key, value);

        Map<String, String> schemas = readSchema("ids");

        String directory = Table + schema;
        String file = String.valueOf(id);
        Path fullPath = Paths.get(directory).resolve(file);

        try (FileChannel fileChannel = FileChannel.open(fullPath, StandardOpenOption.WRITE)) {
            fileChannel.truncate(0);

            for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                String keyValueString = entry.getKey() + ":" + entry.getValue() + "\n";
                byte[] data = keyValueString.getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(data);

                while (buffer.hasRemaining()) {
                    fileChannel.write(buffer);
                }
            }
        } catch (IOException e) {
            System.out.format("IOException: %s%n", e);
        }
    }
    public static void deleteFile(String schema, int id) {
        String dirPath = Table + schema;
        String filePath = String.valueOf(id) + ".txt";
        Path fullPath = Paths.get(dirPath).resolve(filePath);

        try {
            Files.delete(fullPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static boolean validateMap(Map<String, String> dataMap, String schemaTitle)
    {
        Map<String, String> schemaMap = readSchema(schemaTitle);

        Set<Map.Entry<String, String>> schemaEntries = schemaMap.entrySet();
        AtomicBoolean isValid = new AtomicBoolean(true);

        dataMap.forEach((key, value) -> {
            if (schemaEntries.stream().noneMatch(entry -> entry.getKey().equals(key))) {
                System.out.println("Validation error: Key '" + key + "' not found in the schema.");
                isValid.set(false);
            } else {
                String expectedType = schemaMap.get(key);
                if (!validateType(value, expectedType)) {
                    System.out.println("Validation error: Key '" + key + "' has an invalid type.");
                    isValid.set(false);
                }
            }
        });

        return isValid.get();
    }
    private static boolean validateType(String value, String expectedType)
    {
        return expectedType.equals("String");
    }
}
