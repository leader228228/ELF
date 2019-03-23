package ua.edu.sumdu.badgroup.math.approximations;

public class InverseApproximation extends Formula {
    public InverseApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    public InverseApproximation() {
    }

    @Override
    double count(double arg) {
        return freeCoef + argCoef / arg;
    }

    @Override
    public double argLinear(double arg) {
        return 1 / arg;
    }
}
