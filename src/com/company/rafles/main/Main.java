package com.company.rafles.main;

import com.company.rafles.AreaCounter.CountArea;
import com.company.rafles.AreaCounter.MonteCarlo;
import com.company.rafles.ConvexCreateMethod.ConvexMerge;
import com.company.rafles.ConvexCreateMethod.Jarvis;
import com.company.rafles.shapes.ConvexHull;
import com.company.rafles.shapes.Point;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Point> punkty= new ArrayList<>();
        punkty.add(new Point(2,4));
        punkty.add(new Point(4,4));
        punkty.add(new Point(4,6));
        punkty.add(new Point(6,4));
        punkty.add(new Point(4,2));
        punkty.add(new Point(2,2));


        Jarvis jarvis = new Jarvis();
        ConvexHull convexHull = jarvis.convexHull(punkty);

        System.out.println(convexHull);


        CountArea mc = new MonteCarlo();
        mc.estimate(convexHull,7,7);


    }
}
