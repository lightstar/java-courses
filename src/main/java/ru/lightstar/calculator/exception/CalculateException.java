package ru.lightstar.calculator.exception;

/**
 * Error of calculation
 *
 * @author LightStar
 * @since 0.0.1
 */
public class CalculateException extends Exception {

    /**
     * Construct <code>CalculateException</code> object
     */
    public CalculateException() {
        super();
    }

    /**
     * Construct <code>CalculateException</code> object
     *
     * @param message error description
     */
    public CalculateException(String message) {
        super(message);
    }
}
