package javaphase1.Lesson1Assignment;

import java.util.Objects;
import java.util.Scanner;

public final class CalculatorInputUtil {
    private CalculatorInputUtil() {
        // Utility Class
    }



    public static Double acceptNumberInput(final Scanner scanner) {
        Double number = null;
        System.out.println("Enter a number");
        while(Objects.isNull(number)) {
            try {
                number = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Enter a valid number");
                number = null;
            }
        }

        return number;
    }
}
