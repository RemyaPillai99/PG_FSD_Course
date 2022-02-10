package javaphase1.Lesson1Assignment;

import java.util.Scanner;

public class DivOperation implements IOperation {
    Double operand1;
    Double operand2;
    @Override
    public String getName() {
        return "Division";
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
        if (operand2 == 0) {
            throw new ArithmeticException("Error! In Division denominator cannot be 0!");
        }
        return Double.parseDouble(String.format("%.2f",  operand1 / operand2));
    }
}
