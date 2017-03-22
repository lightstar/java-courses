package ru.lightstar.calculate;

import ru.lightstar.calculate.exception.CalculateException;
import ru.lightstar.calculate.exception.ParserException;
import ru.lightstar.calculate.parser.OperandParser;
import ru.lightstar.calculate.parser.OperationParser;

/**
 * ArgRunner class, used as runner for <code>Calculator</code> object
 *
 * @author LightStar
 * @since 0.0.1
 */
public class ArgRunner {

    /**
     * Runner args
     */
    private final String[] args;

    /**
     * Used to parse operands entered by user
     */
    private final OperandParser operandParser;

    /**
     * Used to parse operations entered by user
     */
    private final OperationParser operationParser;

    /**
     * Used to calculate result
     */
    private final Calculator calculator;

    /**
     * This runner can run only if this flag is true
     */
    private final boolean isReady;

    /**
     * Construct <code>ArgRunner</code> object
     *
     * @param args operands and operations, one by one.<br>
     *             Example: <i>1 + 2 * 3</i>
     */
    public ArgRunner(final String[] args) {
        this.args = args;
        this.operandParser = new OperandParser();
        this.operationParser = new OperationParser();
        this.calculator = new Calculator();

        if (this.args.length < 3 || ((this.args.length - 1) % 2 != 0)) {
            System.out.println("Wrong parameters");
            this.isReady = false;
        } else {
            this.isReady = true;
        }
    }

    /**
     * Run this runner if possible
     */
    public void run() {
        if (!this.isReady) {
            return;
        }

        try {
            this.calculator.setResult(this.operandParser.parse(this.args[0]));

            for (int i = 1; i < this.args.length; i += 2) {
                this.calculator.run(this.operationParser.parse(this.args[i]),
                        this.operandParser.parse(this.args[i + 1]));
            }

            System.out.println(String.format("Result: %.2f", this.calculator.getResult()));
        } catch (ParserException | CalculateException e) {
            System.out.println(e.getMessage());
        }
    }
}
