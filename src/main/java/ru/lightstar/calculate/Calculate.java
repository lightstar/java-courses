package ru.lightstar.calculate;

/**
 * Calculation object
 */
public class Calculate {

    private double result;

    /**
     * Calculation object
     */
    public Calculate() {
        this(0);
    }

    /**
     * Calculation object
     * @param init initial value of calculation
     */
    public Calculate(final double init) {
        this.result = init;
    }

    /**
     * Run operation with current value of calculation using provided operand
     *
     * @param operation operation
     * @param value operand
     */
    public void run(final Operation operation, final double value) {
        switch(operation) {
            case PLUS:
                this.result += value;
                break;
            case MINUS:
                this.result -= value;
                break;
            case MUL:
                this.result *= value;
                break;
            case DIV:
                if (value == 0) {
                    throw new IllegalArgumentException("Can't divide by zero");
                }
                this.result /= value;
                break;
            case EXP:
                this.result = Math.pow(this.result, value);
                break;
            default:
                throw new IllegalArgumentException("Unknown operation");
        }
    }

    /**
     * Parsing operation string
     * @param operationString input string
     * @return operation value
     */
    public Operation parseOperationString(final String operationString) {
        final Operation operation;

        switch (operationString) {
            case "+":
                operation = Calculate.Operation.PLUS;
                break;
            case "-":
                operation = Calculate.Operation.MINUS;
                break;
            case "*":
                operation = Calculate.Operation.MUL;
                break;
            case "/":
                operation = Calculate.Operation.DIV;
                break;
            case "^":
                operation = Calculate.Operation.EXP;
                break;
            default:
                throw new IllegalArgumentException(String.format("Unknown operation '%s'", operationString));
        }

        return operation;
    }

    /**
     * Get result of calculation
     * @return result
     */
    public double getResult() {
        return result;
    }

    /**
     * Operations used in calculations
     */
    public enum Operation {
        PLUS,
        MINUS,
        MUL,
        DIV,
        EXP
    }
}
