package com.company.rafles.shapes;

import java.util.ArrayList;

/**
 * Created by rwozn on 24.11.2016.
 */
public class ConvexHull {
    private ArrayList<Point> points;

    public ConvexHull(Point... points) {
        for(Point point: points) {
            this.points.add(point);
        }
    }

    public ConvexHull(ArrayList<Point> points) {
        this.points = points;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
    public int getSize() {
        return points.size();
    }
    public Point getPoint(int n) {
        return points.get(n);
    }

    @Override
    public String toString() {
        return "ConvexHull{" +
                "points=" + points.toString() +
                '}';
    }
}
