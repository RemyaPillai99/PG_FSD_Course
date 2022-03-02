package javaphase1.Lesson3AssignmentFileHandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileWriteOperation implements IFileHandler {

    @Override
    public boolean applyOperation(Path filePath, Scanner scanner) throws IOException {

        System.out.println("Enter data to be written to file");
        String data = scanner.nextLine();
        byte[] strToBytes = data.getBytes();
        if (Files.exists(filePath)) {
            System.out.println("Do you want to overwrite data in existing file : Y/N");
            if (scanner.nextLine().toUpperCase().equals("Y")) {
                Files.write(filePath, strToBytes);
                System.out.println("File was successfully overwritten ");
            } else {
                System.out.println("File was not written");
            }
        } else {
            Files.write(filePath, strToBytes);
            System.out.println("File was successfully created and written ");
        }

        return false;

    }
}
