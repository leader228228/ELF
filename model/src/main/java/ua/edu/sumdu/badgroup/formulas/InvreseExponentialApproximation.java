package ua.edu.sumdu.badgroup.formulas;

public class InvreseExponentialApproximation extends Formula {
    public InvreseExponentialApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    @Override
    double count(double arg) {
        return Math.exp(freeCoef + argCoef / arg);
    }
}
