package ru.lightstar.calculate;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Tests for <code>Calculator</code> object
 *
 * @author LightStar
 * @since 0.0.1
 */
public class CalculatorTest {

    /**
     * Test PLUS operation
     */
    @Test
    public void whenAddThenResult() {
        Calculator calculator = new Calculator(5);
        calculator.run(Calculator.Operation.PLUS, 3);
        assertThat(calculator.getResult(), is(8d));
    }

    /**
     * Test MINUS operation
     */
    @Test
    public void whenSubThenResult() {
        Calculator calculator = new Calculator(5);
        calculator.run(Calculator.Operation.MINUS, 3);
        assertThat(calculator.getResult(), is(2d));
    }

    /**
     * Test MUL operation
     */
    @Test
    public void whenMulThenResult() {
        Calculator calculator = new Calculator(5);
        calculator.run(Calculator.Operation.MUL, 3);
        assertThat(calculator.getResult(), is(15d));
    }

    /**
     * Test DIV operation
     */
    @Test
    public void whenDivThenResult() {
        Calculator calculator = new Calculator(15);
        calculator.run(Calculator.Operation.DIV, 3);
        assertThat(calculator.getResult(), is(5d));
    }

    /**
     * Test division by zero
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenDivZeroThenException() {
        Calculator calculator = new Calculator(15);
        calculator.run(Calculator.Operation.DIV, 0);
    }

    /**
     * Test EXP operation
     */
    @Test
    public void whenExpThenResult() {
        Calculator calculator = new Calculator(2);
        calculator.run(Calculator.Operation.EXP, 3);
        assertThat(calculator.getResult(), is(8d));
    }

    /**
     * Test multiple operations
     */
    @Test
    public void whenMultipleOperationsThenResult() {
        Calculator calculator = new Calculator();
        calculator.run(Calculator.Operation.PLUS, 2);
        calculator.run(Calculator.Operation.MUL,3);
        calculator.run(Calculator.Operation.MINUS, 1);
        calculator.run(Calculator.Operation.EXP, 2);
        assertThat(calculator.getResult(), is(25d));
    }

    /**
     * Test PLUS operation, represented by string
     */
    @Test
    public void whenAddStringThenResult() {
        Calculator calculator = new Calculator(5);
        calculator.run("+", 3);
        assertThat(calculator.getResult(), is(8d));
    }

    /**
     * Test PLUS operation parsing
     */
    @Test
    public void whenPlusStringThenPlusOperation() {
        Calculator calculator = new Calculator();
        Calculator.Operation operation = calculator.parseOperationString("+");
        assertThat(operation, is(Calculator.Operation.PLUS));
    }

    /**
     * Test MINUS operation parsing
     */
    @Test
    public void whenMinusStringThenMinusOperation() {
        Calculator calculator = new Calculator();
        Calculator.Operation operation = calculator.parseOperationString("-");
        assertThat(operation, is(Calculator.Operation.MINUS));
    }

    /**
     * Test MUL operation parsing
     */
    @Test
    public void whenMulStringThenMulOperation() {
        Calculator calculator = new Calculator();
        Calculator.Operation operation = calculator.parseOperationString("*");
        assertThat(operation, is(Calculator.Operation.MUL));
    }

    /**
     * Test DIV operation parsing
     */
    @Test
    public void whenDivStringThenDivOperation() {
        Calculator calculator = new Calculator();
        Calculator.Operation operation = calculator.parseOperationString("/");
        assertThat(operation, is(Calculator.Operation.DIV));
    }

    /**
     * Test EXP operation parsing
     */
    @Test
    public void whenExpStringThenExpOperation() {
        Calculator calculator = new Calculator();
        Calculator.Operation operation = calculator.parseOperationString("^");
        assertThat(operation, is(Calculator.Operation.EXP));
    }

    /**
     * Test unknown operation parsing
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenUnsupportedStringThenException() {
        Calculator calculator = new Calculator();
        Calculator.Operation operation = calculator.parseOperationString("&");
    }

    /**
     * Test clean result
     */
    @Test
    public void whenCleanResultThenZeroResult() {
        Calculator calculator = new Calculator(5);
        calculator.run(Calculator.Operation.PLUS, 2);
        calculator.cleanResult();
        assertThat(calculator.getResult(), is(0d));
    }
}
