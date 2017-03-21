package ru.lightstar.calculate;

import org.junit.Test;
import ru.lightstar.calculate.exception.ValidateException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for <code>Validator</code> object
 *
 * @author LightStar
 * @since 0.0.1
 */
public class ValidatorTest {
    /**
     * Test PLUS operation parsing
     */
    @Test
    public void whenPlusStringThenPlusOperation() throws ValidateException {
        Validator validator = new Validator();
        Calculator.Operation operation = validator.parseOperationString("+");
        assertThat(operation, is(Calculator.Operation.PLUS));
    }

    /**
     * Test MINUS operation parsing
     */
    @Test
    public void whenMinusStringThenMinusOperation() throws ValidateException {
        Validator validator = new Validator();
        Calculator.Operation operation = validator.parseOperationString("-");
        assertThat(operation, is(Calculator.Operation.MINUS));
    }

    /**
     * Test MUL operation parsing
     */
    @Test
    public void whenMulStringThenMulOperation() throws ValidateException {
        Validator validator = new Validator();
        Calculator.Operation operation = validator.parseOperationString("*");
        assertThat(operation, is(Calculator.Operation.MUL));
    }

    /**
     * Test DIV operation parsing
     */
    @Test
    public void whenDivStringThenDivOperation() throws ValidateException {
        Validator validator = new Validator();
        Calculator.Operation operation = validator.parseOperationString("/");
        assertThat(operation, is(Calculator.Operation.DIV));
    }

    /**
     * Test EXP operation parsing
     */
    @Test
    public void whenExpStringThenExpOperation() throws ValidateException {
        Validator validator = new Validator();
        Calculator.Operation operation = validator.parseOperationString("^");
        assertThat(operation, is(Calculator.Operation.EXP));
    }

    /**
     * Test unknown operation parsing
     */
    @Test(expected = ValidateException.class)
    public void whenUnsupportedStringThenException() throws ValidateException {
        Validator validator = new Validator();
        Calculator.Operation operation = validator.parseOperationString("&");
    }

    /**
     * Test number parsing
     */
    @Test
    public void whenNumberStringThenResult() throws ValidateException {
        Validator validator = new Validator();
        double result = validator.parseDouble("3");
        assertThat(result, is(3d));
    }

    /**
     * Test not a number parsing
     */
    @Test(expected = ValidateException.class)
    public void whenNotANumberThenException() throws ValidateException {
        Validator validator = new Validator();
        validator.parseDouble("a");
    }
}
