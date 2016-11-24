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
    private int n;
    private ArrayList<Point> radnomPoints;


    public MonteCarlo() {
        this.n = 100;
        this.radnomPoints = new ArrayList<>();

    }
    private void generateRandomPoints(int n, double max_x, double max_y) {
        this.radnomPoints.clear();
        for(int i=0; i<n ; i++) {
            Random random = new Random();
            double x = random.nextDouble() * max_x;
            double y = random.nextDouble() * max_y;
            Point point = new Point(x,y);
            this.radnomPoints.add(point);
        }
    }
    private double count(ConvexHull convexHull, double max_x, double max_y) {
        generateRandomPoints(this.n,max_x,max_y);
        int count = 0;
        PointInsideCheck pc = new GeoPointInside();
        for(int i=0; i<this.n;i++) {
            if(pc.check(convexHull,this.radnomPoints.get(i),max_x) > 0) count++;
        }
        double diff = count/(double) n;
        double area = diff * max_x * max_y;
        return area;
    }

    @Override
    public double estimate(ConvexHull convexHull, double max_x, double max_y) {
        double area;
        do {
            this.n += 100;
            area=count(convexHull,max_x,max_y);

        } while(this.n < 1000);
        System.out.println(this.n);
        System.out.println(area);
        return area;
    }
}
