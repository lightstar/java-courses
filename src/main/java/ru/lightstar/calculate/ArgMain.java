package ru.lightstar.calculate;

import ru.lightstar.calculate.exception.CalculateException;
import ru.lightstar.calculate.exception.ValidateException;

/**
 * ArgMain class, used as runner for <code>Calculator</code> object
 *
 * @author LightStar
 * @since 0.0.1
 */
public class ArgMain {

    /**
     * Entry point of <code>ArgMain</code> runner
     *
     * @param args operands and operations, one by one.<br>
     *             Example: <i>1 + 2 * 3</i>
     */
    public static void main(final String[] args) {
        ArgMain argMain = new ArgMain();
        argMain.run(args);
    }

    /**
     * Run program with given args
     *
     * @param args operands and operations, one by one.<br>
     *             Example: <i>1 + 2 * 3</i>
     */
    public void run(String[] args) {
        if (args.length < 3 || ((args.length - 1) % 2 != 0)) {
            System.out.println("Wrong parameters");
            return;
        }

        try {
            Validator validator = new Validator();
            Calculator calculator = new Calculator(validator.parseDouble(args[0]));

            for (int i = 1; i < args.length; i += 2) {
                calculator.run(validator.parseOperationString(args[i]), validator.parseDouble(args[i + 1]));
            }

            System.out.println(String.format("Result: %.2f", calculator.getResult()));
        } catch (ValidateException | CalculateException e) {
            System.out.println(e.getMessage());
        }
    }
}
