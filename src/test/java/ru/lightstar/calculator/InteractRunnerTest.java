package ru.lightstar.calculator;

import org.junit.Test;

import java.io.OutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Tests for <code>InteractRunner</code> class
 *
 * @author LightStar
 * @since 0.0.1
 */
public class InteractRunnerTest extends RunnerTest {

    /**
     * Test clean operation
     */
    @Test
    public void whenCleanThenResultIsZero() {
        this.testInputAndOutput(new String[]{
                        "5",
                        "clean",
                        "yes"
                }, new String[]{
                        "Enter initial value: ",
                        "Enter operation (+, -, *, /, ^) or word 'clean' to clean result: ",
                        "Result: 0,00",
                        "Exit? [yes/no]:",
                        "Good bye!"
                }
        );
    }

    /**
     * Test arithmetic operations
     */
    @Test
    public void whenOperationsThenResult() {
        this.testInputAndOutput(new String[]{
                        "5",
                        "+",
                        "2",
                        "no",
                        "*",
                        "3",
                        "no",
                        "^",
                        "2",
                        "no",
                        "/",
                        "3",
                        "yes"
                }, new String[]{
                        "Enter initial value: ",
                        "Enter operation (+, -, *, /, ^) or word 'clean' to clean result: ",
                        "Enter operand: ",
                        "Result: 7,00",
                        "Exit? [yes/no]:",
                        "Enter operation (+, -, *, /, ^) or word 'clean' to clean result: ",
                        "Enter operand: ",
                        "Result: 21,00",
                        "Exit? [yes/no]:",
                        "Enter operation (+, -, *, /, ^) or word 'clean' to clean result: ",
                        "Enter operand: ",
                        "Result: 441,00",
                        "Exit? [yes/no]:",
                        "Enter operation (+, -, *, /, ^) or word 'clean' to clean result: ",
                        "Enter operand: ",
                        "Result: 147,00",
                        "Exit? [yes/no]:",
                        "Good bye!"
                }
        );
    }

    /**
     * Test that it is impossible to run after close
     */
    @Test(expected = IllegalStateException.class)
    public void whenRunAfterCloseThenIllegalStateException() {
        InteractRunner interactRunner = new InteractRunner();
        interactRunner.close();
        interactRunner.run();
    }

    /**
     * Generic test for interact runner
     *
     * @param inputLines  lines used in place of standard input stream
     * @param outputLines expected output lines in standard output stream
     */
    private void testInputAndOutput(String[] inputLines, String[] outputLines) {
        OutputStream outputStream = this.mockStandardOutput();
        this.mockStandardInput(this.joinLines(inputLines).getBytes());

        InteractRunner interactRunner = new InteractRunner();
        interactRunner.init();
        interactRunner.run();
        interactRunner.close();

        assertThat(outputStream.toString(), is(this.joinLines(outputLines)));
    }

    /**
     * Helper method used to join lines in one string
     *
     * @param lines joined lines
     * @return result string
     */
    private String joinLines(String[] lines) {
        return String.format("%s%s", String.join(LN, lines), LN);
    }
}
