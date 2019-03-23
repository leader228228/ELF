package ua.edu.sumdu.badgroup.math.approximations;

public class InverseLogSumApproximation extends Formula {
    public InverseLogSumApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    public InverseLogSumApproximation() {
    }

    @Override
    double count(double arg) {
        return 1 / (freeCoef + argCoef * Math.log(arg));
    }

    @Override
    public double valLinear(double val) {
        return 1 / val;
    }

    @Override
    public double argLinear(double arg) {
        return Math.log(arg);
    }
}
