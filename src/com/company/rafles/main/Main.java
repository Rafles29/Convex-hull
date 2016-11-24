package com.company.rafles.main;

import com.company.rafles.AreaCounter.CountArea;
import com.company.rafles.AreaCounter.MonteCarlo;
import com.company.rafles.ConvexCreateMethod.ConvexMerge;
import com.company.rafles.ConvexCreateMethod.Jarvis;
import com.company.rafles.shapes.ConvexHull;
import com.company.rafles.shapes.Point;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void generate(ArrayList<Point> points, int n, double max_x, double max_y) {
        Random random = new Random();
        for (int i=0;i<n;i++)
            points.add(new Point(random.nextDouble()*max_x,random.nextDouble()*max_y));
    }

    public static void main(String[] args) {
        ArrayList<Point> punkty= new ArrayList<>();
        double max_x = 100;
        double max_y = 100;
        int n=1000;

        generate(punkty,n,max_x,max_y);

        /*punkty.add(new Point(2,4));
        punkty.add(new Point(4,4));
        punkty.add(new Point(4,6));
        punkty.add(new Point(6,4));
        punkty.add(new Point(4,2));
        punkty.add(new Point(2,2));*/




        Jarvis jarvis = new Jarvis();
        ConvexHull convexHull = jarvis.convexHull(punkty);

        CountArea mc = new MonteCarlo();
        mc.estimate(convexHull,max_x,max_y);


    }
}
