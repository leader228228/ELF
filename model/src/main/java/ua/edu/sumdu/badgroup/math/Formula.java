package ua.edu.sumdu.badgroup.math;

import ua.edu.sumdu.badgroup.math.linearization.Linearizator;

import javax.naming.OperationNotSupportedException;

public abstract class Formula implements Linearizator {
    protected double argCoef;
    protected double freeCoef;
    public abstract double count(double arg);

    public Formula(double argCoef, double freeCoef) {
        this.argCoef = argCoef;
        this.freeCoef = freeCoef;
    }

    public Formula() {
    }

    public double getArgCoef() {
        return argCoef;
    }

    public void setArgCoef(double argCoef) {
        this.argCoef = argCoef;
    }

    public double getFreeCoef() {
        return freeCoef;
    }

    public void setFreeCoef(double freeCoef) {
        this.freeCoef = freeCoef;
    }

    @Override
    public double argLinear(double arg) {
        return arg;
    }

    @Override
    public double valLinear(double val) {
        return val;
    }

    @Override
    public double freeCoefLinear(double freeCoef) {
        return freeCoef;
    }

    @Override
    public double argCoefLinear(double argCoef) {
        return argCoef;
    }

    @Override
    public double freeCoef(double freeCoefLinear) {
        return freeCoefLinear;
    }

    @Override
    public double argCoef(double argCoefLinear) {
        return argCoefLinear;
    }

    @Override
    public String toString() {
        return "Formula{" +
                "argCoef=" + argCoef +
                ", freeCoef=" + freeCoef +
                '}';
    }
}
