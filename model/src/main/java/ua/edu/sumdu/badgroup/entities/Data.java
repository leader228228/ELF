package ua.edu.sumdu.badgroup.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    private Set<Point> points = new HashSet<>();
    public Set<Point> getPoints() {
        return points;
    }

    public Data(Collection<Point> points) {
        this.points.addAll(points);
    }

    public Data(Map<Double, Double> points) {
        for (Map.Entry<Double, Double> entry : points.entrySet()) {
            this.points.add(new Point(entry.getKey(), entry.getValue()));
        }
    }

    public boolean add(Point point) {
        return points.add(point);
    }

    public int size() {
        return points.size();
    }
}
