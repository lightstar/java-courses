package ru.lightstar.calculator.operation;

import ru.lightstar.calculator.exception.CalculateException;

/**
 * 'Plus' operation
 *
 * @author LightStar
 * @since 0.0.1
 */
public class Plus extends Operation {

    /**
     * Constructs <code>Plus</code> operation object
     */
    public Plus() {
        super(Type.PLUS);
    }

    /**
     * @inheritDoc
     */
    @Override
    public double run(double leftOperand, double rightOperand) throws CalculateException {
        return leftOperand + rightOperand;
    }
}
