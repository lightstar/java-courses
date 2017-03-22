package ru.lightstar.calculate.operation;

import ru.lightstar.calculate.exception.CalculateException;

/**
 * Base operation class
 *
 * @author LightStar
 * @since 0.0.1
 */
public abstract class Operation {
    /**
     * Type of operation
     */
    private final Type type;

    /**
     * Constructs <code>Operation</code> object
     *
     * @param type type of operation
     */
    public Operation(final Type type) {
        this.type = type;
    }

    /**
     * Run this operation
     *
     * @param leftOperand left operand
     * @param rightOperand right operand
     * @return result
     * @throws CalculateException thrown on calculation error (such as divide by zero)
     */
    public abstract double run(final double leftOperand, final double rightOperand) throws CalculateException;

    /**
     * Get operation type
     *
     * @return operation type
     */
    public Type getType() {
        return type;
    }

    /**
     * Operation types
     */
    public enum Type {
        PLUS,
        MINUS,
        MUL,
        DIV,
        EXP
    }
}
