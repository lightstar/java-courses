package ru.lightstar.calculate;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Tests for <code>Main</code>, <code>Calculate</code> object runner
 * @author LightStar
 * @since 0.0.1
 */
public class MainTest {
    private static final String LN = System.getProperty("line.separator");

    /**
     * Test run with no args
     */
    @Test
    public void whenNoArgThenWrongParameters() {
        OutputStream outputStream = this.mockStandartOutput();
        Main.main(new String[]{});
        assertThat(outputStream.toString(), is(String.format("Wrong parameters%s", LN)));
    }

    /**
     * Test run with three args
     */
    @Test
    public void whenThreeArgThenResult() {
        OutputStream outputStream = this.mockStandartOutput();
        Main.main(new String[]{"5","+","3"});
        assertThat(outputStream.toString(), is(String.format("Result: 8,00%s", LN)));
    }

    /**
     * Test run with five args
     */
    @Test
    public void whenFiveArgThenResult() {
        OutputStream outputStream = this.mockStandartOutput();
        Main.main(new String[]{"5","+","3","^","2"});
        assertThat(outputStream.toString(), is(String.format("Result: 64,00%s", LN)));
    }

    /**
     * Test giving not a number
     */
    @Test
    public void whenNotNumberThenError() {
        OutputStream outputStream = this.mockStandartOutput();
        Main.main(new String[]{"a","+","3"});
        assertThat(outputStream.toString(), is(String.format("Can't parse number for input string: \"a\"%s", LN)));
    }

    /**
     * Test division by zero
     */
    @Test
    public void whenDivByZeroThenError() {
        OutputStream outputStream = this.mockStandartOutput();
        Main.main(new String[]{"1","/","0"});
        assertThat(outputStream.toString(), is(String.format("Can't divide by zero%s", LN)));
    }

    /**
     * Test unsupported operation
     */
    @Test
    public void whenUnsupportedOperationThenError() {
        OutputStream outputStream = this.mockStandartOutput();
        Main.main(new String[]{"2","&","3"});
        assertThat(outputStream.toString(), is(String.format("Unknown operation '&'%s", LN)));
    }

    private OutputStream mockStandartOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }
}
