package javaphase1.Lesson3AssignmentFileHandling;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileAppendOperation implements IFileHandler {
    @Override
    public boolean applyOperation(Path filePath, Scanner scanner) throws IOException {
        System.out.println("Enter data to be appended ");
        String contentToAppend = scanner.nextLine();
        try {
            Files.write(
                    filePath,
                    contentToAppend.getBytes(),
                    StandardOpenOption.APPEND);
            System.out.println("File was updated");
        } catch (NoSuchFileException e) {
            System.out.println("File not found");
        }
        return false;

    }
}
