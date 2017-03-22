package ru.lightstar.calculate;

/**
 * InteractMain class, used as entry point for <code>InteractRunner</code> runner
 *
 * @author LightStar
 * @since 0.0.1
 */
public class InteractMain {

    /**
     * Entry point with {@link InteractRunner} runner
     *
     * @param args not used because this runner is interactive
     */
    public static void main(final String[] args) {
        final InteractRunner interactRunner = new InteractRunner();
        interactRunner.init();
        interactRunner.run();
        interactRunner.close();
    }

}
