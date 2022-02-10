package javaphase1.Lesson1Assignment;

import java.util.Scanner;

public class MulOperation implements IOperation {
    Double operand1;
    Double operand2;

    @Override
    public String getName() {
        return "Multiplication";
    }

    @Override
    public void initialize(final Double input) {
        operand1 = input;
    }

    @Override
    public void acceptInput(final Scanner scanner) {
        operand2 = CalculatorInputUtil.acceptNumberInput(scanner);
    }

    @Override
    public double getResult() throws CalculatorException {
        return operand1 * operand2;
    }
}
