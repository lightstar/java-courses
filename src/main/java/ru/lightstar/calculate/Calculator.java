package ru.lightstar.calculate;

/**
 * Calculation object
 *
 * @author LightStar
 * @since 0.0.1
 */
public class Calculator {

    /**
     * result value
     */
    private double result;

    /**
     * Constructs <code>Calculator</code> object with zero initial value
     */
    public Calculator() {
        this(0);
    }

    /**
     * Construct <code>Calculation</code> object with given initial value
     *
     * @param init initial value of calculation
     */
    public Calculator(final double init) {
        this.result = init;
    }

    /**
     * Run operation with current value of calculation using provided operand
     *
     * @param operation operation
     * @param value     operand
     */
    public void run(final Operation operation, final double value) {
        switch (operation) {
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
                throw new IllegalArgumentException(String.format("Unknown operation: '%s'", operation.name()));
        }
    }

    /**
     * Run operation with current value of calculation using provided operand
     *
     * @param operationString operation, presented as string. Must be one of: <i>+, -, *, /, ^</i>.<br>
     *                        Otherwise {@link IllegalArgumentException} is thrown.
     * @param value           operand
     */
    public void run(final String operationString, final double value) {
        this.run(this.parseOperationString(operationString), value);
    }

    /**
     * Parsing operation string
     *
     * @param operationString input string
     * @return operation value
     */
    public Operation parseOperationString(final String operationString) {
        final Operation operation;

        switch (operationString) {
            case "+":
                operation = Calculator.Operation.PLUS;
                break;
            case "-":
                operation = Calculator.Operation.MINUS;
                break;
            case "*":
                operation = Calculator.Operation.MUL;
                break;
            case "/":
                operation = Calculator.Operation.DIV;
                break;
            case "^":
                operation = Calculator.Operation.EXP;
                break;
            default:
                throw new IllegalArgumentException(String.format("Unknown operation '%s'", operationString));
        }

        return operation;
    }

    /**
     * Get result of calculation
     *
     * @return result
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Clean calculation result
     */
    public void cleanResult() {
        this.result = 0;
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
