package javaphase1.Lesson3AssignmentFileHandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileReadOperation implements IFileHandler {
    @Override
    public boolean applyOperation(final Path filePath, final Scanner scanner) throws IOException {
        List<String> lines;
        try {
            lines = Files.readAllLines(filePath);

            Iterator<String> itr = lines.iterator();
            while (itr.hasNext())
                System.out.println(itr.next());

        } catch (NoSuchFileException e) {
            System.out.println("File not found");
        }

        return false;
    }
}
