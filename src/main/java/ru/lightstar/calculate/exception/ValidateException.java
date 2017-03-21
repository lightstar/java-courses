package ru.lightstar.calculate.exception;

/**
 * Validation error exception
 */
public class ValidateException extends Exception {
    /**
     * Construct <code>ValidateException</code> object
     */
    public ValidateException() {
    }

    /**
     * Construct <code>ValidateException</code> object
     * @param message error description
     */
    public ValidateException(String message) {
        super(message);
    }
}
