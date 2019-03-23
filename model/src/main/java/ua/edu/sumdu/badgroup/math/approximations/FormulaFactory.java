package ua.edu.sumdu.badgroup.math.approximations;

import ua.edu.sumdu.badgroup.common.Formulas;

public class FormulaFactory {
    /**
     *  This is just a factory-method that returns a formula specified by the {@code type}
     *
     * @param           type a type of required formula
     *
     * @return          an instance of {@code Formula} corresponding to the passed type
     * */
    public static Formula getFormula(Formulas type) {
        switch (type) {
            case LINEAR:
                return new LinearApproximation();
            case LOGARITHMIC:
                return new LogApproximation();
            case INVERSE:
                return new InverseApproximation();
            case EXPONENTIAL:
                return new ExponentialApproximation();
            case POWER:
                return new PowerApproximation();
            case INVERSE_EXPONENTIAL:
                return new InverseApproximation();
            case INVERSE_SUM:
                return new InverseSumApproximation();
            case INVERSE_LOG_SUM:
                return new InverseLogSumApproximation();
            case INVERSE_SUM_X:
                return new InverseSumXApproximation();
                default:
                    throw new UnsupportedOperationException();
        }
    }
}
