package ua.edu.sumdu.badgroup.formulas;

public class InverseLogSumApproximation extends Formula {
    public InverseLogSumApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    @Override
    double count(double arg) {
        return 1 / (freeCoef + argCoef * Math.log(arg));
    }
}
