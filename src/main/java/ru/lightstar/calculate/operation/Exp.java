package ru.lightstar.calculate.operation;

import ru.lightstar.calculate.exception.CalculateException;

/**
 * 'Exponent' operation
 *
 * @author LightStar
 * @since 0.0.1
 */
public class Exp extends Operation {

    /**
     * Constructs <code>Exp</code> operation object
     */
    public Exp() {
        super(Type.EXP);
    }

    /**
     * @inheritDoc
     */
    @Override
    public double run(double leftOperand, double rightOperand) throws CalculateException {
        return Math.pow(leftOperand, rightOperand);
    }
}
