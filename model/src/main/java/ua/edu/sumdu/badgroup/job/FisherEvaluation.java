package ua.edu.sumdu.badgroup.job;

import ua.edu.sumdu.badgroup.entities.Data;
import ua.edu.sumdu.badgroup.entities.Point;
import ua.edu.sumdu.badgroup.exceptions.ELFException;
import ua.edu.sumdu.badgroup.math.Formula;

public class FisherEvaluation implements Job<Double> {
    private Formula formula;
    private Data data;
    public FisherEvaluation(Formula formula, Data data) {
        this.formula = formula;
        this.data = data;
    }
    @Override
    public Double execute() throws ELFException {
        double n = data.size();
        double argLinearSum = 0;
        double valLinearSum = 0;
        double argValLinearMultSum = 0;
        double valLinearSqrSum = 0;
        for (Point point : data.getPoints()) {
            argLinearSum += formula.argLinear(point.getArg());
            valLinearSum += formula.valLinear(point.getValue());
            valLinearSqrSum += Math.pow(formula.valLinear(point.getValue()), 2);
            argValLinearMultSum += formula.argLinear(point.getArg()) * formula.valLinear(point.getValue());
        }
        double rSqr = (formula.getArgCoef() * (n * argValLinearMultSum - argLinearSum * valLinearSqrSum))
                / (n * valLinearSqrSum - Math.pow(valLinearSum, 2));
        return (rSqr * (n - (2 - 1) /*constant for this case*/ - 1))
                / (/*constant for this case*/(2 - 1) * (1 - rSqr));
    }
}
