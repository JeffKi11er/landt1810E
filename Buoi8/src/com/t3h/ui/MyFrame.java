package com.t3h.ui;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends JFrame implements WindowListener {
    public static final int W = 1000;
    public static final int H = 800;

    public MyFrame() {
        setTitle("Buoi 8");
        setSize(W, H);
//        setLocation(200, 200);
        // set hiển thị giữa màn hình
        setLocationRelativeTo(null);
        setResizable(false);
        // set đóng chương trình
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        // cho panel hiển thị trên frame
        MyPanel panel = new MyPanel();
        add(panel);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int result = JOptionPane.showConfirmDialog(
                null,
                "Bạn có muốn thoát không?",
                "Thoát ứng dụng",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (result == JOptionPane.YES_OPTION){
            System.exit(0);
        }

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
