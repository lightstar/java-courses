package ru.lightstar.calculator.parser;

import ru.lightstar.calculator.exception.ParserException;

/**
 * <code>OperandParser</code> object used to parse operands entered by user
 *
 * @author LightStar
 * @since 0.0.1
 */
public class OperandParser {

    /**
     * Try to parse operand string
     *
     * @param operandString input string
     * @return result value
     * @throws ParserException thrown when string doesn't contain a valid number
     */
    public double parse(final String operandString) throws ParserException {
        try {
            return Double.valueOf(operandString);
        } catch(NumberFormatException e) {
            throw new ParserException(String.format("'%s' is not a number", operandString));
        }
    }
}
