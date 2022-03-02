package javaphase1.Lesson3AssignmentFileHandling;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public interface IFileHandler {
    boolean applyOperation(Path filePath, Scanner scanner) throws IOException;
}
