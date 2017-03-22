package ru.lightstar.calculate;

import org.junit.Test;
import ru.lightstar.calculate.exception.CalculateException;
import ru.lightstar.calculate.operation.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Tests for <code>Calculator</code> class
 *
 * @author LightStar
 * @since 0.0.1
 */
public class CalculatorTest {

    /**
     * Test 'Plus' operation
     */
    @Test
    public void whenAddThenResult() throws CalculateException {
        Calculator calculator = new Calculator(5d);
        calculator.run(new Plus(), 3d);
        assertThat(calculator.getResult(), is(8d));
    }

    /**
     * Test 'Minus' operation
     */
    @Test
    public void whenSubThenResult() throws CalculateException {
        Calculator calculator = new Calculator(5d);
        calculator.run(new Minus(), 3d);
        assertThat(calculator.getResult(), is(2d));
    }

    /**
     * Test 'Multiply' operation
     */
    @Test
    public void whenMulThenResult() throws CalculateException {
        Calculator calculator = new Calculator(5d);
        calculator.run(new Mul(), 3d);
        assertThat(calculator.getResult(), is(15d));
    }

    /**
     * Test 'Division' operation
     */
    @Test
    public void whenDivThenResult() throws CalculateException {
        Calculator calculator = new Calculator(15d);
        calculator.run(new Div(), 3d);
        assertThat(calculator.getResult(), is(5d));
    }

    /**
     * Test division by zero
     */
    @Test(expected = CalculateException.class)
    public void whenDivZeroThenException() throws CalculateException {
        Calculator calculator = new Calculator(15d);
        calculator.run(new Div(), 0d);
    }

    /**
     * Test 'Exponent' operation
     */
    @Test
    public void whenExpThenResult() throws CalculateException {
        Calculator calculator = new Calculator(2d);
        calculator.run(new Exp(), 3d);
        assertThat(calculator.getResult(), is(8d));
    }

    /**
     * Test multiple operations
     */
    @Test
    public void whenMultipleOperationsThenResult() throws CalculateException {
        Calculator calculator = new Calculator();
        calculator.run(new Plus(), 2d);
        calculator.run(new Mul(),3d);
        calculator.run(new Minus(), 1d);
        calculator.run(new Exp(), 2d);
        assertThat(calculator.getResult(), is(25d));
    }

    /**
     * Test clean result
     */
    @Test
    public void whenCleanResultThenZeroResult() throws CalculateException {
        Calculator calculator = new Calculator(5d);
        calculator.run(new Plus(), 2d);
        calculator.cleanResult();
        assertThat(calculator.getResult(), is(0d));
    }

    /**
     * Test set result
     */
    @Test
    public void whenSetResultThenResult() throws CalculateException {
        Calculator calculator = new Calculator();
        calculator.setResult(5d);
        assertThat(calculator.getResult(), is(5d));
    }
}
