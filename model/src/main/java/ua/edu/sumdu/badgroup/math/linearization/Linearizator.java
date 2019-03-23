package ua.edu.sumdu.badgroup.math.linearization;

import javax.naming.OperationNotSupportedException;

/**
 *  The interface provides converting methods of constants and variables that help during linearization
 * */
public interface Linearizator {
    double argLinear(double arg);
    double valLinear(double val);
    double freeCoefLinear(double freeCoef);
    double argCoefLinear(double argCoef);
    double freeCoef(double freeCoefLinear);
    double argCoef(double argCoefLinear);
}
