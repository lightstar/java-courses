package ru.lightstar.calculator;

/**
 * ArgMain class, used as entry point for <code>ArgRunner</code> runner
 *
 * @author LightStar
 * @since 0.0.1
 */
public class ArgMain {

    /**
     * Entry point with {@link ArgRunner} runner
     *
     * @param args operands and operations, one by one.<br>
     *             Example: <i>1 + 2 * 3</i>
     */
    public static void main(final String[] args) {
        final ArgRunner argRunner = new ArgRunner(args);
        argRunner.run();
    }
}
