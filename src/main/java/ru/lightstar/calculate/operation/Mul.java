package ru.lightstar.calculate.operation;

import ru.lightstar.calculate.exception.CalculateException;

/**
 * 'Multiply' operation
 *
 * @author LightStar
 * @since 0.0.1
 */
public class Mul extends Operation {

    /**
     * Constructs <code>Mul</code> operation object
     */
    public Mul() {
        super(Type.MUL);
    }

    /**
     * @inheritDoc
     */
    @Override
    public double run(double leftOperand, double rightOperand) throws CalculateException {
        return leftOperand * rightOperand;
    }
}
