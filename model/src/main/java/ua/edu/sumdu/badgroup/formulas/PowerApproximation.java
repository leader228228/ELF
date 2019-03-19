package ua.edu.sumdu.badgroup.formulas;

public class PowerApproximation extends Formula {
    public PowerApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    @Override
    double count(double arg) {
        return freeCoef * Math.pow(arg, argCoef);
    }
}
