package ua.edu.sumdu.badgroup.math.approximations;

public class LinearApproximation extends Formula {
    public LinearApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }

    public LinearApproximation() {
    }

    @Override
    double count(double arg) {
        return freeCoef + argCoef * arg;
    }
}
