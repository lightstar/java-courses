package ru.lightstar.calculate;

import java.util.Scanner;

/**
 * InteractMain class, used as runner for <code>Calculator</code> object
 *
 * @author LightStar
 * @since 0.0.1
 */
public class InteractMain {

    /**
     * Entry point
     *
     * @param args not used because this runner is interactive
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter initial value: ");
        double initialValue = scanner.nextDouble();
        Calculator calculator = new Calculator(initialValue);

        String exit = "";
        while (!exit.toLowerCase().equals("yes")) {
            System.out.println("Enter operation (+, -, *, /, ^ or clean to clean result): ");
            String operationString = scanner.next();
            if (operationString.equals("clean")) {
                calculator.cleanResult();
            } else {
                System.out.println("Enter operand: ");
                double operand = scanner.nextDouble();
                calculator.run(operationString, operand);
            }

            System.out.println(String.format("Result: %.2f", calculator.getResult()));

            System.out.println("Exit? [yes/no]:");
            exit = scanner.next();
        }

        scanner.close();

        System.out.println("Good bye!");
    }
}
