package com.company.rafles.view;

import com.company.rafles.AreaCounter.CountArea;
import com.company.rafles.AreaCounter.MonteCarlo;
import com.company.rafles.ConvexCreateMethod.Jarvis;
import com.company.rafles.shapes.ConvexHull;
import com.company.rafles.shapes.Point;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by rwozn on 24.11.2016.
 */



public class DrawingShapes extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    public static void generate(ArrayList<Point> points, int n, double max_x, double max_y) {
        Random random = new Random();
        for (int i=0;i<n;i++)
            points.add(new Point(random.nextDouble()*(max_x-10)+5,random.nextDouble()*(max_y-10)+5));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Graphics in JavaFX");
        Group root = new Group();
        Canvas canvas = new Canvas(1000, 1000);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        draw2DShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    private void draw2DShapes(GraphicsContext gc) {
        double y =gc.getCanvas().getHeight();
        ArrayList<Point> punkty= new ArrayList<>();
        double max_x = 1000;
        double max_y = 1000;
        int n=20;

        generate(punkty,n,max_x,max_y);

        for(Point punkt:punkty) {

            gc.strokeOval(punkt.getX(),punkt.getY(),1,1);
        }


        Jarvis jarvis = new Jarvis();
        ConvexHull convexHull = jarvis.convexHull(punkty);
        System.out.println(convexHull);

        CountArea mc = new MonteCarlo();
        mc.estimate(convexHull,max_x,max_y);


        for(int i=1;i<convexHull.getSize();i++) {
             gc.strokeLine(convexHull.getPoint(i-1).getX(),convexHull.getPoint(i-1).getY(),convexHull.getPoint(i).getX(),convexHull.getPoint(i).getY());
            System.out.println(i);
        }
        gc.strokeLine(convexHull.getPoint(0).getX(),convexHull.getPoint(0).getY(),convexHull.getPoint(convexHull.getSize()-1).getX(),convexHull.getPoint(convexHull.getSize()-1).getY());

    }
}