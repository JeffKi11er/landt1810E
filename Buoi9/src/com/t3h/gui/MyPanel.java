package com.t3h.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {
    private JLabel lbTitle;
    private JTextField tfInput;
    private JButton btnSubmit;
    private JButton btnCancel;
    public MyPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
        initComps();
    }

    private void initComps() {
        lbTitle = new JLabel();
        lbTitle.setText("Hello");
        lbTitle.setSize(MyFrame.W, 100);
        lbTitle.setLocation(0, 10);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setForeground(Color.RED);
        lbTitle.setFont(new Font(null, Font.BOLD, 20));
        add(lbTitle);
        //======================
        tfInput = new JTextField();
        tfInput.setSize(MyFrame.W - 40, 30);
        // tinh y theo kích thước của component trên + khoảng cach
        int y = lbTitle.getY() + lbTitle.getHeight() + 10;
        tfInput.setLocation(10, y);
        add(tfInput);
        //==================
        btnSubmit = new JButton();
        btnSubmit.setText("Ok");
        btnSubmit.setSize(100, 30);
        y = tfInput.getY() + tfInput.getHeight() + 20;
        int x = tfInput.getX() + tfInput.getWidth() - btnSubmit.getWidth();
        btnSubmit.setLocation(x, y);
        btnSubmit.setBackground(Color.RED);
        btnSubmit.setForeground(Color.WHITE);
        add(btnSubmit);
        btnSubmit.addActionListener(this);
        //===============
        btnCancel = new JButton();
        btnCancel.setText("Cancel");
        btnCancel.setSize(btnSubmit.getWidth(), btnSubmit.getHeight());
        x = x - btnCancel.getWidth() - 10;
        btnCancel.setLocation(x, y);
        btnCancel.setBackground(Color.BLACK);
        btnCancel.setForeground(Color.WHITE);
        add(btnCancel);
        btnCancel.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnSubmit)){
            lbTitle.setText(tfInput.getText());
            tfInput.setText("");
        }else if (e.getSource().equals(btnCancel)){
            System.exit(0);
        }
    }
}
