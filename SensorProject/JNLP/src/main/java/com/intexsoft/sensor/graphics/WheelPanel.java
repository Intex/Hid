package com.intexsoft.sensor.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * User: sergey.berdashkevich
 * Date: 31.07.13
 */
public class WheelPanel extends JPanel {

    int angle;

    private final int X = 28;
    private final int Y = 15;
    private final int WIDTH = 200;
    private final int HEIGHT = 200;
    private final int R = 50;
    private double xAxe = 0;
    private double yAxe = 0;



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(5));

        xAxe = Math.cos((((double) angle - 218))*(Math.PI/180)) * R;
        yAxe = Math.sin((((double) angle - 218))*(Math.PI/180)) * R;

        g2d.drawLine((int) (Math.round(xAxe + X + (WIDTH / 2))), (int) (Math.round(yAxe + Y + (HEIGHT / 2))),
                (int) (Math.round(xAxe + X + (WIDTH / 2))), (int) (Math.round(yAxe + Y + (HEIGHT / 2))));

        Ellipse2D ellipse = new Ellipse2D.Double(X, Y, WIDTH, HEIGHT);
        g2d.draw(ellipse);
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}
