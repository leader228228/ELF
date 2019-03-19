package ua.edu.sumdu.badgroup.formulas;

public class LinearApproximation extends Formula {
    public LinearApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    @Override
    double count(double arg) {
        return freeCoef + argCoef * arg;
    }
}
