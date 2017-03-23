package ru.lightstar.calculator.exception;

/**
 * Error of translating user input into internal representation
 *
 * @author LightStar
 * @since 0.0.1
 */
public class ParserException extends Exception {

    /**
     * Construct <code>ParserException</code> object
     */
    public ParserException() {
        super();
    }

    /**
     * Construct <code>ParserException</code> object
     *
     * @param message error description
     */
    public ParserException(String message) {
        super(message);
    }
}
