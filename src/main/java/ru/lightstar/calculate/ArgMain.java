package ru.lightstar.calculate;

/**
 * ArgMain class, used as runner for <code>Calculator</code> object
 *
 * @author LightStar
 * @since 0.0.1
 */
public class ArgMain {

    /**
     * Entry point
     *
     * @param args operands and operations, one by one.<br>
     *             Example: <i>1 + 2 * 3</i>
     */
    public static void main(final String[] args) {
        if (args.length < 3 || ((args.length - 1) % 2 != 0)) {
            System.out.println("Wrong parameters");
            return;
        }

        try {
            double firstOperand = Double.valueOf(args[0]);
            Calculator calculator = new Calculator(firstOperand);

            for (int i = 1; i < args.length; i += 2) {
                double nextOperand = Double.valueOf(args[i + 1]);
                String operationString = args[i];
                calculator.run(operationString, nextOperand);
            }

            System.out.println(String.format("Result: %.2f", calculator.getResult()));

        } catch (NumberFormatException e) {
            System.out.println(String.format("Can't parse number %s",e.getMessage().toLowerCase()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
