package com.company.rafles.ConvexCreateMethod;

import com.company.rafles.shapes.ConvexHull;
import com.company.rafles.shapes.Point;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rwozn on 24.11.2016.
 */
public class Jarvis {

    private boolean CCW(Point p, Point q, Point r)
    {
        double val = (q.getY() - p.getY()) * (r.getX() - q.getX()) - (q.getX() - p.getX()) * (r.getY() - q.getY());

        if (val >= 0)
            return false;
        return true;
    }
    public ConvexHull convexHull(ArrayList<Point> points)
    {
        int n = points.size();
        /** if less than 3 points return **/
        if (n < 3)
            return new ConvexHull(points);
        int[] next = new int[n];
        Arrays.fill(next, -1);

        /** find the leftmost point **/
        int leftMost = 0;
        for (int i = 1; i < n; i++)
            if (points.get(i).getX() < points.get(leftMost).getX())
                leftMost = i;
        int p = leftMost, q;
        /** iterate till p becomes leftMost **/
        do
        {
            /** wrapping **/
            q = (p + 1) % n;
            for (int i = 0; i < n; i++)
                if (CCW(points.get(p), points.get(i), points.get(q)))
                    q = i;

            next[p] = q;
            p = q;
        } while (p != leftMost);

        /** manage result **/
        ConvexHull convexHull = new ConvexHull(manage(points, next));
        return convexHull;
    }
    private ArrayList<Point> manage(ArrayList<Point> points, int[] next)
    {
        ArrayList<Point> dest = new ArrayList<>();
        System.out.println("\nConvex Hull points : ");
        for (int i = 0; i < next.length; i++)
            if (next[i] != -1)
                dest.add(points.get(i));
        return dest;
    }
}
