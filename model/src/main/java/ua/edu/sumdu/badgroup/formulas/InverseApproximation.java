package ua.edu.sumdu.badgroup.formulas;

public class InverseApproximation extends Formula {
    public InverseApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    @Override
    double count(double arg) {
        return freeCoef + argCoef / arg;
    }
}
