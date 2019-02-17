package com.t3h.gui.login;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    public static final int W = 400;
    public static final int H = 600;
    public LoginFrame() {
        setTitle("Login");
        setSize(W, H);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        LoginPanel panel = new LoginPanel();
        add(panel);
    }
}
