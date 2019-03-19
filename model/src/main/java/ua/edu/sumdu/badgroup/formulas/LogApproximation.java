package ua.edu.sumdu.badgroup.formulas;

public class LogApproximation extends Formula {
    public LogApproximation(double argCoef, double freeCoef) {
        super(argCoef, freeCoef);
    }


    @Override
    double count(double arg) {
        return freeCoef + argCoef * Math.log(arg);
    }
}
