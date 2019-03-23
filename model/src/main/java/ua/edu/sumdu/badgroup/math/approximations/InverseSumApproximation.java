package ua.edu.sumdu.badgroup.math.approximations;

public class InverseSumApproximation extends Formula {
    public InverseSumApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    public InverseSumApproximation() {
    }

    @Override
    double count(double arg) {
        return 1 / (freeCoef + argCoef * arg);
    }

    @Override
    public double valLinear(double val) {
        return  1 / val;
    }
}
