package com.company.rafles.SimplePointInShapeChecker;

import com.company.rafles.shapes.ConvexHull;
import com.company.rafles.shapes.Point;

/**
 * Created by rwozn on 24.11.2016.
 */
public interface PointInsideCheck {
    public int check(ConvexHull convexHull, Point point, double max_x);
}
