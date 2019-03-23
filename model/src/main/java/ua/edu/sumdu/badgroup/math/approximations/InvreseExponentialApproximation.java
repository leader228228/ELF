package ua.edu.sumdu.badgroup.math.approximations;

import ua.edu.sumdu.badgroup.math.Formula;

public class InvreseExponentialApproximation extends Formula {
    public InvreseExponentialApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    public InvreseExponentialApproximation() {
    }

    @Override
    protected double count(double arg) {
        return Math.exp(freeCoef + argCoef / arg);
    }

    @Override
    public double argLinear(double arg) {
        return 1 / arg;
    }

    @Override
    public double valLinear(double val) {
        return Math.log(val);
    }
}
