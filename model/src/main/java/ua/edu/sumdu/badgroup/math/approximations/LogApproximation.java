package ua.edu.sumdu.badgroup.math.approximations;

public class LogApproximation extends Formula {
    public LogApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    public LogApproximation() {
    }

    @Override
    double count(double arg) {
        return freeCoef + argCoef * Math.log(arg);
    }

    @Override
    public double argLinear(double arg) {
        return Math.log(arg);
    }
}
