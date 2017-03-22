package ru.lightstar.calculate.operation;

import ru.lightstar.calculate.exception.CalculateException;

/**
 * 'Minus' operation
 *
 * @author LightStar
 * @since 0.0.1
 */
public class Minus extends Operation {

    /**
     * Constructs <code>Minus</code> operation object
     */
    public Minus() {
        super(Type.MINUS);
    }

    /**
     * @inheritDoc
     */
    @Override
    public double run(double leftOperand, double rightOperand) throws CalculateException {
        return leftOperand - rightOperand;
    }
}
