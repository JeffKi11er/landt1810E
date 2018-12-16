package com.t3h.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyButton extends JButton implements MouseListener {
    private ImageIcon imNormal;
    private ImageIcon imSelected;

    public MyButton(String normal, String selected) {
        imNormal = new ImageIcon(getClass().getResource("/images/" + normal));
        imSelected = new ImageIcon(getClass().getResource("/images/" + selected));
        addMouseListener(this);
        setBorder(null);
        setIcon(imNormal);
//        setSize(imNormal.getIconWidth(), imNormal.getIconHeight());
    }

//    @Override
//    public void setSize(int width, int height) {
//        super.setSize(imNormal.getIconWidth(), imNormal.getIconHeight());
//    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setIcon(imSelected);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setIcon(imNormal);
    }
}
