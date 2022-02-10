package javaphase1.Lesson1Assignment;

import java.util.Scanner;

public class ClearOperation implements IOperation {

    @Override
    public String getName() {
        return "Clear";
    }

    @Override
    public void initialize(final Double input) {

    }

    @Override
    public void acceptInput(final Scanner scanner) {
    }

    @Override
    public double getResult() throws CalculatorException {
        return 0;
    }
}
