package com.t3h.gui;

import com.t3h.manager.GameManager;
import com.t3h.manager.SoundManager;
import com.t3h.model.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class BoomPanel extends JPanel implements Runnable, KeyListener, MouseMotionListener {
    private GameManager manager = new GameManager();
    private boolean[] flag = new boolean[256];

    public BoomPanel() {
        setBackground(Color.white);
        manager.initGame();
        Thread t = new Thread(this);
        // bắt đâu thực hiện. chỉ đc gọi 1 lần/1 thread
        t.start();
        // đăng ký sự kiện bàn phím
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
//        g2d.setColor(Color.RED);
//        g2d.setStroke(new BasicStroke(20));
//        g2d.drawLine(0, 0, 200, 200);
//
//        g2d.drawOval(200, 200, 100, 50);
//        g2d.drawRect(300, 300, 100, 100);
//        g2d.setFont(new Font(null, Font.ITALIC, 20));
//        g2d.drawString("Hello world", 400, 200);
        manager.draw(g2d);
    }

    @Override
    public void run() {
        while (true) {
            boolean isDie = manager.AI();
            if (isDie) {
                SoundManager.play("luigi_haha.wav");
                int result = JOptionPane.showConfirmDialog(
                        null,
                        "Do you want to replay?",
                        "Game over",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (result == JOptionPane.YES_OPTION) {
                    manager.initGame();
                    flag = new boolean[256];
                } else {
                    System.exit(0);
                }
            }
            if (flag[KeyEvent.VK_LEFT]) {
                manager.movePlayer(Entity.LEFT);
            } else if (flag[KeyEvent.VK_RIGHT]) {
                manager.movePlayer(Entity.RIGHT);
            } else if (flag[KeyEvent.VK_UP]) {
                manager.movePlayer(Entity.UP);
            } else if (flag[KeyEvent.VK_DOWN]) {
                manager.movePlayer(Entity.DOWN);
            }
            if (flag[KeyEvent.VK_SPACE]) {
                manager.playerFire();
            }
            // cập nhập lại giao diện
            repaint();
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        flag[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        flag[e.getKeyCode()] = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
