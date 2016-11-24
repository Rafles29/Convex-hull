package com.company.rafles.main;

import com.company.rafles.ConvexCreateMethod.ConvexMerge;
import com.company.rafles.ConvexCreateMethod.Jarvis;
import com.company.rafles.shapes.ConvexHull;
import com.company.rafles.shapes.Point;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Point> punkty= new ArrayList<>();
        punkty.add(new Point(1,2));
        punkty.add(new Point(5,3));
        punkty.add(new Point(2,1));
        ConvexHull convexHull = new ConvexHull(punkty);
        System.out.println(convexHull);

        System.out.println();
        System.out.println();
        Jarvis jar = new Jarvis();
        ConvexHull ch = jar.create(punkty);
        System.out.println(ch);


       /* PointInsideCheck pc = new GeoPointInside();
        pc.check(convexHull,p,5);
        pc.check(convexHull,r,5);
        pc.check(convexHull,s,5);

        CountArea mc = new MonteCarlo();
        mc.estimate(convexHull,7,7);*/


    }
}
