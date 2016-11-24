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

    public ConvexHull() {
        this.points = new ArrayList<>();
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
    public void addPoint(Point p) {this.points.add(p); }
    public Point removePoint(int n){return this.points.remove(n);}

    @Override
    public String toString() {
        return "ConvexHull{" +
                "points=" + points.toString() +
                '}';
    }

}
