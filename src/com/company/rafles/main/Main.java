package com.company.rafles.main;

import com.company.rafles.AreaCounter.CountArea;
import com.company.rafles.AreaCounter.MonteCarlo;
import com.company.rafles.SimplePointInShapeChecker.GeoPointInside;
import com.company.rafles.SimplePointInShapeChecker.PointInsideCheck;
import com.company.rafles.shapes.ConvexHull;
import com.company.rafles.shapes.Point;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Point> punkty= new ArrayList<>();
        punkty.add(new Point(2,2));
        punkty.add(new Point(2,6));
        punkty.add(new Point(6,2));
        ConvexHull convexHull = new ConvexHull(punkty);
        System.out.println(convexHull);
        Point p = new Point(3,3);
        Point r = new Point(0,1);
        Point s = new Point(3,4.5);
        System.out.println(convexHull.maxY());
        System.out.println(convexHull.minY());

       /* PointInsideCheck pc = new GeoPointInside();
        pc.check(convexHull,p,5);
        pc.check(convexHull,r,5);
        pc.check(convexHull,s,5);

        CountArea mc = new MonteCarlo();
        mc.estimate(convexHull,7,7);*/


    }
}
