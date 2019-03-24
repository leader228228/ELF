package ua.edu.sumdu.badgroup.math.approximations;

import ua.edu.sumdu.badgroup.math.Formula;

public class LinearApproximation extends Formula {
    public LinearApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    public LinearApproximation() {
    }

    @Override
    public double count(double arg) {
        return freeCoef + argCoef * arg;
    }
}
