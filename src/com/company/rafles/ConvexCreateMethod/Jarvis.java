package com.company.rafles.ConvexCreateMethod;

import com.company.rafles.shapes.ConvexHull;
import com.company.rafles.shapes.Point;

import java.util.ArrayList;

/**
 * Created by rwozn on 24.11.2016.
 */
public class Jarvis {
    public ConvexHull create(ArrayList<Point> points) {

        ArrayList<Point> dest = new ArrayList<>();
        dest.add(findExtreme(points));
        Point tmp = new Point(dest.get(0).getX()-1,dest.get(0).getY());
        dest.add(findLowestAngle(points,tmp,dest.get(0)));
        /*
        * Dorobić dla reszty przypadków
        * sprawdźić funkcje countAngle oraz findLowestAngle
        * Możliwa zamiana double na BigDecimal
        *
        * */
        ConvexHull convexHull = new ConvexHull(dest);
        return convexHull;
    }
    private Point findExtreme(ArrayList<Point> points) {
        ArrayList<Point> answers = new ArrayList<>();
            double tmp = points.get(0).getY();
            for(Point point:points) {
                if(tmp > point.getY())
                {
                    answers.clear();
                    tmp = point.getY();
                    answers.add(point);
                }
                else if( tmp == point.getY()) {
                    answers.add(point);
                }
            }
            if (answers.size() == 1) {
                return answers.get(0);
            }
            else {
                int i=0;
                int counter = 0;
                tmp = answers.get(0).getX();
                for (Point point: answers) {
                    if (tmp > point.getY()) {
                        tmp = point.getY();
                        counter = i;
                    }
                    i++;
                }
                Point answer = answers.get(counter);
                return answer;
        }
    }
    private double countAngle(Point a, Point b, Point c) {

        Point vec1 = new Point(b.getX()-a.getX(),b.getY()-a.getY());
        Point vec2 = new Point(c.getX()-b.getX(),c.getY()-b.getY());

        double up = vec1.getX() * vec2.getX() + vec1.getY() * vec2.getY();
        double down = len(vec1) * len(vec2);

        double cos = up/down;
        return Math.toDegrees(Math.acos(cos));

    }
    private double len(Point a) {
        return Math.sqrt(Math.pow(a.getX(),2) + Math.pow(a.getY(),2)) ;
    }
    private Point findLowestAngle(ArrayList<Point> points, Point a, Point b) {
        double tmp = countAngle(a,b,points.get(0));
        ArrayList<Point> answers = new ArrayList<>();
        for(Point point: points) {
            if(countAngle(a,b,point) < tmp) {
                answers.clear();
                tmp = countAngle(a, b, point);
                answers.add(point);
            }
        }
        if(answers.size() == 1) {
            return answers.get(0);
        }
        else {
            tmp = answers.get(0).getY();
            int i=0, counter =0;
            for(Point point:points) {
                if(tmp > point.getY())
                {
                    tmp = point.getY();
                    counter = i;
                }
                i++;
            }
            Point answer = answers.get(counter);
            return answer;
        }
    }
}
