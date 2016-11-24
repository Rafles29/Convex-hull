package com.company.rafles.SimplePointInShapeChecker;

import com.company.rafles.shapes.ConvexHull;
import com.company.rafles.shapes.Point;

/**
 * Created by rwozn on 24.11.2016.
 */
public class GeoPointInside implements PointInsideCheck {
    private Point p;
    private Point r;
    private ConvexHull polygon;
    private int n;            //Liczba wierzchalkow wielokata
    private int k;

    public GeoPointInside() {
        this.p = new Point();
        this.r = new Point();
        this.polygon = new ConvexHull();
    }

    public double det(Point x, Point y, Point z) //Wyznacznik macierzy kwadratowej stopnia 3.
    {
        return(x.getX()*y.getY()+y.getX()*z.getY()+z.getX()*x.getY()-z.getX()*y.getY()-x.getX()*z.getY()-y.getX()*x.getY());
    }
    int przynaleznosc(Point x, Point y,Point z) {
        double det = det(x,y,z);
        if (det != 0) {
            return (0);
        }
        else {
            if ((Math.min(x.getX(), y.getX()) <= z.getX()) && (z.getX() <= Math.max(x.getX(), y.getX())) && (Math.min(x.getY(), y.getY()) <= z.getY()) && (z.getY() <= Math.max(x.getY(), y.getY())))
            {
                return 1;
            }
            return 0;
        }
    }

    int przecinanie(Point a,Point b)
    {
        Point tmp = new Point();
        if ((przynaleznosc(p,r,a)==0)&&(przynaleznosc(p,r,b)==0))
        { //pólprosta nie przecina odcinka |AB| w koncach
            if ((Math.signum(det(p,r,a)) != Math.signum(det(p,r,b))) &&
                    (Math.signum(det(a,b,p)) != Math.signum(det(a,b,r)))) return(1); else return(0);
        } else //do pólprostej nalezy przynajmniej jeden koniec odcinka |AB|
        {
            if ((przynaleznosc(p,r,a)==1)&&(przynaleznosc(p,r,b)==1))
            {
                if ((Math.signum(det(p,r,polygon.getPoint((k-1+n)%n))) == Math.signum(det(p,r,polygon.getPoint((k+2)%n)))) &&
                        (Math.signum(det(p,r,polygon.getPoint((k-1+n)%n))) != 0)) return(0); else return(1);
            } else
            if ((przynaleznosc(p,r,polygon.getPoint((k-1+n)%n))==1)||(przynaleznosc(p,r,polygon.getPoint((k+2)%n))==1)) return(0);
            else
            { //polprosta zawiera tylko wierzcholek
                if (przynaleznosc(p,r,b)==1)
                {
                    tmp=a;
                    return(0);
                }
                if (przynaleznosc(p,r,a)==1)
                {
                    if ((Math.signum(det(p,r,tmp)) == Math.signum(det(p,r,b))) &&
                            (Math.signum(det(p,r,tmp)) != 0)) return(0); else return(1);
                }
            }
        }
        return 0;
    }

    public int oblicz() {

        int l=0; //liczba przeciec
        int i;

        for (i=0; i<n; i++) {
            k=i;
            if (przynaleznosc(polygon.getPoint(i), polygon.getPoint((i+1)%n), p) == 1) {
          //      System.out.println("Punkt nalezy do krawedzi wielokata");
                return 2;
            }
            if (przecinanie(polygon.getPoint(i),polygon.getPoint((i+1)%n))==1)
                l++;
        }
       // System.out.println("Rozwiazanie--------------");
       // System.out.println("Liczba przeciec: " + l);
        if ((l % 2) == 0) {
        //    System.out.println("Punkt p NIE nalezy do wielokata\n");
            return 0;
        }
        else {
        //    System.out.println("Punkt p nalezy do wielokata\n");
            return 1;
        }

    }

    @Override
    public int check(ConvexHull convexHull, Point point, double max_x) {

        this.p = point;
        this.polygon = convexHull;
        this.n = polygon.getSize();
        this.k = 0;
        this.r = new Point(max_x+1,p.getY());
        return oblicz();
    }
}
