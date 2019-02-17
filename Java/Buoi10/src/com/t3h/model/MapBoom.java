package com.t3h.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

    public int getBit() {
        return bit;
    }

    public Rectangle getRect(){
        Rectangle rect = new Rectangle(x, y,
                images[bit].getWidth(null),
                images[bit].getHeight(null));
        return rect;
    }

    public void checkBoom(ArrayList<Boom> arr){
        if (bit == 0 || bit == 3 || bit == 1){
            return;
        }
        for (Boom b: arr) {
            boolean check = b.checkExplosion(getRect());
            if (check){
                bit = 0;
                return;
            }
        }
    }
}
