package javaphase1.Lesson3AssignmentFileHandling;

import java.util.InputMismatchException;

public enum FileMenu {
    READ("1", "Read from the file"),
    WRITE("2", "Write to the file"),
    APPEND("3", "Append to the file"),
    EXIT("4", "Exit");

    private final String symbol;
    private final String description;
    FileMenu(final String symbol, final String description) {
        this.symbol = symbol;
        this.description = description;
    }

    public static FileMenu getBySymbol(final String symbol) {
        for (FileMenu value : FileMenu.values()) {
            if (value.getSymbol().equals(symbol)) {
                return value;
            }
        }
        throw new InputMismatchException("Invalid Input");
    }

    public String getSymbol() {
        return symbol;
    }

    public String getDescription() {
        return description;
    }
}