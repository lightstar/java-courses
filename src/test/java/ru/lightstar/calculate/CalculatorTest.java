package ru.lightstar.calculate;

import org.junit.Test;
import ru.lightstar.calculate.exception.CalculateException;

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
    public void whenAddThenResult() throws CalculateException {
        Calculator calculator = new Calculator(5);
        calculator.run(Calculator.Operation.PLUS, 3);
        assertThat(calculator.getResult(), is(8d));
    }

    /**
     * Test MINUS operation
     */
    @Test
    public void whenSubThenResult() throws CalculateException {
        Calculator calculator = new Calculator(5);
        calculator.run(Calculator.Operation.MINUS, 3);
        assertThat(calculator.getResult(), is(2d));
    }

    /**
     * Test MUL operation
     */
    @Test
    public void whenMulThenResult() throws CalculateException {
        Calculator calculator = new Calculator(5);
        calculator.run(Calculator.Operation.MUL, 3);
        assertThat(calculator.getResult(), is(15d));
    }

    /**
     * Test DIV operation
     */
    @Test
    public void whenDivThenResult() throws CalculateException {
        Calculator calculator = new Calculator(15);
        calculator.run(Calculator.Operation.DIV, 3);
        assertThat(calculator.getResult(), is(5d));
    }

    /**
     * Test division by zero
     */
    @Test(expected = CalculateException.class)
    public void whenDivZeroThenException() throws CalculateException {
        Calculator calculator = new Calculator(15);
        calculator.run(Calculator.Operation.DIV, 0);
    }

    /**
     * Test EXP operation
     */
    @Test
    public void whenExpThenResult() throws CalculateException {
        Calculator calculator = new Calculator(2);
        calculator.run(Calculator.Operation.EXP, 3);
        assertThat(calculator.getResult(), is(8d));
    }

    /**
     * Test multiple operations
     */
    @Test
    public void whenMultipleOperationsThenResult() throws CalculateException {
        Calculator calculator = new Calculator();
        calculator.run(Calculator.Operation.PLUS, 2);
        calculator.run(Calculator.Operation.MUL,3);
        calculator.run(Calculator.Operation.MINUS, 1);
        calculator.run(Calculator.Operation.EXP, 2);
        assertThat(calculator.getResult(), is(25d));
    }

    /**
     * Test clean result
     */
    @Test
    public void whenCleanResultThenZeroResult() throws CalculateException {
        Calculator calculator = new Calculator(5);
        calculator.run(Calculator.Operation.PLUS, 2);
        calculator.cleanResult();
        assertThat(calculator.getResult(), is(0d));
    }
}
