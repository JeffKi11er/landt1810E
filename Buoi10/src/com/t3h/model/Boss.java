package com.t3h.model;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Boss extends Entity{
    private Random rd = new Random();
    private Image[] arrImg = {
            new ImageIcon(getClass().
                    getResource("/images/blink_left.png")).getImage(),
            new ImageIcon(getClass().
                    getResource("/images/blink_right.png")).getImage(),
            new ImageIcon(getClass().
                    getResource("/images/blink_up.png")).getImage(),
            new ImageIcon(getClass().
                    getResource("/images/blink_down.png")).getImage(),
    };

    public Boss(int x, int y) {
        super(x, y);
        orient = DOWN;
    }

    @Override
    public void draw(Graphics2D g2d) {
        img = arrImg[orient];
        super.draw(g2d);
    }

    @Override
    public void move() {
        generateOrient();
        super.move();
    }

    private void generateOrient(){
        int percent = rd.nextInt(101);
        if (percent > 95) {
            orient = rd.nextInt(4);
        }
    }
}
