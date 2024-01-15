package file_manager;

import file_manager.documentations.Constant;
import file_manager.errorMessage.ERROR;
import file_manager.utils.DirectoryManager;

import java.util.HashMap;
import java.util.Map;

public class SchemaId
{
    private HashMap<String, Map<Integer, Integer>> tables = new HashMap<>();
    SchemaId()
    {
        Stream<HashMap<String, Map<Integer, Integer>>> stream = new Stream<>();
        tables = stream.reader(Constant._SchemaIdsPath);
    }
    SchemaId(HashMap<String, Map<Integer, Integer>> _tables)
    {
        this.tables = _tables;
        updateSchema();
    }

    public void updateSchema()
    {
        Stream<HashMap<String, Map<Integer, Integer>>> stream = new Stream<>();
        stream.writer(tables, Constant._SchemaIdsPath);
    }

    public void addTable(String schemaTitle)
    {

        if (tables.containsKey(schemaTitle))
        {
            ERROR e = new ERROR(5000, "schema name already existed.");
            e.print();
            return;
        }

        Map<Integer, Integer> rollAndSize = new HashMap<>();

        rollAndSize.put(0,0); // Key 0 : for roll numbers which get auto-incremented during data-insertion
        rollAndSize.put(1,0); // Key 1 : for size of a given table which gets auto-incremented during data-insertion and decremented during data-deletion

        tables.put(schemaTitle, rollAndSize);

        DirectoryManager.createDirectory(Constant._TableDirectory + schemaTitle);

        updateSchema();
    }

    public void removeTable(String schemaTitle)
    {
        tables.remove(schemaTitle);
        DirectoryManager.deleteDirectory(Constant._TableDirectory + schemaTitle);

        updateSchema();
    }

    public void resetDatabase()
    {
        Map<Integer, Integer> zeros = new HashMap<>();
        zeros.put(0,0);
        zeros.put(1,0);
        for (Map.Entry<String, Map<Integer, Integer>> table : tables.entrySet())
        {
            tables.put(table.getKey(), zeros);
            DirectoryManager.cleanDirectory(Constant._TableDirectory + table.getKey());
        }
            updateSchema();
    }

    private Map<Integer, Integer> schemaDetail(String schemaTitle)
    {
        if (tables.containsKey(schemaTitle))
        {
            return tables.get(schemaTitle);
        } else
        {
            ERROR e = new ERROR(4000, "table no found");
            e.print();
            return null;
        }
    }

    public void incrementSize(String schemaTitle)
    {
        Map<Integer, Integer> i = schemaDetail(schemaTitle);

        if (i == null) return;

        i.put(0, i.get(0) + 1);
        i.put(1, i.get(1) + 1);

        tables.put(schemaTitle, i);
        updateSchema();
    }

    public void decrementSize(String schemaTitle)
    {
        Map<Integer, Integer> i = schemaDetail(schemaTitle);

        if (i == null) return;

        i.put(1, i.get(1) - 1);

        tables.put(schemaTitle, i);
        updateSchema();
    }

    public int getRoll(String schemaTitle)
    {
        return tables.get(schemaTitle).get(0);
    }

    public void display() {
        System.out.printf(String.valueOf("=").repeat(40) + "\n");
        System.out.printf("%-15s%-7s%-7s\n", "Table", "Exp", "Size");


        for (Map.Entry<String, Map<Integer, Integer>> entry : tables.entrySet()) {
            String tableName = entry.getKey();
            Map<Integer, Integer> innerMap = entry.getValue();

            System.out.printf("%-15s%-7s%-7s\n", tableName, innerMap.get(0), innerMap.get(1));

        }
        System.out.printf(String.valueOf("=").repeat(40) + "\n");

    }
}
