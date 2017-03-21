package ru.lightstar.calculate;

import java.io.*;

/**
 * Base class for runner tests
 *
 * @author LightStar
 * @since 0.0.1
 */
public abstract class MainTest {
    /**
     * System-dependent line separator
     */
    protected static final String LN = System.getProperty("line.separator");

    /**
     * Substitutes standard output stream with byte array stream
     *
     * @return output stream backed by byte array
     */
    protected OutputStream mockStandardOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }

    /**
     * Substitutes standard input stream with byte array stream
     *
     * @param buf byte buffer used as content of byte array stream
     */
    protected void mockStandardInput(final byte[] buf) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(buf);
        System.setIn(inputStream);
    }
}
