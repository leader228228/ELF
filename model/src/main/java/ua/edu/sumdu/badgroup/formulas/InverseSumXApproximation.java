package ua.edu.sumdu.badgroup.formulas;

public class InverseSumXApproximation extends Formula {
    public InverseSumXApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    @Override
    double count(double arg) {
        return arg / (freeCoef + argCoef * arg);
    }
}
