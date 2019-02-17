package com.t3h.gui;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public static final int W = 400;
    public static final int H = 600;

    public MyFrame() {
        setSize(W, H);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Buổi 9");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(new MyPanel());
        dispose();
    }
}
