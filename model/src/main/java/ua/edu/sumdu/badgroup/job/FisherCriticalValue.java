package ua.edu.sumdu.badgroup.job;

import ua.edu.sumdu.badgroup.exceptions.ELFException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FisherCriticalValue implements Job<Double> {
    private int pointsAmount;
    private double significanceLevel;

    public FisherCriticalValue(int pointsAmount, double significanceLevel) {
        if (pointsAmount < 1) {
            throw new IllegalArgumentException("Points amount must be a positive integer bu found " + pointsAmount);
        }
        if (pointsAmount > 30) {
            throw new ELFException(new UnsupportedOperationException("Currently supported only 30 points"));
        }
        this.pointsAmount = pointsAmount;
        this.significanceLevel = significanceLevel;
    }

    @Override
    public Double execute() throws ELFException {
        Map<Integer, Double> tableFisherValues95 = new HashMap<>();
        Map<Integer, Double> tableFisherValues99 = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(
                FisherCriticalValue.class.getResource(
                        "../../../../../dataFile.txt").toURI()))) {
            while (scanner.hasNextLine()) {
                int pointsNumber = scanner.nextInt();
                tableFisherValues95.put(pointsNumber, scanner.nextDouble());
                tableFisherValues99.put(pointsNumber, scanner.nextDouble());
            }
        } catch (IOException | URISyntaxException e) {
            throw new ELFException(e);
        }
        if (significanceLevel == 0.99) {
            return tableFisherValues99.get(pointsAmount);
        } else if (significanceLevel == 0.95) {
            return tableFisherValues95.get(pointsAmount);
        } else {
            throw new UnsupportedOperationException("Only 0.99 and 0.95 significance levels are supported");
        }
    }
}
