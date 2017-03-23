package ru.lightstar.calculator;

import org.junit.Test;
import ru.lightstar.calculator.exception.CalculateException;
import ru.lightstar.calculator.operation.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for <code>Operation</code> subclasses
 *
 * @author LightStar
 * @since 0.0.1
 */
public class OperationTest {

    /**
     * Test 'Plus' operation
     */
    @Test
    public void whenPlusOperationThenResult() throws CalculateException {
        Operation operation = new Plus();
        assertThat(operation.run(2d, 3d), is(5d));
    }

    /**
     * Test 'Minus' operation
     */
    @Test
    public void whenMinusOperationThenResult() throws CalculateException {
        Operation operation = new Minus();
        assertThat(operation.run(2d, 3d), is(-1d));
    }

    /**
     * Test 'Multiply' operation
     */
    @Test
    public void whenMulOperationThenResult() throws CalculateException {
        Operation operation = new Mul();
        assertThat(operation.run(2d, 3d), is(6d));
    }

    /**
     * Test 'Division' operation
     */
    @Test
    public void whenDivOperationThenResult() throws CalculateException {
        Operation operation = new Div();
        assertThat(operation.run(6d, 3d), is(2d));
    }

    /**
     * Test 'Exponent' operation
     */
    @Test
    public void whenExpOperationThenResult() throws CalculateException {
        Operation operation = new Exp();
        assertThat(operation.run(2d, 3d), is(8d));
    }

    /**
     * Test division by zero
     */
    @Test(expected = CalculateException.class)
    public void whenDivByZeroThenCalculateException() throws CalculateException {
        Operation operation = new Div();
        operation.run(6d, 0d);
    }
}
