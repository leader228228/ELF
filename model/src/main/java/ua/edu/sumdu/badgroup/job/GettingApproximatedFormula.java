package ua.edu.sumdu.badgroup.job;

import org.apache.commons.math3.linear.*;
import ua.edu.sumdu.badgroup.math.Formulas;
import ua.edu.sumdu.badgroup.entities.Data;
import ua.edu.sumdu.badgroup.entities.Point;
import ua.edu.sumdu.badgroup.math.Formula;
import ua.edu.sumdu.badgroup.math.approximations.FormulaFactory;

public class GettingApproximatedFormula implements Job<Formula> {
    private Data data;
    private Formula formula;

    public GettingApproximatedFormula(Formulas formulaType, Data data) {
        formula = FormulaFactory.getFormula(formulaType);
        this.data = data;
    }

    @Override
    public Formula execute() {
        double n = data.size();
        double argLinearSum = 0;
        double valLinearSum = 0;
        double argLinearSqrSum = 0;
        double argValLinearMultSum = 0;
        for (Point point : data.getPoints()) {
            argLinearSum += formula.argLinear(point.getArg());
            valLinearSum += formula.valLinear(point.getValue());
            argLinearSqrSum += Math.pow(formula.argLinear(point.getArg()), 2);
            argValLinearMultSum += formula.argLinear(point.getArg()) * formula.valLinear(point.getValue());
        }
        RealMatrix coefficients = new Array2DRowRealMatrix(
                new double[][] {{n, argLinearSum}, {argLinearSum, argLinearSqrSum}}, false);
        DecompositionSolver solver = new SingularValueDecomposition(coefficients).getSolver();
        RealVector constants = new ArrayRealVector(new double[] {valLinearSum, argValLinearMultSum}, false);
        RealVector solution = solver.solve(constants);
        double freeCoef = formula.freeCoef(solution.getEntry(0));
        double argCoef = formula.argCoef(solution.getEntry(1));
        formula.setArgCoef(argCoef);
        formula.setFreeCoef(freeCoef);
        return formula;
    }
}
