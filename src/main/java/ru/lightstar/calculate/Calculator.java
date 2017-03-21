package ru.lightstar.calculate;

import ru.lightstar.calculate.exception.CalculateException;

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
    public void run(final Operation operation, final double value) throws CalculateException {
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
                    throw new CalculateException("Can't divide by zero");
                }
                this.result /= value;
                break;
            case EXP:
                this.result = Math.pow(this.result, value);
                break;
            default:
                throw new CalculateException(String.format("Unknown operation: '%s'", operation.name()));
        }
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
     * Set current value of calculation
     *
     * @param value new value of calculation
     */
    public void setResult(double value) {
        this.result = value;
    }

    /**
     * Clean calculation result
     */
    public void cleanResult() {
        this.setResult(0);
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
