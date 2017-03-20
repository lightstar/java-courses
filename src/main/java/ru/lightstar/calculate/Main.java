package ru.lightstar.calculate;

public class Main {
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
                Calculate.Operation operation = calculate.parseOperationString(args[i]);
                calculate.run(operation, nextOperand);
            }

            System.out.println(String.format("Result: %.2f", calculate.getResult()));

        } catch (NumberFormatException e) {
            System.out.println(String.format("Can't parse number %s",e.getMessage().toLowerCase()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
