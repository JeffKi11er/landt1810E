package com.t3h.ui;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public MyPanel() {
        setLayout(null);
        setBackground(Color.BLACK );
        initComp();
    }

    private void initComp() {
        PanelGame game = new PanelGame();
        add(game);
        PanelMenu menu = new PanelMenu();
        add(menu);
    }
}
