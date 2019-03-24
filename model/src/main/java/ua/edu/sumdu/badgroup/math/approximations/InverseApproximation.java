package ua.edu.sumdu.badgroup.math.approximations;

import ua.edu.sumdu.badgroup.math.Formula;

public class InverseApproximation extends Formula {
    public InverseApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    public InverseApproximation() {
    }

    @Override
    public double count(double arg) {
        return freeCoef + argCoef / arg;
    }

    @Override
    public double argLinear(double arg) {
        return 1 / arg;
    }
}
