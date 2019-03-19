package ua.edu.sumdu.badgroup.formulas;

import ua.edu.sumdu.badgroup.common.Formulas;

public abstract class Formula {
    private Formulas type;
    protected double argCoef;
    protected double freeCoef;
    abstract double count(double arg);

    public Formula(double argCoef, double freeCoef) {
        this.argCoef = argCoef;
        this.freeCoef = freeCoef;
    }
}
