package ua.edu.sumdu.badgroup.formulas;

public class ExponentialApproximation extends Formula {
    public ExponentialApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    @Override
    double count(double arg) {
        return freeCoef * Math.pow(argCoef, arg);
    }
}