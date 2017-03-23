package ru.lightstar.calculator;

import org.junit.Test;
import ru.lightstar.calculator.exception.ParserException;
import ru.lightstar.calculator.parser.OperandParser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for <code>OperandParser</code> class
 *
 * @author LightStar
 * @since 0.0.1
 */
public class OperandParserTest {

    /**
     * Test number parsing
     */
    @Test
    public void whenNumberStringThenResult() throws ParserException {
        OperandParser operandParser = new OperandParser();
        double result = operandParser.parse("3");
        assertThat(result, is(3d));
    }

    /**
     * Test not a number parsing
     */
    @Test(expected = ParserException.class)
    public void whenNotANumberThenException() throws ParserException {
        OperandParser operandParser = new OperandParser();
        operandParser.parse("a");
    }
}
