/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willy.gui.animation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 *
 * @author Willy
 */
public class Animation extends JComponent implements ActionListener {

    private static final long TOTAL_TIME = 1000;
    public static final int DIVITIONS = 100;

    private Timer timer;
    private List<Point> pointList;
    private Iterator<Point> pointIteration;
    private Color color;
    private volatile boolean hasStarted = false;
    private boolean blocked = false;
    private Thread toDoWhenFinished;
    private Point currentPoint;

    public Animation() {
        super();
        this.timer = null;
        this.pointList = null;
        this.color = null;
        this.blocked = true;
        this.toDoWhenFinished = null;
    }

    public Animation(final List<Point> pointList, final Color color) {
        super();
        this.pointList = pointList;
        this.pointIteration = pointList.iterator();
        this.color = color;
        this.timer = new Timer((int) (TOTAL_TIME / pointList.size()), this);
        this.toDoWhenFinished = null;
    }

    public Animation(final List<Point> pointList, final Color color, final Thread toDoWhenFinished) {
        super();
        this.pointList = pointList;
        this.pointIteration = pointList.iterator();
        this.color = color;
        this.timer = new Timer((int) (TOTAL_TIME / pointList.size()), this);
        this.toDoWhenFinished = toDoWhenFinished;
    }

    public static Animation createAnimation(final Point p1, final Point p2, final int num, final Color color) {
        final double dy = ((double) (p2.y - p1.y)) / ((double) num + 1);
        final double dx = ((double) (p2.x - p1.x)) / ((double) num + 1);
        final double m = Double.isNaN(dy / dx) ? 0 : dy / dx;
        final char longestAxis = (m == 1 ? 'X' : (Math.abs(m) > 1 ? 'Y' : 'X'));

        final List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < num + 1; i++) {
            final int coordsX, coordsY;
            if (longestAxis == 'X') {
                coordsX = (int) Math.round(p1.x + (dx * i));
                coordsY = (int) Math.round(((coordsX - p1.x) * m) + p1.y);
            } else {
                coordsY = (int) Math.round(p1.y + (dy * i));
                coordsX = (int) Math.round(((coordsY - p1.y) / m) + p1.x);
            }
            pointList.add(new Point(coordsX, coordsY));
        }
        pointList.add(p2);
        return new Animation(pointList, color);
    }

    public static Animation createAnimation(final Point p1, final Point p2, final int num, final Color color, final Thread toDoWhenFinished) {
        final Animation panim = createAnimation(p1, p2, num, color);
        return new Animation(panim.getPointList(), color, toDoWhenFinished);
    }

    private void updatePoint() {
        if (pointIteration.hasNext()) {
            this.currentPoint = this.pointIteration.next();
        } else {
            hasStarted = false;
            this.stop();
        }
    }

    @Override
    public void paint(Graphics g) {
        if (hasStarted && !blocked) {
            g.setColor(this.color);
            g.fillOval(this.currentPoint.x - 10, this.currentPoint.y - 10, 20, 20);
        } else {
            g.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.hasStarted = true;
        this.updatePoint();
        repaint();
    }

    public void start() {
        if (!hasStarted && !blocked) {
            this.updatePoint();
            timer.start();
            this.hasStarted = true;
        }
    }

    private void stop() {
        pointIteration = pointList.iterator();
        timer.stop();
        this.hasStarted = false;
        if (toDoWhenFinished != null) {
            new Thread(toDoWhenFinished).start();
        }
    }

    public List<Point> getPointList() {
        return pointList;
    }
    
    public Color getColor(){
        return this.color;
    }
    
    private Thread getFinalThread(){
        return toDoWhenFinished;
    }
    
    public boolean hasStarted(){
        return this.hasStarted;
    }

    public void dump(final Animation anim) {
        if (!hasStarted) {
            this.pointList = anim.getPointList();
            this.pointIteration = this.pointList.iterator();
            this.color = anim.getColor();
            this.timer = new Timer((int) (TOTAL_TIME / this.pointList.size()), this);
            this.toDoWhenFinished = anim.getFinalThread();
            this.blocked = anim.blocked;
        }
    }

}
