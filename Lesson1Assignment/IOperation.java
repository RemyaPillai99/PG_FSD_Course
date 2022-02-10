package javaphase1.Lesson1Assignment;

import java.util.Scanner;

public interface IOperation {
    String getName();
    void initialize(final Double input);
    void acceptInput(final Scanner scanner);
    double getResult() throws CalculatorException;
}
