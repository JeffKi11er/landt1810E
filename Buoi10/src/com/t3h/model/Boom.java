package com.t3h.model;

import javax.swing.*;
import java.awt.*;

public class Boom {
    private int x;
    private int y;
    private Image[] images = {
            new ImageIcon(getClass().getResource("/images/boom1.gif")).getImage(),
            new ImageIcon(getClass().getResource("/images/no1.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/no2.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/no3.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/no4.png")).getImage(),
    };
    private int time = 300;
    private int index = 0;

    public Boom(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean draw(Graphics2D g2d) {
        time--;
        if (time < 0) {
            return true;
        }
        if (time < 20) {
            index = 4;
        } else if (time < 40) {
            index = 3;
        } else if (time < 60) {
            index = 2;
        } else if (time < 80) {
            index = 1;
        } else {
            index = 0;
        }
        int xD = x - images[index].getWidth(null)/2;
        int yD = y - images[index].getHeight(null)/2;
        g2d.drawImage(images[index], xD, yD, null);
        return false;
    }
}
