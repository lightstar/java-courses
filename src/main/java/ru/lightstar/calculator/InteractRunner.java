package ru.lightstar.calculator;

import ru.lightstar.calculator.exception.CalculateException;
import ru.lightstar.calculator.exception.ParserException;
import ru.lightstar.calculator.parser.OperandParser;
import ru.lightstar.calculator.parser.OperationParser;

import java.util.Scanner;

/**
 * <code>InteractRunner</code> runner runs program by asking user of operands and operations
 *
 * @author LightStar
 * @since 0.0.1
 */
public class InteractRunner {

    /**
     * Used for user input
     */
    private final Scanner scanner;

    /**
     * Used to parse operands entered by user
     */
    private final OperandParser operandParser;

    /**
     * Used to parse operations entered by user
     */
    private final OperationParser operationParser;

    /**
     * Used to calculator result
     */
    private final Calculator calculator;

    /**
     * Closed flag. You can't run this runner anymore if it is closed
     */
    private boolean isClosed;

    /**
     * Construct <code>InteractRunner</code> object
     */
    public InteractRunner() {
        super();
        this.operandParser = new OperandParser();
        this.operationParser = new OperationParser();
        this.calculator = new Calculator();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Initialize calculator object by asking user for initial value
     */
    public void init() {
        boolean isInitialized = false;

        do {
            try {
                System.out.println("Enter initial value: ");
                String initialValueString = this.scanner.next();
                this.calculator.setResult(this.operandParser.parse(initialValueString));
                isInitialized = true;
            } catch (ParserException e) {
                System.out.println(e.getMessage());
            }
        } while (!isInitialized);
    }

    /**
     * Run calculation by asking user of values and operations to calculator
     *
     * @throws IllegalStateException thrown if this <code>InteractRunner</code> object is closed
     */
    public void run() {
        if (this.isClosed) {
            throw new IllegalStateException("Runner is closed, can't run anymore");
        }

        do {
            try {
                this.processOperation();
            } catch (ParserException | CalculateException e) {
                System.out.println(e.getMessage());
            }
        } while (!this.isUserWantsToExit());

        System.out.println("Good bye!");
    }

    /**
     * Close runner. You can't call run method after this.
     */
    public void close() {
        this.scanner.close();
        this.isClosed = true;
    }

    /**
     * Process one operation by asking user of operation string and operand
     *
     * @throws ParserException thrown when given operation or operand is not valid
     * @throws CalculateException thrown on calculation error, for example divide by zero
     */
    private void processOperation() throws ParserException, CalculateException {
        final String operationString = this.askUser("Enter operation (+, -, *, /, ^) or word 'clean' to clean result: ");

        if (operationString.toLowerCase().equals("clean")) {
            calculator.cleanResult();
        } else {
            final String operandString = this.askUser("Enter operand: ");
            calculator.run(this.operationParser.parse(operationString), this.operandParser.parse(operandString));
        }

        System.out.println(String.format("Result: %.2f", calculator.getResult()));
    }

    /**
     * Ask user if he/she wants to exit
     *
     * @return true if user wants to exit
     */
    private boolean isUserWantsToExit() {
        return this.askUser("Exit? [yes/no]:").toLowerCase().equals("yes");
    }

    /**
     * Ask user a question
     *
     * @param question question string
     * @return user's answer
     */
    private String askUser(final String question) {
        System.out.println(question);
        return this.scanner.next();
    }
}
