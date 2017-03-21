package ru.lightstar.calculate;

import ru.lightstar.calculate.exception.CalculateException;
import ru.lightstar.calculate.exception.ValidateException;

import java.util.Scanner;

/**
 * InteractMain class, used as runner for <code>Calculator</code> object
 *
 * @author LightStar
 * @since 0.0.1
 */
public class InteractMain {

    /**
     * Entry point of <code>InteractMain</code> runner
     *
     * @param args not used because this runner is interactive
     */
    public static void main(final String[] args) {
        InteractMain interactMain = new InteractMain();
        interactMain.init();
        interactMain.run();
        interactMain.close();
    }

    /**
     * Scanner used for user input
     */
    final private Scanner scanner;

    /**
     * Used to parse and validate user input
     */
    final private Validator validator;

    /**
     * Used to calculate result
     */
    final private Calculator calculator;

    /**
     * Construct <code>InteractMain</code> object
     */
    public InteractMain() {
        this.validator = new Validator();
        this.calculator = new Calculator();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Initialize calculator object by asking user for initial value
     */
    public void init() {
        boolean isInitialized = false;

        do {
            try {
                System.out.println("Enter initial value: ");
                String initialValueString = this.scanner.next();
                this.calculator.setResult(this.validator.parseDouble(initialValueString));
                isInitialized = true;
            } catch (ValidateException e) {
                System.out.println(e.getMessage());
            }
        } while (!isInitialized);
    }

    /**
     * Run calculation by asking user of values and operations to calculate
     */
    public void run() {
        String exit = "";

        while (!exit.toLowerCase().equals("yes")) {
            try {
                System.out.println("Enter operation (+, -, *, /, ^ or clean to clean result): ");
                String operationString = this.scanner.next();
                if (operationString.equals("clean")) {
                    calculator.cleanResult();
                } else {
                    System.out.println("Enter operand: ");
                    String operandString = this.scanner.next();
                    calculator.run(this.validator.parseOperationString(operationString),
                            this.validator.parseDouble(operandString));
                }

                System.out.println(String.format("Result: %.2f", calculator.getResult()));
            } catch (ValidateException | CalculateException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Exit? [yes/no]:");
            exit = this.scanner.next();
        }

        System.out.println("Good bye!");
    }

    public void close() {
        this.scanner.close();
    }
}
