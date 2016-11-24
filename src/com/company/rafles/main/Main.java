package com.company.rafles.main;

import com.company.rafles.AreaCounter.CountArea;
import com.company.rafles.AreaCounter.MonteCarlo;
import com.company.rafles.Merge.ConvexMerge;
import com.company.rafles.SimplePointInShapeChecker.GeoPointInside;
import com.company.rafles.SimplePointInShapeChecker.PointInsideCheck;
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

        ArrayList<Point> punktyDrugie= new ArrayList<>();
        punktyDrugie.add(new Point(4,2));
        punktyDrugie.add(new Point(4,4));
        punktyDrugie.add(new Point(6,3));
        ConvexHull convexHull2 = new ConvexHull(punktyDrugie);
        System.out.println(convexHull2);

        ArrayList<Point> tmp= new ArrayList<>();
        ConvexMerge.mergePart(convexHull,tmp,0,2);
        ConvexMerge.mergePart(convexHull2,tmp,0,2);
        System.out.println(tmp.toString());


       /* PointInsideCheck pc = new GeoPointInside();
        pc.check(convexHull,p,5);
        pc.check(convexHull,r,5);
        pc.check(convexHull,s,5);

        CountArea mc = new MonteCarlo();
        mc.estimate(convexHull,7,7);*/


    }
}
