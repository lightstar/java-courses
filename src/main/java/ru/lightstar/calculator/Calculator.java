package ru.lightstar.calculator;

import ru.lightstar.calculator.exception.CalculateException;
import ru.lightstar.calculator.operation.Operation;

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
        super();
        this.result = init;
    }

    /**
     * Run operation with current value of calculation using provided operand
     *
     * @param operation operation
     * @param value     operand
     * @throws CalculateException thrown when you try divide by zero
     */
    public void run(final Operation operation, final double value) throws CalculateException {
        this.result = operation.run(this.result, value);
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
    public void setResult(final double value) {
        this.result = value;
    }

    /**
     * Clean calculation result
     */
    public void cleanResult() {
        this.setResult(0);
    }
}
