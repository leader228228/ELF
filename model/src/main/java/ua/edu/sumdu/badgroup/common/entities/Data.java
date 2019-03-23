package ua.edu.sumdu.badgroup.common.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    private Set<Point> points = new HashSet<>();
    private String tag;

    public Set<Point> getPoints() {
        return points;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Data(Collection<Point> points) {
        this.points.addAll(points);
    }

    public int size() {
        return points.size();
    }
}
