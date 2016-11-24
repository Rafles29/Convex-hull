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
    public void addPoint(Point p) {this.points.add(p); }
    public Point removePoint(int n){return this.points.remove(n);}

    @Override
    public String toString() {
        return "ConvexHull{" +
                "points=" + points.toString() +
                '}';
    }
    public int maxY() {
        if(getSize() == 0) {
            return 0;
        }
        else {
            int i=0, counter=0;
            double tmp = getPoint(0).getY();
            for(Point point:this.points) {
                if(tmp < point.getY())
                {
                    tmp = point.getY();
                    counter=i;
                }
                i++;
            }
            return counter;
        }

    }
    public int minY() {
        if(getSize() == 0) {
            return 0;
        }
        else {
            int i=0, counter=0;
            double tmp = getPoint(0).getY();
            for(Point point:this.points) {
                if(tmp > point.getY())
                {
                    tmp = point.getY();
                    counter=i;
                }
                i++;
            }
            return counter;
        }

    }
}
