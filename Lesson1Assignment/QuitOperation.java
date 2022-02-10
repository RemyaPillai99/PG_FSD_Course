package javaphase1.Lesson1Assignment;

import java.util.Scanner;

public class QuitOperation implements IOperation {
    @Override
    public String getName() {
        return "Quit";
    }

    @Override
    public void initialize(Double input) {

    }

    @Override
    public void acceptInput(Scanner scanner) {

    }

    @Override
    public double getResult() throws CalculatorException {
        return 0;
    }
}
