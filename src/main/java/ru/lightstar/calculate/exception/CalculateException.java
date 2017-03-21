package ru.lightstar.calculate.exception;

/**
 * Calculation error exception
 */
public class CalculateException extends Exception {
    /**
     * Construct <code>CalculateException</code> object
     */
    public CalculateException() {
    }

    /**
     * Construct <code>CalculateException</code> object
     * @param message error description
     */
    public CalculateException(String message) {
        super(message);
    }
}
