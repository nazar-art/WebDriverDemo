package zDemo;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

enum SqlCommands {
    SELECT("SELECT * FROM ?"),
    INSERT("INSERT INTO ?() VALUES()"),
    UPDATE("UPDATE ? SET ?=? WHERE ?"),
    DELETE("DELETE FROM ? WHERE ?");

    private String sqlOperation;

    SqlCommands(String sqlOperation) {
        this.sqlOperation = sqlOperation;
    }

    public String getSqlOperation() {
        return sqlOperation;
    }
}

public class SqlTemplatesDemo {

    public static final EnumMap<SqlCommands, String> map = new EnumMap<>(SqlCommands.class);
    static {
        map.put(SqlCommands.SELECT, "SELECT * FROM ?");
        map.put(SqlCommands.INSERT, "INSERT INTO ?() VALUES()");
        map.put(SqlCommands.UPDATE, "UPDATE ? SET ?=? WHERE ?");
        map.put(SqlCommands.DELETE, "DELETE FROM ? WHERE ?");
    }

    public static void main(String[] args) {
//        System.out.println("Solution 1:");
//        for (Map.Entry<SqlCommands, String> entry : map.entrySet()) {
//            System.out.printf("Key: [%s] for value: [%s]\n", entry.getKey(), entry.getValue());
//        }
//
//        System.out.println("\nSolution 2:");
//        for (SqlCommands sqlCommand : SqlCommands.values()) {
//            System.out.printf("Enum key: [%s], and value: [%s]\n", sqlCommand, sqlCommand.getSqlOperation());
//        }

        final var list = List.of("12345", "34578", "12345", "98710", "12345");

        final var counts = list.stream()
                .collect(Collectors.toMap(
                Function.identity(),
                value -> 1,
                (count1, count2) -> count1 + count2
        ));

        System.out.println(counts);
    }
}
