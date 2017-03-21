package ru.lightstar.calculate;

import org.junit.Test;

import java.io.OutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Tests for <code>ArgMain</code>, <code>Calculator</code> object runner
 *
 * @author LightStar
 * @since 0.0.1
 */
public class ArgMainTest extends MainTest {

    /**
     * Test run with no args
     */
    @Test
    public void whenNoArgThenWrongParameters() {
        this.testArgsAndOutput(new String[]{}, "Wrong parameters");
    }

    /**
     * Test run with three args
     */
    @Test
    public void whenThreeArgThenResult() {
        this.testArgsAndOutput(new String[]{"5", "+", "3"}, "Result: 8,00");
    }

    /**
     * Test run with five args
     */
    @Test
    public void whenFiveArgThenResult() {
        this.testArgsAndOutput(new String[]{"5", "+", "3", "^", "2"}, "Result: 64,00");
    }

    /**
     * Test giving not a number
     */
    @Test
    public void whenNotNumberThenError() {
        this.testArgsAndOutput(new String[]{"a","+","3"}, "'a' is not a number");
    }

    /**
     * Test division by zero
     */
    @Test
    public void whenDivByZeroThenError() {
        this.testArgsAndOutput(new String[]{"1","/","0"}, "Can't divide by zero");
    }

    /**
     * Test unsupported operation
     */
    @Test
    public void whenUnsupportedOperationThenError() {
        this.testArgsAndOutput(new String[]{"2","&","3"}, "Unknown operation '&'");
    }

    /**
     * Generic test for interact runner
     *
     * @param args arguments to main method
     * @param outputString expected output without trailing new line character
     */
    private void testArgsAndOutput(String[] args, String outputString) {
        OutputStream outputStream = this.mockStandardOutput();

        ArgMain argMain = new ArgMain();
        argMain.run(args);

        assertThat(outputStream.toString(), is(String.format("%s%s", outputString, LN)));
    }
}
