package com.company.rafles.AreaCounter;

import com.company.rafles.shapes.ConvexHull;

/**
 * Created by rwozn on 24.11.2016.
 */
public interface CountArea {
    public double estimate(ConvexHull convexHull, double max_x, double max_y);
}