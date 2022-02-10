package javaphase1.Lesson1Assignment;

import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Calculator {

    public Double result;
    private LinkedHashMap<String, IOperation> operationHashMap;

    public Calculator() {
        //initialize LinkedHashMap as it is ordered based on insertion
        //or read from properties file
        this.operationHashMap = new LinkedHashMap<>();
        operationHashMap.put("+", new SumOperation());
        operationHashMap.put("-", new DifferenceOperation());
        operationHashMap.put("*", new MulOperation());
        operationHashMap.put("/", new DivOperation());
        operationHashMap.put("c", new ClearOperation());

        result = 0.0;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.displayMenu();
        Scanner scanner = new Scanner(System.in);
        String strOperator = "";
        calculator.initialize(scanner);
        System.out.println("Please enter the operator from above menu");
        strOperator = scanner.nextLine();

        while (true) {
            switch (strOperator) {
                case "q":
                    return;
                case "c":
                    calculator.applyOperation(strOperator, scanner);
                    System.out.println("Computational result =" + calculator.getResult());
                    calculator.initialize(scanner);
                    System.out.println("Please enter the operator from above menu");
                    strOperator = scanner.nextLine();

                    break;
                default: {
                    try {
                        calculator.applyOperation(strOperator, scanner);
                        System.out.println("Computational result = " + calculator.getResult());
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        calculator.reset();
                        System.out.println("Computational result = " + calculator.getResult());
                        calculator.initialize(scanner);
                    } finally {
                        System.out.println("Please enter the operator from above menu");
                        strOperator = scanner.nextLine();
                    }

                }
            }
        }
    }

    public Double getResult() {
        return result;
    }

    public IOperation getOperation(final String operator) {

        if (operationHashMap.containsKey(operator)) {
            return operationHashMap.get(operator);
        }
        throw new InputMismatchException("Invalid Operator");
    }

    public void applyOperation(final String operator, final Scanner scanner) throws CalculatorException {
        IOperation operation = getOperation(operator);
        operation.initialize(result);
        operation.acceptInput(scanner);
        result = operation.getResult();
    }

    public void initialize(final Scanner scanner) throws CalculatorException {
        result = CalculatorInputUtil.acceptNumberInput(scanner);
    }

    public void reset() {
        result = 0.0;
    }

    public void displayMenu() {

        System.out.println("Operations are:");
        for (String operation : operationHashMap.keySet()) {
            System.out.println(operation + " to "
                    + operationHashMap.get(operation).getName());
        }
    }


}

