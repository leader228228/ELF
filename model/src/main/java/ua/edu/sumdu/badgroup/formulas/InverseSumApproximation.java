package ua.edu.sumdu.badgroup.formulas;

public class InverseSumApproximation extends Formula {
    public InverseSumApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    @Override
    double count(double arg) {
        return 1 / (freeCoef + argCoef * arg);
    }
}
