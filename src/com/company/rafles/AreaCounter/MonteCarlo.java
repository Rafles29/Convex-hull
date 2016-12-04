package com.company.rafles.AreaCounter;

import com.company.rafles.SimplePointInShapeChecker.GeoPointInside;
import com.company.rafles.SimplePointInShapeChecker.PointInsideCheck;
import com.company.rafles.shapes.ConvexHull;
import com.company.rafles.shapes.Point;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by rwozn on 24.11.2016.
 */
public class MonteCarlo implements CountArea {
    private ArrayList<Point> radnomPoints;


    public MonteCarlo() {
        this.radnomPoints = new ArrayList<>();

    }
    private void generateRandomPoints(int n, double max_x, double max_y) {
        Random random = new Random();
        for(int i=0; i<n ; i++) {
            double x = random.nextDouble() * max_x;
            double y = random.nextDouble() * max_y;
            Point point = new Point(x,y);
            this.radnomPoints.add(point);
        }
    }
    private double count(ConvexHull convexHull, double max_x, double max_y) {
        int count = 0;
        PointInsideCheck pc = new GeoPointInside();
        for(int i=0; i<this.radnomPoints.size();i++) {
            if(pc.check(convexHull,this.radnomPoints.get(i),max_x) > 0) count++;
        }
        double diff = (double)count/(double) this.radnomPoints.size();
        double area = diff * max_x * max_y;
        return area;
    }

    @Override
    public double estimate(ConvexHull convexHull, double max_x, double max_y) {
        double area,diff, preArea;
        int n=10;
        generateRandomPoints(n,max_x,max_y);
        do {
            preArea = count(convexHull,max_x,max_y);
            generateRandomPoints(n,max_x,max_y);
            area=count(convexHull,max_x,max_y);
            diff=Math.abs(area-preArea);

        } while(diff > 0.01);
        System.out.println("n = " +this.radnomPoints.size());
        System.out.println("area = " + area);
        return area;
    }
}
