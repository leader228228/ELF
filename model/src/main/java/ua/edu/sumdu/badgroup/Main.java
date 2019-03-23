package ua.edu.sumdu.badgroup;

import ua.edu.sumdu.badgroup.job.DeviateCalculation;
import ua.edu.sumdu.badgroup.job.FisherCriticalValue;
import ua.edu.sumdu.badgroup.job.Job;
import ua.edu.sumdu.badgroup.math.Formulas;
import ua.edu.sumdu.badgroup.entities.Data;
import ua.edu.sumdu.badgroup.entities.Point;
import ua.edu.sumdu.badgroup.job.GettingApproximatedFormula;

import java.util.HashSet;
import java.util.Set;

public class Main
{
    public static void main(String[] args) {
        // GettingApproximatedFormula TEST [PASSED]
        /*Point point1 = new Point(2,14);
        Point point2 = new Point(5,21);
        Point point3 = new Point(7,25);
        Point point4 = new Point(8,26);
        Point point5 = new Point(10,30);
        Point point6 = new Point(12,34);
        Point point7 = new Point(15,41);
        Point point8 = new Point(20,54);
        Point point9 = new Point(25,67);
        Point point10 = new Point(40,110);

        Set<Point> points = new HashSet<>();

        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
        points.add(point5);
        points.add(point6);
        points.add(point7);
        points.add(point8);
        points.add(point9);
        points.add(point10);

        Data data = new Data(points);
        GettingApproximatedFormula getFormula = new GettingApproximatedFormula(Formulas.INVERSE_LOG_SUM, data);
        System.out.println(getFormula.execute());*/

        Job job = new FisherCriticalValue(10, 0.99);
        System.out.println(((FisherCriticalValue) job).execute());

    }
}
