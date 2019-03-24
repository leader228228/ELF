package ua.edu.sumdu.badgroup.job;

import ua.edu.sumdu.badgroup.math.Formulas;
import ua.edu.sumdu.badgroup.entities.Data;
import ua.edu.sumdu.badgroup.entities.Point;

import java.util.*;
/**
 *  This implementation handles with the first part of the workflow -
 * calculating the mean deviation of 9 general functions
 * */
public class DeviateCalculation implements Job<Map<Formulas, Properties>> {
    public static final String ARGUMENT_AVERAGE = "ARG_Mean";
    public static final String VALUE_AVERAGE = "VAL_Mean";
    public static final String INTERPOLATED_VALUE = "INTERP_VAL";
    public static final String DEVIATE = "DEVIATE";
    private Data data;
    public DeviateCalculation(Data data) {
        this.data = data;
    }
    @Override
    public Map<Formulas, Properties> execute() {
        List<Point> points = new ArrayList<>(data.getPoints());
        List<Double> args = new ArrayList<>(points.size());
        List<Double> values = new ArrayList<>(points.size());
        for (Point point : points) {
            args.add(point.getArg());
            values.add(point.getValue());
        }
        double argArithmMean = arithMean(args);
        double argGeomMean = geomMean(args);
        double argHarmonicMean = harmonicMean(args);
        double valueArithmMean = arithMean(values);
        double valueGeomMean = geomMean(values);
        double valueHarmonicMean = harmonicMean(values);
        Map<Formulas, Properties> map = new HashMap<>();
        map.put(Formulas.LINEAR,
                createTableRowProperties(argArithmMean, valueArithmMean, interpolateLineary(data, argArithmMean)));
        map.put(Formulas.LOGARITHMIC,
                createTableRowProperties(argGeomMean, valueArithmMean, interpolateLineary(data, argGeomMean)));
        map.put(Formulas.INVERSE,
                createTableRowProperties(argHarmonicMean, valueArithmMean, interpolateLineary(data, argHarmonicMean)));
        map.put(Formulas.EXPONENTIAL,
                createTableRowProperties(argArithmMean, valueGeomMean, interpolateLineary(data, argArithmMean)));
        map.put(Formulas.POWER,
                createTableRowProperties(argGeomMean, valueGeomMean, interpolateLineary(data, argGeomMean)));
        map.put(Formulas.INVERSE_EXPONENTIAL,
                createTableRowProperties(argHarmonicMean, valueGeomMean, interpolateLineary(data, argHarmonicMean)));
        map.put(Formulas.INVERSE_SUM,
                createTableRowProperties(argArithmMean, valueHarmonicMean, interpolateLineary(data, argArithmMean)));
        map.put(Formulas.INVERSE_LOG_SUM,
                createTableRowProperties(argGeomMean, valueHarmonicMean, interpolateLineary(data, argGeomMean)));
        map.put(Formulas.INVERSE_SUM_X,
                createTableRowProperties(argHarmonicMean, valueHarmonicMean, interpolateLineary(data, argHarmonicMean)));
        return map;

    }

    private Properties createTableRowProperties(double argMean, double valueMean, double interpolatedVal) {
        Properties properties = new Properties();
        properties.setProperty(ARGUMENT_AVERAGE, String.valueOf(argMean));
        properties.setProperty(VALUE_AVERAGE, String.valueOf(valueMean));
        properties.setProperty(INTERPOLATED_VALUE, String.valueOf(interpolatedVal));
        properties.setProperty(DEVIATE, String.valueOf((interpolatedVal - valueMean) / interpolatedVal));
        return properties;
    }

    private double arithMean(Collection<Double> collection) {
        double average = 0;
        for (double d : collection) {
            average += d;
        }
        return average / collection.size();
    }

    private double geomMean(Collection<Double> collection) {
        double mult = 1;
        for (double d : collection) {
            mult *= d;
        }
        return Math.pow(mult, 1.0d / collection.size());
    }

    private double harmonicMean(Collection<Double> collection) {
        double result = 0;
        for (Double d : collection) {
            result += 1 / d;
        }
        return 1 / result;
    }

    /**
     * Counts an ~Y value
     * */
    private double interpolateLineary(Data data, double argMean) {
        if (data.size() == 0) {
            throw new IllegalArgumentException("Empty data set");
        }
        List<Point> points = new ArrayList<>(data.getPoints());
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Double.compare(o1.getArg(), o2.getArg());
            }
        });
        if (data.size() == 1) {
            Iterator<Point> iterator = data.getPoints().iterator();
            Point singlePoint = iterator.next();
            if (singlePoint.getArg() == argMean) {
                return singlePoint.getValue();
            } else {
                throw new IllegalArgumentException("Unable to interpolate by single point");
            }
        }
        if (argMean > points.get(points.size() - 1).getArg() || argMean < points.get(0).getArg()) {
            throw new IllegalArgumentException(argMean
                    + " does not belong to the ["
                    + points.get(0).getArg()
                    + ";" + points.get(points.size() - 1).getArg()
                    + "]");
        }
        int indexAfter = -1;
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).getArg() >= argMean) {
                indexAfter = i;
                break;
            }
        }
        double argPrev = points.get(indexAfter - 1).getArg();
        double argNext = points.get(indexAfter).getArg();
        double valPrev = points.get(indexAfter - 1).getValue();
        double valNext = points.get(indexAfter).getValue();
        return valPrev + ((valNext - valPrev) / (argNext - argPrev)) * (argMean - argPrev);
    }
}
