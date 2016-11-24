package com.company.rafles.ConvexCreateMethod;

import com.company.rafles.shapes.ConvexHull;
import com.company.rafles.shapes.Point;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rwozn on 24.11.2016.
 */
public class Jarvis {
    private static final Double ZERO = new Double(0);

    public ConvexHull convexHull(final ArrayList<Point> src)
    {
        if (src == null)
            return new ConvexHull();

        if (src.size() < 3)
            return new ConvexHull();

        final ArrayList<Point> points = new ArrayList<Point>(src);
        final ArrayList<Point> hull = new ArrayList<Point>();
        Point pointOnHull = points.get(extreme(points));
        Point endpoint = null;
        do
        {
            hull.add(pointOnHull);
            endpoint = points.get(0);

            for (final Point r : points)
            {
                // Distance is used to find the outermost point -
                final int turn = findTurn(pointOnHull, endpoint, r);
                if (endpoint.equals(pointOnHull) || turn == -1 || turn == 0
                        && dist(pointOnHull, r) > dist(endpoint, pointOnHull))
                {
                    endpoint = r;
                }
            }
            pointOnHull = endpoint;
        } while (!endpoint.equals(hull.get(0))); // we are back at the start

        ConvexHull convexHull = new ConvexHull(hull);
        return convexHull;
    }

    private int extreme(ArrayList<Point> points) {
        /** find the leftmost point **/
        int leftMost = 0;
        for (int i = 1; i < points.size(); i++)
            if (points.get(i).getX() < points.get(leftMost).getX())
                leftMost = i;
        return leftMost;
    }

    private static int findTurn(final Point p, final Point q, final Point r)
    {
        final double x1 = (q.getX() - p.getX()) * (r.getY() - p.getY());
        final double x2 = (r.getX() - p.getX()) * (q.getY() - p.getY());
        final double anotherInteger = x1 - x2;
        return ZERO.compareTo(anotherInteger);
    }
    private static double dist(final Point p, final Point q)
    {
        final double dx = (q.getX() - p.getX());
        final double dy = (q.getY() - p.getY());
        return dx * dx + dy * dy;
    }

}
