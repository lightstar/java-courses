package ru.lightstar.calculate.parser;

import ru.lightstar.calculate.exception.ParserException;
import ru.lightstar.calculate.operation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <code>OperationParser</code> object used to parse operations entered by user and convert
 * them into <code>Operation</code> objects
 *
 * @author LightStar
 * @since 0.0.1
 */
public class OperationParser {

    /**
     * Collection of all known operations
     */
    private final Map<String, Operation> operations;

    /**
     * Constructs <code>OperationParser</code> object
     */
    public OperationParser() {
        operations = new HashMap<>();
        operations.put("+", new Plus());
        operations.put("-", new Minus());
        operations.put("*", new Mul());
        operations.put("/", new Div());
        operations.put("^", new Exp());
    }

    /**
     * Try to parse operation string, converting it to {@link Operation} object
     *
     * @param operationString input string
     * @return operation object
     * @throws ParserException thrown when string contains unknown operation
     */
    public Operation parse(final String operationString) throws ParserException {
        if (!operations.containsKey(operationString)) {
            throw new ParserException(String.format("Unknown operation '%s'", operationString));
        }

        return operations.get(operationString);
    }
}
