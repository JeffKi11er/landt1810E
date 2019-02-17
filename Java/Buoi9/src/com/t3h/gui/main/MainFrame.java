package com.t3h.gui.main;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static final int W = 400;
    public static final int H = 600;
    public MainFrame(String userName, String password) {
        setTitle("Main");
        setSize(W, H);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        MainPanel panel = new MainPanel(userName, password);
        add(panel);
    }
}
