package com.t3h.model;

import javax.swing.*;
import java.awt.*;

public class MapBoom {
    private int x;
    private int y;
    private int bit;

    private Image[] images = {
            new ImageIcon(getClass().getResource("/images/snow.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/Tree.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/snowman1.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/Stone.png")).getImage(),
            new ImageIcon(getClass().getResource("/images/home.png")).getImage(),
    };

    public MapBoom(int x, int y, int bit) {
        this.x = x;
        this.y = y;
        this.bit = bit;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(images[bit], x, y, null);
    }
}
