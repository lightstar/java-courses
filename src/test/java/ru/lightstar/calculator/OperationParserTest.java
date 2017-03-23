package ru.lightstar.calculator;

import org.junit.Test;
import ru.lightstar.calculator.exception.ParserException;
import ru.lightstar.calculator.operation.*;
import ru.lightstar.calculator.parser.OperationParser;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Tests for <code>OperandParser</code> object
 *
 * @author LightStar
 * @since 0.0.1
 */
public class OperationParserTest {

    /**
     * Test 'Plus' operation parsing
     */
    @Test
    public void whenPlusStringThenPlusOperation() throws ParserException {
        this.testOperationClass("+", Plus.class);
    }

    /**
     * Test 'Minus' operation parsing
     */
    @Test
    public void whenMinusStringThenMinusOperation() throws ParserException {
        this.testOperationClass("-", Minus.class);
    }

    /**
     * Test 'Multiply' operation parsing
     */
    @Test
    public void whenMulStringThenMulOperation() throws ParserException {
        this.testOperationClass("*", Mul.class);
    }

    /**
     * Test 'Division' operation parsing
     */
    @Test
    public void whenDivStringThenDivOperation() throws ParserException {
        this.testOperationClass("/", Div.class);

    }

    /**
     * Test 'Exponent' operation parsing
     */
    @Test
    public void whenExpStringThenExpOperation() throws ParserException {
        this.testOperationClass("^", Exp.class);

    }

    /**
     * Test unknown operation parsing
     */
    @Test(expected = ParserException.class)
    public void whenUnsupportedStringThenException() throws ParserException {
        OperationParser operationParser = new OperationParser();
        operationParser.parse("&");
    }

    /**
     * Generic test for parsing operations
     *
     * @param input input string
     * @param expectedClass expected class of parsed operation
     */
    private void testOperationClass(String input, Class<? extends Operation> expectedClass) throws ParserException {
        OperationParser operationParser = new OperationParser();
        Operation operation = operationParser.parse(input);
        assertThat(operation, instanceOf(expectedClass));
    }
}
