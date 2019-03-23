package ua.edu.sumdu.badgroup.math.approximations;

public class ExponentialApproximation extends Formula {
    public ExponentialApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    public ExponentialApproximation() {
    }

    @Override
    double count(double arg) {
        return freeCoef * Math.pow(argCoef, arg);
    }

    @Override
    public double valLinear(double val) {
        return Math.log(val);
    }

    @Override
    public double argCoefLinear(double argCoef) {
        return Math.log(argCoef);
    }

    @Override
    public double freeCoefLinear(double freeCoef) {
        return Math.log(freeCoef);
    }

    @Override
    public double freeCoef(double freeCoefLinear) {
        return Math.exp(freeCoefLinear);
    }

    @Override
    public double argCoef(double argCoefLinear) {
        return Math.exp(argCoefLinear);
    }
}