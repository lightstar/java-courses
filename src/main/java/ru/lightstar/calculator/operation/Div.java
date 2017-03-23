package ru.lightstar.calculator.operation;

import ru.lightstar.calculator.exception.CalculateException;

/**
 * 'Division' operation
 *
 * @author LightStar
 * @since 0.0.1
 */
public class Div extends Operation {

    /**
     * Constructs <code>Div</code> operation object
     */
    public Div() {
        super(Type.DIV);
    }

    /**
     * @inheritDoc
     */
    @Override
    public double run(double leftOperand, double rightOperand) throws CalculateException {
        if (rightOperand == 0) {
            throw new CalculateException("Can't divide by zero");
        }
        return leftOperand / rightOperand;
    }
}
