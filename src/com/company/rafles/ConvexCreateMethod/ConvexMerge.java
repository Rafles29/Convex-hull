package com.company.rafles.ConvexCreateMethod;

import com.company.rafles.shapes.ConvexHull;
import com.company.rafles.shapes.Point;

import java.util.ArrayList;

/**
 * Created by rwozn on 24.11.2016.
 */
public class ConvexMerge {
    public static void merge(ConvexHull ch1, ConvexHull ch2) {

    }
    public static void mergePart(ConvexHull ch1, ArrayList<Point> dest,int p, int k) {
        dest.clear();
        for(int i=p;i<=k;i++) {
            dest.add(ch1.getPoint(i));
        }
    }
}
