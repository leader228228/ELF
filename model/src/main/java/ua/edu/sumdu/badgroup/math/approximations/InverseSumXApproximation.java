package ua.edu.sumdu.badgroup.math.approximations;

public class InverseSumXApproximation extends Formula {
    public InverseSumXApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    public InverseSumXApproximation() {
    }

    @Override
    double count(double arg) {
        return arg / (freeCoef + argCoef * arg);
    }

    @Override
    public double argLinear(double arg) {
        return 1 / arg;
    }

    @Override
    public double valLinear(double val) {
        return 1 / val;
    }
}
