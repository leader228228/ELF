package ua.edu.sumdu.badgroup.math.approximations;

public class PowerApproximation extends Formula {
    public PowerApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    public PowerApproximation() {
    }

    @Override
    double count(double arg) {
        return freeCoef * Math.pow(arg, argCoef);
    }

    @Override
    public double valLinear(double val) {
        return Math.log(val);
    }

    @Override
    public double freeCoefLinear(double freeCoef) {
        return Math.log(freeCoef);
    }

    @Override
    public double argLinear(double arg) {
        return Math.log(arg);
    }

    @Override
    public double freeCoef(double freeCoefLinear) {
        return Math.exp(freeCoefLinear);
    }
}
