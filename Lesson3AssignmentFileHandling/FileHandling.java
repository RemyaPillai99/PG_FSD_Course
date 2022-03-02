package javaphase1.Lesson3AssignmentFileHandling;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileHandling {

    private EnumMap<FileMenu, IFileHandler> fileMenuMap = new EnumMap(FileMenu.class);
    private Path usrPath;

    FileHandling() {

        fileMenuMap.put(FileMenu.READ, new FileReadOperation());
        fileMenuMap.put(FileMenu.WRITE, new FileWriteOperation());
        fileMenuMap.put(FileMenu.APPEND, new FileAppendOperation());
        fileMenuMap.put(FileMenu.EXIT, new FileExitOperation());

    }

    public static void main(final String[] args) {
        FileHandling fileHandler = new FileHandling();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter file path to do the file Operations: ");
            fileHandler.usrPath = Paths.get(scanner.nextLine());
            while (true) {
                fileHandler.displayMenu();
                String option = scanner.nextLine();
                try {

                    FileMenu selectedMenuItem = FileMenu.getBySymbol(option);
                    IFileHandler operation = fileHandler.fileMenuMap.get(selectedMenuItem);
                    if (operation.applyOperation(fileHandler.usrPath, scanner)) {
                        return;
                    }
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private void displayMenu() {
        System.out.println("\nPlease select an option:");
        for (FileMenu option : fileMenuMap.keySet()) {
            System.out.println(option.getSymbol() + "> " + option.getDescription());
        }
    }
}
