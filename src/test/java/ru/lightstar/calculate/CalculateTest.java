package ru.lightstar.calculate;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Tests for <code>Calculate</code> object
 * @author LightStar
 * @since 0.0.1
 */
public class CalculateTest {

    /**
     * Test PLUS operation
     */
    @Test
    public void whenAddThenResult() {
        Calculate calculate = new Calculate(5);
        calculate.run(Calculate.Operation.PLUS, 3);
        assertThat(calculate.getResult(), is(8d));
    }

    /**
     * Test MINUS operation
     */
    @Test
    public void whenSubThenResult() {
        Calculate calculate = new Calculate(5);
        calculate.run(Calculate.Operation.MINUS, 3);
        assertThat(calculate.getResult(), is(2d));
    }

    /**
     * Test MUL operation
     */
    @Test
    public void whenMulThenResult() {
        Calculate calculate = new Calculate(5);
        calculate.run(Calculate.Operation.MUL, 3);
        assertThat(calculate.getResult(), is(15d));
    }

    /**
     * Test DIV operation
     */
    @Test
    public void whenDivThenResult() {
        Calculate calculate = new Calculate(15);
        calculate.run(Calculate.Operation.DIV, 3);
        assertThat(calculate.getResult(), is(5d));
    }

    /**
     * Test division by zero
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenDivZeroThenException() {
        Calculate calculate = new Calculate(15);
        calculate.run(Calculate.Operation.DIV, 0);
    }

    /**
     * Test EXP operation
     */
    @Test
    public void whenExpThenResult() {
        Calculate calculate = new Calculate(2);
        calculate.run(Calculate.Operation.EXP, 3);
        assertThat(calculate.getResult(), is(8d));
    }

    /**
     * Test multiple operations
     */
    @Test
    public void whenMultipleOperationsThenResult() {
        Calculate calculate = new Calculate();
        calculate.run(Calculate.Operation.PLUS, 2);
        calculate.run(Calculate.Operation.MUL,3);
        calculate.run(Calculate.Operation.MINUS, 1);
        calculate.run(Calculate.Operation.EXP, 2);
        assertThat(calculate.getResult(), is(25d));
    }

    /**
     * Test PLUS operation, represented by string
     */
    @Test
    public void whenAddStringThenResult() {
        Calculate calculate = new Calculate(5);
        calculate.run("+", 3);
        assertThat(calculate.getResult(), is(8d));
    }

    /**
     * Test PLUS operation parsing
     */
    @Test
    public void whenPlusStringThenPlusOperation() {
        Calculate calculate = new Calculate();
        Calculate.Operation operation = calculate.parseOperationString("+");
        assertThat(operation, is(Calculate.Operation.PLUS));
    }

    /**
     * Test MINUS operation parsing
     */
    @Test
    public void whenMinusStringThenMinusOperation() {
        Calculate calculate = new Calculate();
        Calculate.Operation operation = calculate.parseOperationString("-");
        assertThat(operation, is(Calculate.Operation.MINUS));
    }

    /**
     * Test MUL operation parsing
     */
    @Test
    public void whenMulStringThenMulOperation() {
        Calculate calculate = new Calculate();
        Calculate.Operation operation = calculate.parseOperationString("*");
        assertThat(operation, is(Calculate.Operation.MUL));
    }

    /**
     * Test DIV operation parsing
     */
    @Test
    public void whenDivStringThenDivOperation() {
        Calculate calculate = new Calculate();
        Calculate.Operation operation = calculate.parseOperationString("/");
        assertThat(operation, is(Calculate.Operation.DIV));
    }

    /**
     * Test EXP operation parsing
     */
    @Test
    public void whenExpStringThenExpOperation() {
        Calculate calculate = new Calculate();
        Calculate.Operation operation = calculate.parseOperationString("^");
        assertThat(operation, is(Calculate.Operation.EXP));
    }

    /**
     * Test unknown operation parsing
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenUnsupportedStringThenException() {
        Calculate calculate = new Calculate();
        Calculate.Operation operation = calculate.parseOperationString("&");
    }
}
