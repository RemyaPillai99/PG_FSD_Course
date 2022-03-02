package javaphase1.Lesson3AssignmentFileHandling;

import java.nio.file.Path;
import java.util.Scanner;

public class FileExitOperation implements IFileHandler {
    @Override
    public boolean applyOperation(Path filePath, Scanner scanner) {
        return true;
    }
}
