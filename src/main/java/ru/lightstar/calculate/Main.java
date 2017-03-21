package ru.lightstar.calculate;

/**
 * Main class, used as runner for <code>Calculate</code> object
 * @author LightStar
 * @since 0.0.1
 */
public class Main {

    /**
     * Entry point
     * @param args operands and operations, one by one.<br>
     *             Example: <i>1 + 2 * 3</i>
     */
    public static void main(String[] args) {
        if (args.length < 3 || ((args.length - 1) % 2 != 0)) {
            System.out.println("Wrong parameters");
            return;
        }

        try {
            double firstOperand = Double.valueOf(args[0]);
            Calculate calculate = new Calculate(firstOperand);

            for (int i = 1; i < args.length; i += 2) {
                double nextOperand = Double.valueOf(args[i + 1]);
                String operationString = args[i];
                calculate.run(operationString, nextOperand);
            }

            System.out.println(String.format("Result: %.2f", calculate.getResult()));

        } catch (NumberFormatException e) {
            System.out.println(String.format("Can't parse number %s",e.getMessage().toLowerCase()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
