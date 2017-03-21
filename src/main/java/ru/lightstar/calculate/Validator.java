package ru.lightstar.calculate;

import ru.lightstar.calculate.exception.ValidateException;

/**
 * Validator object used to validate user input and convert it to internal representation
 *
 * @author LightStar
 * @since 0.0.1
 */
public class Validator {

    /**
     * Try to parse operation string, converting it to {@link Calculator.Operation}
     *
     * @param operationString input string
     * @return operation value
     */
    public Calculator.Operation parseOperationString(final String operationString) throws ValidateException {
        final Calculator.Operation operation;

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
                throw new ValidateException(String.format("Unknown operation '%s'", operationString));
        }

        return operation;
    }

    /**
     * Try to parse double string
     *
     * @param doubleString input string
     * @return result value
     */
    public double parseDouble(final String doubleString) throws ValidateException {
        try {
            return Double.valueOf(doubleString);
        } catch(NumberFormatException e) {
            throw new ValidateException(String.format("'%s' is not a number", doubleString));
        }
    }
}
